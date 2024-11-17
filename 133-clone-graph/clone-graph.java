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
        if(node == null){
            return null;
        }


        Map<Node , Node> map= new HashMap<>();

        //Queue to perform BFS
        Queue<Node> q = new LinkedList<>();


        q.add(node);
        map.put(node , new Node(node.val));

        while(!q.isEmpty()){
            Node curr = q.poll();
            Node currClone = map.get(curr);

            for(Node neighbor: curr.neighbors){

                if(!map.containsKey(neighbor)){

                //CLone the neighbor node and add it to the map
                map.put(neighbor , new Node(neighbor.val));
                q.add(neighbor);

                }

                currClone.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}