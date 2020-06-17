package com.xhx.common.algorithm.array;//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//Example 1:
//
//Input:
//[
 //[ 1, 2, 3 ],
 //[ 4, 5, 6 ],
 //[ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
//Example 2:
//
//Input:
//[
  //[1, 2, 3, 4],
  //[5, 6, 7, 8],
  //[9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int c = 1;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = c++;
            }
        }
        List<Integer> res = spiralOrder(matrix);
        for (Integer integer:res){
            System.out.print(integer+",");
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int m=matrix.length-1,n=matrix[0].length-1;
        int i=0,j=0;
        int maxX=m,maxY=n;
        int minX=0,minY=0;
        int indicator = 0;
        while (i>=minX && i<=maxX && j>=minY && j<=maxY){
            res.add(matrix[i][j]);
            if(indicator == 0&&i==minX && j==maxY){
                minX++;
            }
            if(indicator == 1&&i==maxX && j==maxY){
                maxY--;
            }
            if(indicator == 2&&i==maxX && j==minY){
                maxX--;
            }

            if(indicator == 3&&i==minX && j==minY){
                minY++;
            }
            if(i==minX && j<maxY){
                j++;
                indicator=0;
                continue;
            }
            if(j == maxY && i<maxX){
                i++;
                indicator=1;
                continue;
            }
            if(i==maxX && j>minY){
                j--;
                indicator=2;
                continue;
            }
            if(j==minY && i>minX){
                i--;
                indicator=3;
            }


        }
        return res;
    }
}
