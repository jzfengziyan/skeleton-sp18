
//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
addLast: The next item we want to add, will go into position size
getLast: The item we want to return is in position size - 1
size: The number of items in the list should be size.
*/

public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        int j = 1;
        //I arrange the elements from the beginning of index:1 of the newArray, so after each resizing, nextFirst = 0;
        for (int i = increase(nextFirst, items.length); i != nextLast; i = increase(i, items.length)) {
            newArray[j] = items[i];
            j = increase(j, newArray.length);
        }
        nextFirst = 0;
        nextLast = j;
        this.items = newArray;
    }

    /**Increase the index in a circular way, could also be implements as: return n = (n + 1) % length.*/
    private static int increase(int n, int length) {
        if (n == (length - 1)) {
            return 0;
        }
        else {
            return n + 1;
        }
    }

    /**Decrese the index in a circular way*/
    private static int decrease(int n, int length) {
        if (n == 0) {
            return length - 1;
        }
        else {
            return n - 1;
        }
    }

    /** Check if the Deque is empty*/
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /**If size == items.length - 1, which means nextFirst = nextLast. We first resize the array, then add the element. This may reduce the usage factor
     *becuase the array would never be fully used. But we still satisfy the requirement, the usage factor never drops off 0.25 when items.length >= 16.
     */
    @Override
    public void addFirst(T x){
        if (size == items.length - 1) {//in this situation, nextFirst = nextLast
            this.resize(items.length * 2);
        }

        items[nextFirst] = x;
        size ++;
        nextFirst = decrease(nextFirst, items.length);
    }
    @Override
    public void addLast(T x){
        if (size == items.length - 1) {
            this.resize(items.length * 2);
        }
        items[nextLast] = x;
        size ++;
        nextLast = increase(nextLast, items.length);
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        if (this.isEmpty()) {
            System.out.println("empty list");
        }
        else {
            int firstIndex = increase(nextFirst, items.length);
            int currentIndex = firstIndex;
            while (currentIndex != nextLast) {
                System.out.print(items[currentIndex]);
                System.out.print(' ');
                currentIndex = increase(currentIndex, items.length);
            }
            System.out.println();
        }
    }
    @Override
    public T removeFirst(){
        if (this.isEmpty()) {
            return null;
        }
        else {
            float ratio = (float) this.size / this.items.length;
            if (ratio < 0.25 && items.length >=16) {
                this.resize(items.length / 2);
            }
            int firstIndex = increase(nextFirst, items.length);
            T firstElement = items[firstIndex];
            items[firstIndex] = null;
            nextFirst = firstIndex;
            size --;
            return firstElement;
        }

    }
    @Override
    public T removeLast(){
        if (this.isEmpty()) {
            return null;
        }
        else {
            float ratio = (float) this.size / this.items.length;
            if(ratio < 0.25 && items.length >= 16) {
                this.resize(items.length / 2);
            }
            int lastIndex = decrease(nextLast,items.length);
            T lastElement = items[lastIndex];
            items[lastIndex] = null;
            nextLast = lastIndex;
            size --;
            return lastElement;
        }
    }
    @Override
    public T get(int index){
        if (index > (this.size - 1) || index < 0 || this.size == 0) {
            return null;
        }
        else {
            int realIndex = (nextFirst + 1 + index) % items.length;
            return items[realIndex];
        }
    }

}