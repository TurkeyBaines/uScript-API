package org.scripts.woodcutter;

import org.scripter.ScriptController;
import org.scripts.woodcutter.tasks.Bank;
import org.scripts.woodcutter.tasks.Chop;
import org.scripts.woodcutter.tasks.Drop;
import simple.hooks.scripts.Category;
import simple.hooks.scripts.ScriptManifest;
import simple.hooks.simplebot.ChatMessage;
import simple.robot.api.ClientContext;
import simple.robot.script.Script;

import java.awt.*;

@ScriptManifest(servers = {"OldschoolRSPS"}, discord = "x_unix", version = "1", name = "<Demo> MyWoodcutter", author = "unix", category = Category.WOODCUTTING, description = "Demo Woodcutting Script")
public class MyWoodcutter extends Script {
    private static ScriptController scriptController = null; //Create a ScriptController Object
    private static boolean isBanking; //Tell the script if it's Banking or Not

    @Override
    public void onExecute() {
        scriptController = new ScriptController(); // initialize the script controller

        /*
        * Add all 3 tasks to the Script Controller with their respective names
        */
        scriptController.addTask("Chop", new Chop());
        scriptController.addTask("Drop", new Drop());
        scriptController.addTask("Bank", new Bank());

        // Set the Active Task within the script controller to something
        scriptController.setTask("Chop");

        isBanking = true; // We want to bank, so setting this to True, if not, set it to False
    }

    @Override
    public void onTerminate() {
        scriptController.clean(); // we should clean out the script controller before we end the script
        scriptController = null; // finally we should null the object
    }

    @Override
    public void onProcess() {
        scriptController.run(); // runs the script controller!
    }

    @Override
    public void onChatMessage(ChatMessage chatMessage) {

    }

    @Override
    public void paint(Graphics graphics) {

    }

    public static boolean isBanking() { //Create a quick method, to tell if 'isBanking' is true or false
        return isBanking;
    }

    public static ScriptController getScriptController() { //Create this method to allow us to change the Current Task!
        return scriptController;
    }
}
