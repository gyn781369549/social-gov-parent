package com.coaware.social.constants.enums;

public enum EmEventSolve {

	SOLVED("已解决",1), UN_SOLVED("未解决",2), ACCEPT("初始状态",0);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmEventSolve(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmEventSolve c : EmEventSolve.values()) {
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
