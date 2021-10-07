package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
	public TreeMap<String, Integer> Comptage() {
		
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
	public void AfficheOutput( ) {
		System.out.println(output.toString());
	}
	
	

	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		AnalyticsCounter compteur = new AnalyticsCounter(reader.GetSymptoms());
		
		compteur.Comptage();
		compteur.AfficheOutput();
		
		// first get input
		
		// next generate output
		/*FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	}
}
