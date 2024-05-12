package dev.vxrp.itemforge.Events.debugging;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.commands.debugging.DebugInfo;
import dev.vxrp.itemforge.config.CONFIG;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class DamageDealDebug implements Listener {
    private final ItemForge plugin;
    public DamageDealDebug(ItemForge itemForge) {
        this.plugin = itemForge;
    }
    @EventHandler
    public void OnDamageDeal(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() != EntityType.PLAYER) return;
        Player player = (Player) event.getDamager();
        double damage;

        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            DebugInfo.showDamageInfo.putIfAbsent(player.getUniqueId(), false);
            if (!DebugInfo.showDamageInfo.get(player.getUniqueId())) return;
            //Durability
            ItemStack item = player.getInventory().getItemInMainHand();
            Damageable damageable = (Damageable) item.getItemMeta();
            double durability = damageable.getDamage();
            double percent = durability/item.getType().getMaxDurability() * 100;

            double statePercentI = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_I_PERCENT);
            double statePercentII = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_II_PERCENT);
            double statePercentIII = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_III_PERCENT);


            if (percent <= statePercentI) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_I_REDUCED_DAMAGE)/100;
                player.sendMessage(Component
                        .text("--- State 1 |" + percent + " ---", NamedTextColor.RED));
                player.sendMessage(String.valueOf(damage));
            }
            if (percent <= statePercentII && percent > statePercentI) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_II_REDUCED_DAMAGE)/100;
                player.sendMessage(Component
                        .text("--- State 2 |" + percent +  " ---", NamedTextColor.RED));
                player.sendMessage(String.valueOf(damage));
            }
            if (percent <= statePercentIII && percent > statePercentII || percent > statePercentIII) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_III_REDUCED_DAMAGE)/100;
                player.sendMessage(Component
                        .text("--- State 3 |" + percent +  " ---", NamedTextColor.RED));
                player.sendMessage(String.valueOf(damage));
            }
        }
    }
}
