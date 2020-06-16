package com.lyj.o2o.Enums;

/**
 * @author lyj
 * @Description: 店铺状态枚举
 * @date 2020年6月16日
 */
public enum ShopStateEnum {
    CHECK(0, "审核中"),
    SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"),
    OFFLINE(-1, "非法商铺"),
    EDIT_ERROR(-1001, "店铺操作失败"),
    NULL_SHOP_ID(-1002, "ShopId为空"),
    NULL_SHOP_INFO(-1003, "店铺信息为空");

    private int state;
    private String stateInfo;

    ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    // 根据传入的state值返回相应的状态值
    public static ShopStateEnum stateOf(int index) {
        for (ShopStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
