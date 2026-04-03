package com.example.q1_currencyconverter;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    Spinner fromCurrency, toCurrency;
    EditText amount;
    TextView result;
    Button convertBtn;

    String[] currencies = {"INR", "USD", "EUR", "JPY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromCurrency = findViewById(R.id.fromCurrency);
        toCurrency = findViewById(R.id.toCurrency);
        amount = findViewById(R.id.amount);
        result = findViewById(R.id.result);
        convertBtn = findViewById(R.id.convertBtn);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencies);
        fromCurrency.setAdapter(adapter);
        toCurrency.setAdapter(adapter);

        convertBtn.setOnClickListener(v -> {
            double amt = Double.parseDouble(amount.getText().toString());

            String from = fromCurrency.getSelectedItem().toString();
            String to = toCurrency.getSelectedItem().toString();

            double converted = convert(amt, from, to);
            result.setText("Result: " + converted);
        });
    }

    private double convert(double amt, String from, String to) {
        if (from.equals("USD") && to.equals("INR")) return amt * 83;
        if (from.equals("INR") && to.equals("USD")) return amt / 83;

        if (from.equals("EUR") && to.equals("INR")) return amt * 90;
        if (from.equals("INR") && to.equals("EUR")) return amt / 90;

        if (from.equals("JPY") && to.equals("INR")) return amt * 0.55;
        if (from.equals("INR") && to.equals("JPY")) return amt / 0.55;

        return amt;
    }
}