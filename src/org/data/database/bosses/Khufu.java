package org.data.database.bosses;

import net.runelite.api.GraphicsObject;
import net.runelite.api.coords.WorldPoint;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.queries.SimpleIdQuery;
import simple.hooks.wrappers.SimpleNpc;
import simple.hooks.wrappers.SimpleObject;
import simple.hooks.wrappers.SimpleProjectile;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

import java.util.ArrayList;

public class Khufu {

    private static ClientContext c = ClientContext.instance();

    public enum Objects {
        BRAZIER_ORANGE(65475),
        BRAZIER_BLUE(65477),
        BRAZIER_YELLOW(65478);

        final int id;
        Objects(int id) {
            this.id = id;
        }

        public int getID() {
            return id;
        }

        public SimpleEntityQuery<SimpleObject> getQuery() {
            return c.objects.populate().filter(id);
        }
    }

    public enum Items {}

    public enum Npcs {
        KHUFU(16349),
        KHUFU_ASLEEP(16351);

        final int id;
        Npcs(int id) {
            this.id = id;
        }

        public int getID() {
            return id;
        }

        public SimpleEntityQuery<SimpleNpc> getQuery() {
            return c.npcs.populate().filter(id);
        }
    }

    public enum GraphicsObjects {
        YELLOW_ORBS(1595);

        int id;
        GraphicsObjects(int id) {
            this.id = id;
        }

        public int getID() {
            return id;
        }

        public GraphicsObject get() {
            for (GraphicsObject go : c.getClient().getGraphicsObjects()) {
                if (go == null) { continue; }
                if (go.getId() == id) {
                    return go;
                }
            }
            return null;
        }

        public GraphicsObject[] getArray() {
            ArrayList<GraphicsObject> list = new ArrayList<>();
            for (GraphicsObject go : c.getClient().getGraphicsObjects()) {
                if (go == null) { continue; }
                if (go.getId() == id) { list.add(go); }
            }
            return list.toArray(new GraphicsObject[list.size()]);
        }

        public ArrayList<GraphicsObject> getList() {
            ArrayList<GraphicsObject> list = new ArrayList<>();
            for (GraphicsObject go : c.getClient().getGraphicsObjects()) {
                if (go == null) { continue; }
                if (go.getId() == id) { list.add(go); }
            }
            return list;
        }
    }

    public enum Projectiles {
        RANGE_ATK(1245),
        MAGE_ATK(1465);

        int id;
        Projectiles(int ID) {id = ID;}
        public SimpleIdQuery<SimpleProjectile> getQuery() {
            return c.projectiles.populate().filter(id);
        }
        public SimpleProjectile get() {
            return getQuery().next();
        }
        public boolean active() {return c.projectiles.projectileActive(id);}
    }

}
