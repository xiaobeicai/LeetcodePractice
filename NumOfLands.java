import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.StdOut;

/*Description#200
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class NumOfLands {
	private static int count;
	private static boolean[][] isCheck;
	//DFS T~M*N S~M*N
	public static int numIslands(char[][] grid) {
		if(grid.length == 0) return 0;
		count = 0;
		isCheck = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length;i++)
			for(int j = 0;j < grid[i].length;j++) {
				if(!isCheck[i][j] && grid[i][j] == '1') {
					dfs(grid,i,j);
					count++;
			}
    }
		return count;
	}
	private static void dfs(char[][] grid, int col,int row) { //flag =1,2,3,4(从下、上、右、左而来) 0 原点
		isCheck[col][row] = true;
		if(grid[col][row] == '0') return;
		
		if(col != 0 && !isCheck[col-1][row])
			dfs(grid,col-1,row);//up
		
		if(col != grid.length-1 && !isCheck[col+1][row])
			dfs(grid,col+1,row);//down
		
		if(row != 0 && !isCheck[col][row-1])
			dfs(grid,col,row-1);//left
		
		if(row != grid[col].length - 1 && !isCheck[col][row+1])
			dfs(grid,col,row+1);//right
		
		return;
	}
	
	/*BFS
	 * col 3 row5
	 * grid[2][1] 12 12/5 = 2 12%5 = 2
	 * 
	 */
	public static int numIslands2(char[][] grid) {
		if(grid.length == 0) return 0;
		int count = 0;
		int col = grid.length;
		int row = grid[0].length;
		Queue<Integer> neighbor = new LinkedList<>();
		for(int i = 0;i < col;i++)
			for(int j = 0;j < row;j++) {
				if(grid[i][j] == '1') {
					count++;
					grid[i][j] = '0';
					neighbor.add(i * row + j);
					while(!neighbor.isEmpty()) {
						int id = neighbor.remove();
						int nc = id/row;
						int nr = id%row;
						if(nc != 0 && grid[nc-1][nr] != '0') {
							neighbor.add((nc-1)*nr);
							grid[nc-1][nr] = '0';
						}
						if(nc != col-1 && grid[nc+1][nr] != '0') {
							neighbor.add((nc+1)*nr);
							grid[nc+1][nr] = '0';
						}
						if(nr != 0 && grid[nc][nr-1] != '0') {
							neighbor.add(nc*(nr-1));
							grid[nc][nr-1] = '0';
						}
						if(nr != row-1 && grid[nc][nr+1] != '0') {
							neighbor.add(nc*(nr+1));
							grid[nc][nr+1] = '0';
						}
					}
				}
			}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] a = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		int res = numIslands2(a);
        	StdOut.print("result:" + res);

	}
}
