package com.coaware.social.constants.enums;


public enum EmConditionType {
	
	EQ("=", "1"),
	LT(" <= ","2"), 
	GT(" >= ","3");
    // 成员变量
    private String name;
    private String value;

    // 构造方法
    private EmConditionType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(String value) {
        for (EmConditionType c : EmConditionType.values()) {
            if (c.getValue().equals(value)) {
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
