package cn.yzking.extension;

import java.sql.Connection;

/**
 * Created by Yanziqing25
 */
public interface Database {
    String getName();
    boolean connect();
    Connection createConnection();
    boolean isConnect();
    boolean close();
    Connection getConnection();
}