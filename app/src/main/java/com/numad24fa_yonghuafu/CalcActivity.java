package com.numad24fa_yonghuafu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalcActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        tvDisplay = findViewById(R.id.tv_display);

        // Number buttons (0-9)
        int[] numberButtonIds = {
                R.id.btn_0, R.id.btn_1, R.id.btn_2,
                R.id.btn_3, R.id.btn_4, R.id.btn_5,
                R.id.btn_6, R.id.btn_7, R.id.btn_8,
                R.id.btn_9
        };
        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    input.append(button.getText().toString()); // Append the number to input
                    tvDisplay.setText(input.toString()); // Update the display
                }
            });
        }

        // Operator buttons (+, -, x)
        int[] operatorButtonIds = {R.id.btn_plus, R.id.btn_minus, R.id.btn_multiply};
        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    input.append(" " + button.getText().toString() + " "); // Append operator
                    tvDisplay.setText(input.toString()); // Update display
                }
            });
        }

        // Equals button - evaluates the expression
        Button btnEquals = findViewById(R.id.btn_equals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateExpression();
            }
        });

        // Multiply button for deletion (if this is intended)
        Button btnClear = findViewById(R.id.btn_multiply);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length() > 0) {
                    input.deleteCharAt(input.length() - 1); // Remove the last character
                    tvDisplay.setText(input.toString());
                }
            }
        });
    }

    // Method to evaluate the expression
    private void evaluateExpression() {
        try {
            Expression expression = new ExpressionBuilder(input.toString()).build();
            double result = expression.evaluate(); // Calculate result
            tvDisplay.setText(String.valueOf(result)); // Show the result
            input.setLength(0); // Clear input
            input.append(result); // Save result for further calculations
        } catch (Exception e) {
            tvDisplay.setText("Error"); // Handle any errors
        }
    }
}
