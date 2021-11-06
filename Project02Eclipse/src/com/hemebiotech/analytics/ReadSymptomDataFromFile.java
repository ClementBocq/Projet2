package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class read data stored in a file and put it in array.
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	
	/**
	 * this is the constructor.
	 * @param filepath a full or partial filepath.
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
				int lineCounter = 0;
				
				while (line != null) {
					lineCounter++;
					result.add(line);
					line = reader.readLine();
				}
				
				System.out.println("Nombre de ligne dans le fichier : " + lineCounter);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		
		return result;
	}

	

}
