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
            // System.out.println(" Vertex " + Vertices.get(i).name + " is connecte to: ");
            Vertex current = Vertices.get(i);
            for (Edge e : current.OutEdge) {
                System.out.println(e.to.name + " with weight: " + e.weight);
            }
        }
    }

    public void printSurplus() {
        for (int i = 0; i < Vertices.size(); i++) {
            Vertex current = Vertices.get(i);

            System.out.println(current.toString() + "total surplus: "
                    + (current.getRecievedContainers() - current.getSentContainers()));
        }
    }

    public void sortedVertices() {
        Vertex current;
        for (int i = 0; i < Vertices.size(); i++) {
            current = Vertices.get(i);
            int surplus = current.getRecievedContainers() - current.getSentContainers();
            sortedVertices.add(i, surplus);
        }
        Collections.sort(sortedVertices);
        System.out.println(sortedVertices);
    }

}

class Vertex {
    String name;
    ArrayList<Edge> OutEdge;
    Integer sContainer = 0;
    Integer rContainer = 0;

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

    public void sentContainers(Integer container) {
        sContainer += container;
    }

    public void recievedContainers(Integer container) {
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

        this.from.sentContainers(weight);
        this.to.recievedContainers(weight);
    }

    public Integer getWeight() {
        return weight;
    }

    public String toString() {
        return from + "->" + to + "::" + weight;
    }
}