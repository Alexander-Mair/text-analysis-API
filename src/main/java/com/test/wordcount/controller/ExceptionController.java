package com.test.wordcount.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	/*
	 * @ExceptionHandler(IOException.class) public void
	 * springHandleNotFound(HttpServletResponse response) throws IOException {
	 * response.se }
	 */

}
