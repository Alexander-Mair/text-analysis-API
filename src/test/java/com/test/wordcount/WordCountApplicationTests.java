package com.test.wordcount;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.wordcount.data.FileLoader;
import com.test.wordcount.service.TextAnalyser;
import com.test.wordcount.service.TextInfo;
import com.test.wordcount.service.WordLengthFrequency;

@SpringBootTest
class WordCountApplicationTests {
	// setup

	TextAnalyser ta = new TextAnalyser();
	FileLoader fl = new FileLoader();
	String testSentence = "Hello world & good morning. The date is 18/05/2016";

	@Test
	void emptyFileHasZeroWordCount_ZeroAverageWordLength_EmptyModalWordLengths_WordLenthFrequency() {

		TextInfo ti = ta.analyseText("");

		assertTrue(ti.getAverageWordLength() == 0 && ti.getWordcount() == 0 && ti.getModalWordLengths().isEmpty()
				&& ti.getWordlengthFrequency().isEmpty());

	}

	@Test()
	void fileReaderMethodThrowsIOExceptionWhenFilePathIsInvalid() {

		assertThrows(IOException.class, () -> fl.fileReader("abc123"));
	}

	@Test()
	void fileReaderMethodReturnsDataWhenFilePathIsValid() {

		try {
			assertNotNull(fl.fileReader("text/sample"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Test()
	void analyseTextGivesCorrectResultForTestSentence() {
		TextInfo ti = ta.analyseText(testSentence);
		// see second comment
		List<Integer> expectedWordLength = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 7, 10));
		List<Integer> expectedFreqency = new ArrayList<Integer>(List.of(1, 1, 1, 2, 2, 1, 1));

		List<WordLengthFrequency> wlfList = ti.getWordlengthFrequency();

		assertTrue(ti.getWordcount() == 9 && ti.getAverageWordLength() == 4.556);
		assertThat(ti.getModalWordLengths(), hasItems(4, 5));

		// couldn't get hasItems() to work with WordFrequency objects so I had to bodge
		// it
		int i = 0;
		for (WordLengthFrequency wlf : wlfList) {
			assertTrue(expectedWordLength.get(i) == wlf.getWordlength());
			assertTrue(expectedFreqency.get(i) == wlf.getFrequency());
			i++;
		}

	}

}
