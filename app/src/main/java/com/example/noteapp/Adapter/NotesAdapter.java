package com.example.noteapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.NoteDetailActivity;
import com.example.noteapp.R;
import com.example.noteapp.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter  extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    Context context;
    List<Note> noteList = new ArrayList<>();

    public NotesAdapter(Context context, List<Note> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_note,parent,false);
        NotesViewHolder nvh = new NotesViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, final int position) {
        holder.tvTitle.setText(noteList.get(position).getTitle());
        holder.tvNote.setText(noteList.get(position).getNote());
        holder.tvNoteCreatedBy.setText("Created By :"+noteList.get(position).getStrdate());


        holder.consLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, NoteDetailActivity.class);
                i.putExtra("NoteTitle",noteList.get(position).getTitle());
                i.putExtra("NoteDetail",noteList.get(position).getNote());
                i.putExtra("NoteCreatedBy",noteList.get(position).getStrdate());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle,tvNote,tvNoteCreatedBy;
        ConstraintLayout consLayout;
        public NotesViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvNoteTitle);
            tvNote = itemView.findViewById(R.id.tvNoteText);
            tvNoteCreatedBy = itemView.findViewById(R.id.tvNoteCreatedBy);
            consLayout = itemView.findViewById(R.id.consLayout);

        }
    }

}