import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * This class will produce tiles in multiple formats
 * including .txt, .bin, .xml files.
 * @author Jonathan Rayo
 *
 */
public class TileWriter {
	/**
	 * Write tiles to a text file
	 * @param fname the name of the text file
	 * @param tiles list of the tiles to write
	 * @return true if successfully written; false otherwise.
	 */
	public boolean writeToText(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToText(f,tiles);
	}
	/**
	 * 
	 * @param f the File object
	 * @param tiles to write to 
	 * @return true if successfully written, false otherwise.
	 */
	public boolean writeToText(File f, ArrayList<Tile> tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Tile tile : tiles) {
				pw.println(tile);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * 
	 * @param fname the name of the bin file
	 * @param tiles the list of the tiles to write
	 * @return true if successfully written; false otherwise.
	 */
	public boolean writeToBinary(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToBinary(f,tiles);
	}
	/**
	 * 
	 * @param f the File object
	 * @param tiles to write to 
	 * @return true if successfully written, false otherwise.
	 */
	public boolean writeToBinary(File f, ArrayList<Tile> tiles) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(tiles);
			oos.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * 
	 * @param fname the name of the xml file
	 * @param tiles the list of the tiles to write
	 * @return true if successfully written; false otherwise.
	 */
	public boolean writeToXML(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToXML(f,tiles);
	}
	/**
	 * 
	 * @param f the File object 
	 * @param tiles to write to
	 * @return true if successfully written; false otherwise.
	 */
	public boolean writeToXML( File f, ArrayList<Tile> tiles) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(tiles);
			enc.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * 
	 * @param fname the name of the file the user saves to
	 * @param tiles list of the tiles to write
	 * @return true if successfully written; false otherwise.
	 */
	public boolean write(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return write(f,tiles);
	}
	/**
	 * 
	 * The write function serves as a hub that farms out to other write___ functions
	 * the responsibility of writing the data. It chooses which function to call
	 * based on the file extension.
	 * .txt - writeToText
	 * .bin - writeToBinary
	 * .xml - writeToXML
	 * @param f this is the file object
	 * @param tiles the tiles to write
	 * @return true if successfully, false otherwise (including unrecognized extension)
	 */
	public boolean write(File f, ArrayList<Tile> tiles) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return writeToText(f,tiles);
			} else if (fname.endsWith(".BIN")) {
				return writeToBinary(f,tiles);
			} else if (fname.endsWith(".XML")) {
				return writeToXML(f,tiles);
			} else {
				return false;  // unrecognized file format
			}
		} catch (Exception ex) {
			return false;
		}
	}
}
