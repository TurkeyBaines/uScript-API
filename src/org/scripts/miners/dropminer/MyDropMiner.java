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

// Script manifest providing metadata about the script
@ScriptManifest(
        servers = {"OldschoolRSPS"}, // Server the script is designed for
        discord = "x_unix", // Discord handle for support
        version = "1", // Script version
        name = "Iron Drop Miner", // Script name
        author = "unix", // Script author
        category = Category.MINING, // Script category
        description = "Demo Iron Drop Miner" // Description of the script
)
public class MyDropMiner extends Script {

    // This will hold the instance of the script controller
    private static ScriptController scriptController;

    // This method is called when a chat message is received in the game
    @Override
    public void onChatMessage(ChatMessage chatMessage) {
        // Handle chat messages here (if needed)
    }

    // This method is called when the script is started
    @Override
    public void onExecute() {
        // Initialize the script controller
        scriptController = new ScriptController();

        // Add mining task to the script controller with the identifier "Mine"
        scriptController.addTask("Mine", new Mine());

        // Add dropping task to the script controller with the identifier "Drop"
        scriptController.addTask("Drop", new Drop());

        // Set the initial task to "Mine"
        scriptController.setTask("Mine");
    }

    // This method is called repeatedly to process the script logic
    @Override
    public void onProcess() {
        // Execute the current task in the script controller
        scriptController.run();
    }

    // This method is called when the script is stopped
    @Override
    public void onTerminate() {
        // Clean up resources or save data here (if needed)
    }

    // This method is called to render graphics on the screen (e.g., for a script overlay)
    @Override
    public void paint(Graphics graphics) {
        // Draw graphics here (if needed)
    }

    // Getter method to access the script controller
    public static ScriptController getScriptController() {
        return scriptController;
    }
}
