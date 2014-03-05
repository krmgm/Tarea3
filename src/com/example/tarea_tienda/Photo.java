package com.example.tarea_tienda;

import java.util.ArrayList;

public class Photo {
    private String direccionweb;
    private String descrip;
    private ArrayList<Comment>listaComents;
    private String favorito;
    public Photo(String url, String descripcion,ArrayList<Comment> comments,String favoriteNum) {
        this.direccionweb = url;
        this.descrip = descripcion;
        this.listaComents = comments;
        this.favorito = favoriteNum;
    }
    public String getURL() {
        return direccionweb;
    }
    public void setURL(String uRL) {
        direccionweb = uRL;
    }
    public String getDescripcion() {
        return descrip;
    }
    public void setDescripcion(String descripcion) {
        this.descrip = descripcion;
    }
    public ArrayList<Comment> getCommentList() {
        return listaComents;
    }
    public void setCommentList(ArrayList<Comment> commentList) {
        this.listaComents = commentList;
    }
    public String getFavoriteNum() {
        return favorito;
    }
    public void setFavoriteNum(String favoriteNum) {
        this.favorito = favoriteNum;
    }
}