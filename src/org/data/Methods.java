package org.data;

import net.runelite.api.coords.WorldPoint;
import org.data.database.Widgets;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.queries.SimpleItemQuery;
import simple.hooks.wrappers.SimpleGroundItem;
import simple.hooks.wrappers.SimpleItem;
import simple.hooks.wrappers.SimpleNpc;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Methods {

    /*
            Author: unix
            Discord: x_unix
     */

    private static ClientContext c = ClientContext.instance();

    public static void teleport(String s) {

        if (c.widgets.getWidget(1028, 101).visibleOnScreen()) {

        }

        switch (s) {
            case "home":
                break;

            case "essence_mine":
                break;

        }
    }

    public static boolean runRandomCheck() {
        boolean needsAction = false;

        if (!c.npcs.populate().filter(Database.npcs().PILLORY_GUARD).isEmpty()) {
            for (SimpleNpc n : c.npcs) {
                if (n.getInteracting().getName().equals(c.players.getLocal().getName())) {
                    needsAction = true;
                }
            }
        }
        if (!needsAction) {
            return false;
        }

        if (Widgets.x.NPC_DIALOGUE_MASTER.get() != null) {
            Widgets.x.NPC_DIALOGUE_CONTINUE.get().click(0);
            c.sleep(500);
            System.out.println("\t <@unix> \t {runRandomCheck()} Clicking Continue...");
            return true;
        }
        if (Widgets.x.PLAYER_DIALOGUE_MASTER.get() != null) {
            Widgets.x.PLAYER_DIALOGUE_CONTINUE.get().click(0);
            c.sleep(500);
            System.out.println("\t <@unix> \t {runRandomCheck()} Clicking Continue...");
            return true;
        }

        SimpleEntityQuery<SimpleNpc> seq = c.npcs.populate().filter(Database.npcs().PILLORY_GUARD);
        if (seq.isEmpty()) {
            System.out.println("\t <@unix> \t {runRandomCheck()} Couldn't find a Pillory Guard!");
            return true;
        }

        System.out.println("\t <@unix> \t {runRandomCheck()} We Found A Guard!!");
        for (SimpleNpc n : seq) {
            System.out.println("\t\t Interacting With: " + n.getInteracting().getName());
            if (n.getInteracting().getName().equals(c.players.getLocal().getName())) {
                Methods.intEntity(1, n.getId(), 500);
                return true;
            }
        }
        return false;
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
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click(interaction);
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
                if (!sGItm.visibleOnScreen()) {
                    sGItm.turnTo();
                    c.sleepCondition(() -> sGItm.visibleOnScreen(), 2500);
                }
                sGItm.click("Pick-up");
                break;
        }
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

    public static String formatTimeRunning(long st) {
        long running = System.currentTimeMillis() - st;
        long millis = running % 1000;
        long second = (running / 1000) % 60;
        long minute = (running / (1000 * 60)) % 60;
        long hour = (running / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
    }

    public static String formatGained(int sxp, int current) {
        int gained = current - sxp;
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

}
