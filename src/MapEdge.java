/**
 * Created by rozz on 08/02/16.
 */
public class MapEdge {

    private int weight;

    public MapNode getPointA() {
        return pointA;
    }

    public MapNode getPointB() {
        return pointB;
    }

    private MapNode pointA;
    private MapNode pointB;

    public MapEdge(MapNode pointA, MapNode pointB, int weight){
        this.pointA = pointA;
        this.pointB = pointB;
        this.weight = weight;
    }

    public MapNode getConnection(MapNode pointX){
        if (pointX == pointA) {
            return pointB;
        } else if (pointX == pointB) {
            return pointA;
        } else return null;
    }

    public int getWeight(){
        return weight;
    }
}
