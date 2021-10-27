package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;



public class WriteData implements IDataWriter {
	
	
	public WriteData() {	}
	
	
	public void writeFile(Map<String, Integer> data) {
		
		try (BufferedWriter output = new BufferedWriter(new FileWriter("result.out"))) {
			
			
			for(Map.Entry<String, Integer> donnees : data.entrySet()) {
				
				output.write(donnees.getKey() + " : " + donnees.getValue() + "\n");
			}
			
			
			
		} catch (IOException e) {
			
			System.out.println(e);
		}
	}

}
