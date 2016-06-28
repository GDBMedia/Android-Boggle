package net.gdbmedia.boggle;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashPage extends AppCompatActivity {
    @Bind(R.id.title) TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);

        ButterKnife.bind(this);

        Typeface Bangers = Typeface.createFromAsset(getAssets(), "fonts/Bangers.ttf");

        mTitle.setTypeface(Bangers);
    }

    public void click(View v){
        Intent intent = new Intent(SplashPage.this, MainActivity.class);
        startActivity(intent);
    }
}
