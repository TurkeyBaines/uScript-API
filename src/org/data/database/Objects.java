package org.data.database;

import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Objects {

    static ClientContext c = ClientContext.instance();

    public enum Alters {
        WILDERNESS(411);

        int id;
        Alters(int ID) {
            id = ID;
        }

        public int getID() {
            return id;
        }

    }

    public static class Banks {
        public final int FEROX_BANK_CHEST = 26711;
        public final int[] BANK_BOOTH = {6943, 6944};
    }
    public static final int TELEPORTER = 35000;
    public static final int CURSED_ALTER = 126;

    // BARROWS OBJECTS

    public static class Minigames {
        public enum Barrows {
            BARROWS_CHEST(20973),
            DHAROK_SARCOPHAGUS(20720),
            DHAROK_STAIRS(20668),
            GUTHAN_SARCOPHAGUS(20722),
            GUTHAN_STAIRS(20669),
            VERAC_SARCOPHAGUS(20772),
            VERAC_STAIRS(20672),
            AHRIM_SARCOPHAGUS(20770),
            AHRIM_STAIRS(20667),
            KARIL_SARCOPHAGUS(20771),
            KARIL_STAIRS(20670),
            TORAG_SARCOPHAGUS(20721),
            TORAG_STAIRS(20671);

            private final int id;

            Barrows(int id) {
                this.id = id;
            }

            public int getID() {
                return id;
            }
        }
    }

    public static class Skills {
        public enum Thieving {
            CAKE_STALL(11730),
            SILK_STALL(11729),
            CRAFTING_STALL(4874),
            FOOD_STALL(4875),
            GENERAL_STALL(4876),
            MAGIC_STALL(4877),
            SCIMITAR_STALL(4878);

            private final int itemId;

            Thieving(int itemId) {
                this.itemId = itemId;
            }

            public int getID() {
                return itemId;
            }
        }

        public enum Construction {
            OVERWORLD_HOUSE_PORTAL(15478),
            INHOUSE_PORTAL(4525),
            TABLE_EMPTY(15298),
            OAK_DINING_TABLE(13294),
            CARVED_OAK_TABLE(13295),
            TEAK_DINING_TABLE(13296),
            MAHOGANY_DINING_TABLE(13298);

            int id;
            Construction(int ID) {
                id = ID;
            }

            public int getID() {
                return id;
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }
        }

        public enum Woodcutting {
            TREE(1276, 1277, 1278, 1279, 1280),
            OAK_TREE(4533, 4540, 10820),
            WILLOW_TREE(4534, 4541, 8481, 8482, 8483, 8484, 8485, 8486, 8487, 8488),
            MAPLE_TREE(4535, 4674, 5126, 8435, 8436, 8437, 8438, 8439, 8440, 8441, 8442, 8443, 8444, 10832, 36681, 36682, 40754, 40755),
            YEW_TREE(4536, 5121, 8503, 8504, 8505, 8506, 8507, 8508, 8509, 8510, 8511, 8512, 8513),
            MAGIC_TREE(4537, 5127, 8396, 8397, 8398, 8399, 8400, 8401, 8402, 8403, 8404, 8405, 8406, 8407, 8408, 8409),
            TEAK_TREE(9036),
            MAHOGANY_TREE(9034);

            private int[] ids;
            Woodcutting(int... IDs) {
                ids = IDs;
            }

            public int[] getIds() {
                return ids;
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(ids);
            }
        }

        public enum Fishing {
            FISHING_NET_BAIT(1518),
            FISHING_CAGE_HARPOON(1510, 1519),
            FISHING_NET_HARPOON(1511, 1520),
            FISHING_MINNOW(7730, 7731, 7732, 7733),
            FISHING_FLY(1526);

            private int itemId;
            private int[] ids;

            Fishing(int itemId) {
                this.itemId = itemId;
            }

            Fishing(int... IDS) {
                ids = IDS;
            }

            public int getID() {
                return itemId;
            }

            public int[] getIDs() {
                return ids;
            }
        }

        public static class Cooking {
            public final int BARBARIAN_FIRE = 26185;
            public final int RANGE = 26181;
        }
    }

    public enum Cannon {
        FULL(6),
        BASE(7),
        STAND(8),
        FURNACE(9);

        int id;
        Cannon(int ID) {id = ID;}

        public SimpleEntityQuery<SimpleObject> getQuery() {
            return c.objects.populate().filter(id);
        }

        public void interact(String interaction) {
            if (getQuery().isEmpty()) { return; }
            getQuery().next().click(interaction);
        }
        public void click() {
            if (getQuery().isEmpty()) { return; }
            getQuery().next().click(0);
        }
        public void interactP(String interaction) {
            if (getQuery().isEmpty()) {return;}
            getQuery().next().menuAction(interaction);
        }

    }




}
