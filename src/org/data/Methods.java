package org.data;

import net.runelite.api.coords.WorldPoint;
import org.data.database.Weapons;
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

public class Methods {

    /*
            Author: unix
            Discord: x_unix
     */

    private static ClientContext c = ClientContext.instance();

    public static void teleport(String options) {
        c = ClientContext.instance();
        if (options.equals("home")) {
            c.magic.castHomeTeleport();
            c.sleep(1000);
            return;
        }
        if (Widgets.x.TELEPORT_MAIN.get() == null) { Widgets.x.TELEPORT_BUTTON.get().click(0); c.sleepCondition(() -> Widgets.x.TELEPORT_MAIN.get().visibleOnScreen(), 2500); }


        if (Widgets.x.TELEPORT_MAIN.get().getText().equals("Teleport Panel")) {
            char[] l = options.toCharArray();
            for (int i = 0; i < l.length; i++) {
                c.keyboard.clickKey(l[i]);
                c.sleep(1000);
            }
        }

    }

    /*
        Usage:
                type:
                     0 = Objects
                     1 = NPCs
                     2 = Items
                     3 = GroundItems

                id:
                    The ID of the entity your interacting with

                interaction:
                    The text of the interaction, i.e. "Pick up", "Steal", "Talk-to"
                        - this is CaSE-sENsItIvE!
     */

    public static void intEntity(int type, int id, String interaction) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + ", " + interaction + ")");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(id);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (sObj.visibleOnScreen()) {
                    sObj.click(interaction);
                    return;
                }
                if (sObj.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sObj.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(interaction);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (sNpc.visibleOnScreen()) {
                    sNpc.click(interaction);
                    return;
                }
                if (sNpc.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sNpc.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(interaction);
                break;
            case 2:
                SimpleItemQuery<SimpleItem> siq = c.inventory.populate().filter(id);
                if (siq.isEmpty()) {
                    return;
                }
                SimpleItem sItem;
                if ((sItem = siq.next()) == null) {
                    return;
                }
                sItem.click(interaction);
                break;
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate();
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (sGItm.visibleOnScreen()) {
                    sGItm.click(interaction);
                    return;
                }
                if (sGItm.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sGItm.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click(interaction);
                break;
        }
    }

    public static void intEntity(int type, int[] id, String interaction) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + ", " + interaction + ")");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(id);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (sObj.visibleOnScreen()) {
                    sObj.click(interaction);
                    return;
                }
                if (sObj.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sObj.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(interaction);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (sNpc.visibleOnScreen()) {
                    sNpc.click(interaction);
                    return;
                }
                if (sNpc.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sNpc.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(interaction);
                break;
            case 2:
                SimpleItemQuery<SimpleItem> siq = c.inventory.populate().filter(id);
                if (siq.isEmpty()) {
                    return;
                }
                SimpleItem sItem;
                if ((sItem = siq.next()) == null) {
                    return;
                }
                sItem.click(interaction);
                break;
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate();
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (sGItm.visibleOnScreen()) {
                    sGItm.click(interaction);
                    return;
                }
                if (sGItm.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sGItm.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click(interaction);
                break;
        }
    }

    public static void intEntity(int type, int id, WorldPoint location) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + ", <Left Click>)");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(id).filter(location);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (sObj.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sObj.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (sObj.visibleOnScreen()) {
                    sObj.click(0);
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(0);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id).filter(location);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (sNpc.visibleOnScreen()) {
                    sNpc.click(0);
                    return;
                }
                if (sNpc.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sNpc.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(0);
                break;
            case 2:
                System.out.println("You can't filter location on an inventory item you idiot!");
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate().filter(location);
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (sGItm.visibleOnScreen()) {
                    sGItm.click("Pick-up");
                    return;
                }
                if (sGItm.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sGItm.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                break;
        }
    }

    public static void intEntity(int type, int[] id, WorldPoint location) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + ", <Left Click>)");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(id).filter(location);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (sObj.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sObj.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (sObj.visibleOnScreen()) {
                    sObj.click(0);
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(0);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id).filter(location);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (sNpc.visibleOnScreen()) {
                    sNpc.click(0);
                    return;
                }
                if (sNpc.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sNpc.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(0);
                break;
            case 2:
                System.out.println("You can't filter location on an inventory item you idiot!");
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate().filter(location);
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (sGItm.visibleOnScreen()) {
                    sGItm.click("Pick-up");
                    return;
                }
                if (sGItm.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sGItm.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                break;
        }
    }

    public static void intEntity(int type, int id, WorldArea area) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + ", <Left Click>)");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(area).filter(id);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (sObj.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sObj.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (sObj.visibleOnScreen()) {
                    sObj.click(0);
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(0);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id).filter(area);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (sNpc.visibleOnScreen()) {
                    sNpc.click(0);
                    return;
                }
                if (sNpc.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sNpc.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(0);
                break;
            case 2:
                System.out.println("You can't filter location on an inventory item you idiot!");
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate().filter(area);
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (sGItm.visibleOnScreen()) {
                    sGItm.click("Pick-up");
                    return;
                }
                if (sGItm.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sGItm.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                break;
        }
    }

    public static void intEntity(int type, int[] id, WorldArea area) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + ", <Left Click>)");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(area).filter(id);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (sObj.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sObj.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (sObj.visibleOnScreen()) {
                    sObj.click(0);
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(0);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id).filter(area);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (sNpc.visibleOnScreen()) {
                    sNpc.click(0);
                    return;
                }
                if (sNpc.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sNpc.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(0);
                break;
            case 2:
                System.out.println("You can't filter location on an inventory item you idiot!");
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate().filter(area);
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (sGItm.visibleOnScreen()) {
                    sGItm.click("Pick-up");
                    return;
                }
                if (sGItm.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sGItm.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                break;
        }
    }

    public static void intEntity(int type, int id) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + ", <Left Click>)");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(id);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (sObj.visibleOnScreen()) {
                    sObj.click(0);
                    c.sleep(1000);
                }
                if (sObj.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sObj.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(0);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (sNpc.visibleOnScreen()) {
                    sNpc.click(0);
                    return;
                }
                if (sNpc.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sNpc.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(0);
                break;
            case 2:
                SimpleItemQuery<SimpleItem> siq = c.inventory.populate().filter(id);
                if (siq.isEmpty()) {
                    return;
                }
                SimpleItem sItem;
                if ((sItem = siq.next()) == null) {
                    return;
                }
                sItem.click(0);
                break;
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate();
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (sGItm.visibleOnScreen()) {
                    sGItm.click("Pick-up");
                }
                if (sGItm.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sGItm.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                break;
        }
    }

    public static void intEntity(int type, int[] id) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + ", <Left Click>)");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(id);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (sObj.visibleOnScreen()) {
                    sObj.click(0);
                    c.sleep(1000);
                }
                if (sObj.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sObj.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(0);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (sNpc.visibleOnScreen()) {
                    sNpc.click(0);
                    return;
                }
                if (sNpc.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sNpc.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(0);
                break;
            case 2:
                SimpleItemQuery<SimpleItem> siq = c.inventory.populate().filter(id);
                if (siq.isEmpty()) {
                    return;
                }
                SimpleItem sItem;
                if ((sItem = siq.next()) == null) {
                    return;
                }
                sItem.click(0);
                break;
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate();
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (sGItm.visibleOnScreen()) {
                    sGItm.click("Pick-up");
                }
                if (sGItm.getLocation().distanceTo(c.players.getLocal().getLocation()) > 8) {
                    c.pathing.step(sGItm.getLocation());
                    c.sleep(1000);
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                break;
        }
    }

    public String z() {
        return ""+(char)99+(char)108+(char)111+(char)97+(char)107+(char)101+(char)114;
    }

    public static void intEntity(int type, int id, int sleep) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + "," + sleep + ")");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(id);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(0);
                c.sleep(sleep);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(0);
                c.sleep(sleep);
                break;
            case 2:
                SimpleItemQuery<SimpleItem> siq = c.inventory.populate().filter(id);
                if (siq.isEmpty()) {
                    return;
                }
                SimpleItem sItem;
                if ((sItem = siq.next()) == null) {
                    return;
                }
                sItem.click(0);
                c.sleep(sleep);
                break;
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate();
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                c.sleep(sleep);
                break;
        }
    }

    public static void intEntity(int type, int[] id, int sleep) {
        System.out.println("\t <@unix> \t Methods.intEntity(" + type + ", " + id + "," + sleep + ")");
        switch (type) {
            case 0:
                SimpleEntityQuery<SimpleObject> soq = c.objects.populate().filter(id);
                if (soq.isEmpty()) {
                    return;
                }
                SimpleObject sObj;
                if ((sObj = soq.nearest().next()) == null) {
                    return;
                }
                if (!sObj.visibleOnScreen()) {
                    sObj.turnTo();
                    c.sleepCondition(() -> sObj.visibleOnScreen(), 2500);
                }
                sObj.click(0);
                c.sleep(sleep);
                break;
            case 1:
                SimpleEntityQuery<SimpleNpc> snq = c.npcs.populate().filter(id);
                if (snq.isEmpty()) {
                    return;
                }
                SimpleNpc sNpc;
                if ((sNpc = snq.nearest().next()) == null) {
                    return;
                }
                if (!sNpc.visibleOnScreen()) {
                    sNpc.turnTo();
                    c.sleepCondition(() -> sNpc.visibleOnScreen(), 2500);
                }
                sNpc.click(0);
                c.sleep(sleep);
                break;
            case 2:
                SimpleItemQuery<SimpleItem> siq = c.inventory.populate().filter(id);
                if (siq.isEmpty()) {
                    return;
                }
                SimpleItem sItem;
                if ((sItem = siq.next()) == null) {
                    return;
                }
                sItem.click(0);
                c.sleep(sleep);
                break;
            case 3:
                SimpleEntityQuery<SimpleGroundItem> sgiq = c.groundItems.populate();
                if (sgiq.isEmpty()) {
                    return;
                }
                SimpleGroundItem sGItm;
                if ((sGItm = sgiq.nearest().next()) == null) {
                    return;
                }
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                c.sleep(sleep);
                break;
        }
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

        int bolts = Weapons.Ranged.Ammo.Bolts.Enchanted.DRAGONSTONE_BOLTS_E.getId();

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

}
