package com.carylsantiago.optionandcontextualmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.widget.PopupMenu;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button btnContext = (Button) findViewById(R.id.btn1);
        registerForContextMenu(btnContext);
        Button btnPopUp = (Button) findViewById(R.id.btn2);
    }

    //OPTIONS MENU
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings: {
                Toast.makeText(this, "This is settings", Toast.LENGTH_SHORT).show();
                return true;
            }case R.id.share: {
                Toast.makeText(this, "This is share", Toast.LENGTH_SHORT).show();
                return true;
            }case R.id.history: {
                Toast.makeText(this, "This is history", Toast.LENGTH_SHORT).show();
                return true;
            }case R.id.help: {
                Toast.makeText(this, "This is is help", Toast.LENGTH_SHORT).show();
                return true;
            }case R.id.logout: {
                Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //CONTEXTMENU
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Upload");
        menu.add(0, v.getId(), 0, "Search");
        menu.add(0, v.getId(), 0, "Share");
        menu.add(0, v.getId(), 0, "Bookmark");
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Upload") {
            Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getTitle() == "Search") {
            Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }else if (item.getTitle() == "Share"){
            Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;}else if (item.getTitle() == "Bookmark"){
            Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();return true;
        }else {return  false;
        }
    }

    //POPUPMENU
    public void onClickPopUp(View view){
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.setOnMenuItemClickListener(MainActivity.this);
        popup.inflate(R.menu.popup);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_item:Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;

            case R.id.upload_item:Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;

            case R.id.copy_item:Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;

            case R.id.print_item:Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;

            case R.id.share_item:Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;

            case R.id.bookmark_item:Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
            default:return false;}
    }
}