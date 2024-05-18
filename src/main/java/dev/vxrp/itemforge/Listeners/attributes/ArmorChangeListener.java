package dev.vxrp.itemforge.Listeners.attributes;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.ATTRIBUTES;
import dev.vxrp.itemforge.config.CONFIG;
import dev.vxrp.itemforge.util.dataStorage.RetrieveStoredData;
import dev.vxrp.itemforge.util.MaterialTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmorChangeListener implements Listener {
    private final ItemForge plugin;
    public ArmorChangeListener(ItemForge itemForge) {
        this.plugin = itemForge;
    }

    @EventHandler
    public void onChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        int strenghtAmplifier = plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_PRIDE_STRENGHT_LEVEL);
        int speedAmplifier = plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_AGILITY_SPEED_LEVEL);

        if (Boolean.TRUE.equals(RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), new NamespacedKey(plugin, ATTRIBUTES.POSITIVE_ATTRIBUTES), ATTRIBUTES.POSITIVE.PRIDE))) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, PotionEffect.INFINITE_DURATION, strenghtAmplifier-1, false, false));
        } else {
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
        if (Boolean.TRUE.equals(RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), new NamespacedKey(plugin, ATTRIBUTES.POSITIVE_ATTRIBUTES), ATTRIBUTES.POSITIVE.AGILITY))) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, speedAmplifier-1, false, false));
        } else {
            player.removePotionEffect(PotionEffectType.SPEED);
        }
    }
}
