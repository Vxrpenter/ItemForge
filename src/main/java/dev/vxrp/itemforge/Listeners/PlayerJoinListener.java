package dev.vxrp.itemforge.Listeners;

import dev.vxrp.itemforge.commands.debugging.DebugInfo;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void OnPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("itemforge.debug.show_damage_info")) {
            DebugInfo.showDamageInfo.putIfAbsent(event.getPlayer().getUniqueId(), false);
        }
    }
}