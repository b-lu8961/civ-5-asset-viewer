/**
 * Class used to test an individual instance of
 * displaying art from a file.
 */
package misc;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageTester extends Component { 
	BufferedImage img;
	static final long serialVersionUID = 42L; 
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
	public ImageTester() {
		try {
			img = ImageIO.read(new File("CivWonderArt/wonderconceptalahambra.png")); //insert real file path here
		} catch (IOException e) {
			System.out.println("IO Exception caught.");
		}
	}
	
	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100, 100);
		}
		else {
			return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Wonder Art");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(new ImageTester());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
