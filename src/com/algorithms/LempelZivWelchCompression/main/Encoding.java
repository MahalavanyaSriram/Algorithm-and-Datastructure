package com.algorithms.LempelZivWelchCompression.main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.algorithms.LempelZivWelchCompression.model.InputObject;
import com.algorithms.LempelZivWelchCompression.util.ReadFile;
import com.algorithms.LempelZivWelchCompression.util.WriteFile;

/**
 * this class implements LZW encode or compress on the read data from the file
 * and output is written to a file
 * 
 * @author mahalavanya_sriram
 *
 */
public class Encoding {

	private final static Logger LOGGER = Logger.getLogger(Encoding.class.getName());

	private ReadFile readfile;
	private WriteFile writefile;

	/**
	 * creating object for reading and writing in a file
	 */
	Encoding() {
		readfile = new ReadFile();
		writefile = new WriteFile();
	}

	/**
	 * this method encodes the given data by forming a dictionary having keys as the
	 * strings and corresponding codes of the string as the value
	 * 
	 * @param input
	 */
	public void encode(InputObject input) {
		LOGGER.log(Level.INFO, "started encoding the data");
		// variable to store the encoded output as list before writing it on to a file
		LinkedList<Integer> encodeOutputList = new LinkedList<Integer>();
		double maxTableSize = Math.pow(2, input.getBitLength());
		int tableSize = 256;

		// creating a hash map with generic type keys as strings and value as integers
		Map<String, Integer> table = new HashMap<String, Integer>();
		for (int i = 0; i <= 255; i++)
			table.put(String.valueOf((char) i), i);

		String currentString = "";

		for (char symbol : readfile.readfile(input.getFilename()).toCharArray()) {
			String resultingString = currentString + symbol;
			if (table.containsKey(resultingString))
				currentString = resultingString;
			else {
				encodeOutputList.add(table.get(currentString));
				if (table.size() < maxTableSize)
					table.put(resultingString, tableSize++);
				currentString = String.valueOf(symbol);
			}

		}
		encodeOutputList.add(table.get(currentString));
		LOGGER.log(Level.FINE, "completed encoding successfully");
		writefile.writeFileStream(encodeOutputList, input.getFilename());

	}
}
