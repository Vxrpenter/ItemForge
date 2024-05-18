package dev.vxrp.itemforge.Listeners.attributes;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.ATTRIBUTES;
import dev.vxrp.itemforge.config.CONFIG;
import dev.vxrp.itemforge.util.dataStorage.RetrieveStoredData;
import dev.vxrp.itemforge.util.MaterialTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEntityListener implements Listener {
    private final ItemForge plugin;
    public DamageEntityListener(ItemForge itemForge) {
        this.plugin = itemForge;
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Player player = (Player) event.getEntity();
        EntityDamageEvent.DamageCause damageCause = event.getCause();

        //Flamable
        if (damageCause == EntityDamageEvent.DamageCause.FIRE || damageCause == EntityDamageEvent.DamageCause.FIRE_TICK) {
            if (Boolean.TRUE.equals(RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), new NamespacedKey(plugin, ATTRIBUTES.NEGATIVE_ATTRIBUTES), ATTRIBUTES.NEGATIVE.FLAMABLE))) {
                event.setDamage(event.getDamage()*plugin.getConfig().getDouble(CONFIG.ATTRIBUTES.ATTRIBUTE_FLAMABLE_DAMAGE_INCREASE));
            }
        }
    }
}
