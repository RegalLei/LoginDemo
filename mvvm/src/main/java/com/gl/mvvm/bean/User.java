package com.gl.mvvm.bean;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * 作者：高镭
 * 时间：2017/4/21 15:15
 * 功能：
 */
public class User {
    private users user;

    public User(users user) {
        this.user = user;
    }

    public TextWatcher gWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable)
        {
             user.name= editable.toString();
        }
    };
}
