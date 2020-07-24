package cn.yzq25.extension;

import java.sql.DriverManager;

/**
 * Created by Yanziqing25
 */
public class MySQLDatabase extends RelationalDatabase {

    public MySQLDatabase(String host, int port, String database, String username, String password) {
        super(host, port, database, username, password);
    }

    @Override
    public String getName() {
        return "MySQL";
    }

    @Override
    public boolean connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?" + "user=" + this.username + "&password=" + this.password + "&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
