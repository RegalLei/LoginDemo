package com.gl.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gl.mvvm.bean.User;
import com.gl.mvvm.bean.users;
import com.gl.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private users gUsera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding mion = DataBindingUtil.setContentView(this, R.layout.activity_main);
        gUsera = new users();
        gUsera.name = "gaolei";
        mion.setUu(gUsera);
        User user = new User(gUsera);
        mion.setEvent(user);


    }

    public void text(View view)
    {
        Toast.makeText(this,gUsera.name,Toast.LENGTH_SHORT).show();
    }
}
