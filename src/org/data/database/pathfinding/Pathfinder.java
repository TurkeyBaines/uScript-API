package org.data.database.pathfinding;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.wrappers.SimpleNpc;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

import java.awt.*;
import java.util.*;
import java.util.List;

import java.util.*;

// Assuming you have the WorldPoint class from your API
// Adjust the import statement accordingly

public class Pathfinder extends Thread {
    private Set<WorldPoint> obstacles;
    private WorldPoint start, destination;

    public Pathfinder(Set<WorldPoint> obstacles, WorldPoint start, WorldPoint destination) {
        this.obstacles = obstacles;
        this.start = start;
        this.destination = destination;
    }

    @Override
    public void run() {
        List<WorldPoint> path = optimizePath(findPath(start, destination));

        if (!path.isEmpty()) {
            System.out.println("Path found: " + path);
            walkPath(path);
        } else {
            System.out.println("No path found");
        }
    }


    private List<WorldPoint> findPath(WorldPoint start, WorldPoint destination) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Set<WorldPoint> closedSet = new HashSet<>();

        openSet.add(new Node(start, null, 0, heuristic(start, destination)));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.point.equals(destination)) {
                // Reconstruct the path
                List<WorldPoint> path = new ArrayList<>();
                while (current != null) {
                    path.add(current.point);
                    current = current.parent;
                }
                Collections.reverse(path);
                return path;
            }

            closedSet.add(current.point);

            for (WorldPoint neighbor : getNeighbors(current.point)) {
                if (!closedSet.contains(neighbor) && !obstacles.contains(neighbor)) {
                    double tentativeGScore = current.gScore + 1; // Assuming each step has a cost of 1

                    Node neighborNode = new Node(neighbor, current, tentativeGScore, heuristic(neighbor, destination));

                    if (!openSet.contains(neighborNode) || tentativeGScore < neighborNode.gScore) {
                        openSet.add(neighborNode);
                    }
                } else {
                    System.out.println("Skipping neighbor: " + neighbor + " (Obstacle or already visited)");
                }
            }
        }

        // No path found
        return Collections.emptyList();
    }

    private void walkPath(List<WorldPoint> path) {
        ClientContext c = ClientContext.instance();
        // Assuming your API provides a method to step to a WorldPoint
        for (WorldPoint point : path) {
            // Use your game's pathing API to step to the WorldPoint
            c.pathing.step(point);
            c.sleepCondition(() -> c.players.getLocal().getLocation().equals(point), 5000);
            System.out.println("Walking to: " + point.getX() + ", " + point.getY() + ", Plane: " + point.getPlane());
        }
    }

    public List<WorldPoint> optimizePath(List<WorldPoint> path) {
        if (path.size() < 2) {
            // No optimization needed for paths with less than two points
            return path;
        }

        List<WorldPoint> optimizedPath = new ArrayList<>();
        optimizedPath.add(path.get(0)); // Always include the first point

        for (int i = 1; i < path.size() - 1; i++) {
            WorldPoint current = path.get(i);
            WorldPoint next = path.get(i + 1);
            WorldPoint previous = path.get(i - 1);

            if (!isSameDirection(previous, current, next)) {
                optimizedPath.add(current);
            }
        }

        optimizedPath.add(path.get(path.size() - 1)); // Always include the last point

        return optimizedPath;
    }

    private boolean isSameDirection(WorldPoint a, WorldPoint b, WorldPoint c) {
        // Check if the points A, B, and C form a straight line (same direction)
        int crossProduct = (b.getY() - a.getY()) * (c.getX() - b.getX()) - (b.getX() - a.getX()) * (c.getY() - b.getY());
        return crossProduct == 0;
    }

    private List<WorldPoint> getNeighbors(WorldPoint point) {
        List<WorldPoint> neighbors = new ArrayList<>();

        // Assuming your game world has a specific logic for determining neighbors
        // Example: Check adjacent points
        if (!ClientContext.instance().pathing.running()) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    // Skip the current point
                    if (dx == 0 && dy == 0) {
                        continue;
                    }

                    int newX = point.getX() + dx;
                    int newY = point.getY() + dy;
                    int newPlane = point.getPlane();

                    WorldPoint neighbor = new WorldPoint(newX, newY, newPlane);
                    neighbors.add(neighbor);

                    System.out.println("Potential neighbor: " + neighbor);
                }
            }
        } else {
            // Assuming your game world has a specific logic for determining neighbors
            // Example: Check points that are 2 units away in all directions

            for (int dx = -2; dx <= 2; dx++) {
                for (int dy = -2; dy <= 2; dy++) {
                    // Skip the current point
                    if (dx == 0 && dy == 0) {
                        continue;
                    }

                    int newX = point.getX() + dx;
                    int newY = point.getY() + dy;
                    int newPlane = point.getPlane();

                    WorldPoint neighbor = new WorldPoint(newX, newY, newPlane);
                    neighbors.add(neighbor);

                    System.out.println("Potential neighbor: " + neighbor);
                }
            }
        }

        return neighbors;
    }

    private double heuristic(WorldPoint from, WorldPoint to) {
        // Implement a heuristic function (e.g., Euclidean distance) to estimate the remaining distance
        double distance = Math.sqrt(Math.pow(to.getX() - from.getX(), 2) + Math.pow(to.getY() - from.getY(), 2));
        System.out.println("Heuristic from " + from + " to " + to + ": " + distance);
        return distance;
    }


    private static class Node implements Comparable<Node> {
        WorldPoint point;
        Node parent;
        double gScore;
        double fScore;

        public Node(WorldPoint point, Node parent, double gScore, double fScore) {
            this.point = point;
            this.parent = parent;
            this.gScore = gScore;
            this.fScore = fScore;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.fScore, other.fScore);
        }
    }
}
