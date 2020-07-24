package cn.yzq25.extension;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yanziqing25
 */
public abstract class RelationalDatabase implements Database {
    protected String host;
    protected int port;
    protected String database;
    protected String username;
    protected String password;
    protected Connection connection;

    public RelationalDatabase(String host, int port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean isConnect() {
        if (getConnection() == null) {
            return false;
        }
        try {
            return getConnection().isValid(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public boolean close() {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean executeSQL(String sql) {
        if (!isConnect()) {
            connect();
        }
        try {
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            return preparedstatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet executeQuery(String sql) {
        if (!isConnect()) {
            connect();
        }
        try {
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            return preparedstatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}