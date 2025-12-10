package me.yourname.admincode;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class AdminCodePlugin extends JavaPlugin {

    private static AdminCodePlugin instance;
    private CodeManager codeManager;
    private FileConfiguration messages;

    @Override
    public void onEnable() {
        instance = this;

        // Lưu cấu hình mặc định
        saveDefaultConfig();

        // Tải messages.yml
        loadMessages();

        // Tạo và load CodeManager
        codeManager = new CodeManager(this);
        codeManager.load();

        // Đăng ký command
        getCommand("admincode").setExecutor(new AdminCodeCommand(this));
        getCommand("code").setExecutor(new CodePlayerCommand(this));

        // Đăng ký listener
        getServer().getPluginManager().registerEvents(new RedeemInventoryListener(), this);

        // In bản quyền plugin khi bật
        printCopyright();
    }

    @Override
    public void onDisable() {
        codeManager.save();
    }

    public static AdminCodePlugin getInstance() {
        return instance;
    }

    public CodeManager getCodeManager() {
        return codeManager;
    }

    public FileConfiguration getMessages() {
        return messages;
    }

    // Tải file messages.yml
    private void loadMessages() {
        File file = new File(getDataFolder(), "messages.yml");
        if (!file.exists()) {
            saveResource("messages.yml", false);
        }
        messages = YamlConfiguration.loadConfiguration(file);
    }

    // In thông tin bản quyền
    private void printCopyright() {
        getLogger().info("====================================");
        getLogger().info("  AdminCode Plugin - Custom Edition ");
        getLogger().info("  Author: pnhuy08");
        getLogger().info("  Server: BoxPvP");
        getLogger().info("====================================");
    }
}
