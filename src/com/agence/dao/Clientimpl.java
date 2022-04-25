package com.agence.dao;

import java.sql.*;
import java.util.ArrayList;

public class Clientimpl implements IClient{
    public Connection connect;
    public Clientimpl(){
        DB db = new DB();
        try {
            this.connect = db.connexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void create(ArrayList<String> data){

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connect.prepareStatement("INSERT INTO client (nom, prenom, adresse, tel, email) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,data.get(0));
            preparedStatement.setString(2, data.get(1));
            preparedStatement.setString(3, data.get(2));
            preparedStatement.setString(4, data.get(3));
            preparedStatement.setString(5, data.get(4));

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    public ArrayList read(){
        ArrayList<String[]> donnees = new ArrayList();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM client");
            ResultSet rs = preparedStatement.executeQuery();
            String[] donnee = new String[6];
            int i = 0;
            while (rs.next()){
                donnee[0] = String.valueOf(rs.getInt("numero"));
                donnee[1] = rs.getString("nom");
                donnee[2] = rs.getString("prenom");
                donnee[3] = rs.getString("adresse");
                donnee[4] = rs.getString("tel");
                donnee[5] = rs.getString("email");

                donnees.add(donnee);
                i++;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return donnees;
    }
    @Override
    public int update(ArrayList<String> data ){
        int rs;
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("UPDATE client set nom=?, prenom=?, adresse=?, tel=?, email=? WHERE numero=?");
            preparedStatement.setInt(5, Integer.parseInt(data.get(0)));
            preparedStatement.setString(4, data.get(5));
            preparedStatement.setInt(3, Integer.parseInt(data.get(4)));
            preparedStatement.setString(2, data.get(3));
            preparedStatement.setString(1, data.get(2));
            preparedStatement.setString(0,data.get(1));

             rs = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    };
    public ResultSet delete(int id){
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("DELETE * FROM client WHERE numero=?");
            preparedStatement.setInt(id,0);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };


    public static void main(String[] args) {
        Clientimpl clien = new Clientimpl();
    }
}
