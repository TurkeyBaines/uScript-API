package org.data;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.callback.ClientThread;
import org.data.database.Areas;
import org.data.database.Objects;
import org.data.database.Widgets;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.queries.SimpleItemQuery;
import simple.hooks.simplebot.Keyboard;
import simple.hooks.wrappers.SimpleGroundItem;
import simple.hooks.wrappers.SimpleItem;
import simple.hooks.wrappers.SimpleNpc;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

import java.lang.reflect.Method;

public class Methods {

    /*
            Author: unix
            Discord: x_unix
     */

    private static ClientContext c = ClientContext.instance();
    private static ClientThread clientThread;

    public static void teleport(String options) {
        System.out.println("uScript > Methods\t|\tTeleporting: " + options);
        c = ClientContext.instance();
        if (options.equalsIgnoreCase("home")) {
            c.magic.castHomeTeleport();
            c.sleep(1000);
            return;
        }
        if (Widgets.x.TELEPORT_MAIN.get() == null) {
            c.menuActions.sendAction(57, -1, 10616863, 2, "Teleport", "");
            c.sleepCondition(() -> (Widgets.x.TELEPORT_MAIN.get() != null && Widgets.x.TELEPORT_MAIN.get().visibleOnScreen()), 1000);
        }

        if (Widgets.x.TELEPORT_MAIN.get().getText().equals("Teleport Panel")) {
            char[] l = options.toCharArray();
            for (int i = 0; i < l.length; i++) {
                c.keyboard.clickKey(l[i]);
                c.sleep(250);
            }
        }
    }

    public static void equipGear(int[] itemList) {
        for (int i : itemList) {
            if (c.inventory.populate().filter(i).isEmpty() || !c.equipment.populate().filter(i).isEmpty()) continue;
            c.inventory.populate().filter(i).next().menuAction("Wear");
            c.sleep(50);
        }
    }

    public static void equipWeapon(int[] itemList) {
        for (int i : itemList) {
            if (c.inventory.populate().filter(i).isEmpty()) continue;
            c.inventory.populate().filter(i).next().menuAction("Wield");
            c.sleep(50);
        }
    }

    public static void walk(WorldPoint tile) {
        ClientContext c = ClientContext.instance();
        c.menuActions.step(tile);

    }

    public static String formatTimeRunning(long start_time) {
        long running = System.currentTimeMillis() - start_time;
        long millis = running % 1000;
        long second = (running / 1000) % 60;
        long minute = (running / (1000 * 60)) % 60;
        long hour = (running / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
    }

    public static String formatGained(int start_xp, int current_xp) {
        int gained = current_xp - start_xp;
        String output = "";
        if (gained > 1000 && gained < 10000) {
            output = String.valueOf(gained).substring(0, 1) + "K";
        } else if (gained > 9999 && gained < 100000) {
            output = String.valueOf(gained).substring(0, 2) + "K";
        } else if (gained > 99999 && gained < 1000000) {
            output = String.valueOf(gained).substring(0, 3) + "K";
        } else if (gained > 999999 && gained < 10000000) {
            output = String.valueOf(gained).substring(0, 1) + "M";
        } else if (gained > 9999999) {
            output = String.valueOf(gained).substring(0, 2) + "M";
        } else {
            output = String.valueOf(gained);
        }

        return output;
    }

    public static boolean standingOnTile(WorldPoint[] tiles) {
        for (WorldPoint t : tiles) {
            if (c.players.getLocal().getLocation().equals(t)) {
                return true;
            }
        }
        return false;
    }

    public static void fairyRing(String path) {
        c = ClientContext.instance();
        long startTime = System.currentTimeMillis();

        while (!Areas.Home.BANK_AREA.contains(c.players.getLocal().getLocation()) && (System.currentTimeMillis() - startTime) < 5000) {
            Methods.teleport("11");
            c.sleepCondition(() -> Areas.Home.BANK_AREA.contains(c.players.getLocal().getLocation()));
        }

        if (Widgets.FairyRing.MAIN.get() == null) {
            System.out.println("Opening Fairy Ring...");

            startTime = System.currentTimeMillis();
            WorldPoint target = new WorldPoint(1951, 3271, 0);
            while (!target.equals(c.players.getLocal().getLocation()) && ((System.currentTimeMillis() - startTime) < 5000)) {
                walk(target);
                c.sleep(1000);

            }

            Objects.Teleportation.FAIRY_RING.getQuery().next().click("Configure");
            c.sleepCondition(() -> Widgets.FairyRing.MAIN.get() != null);
        }

        int number1 = 0, number2 = 0, number3 = 0;
        char[] input = path.toLowerCase().toCharArray();
        System.out.println("input: " + path.toLowerCase());
        System.out.println(input[0]);
        switch (input[0]) {
            case 'a': number1 = 0; break;
            case 'b': number1 = 3; break;
            case 'c': number1 = 2; break;
            case 'd': number1 = 1; break;
        }
        System.out.println(input[1]);
        switch (input[1]) {
            case 'i': number2 = 0; break;
            case 'j': number2 = 3; break;
            case 'k': number2 = 2; break;
            case 'l': number2 = 1; break;
        }
        System.out.println(input[2]);
        switch (input[2]) {
            case 'p': number3 = 0; break;
            case 'q': number3 = 3; break;
            case 'r': number3 = 2; break;
            case 's': number3 = 1; break;
        }
        System.out.println("1: " + number1 + " |2: " + number2 + " |3: " + number3 + "" );
        c.sleepCondition(() -> Widgets.FairyRing.MAIN.get() != null, 5000);

        startTime = System.currentTimeMillis();
        while (c.varpbits.varpbit(3985) != number1 && (System.currentTimeMillis() - startTime) < 5000) {
            Widgets.FairyRing.LEFT_MOVE.get().click(0);
            c.sleep(600);
        }
        startTime = System.currentTimeMillis();

        while (c.varpbits.varpbit(3986) != number2 && (System.currentTimeMillis() - startTime) < 5000) {
            Widgets.FairyRing.MIDDLE_MOVE.get().click(0);
            c.sleep(600);
        }
        startTime = System.currentTimeMillis();

        while (c.varpbits.varpbit(3987) != number3 && (System.currentTimeMillis() - startTime) < 5000) {
            Widgets.FairyRing.RIGHT_MOVE.get().click(0);
            c.sleep(600);
        }
        c.sleep(1000);

        c.menuActions.sendAction(57, -1, 26083354, 1, "Confirm", "");
        c.sleep(2000);
        
    }

}
