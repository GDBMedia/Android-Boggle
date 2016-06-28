package net.gdbmedia.boggle;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.title) TextView mTitle;
    @Bind(R.id.letters) TextView mLetters;
    @Bind(R.id.answer) EditText mAnswer;
    @Bind(R.id.submitButton) Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface Bangers = Typeface.createFromAsset(getAssets(), "fonts/Bangers.ttf");

        mTitle.setTypeface(Bangers);
        String letters = randLetters();
        mLetters.setText(letters);

       final char[] lettersArray = letters.toCharArray();

        mSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String answer = mAnswer.getText().toString();
                char[] answerArray = answer.toUpperCase().toCharArray();
                if(answerArray.length >=3){
                    String b = new String(lettersArray);
                    Log.d("char Array", b);
                    for(int i = 0; i<answerArray.length; i++){
                        String test = "" + answerArray[i];
                        Log.d("letter " + i, test);
                        if(new String(lettersArray).indexOf(answerArray[i]) != -1){
                            Toast.makeText(MainActivity.this, "we made it here", Toast.LENGTH_LONG).show();
                            if(i == answerArray.length-1){
                                Intent intent = new Intent(MainActivity.this, AnswerList.class);
                                intent.putExtra("answer", answer);
                                startActivity(intent);
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Answer contained letters not Provided", Toast.LENGTH_LONG).show();
                            break;
                        }
                    }
                }

            }
        });
    }

    public String randLetters(){
        String[] vowels = {"A", "E", "I", "O", "U"};
        String[] others = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "X", "Z", "W", "Y", "A", "E", "I", "O", "U"};
        String returnValue = "";
        Random rand = new Random();
        int vowel1 = rand.nextInt((7 - 0) + 1) + 0;
        int vowel2 = rand.nextInt((7 - 0) + 1) + 0;
        while (vowel1 == vowel2){
            vowel2 = rand.nextInt((7 - 0) + 1) + 0;
        }
        for(int i = 0; i<8; i++){

            if(i == vowel1 || i == vowel2) {
                int x = rand.nextInt((4 - 0) + 1) + 0;
                returnValue += vowels[x];
            }else{
                int x = rand.nextInt((25 - 0) + 1) + 0;
                returnValue += others[x];
            }
        }
        return returnValue;
    }
}
