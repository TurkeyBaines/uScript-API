package org.data.database;

import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public enum Npcs {
    PILLORY_GUARD(380),
    MAN(3078, 3079, 3080),
    WOMAN(3083, 3084, 3085),
    GUARD(3245),
    KNIGHT_OF_ARDOUGNE(3297),
    PALADIN(3105),
    HERO(3106),
    MASTER_FARMER(3257),
    SAWMILL_OPERATOR(3101),
    ABYSSAL_DEMON(415);

    public enum Vyre {
        X;

        public enum Thieving {
            ALL(9713, 9692, 9697, 9692);

            int[] npcIds;
            Thieving(int... IDS) {
                npcIds = IDS;
            }

            public SimpleEntityQuery<SimpleNpc> getQuery() {
                return ClientContext.instance().npcs.populate().filter(npcIds);
            }
            public void clickP(String interaction) {
                if (getQuery().isEmpty()) {return;}
                getQuery().next().menuAction(interaction);
            }
            public void click(String interaction) {
                if (getQuery().isEmpty()) {return;}
                getQuery().next().click(interaction);
            }
            public void click() {
                if (getQuery().isEmpty()) {return;}
                getQuery().next().click(0);
            }
        }
    }

    private final int[] npcIds;

    Npcs(int... npcIds) {
        this.npcIds = npcIds;
    }

    public int[] getIDs() {
        return npcIds;
    }

    public int getID() {
        return npcIds[0];
    }

    public SimpleEntityQuery<SimpleNpc> getQuery() {
        return ClientContext.instance().npcs.populate().filter(npcIds);
    }
    public void clickP(String interaction) {
        if (getQuery().isEmpty()) {return;}
        getQuery().next().menuAction(interaction);
    }
    public void click(String interaction) {
        if (getQuery().isEmpty()) {return;}
        getQuery().next().click(interaction);
    }
    public void click() {
        if (getQuery().isEmpty()) {return;}
        getQuery().next().click(0);
    }
}
