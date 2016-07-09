package com.futa.romannumtrans;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** スレッドUI操作用ハンドラ */
    private Handler mHandler = new Handler();
    /** テキストオブジェクト */
    private Runnable deleteBeeno;
    /** 結果表示フラッグ */
    private boolean changeFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeLabel(View view){
        TextView generateNum = (TextView) findViewById(R.id.generateNum);
        // エディットテキストのテキストを取得します
        String text = generateNum.getText().toString();
        if(text.length() == 0)return;
        int num = Integer.parseInt(text);
        TextView resultNum = (TextView)findViewById(R.id.resultNum);

        if(num == 7163 ) {
            // ビーノの表示プロセス
            findViewById(R.id.beeno).setVisibility(View.VISIBLE);
            generateNum.setText(R.string.space);
            resultNum.setText(R.string.beeno);

            //ビーノ画像呼び出し
            deleteBeeno = new Runnable() {
                public void run() {
                    findViewById(R.id.beeno).setVisibility(View.INVISIBLE);
                    mHandler.removeCallbacks(deleteBeeno);
                }
            };
            mHandler.postDelayed(deleteBeeno, 400);

        }else {
            if (new RomanNumTrans().rCheck(num)) {
                resultNum.setText(new RomanNumTrans().rTrans(num));
            } else {
                resultNum.setText(R.string.error);
                changeFlag = true;
            }
        }
        changeFlag = true;

    }

    private void add(View view, String num){
        TextView generateNum = (TextView) findViewById(R.id.generateNum);
        // エディットテキストのテキストを取得します

        if(changeFlag == true){
            TextView resultNum = (TextView) findViewById(R.id.resultNum);
            resultNum.setText("");
            generateNum.setText("");
            changeFlag = false;
        }

        String str = generateNum.getText().toString();
        if(str.length() < 4) {
            generateNum.setText(generateNum.getText() + num);
        }

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

        if(changeFlag == true){
            TextView resultNum = (TextView) findViewById(R.id.resultNum);
            resultNum.setText("");
            generateNum.setText("");
            changeFlag = false;

        }else if(str.length() > 0) {
            generateNum.setText(str.substring(0, str.length() - 1));
        }
    }

}