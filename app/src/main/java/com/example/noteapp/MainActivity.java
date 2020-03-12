package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.Adapter.NotesAdapter;
import com.example.noteapp.Database.DatabaseHandler;
import com.example.noteapp.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvNotes)
    RecyclerView rvNotes;

    RecyclerView.Adapter adapter;
    List<Note> notesList;

    @BindView(R.id.fabBtn)
    FloatingActionButton fabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
        loadNotes();


        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AddNoteActivity.class);
                startActivity(i);
            }
        });

    }

    private void initViews() {

        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadNotes(){
        DatabaseHandler db = new DatabaseHandler(this);

        notesList = db.getAllNotes();
        if(notesList.size() != 0){
            adapter = new NotesAdapter(this,notesList);
            rvNotes.setAdapter(adapter);
        }


    }

  /*  @OnClick(R.id.fabAddNote)
    public void addNote(){
        Intent i = new Intent(MainActivity.this,AddNoteActivity.class);
        startActivity(i);
    }*/

}