package org.scripts.woodcutter.tasks;

import org.data.database.Items;
import org.scripter.Task;
import org.scripts.woodcutter.MyWoodcutter;

public class Bank extends Task {
    @Override
    public void run() {
        int[] woodcuttingAxes = Items.Skills.Woodcutting.AXE.getIds(); // grabs a list of all the woodcutting axes id's

        /*
        * I always start my Bank Task with a check to see if the bank is open or not
        */

        if (c.bank.bankOpen()) { // If the bank interface is open...

            if (c.inventory.populate().omit(woodcuttingAxes).size() > 0) { // If we have something more than a woodcutting axe in our inventory

                c.bank.depositAllExcept(woodcuttingAxes); // Deposit the inventory (Except our Axes)
                c.sleep(600); // sleep for x milliseconds

            } else { // If we only have an axe left in our inventory

                c.bank.closeBank(); // close the bank interface
                c.sleepCondition(() -> c.bank.bankOpen() == false); // sleep until the bank interface is closed, or 5 seconds has passed

            }

        } else { // If the bank interface is NOT open...

            if (c.inventory.populate().omit(woodcuttingAxes).size() > 0) { // We have something more than an Axe in our inventory

                c.bank.openBank(); // Open the bank!
                c.sleepCondition(() -> c.bank.bankOpen()); // sleep until the bank interface is open, or 5 seconds has passed

            } else { // We only have an axe in our inventory, we should swap the task!

                MyWoodcutter.getScriptController().setTask("Chop");

            }

        }
    }

    @Override
    public String DebugTaskDescription() {
        return "Bank Task";
    }
}
