package com.micmiu.submarine.core.compress;

/**
 * 默认采用是不压缩算法
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/29/2017
 * Time: 00:30
 */
public class DefaultCompressor extends Compressor {

	@Override
	public String compress(String data) {
		return data;
	}

	@Override
	public String decompress(String data) {
		return data;
	}
}
