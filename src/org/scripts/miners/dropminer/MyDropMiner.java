package org.scripts.miners.dropminer;

import net.runelite.api.events.GameObjectSpawned;
import net.runelite.client.eventbus.Subscribe;
import org.scripter.ScriptController;
import org.scripts.miners.dropminer.tasks.Drop;
import org.scripts.miners.dropminer.tasks.Mine;
import simple.hooks.scripts.Category;
import simple.hooks.scripts.ScriptManifest;
import simple.hooks.simplebot.ChatMessage;
import simple.robot.script.Script;

import java.awt.*;

@ScriptManifest(servers = {"OldschoolRSPS"}, discord = "x_unix", version = "1", name = "Iron Drop Miner", author = "unix", category = Category.MINING, description = "Demo Iron Drop Miner")
public class MyDropMiner extends Script {

    private static ScriptController scriptController;

    @Override
    public void onChatMessage(ChatMessage chatMessage) {

    }

    @Override
    public void onExecute() {

        scriptController = new ScriptController();
        scriptController.addTask("Mine", new Mine());
        scriptController.addTask("Drop", new Drop());

        scriptController.setTask("Mine");
    }

    @Override
    public void onProcess() {

        scriptController.run();

    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void paint(Graphics graphics) {

    }

    public static ScriptController getScriptController() {
        return scriptController;
    }

}
