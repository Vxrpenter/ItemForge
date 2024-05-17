package dev.vxrp.itemforge.Events.attributes.Positive;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.ATTRIBUTES;
import dev.vxrp.itemforge.util.DataStorage.RetrieveStoredData;
import dev.vxrp.itemforge.util.MaterialTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmorChangeEvent implements Listener {
    private final ItemForge plugin;
    public ArmorChangeEvent(ItemForge itemForge) {
        this.plugin = itemForge;
    }

    @EventHandler
    public void onChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, PotionEffect.INFINITE_DURATION, 0, false, false);

        if (Boolean.TRUE.equals(RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), new NamespacedKey(plugin, ATTRIBUTES.POSITIVE_ATTRIBUTES), ATTRIBUTES.POSITIVE.PRIDE))) {
            player.addPotionEffect(effect);
        } else {
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
    }
}
