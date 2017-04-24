package com.harsh.customtextview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;

public class CustomTextViewActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MAKE_THIS_SPECIFIC_PART_COLORED = "MakeThisSpecificPartColored";
    public static final String MAKE_THIS_SPECIFIC_PART_BOLD = "MakeThisSpecificPartBold";
    public static final String MAKE_THIS_SPECIFIC_PART_BOLD_AND_COLORED = "MakeThisSpecificPartBoldAndColored";

    CustomTextView customTextView1,
            customTextView2,
            customTextView3;

    Button changeToRoboto,
            changeToCalculus,
            makeSpecificTextColored,
            makeSpecificTextBold,
            makeSpecificTextBoldAndColored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        customTextView1 = (CustomTextView) findViewById(R.id.customTextView1);
        customTextView2 = (CustomTextView) findViewById(R.id.customTextView2);
        customTextView3 = (CustomTextView) findViewById(R.id.customTextView3);

        changeToRoboto = (Button) findViewById(R.id.change_to_roboto);
        changeToCalculus = (Button) findViewById(R.id.change_to_calculus);
        makeSpecificTextBold = (Button) findViewById(R.id.make_specific_text_bold);
        makeSpecificTextColored = (Button) findViewById(R.id.make_text_colored);
        makeSpecificTextBoldAndColored = (Button) findViewById(R.id.make_text_bold_and_colored);

        changeToRoboto.setOnClickListener(this);
        changeToCalculus.setOnClickListener(this);
        makeSpecificTextColored.setOnClickListener(this);
        makeSpecificTextBold.setOnClickListener(this);
        makeSpecificTextBoldAndColored.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_to_roboto:
                customTextView1.setFont(getString(R.string.font_roboto_regular));
                customTextView2.setFont(getString(R.string.font_roboto_regular));
                customTextView3.setFont(getString(R.string.font_roboto_regular));
                break;
            case R.id.change_to_calculus:
                customTextView1.setFont(getString(R.string.font_calculus_sans));
                customTextView2.setFont(getString(R.string.font_calculus_sans));
                customTextView3.setFont(getString(R.string.font_calculus_sans));
                break;
            case R.id.make_text_colored:
                makeTextColoured();
                break;
            case R.id.make_specific_text_bold:
                makeSpecificTextBold();
                break;
            case R.id.make_text_bold_and_colored:
                makeTextBoldAndColored();
                break;
        }
    }


    public static SpannableString giveMeColoredSpan(SpannableString spannableString, int color) {
        spannableString.setSpan(
                new ForegroundColorSpan(color), 0, spannableString.length(), 0);
        return spannableString;
    }

    private void makeTextColoured() {
        String textToBeSpanned = customTextView1.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textToBeSpanned);

        int positionOfSearchedText = textToBeSpanned.indexOf(MAKE_THIS_SPECIFIC_PART_COLORED);

        SpannableString coloredSpan = giveMeColoredSpan(
                new SpannableString(textToBeSpanned),
                ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_dark));

        customTextView1.setText(coloredSpan);
    }

    private void makeSpecificTextBold() {
        String textToBeSpanned = customTextView2.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textToBeSpanned);

        int positionOfSearchedText = textToBeSpanned.indexOf(MAKE_THIS_SPECIFIC_PART_BOLD);

        StyleSpan styleSpan = new StyleSpan(android.graphics.Typeface.BOLD);

        spannableStringBuilder.setSpan(styleSpan,
                positionOfSearchedText,
                positionOfSearchedText + MAKE_THIS_SPECIFIC_PART_BOLD.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        customTextView2.setText(spannableStringBuilder);
    }

    private void makeTextBoldAndColored() {
        String textToBeSpanned = customTextView3.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textToBeSpanned);

        int positionOfSearchedText = textToBeSpanned.indexOf(MAKE_THIS_SPECIFIC_PART_BOLD_AND_COLORED);

        StyleSpan styleSpan = new StyleSpan(android.graphics.Typeface.BOLD);

        spannableStringBuilder.setSpan(styleSpan,
                positionOfSearchedText,
                positionOfSearchedText + MAKE_THIS_SPECIFIC_PART_BOLD_AND_COLORED.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        SpannableString coloredBoldSpan = giveMeColoredSpan(
                new SpannableString(spannableStringBuilder),
                ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_dark));

        customTextView3.setText(coloredBoldSpan);
    }

}
