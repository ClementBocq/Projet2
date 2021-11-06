package com.hemebiotech.analytics;


import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * This class count the number of occurences of symptoms in a List
 * and store the result into a file called "result.out".
 *
 */

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private IDataWriter writer;
	
	
	/**
	 * This the constructor.
	 * 
	 * @param reader Contains the filepath and list of symtpoms.
	 * @param writer IDataWriter object used to create ouput file.
	 */
	private AnalyticsCounter(ISymptomReader reader, IDataWriter writer) {
	
		
		this.reader = reader;
		this.writer = writer;
		
		
	}
	
	
	
	/**
	 * put data which contain a list
	 * of symptoms ordered by alphabetical order.
	 * @param symptoms type of List<String>.
	 */
	private TreeMap<String, Integer> comptage(List<String> symptoms) {
		
		TreeMap<String, Integer> output = new TreeMap<String, Integer>();
		for(String symptom : symptoms) {
			output.put(symptom, Collections.frequency(symptoms, symptom));
		}
		
		return output;
		
		
		
	}
	
	/**
	 * Call WriteData object to create a file with processed data.
	 * @param map TreeMap passed in parameter of attribute writer.
	 */
	private void writeInFile(TreeMap<String,Integer> map) {
		
		
		this.writer.writeFile(map);
	}
	
	/**
	 * display output content in the console for log.
	 * @param map TreeMap to display in the console.
	 */
	private void afficheOutput(TreeMap<String, Integer> map) {
		System.out.println(map.toString());
	}
	
	
	
	
	/**
	 * main method.
	 * @param args not used but needed for the main method.
	 */
	public static void main(String args[]) {
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		WriteData writer = new WriteData();
		AnalyticsCounter compteur = new AnalyticsCounter(reader, writer);
		compteur.process(compteur);
		
		
	
	}

	/**
	 * Wrapper method of others methods in the class.
	 * @param compteur type of AnalyticsCounter.
	 */
	public void process(AnalyticsCounter compteur) {
		
		List<String> symptom = this.reader.getSymptoms();
		
		TreeMap<String, Integer> map = compteur.comptage(symptom);
		compteur.writeInFile(map);
		compteur.afficheOutput(map);
	}
}
