package com.yavuz.bodymassindexcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText heightText;
    EditText weightText;
    TextView resultText;
    Button button;
    ImageView ayloImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightText = findViewById(R.id.heightText);
        weightText = findViewById(R.id.weightText);
        resultText = findViewById(R.id.resultText);
        button = findViewById(R.id.button);
        ayloImage = findViewById(R.id.ayloImage);
    }

    public void calculate(View view){

        if(heightText.getText().toString().matches("") || weightText.getText().toString().matches("")){

            resultText.setText("Please enter your height and weight!!");
        }

        else{

            double height = Double.parseDouble(heightText.getText().toString());
            double weight = Double.parseDouble(weightText.getText().toString());
            double BMI = weight / ( height * height );

            if(BMI >= 0 && BMI <= 18.4){

                resultText.setText("You are THIN. " + "BMI : " + " " + String.format("%.2f", BMI));
                ayloImage.setImageResource(R.drawable.resource_true);
            }

            else if(BMI >= 18.5 && BMI <= 24.9){

                resultText.setText("You are NORMAL. " + "BMI : " + " " + String.format("%.2f", BMI));
                ayloImage.setImageResource(R.drawable.resource_true);
            }

            else if(BMI >= 25 && BMI <= 29.9){

                resultText.setText("You are OVERWEİGHT. " + "BMI : " + " " + String.format("%.2f", BMI));
                ayloImage.setImageResource(R.drawable.resource_true);
            }

            else if(BMI >= 30 && BMI <= 34.9){

                resultText.setText("You are first degree OBESE. " + "BMI : " + " " + String.format("%.2f", BMI));
                ayloImage.setImageResource(R.drawable.resource_false);
            }

            else if(BMI >= 35 && BMI <= 44.9){

                resultText.setText("You are second degree OBESE. " + "BMI : " + " " + String.format("%.2f", BMI));
                ayloImage.setImageResource(R.drawable.resource_false);
            }

            else if(BMI >= 45){

                resultText.setText("You are third degree OBESE. " + "BMI : " + " " + String.format("%.2f", BMI));
                ayloImage.setImageResource(R.drawable.resource_false);
            }
        }
    }
}