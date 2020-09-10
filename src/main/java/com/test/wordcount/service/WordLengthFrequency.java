package com.test.wordcount.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class WordLengthFrequency {
	@JsonSerialize
	int wordlength;

	@JsonSerialize
	int frequency;

	public WordLengthFrequency(int wordlength, int frequency) {
		super();
		this.wordlength = wordlength;
		this.frequency = frequency;
	}

	public int getWordlength() {
		return wordlength;
	}

	public void setWordlength(int wordlength) {
		this.wordlength = wordlength;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
