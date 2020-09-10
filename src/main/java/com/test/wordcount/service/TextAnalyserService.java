package com.test.wordcount.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.wordcount.data.FileLoader;

@Service
public class TextAnalyserService {

	public TextInfo analyseText() throws IOException {
		TextAnalyser ta = new TextAnalyser();
		FileLoader fl = new FileLoader();
		TextInfo ti = ta.analyseText(fl.fileReader("/text/sample"));
		return ti;
	}

}
