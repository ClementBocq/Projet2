package com.hemebiotech.analytics;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private List<String> data;
	private HashSet<String> symptoms;
	private TreeMap<String, Integer> output = new TreeMap<String, Integer>();
	
	
	
	public AnalyticsCounter(List<String> data) {
		this.data = data;
		this.symptoms = new HashSet<String>(data);
	}
	
	
	public TreeMap<String, Integer> comptage() {
		

		for(String symptom : this.symptoms) {
			output.put(symptom, Collections.frequency(data, symptom));
		}
		
		
		return output;
	}
	
	public void afficheOutput( ) {
		System.out.println(output.toString());
	}
	
	

	public static void main(String args[]) throws Exception {
		
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		AnalyticsCounter compteur = new AnalyticsCounter(reader.getSymptoms());
		IDataWriter outputFile = new WriteData(compteur.comptage());
		
		outputFile.writeFile();
		
		compteur.afficheOutput();
		
	
	}
}
