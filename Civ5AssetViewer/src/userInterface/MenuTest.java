/**
 * Class used to test displaying art
 * and playing music at the same time. 
 */

package userInterface;
import wonders.*;
import java.util.Scanner;

public class MenuTest { //Must insert real file paths

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		boolean loop = true;
		Scanner in = new Scanner(System.in);
		while (loop) {
			System.out.println("Which wonder would you like to display? \n"
					+ "1) Angkor Wat \n" 
					+ "2) Big Ben \n"
					+ "3) Exit this program");
			int menu = in.nextInt();
			if (menu == 1) {
				String name = "angkor wat art path";
				Art pic = new Art(name, "Angkor Wat");
				Sound clip = new Sound("angkor wat sound path");
				pic.run();
				clip.run();
			}
			else if (menu == 2) {
				String name = "big ben art path";
				Art pic = new Art(name, "Big Ben");
				Sound clip = new Sound("big ben sound path");
				pic.run();
				clip.run();
			}
			else if (menu == 3) {
				loop = false;
				in.close();
			}
		}
	}

}
