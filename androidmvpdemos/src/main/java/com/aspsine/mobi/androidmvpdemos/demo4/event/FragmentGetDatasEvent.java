package com.aspsine.mobi.androidmvpdemos.demo4.event;

import java.util.List;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public class FragmentGetDatasEvent {
    List<String> datas;

    public FragmentGetDatasEvent(List<String> datas) {
        this.datas = datas;
    }

    public List<String> getDatas() {
        return datas;
    }
}
