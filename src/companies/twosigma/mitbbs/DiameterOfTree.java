package companies.twosigma.mitbbs;

/**
 * @author: mizhang
 * @time: 2/12/15 10:06 PM
 */
public class DiameterOfTree {
    public static int diameterOfTree(Node root) {
        return dimeterOfTreeHelper(root)[0];
    }

    private static int[] dimeterOfTreeHelper(Node root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = dimeterOfTreeHelper(root.left);
        int[] right = dimeterOfTreeHelper(root.right);

        left[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + 1);
        left[1] = Math.max(left[1], right[1]) + 1;
        return left;
    }

    public static void main(String[] args) {

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
    */
        System.out.println(diameterOfTree(Node.getSampleTree()));
    }
}
