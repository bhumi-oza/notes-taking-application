package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.noteapp.Database.DatabaseHandler;
import com.example.noteapp.model.Note;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNoteActivity extends AppCompatActivity {

    @BindView(R.id.etTitle)
    EditText etTitle;

    @BindView(R.id.etNote)
    EditText etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);
    }


    private void saveNote() {

        String title = etTitle.getText().toString();
        String note_text = etNote.getText().toString();

        if (title.equals("") || note_text.equals("")) {
            showToast("Please fill all the fields before saving");


        } else {

            String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

            Log.v("AddNote", "Add note "+ currentDateTimeString);


            DatabaseHandler db = new DatabaseHandler(this);
            Note note = new Note(title, note_text,currentDateTimeString);
            db.addNote(note);
            db.close();

            Intent i = new Intent(AddNoteActivity.this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        }

    }


    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_save) {
            saveNote();
        }

        return super.onOptionsItemSelected(item);
    }
}