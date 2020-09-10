package com.test.wordcount.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TextAnalyser {

	public TextInfo analyseText(String sentence) {
		List<String> trimmedWords = extractWordsFromSentence(sentence);
		List<Integer> wordlengths = new ArrayList<Integer>();
		HashSet<Integer> wordlengthValues = new HashSet<Integer>();
		List<WordLengthFrequency> wlfList = new ArrayList<WordLengthFrequency>();
		int totalWordLength = 0;
		for (String trimmedWord : trimmedWords) {

			totalWordLength += trimmedWord.length();
			wordlengths.add(trimmedWord.length());

			wordlengthValues.add(trimmedWord.length());

		}
		for (Integer value : wordlengthValues) {
			System.out.println(value);
			wlfList.add(new WordLengthFrequency(value, 0));
			int lastAdded = wlfList.size() - 1;
			for (Integer wordlength : wordlengths) {
				if (wordlength == value) {
					int updatedFrequency = wlfList.get(lastAdded).getFrequency() + 1;
					wlfList.get(lastAdded).setFrequency(updatedFrequency);

				}
			}
		}
		int maxFrequency = 0;
		for (WordLengthFrequency wlf : wlfList) {
			if (wlf.getFrequency() > maxFrequency) {
				maxFrequency = wlf.getFrequency();
			}
		}
		List<Integer> modalWordLengths = new ArrayList<Integer>();
		for (WordLengthFrequency wlf : wlfList) {
			if (wlf.getFrequency() == maxFrequency) {
				modalWordLengths.add(wlf.getWordlength());
			}
		}
		Double averageWordLength = roundAverage(wordlengths, totalWordLength);

		return new TextInfo(trimmedWords.size(), averageWordLength, modalWordLengths, wlfList);
	}

	private List<String> extractWordsFromSentence(String sentence) {
		sentence = sentence.replaceAll("/(?=[a-zA-Z])", " ");

		String[] words = sentence.split(" |\n");
		List<String> trimmedWords = new ArrayList<String>();
		for (String word : words) {
			while (word.matches("^[^a-zA-Z0-9�$].*$|^.*[^a-zA-Z0-9%]$") && !word.matches("^[&+-=]$")) {
				word = word.replaceAll("^[^a-zA-Z0-9�$]|[^a-zA-Z0-9%]$", "");

			}

			if (word.length() > 0) {
				String trimmedWord = word;
				trimmedWords.add(trimmedWord);
			}
		}
		return trimmedWords;
	}

	private static Double roundAverage(List<Integer> wordlengths, int totalWordLength) {
		long averageWordLengthLong = Math.round((double) totalWordLength * 1000 / wordlengths.size());
		Double averageWordLength = ((double) averageWordLengthLong / 1000);
		return averageWordLength;
	}
}
