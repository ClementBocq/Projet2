package com.hemebiotech.analytics;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

/**
 * Allow counting of elements in a collection by take data from
 * input object.
 * @author Z
 *
 */

public class AnalyticsCounter {
	
	private List<String> data;
	private HashSet<String> symptoms;
	private TreeMap<String, Integer> output;
	
	
	/**
	 * Call ReadDataFromFile object and put data in Hash.
	 * 
	 * @param filepath full or partial
	 */
	public AnalyticsCounter(String filepath) {
		
		
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		this.data = reader.getSymptoms();
		this.symptoms = new HashSet<String>(this.data);
		this.output = new TreeMap<String, Integer>();
	}
	
	/**
	 * put data which contain a list
	 * of symptoms ordered by alphabetical order.
	 * 
	 */
	public void comptage() {
		
		for(String symptom : this.symptoms) {
			output.put(symptom, Collections.frequency(data, symptom));
		}
		
		
		
	}
	
	/**
	 * Call WriteData object to create a file with processed data.
	 */
	public void writeInFile() {
		
		IDataWriter outputFile = new WriteData();
		outputFile.writeFile(this.output);
	}
	
	/**
	 * display output content in the console.
	 */
	public void afficheOutput( ) {
		System.out.println(output.toString());
	}
	
	
	
	
	/**
	 * main method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
				
		AnalyticsCounter compteur = new AnalyticsCounter("symptoms.txt");
		compteur.process(compteur);
		
		
	
	}

	/**
	 * Wrapper method of others methods in the class
	 * @param compteur type of AnalyticsCounter
	 */
	public void process(AnalyticsCounter compteur) {
		compteur.comptage();
		compteur.writeInFile();
		compteur.afficheOutput();
	}
}
