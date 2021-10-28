package com.hemebiotech.analytics;


import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * This class count the number of occurences of symptoms in a List
 * and store the result into a TreeMap as a couple key-value.
 *
 */

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private IDataWriter writer;
	
	
	/**
	 * Call ReadDataFromFile object and put data in Hash.
	 * 
	 * @param filepath full or partial
	 */
	private AnalyticsCounter(ISymptomReader reader, IDataWriter writer) {
	
		
		this.reader = reader;
		this.writer = writer;
		
		
	}
	
	
	
	/**
	 * put data which contain a list
	 * of symptoms ordered by alphabetical order.
	 * 
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
	 * @param map 
	 */
	private void writeInFile(TreeMap<String,Integer> map) {
		
		
		this.writer.writeFile(map);
	}
	
	/**
	 * display output content in the console.
	 */
	private void afficheOutput(TreeMap<String, Integer> map) {
		System.out.println(map.toString());
	}
	
	
	
	
	/**
	 * main method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symtpoms.txt");
		WriteData writer = new WriteData();
		AnalyticsCounter compteur = new AnalyticsCounter(reader, writer);
		compteur.process(compteur);
		
		
	
	}

	/**
	 * Wrapper method of others methods in the class
	 * @param compteur type of AnalyticsCounter
	 */
	public void process(AnalyticsCounter compteur) {
		//recuperer liste qui vient du reader et appliquer comptage
		//en fournissant le resultat de la liste (en parametre)
		List<String> symptom = this.reader.getSymptoms();
		
		TreeMap<String, Integer> map = compteur.comptage(symptom);
		compteur.writeInFile(map);
		compteur.afficheOutput(map);
	}
}
