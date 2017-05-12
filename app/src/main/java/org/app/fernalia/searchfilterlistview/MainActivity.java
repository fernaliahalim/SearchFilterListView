package org.app.fernalia.searchfilterlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText edSearch;
    ListView lvAnimalia;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSearch   = (EditText) findViewById(R.id.ed_search);
        lvAnimalia = (ListView) findViewById(R.id.lv_animalia);
        final String[] animalia = new String[] {"Porifera", "Cnidaria", "Platyhelminthes", "Nematoda", "Annelida", "Mollusca", "Echinodermata", "Arthopoda", "Chordata"};

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animalia);
        lvAnimalia.setAdapter(adapter);

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
