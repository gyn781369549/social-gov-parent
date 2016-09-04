package com.coaware.social.constants.enums;


public enum EmEventSource {
	
	iOS("iOS社区管家",1), 
	Android("Android社区管家",2), 
	PAD("社工平台",3), 
	RX12345("12345",4), 
	ZCWZ("筑城微治",5), 
	WSXX("网上信箱",6), 
	OTHER("其他",20);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmEventSource(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmEventSource c : EmEventSource.values()) {
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
