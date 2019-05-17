package database;

import java.sql.*;

public class DBConnect {
    private String url, user, pswd, driver;
    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;
    
    public DBConnect() {
		this.url = "jdbc:mysql://104.197.233.39:3306/ssdSystem?autoReconnect=true&useSSL=false";
        this.user = "root";
        this.pswd = "ssdapp";
        this.driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            dbConn = DriverManager.getConnection(url, user, pswd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Statement createStatement() throws SQLException {
        this.stmt = dbConn.createStatement();
        return stmt;
    }
    
    public ResultSet query(String query) throws SQLException {
        this.rs = createStatement().executeQuery(query);
        return rs;
    }
    
    public void update(String query) throws SQLException {
        createStatement().executeUpdate(query);
    }
    
    public void close() throws SQLException {
        stmt.close();
        dbConn.close();
    }
    
    public static void main(String[] args) {
        }
}
