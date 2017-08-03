package com.micmiu.submarine.core.compress;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/29/2017
 * Time: 00:19
 */
public abstract class Compressor {
		public static enum Type{
			DEFAULT,
			ZIP,
			DEFLATE,
			GZIP,
			BZIP2,
			LZO,
			LZ4,
			SNAPPY
		}

	/**
	 * 压缩字符串
	 * @param data
	 * @return
	 */
	public abstract String compress(String data);

	/**
	 * 解压缩字符串
	 * @param data
	 * @return
	 */
	public abstract String decompress(String data);
}
