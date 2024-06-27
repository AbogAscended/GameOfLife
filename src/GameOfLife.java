import java.util.*;
import java.io.*;	
public class GameOfLife {
	private int[][] gameBoard;
	private int rows;
	private int columns;
	private int geners;

	public GameOfLife(File inputFile) {
		Scanner scnr;
		try {
			scnr = new Scanner(inputFile);
		} catch (Exception e) {
			return;
		}
		rows = scnr.nextInt();
		columns = scnr.nextInt();
		scnr.nextLine();
		gameBoard = new int[rows][columns];
		String[] eLine = new String[rows];
		for (int i = 0; i < rows; i++) {
			eLine[i] = scnr.nextLine();
			for (int j = 0; j < columns * 2; j += 2)
				gameBoard[i][j / 2] = ((int) eLine[i].charAt(j)) - 48;
		}
	}

	public void computeNextGeneration(int gens) {
		if (gens == 0)
			return;
		else {
			int[][] nextGeneration = new int[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if (gameBoard[i][j] == 1) {
						int nAlive = 0;
						for (int k = -1; k <= 1; k++) {
							for (int h = -1; h <= 1; h++) {
								if (k == 0 && h == 0)
									continue;
								else {
									int n = k + i;
									int m = h + j;
									if (n >= 0 && n < rows && m >= 0 && m < columns)
										if (gameBoard[n][m] == 1)
											nAlive++;
								}
							}
						}
						if (nAlive > 3)
							nextGeneration[i][j] = 0;
						else if (nAlive < 2)
							nextGeneration[i][j] = 0;
						else
							nextGeneration[i][j] = 1;
					} else {
						int nAlive = 0;
						for (int k = -1; k <= 1; k++)
							for (int h = -1; h <= 1; h++) {
								if (k == 0 && h == 0)
									continue;
								else {
									int n = k + i;
									int m = h + j;
									if (n >= 0 && n < rows && m >= 0 && m < columns)
										if (gameBoard[n][m] == 1)
											nAlive++;
								}
							}
						if (nAlive == 3)
							nextGeneration[i][j] = 1;
						else
							nextGeneration[i][j] = 0;
					}
				}
			}
			System.out.println("\nGeneration " + (geners - gens + 2) + "\n");
			gameBoard = nextGeneration;
			print();
			computeNextGeneration(gens - 1);
		}
	}

	public int getRows() {
		return rows;
	}

	public int getCol() {
		return columns;
	}

	public void setGeners(int genss) {
		geners = genss;
	}

	public void print() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				System.out.print(gameBoard[i][j]);
			System.out.println();
		}
	}
}

