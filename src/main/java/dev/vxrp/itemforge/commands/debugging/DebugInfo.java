package dev.vxrp.itemforge.commands.debugging;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.util.peristentdatastorage.RetrieveStoredData;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DebugInfo implements CommandExecutor {
    private final ItemForge plugin;
    public DebugInfo(ItemForge itemForge) {
        this.plugin = itemForge;
    }
    public static Map<UUID, Boolean> showDamageInfo = new HashMap<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length == 0) {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Debug Tools: <red>show_damage_info<gray>, <red>show_custom_attributes"));
        } else {
            if (args[0].equals("show_damage_info")) {
                showDamageInfo.putIfAbsent(player.getUniqueId(), false);
                if (args[1].equals("true")) {
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Changed show_damage_info to <green>true"));
                    showDamageInfo.put(player.getUniqueId(), true);
                }
                if (args[1].equals("false")) {
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Changed show_damage_info to <red>false"));
                    showDamageInfo.put(player.getUniqueId(), false);
                }
            }
            if (args[0].equals("show_custom_attributes")) {
                if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
                    player.sendMessage(Component.text("You have to hold an item in your hand to get this info", NamedTextColor.RED));
                    return false;
                }
                player.sendMessage(Component.text(" "));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Item: <red>" + player.getInventory().getItemInMainHand().getType()));
                player.sendMessage(Component.text(" "));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Positive Attributes: <red>" + RetrieveStoredData.retrieveString(player.getInventory().getItemInMainHand(),
                        new NamespacedKey(plugin, "positive_attributes"))));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Negative Attributes: <red>" + RetrieveStoredData.retrieveString(player.getInventory().getItemInMainHand(),
                        new NamespacedKey(plugin, "negative_attributes"))));
            }
        }
        return false;
    }
}
