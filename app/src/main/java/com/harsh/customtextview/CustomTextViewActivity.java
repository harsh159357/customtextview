package com.harsh.customtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomTextViewActivity extends AppCompatActivity implements View.OnClickListener {

    CustomTextView customTextView1, customTextView2;
    Button changeToRoboto, changeToCalculus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        customTextView1 = (CustomTextView) findViewById(R.id.customTextView1);
        customTextView2 = (CustomTextView) findViewById(R.id.customTextView2);

        changeToRoboto = (Button) findViewById(R.id.change_to_roboto);
        changeToCalculus = (Button) findViewById(R.id.change_to_calculus);
        changeToRoboto.setOnClickListener(this);
        changeToCalculus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_to_roboto:
                customTextView1.setFont(getString(R.string.font_roboto_regular));
                customTextView2.setFont(getString(R.string.font_roboto_regular));
                break;
            case R.id.change_to_calculus:
                customTextView1.setFont(getString(R.string.font_calculus_sans));
                customTextView2.setFont(getString(R.string.font_calculus_sans));
                break;
        }
    }
}
