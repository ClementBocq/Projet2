package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteData implements IDataWriter {
	
	private BufferedWriter output;
	private TreeMap<String, Integer> data;
	
	public WriteData(TreeMap<String, Integer> data) {
		
		this.data = new TreeMap<String, Integer>(data);
		
	}
	
	
	public void writeFile( ) {
		
		try {
			
			this.output = new BufferedWriter(new FileWriter("result.out"));
			
			for(Map.Entry<String, Integer> donnees : data.entrySet()) {
				
				output.write(donnees.getKey() + " : " + donnees.getValue() + "\n");
			}
			
			output.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
