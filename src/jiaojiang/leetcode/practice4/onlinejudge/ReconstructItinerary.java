package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Mar 27, 2016
 */
public class ReconstructItinerary {
    /*
    Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct
    the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin
    with JFK.

    Note:

        If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order
        when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
        ["JFK", "LGB"].
        All airports are represented by three capital letters (IATA code).
        You may assume all tickets form at least one valid itinerary.

    Example 1:
    tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
    Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

    Example 2:
    tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
    Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
     */
    public static List<String> findItinerary2(String[][] tickets) {
        List<String> ret = new ArrayList<String>();

        Map<String, SortedSet<String>> edges = new HashMap<String, SortedSet<String>>();

        for (String[] edge : tickets) {
            if (!edges.containsKey(edge[0])) {
                edges.put(edge[0], new TreeSet<String>());
            }
            edges.get(edge[0]).add(edge[1]);
        }

        String start = "JFK";
        ret.add(start);
        SortedSet<String> dests = edges.get(start);
        while (dests != null && !dests.isEmpty()) {
            start = dests.first();
            dests.remove(start);
            ret.add(start);
            dests = edges.get(start);
        }

        return ret;
    }

    public static List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> edges = new HashMap<String, List<String>>();

        for (String[] edge : tickets) {
            if (!edges.containsKey(edge[0])) {
                edges.put(edge[0], new ArrayList<String>());
            }
            edges.get(edge[0]).add(edge[1]);
        }

        for (Map.Entry<String, List<String>> entry : edges.entrySet()) {
            Collections.sort(entry.getValue());
        }

        return findItinerary(edges, "JFK");
    }

    private static List<String> findItinerary(Map<String, List<String>> edges, String start) {
        List<String> dests = edges.get(start);
        List<String> itinerary = new ArrayList<String>();
        itinerary.add(start);
        while (dests != null && !dests.isEmpty()) {
            String nextStart = dests.get(0);
            dests.remove(0);
            List<String> next = findItinerary(edges, nextStart);
            if (next.get(next.size() - 1).equals(start)) {
                itinerary.addAll(1, next);
            } else {
                itinerary.addAll(next);
            }
        }

        return itinerary;
    }
}
