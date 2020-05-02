import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Anand Kulkarni
 *
 */
public class StringOperations {
	private FileProcessor fileProcessor = null;

	private List<String> resultList = new ArrayList<String>();

	private Integer maxCount = 0;

	// Represents xml attribute name.
	private static final String XML_ATTRIBUTE = "name";

	// Represents xml tag name.
	private static final String XML_TAG = "element";

	public StringOperations(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	/**
	 * This method finds the most frequently occurring element names from the
	 * input file.
	 */
	public void findNamesWithHighestOccurence() {
		String line = null;
		Map<String, Integer> nameCountMap = new HashMap<String, Integer>();
		while ((line = fileProcessor.readLineFromFile()) != null) {
			String currentLine = line.trim();
			if (currentLine.startsWith("<xs:" + XML_TAG)) {
				Map<String, String> nameValuePairs = getNameValuePairs(currentLine);
				if (nameValuePairs != null && nameValuePairs.containsKey(XML_ATTRIBUTE)) {
					if (nameCountMap.containsKey(nameValuePairs.get(XML_ATTRIBUTE))) {
						int newCount = nameCountMap.get(nameValuePairs.get(XML_ATTRIBUTE)) + 1;
						nameCountMap.put(nameValuePairs.get(XML_ATTRIBUTE), newCount);
						if (newCount == maxCount) {
							resultList.add(nameValuePairs.get(XML_ATTRIBUTE));
						}
						if (newCount > maxCount) {
							resultList.clear();
							resultList.add(nameValuePairs.get(XML_ATTRIBUTE));
							maxCount = newCount;
						}
					} else {
						int newCount = 1;
						nameCountMap.put(nameValuePairs.get("name"), newCount);
						if (newCount == maxCount) {
							resultList.add(nameValuePairs.get("name"));
						}
						if (newCount > maxCount) {
							resultList.clear();
							resultList.add(nameValuePairs.get("name"));
							maxCount = newCount;
						}
					}
				}
			}
		}
	}

	/**
	 * This method generates attribute name and value pairs from a string.
	 * 
	 * @param currentLine
	 *            a line from a file which contain '<xs:element' string
	 * @return
	 */
	private Map<String, String> getNameValuePairs(String currentLine) {
		Map<String, String> nameValuePairs = new HashMap<String, String>();
		String[] lineFractions = currentLine.trim().split(" ");
		if (lineFractions.length > 1) {
			for (int count = 1; count < lineFractions.length; count++) {
				String[] nameValue = lineFractions[count].split("=");
				nameValuePairs.put(nameValue[0],
						nameValue[1].substring(nameValue[1].indexOf("\"") + 1, nameValue[1].lastIndexOf("\"")));
			}
		}
		return nameValuePairs;
	}

	/**
	 * @return the resultList
	 */
	public List<String> getResultList() {
		return resultList;
	}

	/**
	 * @return the maxCount
	 */
	public Integer getMaxCount() {
		return maxCount;
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "StringOperations [fileProcessor=" + fileProcessor + ", resultList=" + resultList + ", maxCount="
				+ maxCount + "]";
	}
}
