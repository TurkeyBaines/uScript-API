package org.data.database;

import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.queries.SimpleItemQuery;
import simple.hooks.wrappers.SimpleGroundItem;
import simple.hooks.wrappers.SimpleItem;
import simple.robot.api.ClientContext;

public class Mage {
    private static ClientContext c = ClientContext.instance();

    public static class Staff {
        public enum Elemental {
            STAFF_OF_AIR(1381),
            STAFF_OF_WATER(1383),
            STAFF_OF_EARTH(1385),
            STAFF_OF_FIRE(1387),
            MYSTIC_AIR_STAFF(1405),
            MYSTIC_WATER_STAFF(1403),
            MYSTIC_EARTH_STAFF(1407),
            MYSTIC_FIRE_STAFF(1401);

            private final int id;

            Elemental(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(id);
            }

            public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
                return c.groundItems.populate().filter(id);
            }

            public SimpleItemQuery<SimpleItem> getEquipQuery() {
                return c.equipment.populate().filter(id);
            }

            public void equip() {
                if (getInvQuery().isEmpty()) {
                    return;
                }
                getInvQuery().next().menuAction("Wield");
            }

            public void unequip() {
                if (getEquipQuery().isEmpty()) {
                    return;
                }
                getEquipQuery().next().menuAction("Remove");
            }
        }

        public enum Battlestaff {
            AIR_BATTLESTAFF(1397),
            WATER_BATTLESTAFF(1395),
            EARTH_BATTLESTAFF(1399),
            FIRE_BATTLESTAFF(1393);

            private final int id;

            Battlestaff(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(id);
            }

            public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
                return c.groundItems.populate().filter(id);
            }

            public SimpleItemQuery<SimpleItem> getEquipQuery() {
                return c.equipment.populate().filter(id);
            }

            public void equip() {
                if (getInvQuery().isEmpty()) {
                    return;
                }
                getInvQuery().next().menuAction("Wield");
            }

            public void unequip() {
                if (getEquipQuery().isEmpty()) {
                    return;
                }
                getEquipQuery().next().menuAction("Remove");
            }
        }

        public enum Combination {
            LAVA_BATTLESTAFF(3053),
            MUD_BATTLESTAFF(6562),
            STEAM_BATTLESTAFF(11787),
            SMOKE_BATTLESTAFF(11998),
            MYSTIC_LAVA_STAFF(3054),
            MYSTIC_MUD_STAFF(6563),
            MYSTIC_STEAM_STAFF(11789),
            MYSTIC_SMOKE_STAFF(12000);

            private final int id;

            Combination(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(id);
            }

            public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
                return c.groundItems.populate().filter(id);
            }

            public SimpleItemQuery<SimpleItem> getEquipQuery() {
                return c.equipment.populate().filter(id);
            }

            public void equip() {
                if (getInvQuery().isEmpty()) {
                    return;
                }
                getInvQuery().next().menuAction("Wield");
            }

            public void unequip() {
                if (getEquipQuery().isEmpty()) {
                    return;
                }
                getEquipQuery().next().menuAction("Remove");
            }
        }

        public enum God {
            SARADOMIN_STAFF(2415),
            GUTHIX_STAFF(2416),
            ZAMORAK_STAFF(2417);

            private final int id;

            God(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(id);
            }

            public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
                return c.groundItems.populate().filter(id);
            }

            public SimpleItemQuery<SimpleItem> getEquipQuery() {
                return c.equipment.populate().filter(id);
            }

            public void equip() {
                if (getInvQuery().isEmpty()) {
                    return;
                }
                getInvQuery().next().menuAction("Wield");
            }

            public void unequip() {
                if (getEquipQuery().isEmpty()) {
                    return;
                }
                getEquipQuery().next().menuAction("Remove");
            }
        }
    }

    public enum Wand {
        BEGINNER_WAND(6908),
        APPRENTICE_WAND(6910),
        TEACHER_WAND(6912),
        KODAI_WAND(21006),
        MASTER_WAND(6914);

        private final int id;

        Wand(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return c.inventory.populate().filter(id);
        }

        public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
            return c.groundItems.populate().filter(id);
        }

        public SimpleItemQuery<SimpleItem> getEquipQuery() {
            return c.equipment.populate().filter(id);
        }

        public void equip() {
            if (getInvQuery().isEmpty()) { return; }
            getInvQuery().next().menuAction("Wield");
        }

        public void unequip() {
            if (getEquipQuery().isEmpty()) { return; }
            getEquipQuery().next().menuAction("Remove");
        }
    }

    public enum Salamander {
        SWAMP_LIZARD(10149),
        ORANGE_SALAMANDER(10146),
        RED_SALAMANDER(10147),
        BLACK_SALAMANDER(10148);

        private final int id;

        Salamander(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return c.inventory.populate().filter(id);
        }

        public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
            return c.groundItems.populate().filter(id);
        }

        public SimpleItemQuery<SimpleItem> getEquipQuery() {
            return c.equipment.populate().filter(id);
        }

        public void equip() {
            if (getInvQuery().isEmpty()) { return; }
            getInvQuery().next().menuAction("Wield");
        }

        public void unequip() {
            if (getEquipQuery().isEmpty()) { return; }
            getEquipQuery().next().menuAction("Remove");
        }
    }

    public enum Special {
        STAFF_OF_THE_DEAD(11792),
        TOXIC_STAFF_OF_THE_DEAD(12904),
        IBANS_STAFF(1409),
        AHRIMS_STAFF(4710),
        TRIDENT_OF_THE_SEAS(11905),
        TRIDENT_OF_THE_SEAS_FULL(11907),
        TRIDENT_OF_THE_SEAS_EMPTY(11908),
        TRIDENT_OF_THE_SWAMP(12899),
        TRIDENT_OF_THE_SWAMP_EMPTY(12900),
        ANCIENT_STAFF(4675),
        SLAYER_STAFF(4170),
        SANGUINESTI_STAFF(22323),
        NIGHTMARE_STAFF(24422),
        VOLATILE_NIGHTMARE_STAFF(24424),
        HARMONISED_NIGHTMARE_STAFF(24423),
        ELDRITCH_NIGHTMARE_STAFF(24425);

        private int id;

        Special(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return c.inventory.populate().filter(id);
        }

        public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
            return c.groundItems.populate().filter(id);
        }

        public SimpleItemQuery<SimpleItem> getEquipQuery() {
            return c.equipment.populate().filter(id);
        }

        public void equip() {
            if (getInvQuery().isEmpty()) { return; }
            getInvQuery().next().menuAction("Wield");
        }

        public void unequip() {
            if (getEquipQuery().isEmpty()) { return; }
            getEquipQuery().next().menuAction("Remove");
        }
    }

    public enum Hood {
        GHOSTLY_HOOD(5525),
        MYSTIC_HOOD(4099),
        AHRIMS_HOOD(4708),
        ANCESTRAL_HAT(21018),
        INFERNAL_HOOD(21282),
        THIRD_AGE_HAT(10350), // Corrected item
        ELDER_CHAOS_HOOD(20595); // Added Elder Chaos Hood

        private final int id;

        Hood(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return ClientContext.instance().inventory.populate().filter(id);
        }

        public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
            return ClientContext.instance().groundItems.populate().filter(id);
        }

        public SimpleItemQuery<SimpleItem> getEquipQuery() {
            return ClientContext.instance().equipment.populate().filter(id);
        }

        public void equip() {
            if (getInvQuery().isEmpty()) {
                return;
            }
            getInvQuery().next().menuAction("Wear");
        }

        public void unequip() {
            if (getEquipQuery().isEmpty()) {
                return;
            }
            getEquipQuery().next().menuAction("Remove");
        }
    }

    public enum RobeTops {
        GHOSTLY_ROBE_TOP(6107),
        MYSTIC_ROBE_TOP(4091),
        AHRIMS_ROBE_TOP(4712),
        ANCESTRAL_ROBE_TOP(21021),
        VOID_KNIGHT_TOP(8839),
        THIRD_AGE_ROBE_TOP(10338), // Correct item
        ZAMORAK_MONK_ROBE_TOP(1033), // Correct item
        ELDER_CHAOS_ROBE_TOP(20517); // Added Elder Chaos Robe Top

        private final int id;

        RobeTops(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return ClientContext.instance().inventory.populate().filter(id);
        }

        public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
            return ClientContext.instance().groundItems.populate().filter(id);
        }

        public SimpleItemQuery<SimpleItem> getEquipQuery() {
            return ClientContext.instance().equipment.populate().filter(id);
        }

        public void equip() {
            if (getInvQuery().isEmpty()) {
                return;
            }
            getInvQuery().next().menuAction("Wear");
        }

        public void unequip() {
            if (getEquipQuery().isEmpty()) {
                return;
            }
            getEquipQuery().next().menuAction("Remove");
        }
    }

    public enum RobeBottoms {
        GHOSTLY_ROBE_BOTTOM(6108),
        MYSTIC_ROBE_BOTTOM(4093),
        AHRIMS_ROBE_SKIRT(4714),
        ANCESTRAL_ROBE_BOTTOM(21024),
        VOID_KNIGHT_ROBE(8840),
        THIRD_AGE_ROBE_BOTTOM(10340),
        ZAMORAK_MONK_ROBE_BOTTOM(1035), // Corrected naming
        ELDER_CHAOS_ROBE_BOTTOM(20520); // Added Elder Chaos Robe Bottom

        private final int id;

        RobeBottoms(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return ClientContext.instance().inventory.populate().filter(id);
        }

        public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
            return ClientContext.instance().groundItems.populate().filter(id);
        }

        public SimpleItemQuery<SimpleItem> getEquipQuery() {
            return ClientContext.instance().equipment.populate().filter(id);
        }

        public void equip() {
            if (getInvQuery().isEmpty()) {
                return;
            }
            getInvQuery().next().menuAction("Wear");
        }

        public void unequip() {
            if (getEquipQuery().isEmpty()) {
                return;
            }
            getEquipQuery().next().menuAction("Remove");
        }
    }

    public enum Gloves {
        GHOSTLY_GLOVES(6109),
        MYSTIC_GLOVES(4095),
        VOID_KNIGHT_GLOVES(8842),
        BARROWS_GLOVES(7462),
        DARK_MYSTIC_GLOVES(4101),
        LIGHT_MYSTIC_GLOVES(4103),
        ELDER_CHAOS_GLOVES(20595); // Added Elder Chaos Gloves

        private final int id;

        Gloves(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return ClientContext.instance().inventory.populate().filter(id);
        }

        public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
            return ClientContext.instance().groundItems.populate().filter(id);
        }

        public SimpleItemQuery<SimpleItem> getEquipQuery() {
            return ClientContext.instance().equipment.populate().filter(id);
        }

        public void equip() {
            if (getInvQuery().isEmpty()) {
                return;
            }
            getInvQuery().next().menuAction("Wear");
        }

        public void unequip() {
            if (getEquipQuery().isEmpty()) {
                return;
            }
            getEquipQuery().next().menuAction("Remove");
        }
    }

    public enum Boots {
        MYSTIC_BOOTS(4097),
        INFINITY_BOOTS(6920),
        ETERNAL_BOOTS(13235),
        WIZARD_BOOTS(2579),
        ELDER_CHAOS_BOOTS(20517), // Added Elder Chaos Boots
        BOOTS_OF_LIGHTNESS(88),
        GHOSTLY_BOOTS(6106),
        IMBUED_WIZARD_BOOTS(11732); // Imbued version of Wizard Boots from Bounty Hunter

        private final int id;

        Boots(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return ClientContext.instance().inventory.populate().filter(id);
        }

        public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
            return ClientContext.instance().groundItems.populate().filter(id);
        }

        public SimpleItemQuery<SimpleItem> getEquipQuery() {
            return ClientContext.instance().equipment.populate().filter(id);
        }

        public void equip() {
            if (getInvQuery().isEmpty()) {
                return;
            }
            getInvQuery().next().menuAction("Wear");
        }

        public void unequip() {
            if (getEquipQuery().isEmpty()) {
                return;
            }
            getEquipQuery().next().menuAction("Remove");
        }
    }


}

