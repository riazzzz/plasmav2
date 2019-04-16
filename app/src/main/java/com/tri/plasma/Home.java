package com.tri.plasma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Home extends AppCompatActivity {

    private Button btn;
    private RadioGroup radioGroup;
    private RadioButton radioButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        radioGroup=(RadioGroup) findViewById(R.id.radio_blood);

        btn=(Button) findViewById(R.id.search);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectid= radioGroup.getCheckedRadioButtonId();
                radioButton=(RadioButton) findViewById(selectid);
                String value=radioButton.getText().toString();


                Intent intent=new Intent(Home.this,Details.class);
                intent.putExtra("tag",value);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.Share)
        {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject="Blood donation app";
            String body="It is very good app to find donar.\n package com.tri.plasma;";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"share with"));
        }
        else if(item.getItemId()==R.id.Feedback)
        {
            Intent intent=new Intent(Home.this,Feedback.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.About_us)
        {
            Intent intent=new Intent(Home.this,About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
