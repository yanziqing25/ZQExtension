package cn.yzking.extension.task;

import cn.nukkit.plugin.Plugin;
import cn.nukkit.scheduler.PluginTask;
import cn.yzking.extension.ExtensionMain;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CheckPluginUpdateTask extends PluginTask<ExtensionMain> {
    private final Plugin plugin;
    public CheckPluginUpdateTask(ExtensionMain main, Plugin plugin) {
        super(main);
        this.plugin = plugin;
    }

    private static JsonObject getPluginJsonObject(Plugin plugin) {
        try {
            URL url = new URL("https://www.yzking.cn/plugins/nk/" + plugin.getName() + "/" + plugin.getName() +  ".json");
            url.openConnection().setConnectTimeout(30000); // 30秒
            url.openConnection().setReadTimeout(30000); // 30秒
            InputStreamReader inr = new InputStreamReader(url.openConnection().getInputStream(), StandardCharsets.UTF_8);
            JsonObject res = JsonParser.parseReader(inr).getAsJsonObject();
            inr.close();
            return res;
        } catch (IOException e) {
            return new JsonObject();
        }
    }

    @Override
    public void onRun(int currentTick) {
        JsonObject jsonObject = getPluginJsonObject(plugin);
        if (jsonObject.isJsonNull()) ExtensionMain.getInstance().getLogger().warning("[" + plugin.getName() + "]" + "插件更新检查失败！");
        else {
            String version = jsonObject.get("version").getAsString();
            String link = jsonObject.get("link").getAsString();
            String description = jsonObject.get("description").getAsString();

            if (!plugin.getDescription().getVersion().equals(version)) {
                ExtensionMain.getInstance().getLogger().info("§e[" + plugin.getName() + "]插件最新版本: §b" + version + "\n§e下载地址：§a" + link + "\n更新内容：§6" + description);
            } else {
                ExtensionMain.getInstance().getLogger().info("§a[" + plugin.getName() + "]插件已是最新版本！");
            }
        }
    }
}