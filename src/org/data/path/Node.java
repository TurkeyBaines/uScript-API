package org.data.path;

import net.runelite.api.coords.WorldPoint;

class Node implements Comparable<Node> {
    WorldPoint point;
    Node parent;
    double g, h;

    Node(WorldPoint pt, Node parent, double g, double h) {
        this.point = pt;
        this.parent = parent;
        this.g = g;
        this.h = h;
    }

    public int compareTo(Node other) {
        return Double.compare(this.g + this.h, other.g + other.h);
    }
}
