package com.coaware.social.constants.enums;

public enum EmFileType {

	IMG("图片",1), AUDIO("音频",2), VIDEO("视频",3);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmFileType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmFileType c : EmFileType.values()) {
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
