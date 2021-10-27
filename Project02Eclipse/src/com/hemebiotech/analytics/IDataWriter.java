package com.hemebiotech.analytics;

import java.util.Map;

/**
 * IDataWriter is an interface that write data in output no matter which format it is.
 * 
 * 
 * @author Z
 *
 */

public interface IDataWriter {

	void writeFile(Map<String, Integer> data);
}
