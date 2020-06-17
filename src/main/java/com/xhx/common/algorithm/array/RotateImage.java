package com.xhx.common.algorithm.array;
// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
    // Could you do this in-place?

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int c = 1;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = c++;
            }
        }


        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println("++++++++++=++");
        int[][] res = rotate(matrix);

        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(res[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static int[][] rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][column-1-j];
                matrix[i][column-1-j]=temp;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        return matrix;
    }
}
