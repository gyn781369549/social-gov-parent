package com.coaware.social.constants.enums;

public enum EmDataType {

	STRING("字符串","String"), 
	INTEGER("整型","Integer"), 
	FLOAT("单精度浮点","Float"),
	DOUBLE("双精度浮点","Double"),
	DATE("日期","Date");
    // 成员变量
    private String name;
    private String value;

    // 构造方法
    private EmDataType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(String value) {
        for (EmDataType c : EmDataType.values()) {
            if (c.getValue().equalsIgnoreCase(value) ) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
