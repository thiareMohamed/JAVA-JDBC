package com.agence.entities;

import com.agence.dao.Clientimpl;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Client extends Clientimpl {
    protected int numero;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String tel;
    protected String email;

    public Client(String nom, String prenom, String email, String tel, String adresse){
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }
    public Client(){
    super();
    }
    public void createClient(ArrayList data){
        System.out.println(data);
       super.create(data);

    }
    public void readClient(){

    }
    public void deleteClient(){

    }
    public void updateClient(){

    }



}
