package com.gl.logindemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button gLogin;
    private EditText gAccountEdittext;
    private EditText gPwdEdittext;
    private ProgressDialog gProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        gProgressDialog = new ProgressDialog(this);

        initData();

    }

    private void initData() {
        gLogin.setOnClickListener(this);

    }

    private void initView() {

        gLogin = (Button) findViewById(R.id.login);
        gAccountEdittext = (EditText) findViewById(R.id.accountEdittext);
        gPwdEdittext = (EditText) findViewById(R.id.pwdEdittext);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.login:
                final String account = gAccountEdittext.getText().toString().trim();
                final String password = gPwdEdittext.getText().toString().trim();
                //创建Bean类,然后把数据放到bean类里
                final User user = new User();
                user.account = account;
                user.password = password;
                //判断信息是否为null
                boolean userpan = userpan(user);
                if(userpan){
                    //显示进度条
                    gProgressDialog.show();
                    //开启一个子线程做耗时操作
                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            //创建网络工具类对象
                            UserLoginNet net = new UserLoginNet();
                            //对输入的用户进行判断
                            if(net.UserLoginIn(user)){
                                //登录成功的逻辑,谈一个吐司,更新UI
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //关闭进度条
                                        gProgressDialog.dismiss();
                                        Toast.makeText(MainActivity.this,"镭少好帅",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    }.start();
                }else{
                    gProgressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "输入不能为null", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }

    private boolean userpan(User user) {
        if (TextUtils.isEmpty(user.account) || TextUtils.isEmpty(user.password)) {
            Toast.makeText(MainActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}