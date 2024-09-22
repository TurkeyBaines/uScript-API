package org.data.database.minigames;

import net.runelite.api.Varbits;

import org.data.database.Items;
import org.data.database.Items.Skills.*;

import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.wrappers.SimpleItem;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class BlastFurnace {

    private static ClientContext c = ClientContext.instance();

    public enum Objects {
        BAR_DISPENSER(9092),
        CONVAYOR(9100),
        BANK(26707);

        int id;
        Objects(int id) {
            this.id = id;
        }

        public SimpleObject get() {
            return c.objects.populate().filter(id).next();
        }
        public SimpleEntityQuery<SimpleObject> getQuery() {
            return c.objects.populate().filter(id);
        }
    }


}
