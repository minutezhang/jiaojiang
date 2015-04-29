package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: mizhang
 * @time: 2/11/15 10:44 PM
 */
public class SudokuSolver {
    /*
    Write a program to solve a Sudoku puzzle by filling the empty cells.

    Empty cells are indicated by the character '.'.

    You may assume that there will be only one unique solution.


    A sudoku puzzle...


    ...and its solution numbers marked in red.
     */
    public static void solveSudoku(char[][] board) {
        Set<Character>[] rowCandicates = new Set[9];
        Set<Character>[] columnCandicates = new Set[9];
        Set<Character>[] blockCandicates = new Set[9];
        List<int[]> indices = new ArrayList<int[]>();

        Set<Character> seed = new HashSet<Character>();
        for (char c = '1'; c <= '9'; c++) {
            seed.add(c);
        }

        for (int i = 0; i < 9; i++) {
            rowCandicates[i] = new HashSet<Character>(seed);
            columnCandicates[i] = new HashSet<Character>(seed);
            blockCandicates[i] = new HashSet<Character>(seed);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    indices.add(new int[]{i, j});
                } else {
                    rowCandicates[i].remove(board[i][j]);
                    columnCandicates[j].remove(board[i][j]);
                    blockCandicates[i / 3 * 3 + j / 3].remove(board[i][j]);
                }
            }
        }

        solveSudoku(board, indices, rowCandicates, columnCandicates, blockCandicates);
    }

    private static boolean solveSudoku(char[][] board, List<int[]> indices, Set[] rowCandidates, Set[] columnCandidates, Set[] blockCandidates) {
        if (indices.size() == 0) {
            return true;
        }

        int[] index = indices.remove(indices.size() - 1);
        List<Character> candidates = getCandidates(rowCandidates[index[0]], columnCandidates[index[1]], blockCandidates[index[0] / 3 * 3 + index[1]/3]);
        for (char c : candidates) {
            board[index[0]][index[1]] = c;
            rowCandidates[index[0]].remove(c);
            columnCandidates[index[1]].remove(c);
            blockCandidates[index[0] /3 * 3 + index[1] / 3].remove(c);
            if (solveSudoku(board, indices, rowCandidates, columnCandidates, blockCandidates)) {
                return true;
            }
            rowCandidates[index[0]].add(c);
            columnCandidates[index[1]].add(c);
            blockCandidates[index[0] /3 * 3 + index[1] / 3].add(c);
        }
        indices.add(index);

        return false;
    }

    private static List<Character> getCandidates(Set<Character> rowCandidate, Set<Character> columnCandidate, Set<Character> blockCandicate) {
        List<Character> candidates = new ArrayList<Character>();

        for (char c : rowCandidate) {
            if (columnCandidate.contains(c) && blockCandicate.contains(c)) {
                candidates.add(c);
            }
        }

        return candidates;
    }
}
