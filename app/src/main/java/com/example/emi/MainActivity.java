package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText principle,month,interest;
    Button emiCalcBtn;
    TextView totalemi,p_amount,r_amount,totalPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principle = findViewById(R.id.edtPrincipal);
        month = findViewById(R.id.edtYears);
        interest = findViewById(R.id.edtInterest);

        emiCalcBtn = findViewById(R.id.btncalculate);
        totalemi = findViewById(R.id.txtEmi);
        p_amount = findViewById(R.id.txtPrincipalAmount);
        r_amount = findViewById(R.id.txtTotalInterest);
        totalPayment = findViewById(R.id.txtTotalPayment);


        emiCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float P = Float.parseFloat(principle.getText().toString());
                float r = Float.parseFloat(interest.getText().toString());
                int m = Integer.parseInt(month.getText().toString());

                r = r / (12*100);

                float ans = 1.0f;

                for (int i = 1; i <= m; i++) {

                    ans = ans * (1 + r);
                }

                float Emi = P * r * (ans /  (ans-1));

                int Total = (int) (Emi*m);

                p_amount.setText("Pricipal : "+P);
                totalemi.setText("EMi Per month : "+Emi);
                r_amount.setText("Interest : "+(Total-P));
                totalPayment.setText("Total Payment : "+(Total));
            }
        });




    }
}