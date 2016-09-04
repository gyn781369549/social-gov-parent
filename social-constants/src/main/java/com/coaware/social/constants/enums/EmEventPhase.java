package com.coaware.social.constants.enums;

public enum EmEventPhase {

	REVOKE("公众撤销",1), //公众撤销
	
	UN_RECORD("未接录",10), //公众上报后的状态
	RECORD("已接录",11), //中心业务人员接录后的状态
	
	REAL_DISTRIBUTE("已派发核查事件真伪",20), //中心人员派发了真伪核查事件
	REAL_CHECK("真伪核查完成",21), //网格员反馈了真伪核查结果，不需要事件真伪核查的提交
	
	CENTER_ACCEPT("中心受理",30), //中心受理、如果不受理直接办结
	
	HANDLE_DISTRIBUTE("已派发事件处理",40), //中心人员派发了事件给部门或者网格员
	
	//EVENT_ACCEPT("受理",50), //部门或者网格员受理，可以通过派发部门来区分是网格员还是部门/*受理环节去掉，只要派发了默认部门就是受理*/
	EVENT_HANDLED("处理完成",51), //部门或者网格员处理完成
 
	RESULT_DISTRIBUTE("已派发反馈结果核查",60),//已派发给网格员 
	
	RESULT_CHECK("结果核查完成",70), //网格员反馈结果核查
	
	COMPLETED("办结完成",80), //中心业务人员办结完成
	
	EVALATE_GENERAL("评价完成",90), //公众评价完成
	EVALATE_CENTER("评价完成",91), //中心业务人员评价完成
	//EVALATED("评价完成",92), //中心业务人员和公众评价完成
	
	FILE("归档完成",100);		//归档完成
	
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private EmEventPhase(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmEventPhase c : EmEventPhase.values()) {
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
