package com.coaware.social.constants.enums;


public enum EmEventTypical {
	
	MOBILE("移动端",1), 
	PC("PC端",2), 
	ALL("所有",3);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmEventTypical(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmEventTypical c : EmEventTypical.values()) {
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
