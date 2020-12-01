import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will read tiles from either a .txt, .xml, .bin file
 * then display them on the frame when the user loads them in.
 * @author Jonathan Rayo
 *
 */
public class TileReader {
	/*
	 * This function reads from .txt file that comes from readFromText 
	 * with its file.
	 */
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	/*
	 * This function does the busy work by reading in a .txt file that the user tries to load in. 
	 * If it fails we will reply that the tiles cannot be written.
	 */
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> tilesRead = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int ts, tc;
			Tile tile;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				ts = Integer.parseInt(parts[0]);
				tc = Integer.parseInt(parts[1]);
				tile = new Tile(ts,tc);
				tilesRead.add(tile);
			}
			fsc.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;  // null means I wasn't able to build 
						  // the required array list of tiles
		}
	}
	/*
	 * This function reads from .bin file that comes from readFromBinary 
	 * with its file.
	 */
	public ArrayList<Tile> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	/*
	 * This function does the busy work by reading in a .bin file that the user tries to load in. 
	 * If it fails we will reply that the tiles cannot be written.
	 */
	public ArrayList<Tile> readFromBinary(File f) {
		try {
			ArrayList<Tile> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tilesRead = (ArrayList<Tile>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null; // null means I wasn't able to build 
			  // the required array list of tiles
		}
	}
	/*
	 * This function reads from .xml file that comes from readFromBinary 
	 * with its file.
	 */
	public ArrayList<Tile> readFromXML (String fname) {
		File f = new File(fname);
		return readFromXML(f);
	}
	/*
	 * This function does the busy work by reading in a .xml file that the user tries to load in. 
	 * If it fails we will reply that the tiles cannot be written.
	 */
	public ArrayList<Tile> readFromXML (File f) {
		try {
			ArrayList<Tile> tilesRead;
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)));
			tilesRead = (ArrayList<Tile>)dec.readObject();
			dec.close();
			return tilesRead;
		} catch (Exception ex) {
			return null; // null means I wasn't able to build 
			  // the required array list of tiles
		}
	}
	/*
	 * This function will make it easier to read any file that the user tries to load in.
	 * We will get our information from little brother public ArrayList<Tile> read(File f).
	 * This will then be able to read any file the chooses from .txt, .bin, .xml.
	 */
	public ArrayList<Tile> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	/*
	 * This function will do the busy work for the head of the table that is public ArrayList<Tile> read(String fname) 
	 * We will try to read the files ending in .txt, .bin, or .xml and use their respective functions to load them in.
	 * Return a null extension if the file format is unrecognized and won't build tiles if they aren't found.
	 */
	public ArrayList<Tile> read(File f) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return readFromText(f);
			} else if (fname.endsWith(".BIN")) {
				return readFromBinary(f);
			} else if (fname.endsWith(".XML")) {
				return readFromXML(f);
			}
			else {
				return null;  // unrecognized extension
			}
		} catch (Exception ex) {
			return null; // null means I wasn't able to build 
			  // the required array list of tiles
		}
	}
}
