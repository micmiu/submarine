package com.micmiu.submarine.core.model;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 3/2/2016
 * Time: 15:11
 */
public class Report {

	private String succCount;

	private String succeKeys;

	private String failCount;

	private String failKeys;

	public String getFailCount() {
		return failCount;
	}

	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}

	public String getFailKeys() {
		return failKeys;
	}

	public void setFailKeys(String failKeys) {
		this.failKeys = failKeys;
	}

	public String getSuccCount() {
		return succCount;
	}

	public void setSuccCount(String succCount) {
		this.succCount = succCount;
	}

	public String getSucceKeys() {
		return succeKeys;
	}

	public void setSucceKeys(String succeKeys) {
		this.succeKeys = succeKeys;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Report{");
		sb.append("failCount='").append(failCount).append('\'');
		sb.append(", succCount='").append(succCount).append('\'');
		sb.append(", succeKeys='").append(succeKeys).append('\'');
		sb.append(", failKeys='").append(failKeys).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
