package org.data.database.minigames;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Wintertodt {

    private static ClientContext c = ClientContext.instance();

    /* items */
    public static final int BRUMA_ROOT = 20695;
    public static final int BRUMA_KINDLING = 20696;

    public static final int REWARDS_CRATE = 20703;

    /* objects */
    public static final int BANK_CHEST = 29321;
    public static final int DOOR = 29322;

    public static final int DEADLY_SNOW = 26690;

    public static final int BRAZIER_UNLIT = 29312;
    public static final int BRAZIER_LIT = 29314;
    public static final int BRAZIER_BROKEN = 29313;

    public static final int BRUMA_TREE = 29311;

    /* npcs */
    public static final int PYROMANCER = 7371;

    /* anims */
    public static final int FM_ANIMATION = 832;

    /* tiles & areas */
    public static final WorldPoint SAFE_WC_SPOT = new WorldPoint(1622, 3988, 0);

    public static final WorldPoint WALK_TO_LEAVE = new WorldPoint(1629, 3974, 0);
    public static final WorldPoint WALK_TO_ENTER = new WorldPoint(1630, 3956, 0);

    public static final WorldPoint[] FM_TILES = new WorldPoint[]{
            new WorldPoint(1619, 3999, 0),
            new WorldPoint(1619, 3998, 0),
            new WorldPoint(1619, 3997, 0),
            new WorldPoint(1622, 3996, 0),
            new WorldPoint(1621, 3996, 0),
            new WorldPoint(1620, 3996, 0)
    };

    public static final WorldPoint SNOWFALL_BRAZIER_CHECK = new WorldPoint(1621, 3998, 0);
    public static final WorldPoint[] BRAZIER_SAFE = new WorldPoint[]{
            new WorldPoint(1618, 3999, 0),
            new WorldPoint(1618, 3998, 0),
            new WorldPoint(1618, 3997, 0),
            new WorldPoint(1622, 3997, 0),
            new WorldPoint(1621, 3997, 0),
            new WorldPoint(1620, 3997, 0)
    };

    public static final WorldArea BANK_AREA = new WorldArea(
            new WorldPoint(1641, 3942, 0),
            new WorldPoint(1638, 3946, 0)
    );

    public static final WorldArea OUTSIDE_AREA = new WorldArea(
            new WorldPoint(1638, 3963, 0),
            new WorldPoint(1624, 3937, 0)

    );

    public static final WorldArea LOBBY = new WorldArea(
            new WorldPoint(1636, 3989, 0),
            new WorldPoint(1624, 3967, 0)
    );

    public static final WorldArea PRODUCTION = new WorldArea(
            new WorldPoint(1623, 4000, 0),
            new WorldPoint(1608, 3987, 0)
    );

    /* widgets */

    public static final int[] HEALTH_WIDGET = {396, 21};

    public static WorldArea getSnowfallBounds() {
        if (c.objects.populate().filter(DEADLY_SNOW).isEmpty()) {
            return new WorldArea(new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0));
        }
        WorldPoint centre;
        WorldArea area;
        SimpleEntityQuery<SimpleObject> seq = c.objects.populate().filter(DEADLY_SNOW).filter(PRODUCTION);
        for (SimpleObject o : seq) {
            WorldPoint nw = new WorldPoint(o.getLocation().getX() + 2, o.getLocation().getY() + 2, 0);
            WorldPoint sw = new WorldPoint(o.getLocation().getX() - 2, o.getLocation().getY() - 2, 0);
            area = new WorldArea(nw, sw);
            centre = area.getCenterPoint();
            if (!c.objects.populate().filter(DEADLY_SNOW).filter(nw).isEmpty()) {
                if (!c.objects.populate().filter(DEADLY_SNOW).filter(sw).isEmpty()) {
                    System.out.println("We found the centre point! ");
                    System.out.println("\t | " + nw.getX() + " | " + nw.getY() + " | " + nw.getPlane() + " |");
                    System.out.println("\t | " + sw.getX() + " | " + sw.getY() + " | " + sw.getPlane() + " |");
                    System.out.println("\t | " + centre.getX() + " | " + centre.getY() + " | " + centre.getPlane() + " |");
                    return new WorldArea(nw, sw);
                }
            }

        }

        return new WorldArea(new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0));
    }

}
