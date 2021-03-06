
/*
 * Problem:
 * Initially, there is a grid with some cells which may be alive or dead. 
 * Our task to generate the next generation of cells based on the following rules:
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by under population.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by over population.
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 
 * Solution:
 * Loop through every cell and counts it�s neighbors. 
 * Based on that values, the fore mentioned rules are implemented.
 * 
 * References:
 * https://www.geeksforgeeks.org/program-for-conways-game-of-life/
 */
public class ConwaysGameOfLife {

	// Function to print next generation
	private static void nextGeneration(int grid[][], int M, int N) {
		int[][] future = new int[M][N];

		// Loop through every cell
		for (int l = 1; l < M - 1; l++) {
			for (int m = 1; m < N - 1; m++) {
				// finding no Of Neighbours that are alive
				int aliveNeighbours = 0;
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
						aliveNeighbours += grid[l + i][m + j];

				// Cell needs to be subtracted from its neighbours as it was counted before
				aliveNeighbours -= grid[l][m];

				// Implementing the Rules of Life

				// Cell is lonely and dies
				if ((grid[l][m] == 1) && (aliveNeighbours < 2))
					future[l][m] = 0;

				// Cell dies due to over population
				else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
					future[l][m] = 0;

				// A new cell is born
				else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
					future[l][m] = 1;

				// Remains the same
				else
					future[l][m] = grid[l][m];
			}
		}
		System.out.println("Next Generation");
		printGrid(M, N, future);
	}

	private static void printGrid(int M, int N, int[][] cells) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (cells[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int M = 10, N = 10;

		// Intializing the grid.
		int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		// Displaying the grid
		System.out.println("Original Generation");
		printGrid(M, N, grid);
		System.out.println();

		nextGeneration(grid, M, N);
	}
}
