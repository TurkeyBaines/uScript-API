package org.data;

import net.runelite.api.coords.WorldPoint;
import org.data.database.*;
import org.data.database.minigames.Wintertodt;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Database {

    /*
            Author: unix
            Discord: x_unix
     */

    private static ClientContext c = ClientContext.instance();

    public static Npcs npcs() {
        return new Npcs();
    }

    public static Objects objects() {
        return new Objects();
    }

    public static Items items() {
        return new Items();
    }

    public static Potions potions() {
        return new Potions();
    }

    public static Food food() {
        return new Food();
    }

    public static Runes runes() {
        return new Runes();
    }

    public static Ores ores() {
        return new Ores();
    }

    public static Widgets widgets() {
        return new Widgets();
    }

    public static Armour armour() { return new Armour(); }

    public static Weapons weapons() { return new Weapons(); }

    public enum areas {

        FEROX_BANK(new WorldArea(new WorldPoint(3137, 3640, 0), new WorldPoint(3123, 3625, 0))),
        BARROWS(new WorldArea(new WorldPoint(3584, 3310, 0), new WorldPoint(3546, 3270, 0))),
        BARROWS_DHAROK(new WorldArea(new WorldPoint(3560, 9721, 3), new WorldPoint(3548, 9710, 3))),
        BARROWS_VERAC(new WorldArea(new WorldPoint(3579, 9711, 3), new WorldPoint(3566, 9702, 3))),
        BARROWS_TORAG(new WorldArea(new WorldPoint(3576, 9694, 3), new WorldPoint(3563, 9683, 3))),
        BARROWS_AHRIM(new WorldArea(new WorldPoint(3562, 9705, 3), new WorldPoint(3550, 9694, 3))),
        BARROWS_GUTHAN(new WorldArea(new WorldPoint(3547, 9710, 3), new WorldPoint(3533, 9699, 3))),
        BARROWS_KARIL(new WorldArea(new WorldPoint(3558, 9689, 3), new WorldPoint(3545, 9678, 3))),
        BARROWS_LOOT(new WorldArea(new WorldPoint(3558, 9703, 0), new WorldPoint(3543, 9689, 0))),
        ARDOUGNE_KNIGHT_HOUSE(new WorldArea(new WorldPoint(2648, 3318, 0), new WorldPoint(2653, 3316, 0)));


        WorldArea wa;

        areas(WorldArea WorldArea) {
            wa = WorldArea;
        }

        public WorldArea get() {
            return wa;
        }
    }

    public static Seeds seeds() {
        return new Seeds();
    }

    public enum tiles {

        ARDOUGNE_SILK_STALL(new WorldPoint(2662, 3316, 0)),
        ARDOUGNE_CAKE_STALL(new WorldPoint(2669, 3310, 0)),
        DRAYNOR_THIEVING_SPOT(new WorldPoint(3087, 3249, 0));

        WorldPoint worldPoint;

        tiles(WorldPoint wp) {
            worldPoint = wp;
        }

        public WorldPoint get() {
            return worldPoint;
        }
    }

    public static class graphics {
        public static final int STUNNED = 245;
    }

    public static Animations animations() {
        return new Animations();
    }

    public static class minigames {
        public static Wintertodt wintertodt() { return new Wintertodt(); }
    }
}
