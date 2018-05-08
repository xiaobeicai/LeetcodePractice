import java.util.Stack;

/*Description:#173
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterater {
	//BST= Binary Search Tree 二叉搜索树，左子树里所有的结点<root<右子树所有的结点,不是普通的二叉树BT
	public class BSTIterator {
		Stack<TreeNode> stack = new Stack<TreeNode>();
	    public BSTIterator(TreeNode root) {
	        pushAll(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {  //T~1 S~h :h is the height of the tree
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {   //T~1 S~h
	        TreeNode node = stack.pop();
	        pushAll(node.right);
	        return node.val;
	    }
	    private void pushAll(TreeNode node) {
	    		while(node != null) {
	    			stack.push(node);
	    			node = node.left;
	    		}
	    }
	}
}
