package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * IDataWriter is an interface that write data in output no matter which format it is.
 *
 */

public interface IDataWriter {

	/**
	 * Write data of a TreeMap object in a file.
	 *  @param data which is a TreeMap object.
	 */
	void writeFile(TreeMap<String, Integer> data);

}
