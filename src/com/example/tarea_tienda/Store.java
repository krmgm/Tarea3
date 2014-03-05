package com.example.tarea_tienda;

import java.util.ArrayList;

public class Store {
    private String nombre;
    private String lugar;
    private String telefono;
    private String hora;
    private String web;
    private String mail;
    private ArrayList<Comment> listaComent;
    private String favorito;
    private String locacion;

    public Store(String name,String address,String phone,String horary,String website, String email,ArrayList<Comment> comment,String favoriteNum,String ubicacion){
        this.setNombre(nombre);
        this.setLugar(lugar);
        this.setTelefono(telefono);
        this.setHora(hora);
        this.setWeb(web);
        this.setMail(mail);
        this.listaComent = comment;
        this.setFavorito(favorito);
        this.setLocacion(ubicacion);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFavorito() {
        return favorito;
    }
    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public ArrayList<Comment> getListaComent() {
        return listaComent;
    }

    public void setCommentList(ArrayList<Comment> listaComent) {
        this.listaComent = listaComent;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}