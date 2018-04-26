package com.example.ggagro.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG: ";
    @BindView(R.id.main_edittext_height) EditText mHeight;
    @BindView(R.id.main_edittext_weight) EditText mWeight;
    @BindView(R.id.main_button_calculate) Button mCalculate;
    @BindView(R.id.main_textview_result_number) TextView mResultNumber;
    @BindView(R.id.main_textview_result_text) TextView mResultText;
    @BindView(R.id.main_textview_result_description) TextView mResultDescription;
    @BindView(R.id.main_imageview_display) ImageView mResultImage;
    @BindView(R.id.main_gridlayout) GridLayout vGridLayout;


    Double height;
    Double weight;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_button_calculate)
    public void calculate(){
        // convert edittext to double
        convertNumbers();
        // formula
        result = weight / Math.pow(height,2);
        result = Double.parseDouble(new DecimalFormat("##.##").format(result));
        // display grid layout
        vGridLayout.setVisibility(View.VISIBLE);
        // display result
        mResultNumber.setText(String.valueOf(result));
        //
        setResult();
    }

    private void setResult() {
        if (result < 18){
            mResultText.setText(R.string.resultTextUnderweight);
            mResultImage.setImageResource(R.drawable.underweight);
            mResultDescription.setText(R.string.resultDescriptionUnderWeight);
        }
        else if (result >18 && result < 25){
            mResultText.setText(R.string.resultTextNormal);
            mResultImage.setImageResource(R.drawable.normal);
            mResultDescription.setText(R.string.resultDescriptionNormal);

        }
        else if (result >25 && result < 30){
            mResultText.setText(R.string.resultTextOverweight);
            mResultImage.setImageResource(R.drawable.overweight);
            mResultDescription.setText(R.string.resultDescriptionOverweight);

        }
        else if (result >30 && result < 35){
            mResultText.setText(R.string.resultTextObese1);
            mResultImage.setImageResource(R.drawable.obese1);
            mResultDescription.setText(R.string.resultDescriptionObese1);

        }
        else if (result >35 && result < 40){
            mResultText.setText(R.string.resultTextObese2);
            mResultImage.setImageResource(R.drawable.obese2);
            mResultDescription.setText(R.string.resultDescriptionObese2);

        }
        else if (result >40){
            mResultText.setText(R.string.resultTextObese3);
            mResultImage.setImageResource(R.drawable.obese3);
            mResultDescription.setText(R.string.resultDescriptionObese3);

        }

    }

    private void convertNumbers() {
        // reset values
        height = null;
        weight = null;
        height = Double.parseDouble(mHeight.getText().toString());
        weight = Double.parseDouble(mWeight.getText().toString());
    }
}
