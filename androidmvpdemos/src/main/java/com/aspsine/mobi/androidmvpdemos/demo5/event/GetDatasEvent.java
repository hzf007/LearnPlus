package com.aspsine.mobi.androidmvpdemos.demo5.event;

import java.util.List;

/**
 * Created by hzf on 2017/3/2 0002.
 * 相当于一个对象
 */

public class GetDatasEvent {
    List<String> datas;

    public GetDatasEvent(List<String> datas) {
        this.datas = datas;
    }

    public List<String> getDatas() {
        return datas;
    }
}
