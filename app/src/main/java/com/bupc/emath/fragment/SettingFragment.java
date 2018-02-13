package com.bupc.emath.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.bupc.emath.AppClass;
import com.bupc.emath.R;
import com.bupc.emath.utils.Prefs;

/**
 * Created by casjohnpaul on 2/4/2018.
 */

public class SettingFragment extends Fragment {

    private final String TAG = SettingFragment.class.getSimpleName();
    private AppClass mAppClass;
    private Context mContext;
    private View mView;


    public static SettingFragment newInstance() {

        Bundle args = new Bundle();

        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_settings, container, false);
        mAppClass = AppClass.getInstance();
        mContext = mAppClass.getAppContext();

        Switch soundSwitch = (Switch) mView.findViewById(R.id.settigs_switch_sounds);

        // always fires if b is true, but it's okay
        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Prefs.setSoundStatus(b);
            }
        });

        soundSwitch.setChecked(Prefs.isSoundActive());

        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
