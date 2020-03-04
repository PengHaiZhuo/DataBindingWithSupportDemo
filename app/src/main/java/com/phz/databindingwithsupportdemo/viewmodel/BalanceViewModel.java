package com.phz.databindingwithsupportdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

/**
 * @author:haizhuo
 */
public class BalanceViewModel extends ViewModel {
    private ObservableField<String> balance=new ObservableField<>();
    {
        balance.set("0.0");
    }

    public ObservableField<String> getBalance() {
        return balance;
    }
}