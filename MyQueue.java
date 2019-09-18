interface MyQueue<T extends Comparable<? super T>>{
    void push(T t) ;
    T top() ;
    T pop() ;
}
