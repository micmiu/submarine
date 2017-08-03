package com.micmiu.submarine.core.compress;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/29/2017
 * Time: 00:29
 */
public abstract class CompressorFactory {

	public static Compressor buildDialect(Compressor.Type type) {
		switch (type) {
			case ZIP:
				return new ZipCompressor();
			case DEFAULT:
				return new DefaultCompressor();
			default:
				throw new UnsupportedOperationException();
		}
	}
}
