package org.scripts.woodcutter.tasks;

import org.data.database.Items;
import org.scripter.Task;
import org.scripts.woodcutter.MyWoodcutter;
import simple.hooks.wrappers.SimpleItem;

public class Drop extends Task {

    @Override
    public void run() {
        int[] woodcuttingAxes = Items.Skills.Woodcutting.AXE.getIds(); // grabs a list of all the woodcutting axes id's

        if (c.inventory.populate().omit(woodcuttingAxes).size() > 0) { // check the size of the inventory if we ignore axes, if it's greater than 0, we need to drop!
            SimpleItem logs = c.inventory.populate().omit(woodcuttingAxes).next();
            logs.menuAction("Drop");
            c.sleep(50);

        } else { // if the size is 0, we have no logs left! lets swap the task back
            MyWoodcutter.getScriptController().setTask("Chop"); // swapping the task back to 'Chop' to get more logs!
        }
    }

    @Override
    public String DebugTaskDescription() {
        return "Drop Task";
    }
}
