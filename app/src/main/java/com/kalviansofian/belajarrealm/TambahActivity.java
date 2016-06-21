package com.kalviansofian.belajarrealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kalviansofian.belajarrealm.Helper.RealmHelper;

public class TambahActivity extends AppCompatActivity {

    private RealmHelper realmHelper;
    private EditText inputDescription;
    private EditText inputTitle;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);


        realmHelper = new RealmHelper(TambahActivity.this);


        inputTitle = (EditText) findViewById(R.id.inputTitle);
        inputDescription = (EditText) findViewById(R.id.inputDescription);
        save = (Button) findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inisialisasi string
                String title, description;

                //mengambil text dr edittext
                title = inputTitle.getText().toString();
                description = inputDescription.getText().toString();

                //menambahkan data pada database
                realmHelper.addArtikel(title, description);

                //menutup Add Activity
                finish();
                //kembali ke MainActivity
                Intent i = new Intent(TambahActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
