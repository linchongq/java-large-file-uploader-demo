package com.am.jlfu.fileuploader.exception;

import java.util.UUID;


public class FileStillProcessingException extends Exception {
	private static final long serialVersionUID = 4949230911885292367L;

	public FileStillProcessingException(UUID fileId) {
		super("The file "+fileId+" is still in a process. AsyncRequest ignored.");
	}

}
