package org.data.database;

import simple.hooks.wrappers.SimpleWidget;
import simple.robot.api.ClientContext;

public class Widgets {

    public enum x {

        NPC_DIALOGUE_MASTER(231, 3),
        NPC_DIALOGUE_NAME(231, 4),
        NPC_DIALOGUE_TEXT(321, 6),
        NPC_DIALOGUE_CONTINUE(231, 5),

        CLAIM_COIN_POUCH_CONTINUE(584, 1),

        PLAYER_DIALOGUE_MASTER(217, 4),
        PLAYER_DIALOGUE_TEXT(217, 6),
        PLAYER_DIALOGUE_CONTINUE(217, 5),

        TELEPORT_MAIN(1028, 21),
        TELEPORT_FAVORITES(1028, 286),
        TELEPORT_FAV_1(1028, 289),
        TELEPORT_FAV_2(1028, 292),
        TELEPORT_FAV_3(1028, 295),
        TELEPORT_TOP_ENTRY(1028, 272),

        BARROWS_POTENTIAL(24, 10);

        int mast, sub;
        ClientContext c;

        x(int Master, int Sub) {
            mast = Master;
            sub = Sub;
        }

        public SimpleWidget get() {
            if (c == null) {
                c = ClientContext.instance();
            }
            try {
                return c.widgets.getWidget(mast, sub);
            } catch (NullPointerException e) {
                return null;
            }
        }
    }
}
