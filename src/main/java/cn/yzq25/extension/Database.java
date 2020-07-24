package cn.yzq25.extension;

import java.sql.Connection;

/**
 * Created by Yanziqing25
 */
public interface Database {
    String getName();
    boolean connect();
    boolean isConnect();
    boolean close();
    Connection getConnection();
}