import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rozz on 08/02/16.
 */
public class MapNode {
    private List<MapEdge> routes = new LinkedList<MapEdge>();
    private String data;



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public MapNode(String data) {
        this.data = data;
    }
    public void addPath(MapEdge path){
        this.routes.add(path);
    }
    public void addPathTwoWay(MapEdge path){
        this.routes.add(path);
        path.getConnection(this).addPath(path);
    }
    public List<MapEdge> getRoutes(){
        return this.routes;
    }

}
