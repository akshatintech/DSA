package Graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSets {
    static class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for (int i = 0 ;i<= n ; i++){
                rank.add(0);
                parent.add(i);
            }
        }

        public int findUltimateParent(int node){
            if (node == parent.get(node)){
                return node;
            }

            int ulp = findUltimateParent(parent.get(node));
            parent.set(node , ulp);
            return parent.get(node);
        }


        public void UnionByRank(int u , int v){
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v){
                return;
            }

            if (rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
            }
            else if(rank.get(ulp_u) > rank.get(ulp_v)){
                parent.set(ulp_v , ulp_u);
            }
            else{
                parent.set(ulp_v , ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u , rankU+1);
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        ds.UnionByRank(1, 2);
        ds.UnionByRank(2, 3);
        ds.UnionByRank(4, 5);
        ds.UnionByRank(6, 7);
        ds.UnionByRank(5, 6);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");


        ds.UnionByRank(3, 7);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");


    }
}
