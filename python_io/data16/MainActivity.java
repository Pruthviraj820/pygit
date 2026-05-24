
package com.example.poe16;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

   @Override
    public void onCreateContextMenu(ContextMenu menu , View v , ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Option");

        getMenuInflater().inflate(R.menu.context_menu , menu);
   }


   @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.option1){
            Toast.makeText(MainActivity.this , "Edit selected" , Toast.LENGTH_SHORT).show();

        }
        else if (item.getItemId() == R.id.option2) {
            Toast.makeText(this, "share selected", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.option3) {
            Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
        }

        return true;
   }



}