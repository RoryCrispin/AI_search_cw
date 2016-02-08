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
        MapEdge ij = new MapEdge(I,J,4);

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
        H.addPath(ij);



        //printRoute(ab);
        //printRoutes(B);
        Path p = new Path();
//        p.addNode(A);
//        p.addNode(B);
//        p.addNode(C);
//        p.printPath();
        p.addNode(A);
        p = DFS(A, G, p);
        if (p!= null) {
            p.printPath();
        } else {
            System.out.println("Couldn't find route");
        }

        return A;

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

//    private Path DFS(MapNode start, MapNode dest, Path path){
//        Tree exploreTree = new Tree(null);
//
//        for(MapEdge edge: start.getRoutes()){
//            exploreTree.addChild( new Tree(edge.getConnection(start)) );
//        }
//
//        for (Tree t : exploreTree.getLeaves()   ){
//            if (t.getNode() == dest) {
//                return path;
//            } else{
//                path.addNode(t.getNode());
//                printRoutes(t.getNode());
//                DFS(t.getNode(), dest, path);
//            }
//
//        }
//        return null;
//    }


    private Path DFS(MapNode start, MapNode dest, Path path){
        for(MapEdge edge: start.getRoutes()){
                MapNode n = edge.getConnection(start);
                if (n == dest) {
                    return path;
                } else{
                    path.addNode(n);
                   // printRoutes(n);
                    return DFS(n, dest, path);
                }

            }
        return null;
        }





}
