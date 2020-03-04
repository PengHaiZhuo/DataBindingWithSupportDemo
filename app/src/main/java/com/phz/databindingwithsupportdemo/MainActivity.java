package com.phz.databindingwithsupportdemo;


import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.phz.databindingwithsupportdemo.databinding.ActivityMainBinding;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author haizhuo
 */
public class MainActivity extends SupportActivity {

    private ActivityMainBinding binding;

    private SupportFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("DataBindingWithSupport");
        }

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //使用DataBinding,绑定后可以直接拿到控件，不需要使用findView去找，也不需要使用ButterKnife了
        //只是举个例子，设置透明度为80%
        binding.idContent.setAlpha(0.8f);
        fragment=BalanceFragment.newInstance();
        loadRootFragment(R.id.id_content, fragment);
    }
}
