package com.hemebiotech.analytics;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

/**
 * Allow counting of elements in a collection.
 * @author Z
 *
 */

public class AnalyticsCounter {
	
	private List<String> data;
	private HashSet<String> symptoms;
	private TreeMap<String, Integer> output;
	
	
	
	public AnalyticsCounter(String filepath) {
		
		
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		this.data = reader.getSymptoms();
		this.symptoms = new HashSet<String>(this.data);
		this.output = new TreeMap<String, Integer>();
	}
	
	/**
	 * 
	 * @return a TreeMap object which contain a list of symptoms ordered by alphabetical order.
	 */
	public void comptage() {
		
		for(String symptom : this.symptoms) {
			output.put(symptom, Collections.frequency(data, symptom));
		}
		
		
		
	}
	
	public void writeInFile() {
		
		IDataWriter outputFile = new WriteData(this.output);
		outputFile.writeFile();
	}
	
	public void afficheOutput( ) {
		System.out.println(output.toString());
	}
	
	
	
	

	public static void main(String args[]) throws Exception {
				
		AnalyticsCounter compteur = new AnalyticsCounter("symptoms.txt");
		compteur.process(compteur);
		
		
	
	}

	/**
	 * @param compteur
	 */
	public void process(AnalyticsCounter compteur) {
		compteur.comptage();
		compteur.writeInFile();
		compteur.afficheOutput();
	}
}
