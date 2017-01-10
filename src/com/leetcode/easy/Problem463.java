package com.leetcode.easy;

import com.sun.org.apache.xpath.internal.operations.Gt;

/**
 * 463. Island Perimeter
 * <p>
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected
 * to the water around the island). One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 */
public class Problem463 {
    public static int islandPerimeter(int[][] grid) {//143 beat69%
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    perimeter += grid[i][j];
                } else {
                    perimeter += grid[i][j] ^ grid[i - 1][j];
                }
                if (i == grid.length - 1) {
                    perimeter += grid[i][j];
                }
                if (j == 0) {
                    perimeter += grid[i][j];
                } else {
                    perimeter += grid[i][j] ^ grid[i][j - 1];
                }
                if (j == grid[0].length - 1) {
                    perimeter += grid[i][j];
                }
            }
        }
        return perimeter;
    }


//    loop over the matrix and count the number of islands;
//    if the current dot is an island, count if it has any right neighbour or down neighbour;
//    the result is islands * 4 - neighbours * 2

    public int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
//        int[][] grid = {{1}};
        System.out.println(islandPerimeter(grid));
    }
}