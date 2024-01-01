package com.example.lab3_bai4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ScreenSlidePageFragment extends Fragment {
    private static final String ARG_NAME = "name";
    private static final String ARG_POSITION = "position";
    private static final String ARG_EMAIL = "email";

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    public static ScreenSlidePageFragment newInstance(String name, String position, String email) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_POSITION, position);
        args.putString(ARG_EMAIL, email);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        TextView nameTextView = rootView.findViewById(R.id.nameTextView);
        TextView positionTextView = rootView.findViewById(R.id.position1TextView);
        TextView emailTextView = rootView.findViewById(R.id.email1TextView);

        if (getArguments() != null) {
            String name = getArguments().getString(ARG_NAME);
            String position = getArguments().getString(ARG_POSITION);
            String email = getArguments().getString(ARG_EMAIL);

            nameTextView.setText(name);
            positionTextView.setText(position);
            emailTextView.setText(email);
        }

        return rootView;
    }
}
