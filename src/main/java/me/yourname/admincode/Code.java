
package me.yourname.admincode;

import java.util.*;

public class Code {

    private final String id;
    private final List<String> itemsBase64 = new ArrayList<>();
    private final Set<String> usedPlayers = new HashSet<>();
    private final Set<String> usedIps = new HashSet<>();

    public Code(String id) {
        this.id = id.toLowerCase();
    }

    public String getId() { return id; }

    public List<String> getItemsBase64() { return itemsBase64; }

    public Set<String> getUsedPlayers() { return usedPlayers; }

    public Set<String> getUsedIps() { return usedIps; }
}
