package com.xhx.common.algorithm.breadthsearch;

// Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

// Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

// Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

// Note:
    // The order of returned grid coordinates does not matter.
    // Both m and n are less than 150.

// Example:

// Given the following 5x5 matrix:

//   Pacific ~   ~   ~   ~   ~ 
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//           *   *   *   *   * Atlantic

// Return:

// [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow=new PacificAtlanticWaterFlow();
        int[][] matrix = new int[5][5];
        matrix[0]=new int[]{1,2 ,2, 3,5};
        matrix[1]=new int[]{3 ,2,   3, 4,4};
        matrix[2]=new int[]{2  , 4 ,5, 3,1};
        matrix[3]=new int[]{6,7 ,1  , 4 ,  5};
        matrix[4]=new int[]{5,1   ,1 ,  2 ,  4};
        List<int[]> res= pacificAtlanticWaterFlow.pacificAtlantic(matrix);
        for(int[] indexs:res){
            System.out.println(indexs[0]+" "+indexs[1]);
        }
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result=new ArrayList<>();
        if(null == matrix) return result;
        int m=matrix.length;
        int n=matrix[0].length;
        if(m == 0|| n==0){
            return result;
        }
        boolean[][] visitedPa=new boolean[m][n];
        boolean[][] visitedAt=new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(matrix,visitedPa,Integer.MIN_VALUE,i,0);
            dfs(matrix,visitedAt,Integer.MIN_VALUE,i,n-1);
        }
        for(int i=0;i<n;i++){
            dfs(matrix,visitedPa,Integer.MIN_VALUE,0,i);
            dfs(matrix,visitedAt,Integer.MIN_VALUE,m-1,i);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visitedPa[i][j] && visitedAt[i][j]){
                    result.add(new int[]{i,j});
                }
            }
        }


        return result;
    }
    
    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int m=matrix.length;
        int n=matrix[0].length;
        if(x<0||x>=m||y<0||y>=m||visited[x][y]||height>matrix[x][y]){
            return;
        }
        visited[x][y]=true;
        dfs(matrix,visited,matrix[x][y],x-1,y);
        dfs(matrix,visited,matrix[x][y],x+1,y);
        dfs(matrix,visited,matrix[x][y],x,y-1);
        dfs(matrix,visited,matrix[x][y],x,y+1);
    }
}
