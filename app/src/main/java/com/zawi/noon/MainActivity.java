package com.zawi.noon;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;
    ToggleButton toggle;

    void getTime (boolean is24) {
        final Calendar cldr = Calendar.getInstance();
        int hour = cldr.get(Calendar.HOUR_OF_DAY);
        int minutes = cldr.get(Calendar.MINUTE);
        picker = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                        if(!tp.is24HourView()) {
                            if(sHour > 12) {
                                eText.setText(sHour + ":" + sMinute + " PM");
                            } else {
                                eText.setText(sHour + ":" + sMinute + " AM");
                            }
                        } else {
                            eText.setText(sHour + ":" + sMinute);
                        }
                    }
                }, hour, minutes, is24);
        picker.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvw = (TextView)findViewById(R.id.textView1);
        toggle = (ToggleButton) findViewById(R.id.toggle);
        eText = (EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTime(toggle.isChecked());
            }
        });
        btnGet = (Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Time: "+ eText.getText());
            }
        });
    }
}