import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;

    }

    int height(Node root){
        if (root==null)
            return 0;
        int lheight=height(root.left);
        int rheight=height(root.right);
        if (lheight>rheight) return lheight+1;
        else return rheight+1;


    }
    void printBfs(){
         int h=height(root);
         for(int i=1;i<=h;++i){
             printBfs(root,i);
         }
         }
   void printBfs(Node root,int level){
        if (root==null)
            return;
        if (level==1){
            System.out.print(root.data+" ");
        }else if (level>1){
            printBfs(root.left,level-1);
            printBfs(root.right,level-1);
        }

   }
   private void topView(Node root){
        class QueueObj {
            Node node;
            int hd;
            QueueObj(Node node, int hd){
                this.node=node;
                this.hd=hd;
            }
            Queue<QueueObj> q=new LinkedList<>();
            Map<Integer, Node> topViewMap=new TreeMap();
            

        }
   }

    public static void main(String[] args) {
            BinaryTree bt=new BinaryTree();
            bt.root=new Node('a');
            bt.root.left=new Node('b');
            bt.root.right=new Node('c');
            bt.root.left.left=new Node('d');
            bt.root.left.right=new Node('e');
            bt.root.right.left=new Node('f');
            bt.root.right.right=new Node('g');
            bt.root.right.right.right=new Node('h');
            System.out.println("height of btree:"+bt.height(bt.root));
            bt.printBfs();
            bt.topView(bt.root);
    }
}