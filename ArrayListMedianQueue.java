import java.util.* ;
import java.io.* ;

class ArrayListMedianQueue<T extends Comparable<? super T>> implements MyQueue<T> {
    ArrayList<T> list ;

    ArrayListMedianQueue(){
        list = new ArrayList<>() ;
    }

    public void push(T t){
        int i = 0;
        while (i < list.size() && list.get(i).compareTo(t) <= 0) {
            i++ ;
        }
        list.add(i, t) ;
    }

    public T top(){
        return list.get(list.size() / 2) ;
    }

    public T pop(){
        return list.remove(list.size() / 2) ;
    }

    public static void main(String[] args) {
        ArrayListMedianQueue<Integer> queue = new ArrayListMedianQueue<>() ;
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
        while(!queue.list.isEmpty()){
            System.out.print(queue.pop() + " ") ;
        }
        System.out.println();
    }
}
