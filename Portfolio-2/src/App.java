public class App {
    public static void main(String[] args) throws Exception {
        AdjacencyGraph adj = Graph();
        adj.PrintGraph();

    }

    public static AdjacencyGraph Graph() {
        AdjacencyGraph newG = new AdjacencyGraph();
        Vertex a = new Vertex("Jawaharlal Nehru");
        Vertex b = new Vertex("Tanjung Pelepas");
        Vertex c = new Vertex("Dar Es Salaam");
        Vertex d = new Vertex("Mombasa");
        Vertex e = new Vertex("Zanzibar");
        Vertex f = new Vertex("Salalah");
        Vertex g = new Vertex("Jebel Ali Dubai");
        newG.addVertex(a);
        newG.addVertex(b);
        newG.addVertex(c);
        newG.addVertex(d);
        newG.addVertex(e);
        newG.addVertex(f);
        newG.addVertex(g);

        // Tilføjer edges - Jawaharlal Nehru
        newG.addEdge(a, d, 2000); // +2000 (Mombasa)
        newG.addEdge(a, c, 2000); // + 2000 (Dar Es Salaam)

        // Tilføjer edges - Tanjung Pelepas
        newG.addEdge(b, d, 5000); // +5000 (Mombasa)
        newG.addEdge(b, c, 3000); // +3000 (Dar Es Salaam)
        newG.addEdge(b, e, 2000); // +2000 (Zanzibar)
        newG.addEdge(b, g, 7000); // +7000 (Jebel Ali Dubai)
        newG.addEdge(b, f, 7000); // +7000 (Salalah)

        // Tilføjer edges - Dar Es Salaam
        newG.addEdge(c, b, 5000); // +5000 (Tanjung Pelepas)
        newG.addEdge(c, a, 3000); // +3000 (Jawaharlal Nehru)
        newG.addEdge(c, g, 2000); // +2000 (Jebel Ali Dubai)

        // Tilføjer edges - Mombasa
        newG.addEdge(d, f, 2000); // +2000 (Salalah)
        newG.addEdge(d, g, 500); // +500 (Jebel Ali Dubai)

        return newG;
    }
}
