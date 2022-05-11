package cn.yzking.extension;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yanziqing25
 */
public abstract class RelationalDatabase implements Database {
    protected String host;
    protected int port;
    protected String database;
    protected String username;
    protected String password;
    protected Map<String, String> params;
    protected Connection connection;

    public RelationalDatabase(String host, int port, String database, String username, String password, Map<String, String> params) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        this.params = params;
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

    public boolean executeSQL(String sql, Object... params) {
        if (!isConnect()) connect();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void executeBatchSQL(String sql, Set<Object[]> sqls) {
        Connection conn = createConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            for (Object[] params : sqls) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
                ps.addBatch();
            }
            ps.executeBatch();
            ps.clearBatch();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<Map<String, Object>> executeQuery(String sql, Object... params) {
        Set<Map<String, Object>> dataSet = new HashSet<>();
        if (!isConnect()) connect();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData(); //获取字段名
            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowData.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                dataSet.add(rowData);
            }
            rs.close();
            return dataSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return dataSet;
        }
    }
}