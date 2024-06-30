package org.scripts.miners.dropminer.tasks;

import net.runelite.api.coords.WorldPoint;
import org.data.database.Objects;
import org.scripter.Task;
import org.scripts.miners.dropminer.MyDropMiner;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Mine extends Task {
    ClientContext c = ClientContext.instance();

    long lastAction = System.currentTimeMillis();

    public SimpleObject ourRock;

    @Override
    public void run() {

        if (c.players.getLocal().getAnimation() == 628) {
            lastAction = System.currentTimeMillis();
        }

        if (c.inventory.populate().size() == 28) {

            MyDropMiner.getScriptController().setTask("Drop");
            return;
        }

        if (ourRock == null) {

            ourRock = Objects.Skills.Mining.IRON_ROCK.getQuery().nextNearest();
        } else {

            if ((System.currentTimeMillis() - lastAction) > 1000) {

                ourRock.menuAction("Mine");
                lastAction = System.currentTimeMillis();
            }
        }



    }

    @Override
    public String DebugTaskDescription() {
        return "Mining Task";
    }
}
