package com.henryandlincoln.swimmyfishy;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class GameOverActivity extends Activity {

    private static final String PREFS_NAME = "Settings";
    private String highScore;
    private String currentScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

          /* Remove status,title bar and lock screen to portrait */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.game_over);

        loadSettings();
        configureMenuBtn();
        configureScoreDigits();

    }

    public void configureMenuBtn(){
        Button menuBtn = (Button) findViewById(R.id.main_menu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadSettings(){

        SharedPreferences settings = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        highScore = settings.getString("highScore","0xxxx");
        currentScore = settings.getString("currentScore", "0xxxx");
    }

    public int getDigit(char digit){

        switch (digit){
            case '0' :
                return R.drawable.zero;
            case '1' :
                return R.drawable.one;
            case '2' :
                return R.drawable.two;
            case '3' :
                return R.drawable.three;
            case '4' :
                return R.drawable.four;
            case '5' :
                return R.drawable.five;
            case '6' :
                return R.drawable.six;
            case '7' :
                return R.drawable.seven;
            case '8' :
                return R.drawable.eight;
            case '9' :
                return R.drawable.nine;
            default :
                return R.drawable.empty_number;
        }
    }

    private void configureScoreDigits(){

        //Digits for Current Score
        ImageView digit = (ImageView) findViewById(R.id.score1);
        digit.setImageResource(getDigit(currentScore.charAt(0)));

        digit = (ImageView) findViewById(R.id.score2);
        digit.setImageResource(getDigit(currentScore.charAt(1)));

        digit = (ImageView) findViewById(R.id.score3);
        digit.setImageResource(getDigit(currentScore.charAt(2)));

        digit = (ImageView) findViewById(R.id.score4);
        digit.setImageResource(getDigit(currentScore.charAt(3)));

        digit = (ImageView) findViewById(R.id.score5);
        digit.setImageResource(getDigit(currentScore.charAt(4)));

        //Digits for Best Score
        digit = (ImageView) findViewById(R.id.best1);
        digit.setImageResource(getDigit(highScore.charAt(0)));

        digit = (ImageView) findViewById(R.id.best2);
        digit.setImageResource(getDigit(highScore.charAt(1)));

        digit = (ImageView) findViewById(R.id.best3);
        digit.setImageResource(getDigit(highScore.charAt(2)));

        digit = (ImageView) findViewById(R.id.best4);
        digit.setImageResource(getDigit(highScore.charAt(3)));

        digit = (ImageView) findViewById(R.id.best5);
        digit.setImageResource(getDigit(highScore.charAt(4)));

    }
}