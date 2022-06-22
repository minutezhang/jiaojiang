package jiaojiang.leetcode.practice5.onlinejudge;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {
    /**
     * In LeetCode Store, there are n items to sell. Each item has a price. However, there are some special offers,
     * and a special offer consists of one or more different kinds of items with a sale price.
     *
     * You are given an integer array price where price[i] is the price of the ith item, and an integer array needs
     * where needs[i] is the number of pieces of the ith item you want to buy.
     * <p>
     * You are also given an array special where special[i] is of size n + 1 where special[i][j] is the
     * number of pieces of the jth item in the ith offer and special[i][n] (i.e., the last integer in
     * the array) is the price of the ith offer.
     * <p>
     * Return the lowest price you have to pay for exactly certain items as given, where you could make
     * optimal use of the special offers. You are not allowed to buy more items than you want, even if
     * that would lower the overall price. You could use any of the special offers as many times as you want.
     * <p>
     * Example 1:
     * <p>
     * Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
     * Output: 14
     * Explanation: There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
     * In special offer 1, you can pay $5 for 3A and 0B
     * In special offer 2, you can pay $10 for 1A and 2B.
     * You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
     * <p>
     * Example 2:
     * <p>
     * Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
     * Output: 11
     * Explanation: The price of A is $2, and $3 for B, $4 for C.
     * You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
     * You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
     * You cannot add more items, though only $9 for 2A ,2B and 1C.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == price.length
     * n == needs.length
     * 1 <= n <= 6
     * 0 <= price[i] <= 10
     * 0 <= needs[i] <= 10
     * 1 <= special.length <= 100
     * special[i].length == n + 1
     * 0 <= special[i][j] <= 50
     */
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minCost = Integer.MAX_VALUE;
        for (List<Integer> s : special) {
            List<Integer> reducedNeeds = new ArrayList<>();
            boolean isEligible = true;
            for (int i = 0; i < needs.size(); ++i) {
                int reducedNeed = needs.get(i) - s.get(i);
                if (reducedNeed < 0) {
                    isEligible = false;
                    break;
                }
                reducedNeeds.add(reducedNeed);
            }
            if (isEligible) {
                minCost = Math.min(minCost, s.get(s.size() - 1) + shoppingOffers(price, special, reducedNeeds));
            }
        }

        int cost = 0;
        for (int i = 0; i < price.size(); ++i) {
            cost += price.get(i) * needs.get(i);
        }
        minCost = Math.min(minCost, cost);
        return minCost;
    }


    public static int shoppingOffers2(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (special.isEmpty()) {
            int cost = 0;
            for (int i = 0; i < price.size(); ++i) {
                cost += price.get(i) * needs.get(i);
            }
            return cost;
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); ++i) {
            List<Integer> list = special.remove(i);
            List<Integer> reducedNeeds = new ArrayList<>(needs);
            int cost = shoppingOffers2(price, special, reducedNeeds);
            boolean isEligible = true;
            int specialCost = 0;
            while (isEligible) {
                specialCost += list.get(list.size() - 1);
                for (int j = 0; j < reducedNeeds.size(); ++j) {
                    int reducedNeed = reducedNeeds.get(j) - list.get(j);
                    if (reducedNeed < 0) {
                        isEligible = false;
                        break;
                    }
                    reducedNeeds.set(j, reducedNeed);
                }
                if (isEligible) {
                    cost = Math.min(cost, specialCost + shoppingOffers2(price, special, reducedNeeds));
                }
            }
            minCost = Math.min(cost, minCost);
            special.add(i, list);
        }

        return minCost;
    }

    public static int shoppingOffers3(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (special.isEmpty()) {
            int cost = 0;
            for (int i = 0; i < price.size(); ++i) {
                cost += price.get(i) * needs.get(i);
            }
            return cost;
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); ++i) {
            List<Integer> list = special.get(i);
            List<Integer> reducedNeeds = new ArrayList<>();
            boolean isEligible = true;
            for (int j = 0; j < needs.size(); ++j) {
                int reducedNeed = needs.get(j) - list.get(j);
                if (reducedNeed < 0) {
                    isEligible = false;
                    break;
                }
                reducedNeeds.add(reducedNeed);
            }
            int cost = 0;
            if (isEligible) {
                cost = list.get(list.size() - 1) + shoppingOffers3(price, special, reducedNeeds);
            }
            special.remove(i);
            if (isEligible) {
                cost = Math.min(cost, Math.min(shoppingOffers3(price, special, needs),
                        list.get(list.size() - 1) + shoppingOffers3(price, special, reducedNeeds)));
            } else {
                cost = shoppingOffers3(price, special, needs);
            }
            minCost = Math.min(cost, minCost);
            special.add(i, list);
        }
        return minCost;
    }
}
