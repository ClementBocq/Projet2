package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


/**
 * Write data in a TreeMap and create a file with the TreeMap content.
 */
public class WriteData implements IDataWriter {
	
	
	/** 
	 * this is the constructor.
	 */
	public WriteData() {	}
	
	/**
	 * {@inheritDoc}
	 * Write data of TreeMap attribute in a file named "result.out".
	 */
	@Override
	public void writeFile(TreeMap<String, Integer> data) {
		
		try (BufferedWriter output = new BufferedWriter(new FileWriter("result.out"))) {
			
			
			for(Map.Entry<String, Integer> donnees : data.entrySet()) {
				
				output.write(donnees.getKey() + " : " + donnees.getValue() + "\n");
			}
			
			
			
		} catch (IOException e) {
			
			System.out.println(e);
		}
	}

}
