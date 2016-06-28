package net.gdbmedia.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnswerList extends AppCompatActivity {
    @Bind(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_list);
        Intent intent = getIntent();
        ButterKnife.bind(this);


        ArrayList answersArray = intent.getStringArrayListExtra("answers");
        Log.d("this is my array", "arr: " + answersArray.get(0).toString());


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, answersArray);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String answer = ((TextView)view).getText().toString();
                Toast.makeText(AnswerList.this, answer, Toast.LENGTH_LONG).show();
            }
        });
    }
}
