package com.example.siasun.myapplication.myview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.siasun.myapplication.R;

public class ImageAndTextView extends AppCompatImageButton {

    ImageButton imageButton;
    TextView textView;

    public ImageAndTextView(Context context) {
        super(context);
        init(context);
    }

    public ImageAndTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageAndTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_and_text_view,null);
        imageButton = view.findViewById(R.id.image_btn);
        textView = view.findViewById(R.id.image_btn_tv);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        imageButton.setOnClickListener(l);
    }

    public void setImageButton(Drawable drawable){
        setImageDrawable(drawable,"");

    }

    public void setImageDrawable(Drawable drawable, String text) {
        imageButton.setImageDrawable(drawable);
        textView.setText(text);
    }
}
