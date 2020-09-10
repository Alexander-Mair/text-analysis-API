package com.test.wordcount.service;

import java.util.List;

public class TextInfo {
	private int wordcount;
	private Double averageWordLength;
	private List<Integer> modalWordLengths;
	private List<WordLengthFrequency> wordlengthFrequency;

	public int getWordcount() {
		return wordcount;
	}

	public void setWordcount(int wordcount) {
		this.wordcount = wordcount;
	}

	public Double getAverageWordLength() {
		return averageWordLength;
	}

	public void setAverageWordLength(Double averageWordLength) {
		this.averageWordLength = averageWordLength;
	}

	public List<Integer> getModalWordLengths() {
		return modalWordLengths;
	}

	public void setModalWordLengths(List<Integer> modalWordLength) {
		this.modalWordLengths = modalWordLength;
	}

	public TextInfo(int wordcount, Double averageWordLength, List<Integer> modalWordLengths,
			List<WordLengthFrequency> wordlengthFrequency) {
		super();
		this.wordcount = wordcount;
		this.averageWordLength = averageWordLength;
		this.modalWordLengths = modalWordLengths;
		this.wordlengthFrequency = wordlengthFrequency;
	}

	public TextInfo() {
		// TODO Auto-generated constructor stub
	}

	public List<WordLengthFrequency> getWordlengthFrequency() {
		return wordlengthFrequency;
	}

	public void setWordlengthFrequency(List<WordLengthFrequency> wordlengthFrequency) {
		this.wordlengthFrequency = wordlengthFrequency;
	}

}
