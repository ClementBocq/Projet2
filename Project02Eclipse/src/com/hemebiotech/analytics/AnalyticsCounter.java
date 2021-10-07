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
	
	
	//logique métier
	public TreeMap<String, Integer> Comptage() {
		
	/*Utilisation de  de la boucle avancé dans le cours débuter en Java et
	 * de la méthode frequency qui compte le nombre d'occurence dans une 
	 * liste
	 */
		for(String symptom : this.symptoms) {
			output.put(symptom, Collections.frequency(data, symptom));
		}
		
		return output;
	}
	
	//Aide pour débugger à enlever plus tard
	public void AfficheOutput( ) {
		System.out.println(output.toString());
	}
	
	

	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		AnalyticsCounter compteur = new AnalyticsCounter(reader.GetSymptoms());
		WriteData outputFile = new WriteData(compteur.Comptage());
		
		outputFile.WriteFile();
		
		compteur.AfficheOutput();
		
	
	}
}
