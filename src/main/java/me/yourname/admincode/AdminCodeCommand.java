
package me.yourname.admincode;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class AdminCodeCommand implements CommandExecutor {

    private final AdminCodePlugin plugin;

    public AdminCodeCommand(AdminCodePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage("Only in-game."); return true; }
        Player p = (Player) sender;

        CodeManager m = plugin.getCodeManager();

        if (args.length == 0) {
            p.sendMessage("/admincode create <id>");
            p.sendMessage("/admincode gui <id>");
            return true;
        }

        String sub = args[0].toLowerCase();

        if (sub.equals("create")) {
            if (args.length < 2) { p.sendMessage("Thiếu id"); return true; }
            String id = args[1].toLowerCase();
            if (m.getCode(id) != null) { p.sendMessage("Đã tồn tại"); return true; }
            m.create(id);
            p.sendMessage("Đã tạo code " + id);
            return true;
        }

        if (sub.equals("gui")) {
            if (args.length < 2) { p.sendMessage("Thiếu id"); return true; }
            String id = args[1].toLowerCase();
            Code c = m.getCode(id);
            if (c == null) { p.sendMessage("Không tồn tại"); return true; }
            new CodeEditorGUI(c).open(p);
            return true;
        }

        return true;
    }
}
