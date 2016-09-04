package com.coaware.social.constants.enums;

public enum EmDistributeType {

	ADD("新增派发",1), REPEAT("重新派发",2);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmDistributeType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmDistributeType c : EmDistributeType.values()) {
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
