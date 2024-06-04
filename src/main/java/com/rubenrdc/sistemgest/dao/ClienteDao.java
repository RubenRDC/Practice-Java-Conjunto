/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rubenrdc.sistemgest.dao;

import com.rubenrdc.sistemgest.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class ClienteDao {

    private DaoConnection abc = new DaoConnection();
    private List<User> list;
    private String query;
    private List<String> paramsSql =new ArrayList<>();

    public ClienteDao() {

    }

    public void AgregarCliente(User user) {
        if (abc.ExtablecerC() != null) {
            paramsSql.add(0, user.getName());
            paramsSql.add(1, user.getSubname());
            paramsSql.add(2, user.getTell());
            paramsSql.add(3, user.getEmail());

            String query = "INSERT INTO users (nombre,apellido,tell,email) VALUES (?,?,?,?)";
            //();
            abc.GenericUpdate(query, paramsSql);
            paramsSql.clear();
            abc.getCloseC();
        }

    }

    public List getListUsers() {
        query = "SELECT * FROM users";

        if (abc.ExtablecerC() != null) {
            list = new ArrayList<User>();
            ResultSet rs = abc.GenericQuery(query, null);
            try {
                while (rs.next()) {

                    User u = new User(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("tell"), rs.getString("email"));

                    list.add(u);
                }
            } catch (SQLException e) {
                System.out.println("SQLException " + e);
            }
            abc.getCloseC();
        }
        return list;
    }

    public void EliminarCliente(int id) {
        if (abc.ExtablecerC() != null) {
            paramsSql.add(Integer.toString(id));
            query = "DELETE FROM users WHERE id = ?";
            abc.GenericUpdate(query, paramsSql);
            abc.getCloseC();
            paramsSql.clear();
        }
    }

    public void EditarCliente(User user) {
        if (abc.ExtablecerC() != null) {
            query = "UPDATE users SET nombre = ?,apellido=?,tell=?,email=? WHERE id=?";
            paramsSql.add(0, user.getName());
            paramsSql.add(1, user.getSubname());
            paramsSql.add(2, user.getTell());
            paramsSql.add(3, user.getEmail());
            paramsSql.add(4, Integer.toString(user.getId()));

            abc.GenericUpdate(query, paramsSql);

            paramsSql.clear();
            abc.getCloseC();
        }

    }
}
