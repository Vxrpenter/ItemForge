package dev.vxrp.itemforge.config;

public final class CONFIG {
    public final static class DAMAGE {
        //State I
        public final static String DAMAGED_STATE_I_PERCENT = "percent_item_damaged.damaged_state_I.percent";
        public final static String DAMAGED_STATE_I_REDUCED_DAMAGE = "percent_item_damaged.damaged_state_I.reduced_damage";
        //State II
        public final static String DAMAGED_STATE_II_PERCENT = "percent_item_damaged.damaged_state_II.percent";
        public final static String DAMAGED_STATE_II_REDUCED_DAMAGE = "percent_item_damaged.damaged_state_II.reduced_damage";
        //State III
        public final static String DAMAGED_STATE_III_PERCENT = "percent_item_damaged.damaged_state_III.percent";
        public final static String DAMAGED_STATE_III_REDUCED_DAMAGE = "percent_item_damaged.damaged_state_III.reduced_damage";
    }
    public final static class EFFECTS {
        //Active
        public final static String ACTIVATE_RANDOM_EFFECTS = "activate_random_effects";
        //Effects
        public final static String RANDOM_EFFECTS = "random_effects";
        //Duration
        public final static String DURATION_VALUE_I = "effect_settings.duration.value_I";
        public final static String DURATION_VALUE_II = "effect_settings.duration.value_II";
        //Amplifier
        public final static String AMPLIFIER_MAX = "effect_settings.amplifier.max";
    }
    public final static class CRAFTING {
        //Affected Weapons
        public final static String AFFECTED_WEAPON_ITEMS = "affected_weapon_items";
        //Affected Armor
        public final static String AFFECTED_ARMOR_ITEMS = "affected_armor_items";
        //Show Creator
        public final static String SHOW_WEAPON_ITEM_CREATOR = "show_weapon_item_creator";
        public final static String SHOW_ARMOR_ITEM_CREATOR = "show_armor_item_creator";
        //Save Creator in NBT
        public final static String SAVE_WEAPON_CREATOR_IN_NBT = "save_weapon_creator_in_nbt";
        public final static String SAVE_ARMOR_CREATOR_IN_NBT = "save_armor_creator_in_nbt";
    }
}