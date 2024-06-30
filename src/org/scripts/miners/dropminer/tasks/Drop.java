package org.scripts.miners.dropminer.tasks;

import org.data.database.Items;
import org.scripter.Task;
import org.scripts.miners.dropminer.MyDropMiner;
import simple.hooks.wrappers.SimpleItem;

public class Drop extends Task {

    int[] pickaxes = Items.Skills.Mining.Pickaxe.ALL.getIDs();

    @Override
    public void run() {

        if (c.inventory.populate().omit(pickaxes).size() == 0) {

            MyDropMiner.getScriptController().setTask("Mine");
            return;
        }

        for (SimpleItem oreItem : c.inventory.populate().omit(pickaxes)) {
            oreItem.menuAction("Drop");
            c.sleep(50);
        }

    }

    @Override
    public String DebugTaskDescription() {
        return "Drop Task";
    }
}
