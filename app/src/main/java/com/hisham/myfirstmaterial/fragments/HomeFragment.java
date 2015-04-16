package com.hisham.myfirstmaterial.fragments;

/**
 * Created by Hisham on 4/16/2015.
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hisham.myfirstmaterial.R;
import com.hisham.myfirstmaterial.activity.DemoActivityForTransition;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        Button btn = (Button)rootView.findViewById(R.id.btnStartActivity);

        btn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                int currentApkVersion = Build.VERSION.SDK_INT;

                Intent intent = new Intent(getActivity().getApplicationContext(), DemoActivityForTransition.class);
                if(currentApkVersion >= Build.VERSION_CODES.LOLLIPOP){
                    getActivity().getWindow().setExitTransition(new Explode());
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
                    getActivity().startActivity(intent, bundle);
                } else {
                    getActivity().startActivity(intent);
                }


            }
        });


        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
