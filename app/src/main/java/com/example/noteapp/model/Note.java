package com.example.noteapp.model;

public class Note {

    private int id;
    private String title;
    private String note;
    private String strdate;

    public Note(){

    }

    public Note(int id,String title,String note,String strdate){
        this.id = id;
        this.title = title;
        this.note = note;
        this.strdate = strdate;
    }

    public Note(String title,String note,String strdate){
        this.title = title;
        this.note = note;
        this.strdate = strdate;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStrdate() {
        return strdate;
    }

    public void setStrdate(String strdate) {
        this.strdate = strdate;
    }
}