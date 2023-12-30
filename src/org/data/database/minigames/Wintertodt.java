package org.data.database.minigames;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.wrappers.SimpleObject;
import simple.hooks.wrappers.SimpleWidget;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Wintertodt {

    private ClientContext c = ClientContext.instance();

    /* items */
    public enum Items {
        BRUMA_ROOT(20695),
        BRUMA_KINDLING(20696),
        REWARDS_CRATE(20703);

        private final int itemId;

        Items(int itemId) {
            this.itemId = itemId;
        }

        public int getItemId() {
            return itemId;
        }
    }

    /* objects */
    public enum Objects {
        BANK_CHEST(29321),
        DOOR(29322),
        DEADLY_SNOW(26690),
        BRAZIER_UNLIT(29312),
        BRAZIER_LIT(29314),
        BRAZIER_BROKEN(29313),
        BRUMA_TREE(29311);

        private final int objectId;

        Objects(int objectId) {
            this.objectId = objectId;
        }

        public int getObjectId() {
            return objectId;
        }
    }

    /* npcs */
    public enum NPCs {
        PYROMANCER(7371);

        private final int npcId;

        NPCs(int npcId) {
            this.npcId = npcId;
        }

        public int getNpcId() {
            return npcId;
        }
    }


    /* anims */
    public enum Anims {
        FM_ANIMATION(832);

        private final int animationId;

        Anims(int animationId) {
            this.animationId = animationId;
        }

        public int getAnimationId() {
            return animationId;
        }
    }



    /* tiles & areas */
    public enum Tiles {
        SAFE_WC_SPOT(new WorldPoint(1622, 3988, 0)),
        WALK_TO_LEAVE(new WorldPoint(1629, 3974, 0)),
        WALK_TO_ENTER(new WorldPoint(1630, 3956, 0)),
        SNOWFALL_BRAZIER_CHECK(new WorldPoint(1621, 3998, 0));

        private final WorldPoint worldPoint;

        Tiles(WorldPoint worldPoint) {
            this.worldPoint = worldPoint;
        }

        public WorldPoint getWorldPoint() {
            return worldPoint;
        }
    }


    public enum Areas {
        FM_TILES(new WorldPoint[]{
                new WorldPoint(1619, 3999, 0),
                new WorldPoint(1619, 3998, 0),
                new WorldPoint(1619, 3997, 0),
                new WorldPoint(1622, 3996, 0),
                new WorldPoint(1621, 3996, 0),
                new WorldPoint(1620, 3996, 0)
        }),
        BRAZIER_SAFE(new WorldPoint[]{
                new WorldPoint(1618, 3999, 0),
                new WorldPoint(1618, 3998, 0),
                new WorldPoint(1618, 3997, 0),
                new WorldPoint(1622, 3997, 0),
                new WorldPoint(1621, 3997, 0),
                new WorldPoint(1620, 3997, 0)
        }),
        BANK_AREA(new WorldArea(
                new WorldPoint(1641, 3942, 0),
                new WorldPoint(1638, 3946, 0)
        )),
        OUTSIDE_AREA(new WorldArea(
                new WorldPoint(1638, 3963, 0),
                new WorldPoint(1624, 3937, 0)
        )),
        LOBBY(new WorldArea(
                new WorldPoint(1636, 3989, 0),
                new WorldPoint(1624, 3967, 0)
        )),
        PRODUCTION(new WorldArea(
                new WorldPoint(1623, 4000, 0),
                new WorldPoint(1608, 3987, 0)
        ));

        private final WorldPoint[] worldPoints;
        private final WorldArea worldArea;

        Areas(WorldPoint[] worldPoints) {
            this.worldPoints = worldPoints;
            this.worldArea = null;
        }

        Areas(WorldArea worldArea) {
            this.worldArea = worldArea;
            this.worldPoints = null;
        }

        public WorldPoint[] getWorldPoints() {
            return worldPoints;
        }

        public WorldArea getWorldArea() {
            return worldArea;
        }
    }


    /* widgets */
    public enum Widgets {
        HEALTH_WIDGET(new int[]{396, 21});

        private final int[] widget;

        Widgets(int[] widget) {
            this.widget = widget;
        }

        public SimpleWidget getWidget() {
            try {
                return ClientContext.instance().widgets.getWidget(widget[0], widget[1]);
            } catch (NullPointerException e) {
                throw new NullPointerException("We can't seem to grab that Widget right now!");
            }
        }

        public int[] getIds() {
            return widget;
        }
    }


    public WorldArea getSnowfallBounds() {
        if (c.objects.populate().filter(Objects.DEADLY_SNOW.getObjectId()).isEmpty()) {
            return new WorldArea(new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0));
        }
        WorldPoint centre;
        WorldArea area;
        SimpleEntityQuery<SimpleObject> seq = c.objects.populate().filter(Objects.DEADLY_SNOW.getObjectId()).filter(Areas.PRODUCTION.getWorldArea());
        for (SimpleObject o : seq) {
            WorldPoint nw = new WorldPoint(o.getLocation().getX() + 2, o.getLocation().getY() + 2, 0);
            WorldPoint sw = new WorldPoint(o.getLocation().getX() - 2, o.getLocation().getY() - 2, 0);
            area = new WorldArea(nw, sw);
            centre = area.getCenterPoint();
            if (!c.objects.populate().filter(Objects.DEADLY_SNOW.getObjectId()).filter(nw).isEmpty()) {
                if (!c.objects.populate().filter(Objects.DEADLY_SNOW.getObjectId()).filter(sw).isEmpty()) {
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
