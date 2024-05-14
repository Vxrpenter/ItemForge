package dev.vxrp.itemforge.Events;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.CONFIG;
import org.bukkit.Material;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class DamageDealEvent implements Listener {
    private final ItemForge plugin;
    public DamageDealEvent(ItemForge itemForge) {
        this.plugin = itemForge;
    }

    @EventHandler
    public void OnDamageDeal(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() != EntityType.PLAYER) return;
        Player player = (Player) event.getDamager();
        double damage;
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            //Durability
            ItemStack item = player.getInventory().getItemInMainHand();
            Damageable damageable = (Damageable) item.getItemMeta();
            double percent = (double) damageable.getDamage()/item.getType().getMaxDurability() * 100;

            double statePercentI = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_I_PERCENT);
            double statePercentII = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_II_PERCENT);
            double statePercentIII = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_III_PERCENT);


            if (percent <= statePercentI) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_I_REDUCED_DAMAGE)/100;
                event.setDamage(damage);
            }
            if (percent <= statePercentII && percent > statePercentI) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_II_REDUCED_DAMAGE)/100;
                event.setDamage(damage);
            }
            if (percent <= statePercentIII && percent > statePercentII || percent > statePercentIII) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_III_REDUCED_DAMAGE)/100;
                event.setDamage(damage);
            }
            //Effects
            if (plugin.getConfig().getBoolean(CONFIG.EFFECTS.ACTIVATE_RANDOM_EFFECTS)) {
                if (event.getEntity().getType() == EntityType.PLAYER) {
                    Player victim = (Player) event.getEntity();

                    int random = ThreadLocalRandom.current().nextInt(1,
                            Objects.requireNonNull(plugin.getConfig().getList(CONFIG.EFFECTS.RANDOM_EFFECTS)).size() + 1);
                    int duration = ThreadLocalRandom.current().nextInt(plugin.getConfig().getInt(CONFIG.EFFECTS.DURATION_VALUE_I),
                            plugin.getConfig().getInt(CONFIG.EFFECTS.DURATION_VALUE_II) + 1);
                    int amplifier = ThreadLocalRandom.current().nextInt(1, plugin.getConfig().getInt(CONFIG.EFFECTS.AMPLIFIER_MAX) + 1);

                    victim.addPotionEffect(new PotionEffect((PotionEffectType)
                            Objects.requireNonNull(plugin.getConfig().getList(CONFIG.EFFECTS.RANDOM_EFFECTS)).get(random),
                            duration,amplifier, true, false));
                }
            }
        } else {
            damage = ThreadLocalRandom.current().nextDouble(1.0, 2.0);
            event.setDamage(damage);
        }
    }
}