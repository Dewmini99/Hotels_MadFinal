package com.example.hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        final EditText cardNumber = findViewById(R.id.payments_edit_txt_card_number);
        final EditText cardHolderName = findViewById(R.id.payments_edit_txt_card_name);
        final EditText cvv = findViewById(R.id.payments_edit_txt_cvv);
        final EditText expDate =findViewById(R.id.payments_edit_txt_exp_date);
        EditText totalAmount = findViewById(R.id.payments_txt_view_total_value);
        Button nxt_pay_btn = findViewById(R.id.payments_btn_next);
        paymentDAO dao = new paymentDAO();

        nxt_pay_btn.setOnClickListener(v-> {

            paymenthandle payments = new paymenthandle(cardNumber.getText().toString(),cardHolderName.getText().toString(),
                    cvv.getText().toString(),expDate.getText().toString());
            dao.add(payments).addOnSuccessListener(suc->{

                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{

                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

            String totaAmount = totalAmount.getText().toString();
            Intent intent = new Intent(payment.this,paymentConfirm.class);
            intent.putExtra("keyname", totaAmount);
            startActivity(intent);

        });


        //hook elements of the payment page

//        cardNumber = findViewById(R.id.payments_edit_txt_card_number);
//        cardHolderName = findViewById(R.id.payments_edit_txt_card_name);
//        cvv = findViewById(R.id.payments_edit_txt_cvv);
//        expDate = findViewById(R.id.payments_edit_txt_exp_date);
//        nextbtn = findViewById(R.id.payments_btn_next);
//
//        nextbtn.setOnClickListener(new View.OnClickListener()
//        {
//              @Override
//            public void onClick(view view) {
//                  rootNode = FirebaseDatabase.getInstance();
//                  reference = rootNode.getReference(path:"PaymentDetails");
//
//                  String cardNumber = cardNumber.getEditText().getText().toString();
//                  String cardHolderName =cardHolderName.getEditText().getText().toString();
//                  String cvv = cvv.getEditText().getText().toString();
//                  String expDate = expDate.getEditText().getText().toString();
//                  paymenthandle helperClass = new paymenthandle(cardNumber,cardHolderName,cvv,expDate);
//
//                  reference.child(cardNumber).setValue(helperClass);
//              }
//        });



    }
}

