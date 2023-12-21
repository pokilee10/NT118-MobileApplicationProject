package com.example.doan.GrammarCau.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.doan.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchDictionary#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchDictionary extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private WebView webView;
    private String word;

    public SearchDictionary() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchDictionary.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchDictionary newInstance(String param1, String param2) {
        SearchDictionary fragment = new SearchDictionary();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_dictionary, container, false);

        webView = view.findViewById(R.id.web_view);

        Bundle data = getArguments();

        if (data != null) {
            word = data.getString("word");
        }
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.oxfordlearnersdictionaries.com/definition/english/" + word);
        // Inflate the layout for this fragment
        return view;
    }
}