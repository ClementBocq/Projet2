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
	
	
	//logique m�tier
	public TreeMap<String, Integer> comptage() {
		
	/*Utilisation de  de la boucle avanc� dans le cours d�buter en Java et
	 * de la m�thode frequency qui compte le nombre d'occurence dans une 
	 * liste
	 */
		for(String symptom : this.symptoms) {
			output.put(symptom, Collections.frequency(data, symptom));
		}
		
		return output;
	}
	
	//Aide pour d�bugger � enlever plus tard
	public void afficheOutput( ) {
		System.out.println(output.toString());
	}
	
	

	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		AnalyticsCounter compteur = new AnalyticsCounter(reader.getSymptoms());
		WriteData outputFile = new WriteData(compteur.comptage());
		
		outputFile.writeFile();
		
		compteur.afficheOutput();
		
	
	}
}
