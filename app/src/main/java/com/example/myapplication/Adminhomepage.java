package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Adminhomepage extends AppCompatActivity {
    Button addnew;
    TextView email;
    FirebaseAuth mAuth;
    FirebaseUser uerr;
    String Pcategary, Pname, PPrice, PDescription , savedate, savetime, pkey;
    TextView admin;
    ImageView img;
    Uri imguri;
    EditText itemname, price, description;

    StorageReference pimgref;
    static final int imgint = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhomepage);
        addnew = findViewById(R.id.logoutadmin);
        admin = findViewById(R.id.admin);
        mAuth = FirebaseAuth.getInstance();
        uerr = mAuth.getCurrentUser();
        img = findViewById(R.id.pimg);
        itemname = findViewById(R.id.itemname);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);

        Bundle bundle = getIntent().getExtras();
        admin.setText(bundle.getString("categary"));
        pimgref = FirebaseStorage.getInstance().getReference().child("ProductImages");
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openimage();
            }
        });
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatedata();
            }
        });


    }



    private void openimage() {

        Intent imgintent = new Intent();
        imgintent.setAction(Intent.ACTION_GET_CONTENT);
        imgintent.setType("image/*");
        startActivityForResult(imgintent, imgint);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == imgint && resultCode == RESULT_OK && data != null) {

            imguri = data.getData();
            img.setImageURI(imguri);

        }


    }
    private void updatedata(){


        PDescription =  description.getText().toString();
        PPrice =  price.getText().toString();
        Pname =  itemname.getText().toString();
         if(imguri == null){

             Toast.makeText(this, "update image", Toast.LENGTH_SHORT).show();
         } else if (TextUtils.isEmpty(Pname)) {
             Toast.makeText(this, "please write Name", Toast.LENGTH_SHORT).show();
         } else if (TextUtils.isEmpty(PPrice)) {
             Toast.makeText(this, "please write price", Toast.LENGTH_SHORT).show();
         } else if (TextUtils.isEmpty(PDescription)) {
             Toast.makeText(this, "please write description", Toast.LENGTH_SHORT).show();
         }else {

             storeimageinfo();

         }

    }

    private void storeimageinfo() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd,  yyy");
        savedate =  simpleDateFormat.format(calendar.getTime());

        SimpleDateFormat simpletimeFormat = new SimpleDateFormat("HHH:mm:ss a");
        savetime =  simpletimeFormat.format(calendar.getTime());
        pkey = savedate + savetime;

        StorageReference filepath = pimgref.child(imguri.getLastPathSegment() + pkey + ".jpg" );
        final UploadTask uploadTask = filepath.putFile(imguri);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
           String massage = e.toString();
                Toast.makeText(Adminhomepage.this, "Error"+massage, Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(Adminhomepage.this, "image upload Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
