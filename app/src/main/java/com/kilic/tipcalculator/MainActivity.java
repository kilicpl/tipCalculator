package com.kilic.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.widget.Toast.LENGTH_LONG;


// Tip calculator

public class MainActivity extends AppCompatActivity {

    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView percentageOfBarTextView;
    int seekBarPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        enteredAmount = findViewById(R.id.billAmountID);
        seekBar = findViewById(R.id.percentageSeekBar);
        calculateButton = findViewById(R.id.calculateButton);
        totalResultTextView = findViewById(R.id.resultID);
        percentageOfBarTextView = findViewById(R.id.percentageOfBarTextView);
        seekBar.setMax(20);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentageOfBarTextView.setVisibility(View.VISIBLE);
                percentageOfBarTextView.setText(String.valueOf(seekBar.getProgress()) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarPercentage = seekBar.getProgress();
            }

        });


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!enteredAmount.getText().toString().equals("")) {


                    double calculatedAmount = ((double) seekBarPercentage / 100) * (double) Integer.parseInt(enteredAmount.getText().toString());
                    String strCal = String.valueOf(calculatedAmount);

                    totalResultTextView.setText(strCal);
                } else
                    Toast.makeText(MainActivity.this, "Use your cursor and enter number please", Toast.LENGTH_SHORT).show();


            }
        });


    }

}
