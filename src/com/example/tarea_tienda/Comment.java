package com.example.tarea_tienda;

public class Comment {
    private String comment;
    public Comment(String comment) {
        // TODO Auto-generated constructor stub
        this.comment = comment;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
   
    public String toString(){
        return comment.toString();
    }

}
