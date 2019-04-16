package com.tri.plasma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<User> userList;
    private Custom_adapter custom_adapter;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

       // listView.setAdapter(custom_adapter);

        Bundle bundle=getIntent().getExtras();

        if(bundle!=null)
        {
            value= bundle.getString("tag");
        }

        databaseReference=FirebaseDatabase.getInstance().getReference("Users");

        userList=new ArrayList<>();
        custom_adapter=new Custom_adapter(Details.this,userList);

        listView=findViewById(R.id.list_view1);

        Query query=FirebaseDatabase.getInstance().getReference("Users").
               orderByChild("blood")
                .equalTo(value);
           query.addListenerForSingleValueEvent(valueEventListener);
    }

   /* @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    User user=dataSnapshot1.getValue(User.class);
                    userList.add(user);
                }
                listView.setAdapter(custom_adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        super.onStart();
    }*/


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            userList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);
                    userList.add(user);
                }
               listView.setAdapter(custom_adapter);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}
