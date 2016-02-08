import java.util.LinkedList;
import java.util.List;

/**
 * Created by rozz on 08/02/16.
 */
public class Path {

    private List<String> route = new LinkedList<String>();


    public void addNode(MapNode n) {
        route.add(n.getData());
    }
    public void printPath(){
        for (String name : route){
            System.out.printf("%S ->", name);
        }
    }
}
