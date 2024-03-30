package com.example.class_work_2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView resultTV;
    Integer firstNumber, secondNumber;
    boolean isOperation;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = findViewById(R.id.resultTv);
    }

    public void numberClick(View view) {
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (isOperation) {
                resultTV.setText("");
            }
            resultTV.append(text);
        }
        isOperation = false;
    }

    public void operationClick(View view) {
        if (view.getId() == R.id.clearBtn) {
            resultTV.setText("");
        } else if (view.getId() == R.id.plusBtn) {
            firstNumber = Integer.valueOf(resultTV.getText().toString());
            operator = "+";
        } else if (view.getId() == R.id.minusBtn) {
            firstNumber = Integer.valueOf(resultTV.getText().toString());
            operator = "-";
        } else if (view.getId() == R.id.multiplicationBtn) {
            firstNumber = Integer.valueOf(resultTV.getText().toString());
            operator = "*";
        } else if (view.getId() == R.id.divisionBtn) {
            firstNumber = Integer.valueOf(resultTV.getText().toString());
            operator = "/";
        } else if (view.getId() == R.id.equalBtn) {
            secondNumber = Integer.valueOf(resultTV.getText().toString());
            resultTV.setText(calculateOperation(firstNumber, secondNumber, operator));
        }
        isOperation = true;
    }

    private String calculateOperation(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+":
                return String.valueOf(firstNumber + secondNumber);
            case "-":
                return String.valueOf(firstNumber - secondNumber);
            case "*":
                return String.valueOf(firstNumber * secondNumber);
            case "/":
                if (secondNumber != 0) {
                    return String.valueOf(firstNumber / secondNumber);
                } else {
                    return "0";
                }
                    default:
                return "";
        }
    }
}