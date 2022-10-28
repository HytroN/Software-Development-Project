import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        AdjacencyGraph adj = Graph();
        adj.printGraph();

        System.out.println();
        // System.out.println(adj.flowPrice());
        adj.printSurplus();
        // System.out.println();
        // adj.sortedVertices();
        System.out.println("Money saved by using the algorithm: " + (adj.flowPrice() - adj.minimizeFlowCost()));
    }

    public static AdjacencyGraph Graph() {
        AdjacencyGraph newG = new AdjacencyGraph();
        Vertex jawaharlal = new Vertex("Jawaharlal Nehru");
        Vertex tanjung = new Vertex("Tanjung Pelepas");
        Vertex dar = new Vertex("Dar Es Salaam");
        Vertex mombasa = new Vertex("Mombasa");
        Vertex zanzibar = new Vertex("Zanzibar");
        Vertex salalah = new Vertex("Salalah");
        Vertex jebel = new Vertex("Jebel Ali Dubai");
        newG.addVertex(jawaharlal);
        newG.addVertex(tanjung);
        newG.addVertex(dar);
        newG.addVertex(mombasa);
        newG.addVertex(zanzibar);
        newG.addVertex(salalah);
        newG.addVertex(jebel);

        // Tilføjer edges - Jawaharlal Nehru
        newG.addEdge(jawaharlal, mombasa, 2000); // +2000 (Mombasa)
        newG.addEdge(jawaharlal, dar, 2000); // + 2000 (Dar Es Salaam)

        // Tilføjer edges - Tanjung Pelepas
        newG.addEdge(tanjung, mombasa, 5000); // +5000 (Mombasa)
        newG.addEdge(tanjung, dar, 3000); // +3000 (Dar Es Salaam)
        newG.addEdge(tanjung, zanzibar, 2000); // +2000 (Zanzibar)
        newG.addEdge(tanjung, jebel, 7000); // +7000 (Jebel Ali Dubai)
        newG.addEdge(tanjung, salalah, 7000); // +7000 (Salalah)

        // Tilføjer edges - Dar Es Salaam
        newG.addEdge(dar, tanjung, 5000); // +5000 (Tanjung Pelepas)
        newG.addEdge(dar, jawaharlal, 3000); // +3000 (Jawaharlal Nehru)
        newG.addEdge(dar, jebel, 2000); // +2000 (Jebel Ali Dubai)

        // Tilføjer edges - Mombasa
        newG.addEdge(mombasa, salalah, 2000); // +2000 (Salalah)
        newG.addEdge(mombasa, jebel, 500); // +500 (Jebel Ali Dubai)

        return newG;
    }
}
