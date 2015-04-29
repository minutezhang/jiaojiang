package companies.twitter.mitbbs;

/**
 * @author: zhang
 * @since: Feb 16, 2013 10:59:31 PM
 */
public class GraphUtil {

    protected int[][] adjMatrix;

    public static final int DEFAULT_WEIGHT = 1;

    public GraphUtil(int n) {
        adjMatrix = new int[n][n];
    }

    public void addDirectEdge(int i, int j, int weight) {
        adjMatrix[i][j] = weight;
    }

    public void addEdge(int i, int j, int weight) {
        adjMatrix[i][j] = weight;
        adjMatrix[j][i] = weight;
    }

    public void addEdge(int i, int j) {
        addEdge(i, j, DEFAULT_WEIGHT);
    }


    public static GraphUtil getSampleGraph() {
        GraphUtil graph = new GraphUtil(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
//        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(2, 4);

        return graph;
    }

    public void DFS(int node) {
        if (adjMatrix[node][node] == 0) {
            System.out.println(node);
            adjMatrix[node][node] = 1;
        }

        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[i][i] == 0 && adjMatrix[node][i] != 0) {
                DFS(i);
            }
        }
    }

    public static void testDFS() {
        GraphUtil graph = getSampleGraph();
        graph.DFS(0);
    }

    public static void main(String[] args) {
        testDFS();
    }
}
