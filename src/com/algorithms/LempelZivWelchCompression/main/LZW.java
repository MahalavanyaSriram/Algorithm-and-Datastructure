package com.algorithms.LempelZivWelchCompression.main;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.algorithms.LempelZivWelchCompression.model.InputObject;

/**
 * LZW implements algorithm that compresses the given input data without any
 * loses. It also decompress the compressed data to obtain its original form
 * 
 * @author mahalavanya_sriram
 *
 */
public class LZW {
	private final static Logger LOGGER = Logger.getLogger(LZW.class.getName());
	private static final Pattern INPUT_PATTERN = Pattern.compile("([a-zA-Z0-9_-]+)+(.txt|.lzw)( )([0-9]+)");

	private Encoding encoder;
	private Decoding decoder;
	private InputObject input;
	private static Scanner scanner;

	/**
	 * constructor that creates a new input, encoding and decoding object
	 * 
	 */
	LZW() {
		this.input = new InputObject();
		this.encoder = new Encoding();
		this.decoder = new Decoding();
	}

	/**
	 * Filters the given input data. Extracts the file name and bit length from the
	 * given data. subsequently sets the value of input objects.
	 */
	public InputObject filterInput(String rawInput) {
		Matcher matcher = INPUT_PATTERN.matcher(rawInput);
		if (matcher.find()) {
			input.setFilename(matcher.group(1));
			input.setBitLength(Short.parseShort(matcher.group(4)));
			return input;
		}
		return null;
	}

	/**
	 * the method that is the starting point of the program takes in command line
	 * argument and calls the necessary encode or decode functions.
	 */
	public static void main(String[] args) throws IOException {
		LZW lzwCompression = new LZW();
		Boolean isInputError = false;
		scanner = new Scanner(System.in);
		do {
			try {
				System.out.print("Enter Details for LZW : \n");
				String rawInput = scanner.nextLine();
				if (rawInput.contains("encode") || rawInput.contains("compress"))
					lzwCompression.encoder.encode(lzwCompression.filterInput(rawInput));
				else if (rawInput.contains("decode") || rawInput.contains("decompress"))
					lzwCompression.decoder.decode(lzwCompression.filterInput(rawInput));
			} catch (Exception exception) {
				System.out.print("Enter Details for LZW Again: \n");
				LOGGER.log(Level.SEVERE, "Input not in correct format or Error Input" + exception);
				isInputError = true;
			}
		} while (isInputError);
	}
}
