package com.am.jlfu.fileuploader.exception;


import com.am.jlfu.fileuploader.web.UploadServletParameter;



public class MissingParameterException extends BadRequestException {
	private static final long serialVersionUID = 6789063127058867722L;

	public MissingParameterException(UploadServletParameter parameter) {
		super("The parameter " + parameter.name() + " is missing for this request.");
	}


}
