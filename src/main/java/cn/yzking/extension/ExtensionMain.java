package cn.yzking.extension;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.yzking.utils.ZQUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yanziqing25
 */
public class ExtensionMain extends PluginBase {
    private String storageMode;
    private static Database database;
    private static ExtensionMain instance;

    @Override
    public void onLoad() {
        instance = this;
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        if (getConfig().getBoolean("check_update", true)) ZQUtils.checkPluginUpdate(this);
        this.storageMode = getConfig().getString("storage_mode", "local").toLowerCase();
        Map<String, String> params = (Map<String, String>) getConfig().get("params");
        if (params == null) params = new HashMap<>();
        switch (this.storageMode) {
            case "mysql" ->{
                params.put("rewriteBatchedStatements", "true");
                database = new MySQLDatabase(getConfig().getString("host"), getConfig().getInt("port"), getConfig().getString("database"), getConfig().getString("username"), getConfig().getString("password"), params);
            }
            case "sqlserver" ->
                    database = new SQLServerDatabase(getConfig().getString("host"), getConfig().getInt("port"), getConfig().getString("database"), getConfig().getString("username"), getConfig().getString("password"), params);
            default -> database = null;
        }
        if (database != null) {
            if (database.connect()) {
                getLogger().info(TextFormat.GOLD + database.getName() + "连接成功！");
            } else {
                getLogger().info(TextFormat.RED + database.getName() + "连接失败！");
            }
        }
        getLogger().info(TextFormat.GREEN + "拓展加载成功！By:YzKing");
    }
    @Override
    public void onDisable() {
        if (database != null && database.isConnect() && database.close()) getLogger().info(TextFormat.RED + database.getName() + "连接已关闭!");
        getLogger().info(TextFormat.RED + "插件已关闭!");
    }

    public static ExtensionMain getInstance() {
        return instance;
    }

    public static Database getDatabase() {
        return database;
    }

    public String getStorageMode() {
        return this.storageMode;
    }
}