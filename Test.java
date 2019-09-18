import java.util.* ;
import java.io.* ;

public class Test {

    public static <T> void findDoubles(List<T> data){
        HashSet<T> hs = new HashSet<T>() ;
        for(int i = 0; i < data.size(); i++){
            if(hs.contains(data.get(i))){
                System.out.println("Element at index " + i + " is the same as element at index " + data.indexOf(data.get(i))) ;
            }
            hs.add(data.get(i)) ;
        }
    }

    public static void program1(){
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter a filename to test");
        String filename = sc.nextLine() ;
        ArrayList<Integer> data = new ArrayList<>() ;
        File file = new File(filename) ;
        Scanner scFile = null ;
        try {
            scFile = new Scanner(file) ;
            while(scFile.hasNext()){
                data.add(scFile.nextInt()) ;
            }
        } catch(IOException e) {
            System.out.println("File I/O error !") ;
        } finally {
            if(scFile != null){
                scFile.close() ;
            }
        }
        findDoubles(data) ;
    }

    public static void program2(String[] filenames){
        ArrayList<ArrayList<Integer>> images = new ArrayList<>() ;
        for(String filename : filenames){
            File file = new File(filename) ;
            ArrayList<Integer> data = new ArrayList<>() ;
            Scanner sc = null ;
            try {
                sc = new Scanner(file) ;
                sc.next();
                while(sc.hasNext()){
                    data.add(sc.nextInt()) ;
                }
            } catch(IOException e) {
                System.out.println("File I/O error !") ;
            } finally {
                if(sc != null){
                    sc.close() ;
                }
            }
            images.add(data) ;
        }
        findDoubles(images) ;
    }

    public static void main(String[] args) {
        System.out.println("Program 1");
        program1() ;
        System.out.println("\n-----------------------------------------");
        System.out.println("Program 2");
        program2(args) ;
    }
}
