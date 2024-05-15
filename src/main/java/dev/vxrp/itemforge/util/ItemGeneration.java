package dev.vxrp.itemforge.util;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemGeneration {
    public static ItemStack weapon(Material material, Player player) {
        return new ItemBuilder(material)
                .lore(MiniMessage.miniMessage().deserialize("<italic><gray>Created by - " + player.getName() + "<gray><italic>"))
                .build();
    }
}
