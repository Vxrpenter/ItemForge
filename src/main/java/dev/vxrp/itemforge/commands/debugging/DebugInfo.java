package dev.vxrp.itemforge.commands.debugging;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DebugInfo implements CommandExecutor {
    public static Map<UUID, Boolean> showDamageInfo = new HashMap<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Debug Tools: <red>show_damage_info"));
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
            }
        }
        return false;
    }
}
