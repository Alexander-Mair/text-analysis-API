package com.test.wordcount.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.wordcount.service.TextAnalyserService;
import com.test.wordcount.service.TextInfo;

@RestController
@RequestMapping("/textinfo")
public class Controller {

	@Autowired
	TextAnalyserService tas;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody TextInfo getTextInfoInJSON() throws IOException {

		TextInfo ti = tas.analyseText();

		return ti;

	}

	@ExceptionHandler(value = IOException.class)
	public ResponseEntity<String> exception(IOException e) {
		return new ResponseEntity<String>("The file you have requested does not exist", HttpStatus.NOT_FOUND);
	}

}
