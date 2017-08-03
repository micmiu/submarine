package com.micmiu.submarine.core.compress;

import com.micmiu.common.util.ZipUtils;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/29/2017
 * Time: 00:30
 */
public class ZipCompressor extends Compressor {

	@Override
	public String compress(String data) {
		return ZipUtils.zipStr2Base64(data);
	}

	@Override
	public String decompress(String data) {
		return ZipUtils.unzipBase64Str(data);
	}
}
