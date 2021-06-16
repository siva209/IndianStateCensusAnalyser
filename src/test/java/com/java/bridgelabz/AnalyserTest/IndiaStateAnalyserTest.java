package com.java.bridgelabz.AnalyserTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.java.bridgelabz.CensusAnalyser;
import com.java.bridgelabz.CensusAnalyserException;

public class IndiaStateAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\admin\\eclipse-workspace\\IndianStateCensusCSV\\src\\main\\resources\\IndiaStateCensusData.csv";
	private static final String WRONG_FILE_PATH = "C:\\Users\\main\\eclipse-workspace\\IndianStateCensusCSV\\src\\main\\resources\\IndiaStateCensusData.csv";
	private static final String FILE_PATH_WRONG_EXTENSION = "C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\IndianStateCensusCSV\\\\src\\\\main\\\\resources\\\\IndiaStateCensusData.txt";
	private static final String FILE_PATH_DELIMITER = "C:\\Users\\admin\\eclipse-workspace\\IndianStateCensusCSV\\src\\main\\\resources\\IndiaStateCensusDataDelimiter.csv";
	private static final String FILE_PATH_HEADER = "C:\\Users\\admin\\eclipse-workspace\\IndianStateCensusCSV\\src\\main\\resources\\IndiaStateCensusDataHeader.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() throws IOException, CensusAnalyserException {

		CensusAnalyser censusAnalyser = new CensusAnalyser();
		int numOfRecords = censusAnalyser.loadCSVData(INDIA_CENSUS_CSV_FILE_PATH);
		Assert.assertEquals(29, numOfRecords);

	}

	@Test
	public void givenCSVFile_whenWrongFile_ShouldThrowError() throws IOException {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadCSVData(WRONG_FILE_PATH);
		} catch (CensusAnalyserException exception) {
			System.out.println("No such file found");
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE, exception.type);
		}
	}

	@Test
	public void givenCSVFile_whenFileCorrect_butExtensionIncorrect_shouldThrowError() throws IOException {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadCSVData(FILE_PATH_WRONG_EXTENSION);
		} catch (CensusAnalyserException exception) {
			System.out.println("No such file found");
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE, exception.type);
		}
	}

	@Test
	public void givenCSVFile_whenFileCorrect_butDelimiterIncorrect_shouldThrowError() throws IOException {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadCSVData(FILE_PATH_DELIMITER);
		} catch (CensusAnalyserException exception) {
			System.out.println("Incorrect file delimeter");
			assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, exception.type);
		}
	}

	@Test
	public void givenCSVFile_whenFileCorrect_butHeaderIncorrect_shouldThrowError() throws IOException {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadCSVData(FILE_PATH_HEADER);

		} catch (CensusAnalyserException exception) {
			System.out.println("Incorrect file Header");
			assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, exception.type);
		}
	}

}