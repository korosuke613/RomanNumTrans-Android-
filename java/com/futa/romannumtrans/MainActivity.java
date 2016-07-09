package com.futa.romannumtrans;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View mFocusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void changeLabel(View view){
        TextView generateNum = (TextView) findViewById(R.id.generateNum);
        // エディットテキストのテキストを取得します
        String text = generateNum.getText().toString();
        if(text == null || text.length() == 0)return;
        int num = Integer.parseInt(text);



        String tex2;
        if(new RomanNumTrans().rCheck(num)) {
            tex2 = new RomanNumTrans().rTrans(num);
        }else{
            tex2 = "Error";
        }
        TextView resultTV = (TextView)findViewById(R.id.resultNum);
        resultTV.setText(tex2);

    }

    private void add(View view, String num){
        TextView generateNum = (TextView) findViewById(R.id.generateNum);
        // エディットテキストのテキストを取得します
        String str = generateNum.getText().toString();

        if(str.length() < 4) {
            generateNum.setText(generateNum.getText() + num);
            changeLabel(view);
        }

        //findViewById(R.id.imageView).setVisibility(View.INVISIBLE);

    }

    public void one(View view){
        add(view,"1");
    }
    public void two(View view){
        add(view,"2");
    }
    public void three(View view){
        add(view,"3");
    }
    public void four(View view){
        add(view,"4");
    }
    public void five(View view){
        add(view,"5");
    }
    public void six(View view){
        add(view,"6");
    }
    public void seven(View view){
        add(view,"7");
    }
    public void eight(View view){
        add(view,"8");
    }
    public void nine(View view){
        add(view,"9");
    }
    public void zero(View view){
        add(view,"0");
    }

    public void backspace(View view){
        TextView generateNum = (TextView) findViewById(R.id.generateNum);
        // エディットテキストのテキストを取得します

        String str = generateNum.getText().toString();

        if(str.equals("7163")) {
            // 文字枠の非表示
            //findViewById(R.id.imageView).setVisibility(View.VISIBLE);

        }

        if(str != null && str.length() > 0) {
            generateNum.setText(str.substring(0, str.length() - 1));
            changeLabel(view);
        }
    }

}