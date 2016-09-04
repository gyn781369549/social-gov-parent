package com.coaware.social.constants.enums;

public enum EmFacilitysType {

	Workstation("社区工作站",1), 
	committee("社区居委会",2), 
	policeoffice("社工警务室",3), 
	Communitybased("社区综治办",4), 
	Communityorganizations("社区组织活动室",5), 
	Communityeducation("社区文体教育活动室",6), 
	communitylibrary("社区图书馆",7),
	Communitycenter("社区保健活动中心",8), 
	Communityrehabilitation("社区残疾人康复中心",9), 
	outdoors("户外文体广场",10),	
	other("其他",11);
    // 成员变量
    private String name;
    private int value;
    private EmFacilitysType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (EmFacilitysType c : EmFacilitysType.values()) {
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
