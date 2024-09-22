package org.data.database.minigames;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.wrappers.SimpleNpc;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Tempoross {

    private static ClientContext c = ClientContext.instance();

    public enum Objects {
        STARTING_LADDER(41305),
        WATER_PUMP(41000),
        MAST(41353),
        AMMO_BOX(40971),
        HAMMER_BOX(40964),
        ROPE_BOX(40965),
        HARPOON_BOX(40967),
        BUCKET_BOX(40966),
        TOTEM(41355),
        FIRE(37582),
        OVEN(41236);

        int id;
        Objects(int id) {
            this.id = id;
        }

        public int getID() {return id;}
        public SimpleObject get() {
            return c.objects.populate().filter(id).next();
        }
        public SimpleEntityQuery<SimpleObject> getQuery() {
            return c.objects.populate().filter(id);
        }
    }

    public enum Npcs {
        INACTIVE_POOL(10570),
        TEMPOROSS(10572),
        NULL(10573),
        FISH_NORMAL(10565),
        FISH_SUPER(10569),
        CLOUDS(10580);

        int id;
        Npcs(int id) {
            this.id = id;
        }

        public int getID() {return id;}
        public SimpleNpc get() {
            return c.npcs.populate().filter(id).next();
        }
        public SimpleEntityQuery<SimpleNpc> getQuery() {
            return c.npcs.populate().filter(id);
        }
    }

    public enum Items {
        RAW_FISH(),
        COOKED_FISH()
    }

    public enum GraphicsObjects {}

    public static class WorldPoints {
        public static WorldPoint getEastAnchor(WorldPoint anchor) {
            return new WorldPoint(anchor.getX()+15, anchor.getY()+4, anchor.getPlane());
        }

        public static WorldPoint getWestAnchor(WorldPoint anchor) {
            return new WorldPoint(anchor.getX()-7, anchor.getY()+4, anchor.getPlane());
        }
        public static class East {
            public static WorldArea getBoat(WorldPoint anchor) {
                WorldPoint mast = getEastAnchor(anchor);
                return new WorldArea(
                        new WorldPoint(mast.getX()-4, mast.getY()-10, mast.getPlane()),
                        new WorldPoint(mast.getX()+4, mast.getY()+10, mast.getPlane())
                );
                //-4, +14
            }

            public static WorldArea getIsland(WorldPoint anchor) {
                WorldPoint mast = getEastAnchor(anchor);
                return new WorldArea(
                        new WorldPoint(mast.getX()-4, mast.getY()-10, mast.getPlane()),
                        new WorldPoint(mast.getX()-27, mast.getY()-30, mast.getPlane())
                );
            }

            public static WorldArea getDock(WorldPoint anchor) {
                return new WorldArea(
                        new WorldPoint(anchor.getX()+2, anchor.getY()-11, anchor.getPlane()),
                        new WorldPoint(anchor.getX()+6, anchor.getY()-2, anchor.getPlane())
                );
            }
        }

        public static class West {
            public static WorldArea getBoat(WorldPoint anchor) {
                WorldPoint mast = getWestAnchor(anchor);
                return new WorldArea(
                        new WorldPoint(mast.getX()+4, mast.getY()+10, mast.getPlane()),
                        new WorldPoint(mast.getX()-4, mast.getY()-10, mast.getPlane())
                );
                //-4, +14
            }

            public static WorldArea getIsland(WorldPoint anchor) {
                WorldPoint mast = getWestAnchor(anchor);
                return new WorldArea(
                        new WorldPoint(mast.getX()-6, mast.getY()+12, mast.getPlane()),
                        new WorldPoint(mast.getX()+18, mast.getY()+33, mast.getPlane())
                );
            }

            public static WorldArea getDock(WorldPoint anchor) {
                return new WorldArea(
                        new WorldPoint(anchor.getX()+2, anchor.getY()+10, anchor.getPlane()),
                        new WorldPoint(anchor.getX()+6, anchor.getY()+19, anchor.getPlane())
                );
            }
        }
    }

    public enum GameMessages {
        WAVE_WARNING("a colossal wave closes in"),
        WAVE_HIT("you lose a"),
        WAVE_SAFE("the rope keeps you securely upright as the wave washes over you"),
        CLOUD_WARNING("a strong wind blows as clouds roll"),
        SUCCESS_COOKING("you successfully cook a harpoonfish"),
        SUCCESS_CATCHING("you catch a harpoonfish");

        String message;
        GameMessages(String message) {
            this.message = message;
        }

        public String get() {
            return message;
        }
    }
}
