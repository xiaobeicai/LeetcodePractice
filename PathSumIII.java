/*Description#437
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {
	private int count = 0;
	private int sum;
	public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        path(root,0);
        return count;
        
    }
	private void path(TreeNode node,int res) {
		if(node == null) return;
		res += node.val;
		if(node.left != null)
			path(node.left,res);
		if(node.right != null)
			path(node.right,res);
		
		if(res == sum)
			count++;
		return;
	}
}
