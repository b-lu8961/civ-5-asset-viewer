/**
 * The Menu class provides the user interface of the program.
 * The menus all take integer inputs.
 */
package userInterface;
import java.util.Scanner;
import wonders.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		boolean run = true;
		RefArrays ref = new RefArrays();
		String[][] alpha = ref.getAlphaArray();
		int menuTop = 0;
		while (run) {
			System.out.println("Welcome to the Civ V Asset Viewer. How would you like to sort the wonders?\n"
					   + "1) Alphabetically\n" 
				   	   + "2) By Era\n"
				       + "3) Exit Program");
			try {
				menuTop = in.nextInt();
			}
			catch (InputMismatchException e) {
				in.nextLine();
			}
			if (menuTop == 1) {
				boolean alphaCheck = true;
				int alphaMenu = -1;
				while (alphaCheck) {
					for (int k = 0; k<alpha.length; k++) {
						System.out.println((k+1) +") " + alpha[k][0]);
					}
					try {
						alphaMenu = in.nextInt()-1;
					}
					catch (InputMismatchException e) {
						in.nextLine();
					}
					if (alphaMenu<0 || alphaMenu>alpha.length-1) {
						System.out.println("Invalid input. Please enter a number between 1 and " + alpha.length + ".");
					}
					else {
						Art pic = new Art(alpha[alphaMenu][2], alpha[alphaMenu][0]);
						Sound clip = new Sound(alpha[alphaMenu][3]);
						clip.run();
						pic.run();
						alphaCheck = false;
					}
				}
			}
			else if (menuTop == 2) {
				String[] eraNames = {"Ancient", "Classical", "Medieval", "Renaissance", "Industrial", "Modern", "Atomic", "Information", "Bonus"};
				boolean eraCheck = true;
				int eraMenu = -1;
				while (eraCheck) {
					for (int k = 0; k<eraNames.length; k++) {
						System.out.println((k+1) + ") " + eraNames[k]);
					}
					try {
						eraMenu = in.nextInt()-1;
					}
					catch (InputMismatchException e) {
						in.nextLine();
					}
					if (eraMenu<0 || eraMenu > eraNames.length-1) {
						System.out.println("Invalid input. Please enter a number between 1 and " + eraNames.length + ".");
					}
					else { 
						eraCheck = false;
					}
				}
				ArrayList<String[]> eraList = new ArrayList<String[]>();
				eraList = ref.getEraArray(eraNames[eraMenu]);
				boolean wonderCheck = true;
				int wonderMenu = -1;
				while (wonderCheck) {
					for (int k = 0; k<eraList.size(); k++) {
						System.out.println((k+1) + ") " + eraList.get(k)[0]);
					}
					try {
						wonderMenu = in.nextInt()-1;
					}
					catch (InputMismatchException e) {
						in.nextLine();
					}
					if (wonderMenu<0 || wonderMenu>eraList.size()-1) {
						System.out.println("Invalid input. Please enter a number between 1 and " + eraList.size() + ".");
					}
					else {
						Art pic = new Art(eraList.get(wonderMenu)[2], eraList.get(wonderMenu)[0]);
						Sound clip = new Sound(eraList.get(wonderMenu)[3]);
						clip.run();
						pic.run();
						wonderCheck = false;
					}
				}
			}
			else if (menuTop == 3) {
				System.out.println("Program terminated.");
				run = false;
			}
			else {
				System.out.println("Invalid input. Please enter a number between 1 and 3.");
			}
		}
		in.close();
		System.exit(0);
	}
}
