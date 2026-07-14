/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<>();
        return clone(node,map);
        
    }
    public Node clone(Node node, HashMap<Node,Node> map){
        if(node==null) return null;
        Node newN = new Node(node.val);
        map.put(node,newN);
        for(Node i:node.neighbors){
            if(!map.containsKey(i)){
                newN.neighbors.add(clone(i,map));
            }
            else{
                newN.neighbors.add(map.get(i));
            }
        }
        return newN;
    }
}