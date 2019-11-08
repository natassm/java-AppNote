package com.example.appnote;

public class Konten {

    private String title, addnotes;

    public Konten(String title, String addnotes){
        this.title = title;
        this.addnotes = addnotes;
//        this.date = date;
    }

    public Konten() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddnotes() {
        return addnotes;
    }

    public void setAddnotes(String addnotes) {
        this.addnotes = addnotes;
    }

    @Override
    public String toString() {
        return "Konten{" +
                "title='" + title + '\'' +
                ", addnotes='" + addnotes + '\'' +
//                ", date='" + date + '\'' +
                '}';
    }
}
