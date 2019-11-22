package com.example.StudentApp.FragmentStd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.StudentApp.R;

public class AboutUsFragment extends Fragment {
    public WebView web;
    public ProgressBar progressBar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us, container, false);

        web = view.findViewById(R.id.showSite);
        progressBar = view.findViewById(R.id.ShowProgress);



        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://softwarica.edu.np/");
        return view;
    }
}
