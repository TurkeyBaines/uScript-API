package org.data.database;

public enum Npcs {
    PILLORY_GUARD(380),
    MAN(3078, 3079, 3080),
    WOMAN(3083, 3084, 3085),
    GUARD(3245),
    KNIGHT_OF_ARDOUGNE(3297),
    PALADIN(3105),
    HERO(3106),
    MASTER_FARMER(3257),
    TORAG(1676),
    AHRIM(1672),
    KARIL(1675),
    DHAROK(1673),
    GUTHAN(1674),
    VERAC(1677);

    private final int[] npcIds;

    Npcs(int... npcIds) {
        this.npcIds = npcIds;
    }

    public int[] getIDs() {
        return npcIds;
    }

    public int getID() {
        return npcIds[0];
    }
}
