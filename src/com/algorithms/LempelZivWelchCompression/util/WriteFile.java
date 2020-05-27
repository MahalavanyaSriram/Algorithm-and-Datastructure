package com.algorithms.LempelZivWelchCompression.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * write the output to the file
 * 
 * @author mahalavanya_sriram
 *
 */
public class WriteFile {

	private final static Logger LOGGER = Logger.getLogger(ReadFile.class.getName());

	/**
	 * writes a output of data streams to the file 
	 * 
	 * @param encodeOutputList
	 * @param filename
	 */
	public void writeFileStream(List<Integer> encodeOutputList, String filename) {
		try (OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(filename + ".lzw"),
				"UTF-16BE")) {
			for (Integer encodeOutput : encodeOutputList) {
				outputStream.write(encodeOutput);
			}
			LOGGER.log(Level.INFO, "Output writtern to the file successfully");

		} catch (IOException ioexception) {
			LOGGER.log(Level.SEVERE, "Input file " + filename + ".txt" + " was not found.\n", ioexception);
		}

	}

	/**
	 * write a string output to the file
	 * 
	 * @param decodedOutput
	 * @param filename
	 */
	public void writeFile(String decodedOutput, String filename) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename + "_decode.txt"))) {
			bufferedWriter.write(decodedOutput);
			LOGGER.log(Level.INFO, "Output writtern to the file successfully");

		} catch (IOException ioexception) {
			LOGGER.log(Level.SEVERE, "Input file " + filename + ".txt" + " was not found.\n", ioexception);
		}

	}
}
