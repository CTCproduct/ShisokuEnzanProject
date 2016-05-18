package com.example.hirokikirigaya.shisokuenzan;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Hiroki Kirigaya on 2016/05/18.
 * EditeText内の数値を取得して、結果を表示するクラス
 */

public class GeneralgetEditText extends AppCompatActivity {

    //EditText内の数値を取得、結果を表示するメソッド
    public void getEditText(Button btn,EditText edtxta,EditText edtxtb,TextView txtva,TextView txtvb) {

        Long NumA, NumB;
        Editable editable;

        editable = edtxta.getText();
        NumA = Long.parseLong(editable.toString());
        editable = edtxtb.getText();
        NumB = Long.parseLong(editable.toString());

        //ボタンの文字列に応じて表示方法を決める
        switch (btn.getText().toString()) {

            //＋の場合
            case "＋":
                txtva.setText("＋");
                txtvb.setText("=" + (NumA + NumB) + "です。");
                break;

            //ーの場合
            case "―":
                txtva.setText("―");
                txtvb.setText("=" + (NumA - NumB) + "です。");
                break;

            //×の場合
            case "×":
                txtva.setText("×");
                txtvb.setText("=" + (NumA * NumB) + "です。");
                break;

            //÷の場合
            case "÷":
                txtva.setText("÷");
                txtvb.setText("=" + (NumA / NumB) + "です。");
                break;

            //上記以外の場合
            default:
                break;
        }
    }
}
