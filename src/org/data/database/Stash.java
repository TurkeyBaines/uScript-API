package org.data.database;

import simple.robot.api.ClientContext;

public class Stash {

    private static ClientContext c = ClientContext.instance();

    public enum Easy {
        ARDY_MILL(5209, 1, 28971, "Search", new int[] { Outfits.Ham.HAM_ROBE.getID(), Outfits.ClueItems.BLUE_GNOME_SHIRT.getID(), Items.Skills.Crafting.Jewellery.Tiara.TIARA.getID() }),
        LEGENDS_GUILD(5200, 1, 28962, "Search", new int[] { Melee.Platelegs.IRON_PLATELEGS.getID(), Range.Longbow.OAK_LONGBOW.getID(), Items.Skills.Crafting.Jewellery.Amulet.EMERALD_AMULET.getID() }),
        DRAYNOR_CROSSROADS(5206, 1, 28968, "Search", new int[] { Melee.Chainbody.IRON_CHAINBODY.getID(), Items.Skills.Crafting.Jewellery.Ring.SAPPHIRE_RING.getID(), Range.Longbow.LONGBOW.getID() }),
        RIM_CROSSROADS(5214, 1, 28976, "Search", new int[] { Outfits.ClueItems.CREAM_GNOME_TOP.getID(), Outfits.ClueItems.GREEN_GNOME_HAT.getID(), Range.Chaps.LEATHER_CHAPS.getID() }),
        LIMESTONE_MINE(5199, 1, 28961, "Search", new int[] { Melee.Platelegs.BRONZE_PLATELEGS.getID(), Items.Skills.Mining.Pickaxe.STEEL_PICKAXE.getID(), Melee.MedHelm.STEEL_MED_HELM.getID() }),
        SAWMILL(5219, 1, 28981, "Search", new int[] {Items.Skills.Woodcutting.Axes.BRONZE_AXE.getID(), Range.Chaps.LEATHER_CHAPS.getID(), Range.Body.HARDLEATHER_BODY.getID() }),
        WIZARD_TOWER_BRIDGE(5197, 1, 28959, "Search", new int[] { Items.General.WHITE_APRON.getID(), Melee.MedHelm.IRON_MED_HELM.getID(), Items.Skills.Crafting.Jewellery.Ring.EMERALD_RING.getID() }),
        FALADOR_GEM_SHOP(5222, 1, 28984, "Search", new int[] { Melee.Platebody.BLACK_PLATEBODY.getID(), Melee.KiteShield.IRON_KITE_SHIELD.getID(), Items.Skills.Mining.Pickaxe.MITHRIL_PICKAXE.getID() }),
        VARROCK_RUNE_SHOP(5224, 1, 28986, "Search", new int[] { Mage.Staff.Elemental.STAFF_OF_WATER.getId(), Items.Skills.Runecrafting.AIR_TIARA.getID() }),
        ARDOUGNE_ZOO(5213, 1, 28975, "Search", new int[] { Outfits.ClueItems.STAFF.getID(), Melee.Platelegs.BRONZE_PLATELEGS.getID(), Range.Body.STUDDED_BODY.getID() }),
        DUEL_ARENA_TICKETS(5220, 1, 28982, "Search", new int[] { Melee.Chainbody.IRON_CHAINBODY.getID(), Range.Coif.COIF.getID(), Range.Chaps.LEATHER_CHAPS.getID() }),
        DRAYNOR_MARKET(5198, 1, 28960, "Search", new int[] { Melee.KiteShield.IRON_KITE_SHIELD.getID(), Range.Chaps.STUDDED_CHAPS.getID(), Melee.Longsword.STEEL_LONGSWORD.getID() }),
        BEEHIVE(5212, 1, 28974, "Search", new int[] { Outfits.ClueItems.BLUE_GNOME_SHIRT.getID(), Outfits.Desert.TOP.getID(), Items.Skills.Woodcutting.Axes.STEEL_AXE.getID() });

        final int pvar1, pval1, objectID;
        final String action;
        final int[] items;

        Easy(int pvar1, int pval1, int objectID, String action, int[] items) {
            this.pvar1 = pvar1;
            this.pval1 = pval1;
            this.objectID = objectID;
            this.action = action;
            this.items = items;
        }

        public boolean stashBuilt() {
            return c.varpbits.varpbit(pvar1) == pval1;
        }

        public int[] stashItems() {
            return items;
        }

        public boolean itemsInvInventory() {
            return !c.inventory.populate().filter(items).isEmpty();
        }

        public boolean itemsEquipped() {
            return c.equipment.populate().filter(items).size() == items.length;
        }

        public void grabItems() {
            c.objects.populate().filter(objectID).next().menuAction(action);
            c.sleepCondition(() -> itemsEquipped());
        }

        public void depositItems() {
            c.objects.populate().filter(objectID).next().menuAction(action);
            c.sleepCondition(() -> !itemsEquipped());
        }
    }

    public enum Medium {
        DIGSITE_WINCH(5236, 1, 28997, "Search", new int[] { Outfits.ClueItems.GREEN_GNOME_HAT.getID(), Items.Skills.Mining.Pickaxe.IRON_PICKAXE.getID(), Range.Boots.SNAKESKIN_BOOTS.getID() }),
        CANIFIS_CENTRE(5226, 1, 28987, "Search", new int[] { Outfits.ClueItems.GREEN_GNOME_TOP.getID(), Melee.Platelegs.MITHRIL_PLATELEGS.getID(), Melee.TwoHSword.IRON_2H_SWORD.getID() }),
        BRIM_AGILITY(5231, 1, 28992, "Search", new int[] { Melee.Platebody.STEEL_PLATEBODY.getID(), Range.Shortbow.MAPLE_SHORTBOW.getID() }),
        TZHAAR_WEAPONS(5243, 1, 29004, "Search", new int[] { Melee.Longsword.STEEL_LONGSWORD.getID(), Range.Body.BLUE_DHIDE_BODY.getID(), Mage.Gloves.MYSTIC_GLOVES.getId() });

        final int pvar1, pval1, objectID;
        final String action;
        final int[] items;

        Medium(int pvar1, int pval1, int objectID, String action, int[] items) {
            this.pvar1 = pvar1;
            this.pval1 = pval1;
            this.objectID = objectID;
            this.action = action;
            this.items = items;
        }

        public boolean stashBuilt() {
            return c.varpbits.varpbit(pvar1) == pval1;
        }

        public int[] stashItems() {
            return items;
        }

        public boolean itemsInvInventory() {
            return !c.inventory.populate().filter(items).isEmpty();
        }

        public boolean itemsEquipped() {
            return c.equipment.populate().filter(items).size() == items.length;
        }

        public void grabItems() {
            c.objects.populate().filter(objectID).next().menuAction(action);
            c.sleepCondition(() -> itemsEquipped());
        }

        public void depositItems() {
            c.objects.populate().filter(objectID).next().menuAction(action);
            c.sleepCondition(() -> !itemsEquipped());
        }
    }

}
