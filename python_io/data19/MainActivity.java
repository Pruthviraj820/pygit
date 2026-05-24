package com.example.poe19;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button ;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editName);
        button = findViewById(R.id.button);

        db = new DBHelper(MainActivity.this);

        button.setOnClickListener(v->{
            String name = editText.getText().toString();

            db.insertData(name);

            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        });
    }
}

package com.example.poe19;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import java.nio.channels.Channel;

class DBHelper extends SQLiteOpenHelper{
    public static final String DB_NAME = "MyDB";

    public DBHelper(Context context){
        super(context , DB_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public void insertData(String name){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name" , name);

        db.insert("student" , null , cv);
    }
}