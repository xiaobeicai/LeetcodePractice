import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Description#94
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
 return [1,3,2].
Note: Recursive solution is trivial, could you do it iteratively?
递归的解决方法比较繁琐，你可以通过迭代的方式解决么？
 */
public class BTInorderedTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	/*Inorder:中根次序，不是没有顺序95%
	 * 首先遍历左子树，然后访问根结点，最后遍历右子树
	 * 递归
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
		    List<Integer> list = new ArrayList<>();
		    Traversal(list,root);
		    return list;
  }	     
    public void Traversal(List<Integer> list, TreeNode root) {
	    		//corner case：输入集为空
    			if(root==null)
	    			return;
	    		
    			Traversal(list,root.left);
    			list.add(root.val);
	    		Traversal(list,root.right);
	    		
}	
    /*Iterative Solution
     * 什么叫迭代的解决方法？->不用嵌套函数，通过内部循环解决
     * 用 Stack进行iterative
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
	    List<Integer> list = new ArrayList<>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;
	    while(cur != null || !stack.empty()) {
	    		while(cur != null) {
	    			stack.push(cur);
	    			cur = cur.left;
	    		}
	    		cur = stack.pop();
	    		list.add(cur.val);
	    		cur = cur.right;
	    }
	    
	    return list;
}	 
}
