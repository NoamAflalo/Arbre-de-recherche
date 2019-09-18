import java.lang.Exception ;

class BinSearchTree<T extends Comparable<? super T>>{
    T data ;
    BinSearchTree<T> left, right, parent ;
    int size = 1 ;

    public void add(T t){
        if(t == null) {
            return ;
        }
        if(data == null){
            data = t ;
            return ;
        }
        size++ ;
        if(t.compareTo(data) <= 0){
            if(left == null){
                BinSearchTree<T> v = new BinSearchTree<>() ;
                v.data = t ;
                v.left = v.right = null ;
                v.parent = this ;
                left = v ;
            }
            else {
                left.add(t) ;
            }
        }
        else {
            if(right == null){
                BinSearchTree<T> v = new BinSearchTree<>() ;
                v.data = t ;
                v.left = v.right = null ;
                v.parent = this ;
                right = v ;
            }
            else {
                right.add(t) ;
            }
        }
    }

    public BinSearchTree<T> find(int index){
        BinSearchTree<T> curent = this ;
        while(true){
            if(index < 0 || index >= curent.size){
                System.out.println("Index out of bonds !");
                throw new ArrayIndexOutOfBoundsException();
            }
            int n = curent.left != null ? curent.left.size : 0 ;
            if(n == index){
                return curent ;
            }
            else if(n > index){
                curent = curent.left ;
            }
            else{
                curent = curent.right ;
                index = index - (n + 1) ;
            }
        }
    }

    public BinSearchTree<T> findMax(){
        BinSearchTree<T> curent = this ;
        while(true){
            if(curent.right == null){
                return curent ;
            }
            curent = curent.right ;
        }
    }
}
