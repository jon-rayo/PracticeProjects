import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TileReader {
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
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
	public ArrayList<Tile> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	public ArrayList<Tile> readFromBinary(File f) {
		try {
			ArrayList<Tile> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tilesRead = (ArrayList<Tile>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Tile> readFromXML (String fname) {
		File f = new File(fname);
		return readFromXML(f);
	}
	public ArrayList<Tile> readFromXML (File f) {
		try {
			ArrayList<Tile> tilesRead;
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)));
			tilesRead = (ArrayList<Tile>)dec.readObject();
			dec.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Tile> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
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
			return null;
		}
	}
}
