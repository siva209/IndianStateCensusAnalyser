package com.java.bridgelabz;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
	public int loadCSVData(String csvFile) throws CensusAnalyserException, IOException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFile));) {
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<CSVStateCensus>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusIterator = csvToBean.iterator();
			int countOfRecord = 0;
			while (censusIterator.hasNext()) {
				countOfRecord++;
				CSVStateCensus censusData = censusIterator.next();
			}
			return countOfRecord;
		} 
		catch (IOException exception) {
			throw new CensusAnalyserException(exception.getMessage(), CensusAnalyserException.ExceptionType.INCORRECT_FILE);
		}
		catch (RuntimeException exception) {
			throw new CensusAnalyserException(exception.getMessage(), CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
	
	public int loadStateCSV(String csvFile) throws CensusAnalyserException, IOException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFile));) {
			CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaStateCodeCSV>(reader);
			csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaStateCodeCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaStateCodeCSV> censusIterator = csvToBean.iterator();
			int countOfRecord = 0;
			while (censusIterator.hasNext()) {
				countOfRecord++;
				IndiaStateCodeCSV censusData = censusIterator.next();
			}
			return countOfRecord;
		} 
		catch (IOException exception) {
			throw new CensusAnalyserException(exception.getMessage(), CensusAnalyserException.ExceptionType.INCORRECT_FILE);
		}
		catch (RuntimeException exception) {
			throw new CensusAnalyserException(exception.getMessage(), CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
	public static void main(String[] args) {
		CensusAnalyser c=new CensusAnalyser();
		String csvFile="C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\IndianStateCensusCSV\\\\src\\\\main\\\\resources\\\\IndiaStateCensusData.csv";
		String csvFile2="C:\\\\\\\\Users\\\\\\\\admin\\\\\\\\eclipse-workspace\\\\\\\\IndianStateCensusCSV\\\\\\\\src\\\\\\\\main\\\\\\\\resources\\\\\\\\IndiaStateCode.csv";
		try {
			int numberOfRecords=c.loadCSVData(csvFile);
			System.out.println(numberOfRecords);
		int records=c.loadStateCSV(csvFile2);
			System.out.println(records);
		} catch (CensusAnalyserException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}







