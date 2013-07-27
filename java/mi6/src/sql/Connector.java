/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author Alex Hughes
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {

    public static boolean AUTOCOMMIT = true;
    public static boolean LOGGER;
    public static boolean QUERY;
    protected Connection connection;
    private DBCredentials credentials;
    private static final String DATABASE_USER = "user";
    private static final String DATABASE_PASSWORD = "password";
    private static final String MYSQL_AUTO_RECONNECT = "autoReconnect";
    private static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

    public Connector(DBCredentials cre) throws SQLException, ClassNotFoundException {
        credentials = cre;
        reConnect();
    }

    public void reConnect() throws SQLException, ClassNotFoundException {

        if (connection != null) {
            connection.close();
        }

        Class.forName("com.mysql.jdbc.Driver");	//in order to manipulate data on the mySQL server

        java.util.Properties connProperties = new java.util.Properties();
        connProperties.put(DATABASE_USER, credentials.getUsername());
        connProperties.put(DATABASE_PASSWORD, credentials.getPassword());
        connProperties.put(MYSQL_AUTO_RECONNECT, "true");
        connProperties.put(MYSQL_MAX_RECONNECTS, "2");
        connProperties.put("characterEncoding", "utf8");

        String conString = credentials.getDriver() + credentials.getURL()
                + credentials.getPort() + credentials.getSchema();

        connection = DriverManager.getConnection(conString, connProperties);

        //hardcoding the autocommit...
        connection.setAutoCommit(AUTOCOMMIT);
        printInfo();    //used to print info of the connection
    }

    public ResultSet sendQuery(String aQuery) throws SQLException {
        ResultSet rs = null;
        Statement stmt;

        if (connection.isValid(1)) {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(aQuery);
        } else {
            try {
                reConnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = connection.createStatement();
            rs = stmt.executeQuery(aQuery);
        }
        if (Connector.QUERY) {
            System.out.println(aQuery);
        }
        return rs;
    }

    public PreparedStatement prepareStatement(String aQuery) throws SQLException {
        PreparedStatement ps;
        
        if(connection.isValid(1)){
            ps = connection.prepareStatement(aQuery, Statement.RETURN_GENERATED_KEYS);
        } else {
            try {
                reConnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps = connection.prepareStatement(aQuery, Statement.RETURN_GENERATED_KEYS);
        }
        
        return ps;
    }

    public ResultSet sendUpdate(String aQuery) throws SQLException {
        Statement stmt;

        if (connection.isValid(1)) {
            stmt = connection.createStatement();
        } else {
            try {
                reConnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = connection.createStatement();
        }
        stmt.executeUpdate(aQuery, Statement.RETURN_GENERATED_KEYS);

        if (Connector.QUERY) {
            System.out.println(aQuery);
        }
        return stmt.getGeneratedKeys();
    }

    public void commit() throws SQLException {
        connection.commit();
        if (Connector.QUERY) {
            System.out.println("COMMIT");
        }
    }

    public void rollback() {
        try {
            connection.rollback();
            if (Connector.QUERY) {
                System.out.println("ROLLBACK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSchema(String aSchema) throws SQLException {
        connection.setSchema(aSchema);
    }

    private void printInfo() {
        System.out.println("Database Management...");
        System.out.println("Succesfully connected to: " + credentials.getURL());
        if (AUTOCOMMIT) {
            System.out.println("AUTOCOMMIT IS ON");
        } else {
            System.out.println("AUTOCOMMIT IS OFF");
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public DBCredentials getCredentials() {
        return credentials;
    }
}
