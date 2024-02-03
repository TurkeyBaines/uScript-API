package org.data.database.pathfinding;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.queries.SimpleEntityQuery;
import simple.hooks.wrappers.SimpleNpc;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

import java.util.ArrayList;
import java.util.HashMap;

public class Pathfinder implements Runnable {

    WorldArea area;
    HashMap<WorldPoint, Node> nodes;
    Node startNode;
    Node goalNode;
    Node currNode;

    ArrayList<Node> openList;
    ArrayList<Node> checkedList;

    boolean goalReached;

    int steps;

    public Pathfinder(WorldArea AreaToSearch, int maxCol, int maxRow) {
        steps = 0;
        goalReached = false;
        openList = new ArrayList<>();
        checkedList = new ArrayList<>();
        area = AreaToSearch;

        nodes = new HashMap<>();

        for (int x = 0; x < maxCol; x++) {
            for (int y = 0; y < maxRow; y++) {
                System.out.println("Added new Node[" + x + "][" + y + "] | Location: " + (area.getWorldPoints()[0].getX()+x) + ", " + (area.getWorldPoints()[0].getY()+y) + ", " + area.getWorldPoints()[0].getPlane());
                WorldPoint wp = new WorldPoint(area.getWorldPoints()[0].getX()+x, area.getWorldPoints()[0].getY()+y, area.getWorldPoints()[0].getPlane());
                nodes.put(wp, new Node(x, y, wp));
            }
        }
    }

    public void setStartNode(WorldPoint point) {
        System.out.println("Setting the following tile to START | " + point.toString() );
        startNode = nodes.get(point);
        startNode.setStart();
        currNode = startNode;
    }

    public void setGoalNode(WorldPoint point) {
        goalNode = nodes.get(point);
        goalNode.setGoal();
    }

    public void setBadNode(WorldPoint point) {
        nodes.get(point).setBad();
    }

    public void walkPath(WorldPoint start, WorldPoint goal) {
        setStartNode(start);
        setGoalNode(goal);
        findUnwalkable();
        for (Node n : nodes.values()) {
            getCost(n);
        }
        this.run();
    }

    public void findBadObj(SimpleEntityQuery<SimpleObject> seq) {

        if (seq.isEmpty()) { return; }

        for (SimpleObject so : seq) {
            nodes.get(so.getLocation()).setBad();
        }
    }

    public void findBadNpc(SimpleEntityQuery<SimpleNpc> seq) {

        if (seq.isEmpty()) { return; }

        for (SimpleNpc so : seq) {
            nodes.get(so.getLocation()).setBad();
        }
    }

    public void findUnwalkable() {
        for (Node n : nodes.values()) {
            if (!ClientContext.instance().pathing.reachable(n.location)) {
                n.setBad();
            }
        }
    }

    public void getCost(Node node) {
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        node.fCost = node.gCost + node.hCost;
    }

    private void openNode(Node node) {
        if (!node.open && !node.checked && !node.isBad) {
            node.setAsOpen();
            node.parent = currNode;
            openList.add(node);
        }
    }

    @Override
    public void run() {
        while (!goalReached && steps < 300) {
            steps++;

            WorldPoint wp = currNode.location;
            int col = currNode.col;
            int row = currNode.row;


            currNode.setAsChecked();
            checkedList.add(currNode);
            openList.remove(currNode);

            if (area.containsPoint(new WorldPoint(currNode.location.getX()-1, currNode.location.getY()-1, currNode.location.getPlane())))
                openNode(nodes.get(new WorldPoint(currNode.location.getX()-1, currNode.location.getY()-1, currNode.location.getPlane())));

            if (area.containsPoint(new WorldPoint(currNode.location.getX(), currNode.location.getY()-1, currNode.location.getPlane())))
                openNode(nodes.get(new WorldPoint(currNode.location.getX(), currNode.location.getY()-1, currNode.location.getPlane())));

            if (area.containsPoint(new WorldPoint(currNode.location.getX()+1, currNode.location.getY()-1, currNode.location.getPlane())))
                openNode(nodes.get(new WorldPoint(currNode.location.getX()+1, currNode.location.getY()-1, currNode.location.getPlane())));

            if (area.containsPoint(new WorldPoint(currNode.location.getX()-1, currNode.location.getY(), currNode.location.getPlane())))
                openNode(nodes.get(new WorldPoint(currNode.location.getX()-1, currNode.location.getY(), currNode.location.getPlane())));

            if (area.containsPoint(new WorldPoint(currNode.location.getX()+1, currNode.location.getY()-1, currNode.location.getPlane())))
                openNode(nodes.get(new WorldPoint(currNode.location.getX()+1, currNode.location.getY()-1, currNode.location.getPlane())));

            if (area.containsPoint(new WorldPoint(currNode.location.getX()-1, currNode.location.getY()+1, currNode.location.getPlane())))
                openNode(nodes.get(new WorldPoint(currNode.location.getX()-1, currNode.location.getY()+1, currNode.location.getPlane())));

            if (area.containsPoint(new WorldPoint(currNode.location.getX(), currNode.location.getY()+1, currNode.location.getPlane())))
                openNode(nodes.get(new WorldPoint(currNode.location.getX(), currNode.location.getY()+1, currNode.location.getPlane())));

            if (area.containsPoint(new WorldPoint(currNode.location.getX()+1, currNode.location.getY()+1, currNode.location.getPlane())))
                openNode(nodes.get(new WorldPoint(currNode.location.getX()+1, currNode.location.getY()+1, currNode.location.getPlane())));

            int bestNodeIndex = 0;
            int bestNodefCost = 999;

            for (int i = 0; i < openList.size(); i++) {
                if (openList.get(i).fCost < bestNodefCost) {
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                } else if (openList.get(i).fCost == bestNodefCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;

                    }
                }
            }

            currNode = openList.get(bestNodeIndex);
            if (currNode == goalNode) {
                goalReached = true;
            }
            ClientContext c = ClientContext.instance();

            c.pathing.step(currNode.location);
            c.sleepCondition(() -> c.players.getLocal().getLocation().equals(currNode.location), 1000);
        }
    }
}
