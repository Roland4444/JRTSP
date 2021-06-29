package se.roland.client.service;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

public class Settings extends Properties {

    private final static Logger log = Logger.getLogger(Settings.class);
    public Connection connection;
    private final String table = "MyProperties";

    public Settings(Connection conn) {
        this.connection = conn;
        loadFromDB();
    }
//
//    public Settings() {
//        loadFromDB();
//    }

    private void clearProperties() {
        try {
            Statement statement = connection.createStatement();
            String SELECT_STATEMENT = "DELETE FROM " + table.toUpperCase();
            statement.execute(SELECT_STATEMENT);
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    public void storeToDB() {
        try {
            connection.setAutoCommit(false);
            clearProperties();
            PreparedStatement statement;
            for (Enumeration<?> e = keys(); e.hasMoreElements(); ) {
                String key = (String) e.nextElement();
                String val = (String) get(key);
                String STATEMENT = "INSERT INTO " +table.toUpperCase() + "(NAME,VALUE) VALUES(?,?)";
                statement = connection.prepareStatement(STATEMENT);
                statement.setString(1, key);
                statement.setString(2, val);
                statement.execute();
            }
            connection.commit();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    public void loadFromDB() {
        try {
            System.out.println("\n\n\n\nINTO LOAD From db");
            Statement statement = connection.createStatement();
            String SELECT_STATEMENT ="SELECT * FROM `MYPROPERTIES`";    //// "SELECT * from " + service.getUser() + "." + table.toUpperCase();
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT);
            clear();
            while (resultSet.next()) {

                String name = resultSet.getString("NAME");
                String value = resultSet.getString("VALUE");
                System.out.println("\n\n\n\nNAME::"+name +"\nVALUE::"+value);
                if (value==null){
                    System.out.println("\n\n\n\nNULL!");
                    continue;
                }
                put(name, value);
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

}
