/*Description
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * return 3
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class TreeNode {
	   int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }}

 /*
  * BT类的题记得多考虑递归
  */
public class MaxDepthBT {
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
