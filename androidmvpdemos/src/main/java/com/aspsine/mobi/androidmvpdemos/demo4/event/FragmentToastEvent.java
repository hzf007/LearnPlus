package com.aspsine.mobi.androidmvpdemos.demo4.event;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public class FragmentToastEvent {
    int position;

    public FragmentToastEvent(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
