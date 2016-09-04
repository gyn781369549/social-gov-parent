package com.coaware.social.constants.enums;

public enum EmidCard {
	//省份证的上传
	front("正面",1), reverse("反面",2);
	
	private String name;
    private int value;
    // 构造方法
    private EmidCard(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmidCard c : EmidCard.values()) {
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
