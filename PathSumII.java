import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

/*Description#113
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 */

public class PathSumII {
	
	/*基本知识花了很久
	 * list是引用传递，在后续中会不断改变其值，List<Integer> list =  oldlist 复制也是引用传递，通篇只有一个list值
	 * 每次返回上层需要删去下层子叶，用stack数据结构较为合适
	 */
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        Stack<Integer> stack = new Stack<Integer>();
        Sum(list, stack, root, 0,sum);
        
        return list;
    }
	
	private static void Sum(List<List<Integer>> list, Stack<Integer> stack, TreeNode node, int res, int sum) {
		if(node == null) return;
		res += node.val;
		if(res > sum) return;
		stack.push(node.val);
		if(node.left != null)
			Sum(list,stack,node.left,res,sum);
		if(node.right != null)
			Sum(list,stack,node.right,res,sum);
		if(node.left == null && node.right == null && res ==sum)
			list.add(new ArrayList(stack));
		stack.pop();
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(5);
		TreeNode node9 = new TreeNode(1);
		 root.left = node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node5.left = node8;
		 node5.right = node9;
		 List<List<Integer>> list = pathSum(root,22);
		 
        	StdOut.print("result:" + list);

	}
}	
