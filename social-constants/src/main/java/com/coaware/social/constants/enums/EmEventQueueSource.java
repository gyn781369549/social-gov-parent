package com.coaware.social.constants.enums;

public enum EmEventQueueSource {
	
	FROM_DISTRIBUTE_TO_FEEDBACK("部门处理到待反馈",1),
	FROM_RESULT_CHECK_TO_FEEBACK("结果核查到待反馈",2);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmEventQueueSource(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmEventQueueSource c : EmEventQueueSource.values()) {
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
