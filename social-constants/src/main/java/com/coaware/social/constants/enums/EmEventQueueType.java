package com.coaware.social.constants.enums;

public enum EmEventQueueType {
	
	RECORD("待接录",1),
	CHECK("待核查",10), 
	ACCEPT("待受理",20), 
	DISTRIBUTE("待派发",30), 
	FEEDBACK("待反馈",40), 
	COMPLETE("待办结",50),
	EVALUATE("待评价",60);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmEventQueueType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmEventQueueType c : EmEventQueueType.values()) {
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
