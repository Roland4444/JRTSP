package se.roland.client.service;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AdminService {

    private final static Logger log = Logger.getLogger(AdminService.class);
    public Connection connection;
    public String getTable(){
        return "";
    }
    public AdminService() {

    }

    public Map<String, String> getRows() {
        Map<String, String> result = new HashMap();
        try {
            Statement statement = connection.createStatement();
            String STATEMENT = "SELECT * FROM " + this.getTable() + " ORDER BY LOGIN";
            ResultSet resultSet = statement.executeQuery(STATEMENT);
            while (resultSet.next()) {
                result.put(resultSet.getString("LOGIN"), resultSet.getString("PASSWORD"));
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return result;
    }

    public void save(String login, String password) {
        try {
            String STATEMENT = "INSERT INTO " + this.getTable() + "(LOGIN,PASSWORD) VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(STATEMENT);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            log.error(ex.getMessage());
        }
    }

    public void update(String login, String password) {
        try {
            String STATEMENT = "UPDATE " + this.getTable() + " SET PASSWORD=? WHERE LOGIN=?";
            PreparedStatement statement = connection.prepareStatement(STATEMENT);
            statement.setString(1, password);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            log.error(ex.getMessage());
        }
    }

    public void delete(String login) {
        try {
            Statement statement = connection.createStatement();
            String STATEMENT = "DELETE FROM " + this.getTable() + " WHERE LOGIN='" + login + "'";
            statement.execute(STATEMENT);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            log.error(ex.getMessage());
        }
    }

    public String getPassword(String login) {

        String STATEMENT = "SELECT PASSWORD FROM " + this.getTable() + " WHERE LOGIN='" + login + "'";

        try (
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(STATEMENT);
        ) {
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return "";
    }
}
