package dev.vxrp.itemforge.util.attributes;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.util.peristentdatastorage.PersistentDataStorageUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomAttributesLore {
    public static MiniMessage mm = MiniMessage.miniMessage();
    //Positive Armor Attributes
    public static List<Component> agility() {
        return Arrays.asList(mm.deserialize("<yellow>Agility <gray>- Lighter armor provides better"),
                mm.deserialize("<gray>movement speed"));}
    public static List<Component> pride() {
        return Arrays.asList(mm.deserialize("<color:#ffd700>Pride <gray>- Everyone is just looking at you"),
                mm.deserialize("<gray>leading to you gaining some more strength"));}
    public static List<Component> hardShell() {
        return Arrays.asList(mm.deserialize("<color:#bf5d37>Hard Shell <gray>- Projectiles are more likely to bounce off"),
                mm.deserialize("<gray>then to pierce you"));}
    public static List<Component> hotMetal() {
        return Arrays.asList(mm.deserialize("<red>Hot Metal <gray>- Fire doesn't affect you anymore"),
                mm.deserialize("<gray>if you can extinguish it fast enough"));}
    public static List<Component> gliding() {
        return List.of(mm.deserialize("<white>Gliding <gray>- Swords may glide off your armor"));}

    //Negative Armor Attributes
    public static List<Component> flamable() {
        return Arrays.asList(mm.deserialize("<color:#ffa500>Flamable <gray>- Items that easily catch on fire"),
                mm.deserialize("<gray>should be kept wet"));}
    public static List<Component> slowing() {
        return Arrays.asList(mm.deserialize("<color:#2a2a2a>Slowing <gray>- Heavy armor or weaponry make movement"),
                mm.deserialize("<gray>much more difficult"));}
    public static List<Component> soft() {
        return List.of(mm.deserialize("<color:#fa8072>Soft <gray>- Easily deformable"));}
    public static List<Component> aHoleInTheWall() {
        return List.of(mm.deserialize("<color:#a52a2a>A Hole in the Wall <gray>- Projectiles glide through your armor"));}

    //Adding Lore
    public static ItemStack addLore(ItemForge plugin, ItemStack item) {
        String positiveAttributes = PersistentDataStorageUtil.RetrieveStoredData.retrieveString(item, new NamespacedKey(plugin, "positive_attributes"));
        String negativeAttributes = PersistentDataStorageUtil.RetrieveStoredData.retrieveString(item, new NamespacedKey(plugin, "negative_attributes"));

        if (positiveAttributes != null || negativeAttributes != null) {
            assert positiveAttributes != null;
            assert negativeAttributes != null;
            List<String> posAttributes = new ArrayList<>(Arrays.asList(positiveAttributes.split(",")));
            List<String> negAttributes = new ArrayList<>(Arrays.asList(negativeAttributes.split(",")));
            //Lore list
            List<Component> lore = new ArrayList<>();
            //Positive Armor Attributes
            lore.add(mm.deserialize("<gray>(<green>+<gray>) Advantages:"));
            lore.add(Component.text(" "));
            if (positiveAttributes.contains("attribute.agility")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<yellow>Agility <gray>- extra speed"));
                } else {
                    lore.addAll(agility());
                    lore.add(Component.text(" "));
                }
            }
            if (positiveAttributes.contains("attribute.pride")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<color:#ffd700>Pride <gray>- extra strenght"));
                } else {
                    lore.addAll(pride());
                    lore.add(Component.text(" "));
                }
            }
            if (positiveAttributes.contains("attribute.hardShell")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<color:#bf5d37>Hard Shell <gray>- chance to avoid projectiles"));
                } else {
                    lore.addAll(hardShell());
                    lore.add(Component.text(" "));
                }
            }
            if (positiveAttributes.contains("attribute.hotMetal")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<red>Hot Metal <gray>- chance to avoid fire damage"));
                } else {
                    lore.addAll(hotMetal());
                    lore.add(Component.text(" "));
                }
            }
            if (positiveAttributes.contains("attribute.gliding")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<white>Gliding <gray>- chance to avoid sword hits"));
                } else {
                    lore.addAll(gliding());
                }
                lore.add(Component.text(" "));
            }
            //Negative Armor Attributes
            lore.add(mm.deserialize("<gray>(<red>-<gray>) Disadvantages:"));
            lore.add(Component.text(" "));
            if (negativeAttributes.contains("attribute.flamable")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<color:#ffa500>Flamable <gray>- extra fire damage"));
                } else {
                    lore.addAll(flamable());
                    lore.add(Component.text(" "));
                }
            }
            if (negativeAttributes.contains("attribute.slowing")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<color:#2a2a2a>Slowing <gray>- extra slowness"));
                } else {
                    lore.addAll(slowing());
                    lore.add(Component.text(" "));
                }
            }
            if (negativeAttributes.contains("attribute.soft")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<color:#fa8072>Soft <gray>- you are more fragile"));
                } else {
                    lore.addAll(soft());
                    lore.add(Component.text(" "));
                }
            }
            if (negativeAttributes.contains("attribute.aHoleInTheWall")) {
                if (posAttributes.size() > 3 || negAttributes.size() > 3) {
                    lore.add(mm.deserialize("<color:#a52a2a>A Hole in the Wall <gray>- projectiles do more damage"));
                } else {
                    lore.addAll(aHoleInTheWall());
                }
            }
            item.lore(lore);
            return item;
        }
        return item;
    }
}
