package jiaojiang.leetcode.practice5.onlinejudge;

import utils.Utils;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
    /**
     * Given an integer array nums of size n, return the minimum number of moves required to make all array elements
     * equal.
     * <p>
     * In one move, you can increment n - 1 elements of the array by 1.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: 3
     * Explanation: Only three moves are needed (remember each move increments two elements):
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [1,1,1]
     * Output: 0
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     * The answer is guaranteed to fit in a 32-bit integer.
     */

    public static int minMoves(int[] nums) {
        int min = nums[0];
        long sum = 0;
        for (int i: nums) {
            if (i < min) {
                min = i;
            }
            sum += i;
        }

        return (int)(sum - min * nums.length);
    }

    public static int minMoves2(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int count = 0;
        for(int i : nums) {
            count += i - min;
        }

        return count;
    }

    private static class ListNode {
        ListNode next;
        ListNode prev;
        int value;

        ListNode(int value) {
            this.value = value;
        }

        static void print(ListNode node) {
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }
    }

    public static int minMoves3(int[] nums) {
        Arrays.sort(nums);
        ListNode head = new ListNode(-1);
        ListNode currentNode = head;
        for(int i : nums) {
            ListNode node = new ListNode(i);
            currentNode.next = node;
            node.prev = currentNode;
            currentNode = node;
        }

        ListNode targetNode = currentNode;
        int count = 0;
        while (head.next.value < targetNode.value) {
            int gap = targetNode.value == targetNode.prev.value ? 1 : targetNode.value - targetNode.prev.value;
            ListNode node = head;
            boolean first = true;
            while (node.next != null) {
                node.next.value += gap;
                if (node.next.value >= targetNode.value && first ) {
                    first = false;
                    ListNode newNode = new ListNode(targetNode.value);
                    newNode.next = node.next;
                    newNode.prev = node;
                    node.next = newNode;
                    newNode.next.prev = newNode;
                    node = newNode;
                }
                node = node.next;
            }
            if (!first) {
                targetNode = node.prev;
                node.prev.next = null;
            }
            count += gap;
        }
        return count;
    }


    public static int minMoves4(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        while (nums[0] < nums[nums.length - 1]) {
            int target = nums[nums.length - 1];
            int gap = target == nums[nums.length - 2] ? 1 : target - nums[nums.length - 2];
            int index = -1;
            for (int i = 0; i < nums.length - 1; ++i) {
                nums[i] += gap;
                if (index == -1 && nums[i] >= target) {
                    index = i;
                }
            }
            if (index == -1) {
                Utils.printArrayln(nums);
            }
            count += gap;
            System.arraycopy(nums, index, nums, index + 1, nums.length - 1 - index);
            nums[index] = target;
        }
        return count;
    }
}
