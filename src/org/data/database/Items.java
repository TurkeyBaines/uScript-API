package org.data.database;

public class Items {

    public enum General {
        SPADE(952),
        BUCKET(0),
        KNIFE(946),
        HAMMER(2347);

        private final int value;

        General(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Currency {
        COINS(995),
        MARK_OF_GRACE(11849);

        private final int value;

        Currency(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    public static class Skills {

        public enum Crafting {

        }

        public enum Woodcutting {
            AXE(1351, 1349, 1353, 1361, 1355, 1357, 1359, 6739, 20011, 13241);

            private final int[] ids;

            Woodcutting(int... Ids) {
                ids = Ids;
            }

            public int[] getIds() {
                return ids;
            }
        }

        public enum Fishing {
            FEATHERS(314),
            FLY_FISHING_ROD(309),
            HARPOON(311),
            LOBSTER_POT(301);

            private final int itemId;

            Fishing(int itemId) {
                this.itemId = itemId;
            }

            public int getID() {
                return itemId;
            }
        }

        public enum Runecrafting {
            RUNE_ESSENCE(1436),
            PURE_ESSENCE(7936),

            AIR_TALISMAN(1438),
            EARTH_TALISMAN(1440),
            FIRE_TALISMAN(1442),
            WATER_TALISMAN(1444),
            BODY_TALISMAN(1446),
            MIND_TALISMAN(1448),
            CHAOS_TALISMAN(1452),
            COSMIC_TALISMAN(1454),
            DEATH_TALISMAN(1456),
            LAW_TALISMAN(1458),
            NATURE_TALISMAN(1462),
            ELEMENTAL_TALISMAN(5516),

            AIR_TIARA(5527),
            EARTH_TIARA(5535),
            FIRE_TIARA(5537),
            WATER_TIARA(5531),
            BODY_TIARA(5533),
            MIND_TIARA(5529),
            CHAOS_TIARA(5543),
            COSMIC_TIARA(5539),
            DEATH_TIARA(5547),
            LAW_TIARA(5545),
            NATURE_TIARA(5541);

            private final int itemId;

            Runecrafting(int itemId) {
                this.itemId = itemId;
            }

            public int getID() {
                return itemId;
            }
        }


        public enum Herblore {
            PESTLE_MORTER(233),
            VIAL_OF_WATER(227);

            private final int itemId;

            Herblore(int ItemID) {
                itemId = ItemID;
            }

            public int getID() {
                return itemId;
            }
        }

        public enum Hunter {

        }

        public enum Slayer {

        }

        public enum Thieving {
            COIN_POUCH(22521, 22522, 22527, 22531),
            ROGUES_OUTFIT(5553, 5554, 5555, 5556, 5557),
            SILK(950);

            private final int[] itemIds;

            Thieving(int... itemIds) {
                this.itemIds = itemIds;
            }

            public int[] getItemIds() {
                return itemIds;
            }
        }

    }

}
