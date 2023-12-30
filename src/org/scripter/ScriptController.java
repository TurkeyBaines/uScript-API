package org.scripter;

import simple.robot.api.ClientContext;

import java.util.HashMap;

public class ScriptController {
    private static HashMap<String, Task> tasks;
    private static Task currentTask;
    private Boolean running;
    private ClientContext c;

    public ScriptController() {
        c = ClientContext.instance();
        tasks = new HashMap<>();
    }

    public void addTask(String name, Task task) {
        tasks.put(name.toLowerCase(), task);
        System.out.println("{ScriptController} - Added Task: " + name);
    }

    public void setTask(String name) {
        String curr = "";
        try {
            curr = currentTask.DebugTaskDescription();
        } catch (NullPointerException e) {
            curr = "Null";
        }
        System.out.println("{ScriptController} - Setting Task  [" + curr + "] --> [" + name + "]");
        currentTask = tasks.get(name.toLowerCase());
    }

    public void runTask() {
        String curr = "";
        try {
            curr = currentTask.DebugTaskDescription();
        } catch (NullPointerException e) {
            curr = "Null";
        }
        System.out.println("{ScriptController} - Running Task [" + curr + "]");
        currentTask.runtime();
    }

    public Task getTask() {
        return currentTask;
    }

    public Task getTask(String name) {
        return tasks.get(name);
    }

    public InterruptableTask getTask(int r, String name) {
        return (InterruptableTask) tasks.get(name);
    }

    public void pause() {
        running = false;
    }

    public void play() {
        running = true;
    }
}

