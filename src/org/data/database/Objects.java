package org.data.database;

public class Objects {

    public static class Banks {
        public final int FEROX_BANK_CHEST = 26711;
        public final int[] BANK_BOOTH = {6943, 6944};
    }
    public final int TELEPORTER = 35000;

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






}
