package com.micmiu.submarine.core.handler;

import com.micmiu.submarine.core.compress.Compressor;
import com.micmiu.submarine.core.compress.CompressorFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/29/2017
 * Time: 00:32
 */
public abstract class CompressorHandler {

	private static Map<Compressor.Type, Compressor> compressorMap = new HashMap<Compressor.Type, Compressor>();

	public static Compressor getCompressor(Compressor.Type type) {
		if (compressorMap.containsKey(type)) {
			return compressorMap.get(type);
		} else {
			Compressor compressor = CompressorFactory.buildDialect(type);
			compressorMap.put(type, compressor);
			return compressor;
		}
	}
}
