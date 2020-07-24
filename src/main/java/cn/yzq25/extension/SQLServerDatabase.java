package cn.yzq25.extension;

import java.sql.DriverManager;

/**
 * Created by Yanziqing25
 */
public class SQLServerDatabase extends RelationalDatabase {

    public SQLServerDatabase(String host, int port, String database, String username, String password) {
        super(host, port, database, username, password);
    }

    @Override
    public String getName() {
        return "SQLServer";
    }

    @Override
    public boolean connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection("jdbc:sqlserver://" + this.host + ":" + this.port + ";DatabaseName=" + this.database, this.username, this.password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
