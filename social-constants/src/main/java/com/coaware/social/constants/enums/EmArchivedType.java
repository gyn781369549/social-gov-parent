package com.coaware.social.constants.enums;

public enum EmArchivedType {

	CENTER("中心业务人员归档",1), SYSTEM("系统自动归档",2), UN_ACCEPT("中心不受理直接归档",3), GENERAL("公众归档",4), PAD("网格员归档",4);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmArchivedType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmArchivedType c : EmArchivedType.values()) {
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
