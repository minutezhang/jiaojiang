package companies.adobe.experience;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: zhang
 * Date: Aug 17, 2010
 * Time: 10:46:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Maze {
    private final boolean[][] cells;

    public Maze(boolean [][] cells) {
        this.cells = cells;
    }

    private boolean isCellEmpty(int x, int y) {
        return cells[x][y];
    }

    //check whether the cell is valid
    public boolean isCellValid() {

        return  cells != null
                && cells.length != 0
                && cells[0].length != 0
                && isCellEmpty(0, 0)
                && isCellEmpty(cells.length - 1, cells[0].length - 1);
    }

    public boolean isSolvable() {
        if (!isCellValid()) {
             throw new IllegalArgumentException("Invalid Cell!");
        }

        Stack<int[]> track = new Stack<int[]>();

        int[] curPos = new int[]{0, 0};
        track.push(curPos);
        cells[0][0] = false;

        while (!track.isEmpty()) {
            if (isNext2Dest(curPos)) {
                return true;
            }

            curPos = search(curPos);
            if (curPos == null) {
                curPos = track.pop();
            } else {
                cells[curPos[0]][curPos[1]] = false;
                track.push(curPos);
            }
        }

        return false;
    }

    //search next cell
    private int[] search(int[] curPos) {
        //up position
        if (curPos[0] > 0 && isCellEmpty(curPos[0] - 1, curPos[1])) {
            return new int[]{curPos[0] - 1, curPos[1]};
        }
        //down position
        if (curPos[0] < cells.length - 1 && isCellEmpty(curPos[0] + 1, curPos[1])) {
            return new int[]{curPos[0] + 1, curPos[1]};
        }
        //left
        if (curPos[1] > 0 && isCellEmpty(curPos[0], curPos[1] - 1)) {
            return new int[]{curPos[0], curPos[1] - 1};
        }
        //right
        if (curPos[1] < cells[0].length - 1 && isCellEmpty(curPos[0], curPos[1] + 1)) {
            return new int[]{curPos[0], curPos[1] + 1};
        }

        //not available
        return null;
    }

    private boolean isNext2Dest(int[] curPos) {
        return curPos[0] == cells.length - 1 && curPos[1] == cells[0].length - 2
                || curPos[0] == cells.length - 2 && curPos[1] == cells[0].length - 1;
    }


    public static void main(String[] argv) {
        boolean[][] cells = {{true, true, true, true, true},
                {true, false, true, false, true},
                {true, false, true, true, true},
                {true, true, false, false, false},
                {true, true, true, false, true}};
        Maze maze = new Maze(cells);
        System.out.println(maze.isSolvable());
    }
}