package com.coaware.social.constants.enums;

public enum EmEventCheck {

	TRUE("属实",1), FALSE("不属实",2);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmEventCheck(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmEventCheck c : EmEventCheck.values()) {
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
