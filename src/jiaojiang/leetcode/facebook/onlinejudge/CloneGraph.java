package jiaojiang.leetcode.facebook.onlinejudge;

import utils.UndirectedGraphNode;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Sep 1, 2016
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
        if (node == null) {
            return null;
        }
        Set<UndirectedGraphNode> visitedNodes = new HashSet<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        visitedNodes.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode nodeToCopy = queue.remove();
            UndirectedGraphNode newNode = getNewNode(nodeToCopy, map);

            for (UndirectedGraphNode n : nodeToCopy.neighbors) {
                if (!visitedNodes.contains(n)) {
                    queue.add(n);
                    visitedNodes.add(n);
                }
                UndirectedGraphNode nn = getNewNode(n, map);
                newNode.neighbors.add(nn);
            }
        }
        return map.get(node.label);
    }

    private static UndirectedGraphNode getNewNode(UndirectedGraphNode nodeToCopy, Map<Integer, UndirectedGraphNode> map) {
        if (!map.containsKey(nodeToCopy.label)) {
                UndirectedGraphNode newNode = new UndirectedGraphNode(nodeToCopy.label);
                map.put(newNode.label, newNode);
                return newNode;
        }
        return map.get(nodeToCopy.label);
    }
}
