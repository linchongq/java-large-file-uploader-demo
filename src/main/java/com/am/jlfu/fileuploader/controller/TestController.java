package com.am.jlfu.fileuploader.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.am.jlfu.fileuploader.web.UploadServletAsyncHttpRequestHandler;

@Controller
public class TestController {
	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@Autowired
	private HttpRequestHandler uploadServletHttpRequestHandler;
	@Autowired
	private UploadServletAsyncHttpRequestHandler uploadServletAsyncHttpRequestHandler;

	@RequestMapping(value = "/javaLargeFileUploaderServlet")
	public void javaLargeFileUploaderServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LocaleContextHolder.setLocale(request.getLocale());
		try {
			uploadServletHttpRequestHandler.handleRequest(request, response);
		} catch (HttpRequestMethodNotSupportedException ex) {
			String[] supportedMethods = ex.getSupportedMethods();
			if (supportedMethods != null) {
				response.setHeader("Allow", StringUtils.arrayToDelimitedString(supportedMethods, ", "));
			}
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, ex.getMessage());
		} finally {
			LocaleContextHolder.resetLocaleContext();
		}
	}

	@RequestMapping(value = "/javaLargeFileUploaderAsyncServlet")
	public void javaLargeFileUploaderAsyncServlet(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LocaleContextHolder.setLocale(request.getLocale());
		try {
			uploadServletAsyncHttpRequestHandler.setFile(file);
			uploadServletAsyncHttpRequestHandler.handleRequest(request, response);
		} catch (HttpRequestMethodNotSupportedException ex) {
			String[] supportedMethods = ex.getSupportedMethods();
			if (supportedMethods != null) {
				response.setHeader("Allow", StringUtils.arrayToDelimitedString(supportedMethods, ", "));
			}
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, ex.getMessage());
		} finally {
			LocaleContextHolder.resetLocaleContext();
		}
	}

}
