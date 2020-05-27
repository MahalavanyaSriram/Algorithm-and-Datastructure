package com.algorithms.LempelZivWelchCompression.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * reads data from a file
 * 
 * @author mahalavanya_sriram
 *
 */
public class ReadFile {

	private final static Logger LOGGER = Logger.getLogger(ReadFile.class.getName());

	/**
	 * reads input string from the given input file
	 * 
	 * @param filename
	 * @return input string
	 */
	public String readfile(String filename) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename + ".txt"))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				LOGGER.log(Level.INFO, "read file successful");
				return line;
			}
		} catch (IOException ioexception) {
			LOGGER.log(Level.SEVERE, "Input file " + filename + ".txt" + " was not found.\n", ioexception);
		}
		return null;
	}

	/**
	 * reads data from a file as a stream
	 * 
	 * @param filename
	 * @return list of encoded integers
	 */
	public List<Integer> readfileStream(String filename) {
		try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename + ".lzw"),
				"UTF-16BE")) {
			LinkedList<Integer> encodedInputList = new LinkedList<Integer>();
			double value = 0;
			while ((value = inputStreamReader.read()) != -1) {
				encodedInputList.add((int) value);
			}
			LOGGER.log(Level.INFO, "read file successful");
			return encodedInputList;
		} catch (IOException ioexception) {
			LOGGER.log(Level.SEVERE, "Input file " + filename + ".lzw" + " was not found.\n", ioexception);
		}
		return null;
	}
}
