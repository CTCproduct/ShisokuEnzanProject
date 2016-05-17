package com.example.hirokikirigaya.shisokuenzan;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //TextViewの宣言
    TextView textViewA,textViewB;

    //EditTextの宣言
    EditText editTextA,editTextB;

    //Editacleの宣言
    Editable editable;

    //AlertDialogの宣言
    //AlertDialog.Builder builder = new AlertDialog.Builder(this);

    //格納する変数の宣言
    private int NumA,NumB;



    //Edittext内の数値を取得し、結果を表示するクラス
    public class GeneralgetEditText {

        //コンストラクタ
        public void GeneralgetEditText(){

        }

        //Edittext内の数値を取得するメソッド
        public void getEditText(Button btn){
            //どちらかのEditTextに数字が入力されていない場合
            if ((editTextA.getText().toString().equals("")) || (editTextB.getText().toString().equals(""))){

            }
            //両方のEditTextに数字を入力している場合
            else{
                //EditText内の数値を取得
                editable = editTextA.getText();
                NumA = Integer.parseInt(editable.toString());
                editable = editTextB.getText();
                NumB = Integer.parseInt(editable.toString());
                textViewA.setText((String)btn.getText().toString());

                //ボタンの文字列に応じて、表示する内容を決める
                switch ((String)btn.getText().toString()){
                    case "＋":
                        textViewB.setText("=" + (NumA+NumB) + "です。");
                        break;
                    case "―":
                        textViewB.setText("=" + (NumA-NumB) + "です。");
                        break;
                    case "×":
                        textViewB.setText("=" + (NumA*NumB) + "です。");
                        break;
                    case "÷":
                        textViewB.setText("=" + (NumA/NumB) + "です。");
                        break;
                    default:
                        break;
                }
            }
        }
    }

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
                //変数の取得 クラス中のメソッドを呼び出す
                generalgetEditText.getEditText(btnWa);
            }
        });

        //差のボタン設定
        btnSa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //変数の取得 クラス中のメソッドを呼び出す
                generalgetEditText.getEditText(btnSa);
            }
        });

        //積のボタン設定
        btnSk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //変数の取得 クラス中のメソッドを呼び出す
                generalgetEditText.getEditText(btnSk);;
             }
        });

        //商のボタン設定
        btnSh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //変数の取得 クラス中のメソッドを呼び出す
                generalgetEditText.getEditText(btnSh);
            }
        });

        //リセットボタンの設定
        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextA.setText("");
                editTextB.setText("");
                textViewA.setText("?");
                textViewB.setText("=");
            }
        });

    }
}
