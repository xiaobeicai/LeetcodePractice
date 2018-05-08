import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.StdOut;

/*Description
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
	/*25% BFS
	 * 
	 */
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList();
        int[] inDegree =  new int[numCourses];
        for(int i = 0; i < prerequisites.length;i++)
        		inDegree[prerequisites[i][1]]++;
        
       for(int i = 0; i< numCourses;i++)
    	   	if(inDegree[i] == 0)
    	   		q.offer(i);
       
       while(!q.isEmpty()) {
    	   		int a = q.poll();
    	   		for(int i = 0; i < prerequisites.length;i++) {
    	   			if(a == prerequisites[i][0]) {
    	   				inDegree[prerequisites[i][1]]--;
    	   			if(inDegree[prerequisites[i][1]] == 0)
    	   				q.offer(prerequisites[i][1]);
    	   			}
    	   		}
       }
       
       for(int i = 0;i < numCourses;i++)
    	   		if(inDegree[i] != 0)
    	   			return false;
       return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,0}};
		int num = 2;
		boolean res = false;
		if(canFinish(num,a))
			res = true;
        	StdOut.print("result:" + res);

	}
}
