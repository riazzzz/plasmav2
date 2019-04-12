package com.tri.plasma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    private Button send,clear;
    private EditText name,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        send=(Button)findViewById(R.id.feedback_send);
        clear=(Button)findViewById(R.id.feedback_clear);
        name=(EditText)findViewById(R.id.feedback_name);
        message=(EditText)findViewById(R.id.feedback_comment);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    String na=name.getText().toString();
                    String ma=message.getText().toString();
                    Intent intent=new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"tareqmahmud7572@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from app");
                    intent.putExtra(Intent.EXTRA_TEXT,"Name: "+na+"\n Message:"+ma);
                    startActivity(Intent.createChooser(intent,"Feedback with"));

                }catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"enter name and message:",Toast.LENGTH_SHORT).show();
                }




            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setText("");
                message.setText("");
            }
        });
    }
}
