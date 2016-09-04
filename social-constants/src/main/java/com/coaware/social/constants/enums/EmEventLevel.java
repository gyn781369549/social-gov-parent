package com.coaware.social.constants.enums;

public enum EmEventLevel {

	DAILY("日常",1), GENERAL("一般",2), SERIOUS("严重",3), GREAT("重大",4);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmEventLevel(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmEventLevel c : EmEventLevel.values()) {
            if (c.getValue() == value) {
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
