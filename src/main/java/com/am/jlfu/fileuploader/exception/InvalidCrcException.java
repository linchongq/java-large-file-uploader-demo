package com.am.jlfu.fileuploader.exception;

public class InvalidCrcException extends Exception {
	private static final long serialVersionUID = -5573488260893644709L;

	public InvalidCrcException(String crc32, String crc) {
		super("The file chunk is invalid. Expected "+crc32+" but received "+crc);
	}




}
