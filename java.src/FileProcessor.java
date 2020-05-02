import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Anand Kulkarni
 *
 */
public class FileProcessor {

	private BufferedReader fileReader = null;

	public FileProcessor(String fileName) {
		try {
			fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
		} catch (FileNotFoundException exception) {
			System.err.println("File Not Found.");
			System.exit(1);
		}
	}

	/**
	 * This method reads a line from an input file.
	 * 
	 * @return Next line from an input file.
	 */
	public String readLineFromFile() {
		try {
			return fileReader.readLine();
		} catch (IOException exception) {
			System.err.println("Error occured while reading a file.");
			System.exit(1);
		}
		return null;
	}

	public void closeFile() {
		try {
			fileReader.close();
		} catch (IOException e) {
			System.err.println("Error occured while closing a file.");
			System.exit(1);
		}
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "FileProcessor [fileReader=" + fileReader + "]";
	}
}
