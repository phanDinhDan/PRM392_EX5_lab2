package com.dinhdan.prm392_ex5_lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Number01, Number02, Result;
    Button ADD, SUB, MUL, DIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        Number01 = findViewById(R.id.number01);
        Number02 = findViewById(R.id.number02);
        Result = findViewById(R.id.result);
        ADD = findViewById(R.id.buttonadd);
        SUB = findViewById(R.id.buttonsub);
        MUL = findViewById(R.id.buttonmul);
        DIV = findViewById(R.id.buttondiv);

        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        SUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        MUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        DIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        // Kiểm tra xem EditText có dữ liệu không trước khi thực hiện tính toán
        if (Number01.getText().toString().isEmpty() || Number02.getText().toString().isEmpty()) {
            Result.setText("Please enter both numbers");
            return;
        }

        double number1 = Double.parseDouble(Number01.getText().toString());
        double number2 = Double.parseDouble(Number02.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 != 0)
                    result = number1 / number2;
                else
                    Result.setText("Cannot divide by zero!");
                break;
        }

        Result.setText("Result: " + result);
    }
}
