package org.data.database;

import simple.hooks.filters.SimplePrayers;
import simple.robot.api.ClientContext;
import simple.robot.script.Script;

public enum Prayer {

    CHIVALRY(35455010, "<col=ff9040>Chivalry</col>"),
    PIETY(35455011, "<col=ff9040>Piety</col>"),
    PROTECT_FROM_MELEE(35454999, "<col=ff9040>Protect from Melee</col>"),
    PROTECT_FROM_RANGE(35454998, "<col=ff9040>Protect from Missiles</col>"),
    PROTECT_FROM_MAGIC(35454997, "<col=ff9040>Protect from Magic</col>");

    int param1;
    String target;
    Prayer(int PARAM1, String TARGET) {param1 = PARAM1; target = TARGET;}

    public void enable() {
        ClientContext c = ClientContext.instance();
        if (this.name().toLowerCase().contains("melee")) { c.prayers.prayer(SimplePrayers.Prayers.PROTECT_FROM_MELEE, true); }
        if (this.name().toLowerCase().contains("range")) { c.prayers.prayer(SimplePrayers.Prayers.PROTECT_FROM_MISSILES, true); }
        if (this.name().toLowerCase().contains("magic")) { c.prayers.prayer(SimplePrayers.Prayers.PROTECT_FROM_MAGIC, true); }
    }
    public void enableP() {
        ClientContext c = ClientContext.instance();
        c.menuActions.sendAction(57, -1, param1, 1, "Activate", target);
    }

    public void disable() {
        ClientContext c = ClientContext.instance();
        if (this.name().toLowerCase().contains("melee")) { c.prayers.prayer(SimplePrayers.Prayers.PROTECT_FROM_MELEE, false); }
        if (this.name().toLowerCase().contains("range")) { c.prayers.prayer(SimplePrayers.Prayers.PROTECT_FROM_MISSILES, false); }
        if (this.name().toLowerCase().contains("magic")) { c.prayers.prayer(SimplePrayers.Prayers.PROTECT_FROM_MAGIC, false); }
    }
    public void disableP() {
        ClientContext c = ClientContext.instance();
        c.menuActions.sendAction(57, -1, param1, 1, "Deactivate", target);
    }

}
