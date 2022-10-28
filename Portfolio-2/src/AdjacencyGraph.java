import java.util.*;

public class AdjacencyGraph {
    ArrayList<Vertex> Vertices;
    ArrayList<Integer> sortedVertices = new ArrayList<Integer>();

    public AdjacencyGraph() {
        Vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v) {
        Vertices.add(v);
    }

    public void addEdge(Vertex from, Vertex to, Integer weight) {
        if (!(Vertices.contains(from) && Vertices.contains(to))) {
            System.out.println("Vertices missing from graph");
            return;
        }
        Edge newE = new Edge(from, to, weight);

    }

    public void addUnDirectedEdge(Vertex from, Vertex to, Integer weight) {
        if (!(Vertices.contains(from) && Vertices.contains(to))) {
            System.out.println("Vertices missing from graph");
            return;
        }
        Edge newE = new Edge(from, to, weight);
        Edge newE2 = new Edge(to, from, weight);
    }

    public void printGraph() {
        for (int i = 0; i < Vertices.size(); i++) {
            System.out.println(" Vertex " + Vertices.get(i).name + " is connecte to: ");
            Vertex current = Vertices.get(i);
            for (Edge e : current.OutEdge) {
                System.out.print("---> " + e.to.name + " with weight: " + e.weight);
                System.out.println();
            }
        }
    }

    public void printSurplus() {
        for (int i = 0; i < Vertices.size(); i++) {
            Vertex current = Vertices.get(i);

            System.out.println(current.toString() + " total surplus: "
                    + (current.getRecievedContainers() - current.getSentContainers()));
        }
    }

    public ArrayList<Integer> sortedVertices() {
        Vertex current;
        for (int i = 0; i < Vertices.size(); i++) {
            current = Vertices.get(i);
            int surplus = current.getRecievedContainers() - current.getSentContainers();
            sortedVertices.add(i, surplus);
        }
        Collections.sort(sortedVertices);
        return sortedVertices;
    }

    public int flowPrice() { // Vi regner prisen ud for hver container i hver port
        Vertex current;
        int price = 0;
        for (int i = 0; i < Vertices.size(); i++) {
            current = Vertices.get(i);
            for (int j = 0; j < current.getOutEdge().size(); j++) {
                Edge currentEdge = current.getOutEdge().get(j);
                price += currentEdge.getWeight() * 100;
            }
        }
        return price;
    }

    public int minimizeFlowCost() {
        ArrayList<Integer> sortedArr = sortedVertices();
        int sum = 0;
        for (int i = 0; i < sortedArr.size(); i++) {
            if (sortedArr.get(i) > 0) {
                sum += sortedArr.get(i);
            }
        }
        return sum * 100;

    }

}

class Vertex {
    String name;
    ArrayList<Edge> OutEdge;
    Integer sContainer = 0;
    Integer rContainer = 0;
    Integer weight = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        OutEdge = new ArrayList<Edge>();
    }

    public String toString() {
        return name;
    }

    public ArrayList<Edge> getOutEdge() {
        return OutEdge;
    }

    public Integer getSentContainers() {
        return sContainer;
    }

    public Integer getRecievedContainers() {
        return rContainer;
    }

    public void setSentContainers(Integer container) {
        sContainer += container;
    }

    public void setRecievedContainers(Integer container) {
        rContainer += container;
    }
}

class Edge {
    Vertex from;
    Vertex to;
    Integer weight;

    public Edge(Vertex from, Vertex to, Integer weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        from.OutEdge.add(this);

        this.from.setSentContainers(weight);
        this.to.setRecievedContainers(weight);
    }

    public Integer getWeight() {
        return weight;
    }

    public String toString() {
        return from + "->" + to + "::" + weight;
    }
}