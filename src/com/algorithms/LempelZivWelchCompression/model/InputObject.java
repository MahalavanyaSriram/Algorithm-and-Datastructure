package com.algorithms.LempelZivWelchCompression.model;

/**
 * @author mahalavanya_sriram
 *
 */
public class InputObject {
	 private String filename;
	   /**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the bitLength
	 */
	public short getBitLength() {
		return bitLength;
	}
	/**
	 * @param bitLength the bitLength to set
	 */
	public void setBitLength(short bitLength) {
		this.bitLength = bitLength;
	}
	private short bitLength;
}