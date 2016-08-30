/**
 * The Sound class takes in a file path and uses BasicPlayer 
 * to play the mp3 associated with the file.
 */
package wonders;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import java.io.*;
import java.util.logging.*;

public class Sound {
	private String path;
	
	public Sound(String path) {
		this.path = path;
		Logger.getLogger(BasicPlayer.class.getName()).setLevel(Level.OFF); //Turns off logging statements from BasicPlayer
	}
	
	public void run() {
		BasicPlayer bp = new BasicPlayer();
		try {
			if (path.equals("N/A")) {} //Certain assets don't have sound associated with them, so no sound plays 
			else {
				bp.open(new File(path));
				bp.play();
			}
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { //Test of the sound class
		Sound test = new Sound("sound path");
		test.run();
	} 
}
