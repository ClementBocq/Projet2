package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
		System.out.println("Lecture du fichier " + this.filepath);
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader (new FileReader(filepath))){
				
				String line = reader.readLine();
				int i = 0; //Compteur de ligne
				
				while (line != null) {
					i++;
					result.add(line);
					line = reader.readLine();
				}
				
				System.out.println("Nombre de ligne dans le fichier : " + i);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		
		return result;
	}

}
