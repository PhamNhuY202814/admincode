
package me.yourname.admincode;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

public class CodePlayerCommand implements CommandExecutor {

    private final AdminCodePlugin plugin;

    public CodePlayerCommand(AdminCodePlugin plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage("Chỉ ingame"); return true; }
        Player p = (Player) sender;

        if (args.length < 1) { p.sendMessage("/code <id>"); return true; }

        String id = args[0].toLowerCase();
        Code code = plugin.getCodeManager().getCode(id);

        if (code == null) { p.sendMessage("Không tồn tại."); return true; }

        String uuid = p.getUniqueId().toString();
        String ip = p.getAddress().getAddress().getHostAddress();

        if (code.getUsedPlayers().contains(uuid) || code.getUsedIps().contains(ip)) {
            p.sendMessage("Bạn đã dùng mã này rồi!");
            return true;
        }

        for (String base64 : code.getItemsBase64()) {
            ItemStack item = ItemSerializer.base64ToItem(base64);
            if (item != null) p.getInventory().addItem(item);
        }

        code.getUsedPlayers().add(uuid);
        code.getUsedIps().add(ip);

        plugin.getCodeManager().save();

        p.sendMessage("§aĐã nhận thưởng!");
        return true;
    }
}
