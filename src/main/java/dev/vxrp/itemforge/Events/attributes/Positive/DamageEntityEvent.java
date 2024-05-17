package dev.vxrp.itemforge.Events.attributes.Positive;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.ATTRIBUTES;
import dev.vxrp.itemforge.config.CONFIG;
import dev.vxrp.itemforge.util.DataStorage.RetrieveStoredData;
import dev.vxrp.itemforge.util.MaterialTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.*;

public class DamageEntityEvent implements Listener {
    //Hashmaps
    Map<UUID, Long> savedTime = new HashMap<>();
    Map<UUID, Long> lastDamage = new HashMap<>();

    private final ItemForge plugin;
    public DamageEntityEvent(ItemForge itemForge) {
        this.plugin = itemForge;
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) return;
        Player player = (Player) event.getEntity();
        EntityDamageEvent.DamageCause damageCause = event.getCause();

        //Hot Metal
        if (damageCause == EntityDamageEvent.DamageCause.FIRE || damageCause == EntityDamageEvent.DamageCause.FIRE_TICK) {
            if (Boolean.TRUE.equals(RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), new NamespacedKey(plugin, ATTRIBUTES.POSITIVE_ATTRIBUTES), ATTRIBUTES.POSITIVE.HOT_METAL))) {
                savedTime.putIfAbsent(player.getUniqueId(), System.currentTimeMillis());
                lastDamage.putIfAbsent(player.getUniqueId(), System.currentTimeMillis());

                if (System.currentTimeMillis() - lastDamage.get(player.getUniqueId()) >= plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HOT_METAL_COOLDOWN)*1000L) {
                    savedTime.put(player.getUniqueId(), System.currentTimeMillis());
                }
                if (System.currentTimeMillis() - savedTime.get(player.getUniqueId()) <= plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HOT_METAL_TIME_UNTIL_DAMAGING)* 1000L) {
                    long mTime = System.currentTimeMillis()  - savedTime.get(player.getUniqueId());
                    player.sendActionBar(MiniMessage.miniMessage().deserialize("<gray> Time left until damaging - <red>" + (plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HOT_METAL_TIME_UNTIL_DAMAGING)*1000L - mTime)/1000));
                    event.setCancelled(true);

                } else {
                    player.sendActionBar(MiniMessage.miniMessage().deserialize("<gray> Cooldown will reset in - <red>" + plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HOT_METAL_COOLDOWN)));
                }
                lastDamage.put(player.getUniqueId(), System.currentTimeMillis());
            }

        }
        //Hard Shell
        if (damageCause == EntityDamageEvent.DamageCause.PROJECTILE) {
            if (Boolean.TRUE.equals(RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), new NamespacedKey(plugin, ATTRIBUTES.POSITIVE_ATTRIBUTES), ATTRIBUTES.POSITIVE.HARD_SHELL))) {
                if (!getChance(plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HARD_SHELL_CHANCE_OF_AVOIDING))) return;
                event.setCancelled(true);
            }
        }
        //Gliding
        if (damageCause == EntityDamageEvent.DamageCause.ENTITY_ATTACK || damageCause == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {
            if (!MaterialTypes.swords().contains(player.getInventory().getItemInMainHand().getType())) return;
            if (Boolean.TRUE.equals(RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), new NamespacedKey(plugin, ATTRIBUTES.POSITIVE_ATTRIBUTES), ATTRIBUTES.POSITIVE.GLIDING))) {
                if (!getChance(plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_GLIDING_CHANCE_OF_AVOIDING))) return;
                event.setCancelled(true);
            }
        }
    }
    public boolean getChance(int minimalChance) {
        Random random = new Random();
        return random.nextInt(99) + 1 >= minimalChance;
    }
}