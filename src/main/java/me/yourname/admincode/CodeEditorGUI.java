
package me.yourname.admincode;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.*;
import org.bukkit.inventory.*;

public class CodeEditorGUI implements Listener {

    private final Code code;
    private final Inventory inv;

    public CodeEditorGUI(Code code) {
        this.code = code;
        this.inv = Bukkit.createInventory(null, 27, "Chỉnh code " + code.getId());

        for (String base64 : code.getItemsBase64()) {
            ItemStack item = ItemSerializer.base64ToItem(base64);
            if (item != null) inv.addItem(item);
        }

        Bukkit.getPluginManager().registerEvents(this, AdminCodePlugin.getInstance());
    }

    public void open(Player p) { p.openInventory(inv); }

    @EventHandler
    public void click(InventoryClickEvent e) {
        if (e.getInventory() != inv) return;

        Bukkit.getScheduler().runTaskLater(AdminCodePlugin.getInstance(), () -> {
            code.getItemsBase64().clear();
            for (ItemStack it : inv.getContents()) {
                if (it != null && it.getType() != Material.AIR) {
                    code.getItemsBase64().add(ItemSerializer.itemToBase64(it));
                }
            }
            AdminCodePlugin.getInstance().getCodeManager().save();
        }, 1);
    }
}
