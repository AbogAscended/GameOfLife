import java.io.File;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		System.out.print("Please enter a valid file name: ");
		String fileName = scnr.nextLine();
		System.out.println("How many generations to compute: ");
		int gens = scnr.nextInt();
		GameOfLife nGame = new GameOfLife(new File(fileName));
		nGame.setGeners(gens-1);
		System.out.println("Generation 1\n");
		nGame.print();
		nGame.computeNextGeneration(gens-1);
	}
}