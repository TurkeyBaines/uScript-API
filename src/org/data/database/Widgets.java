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

        TELEPORT_MAIN(612, 1),
        TELEPORT_BUTTON(162, 33),

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
