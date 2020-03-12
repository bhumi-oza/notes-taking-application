package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteDetailActivity extends AppCompatActivity {

    String strNoteTitle, strNote, strNoteCreatedBy;
    @BindView(R.id.tvNoteTitle)
    TextView tvNoteTitle;
    @BindView(R.id.tvNoteDetail)
    TextView tvNoteDetail;
    @BindView(R.id.tvNoteDate)
    TextView tvNoteDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        ButterKnife.bind(this);

        Intent i = getIntent();
        strNoteTitle =i.getExtras().getString("NoteTitle");
        strNote = i.getExtras().getString("NoteDetail");
        strNoteCreatedBy = i.getExtras().getString("NoteCreatedBy");


        tvNoteTitle.setText(strNoteTitle);
        tvNoteDetail.setText(strNote);
        tvNoteDate.setText(strNoteCreatedBy);


    }
}
