package org.data.database.raids;

import net.runelite.api.GraphicsObject;
import net.runelite.api.coords.WorldPoint;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.queries.SimpleIdQuery;
import simple.hooks.queries.SimpleItemQuery;
import simple.hooks.wrappers.*;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class TOA {



    private static ClientContext c = ClientContext.instance();

    public static class Lobby {
        public enum Objects {
            ENTRANCE(46089);

            int id;
            Objects(int ID) {id = ID;}

            public SimpleObject get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }
        }

        public enum Npcs {}

        public static WorldArea Area() {
            return new WorldArea(new WorldPoint(3350, 9111, 0), new WorldPoint(3375, 9131, 0));
        }

        public enum Widgets {
            PARTY_STATUS(773, 4),
            PARTY_LIST(772, 2),
            MYPARTY_WIDGET(774, 3),
            MYPARTY_BUTTON(772, 64);

            int x, y;
            Widgets(int X, int Y) {x = X; y = Y;}


            public SimpleWidget get() {
                try {
                    return ClientContext.instance().widgets.getWidget(x, y);
                } catch (NullPointerException e) {
                    System.out.println("Failed to get widget {"+x+","+y+"}");
                }
                return null;
            }

        }
    }

    public static class Akkha {
        public enum Objects {
            A(-1);

            int[] id;
            Objects(int... ID) {
                id = ID;
            }
            public int getID() {return id[0];}
            public int[] getIDs() {return id;}

            public SimpleObject get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }

        }

        public enum Npcs {
            A(-1);

            int id;
            Npcs(int ID) {id = ID;}

            public int getID() {return id;}

            public SimpleNpc get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleNpc> getQuery() {
                return ClientContext.instance().npcs.populate().filter(id);
            }

            public void attackP() { getQuery().nextNearest().menuAction("Attack"); }
        }

        public enum Projectile {
            A(-1);

            int id;
            Projectile(int ID) {id = ID;}
            public SimpleIdQuery<SimpleProjectile> getQuery() {
                return c.projectiles.populate().filter(id);
            }
            public SimpleProjectile get() {
                return getQuery().next();
            }
        }

        public static class Areas {
        }

        public static class Lobby {
            public enum Items {
                A(-1);

                int id;
                Items(int ID) {
                    id = ID;
                }
                public int getID() {return id;}

                public SimpleItem get() {
                    return getInvQuery().next();
                }

                public SimpleItemQuery<SimpleItem> getInvQuery() {
                    return ClientContext.instance().inventory.populate().filter(id);
                }

                public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
                    return ClientContext.instance().groundItems.populate().filter(id);
                }
            }

            public enum Objects {
                EXIT(45128),
                PICKAXE(45468),
                CASTER(45486),
                SHIELD(45485),
                BARRIER(45135);

                int id;
                Objects(int ID) {
                    id = ID;
                }
                public int getID() {return id;}

                public SimpleObject get() {
                    return getQuery().nextNearest();
                }

                public SimpleEntityQuery<SimpleObject> getQuery() {
                    return ClientContext.instance().objects.populate().filter(id);
                }
            }

            public enum Npcs {
                A(-1);

                int id;
                Npcs(int ID) {
                    id = ID;
                }
                public int getID() {return id;}

                public SimpleNpc get() {
                    return getQuery().nextNearest();
                }

                public SimpleEntityQuery<SimpleNpc> getQuery() {
                    return ClientContext.instance().npcs.populate().filter(id);
                }
            }

            public enum Widgets {
                A(-1, -1);

                int x, y;
                Widgets(int X, int Y) {x = X; y = Y;}


                public SimpleWidget get() {
                    try {
                        return ClientContext.instance().widgets.getWidget(x, y);
                    } catch (NullPointerException e) {
                        System.out.println("Failed to get widget {"+x+","+y+"}");
                    }
                    return null;
                }
            }

            public static WorldPoint base() {return new WorldPoint(Objects.EXIT.get().getLocation().getX()-8, Objects.EXIT.get().getLocation().getY(), 0);}
        }
    }

    public static class Zebak {
        public enum Objects {
            EXIT(45543),
            CRYSTAL(45506),
            ACID_BLOBS(45571, 45572, 45573, 45574, 45575),
            BOULDER(43876);

            int[] id;
            Objects(int... ID) {
                id = ID;
            }
            public int getID() {return id[0];}
            public int[] getIDs() {return id;}

            public SimpleObject get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }

        }

        public enum Npcs {
            ZEBAK(11730),
            JUG(11735),
            WAVES(11738),
            ZEBAK_ATTACK(11744);

            int id;
            Npcs(int ID) {id = ID;}

            public int getID() {return id;}

            public SimpleNpc get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleNpc> getQuery() {
                return ClientContext.instance().npcs.populate().filter(id);
            }

            public void attackP() { getQuery().nextNearest().menuAction("Attack"); }
        }

        public enum Projectile {
            RANGE(2178),
            MAGE(2176);

            int id;
            Projectile(int ID) {id = ID;}
            public SimpleIdQuery<SimpleProjectile> getQuery() {
                return c.projectiles.populate().filter(id);
            }
            public SimpleProjectile get() {
                return getQuery().next();
            }
        }

        public static class Areas {
            public static WorldArea Landing() {
                try {
                    WorldPoint base = Objects.CRYSTAL.get().getLocation();
                    WorldPoint bot = new WorldPoint(base.getX() - 2, base.getY() - 7, base.getPlane());
                    WorldPoint top = new WorldPoint(base.getX() + 8, base.getY() + 7, base.getPlane());
                    return new WorldArea(bot, top);
                } catch (Exception e) {
                    System.out.println("Unable to find Teleport Crystal..");
                    return null;
                }
            }

            public static WorldArea Combat() {
                try {
                    WorldPoint base = Objects.CRYSTAL.get().getLocation();
                    WorldPoint bot = new WorldPoint(base.getX()-30, base.getY()-11, base.getPlane());
                    WorldPoint top = new WorldPoint(base.getX()-11, base.getY()+11, base.getPlane());
                    return new WorldArea(bot, top);
                } catch (Exception e) {
                    System.out.println("Unable to find Teleport Crystal..");
                    return null;
                }
            }

            public static WorldArea WaveCheck() {
                try {
                    WorldPoint base = Objects.CRYSTAL.get().getLocation();
                    WorldPoint bot = new WorldPoint(base.getX()-10, base.getY()-12, base.getPlane());
                    WorldPoint top = new WorldPoint(base.getX()-13, base.getY()+12, base.getPlane());
                    return new WorldArea(bot, top);
                } catch (Exception e) {
                    System.out.println("Unable to find Teleport Crystal..");
                    return null;
                }
            }
        }

        public static class Lobby {
            public enum Items {
                WATER_JUG(27295);

                int id;
                Items(int ID) {
                    id = ID;
                }
                public int getID() {return id;}

                public SimpleItem get() {
                    return getInvQuery().next();
                }

                public SimpleItemQuery<SimpleItem> getInvQuery() {
                    return ClientContext.instance().inventory.populate().filter(id);
                }

                public SimpleEntityQuery<SimpleGroundItem> getGroQuery() {
                    return ClientContext.instance().groundItems.populate().filter(id);
                }
            }

            public enum Objects {
                EXIT(45453),
                BARRIER(45135),
                WATERFALL(45398),
                ENTRY(45397),
                ACID_ORB(45403);

                int id;
                Objects(int ID) {
                    id = ID;
                }
                public int getID() {return id;}

                public SimpleObject get() {
                    return getQuery().nextNearest();
                }

                public SimpleEntityQuery<SimpleObject> getQuery() {
                    return ClientContext.instance().objects.populate().filter(id);
                }
            }

            public enum Npcs {
                CROCODILE(11705),
                PLANT(11700, 11702);

                int[] id;
                Npcs(int... ID) {
                    id = ID;
                }
                public int[] getID() {return id;}

                public SimpleNpc get() {
                    return getQuery().nextNearest();
                }

                public SimpleEntityQuery<SimpleNpc> getQuery() {
                    return ClientContext.instance().npcs.populate().filter(id);
                }
            }

            public enum Widgets {
                MAIN(303, 5),
                PROGRESS(303, 20);

                int x, y;
                Widgets(int X, int Y) {x = X; y = Y;}


                public SimpleWidget get() {
                    try {
                        return ClientContext.instance().widgets.getWidget(x, y);
                    } catch (NullPointerException e) {
                        System.out.println("Failed to get widget {"+x+","+y+"}");
                    }
                    return null;
                }
            }
        }



    }

    public static class BaBa {
        public enum Objects {
            EXIT(45128);

            int id;
            Objects(int ID) {
                id = ID;
            }
            public int getID() {return id;}

            public SimpleObject get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }
        }
    }

    public static class Kephri {
        public enum Objects {
            EXIT(45128);

            int id;
            Objects(int ID) {
                id = ID;
            }
            public int getID() {return id;}

            public SimpleObject get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }
        }
    }

    public static class Overworld {

        public enum Objects {

            PATH_HET(46164),
            PATH_CRONDIS(46161),
            PATH_SCARABAS(46155),
            PATH_APMEKEN(46158),

            EXIT(45128);

            int id;
            Objects(int ID) {
                id = ID;
            }
            public int getID() {return id;}

            public SimpleObject get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }
        }

        public static boolean inArea() {
            return Objects.PATH_APMEKEN.get() != null || Objects.PATH_HET.get() != null || Objects.PATH_CRONDIS.get() != null || Objects.PATH_SCARABAS.get() != null;
        }

    }

    public static class Tumeken {
        public enum Objects {
            EXIT(45128);

            int id;
            Objects(int ID) {
                id = ID;
            }
            public int getID() {return id;}

            public SimpleObject get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }
        }
    }

    public static class Warden {
        public enum Objects {
            EXIT(45128);

            int id;
            Objects(int ID) {
                id = ID;
            }
            public int getID() {return id;}

            public SimpleObject get() {
                return getQuery().nextNearest();
            }

            public SimpleEntityQuery<SimpleObject> getQuery() {
                return ClientContext.instance().objects.populate().filter(id);
            }
        }
    }


    public enum Widgets {
        RAID_LEVEL(481, 42),
        SOMETHING(481, 46);

        int x, y;
        Widgets(int X, int Y) {x = X; y = Y;}


        public SimpleWidget get() {
            try {
                return ClientContext.instance().widgets.getWidget(x, y);
            } catch (NullPointerException e) {
                System.out.println("Failed to get widget {"+x+","+y+"}");
            }
            return null;
        }

    }

}
