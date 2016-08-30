/**
 * The Art class takes in a file path and a name 
 * and returns a JFrame with the title "name" that
 * displays the art associated with the file path. 
*/
package wonders;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Art extends Component implements Runnable {
	static final long serialVersionUID = 44L;
	private BufferedImage img;
	private String path;
	private String name;
	
		
	public Art(String path, String name) {
		this.path = path;
		this.name = name;
	}
	
	public Component initArt() {
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			img = null;
		}
		JLabel artLabel = new JLabel(new ImageIcon(img));
		return artLabel;
	}
	
	public void paint(Graphics g) {
		g.drawImage(img,  0, 0, null);
	}
	
	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100, 100);
		}
		else {
			return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}
	
	public void run() {
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(initArt());
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
	}
	
}
