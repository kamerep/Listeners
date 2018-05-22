package com.example.pc.listeners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button buttonA, buttonB;
    CheckBox checkBoxTerms;
    Spinner spinnerCountries;
    SeekBar seekBarAge;
    ToggleButton togglepresence;
    TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        spinnerCountries = findViewById(R.id.spinnerCountries);
        seekBarAge = findViewById(R.id.seekBarAge);
        togglepresence = findViewById(R.id.togglePresence);
        textViewResults = findViewById(R.id.textViewResults);

        checkBoxTerms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    textViewResults.setText("Agreed to Terms");
                } else {
                    textViewResults.setText("Rejected the Terms");
                }
            }
        });

        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewResults.setText("Age is" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String country = ((TextView) view).getText().toString();
                textViewResults.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        togglepresence.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    textViewResults.setText("Present");

                } else {
                    textViewResults.setText("Absent");
                }
            }
        });
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewResults.setText("Button A was clicked");
            }
        });

    }

    public void preview(View view) {
        textViewResults.setText("Button B was clicked");
    }
}
