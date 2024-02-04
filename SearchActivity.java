package com.example.nammavivasayi.search;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.nammavivasayi.R;
import com.example.nammavivasayi.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding activitySearchActivityBinding;
    ListAdapter adapter;

    List<String> arrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        arrayList.add("January");
        arrayList.add("February");
        arrayList.add("March");
        arrayList.add("April");
        arrayList.add("May");
        arrayList.add("June");
        arrayList.add("July");
        arrayList.add("August");
        arrayList.add("September");
        arrayList.add("October");
        arrayList.add("November");
        arrayList.add("December");

        adapter= new ListAdapter(arrayList);
        activitySearchActivityBinding.listView.setAdapter(adapter);

        activitySearchActivityBinding.search.setActivated(true);
        activitySearchActivityBinding.search.setQueryHint("Type your keyword here");
        activitySearchActivityBinding.search.onActionViewExpanded();
        activitySearchActivityBinding.search.setIconified(false);
        activitySearchActivityBinding.search.clearFocus();

        activitySearchActivityBinding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });
    }
}


