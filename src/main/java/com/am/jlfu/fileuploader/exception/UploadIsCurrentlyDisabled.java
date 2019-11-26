package com.am.jlfu.fileuploader.exception;

import com.am.jlfu.staticstate.JavaLargeFileUploaderService;

/**
 * Exception thrown if the uploads are not enabled at the moment.
 *
 * @see JavaLargeFileUploaderService#enableFileUploader()
 * @see JavaLargeFileUploaderService#disableFileUploader()
 * @author antoinem
 */
public class UploadIsCurrentlyDisabled extends Exception {
	private static final long serialVersionUID = 7474235942408545692L;

	public UploadIsCurrentlyDisabled() {
		super("All uploads are currently suspended.");
	}

}
