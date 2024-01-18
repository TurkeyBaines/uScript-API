package org.data.database;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.interfaces.SimpleLocatable;
import simple.robot.utils.WorldArea;

public class Areas {

    public enum Home {
        BANK_AREA(new WorldArea(new WorldPoint(1949, 3273, 0), new WorldPoint(1962, 3286, 0)));

        WorldArea area;
        Home(WorldArea Area) {area = Area;}

        public boolean contains(WorldPoint point) {
            return area.containsPoint(point);
        }
    }

    public enum Vyre {
        PUB(new WorldArea(new WorldPoint(3593, 3386, 0), new WorldPoint(3606, 3397, 0)));

        WorldArea area;
        Vyre(WorldArea Area) {area = Area;}

        public boolean contains(WorldPoint point) {
            return area.containsPoint(point);
        }
    }


    public enum DZone {
        FULL_ZONE(new WorldArea(new WorldPoint(2818, 5056, 0), new WorldPoint(2876, 5118, 0))),
        LOBBY(new WorldArea(new WorldPoint(2831, 5090, 0), new WorldPoint(2863, 5106, 0))),
        WOODCUTTING(new WorldArea(new WorldPoint(2823, 5071, 0), new WorldPoint(2840, 5087, 0)));


        WorldArea area;
        DZone(WorldArea Area) { area = Area; }

        public WorldArea getArea() {return area;}
        public boolean contains(WorldPoint locatable) {
            if (area.containsPoint(locatable)) {
                return true;
            }
            return false;
        }

        public enum Dungeon {
            FULL_ZONE(new WorldArea(new WorldPoint(1900, 8960, 1), new WorldPoint(1970, 9050, 1))),
            LADDER(new WorldArea(new WorldPoint(1926, 9001, 1), new WorldPoint(1942, 9017, 1))),
            GREEN_DRAGONS(new WorldArea(new WorldPoint(1903, 8991, 1), new WorldPoint(1925, 9016, 1))),
            ROCKS(new WorldArea(new WorldPoint(1932, 9016, 1), new WorldPoint(1940, 9022, 1))),
            NECHS(new WorldArea(new WorldPoint(1926, 8985, 1), new WorldPoint(1952, 9002, 1))),
            DARK_BEASTS(new WorldArea(new WorldPoint(1918, 8962, 1), new WorldPoint(1938, 8984, 1))),
            ABBY_DEMONS(new WorldArea(new WorldPoint(1942, 8964, 1), new WorldPoint(1954, 8980, 1)));

            WorldArea area;
            Dungeon(WorldArea Area) {area = Area;}

            public WorldArea getArea() {return area;}
            public boolean contains(WorldPoint locatable) {
                if (area.containsPoint(locatable)) {
                    return true;
                }
                return false;
            }
        }
    }


}
