package com.algorithms.LempelZivWelchCompression.main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.algorithms.LempelZivWelchCompression.model.InputObject;
import com.algorithms.LempelZivWelchCompression.util.ReadFile;
import com.algorithms.LempelZivWelchCompression.util.WriteFile;

/**
 * this class implements LZW decode the read data from the file and output is
 * written to a file
 * 
 * @author mahalavanya_sriram
 *
 */
public class Decoding {
	private final static Logger LOGGER = Logger.getLogger(Decoding.class.getName());

	private ReadFile readfile;
	private WriteFile writefile;

	/**
	 * creating object for reading and writing in a file
	 */
	Decoding() {
		readfile = new ReadFile();
		writefile = new WriteFile();
	}

	/**
	 * this method decodes the given data by forming a dictionary having keys as the
	 * integer codes and corresponding strings as the value
	 * 
	 * @param input
	 */
	public void decode(InputObject input) {
		LOGGER.log(Level.INFO, "started decoding the data");
		double maxTableSize = Math.pow(2, input.getBitLength());
		int tableSize = 256;
		// creating a hash map with key as integers and value as strings
		Map<Integer, String> table = new HashMap<Integer, String>();
		for (int i = 0; i <= 255; i++)
			table.put(i, String.valueOf((char) i));

		// copying list of encoded values in a another list local to the class from the
		// file
		List<Integer> encodedValuesList = new LinkedList<Integer>(readfile.readfileStream(input.getFilename()));

		// Conversion of first encoded output to string
		String currentString = String.valueOf((char) (int) encodedValuesList.remove(0));

		// creating a string buffer to store the output. String buffer is mutable.
		StringBuffer decodedOutput = new StringBuffer(currentString);
		for (int code : encodedValuesList) {
			String resultingString;
			if (!table.containsKey(code))
				resultingString = currentString + currentString.charAt(0);
			else
				resultingString = table.get(code);

			decodedOutput.append(resultingString);
			if (table.size() < maxTableSize)
				table.put(tableSize++, currentString + resultingString.charAt(0));
			currentString = resultingString;
		}
		LOGGER.log(Level.FINE, "decode operation succesfully completed" + decodedOutput.toString());
		writefile.writeFile(decodedOutput.toString(), input.getFilename());

	}

}
