package com.example.hirokikirigaya.shisokuenzan;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //TextViewの宣言
    TextView textViewA,textViewB;
    //EditTextの宣言
    EditText editTextA,editTextB;
    //クラス用の変数を宣言
    private GeneralgetEditText generalgetEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextViewの宣言とインスタンスの取得
        textViewA = (TextView)findViewById(R.id.textViewA);
        textViewB = (TextView)findViewById(R.id.textViewB);

        //EditTextの宣言とインスタンスの取得
        editTextA = (EditText)findViewById(R.id.editTextA);
        editTextB = (EditText)findViewById(R.id.editTextB);

        //Buttonの宣言とインスタンスの取得
        final Button btnWa = (Button)findViewById(R.id.buttonA);
        final Button btnSa = (Button)findViewById(R.id.buttonB);
        final Button btnSk = (Button)findViewById(R.id.buttonC);
        final Button btnSh = (Button)findViewById(R.id.buttonD);
        final Button btnRe = (Button)findViewById(R.id.button);

        //generaleditGettextのインスタンスの取得  ※忘れやすいので要注意
        generalgetEditText = new GeneralgetEditText();

        //和のボタン設定
        btnWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //数値の取得および結果表示
                ShowResult(btnWa);
            }
        });

        //差のボタン設定
        btnSa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //数値の取得および結果表示
                ShowResult(btnSa);
            }
        });

        //積のボタン設定
        btnSk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //数値の取得および結果表示
                ShowResult(btnSk);
             }
        });

        //商のボタン設定
        btnSh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //数値の取得および結果表示
                ShowResult(btnSh);
            }
        });

        //リセットボタンの設定
        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //リセットボタンをクリックされた時は、EdittextとTextviewの文字をデフォルトに戻す。
                editTextA.setText("");
                editTextB.setText("");
                textViewA.setText("?");
                textViewB.setText("=");
            }
        });
    }

    //入力された数値を取得して、四則演算の結果を表示するメソッド
    private void ShowResult(final Button btn){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        //数値が正しく入力されていない場合
                        if (editTextA.getText().toString().equals("") || editTextB.getText().toString().equals("")){
                            //Toastを表示する
                            Toast.makeText(getApplicationContext(), "数値を入力してください。", Toast.LENGTH_SHORT).show();
                        }
                        //数値が正しく入力されている場合
                        else{
                            //数値を取得して、結果を表示するメソッドへ
                            generalgetEditText.getEditText(btn,editTextA,editTextB,textViewA,textViewB);
                        }
                    }
                });
            }
        }).start();
    }
}
