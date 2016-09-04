package com.coaware.social.constants.enums;

public enum EmVerify {

	CHECKED("审核通过",1), UN_CHECKED("审核不通过",2), UNDEFINDE("未定义",0);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmVerify(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmVerify c : EmVerify.values()) {
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
