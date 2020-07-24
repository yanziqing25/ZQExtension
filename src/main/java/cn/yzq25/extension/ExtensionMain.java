package cn.yzq25.extension;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.yzq25.utils.ZQUtils;

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
        if (getConfig().getBoolean("check_update", true)) {
            ZQUtils.checkPluginUpdate(this);
        }
        this.storageMode = getConfig().getString("storage_mode", "default");
        switch (this.storageMode) {
            case "mysql":
                database = new MySQLDatabase(getConfig().getString("host"), getConfig().getInt("port"), getConfig().getString("database"), getConfig().getString("username"), getConfig().getString("password"));
                break;
            case "sqlserver":
                database = new SQLServerDatabase(getConfig().getString("host"), getConfig().getInt("port"), getConfig().getString("database"), getConfig().getString("username"), getConfig().getString("password"));
                break;
            case "default":
                database = null;
                break;
            default:
                database = null;
                break;
        }
        if (database != null) {
            if (database.connect()) {
                getLogger().info(TextFormat.GOLD + database.getName() + "连接成功!");
            } else {
                getLogger().info(TextFormat.RED + database.getName() + "连接失败!");
            }
        }
        getLogger().info(TextFormat.GREEN + "拓展加载成功! By:Yanziqing25");
    }

    @Override
    public void onDisable() {
        if (database != null && database.isConnect()) {
            if (database.close()) {
                getLogger().info(TextFormat.RED + database.getName() + "连接已关闭!");
            }
        }
        getLogger().info(TextFormat.RED + "插件已关闭!");
    }

    public static ExtensionMain getInstance() {
        return instance;
    }

    public static Database getDatabase() {
        return database;
    }
}