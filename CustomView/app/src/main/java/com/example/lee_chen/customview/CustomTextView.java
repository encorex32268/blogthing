package com.example.lee_chen.customview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public static final String TAG = CustomTextView.class.getSimpleName();

    public CustomTextView(Context context) {
        super(context);

    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "CustomTextView: Context context, AttributeSet attrs");

    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        int level = Integer.parseInt(text.toString());
        Log.d(TAG, "level: "+level);

        switch (level)
        {
            case 1:
                setBackgroundColor(Color.RED);
                break;
            case 2:
                setBackgroundColor(Color.BLUE);
                break;
            case 3:
                setBackgroundColor(Color.YELLOW);
                break;
            default:
                setBackgroundColor(Color.BLACK);
                break;
        }

    }
}
