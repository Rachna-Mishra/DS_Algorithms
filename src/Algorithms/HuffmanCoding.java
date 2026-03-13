package Algorithms;

import java.util.*;

class HuffmanCoding {
    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) ->{
            return (n1.val != n2.val) ? n1.val - n2.val : 1;
        });
        for(int i = 0; i < f.length; i++){
            pq.add(new Node(f[i]));
        }
        while(pq.size() != 1){
            {
                Node leftNode = pq.remove();
                Node rightNode = pq.remove();
                int rootVal = leftNode.val+rightNode.val;
                Node root = new Node(rootVal);
                root.left = leftNode;
                root.right = rightNode;
                pq.add(root);
            }
        }
        Node mainroot = pq.remove();
        ArrayList<String> resultList= new ArrayList<>();
        preOrder(mainroot, resultList, "");
        return resultList;
    }

    public void preOrder(Node root, ArrayList<String> resultList, String value){
        if(root.left == null && root.right  == null){
            resultList.add(value);
            return;
        }
        preOrder(root.left, resultList, value+String.valueOf(0));
        preOrder(root.right, resultList, value+String.valueOf(1));
    }
}
class Node {
    Node left;
    Node right;
    int val;

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}