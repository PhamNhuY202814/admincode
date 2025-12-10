
package me.yourname.admincode;

import org.bukkit.configuration.file.FileConfiguration;
import java.util.*;

public class CodeManager {

    private final AdminCodePlugin plugin;
    private final Map<String, Code> codes = new HashMap<>();

    public CodeManager(AdminCodePlugin plugin) {
        this.plugin = plugin;
    }

    public Map<String, Code> getCodes() { return codes; }

    public Code getCode(String id) { return codes.get(id); }

    public Code create(String id) {
        Code c = new Code(id);
        codes.put(id, c);
        save();
        return c;
    }

    public void load() {
        codes.clear();
        FileConfiguration c = plugin.getConfig();
        if (!c.isConfigurationSection("codes")) return;

        for (String id : c.getConfigurationSection("codes").getKeys(false)) {
            Code code = new Code(id);
            code.getItemsBase64().addAll(c.getStringList("codes." + id + ".items"));
            code.getUsedPlayers().addAll(c.getStringList("codes." + id + ".players"));
            code.getUsedIps().addAll(c.getStringList("codes." + id + ".ips"));
            codes.put(id, code);
        }
    }

    public void save() {
        FileConfiguration c = plugin.getConfig();
        c.set("codes", null);

        for (String id : codes.keySet()) {
            Code code = codes.get(id);
            c.set("codes." + id + ".items", code.getItemsBase64());
            c.set("codes." + id + ".players", new ArrayList<>(code.getUsedPlayers()));
            c.set("codes." + id + ".ips", new ArrayList<>(code.getUsedIps()));
        }

        plugin.saveConfig();
    }
}
