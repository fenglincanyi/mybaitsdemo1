package com.gjr.po;

import java.util.List;

/**
 * Created by geng
 * on 2017/1/26.
 */
public class UserQueryVo {

    private UserCustom userCustom;
    private List<Integer> ids;// 用于 查询 in (xx,xx,xx)

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
