import java.util.LinkedList;
import java.util.List;

/**
 * Created by rozz on 08/02/16.
 */
public class Tree {
    private List<Tree> leaves = new LinkedList<Tree>();
    private Tree parent = null;
    private int weight;

    public MapNode getNode() {
        return node;
    }

    private MapNode node;

    public Tree(MapNode n){
        this.node = n;
        this.weight =0;
    }
    public Tree (MapNode n, int weight){
        this.node =n;
        this.weight = weight;
    }

    public void addChild(Tree child){
        this.leaves.add(child);
    }

    public List<Tree> getLeaves(){
        return this.leaves;
    }

    public List<Tree> getLeavesAtDepth(int depth){
        List<Tree> returnList = new LinkedList<Tree>();
        return getLeavesAtDepth(depth, 0, returnList);
    }

    public List<Tree> getLeavesAtDepth(int depth, int curDepth, List<Tree> list){
        curDepth = curDepth+1;
        if (curDepth == depth) {
            list.add(this);
        }
        for (int i = 0; i < leaves.size()-1; i++){
            leaves.get(i).getLeavesAtDepth(depth, curDepth, list);
        }
        if (leaves.size() >0){
            leaves.get(leaves.size() -1).getLeavesAtDepth(depth, curDepth, list);
        }
        return list;
    }

    public void print() {
        print("", true,0);
    }

    private void print(String prefix, boolean isTail, int depth) {

        try {
            depth = depth+1;
            System.out.println(prefix + (isTail ? "└── " : "├── ") + this.weight + ":" + this.node.getData() );
            for (int i = 0; i < leaves.size() - 1; i++) {
                leaves.get(i).print(prefix + (isTail ? "    " : "│   "), false, depth);
            }
            if (leaves.size() > 0) {
                leaves.get(leaves.size() - 1).print(prefix + (isTail ?"    " : "│   "), true,depth);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}
