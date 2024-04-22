package org.data.path;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.interfaces.SimpleActor;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Pathfinder {
    ClientContext c;

    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    List<SimpleActor> obstacles;
    WorldPoint target;
    WorldPoint start;
    boolean endReached;
    WorldPoint currentSearchTile;
    WorldPoint currentNeighbourTile;

    public List<WorldPoint> findPath(List<SimpleActor> obstacles, WorldPoint target) {
        c = ClientContext.instance();

        // Get current player location from game API
        start = c.players.getLocal().getLocation();
        this.target = target;
        this.obstacles = obstacles;
        endReached = false;

        // Convert obstacles to set for quick lookup
        Set<WorldPoint> blocked = new HashSet<>();
        for (SimpleActor npc : obstacles) {
            blocked.add(npc.getLocation());
        }

        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Map<WorldPoint, Double> costSoFar = new HashMap<>();
        openSet.add(new Node(start, null, 0, c.pathing.collisionDistance(target)));
        costSoFar.put(start, 0.0);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            currentSearchTile = current.point;

            if (current.point.equals(target)) {
                System.out.println("Path Complete!");
                return reconstructPath(current);
            }

            for (int[] dir : DIRECTIONS) {
                WorldPoint neighbour = new WorldPoint(current.point.getX() + dir[0], current.point.getY() + dir[1], current.point.getPlane());
                currentNeighbourTile = neighbour;
                if (blocked.contains(neighbour)) continue;
                double newCost = current.g + 1; // Assuming uniform cost for simplicity
                if (!costSoFar.containsKey(neighbour) || newCost < costSoFar.get(neighbour)) {
                    costSoFar.put(neighbour, newCost);
                    double priority = newCost + neighbour.distanceTo(target);
                    openSet.add(new Node(neighbour, current, newCost, priority));
                }
            }
        }

        return new ArrayList<>(); // Return empty path if no path is found
    }

    private List<WorldPoint> reconstructPath(Node node) {
        List<WorldPoint> path = new ArrayList<>();
        while (node != null) {
            path.add(node.point);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    private double distance(WorldPoint p1, WorldPoint p2) {
        return Math.hypot(p2.getX() - p1.getX(), p2.getY() - p1.getY());
    }

    public void paint(Graphics2D g2d) {
        if (start != null) {
            c.paint.drawTileMatrix(g2d, start, Color.CYAN);
        }

        if (target != null) {
            c.paint.drawTileMatrix(g2d, target, Color.GREEN);
        }

        if (obstacles != null && !obstacles.isEmpty()) {
            for (SimpleActor npc : obstacles) {
                c.paint.drawTileMatrix(g2d, npc.getLocation(), Color.RED);
            }
        }
    }
}
