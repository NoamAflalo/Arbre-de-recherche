import java.util.* ;
import java.io.* ;

class TreeMedianQueue<T extends Comparable<? super T>> implements MyQueue<T> {
    BinSearchTree<T> root ;

    TreeMedianQueue(){
        root = new BinSearchTree<>() ;
    }

    public void push(T t){
        if(root == null){
            root = new BinSearchTree<>() ;
            root.data = t ;
        }
        else{
            root.add(t) ;
        }
    }

    public T top(){
        if(root == null){
            return null ;
        }
        return root.find(root.size / 2).data ;
    }

    public T pop(){
        if(root == null){
            return null ;
        }
        BinSearchTree<T> result = root.find(root.size / 2) ;
        T resultData = result.data ;
        if(root.size == 1){
            root = null ;
            return resultData ;
        }
        if(result.left != null && result.left.right == null){
            result.data = result.left.data ;
            result.left = result.left.left ;
            if(result.left != null){
                result.left.parent = result ;
            }
            BinSearchTree<T> tmp = result ;
            while(tmp != null){
                tmp.size-- ;
                tmp = tmp.parent ;
            }
            return resultData ;
        }
        if(result.left != null && result.left.right != null){
            BinSearchTree<T> bt = result.left.findMax() ;
            bt.parent.right = bt.left ;
            if(bt.left != null){
                bt.left.parent = bt.parent ;
            }
            result.data = bt.data ;
            BinSearchTree<T> tmp = bt.parent ;
            while(tmp != null){
                tmp.size-- ;
                tmp = tmp.parent ;
            }
            return resultData ;
        }
        if(result == root){
            root = result.right ;
            if(result.right != null){
                result.right.parent = null ;
            }
            return resultData ;
        }
        if(result.parent.left == result){
            result.parent.left = result.right ;
            if(result.right != null){
                result.right.parent = result.parent ;
            }
        }
        if(result.parent.right == result){
            result.parent.right = result.right ;
            if(result.right != null){
                result.right.parent = result.parent ;
            }
        }
        BinSearchTree<T> tmp = result.parent ;
        while(tmp != null){
            tmp.size--;
            tmp = tmp.parent ;
        }
        return resultData ;
    }

    public static void main(String[] args) {
        TreeMedianQueue<Integer> queue = new TreeMedianQueue<>() ;
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter a filename :");
        String filename = sc.nextLine() ;
        File file = new File(filename) ;
        Scanner scFile = null ;
        try {
            scFile = new Scanner(file) ;
            while(scFile.hasNext()){
                queue.push(scFile.nextInt()) ;
            }
        } catch(IOException e) {
            System.out.println("File I/O error !");
        } finally {
            if(scFile != null){
                scFile.close() ;
            }
        }
        while(queue.root != null){
            System.out.print(queue.pop() + " ") ;
        }
        System.out.println();
    }
}
