/**
 * The RefArrays class reads the wonders csv file and creates
 * arrays/arraylists to simplify retrieval of file paths and names.
 */
package wonders;

import java.io.*;
import java.util.ArrayList;

public class RefArrays {
	public static String[][] alphaArray = new String[52][4];
	private ArrayList<String[]> eraList = new ArrayList<String[]>();
	
	public RefArrays() {}
	
	public String[][] getAlphaArray() {
		String alphaPath = "C:/Users/Bryan Lu/Programming/workspace/Civ5AssetViewer/Wonders_Alphabetical.csv";
		File alphaFile = new File(alphaPath);
		try {
			BufferedReader alphaReader = new BufferedReader(new FileReader(alphaFile));
			for (int i = 0; i<52; i++) {
				String line = alphaReader.readLine();
				String[] helper = line.split(",");
				alphaArray[i][0] = helper[0];
				alphaArray[i][1] = helper[1];
				alphaArray[i][2] = helper[2];
				alphaArray[i][3] = helper[3];
			}
			alphaReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alphaArray;
	}
	
	public ArrayList<String[]> getEraArray(String eraName) {
		String[][] ref = getAlphaArray();
		for (int i = 0; i<52; i++) {
			if (ref[i][1].equals(eraName)) {
				eraList.add(ref[i]);
			}
		}
		return eraList;
	}

	/* public static void main(String[] args) { //Era array tester
		RefArrays ref = new RefArrays();
		ArrayList<String[]> a = ref.getEraArray("Ancient");
		for (int i = 0; i<a.size(); i++) {
			System.out.println(a.get(i)[0]);
		}
	} */ 
	
}
