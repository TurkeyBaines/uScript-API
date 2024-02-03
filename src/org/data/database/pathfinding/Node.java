package org.data.database.pathfinding;

import net.runelite.api.coords.WorldPoint;

public class Node {

    WorldPoint location;
    int col, row;
    Node parent;
    int gCost, hCost, fCost;

    boolean isStart, isGoal, isBad, open, checked;

    Node(int Col, int Row, WorldPoint Location) {
        col = Col;
        row = Row;
        location = Location;
    }

    public void setStart() {
        isStart = true;
    }

    public void setGoal() {
        isGoal = true;
    }

    public void setBad() {
        isBad = true;
    }

    public void setAsOpen() {
        open = true;
    }

    public void setAsChecked() {
        if (isStart == false && isGoal == false) {
            checked = true;
        }
    }

    public void setAsPath() {

    }


}
