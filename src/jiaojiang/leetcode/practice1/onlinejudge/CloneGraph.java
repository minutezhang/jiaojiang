package jiaojiang.leetcode.practice1.onlinejudge;


import utils.UndirectedGraphNode;

import java.util.*;

/**
 * @author: zhang
 * @since: Oct 23, 2013 10:09:45 PM
 */
public class CloneGraph {
    /*
    Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

    OJ's undirected graph serialization:
    Nodes are labeled uniquely.

    We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
    As an example, consider the serialized graph {0,1,2#1,2#2,2}.

    The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
    Visually, the graph looks like the following:

           1
          / \
         /   \
        0 --- 2
             / \
             \_/
     */
    
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        if (node == null) {
            return null;
        }

        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node, cloneNode);

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.remove();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    cloneNode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, cloneNode);
                    queue.add(neighbor);
                }

                map.get(n).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    public static void test() {
        UndirectedGraphNode node = UndirectedGraphNode.constructGraph();
        node.print();
        
        System.out.println("===========");

        cloneGraph(node).print();
    }

    public static void main(String[] args) {
        test();
    }
}
