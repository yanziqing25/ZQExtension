package cn.yzking.extension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yanziqing25
 */
public class SQLServerDatabase extends RelationalDatabase {
    public SQLServerDatabase(String host, int port, String database, String username, String password, Map<String, String> params) {
        super(host, port, database, username, password, params);
    }
    public SQLServerDatabase(String host, int port, String database, String username, String password) {
        this(host, port, database, username, password, new HashMap<>());
    }

    @Override
    public String getName() {
        return "SQLServer";
    }

    @Override
    public boolean connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            StringBuilder connectURLBuilder = new StringBuilder("jdbc:sqlserver://" + this.host + ":" + this.port + ";database=" + this.database + ";");
            this.params.forEach((k,v) -> connectURLBuilder.append(k).append("=").append(v).append(";"));
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
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            StringBuilder connectURLBuilder = new StringBuilder("jdbc:sqlserver://" + this.host + ":" + this.port + ";database=" + this.database + ";");
            this.params.forEach((k,v) -> connectURLBuilder.append(k).append("=").append(v).append(";"));
            return DriverManager.getConnection(connectURLBuilder.toString(), this.username, this.password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
