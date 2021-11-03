package com.example.login.Model;

public class Personaje {

    String nom;
    String poder;
    String capita;
    String recompensa;

    public Personaje() {

    }
    public Personaje(String nom, String poder, String capita, String recompensa) {
        this.nom = nom;
        this.poder = poder;
        this.capita = capita;
        this.recompensa = recompensa;
    }






    public String getNom() {
            return nom;
        }
    public String getPoder() {
        return poder;
    }
    public String getCapita() {
        return capita;
    }
    public String getRecompensa() {
        return recompensa;
    }

    public void setNom(String nom) {
            this.nom = nom;
        }
    public void setPoder(String poder) {
        this.poder = poder;
    }
    public void setCapita(String capita) {
        this.capita = capita;
    }
    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

}
