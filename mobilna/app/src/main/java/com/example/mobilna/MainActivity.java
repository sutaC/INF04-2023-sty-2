package com.example.mobilna;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etNewItem;
    private ListView listItems;
    private Button btnAdd;

//    Data

    private final List<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNewItem = findViewById(R.id.etNewItem);
        listItems = findViewById(R.id.listItems);
        btnAdd = findViewById(R.id.btnAdd);

//        Init
        items.addAll(Arrays.asList(new String[]{"Zakupy: chleb, masło, ser", "Do zrobienia: obiad, umyć podłogi", "weekend: kino, spacer z psem"}));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_list_view_template, R.id.tvItem, items);
        listItems.setAdapter(adapter);

//        Listeners
        btnAdd.setOnClickListener(e -> {
            String item = etNewItem.getText().toString();
            etNewItem.setText("");
            adapter.add(item);
            adapter.notifyDataSetChanged();
        });
    }
}