package com.techkshetra.tpc1.h2otesttwo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Regtwofragment extends Fragment {
    private CheckBox allcheck,moncheck,tuecheck,wedcheck,thucheck,fricheck,satcheck,suncheck;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.reg_two_fragment_layout,container,false);
    }

}
