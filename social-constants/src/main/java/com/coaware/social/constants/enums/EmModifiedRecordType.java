package com.coaware.social.constants.enums;

public enum EmModifiedRecordType {
	
	SUPPORT("配套设施",1),
	HOUSE("房屋",2), 
	POPULATION("人口",3),
	BUILD("楼栋",4),
	GRID("网格",5);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmModifiedRecordType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmModifiedRecordType c : EmModifiedRecordType.values()) {
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
