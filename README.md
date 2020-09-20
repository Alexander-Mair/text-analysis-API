# text-analysis-API

# API Documentation

# Table of Contents
## Overview	1
## Definition of a word	1
## How to install and run text-analysis-API	1
## Format of JSON Output	8
## Entering a Text Sample	10
## Running Unit Tests	12

## Overview

text-analysis-API is a Spring Boot REST API which can perform statistical analysis of text samples to extract data about word count and word length including the frequencies of occurring word length values. This API uses Spring to implement a 3 tier architecture with a REST layer, service layer and data layer. The data layer contains a pre-loaded text sample which is analysed in the service layer to extract word count and word length data. This information is then sent to the controller in the REST layer which responds to a GET request by sending a customised JSON object containing data about word count, word lengths and their frequencies. The API is versatile and makes no assumptions about how the end user wishes to view or use the information contained in the JSON packets.

Definition of a word
In order to generate a word count for a sample text, the API must know what a word is! For this purpose a word is considered to be a character string separated from other character strings by white-space or a newline character. A word may contain numbers and special characters, however it must terminate with an alpha-numeric character. These conditions exclude punctuation, brackets and braces from any calculated wordlength while allowing formatted numbers such as currency and dates to count as words.  A word may begin with dollar or pound signs in addition to alpha-numeric characters. The ampersand sign on its own is regarded as a word.

How to install and run alex-mair-wordcount-exercise API

Note: this tutorial requires Eclipse. Instructions and resources for installing eclipse may be found at https://www.eclipse.org/downloads/packages/installer

You may wish to use Postman to view the JSON output. Postman can be downloaded at https://www.postman.com


1. Clone the github repo into the desired location (for this tutorial it is C:\Users\customer\eclipse-workspace\project folder)


2. Open Eclipse



3. Once Eclipse is launched, import the project into your workspace with the following steps:
Step 1. click file -> import



Step 2. When the Import window appears, select "Existing Projects Into Workspace" and click Next



Step 3.  In the Import Projects window, enter the folder location of alex-mair-wordcount-exercise. You can search for it visually by clicking the "Browse" button

or you can type the file path directly into the searchbar if you know it. Click Finish.


4. Check your import has succeeded by running alex-mair-wordcount-exercise. You may do this in Eclipse or on the command line.
Eclipse:
right click in the project in the package explorer and click Run As->Spring Boot App

Your Console should look something like this


Command Line:
Use the File Explorer to navigate to text-analysis-API and open the Command Prompt by typing "cmd"->Enter.
Run the command mvnw spring-boot:run
You should see output similar to the following.


5. You can view the JSON output in Google Chrome or Postman at localhost:8080/textinfo
You should see the following  JSON output in:
Chrome

Postman



## Format of JSON Output

The  text-analysis-API outputs word count and length data in the form of a single JSON packet containing 4 key-value pairs. These are:
wordcount – integer which counts the total number of words in the text sample
averageWordLength – double that computes the mean average length of all the words in the text sample
modalWordLength – integer array which computes the modal average word length (word lengths that occur with the highest frequency) in the text sample
wordLengthFrequency – JSON object array which contains all word length values and the respective frequencies with which they occur. Each JSON object contains two keys, wordLength, whose value is the integer length of a word or words, and frequency, which measures how many words have that word length value.


## Entering a Text Sample
In this section, we will see how to input text samples into the API. For this tutorial, I will use Genesis: Chapter 1 from the King James Bible For consistency, all text samples are placed in a file called “sample” which is in the folder  src\main\resources\text.

1. Locate the sample file in the Package Explorer and double-click to display in the main window.

2. Paste in the text.

3. Run the application to see the results.
The API is telling you that this piece of text contains 799 words with a mean length of 3.974, a modal word length of 3 and the word length values were 1, 2, 3, 4, 5, and 6.
Running Unit Tests

A set of basic unit tests have been provided with the API. They test the fileReader method – which reads the text sample and the analyseText method – which extracts the statistical data from the provided text.  There are four tests provided.
emptyFileHasZeroWordCount_ZeroAverageWordLength_EmptyModalWordLengths_
WordLenthFrequency – this tests the analyseText method with an empty file.

AnalyseTextGivesCorrectResultForTestSentence – this tests that the analyseText method extracts the correct word count and word length data for a test sentence. The sentence contains punctuation, an ampersand and a formatted date.

FileReaderMethodThrowsIOExceptionWhenFilePathIsInvalid – tests how the fileReader method handles an invalid filepath.

FileReaderMethodReturnsDataWhenFilePathIsValid – tests that the fileReader returns the text in a valid sample.

You can run the tests in the test explorer by right-clicking WordCountApplicationTests file and clicking Run.

You may write further tests in the WordCountApplicationTests as appropriate.
