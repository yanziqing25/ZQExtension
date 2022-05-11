package cn.yzking.extension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yanziqing25
 */
public class MySQLDatabase extends RelationalDatabase {
    public MySQLDatabase(String host, int port, String database, String username, String password, Map<String, String> params) {
        super(host, port, database, username, password, params);
    }
    public MySQLDatabase(String host, int port, String database, String username, String password) {
        this(host, port, database, username, password, new HashMap<>());
    }

    @Override
    public String getName() {
        return "MySQL";
    }

    @Override
    public boolean connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            StringBuilder connectURLBuilder = new StringBuilder("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database);
            if (!this.params.isEmpty()) {
                connectURLBuilder.append("?");
                this.params.forEach((k,v) -> connectURLBuilder.append(k).append("=").append(v).append("&"));
                connectURLBuilder.deleteCharAt(connectURLBuilder.length() - 1);
            }
            this.connection = DriverManager.getConnection(connectURLBuilder.toString(), this.username, this.password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            StringBuilder connectURLBuilder = new StringBuilder("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database);
            if (!this.params.isEmpty()) {
                connectURLBuilder.append("?");
                this.params.forEach((k,v) -> connectURLBuilder.append(k).append("=").append(v).append("&"));
                connectURLBuilder.deleteCharAt(connectURLBuilder.length() - 1);
            }
            return DriverManager.getConnection(connectURLBuilder.toString(), this.username, this.password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
