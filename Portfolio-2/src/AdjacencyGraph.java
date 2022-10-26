import java.util.*;

public class AdjacencyGraph {
    ArrayList<Vertex> Vertices;

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

    public void PrintGraph() {
        for (int i = 0; i < Vertices.size(); i++) {
            System.out.println(" Vertex " + Vertices.get(i).name + " is connecte to: ");
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
                    + (current.getSentContainers() - current.getRecievedContainers()));

        }
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

    public String toString() {
        return from + "->" + to + "::" + weight;
    }
}