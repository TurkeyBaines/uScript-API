package org.scripts.miners.dropminer.tasks;

import org.data.database.Items;
import org.scripter.Task;
import org.scripts.miners.dropminer.MyDropMiner;
import simple.hooks.wrappers.SimpleItem;

// Drop task class responsible for dropping items in the player's inventory
public class Drop extends Task {

    // Array of pickaxe IDs, used to identify pickaxes in the inventory
    int[] pickaxes = Items.Skills.Mining.Pickaxe.ALL.getIDs();

    // Method containing the logic for the drop task
    @Override
    public void run() {
        // Check if the inventory is empty (ignoring pickaxes)
        if (c.inventory.populate().omit(pickaxes).size() == 0) {
            // If inventory is empty, switch the task back to "Mine"
            MyDropMiner.getScriptController().setTask("Mine");
            return; // Exit the method
        }

        // Loop through all non-pickaxe items in the inventory
        for (SimpleItem oreItem : c.inventory.populate().omit(pickaxes)) {
            // Perform the "Drop" action on the item
            oreItem.menuAction("Drop");
            // Sleep for a short duration to mimic human behavior
            c.sleep(50);
        }
    }

    // Method providing a description of the task, useful for debugging
    @Override
    public String DebugTaskDescription() {
        return "Drop Task";
    }
}
