package org.data.database;

public class Weapons {

    public Melee melee() {
        return new Melee();
    }

    public static class Melee {

        public enum Sword {
            BRONZE_SWORD(1277),
            IRON_SWORD(1279),
            STEEL_SWORD(1281),
            BLACK_SWORD(1283),
            MITHRIL_SWORD(1285),
            ADAMANT_SWORD(1287),
            RUNE_SWORD(1289),
            DRAGON_SWORD(21009);

            private final int id;

            Sword(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }

        public enum Longsword {
            BRONZE_LONGSWORD(1291),
            IRON_LONGSWORD(1293),
            STEEL_LONGSWORD(1295),
            BLACK_LONGSWORD(1297),
            MITHRIL_LONGSWORD(1299),
            ADAMANT_LONGSWORD(1301),
            RUNE_LONGSWORD(1303),
            DRAGON_LONGSWORD(1305),
            THIRD_AGE_LONGSWORD(12426),
            VESTAS_LONGSWORD_FULL(22613),
            VESTAS_LONGSWORD_ACTIVE(23615),
            VESTAS_LONGSWORD_EMPTY(24619);

            private final int id;

            Longsword(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }

        public enum Scimitar {
            BRONZE_SCIMITAR(1321),
            IRON_SCIMITAR(1323),
            STEEL_SCIMITAR(1325),
            BLACK_SCIMITAR(1327),
            MITHRIL_SCIMITAR(1329),
            ADAMANT_SCIMITAR(1331),
            RUNE_SCIMITAR(1333),
            DRAGON_SCIMITAR(4587),
            GILDED_SCIMITAR(12389);

            private final int id;

            Scimitar(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }

        public enum Dagger {
            BRONZE(1205, 1221, 5670, 5688),
            IRON(1203, 1219, 5668, 5686),
            STEEL(1207, 1223, 5672, 5690),
            BLACK(1217, 1233, 5682, 5700),
            MITHRIL(1209, 1225, 5674, 5692),
            ADAMANT(1211, 1227, 5676, 5694),
            RUNE(1213, 1229, 5678, 5696),
            DRAGON(1215, 1231, 5680, 5698);

            private final int id;
            private final int pId;
            private final int pxId;
            private final int pxxId;

            Dagger(int id, int pId, int pxId, int pxxId) {
                this.id = id;
                this.pId = pId;
                this.pxId = pxId;
                this.pxxId = pxxId;
            }

            public int getId() {
                return id;
            }

            public int getP() {
                return pId;
            }

            public int getPx() {
                return pxId;
            }

            public int getPxx() {
                return pxxId;
            }
        }

        public enum Spear {
            RUNE_SPEAR(1247);

            int id;
            Spear(int ID) {
                id = ID;
            }
            public int getID() {
                return id;
            }
        }

        public enum Hasta {}
        public enum Warhammer {}

        public enum TwoHSword {
            RUNE_2H_SWORD(1319);

            int id;
            TwoHSword(int ID) {
                id = ID;
            }
            public int getID() {
                return id;
            }
        }

        public enum Battleaxe {
            RUNE_BATTLEAXE(1373);

            int id;
            Battleaxe(int ID) {
                id = ID;
            }
            public int getID() {
                return id;
            }
        }

        public enum Abyssal {
            DAGGER(13265),
            WHIP(4151);

            int id;
            Abyssal(int ID) {id = ID;}
            public int getID() {return id;}
        }
    }

    public static class Ranged {

        public static class Thrown {
            public enum Dart {
                BRONZE(806),
                IRON(807),
                STEEL(808),
                MITHRIL(809),
                ADAMANT(810),
                RUNE(811);

                private final int id;

                Dart(int id) {
                    this.id = id;
                }

                public int getId() {
                    return id;
                }
            }

            public enum Knife {
                BRONZE(864),
                IRON(863),
                BLACK(869),
                STEEL(865),
                MITHRIL(866),
                ADAMANT(867),
                RUNE(868);

                private final int id;

                Knife(int id) {
                    this.id = id;
                }

                public int getId() {
                    return id;
                }
            }

            public enum Axe {
                BRONZE_THROWNAXE(800),
                IRON_THROWNAXE(801),
                STEEL_THROWNAXE(802),
                MITHRIL_THROWNAXE(803),
                ADAMANT_THROWNAXE(804),
                RUNE_THROWNAXE(805);

                private final int id;

                Axe(int id) {
                    this.id = id;
                }

                public int getId() {
                    return id;
                }
            }

            public enum Javelin {
                BRONZE(825),
                IRON(826),
                STEEL(827),
                MITHRIL(828),
                ADAMANT(829),
                RUNE(830);

                private final int id;

                Javelin(int id) {
                    this.id = id;
                }

                public int getId() {
                    return id;
                }
            }

            public enum Special {
                TOKTZ_XIL_UL(6522);

                private final int id;

                Special(int id) {
                    this.id = id;
                }

                public int getId() {
                    return id;
                }
            }
        }

        public static class Ammo {
            public enum Arrow {
                BRONZE(882, 883),
                IRON(884, 885),
                STEEL(886, 887),
                MITHRIL(888, 889),
                ADAMANT(890, 891),
                RUNE(892, 893),
                DRAGON(11212, -1);

                private final int id;
                private final int pId;

                Arrow(int id, int pId) {
                    this.id = id;
                    this.pId = pId;
                }

                public int getId() {
                    return id;
                }

                public int getP() {
                    return pId;
                }
            }
            public static class Bolts {
                public enum Metal {
                    BRONZE_BOLTS(877),
                    IRON_BOLTS(9140),
                    STEEL_BOLTS(9141),
                    MITHRIL_BOLTS(9142),
                    ADAMANT_BOLTS(9143),
                    RUNITE_BOLTS(9144),
                    DRAGON_BOLTS(21905);

                    private final int id;

                    Metal(int id) {
                        this.id = id;
                    }

                    public int getId() {
                        return id;
                    }
                }
                public enum Gem {
                    OPAL_BOLTS(879),
                    SAPPHIRE_BOLTS(879),
                    JADE_BOLTS(879),
                    PEARL_BOLTS(879),
                    EMERALD_BOLTS(879),
                    TOPAZ_BOLTS(879),
                    RUBY_BOLTS(879),
                    DIAMOND_BOLTS(879),
                    DRAGONSTONE_BOLTS(879),
                    ONYX_BOLTS(879);

                    private final int id;

                    Gem(int id) {
                        this.id = id;
                    }

                    public int getId() {
                        return id;
                    }
                }
                public enum Enchanted {
                    OPAL_BOLTS_E(9236),
                    SAPPHIRE_BOLTS_E(9240),
                    JADE_BOLTS_E(9237),
                    PEARL_BOLTS_E(9238),
                    EMERALD_BOLTS_E(9241),
                    TOPAZ_BOLTS_E(9239),
                    RUBY_BOLTS_E(9242),
                    DIAMOND_BOLTS_E(9243),
                    DRAGONSTONE_BOLTS_E(9244),
                    ONYX_BOLTS_E(9245);

                    private final int id;

                    Enchanted(int id) {
                        this.id = id;
                    }

                    public int getId() {
                        return id;
                    }
                }

                public static class Dragon {
                    public enum Gem {
                        OPAL_DRAGON_BOLTS(21955),
                        SAPPHIRE_DRAGON_BOLTS(21963),
                        JADE_DRAGON_BOLTS(21957),
                        PEARL_DRAGON_BOLTS(21959),
                        EMERALD_DRAGON_BOLTS(21965),
                        TOPAZ_DRAGON_BOLTS(21961),
                        RUBY_DRAGON_BOLTS(21967),
                        DIAMOND_DRAGON_BOLTS(21967),
                        DRAGONSTONE_DRAGON_BOLTS(21971),
                        ONYX_DRAGON_BOLTS(21973);

                        private final int id;

                        Gem(int id) {
                            this.id = id;
                        }

                        public int getId() {
                            return id;
                        }
                    }

                    public enum Enchanted {
                        OPAL_DRAGON_BOLTS_E(21932),
                        SAPPHIRE_DRAGON_BOLTS_E(21940),
                        JADE_DRAGON_BOLTS_E(21934),
                        PEARL_DRAGON_BOLTS_E(21936),
                        EMERALD_DRAGON_BOLTS_E(21942),
                        TOPAZ_DRAGON_BOLTS_E(21938),
                        RUBY_DRAGON_BOLTS_E(21944),
                        DIAMOND_DRAGON_BOLTS_E(21946),
                        DRAGONSTONE_DRAGON_BOLTS_E(21948),
                        ONYX_DRAGON_BOLTS_E(21950);

                        private final int id;

                        Enchanted(int id) {
                            this.id = id;
                        }

                        public int getId() {
                            return id;
                        }
                    }
                }
            }
        }

        public enum Chin {
            GRAY_CHINCHOMPA(9976),
            RED_CHINCHOMPA(9977),
            BLACK_CHINCHOMPA(11959);

            private final int id;

            Chin(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }

        public enum Crossbow {
            CROSSBOW(837),
            DORGESHUUN_CROSSBOW(8880),
            BRONZE_CROSSBOW(9174),
            IRON_CROSSBOW(9177),
            STEEL_CROSSBOW(9179),
            MITHRIL_CROSSBOW(9181),
            ADAMANT_CROSSBOW(9183),
            RUNE_CROSSBOW(9185),
            KARILS_CROSSBOW(4734, 4934, 4935, 4936, 4937, 4938),
            ARMADYL_CROSSBOW(11785),
            DRAGON_CROSSBOW(21902),
            DRAGON_HUNTER_CROSSBOW(21012);

            private final int id;
            private int hun, sev, fif, twen, zero;

            Crossbow(int id) {
                this.id = id;
            }
            Crossbow(int Full, int Hun, int Sev, int Fif, int Twen, int Zero) {
                id = Full;
                hun = Hun;
                sev = Sev;
                fif = Fif;
                twen = Twen;
                zero = Zero;
            }

            public int getId() {
                return id;
            }

            public int getDegradeID(int percent) {
                if (id != 4734) {
                    return -1;
                }
                switch(percent) {
                    case 100:
                        return hun;
                    case 75:
                        return sev;
                    case 50:
                        return fif;
                    case 25:
                        return twen;
                    case 0:
                        return zero;
                }
                return id;
            }
        }

        public enum Shortbow {
            SHORTBOW(841),
            OAK_SHORTBOW(843),
            WILLOW_SHORTBOW(849),
            MAPLE_SHORTBOW(853),
            YEW_SHORTBOW(857),
            MAGIC_SHORTBOW(861);

            private final int id;

            Shortbow(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }

        public enum Longbow {
            LONGBOW(839),
            OAK_LONGBOW(845),
            WILLOW_LONGBOW(847),
            MAPLE_LONGBOW(851),
            YEW_LONGBOW(855),
            MAGIC_LONGBOW(859);

            private final int id;

            Longbow(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }

        public enum Special {
            TOXIC_BLOWPIPE_FULL(12926),
            TOXIC_BLOWPIPE_EMPTY(12924),
            TWISTED_BOW(20997),
            BOW_OF_FAERDHINEN(25865),
            CRYSTAL_BOW(4214, 4215, 4216, 4217, 4218, 4219, 4220, 4221, 4222, 4223),
            DARK_BOW(11235);

            private final int id;
            private int eight, seven, six, five, four, three, two, one, broken;

            Special(int id) {
                this.id = id;
            }
            Special(int Full, int Eight, int Seven, int Six, int Five, int Four, int Three, int Two, int One, int Broken) {
                id = Full;
                eight = Eight;
                seven = Seven;
                six = Six;
                five = Five;
                four = Four;
                three = Three;
                two = Two;
                one = One;
                broken = Broken;
            }

            public int getId() {
                return id;
            }

            public int getDegradeID(int percent) {
                if (id != 4214) {
                    return -1;
                }
                switch(percent) {
                    case 8:
                        return eight;
                    case 7:
                        return seven;
                    case 6:
                        return six;
                    case 5:
                        return five;
                    case 4:
                        return four;
                    case 3:
                        return three;
                    case 2:
                        return two;
                    case 1:
                        return 1;
                    case 0:
                        return broken;
                }
                return id;
            }

        }

    }

    public static class Magic {
        public enum Elemental {
            STAFF_OF_AIR(1381),
            STAFF_OF_WATER(1383),
            STAFF_OF_EARTH(1385),
            STAFF_OF_FIRE(1387),
            MYSTIC_AIR_STAFF(1405),
            MYSTIC_WATER_STAFF(1403),
            MYSTIC_EARTH_STAFF(1407),
            MYSTIC_FIRE_STAFF(1401);

            private final int id;

            Elemental(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }


        public enum Battlestaff {
            AIR_BATTLESTAFF(1397),
            WATER_BATTLESTAFF(1395),
            EARTH_BATTLESTAFF(1399),
            FIRE_BATTLESTAFF(1393);

            private final int id;

            Battlestaff(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }


        public enum Combination {
            LAVA_BATTLESTAFF(3053),
            MUD_BATTLESTAFF(6562),
            STEAM_BATTLESTAFF(11787),
            SMOKE_BATTLESTAFF(11998),
            MYSTIC_LAVA_STAFF(3054),
            MYSTIC_MUD_STAFF(6563),
            MYSTIC_STEAM_STAFF(11789),
            MYSTIC_SMOKE_STAFF(12000);

            private final int id;

            Combination(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }


        public enum God {
            SARADOMIN_STAFF(2415),
            GUTHIX_STAFF(2416),
            ZAMORAK_STAFF(2417);

            private final int id;

            God(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }


        public enum Wand {
            BEGINNER_WAND(6908),
            APPRENTICE_WAND(6910),
            TEACHER_WAND(6912),
            MASTER_WAND(6914);

            private final int id;

            Wand(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }


        public enum Salamander {
            SWAMP_LIZARD(10149),
            ORANGE_SALAMANDER(10146),
            RED_SALAMANDER(10147),
            BLACK_SALAMANDER(10148);

            private final int id;

            Salamander(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }
        }


        public enum Special {
            STAFF_OF_THE_DEAD(11792),
            TOXIC_STAFF_OF_THE_DEAD(12904),
            IBANS_STAFF(1409),
            AHRIMS_STAFF(4710, 4862, 4863, 4864, 4865, 4866),
            KODAI_WAND(21006),
            TRIDENT_OF_THE_SEAS(11905, 11907, 11908),
            TRIDENT_OF_THE_SWAMP(12899, 12900),
            ANCIENT_STAFF(4675),
            SLAYER_STAFF(4170),
            SANGUINESTI_STAFF(22323),
            NIGHTMARE_STAFF(24422),
            VOLATILE_NIGHTMARE_STAFF(24424),
            HARMONISED_NIGHTMARE_STAFF(24423),
            ELDRITCH_NIGHTMARE_STAFF(24425);

            private int id;

            private int[] ahrimStaff;
            private int[] tridentSeas;
            private int[] tridentSwamp;

            Special(int id) {
                this.id = id;
            }
            Special(int... ids) {
                if (ids.length == 6) { ahrimStaff = ids; id = ids[0]; }
                if (ids.length == 3) { tridentSeas = ids; id = ids[0]; }
                if (ids.length == 2) { tridentSwamp = ids; id = ids[0]; }
            }

            public int getId() {
                return id;
            }

            public int getDegradeID(int percent) {
                if (id != 4710) {
                    throw new NullPointerException("This item doesn't degrade!");
                }
                switch(percent) {
                    case 100:
                        return ahrimStaff[1];
                    case 75:
                        return ahrimStaff[2];
                    case 50:
                        return ahrimStaff[3];
                    case 25:
                        return ahrimStaff[4];
                    case 0:
                        return ahrimStaff[5];
                }
                return id;
            }

            public int getInUseID() {
                if (id != 11905 || id != 12899) {
                    throw new NullPointerException("This item doesn't have an 'In-Use' ID");
                }
                if (id == 11905) {
                    return tridentSeas[1];
                }

                return tridentSwamp[0];
            }
            public int getEmptyID() {
                if (id != 11905 || id != 12899) {
                    throw new NullPointerException("This item doesn't have an 'Empty' ID");
                }
                if (id == 11905) {
                    return tridentSeas[2];
                }
                return tridentSwamp[1];
            }
        }
    }
}
