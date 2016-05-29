package com.example.hirokikirigaya.shisokuenzan;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by Hiroki Kirigaya on 2016/05/18.
 */
public class TextSizeFit extends TextView {

    //最小のテキストサイズ
    private static final float min_size = 10f;

    //コンストラクタ
    public TextSizeFit(Context context){
        super(context);
    }

    //コンストラクタ
    public TextSizeFit(Context context,AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    protected void onLayout(boolean changed,int left,int top,int right,int bottom){
        super.onLayout(changed,left,top,right,bottom);
        resize();
    }

    //テキストサイズ調整
    private void resize(){

        Paint paint = new Paint();

        //Viewの幅
        int viewWidth = this.getWidth();
        //テキストサイズ
        float textsize = getTextSize();

        //Paintにテキストサイズ設定
        paint.setTextSize(textsize);

        //テキストの横幅取得
        float textWidth = paint.measureText(this.getText().toString());

        while (viewWidth < textWidth){
            //横幅に収まるまでループ

            if(min_size >= textsize){
                //最小サイズ以下になる場合は最小サイズ
                textsize = min_size;
                break;
            }

            //テキストサイズをデクリメント
            textsize--;

            //Paintにテキストサイズ設定
            paint.setTextSize(textsize);
            textWidth = paint.measureText(this.getText().toString());
        }

        //テキストサイズ設定
        setTextSize(TypedValue.COMPLEX_UNIT_PX,textsize);
    }
}
