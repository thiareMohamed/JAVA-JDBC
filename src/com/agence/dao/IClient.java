package com.agence.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface IClient {
    void create(ArrayList<String> data);
    ArrayList read();
    int update(ArrayList<String> data);
    ResultSet delete(int id);
}
