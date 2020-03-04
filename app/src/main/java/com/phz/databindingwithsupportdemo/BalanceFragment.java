package com.phz.databindingwithsupportdemo;

import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.phz.databindingwithsupportdemo.databinding.FragmentBalanceBinding;
import com.phz.databindingwithsupportdemo.viewmodel.BalanceViewModel;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author:haizhuo
 */
public class BalanceFragment extends SupportFragment implements View.OnClickListener {

    private FragmentBalanceBinding binding;
    private BalanceViewModel balanceViewModel;
    private double balance;

    public static BalanceFragment newInstance() {
        Bundle args = new Bundle();
        BalanceFragment fragment = new BalanceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        balanceViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(MyApplication.getInstance())).get(BalanceViewModel.class);
/*        //这个需要加上扩展包才能用{ implementation 'android.arch.lifecycle:extensions:1.1.1'}，没有扩展包使用上面的方式
        balanceViewModel= ViewModelProviders.of(this).get(BalanceViewModel.class);*/
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_balance,container,false);
        binding.setBalance(balanceViewModel);
        binding.setClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_title_left:
                getActivity().finish();
                break;
            case R.id.bt_invest:
                Log.d("phz","点击了充值按钮");
                balance+=500.0;
                //充值
                balanceViewModel.getBalance().set(String.valueOf(balance));
                break;
            case R.id.bt_withdraw:
                Log.d("phz","点击了提现按钮");
                //提现
                balanceViewModel.getBalance().set("0.0");
                balance=0.0;
                break;
            case R.id.tv_title_second:
                //储值明细
                break;
        }
    }
}
