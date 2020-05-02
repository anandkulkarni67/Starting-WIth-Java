import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author Anand Kulkarni
 *
 */
public class Driver {

	public static final Integer FILE_NAME = 0;

	/**
	 * This is a main method.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args) {
		Driver driver = new Driver();
		if (driver.validateArguments(args)) {
			FileProcessor fileProcessor = new FileProcessor(args[FILE_NAME]);
			StringOperations stringOperations = new StringOperations(fileProcessor);
			stringOperations.findNamesWithHighestOccurence();
			driver.displayResult(stringOperations.getResultList(), stringOperations.getMaxCount());
			fileProcessor.closeFile();
		}
	}

	/**
	 * This method validates command-line arguments. If arguments are invalid
	 * then it throws an error and exits the application otherwise returns
	 * boolean value true.
	 * 
	 * @param args
	 *            Input arguments which are to be validated.
	 * @return Whether arguments are valid or not.
	 */
	private boolean validateArguments(String[] args) {
		if (args.length != 1) {
			System.err.println("Please enter a valid number of arguments.");
			System.exit(1);
		}
		File file = new File(args[FILE_NAME]);
		if (file.isFile() && file.canRead()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
			} catch (IOException exception) {
				System.err.println("File Stream could not be created." + exception.getStackTrace().toString());
				System.exit(1);
			}
		} else {
			System.err.println("Please provide a valid file.");
			System.exit(1);
		}
		return true;
	}

	/**
	 * This method is responsible for displaying result of the program on
	 * console.
	 * 
	 * @param resultList
	 *            result stored in a list data structure.
	 * @param maxCount
	 *            maximum frequency of occurrence of an element name.
	 */
	private void displayResult(List<String> resultList, Integer maxCount) {
		if (resultList.size() == 0) {
			System.out.println("No element names found.");
		} else if (resultList.size() == 1) {
			System.out.println("The most frequently occurring element is " + generateResultString(resultList)
					+ ". It appears " + maxCount + " times ");
		} else {
			System.out.println("The most frequently occurring elements are " + generateResultString(resultList)
					+ ". They appear " + maxCount + " times ");
		}
	}

	/**
	 * This method generates result string from a list for display purpose.
	 * 
	 * @param resultList
	 *            result stored in a List data structure.
	 * @return generated string from resultList.
	 */
	private String generateResultString(List<String> resultList) {
		if (resultList == null) {
			return "No Elements found...";
		} else if (resultList.size() == 1) {
			return resultList.get(0);
		} else {
			String result = "";
			for (String element : resultList) {
				result += element + ", ";
			}
			return result.substring(0, result.length() - 2);
		}
	}
}
