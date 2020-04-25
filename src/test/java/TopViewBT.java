import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopViewBT {

    public static void main(String args[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(3);
        q.add(4);
        Iterator itr=q.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        q.remove();
        System.out.println(q);

        Stack<Integer> s= new Stack<Integer>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s);
        s.pop();
        System.out.println(s);
    }
}
