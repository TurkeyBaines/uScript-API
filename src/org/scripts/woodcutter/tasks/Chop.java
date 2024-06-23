package org.scripts.woodcutter.tasks;

import org.data.database.Objects;
import org.scripter.Task;
import org.scripts.woodcutter.MyWoodcutter;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Chop extends Task {

    long lastActionTime; //We're going to use this to detect if we are woodcutting or not!

    @Override
    public void run() { //The main 'Chop' Loop

        /*
        Our inventory is full, so we should change the task to the next one...
        */
        if (c.inventory.populate().size() == 28) {
            //Our Inventory is full!
            if (MyWoodcutter.isBanking() == true) { //We set that we are banking!
                MyWoodcutter.getScriptController().setTask("Bank"); // Set the task to Bank

            } else { //We set that we are not banking!
                MyWoodcutter.getScriptController().setTask("Drop"); // Set the task to Drop
            }
            return; //Stop the run() method from continuing, and proceed to the new task
        }

        /*
        Our inventory is not full if we got here, so let's chop a tree!
        */

        long currentTime = System.currentTimeMillis(); //save the current time for simplicity
        if (c.players.getLocal().getAnimation() != -1) { //if we are animating, we want to set the lastActionTime to the current time
            lastActionTime = currentTime;
        }

        long timeSinceLastAnimation = currentTime - lastActionTime; //work out the time since last action

        if (timeSinceLastAnimation > 5000) { //if our last action was more than 5 seconds ago

            SimpleObject tree = Objects.Skills.Woodcutting.WILLOW_TREE.getQuery().nextNearest(); // grab the nearest Willow Tree using the API
            tree.menuAction("Chop"); // send a packet to 'Chop' the tree
            c.sleep(600); // sleep for x milliseconds
            return; //exit out to the loop again

        } else { //if the last action was NOT more than 5 seconds ago
            c.sleep(600); // sleep for x milliseconds
        }
    }

    @Override
    public String DebugTaskDescription() {
        return "Chop Task"; //A simple debug message, to tell which Task is currently running!
    }
}
