//package com.am.jlfu.fileuploader.web;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.util.StringUtils;
//import org.springframework.web.HttpRequestHandler;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.HttpRequestHandlerServlet;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
///**
// * Uploads the file from the jquery uploader.
// *
// * @author antoinem
// *
// */
//// @Component("javaLargeFileUploaderServlet")
//@WebServlet(name = "javaLargeFileUploaderServlet", urlPatterns = { "/javaLargeFileUploaderServlet" })
//public class UploadServlet extends HttpRequestHandlerServlet {
//	private static final long serialVersionUID = 5279692748971014399L;
//
//	private HttpRequestHandler target;
//
//	@Override
//	public void init() throws ServletException {
//		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
//		this.target = wac.getBean("uploadServletHttpRequestHandler", HttpRequestHandler.class);
//	}
//
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		LocaleContextHolder.setLocale(request.getLocale());
//		try {
//			this.target.handleRequest(request, response);
//		} catch (HttpRequestMethodNotSupportedException ex) {
//			String[] supportedMethods = ex.getSupportedMethods();
//			if (supportedMethods != null) {
//				response.setHeader("Allow", StringUtils.arrayToDelimitedString(supportedMethods, ", "));
//			}
//			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, ex.getMessage());
//		} finally {
//			LocaleContextHolder.resetLocaleContext();
//		}
//	}
//
//}
