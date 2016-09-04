package com.coaware.social.constants.enums;

public enum EmLogoperationType {
	REGISTER("注册",1), //注册
	LONGIN("登陆",2), //登录		
	QUIT("退出",3); //退出
	private String name;
     private int value;
     private EmLogoperationType(String name, int value) {
         this.name = name;
         this.value = value;
     }

     // 普通方法
     public static String getName(int value) {
         for (EmLogoperationType c : EmLogoperationType.values()) {
             if (c.getValue() == value) {
                 return c.name;
             }
         }
         return null;
     }

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
