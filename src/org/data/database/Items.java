package org.data.database;

import simple.hooks.queries.SimpleItemQuery;
import simple.hooks.wrappers.SimpleItem;
import simple.robot.api.ClientContext;

public class Items {
    static ClientContext c = ClientContext.instance();

    public enum General {
        SPADE(952),
        BUCKET(0),
        KNIFE(946),
        DWARVEN_ROCK_CAKE(7510),
        HAMMER(2347);

        private final int id;

        General(int ID) {
            this.id = ID;
        }

        public int getValue() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return c.inventory.populate().filter(id);
        }
        public void clickP(String interaction) {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().menuAction(interaction);
        }
        public void click(String interaction) {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().click(interaction);
        }
        public void click() {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().click(0);
        }
    }

    public enum Currency {
        COINS(995),
        MARK_OF_GRACE(11849),
        TOKKUL(6529);

        private final int id;

        Currency(int ID) {
            this.id = ID;
        }

        public int getValue() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return c.inventory.populate().filter(id);
        }
        public void clickP(String interaction) {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().menuAction(interaction);
        }
        public void click(String interaction) {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().click(interaction);
        }
        public void click() {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().click(0);
        }
    }

    public enum Bones {
        DRAGON_BONES(536);

        private int id;

        Bones(int ID) {
            id = ID;
        }

        public int getID() {
            return id;
        }

        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return c.inventory.populate().filter(id);
        }
        public void clickP(String interaction) {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().menuAction(interaction);
        }
        public void click(String interaction) {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().click(interaction);
        }
        public void click() {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().click(0);
        }
    }

    public enum Cannon {
        BASE(6),
        STAND(8),
        BARREL(10),
        FURNACE(12);

        int id;
        Cannon(int ID) {id = ID;}
        public int getID() {return id;}
        public SimpleItemQuery<SimpleItem> getInvQuery() {
            return c.inventory.populate().filter(id);
        }
        public void clickP(String interaction) {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().menuAction(interaction);
        }
        public void click(String interaction) {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().click(interaction);
        }
        public void click() {
            if (getInvQuery().isEmpty()) {return;}
            getInvQuery().next().click(0);
        }
    }


    public static class Skills {

        public enum Crafting {

        }

        public enum Firemaking {
            TINDERBOX(590);

            private final int[] ids;

            Firemaking(int... Ids) {
                ids = Ids;
            }

            public int[] getIds() {
                return ids;
            }

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(ids);
            }
            public void clickP(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().menuAction(interaction);
            }
            public void click(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(interaction);
            }
            public void click() {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(0);
            }

        }

        public enum Woodcutting {
            AXE(1351, 1349, 1353, 1361, 1355, 1357, 1359, 6739, 20011, 13241),
            LOGS(1511),
            OAK_LOGS(1521),
            WILLOW_LOGS(),
            MAPLE_LOGS(),
            YEW_LOGS(),
            MAGIC_LOGS(),
            TEAK_LOGS(6333),
            MAHOGANY_LOGS(6332);

            private final int[] ids;

            Woodcutting(int... Ids) {
                ids = Ids;
            }

            public int[] getIds() {
                return ids;
            }

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(ids);
            }
            public void clickP(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().menuAction(interaction);
            }
            public void click(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(interaction);
            }
            public void click() {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(0);
            }
        }

        public enum Construction {
            SAW(8794),
            PLANK(960),
            OAK_PLANK(8778),
            TEAK_PLANK(8780),
            MAHOGANY_PLANK(8782);

            int id;
            Construction(int ID) {
                id = ID;
            }

            public int getID() {
                return id;
            }

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(id);
            }
            public void clickP(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().menuAction(interaction);
            }
            public void click(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(interaction);
            }
            public void click() {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(0);
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

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(itemId);
            }
            public void clickP(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().menuAction(interaction);
            }
            public void click(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(interaction);
            }
            public void click() {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(0);
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

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(itemId);
            }
            public void clickP(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().menuAction(interaction);
            }
            public void click(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(interaction);
            }
            public void click() {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(0);
            }
        }


        public enum Herblore {
            PESTLE_MORTER(233),
            VIAL_OF_WATER(227),
            VIAL(229);

            private final int itemId;

            Herblore(int ItemID) {
                itemId = ItemID;
            }

            public int getID() {
                return itemId;
            }

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(itemId);
            }
            public void clickP(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().menuAction(interaction);
            }
            public void click(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(interaction);
            }
            public void click() {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(0);
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

            public SimpleItemQuery<SimpleItem> getInvQuery() {
                return c.inventory.populate().filter(itemIds);
            }
            public void clickP(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().menuAction(interaction);
            }
            public void click(String interaction) {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(interaction);
            }
            public void click() {
                if (getInvQuery().isEmpty()) {return;}
                getInvQuery().next().click(0);
            }
        }

    }

}
