import java.util.LinkedList;
import java.util.List;

/**
 * Created by rozz on 08/02/16.
 */
public class Tree {
    public List<Tree> getLeaves() {
        return leaves;
    }

    private List<Tree> leaves = new LinkedList<Tree>();
    private Tree parent = null;

    public MapNode getNode() {
        return node;
    }

    private MapNode node;

    public Tree(MapNode n){
        this.node = n;
    }

    public void addChild(Tree child){
        this.leaves.add(child);
    }

    public List<Tree> getChildren(){
        return this.leaves;
    }


}
