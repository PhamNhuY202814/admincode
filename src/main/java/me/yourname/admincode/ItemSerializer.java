
package me.yourname.admincode;

import org.bukkit.inventory.ItemStack;
import java.io.*;
import java.util.Base64;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.bukkit.util.io.BukkitObjectInputStream;

public class ItemSerializer {

    public static String itemToBase64(ItemStack item) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOut = new BukkitObjectOutputStream(out);
            dataOut.writeObject(item);
            dataOut.close();
            return Base64.getEncoder().encodeToString(out.toByteArray());
        } catch (Exception e) { return null; }
    }

    public static ItemStack base64ToItem(String base64) {
        try {
            byte[] data = Base64.getDecoder().decode(base64);
            ObjectInputStream in = new BukkitObjectInputStream(new ByteArrayInputStream(data));
            ItemStack item = (ItemStack) in.readObject();
            in.close();
            return item;
        } catch (Exception e) { return null; }
    }
}
