package com.chinamobile.hestudy.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinamobile.hestudy.R;

/**
 * Created by wzq on 2017/3/9.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected Intent createIntent(Class clazz) {
        return new Intent(getActivity(), clazz);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try{
            return initView(inflater, container, savedInstanceState);
        }catch (Exception e){
            e.printStackTrace();
        }
        return inflater.inflate(R.layout.view_error_page, container, false);
    }

    protected void go(Class clazz) {
        startActivity(createIntent(clazz));
    }

    protected void go(Intent intent) {
        startActivity(intent);
    }
}
