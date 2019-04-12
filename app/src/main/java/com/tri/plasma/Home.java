package com.tri.plasma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
