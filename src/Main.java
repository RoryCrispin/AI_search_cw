import java.util.Map;

public class Main {

    public static void main(String[] args) {
        new Main().run();

    }

    private void run(){
        createMap();
    }
    private MapNode createMap(){
        MapNode A = new MapNode("Abacus");
        MapNode B = new MapNode("Bronco");
        MapNode C = new MapNode("Cesar");
        MapNode D = new MapNode("Dragon");
        MapNode E = new MapNode("Etna");
        MapNode F = new MapNode("Fabio");
        MapNode G = new MapNode("Grace");
        MapNode H = new MapNode("Hector");
        MapNode I = new MapNode("Indigo");
        MapNode J = new MapNode("Jason");
        MapNode K = new MapNode("Kliff");

        MapEdge ab = new MapEdge(A,B,3);
        MapEdge bc = new MapEdge(B,C,10);
        MapEdge bd = new MapEdge(B,D,4);
        MapEdge cd = new MapEdge(C,D,3);
        MapEdge de = new MapEdge(D,E,1);
        MapEdge ef = new MapEdge(E,F,0);
        MapEdge eg = new MapEdge(E,G,6);
        MapEdge gh = new MapEdge(G,H,6);
        MapEdge gi = new MapEdge(G,I,10);
        MapEdge hi = new MapEdge(H,I,7);
        MapEdge hj = new MapEdge(H,J,4); //NEW
        MapEdge hk = new MapEdge(H,K,3); //NEW
        MapEdge ij = new MapEdge(I,J,4);
        MapEdge jk = new MapEdge(J,K,1);

        //this is a one way path
        A.addPath(ab);
        B.addPath(bc);
        B.addPath(bd);
        C.addPath(cd);
        D.addPath(de);
        E.addPath(ef);
        E.addPath(eg);
        G.addPath(gh);
        G.addPath(gi);
        H.addPath(hi);
        H.addPath(hj);
        H.addPath(hk);
        I.addPath(ij);
        J.addPath(jk);

        generateTree(A, 11).print();
        return A;

    }

    private Tree generateTree(MapNode n, int depth){
       return generateTree(new Tree(n),n,depth,0);
    }
    private Tree generateTree(Tree t, MapNode n, int depth, int curDepth){
        curDepth = curDepth +1;
        if (curDepth >= depth) return null;

        try {
            for (int i=0; i<n.getRoutes().size()-1; i++){
                MapEdge e = n.getRoutes().get(i);
                Tree nt = new Tree(e.getConnection(n),e.getWeight());
                t.addChild(nt);
                generateTree(nt, e.getConnection(n), depth, curDepth);
            }

            if(n.getRoutes().size() > 0 ) {
                MapEdge e = n.getRoutes().get(n.getRoutes().size() -1);
                Tree nt = new Tree(e.getConnection(n),e.getWeight());
                t.addChild(nt);
                generateTree(nt, e.getConnection(n), depth, curDepth);
            }
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return t;
    }


    private void printRoute(MapEdge edge){
        System.out.printf("N: %s <--> %s : W: %d\n", edge.getPointA().getData(),
                edge.getPointB().getData(), edge.getWeight() );
    }
    private void printRoutes(MapNode node){
        for (MapEdge edge : node.getRoutes()){
            printRoute(edge);
        }
    }

    private void BFS(Tree root, int depth, int curDepth){
        for

    }

}
