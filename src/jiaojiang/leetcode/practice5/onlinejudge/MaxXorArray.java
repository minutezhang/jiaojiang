package jiaojiang.leetcode.practice5.onlinejudge;

public class MaxXorArray {

    /**
     * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,10,5,25,2,8]
     * Output: 28
     * Explanation: The maximum result is 5 XOR 25 = 28.
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
     * Output: 127
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 2 * 10^5
     * 0 <= nums[i] <= 2^31 - 1
     */

    public static int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode();
        for (int i : nums) {
            TreeNode.addNumber(root, i);
        }

        int maxXor = 0;
        for (int i : nums) {
            maxXor =  Math.max(maxXor, TreeNode.maxXor(root, i));
        }

        return maxXor;
    }


    public static int findMaximumXOR2(int[] nums) {
        int maxXor = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                maxXor = Math.max(maxXor, nums[i] ^ nums[j]);
            }
        }
        return maxXor;
    }

    static private class TreeNode {
        public TreeNode leftChild = null;
        public TreeNode rightChild = null;
        public int number = 0;

        public static void addNumber(TreeNode root, int number) {
            TreeNode node = root;
            int mask = 0x80000000;
            for (int i = 0; i < 32; ++i) {
                if ((mask & number) == 0) {
                    if (node.leftChild == null) {
                        node.leftChild = new TreeNode();
                    }
                    node = node.leftChild;
                } else {
                    if (node.rightChild == null) {
                        node.rightChild = new TreeNode();
                    }
                    node = node.rightChild;
                }
                mask >>>= 1;
            }
        }

        public static int maxXor(TreeNode root, int number) {
            TreeNode node = root;
            int maxXor = 0;
            int mask = 0x80000000;
            for (int i = 0; i < 32; ++i) {
                if ((mask & number) == 0) {
                    if (node.rightChild != null) {
                        maxXor |= mask;
                        node = node.rightChild;
                    } else {
                        node = node.leftChild;
                    }
                } else {
                    if (node.leftChild != null) {
                        maxXor |= mask;
                        node = node.leftChild;
                    } else {
                        node = node.rightChild;
                    }
                }
                mask >>>= 1;
            }
            return maxXor;
        }
    }
}
