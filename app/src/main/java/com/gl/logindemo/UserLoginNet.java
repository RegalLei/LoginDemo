package com.gl.logindemo;

import android.os.SystemClock;

/**
 * 作者：高镭
 * 时间：2017/4/19 18:34
 * 功能：根据MVC的设计原则,把模拟的网络请求逻辑拆分到Module层
 */
public class UserLoginNet {

    /**
     * 对用户输入信息是否正确进行判断
     */

    public boolean UserLoginIn(User user){
        //睡3秒
        SystemClock.sleep(3000);
        //对用户的消息进行判断
        if("gl".equals(user.account)&&"gl".equals(user.password)){
            //成功
            return true;
        }else{
            //失败
            return false;
        }

    }
}
