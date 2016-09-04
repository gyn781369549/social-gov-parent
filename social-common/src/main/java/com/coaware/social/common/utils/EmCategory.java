package com.coaware.social.common.utils;


public enum EmCategory {

	CHECK_STATUS("1","审核状态"), 
	PUBLISH_STATUS("2","发布状态");
	
	private final String value;
	private final String type;

	private EmCategory(String value, String type) {
		this.value = value;
		this.type = type;
	}

	public String value() {
		return value;
	}
	public String getValue() {
		return value;
	}


	public String toString() {
		return this.type;
	}

    public static EmCategory of(final String value) {
        for (EmCategory dt : EmCategory.values()) {
            if (dt.value != null && dt.value.equals(value)) {
                return dt;
            }
        }
        return null;
    }
	
}
