package org.scripts.miners.dropminer.tasks;

import net.runelite.api.coords.WorldPoint;
import org.data.database.Objects;
import org.scripter.Task;
import org.scripts.miners.dropminer.MyDropMiner;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

// Mine task class responsible for mining actions in the game
public class Mine extends Task {
    // Instance of ClientContext to interact with the game client
    ClientContext c = ClientContext.instance();

    // Variable to store the last time an action was performed
    long lastAction = System.currentTimeMillis();

    // Variable to store the current rock being mined
    public SimpleObject ourRock;

    // Method containing the logic for the mine task
    @Override
    public void run() {
        // Check if the player is currently mining (animation ID for mining is 628)
        if (c.players.getLocal().getAnimation() == 628) {
            // Update the last action time
            lastAction = System.currentTimeMillis();
        }

        // Check if the inventory is full (28 items)
        if (c.inventory.populate().size() == 28) {
            // If inventory is full, switch the task to "Drop"
            MyDropMiner.getScriptController().setTask("Drop");
            return; // Exit the method
        }

        // Check if there is no rock currently being mined
        if (ourRock == null) {
            // Find the nearest iron rock to mine
            ourRock = Objects.Skills.Mining.IRON_ROCK.getQuery().nextNearest();
        } else {
            // Check if it's time to perform the next mining action
            if ((System.currentTimeMillis() - lastAction) > 1000) {
                // Perform the "Mine" action on the rock
                ourRock.menuAction("Mine");
                // Update the last action time
                lastAction = System.currentTimeMillis();
            }
        }
    }

    // Method providing a description of the task, useful for debugging
    @Override
    public String DebugTaskDescription() {
        return "Mining Task";
    }
}
