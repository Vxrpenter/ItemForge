package dev.vxrp.itemforge.Events.attributes.Positive;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.ATTRIBUTES;
import dev.vxrp.itemforge.util.DataStorage.RetrieveStoredData;
import dev.vxrp.itemforge.util.MaterialTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementEvent implements Listener {
    private final ItemForge plugin;
    public MovementEvent(ItemForge itemForge) {
        this.plugin = itemForge;
    }
    @EventHandler
    public void onMovement(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (Boolean.TRUE.equals(RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), new NamespacedKey(plugin, ATTRIBUTES.POSITIVE_ATTRIBUTES), ATTRIBUTES.POSITIVE.AGILITY))) {
            player.setWalkSpeed(0.25F);
        } else {
            player.setWalkSpeed(0.2F);
        }
    }
}
