public class LinkedListDeque<Type> {
        private class StuffNode {
                public Type item;
                public StuffNode next;
                public StuffNode previous;

                public StuffNode(Type i, StuffNode n, StuffNode m) {
                        item = i;
                        next = n;
                        previous = m;
                }
        }

        private StuffNode sentinel;
        private int size;

        /**Build an empty linkedlist*/
        public LinkedListDeque() {
                sentinel = new StuffNode(null, sentinel, sentinel);
                size = 0;
        }

        /**Build a linkedlist with an element x*/
        public LinkedListDeque(Type x) {
                sentinel = new StuffNode(null, sentinel, sentinel);
                sentinel.next = new StuffNode(x, sentinel, sentinel);
                sentinel.previous = sentinel.next;
                size = 1;
        }

        /** Check if the deque is empty*/
        public boolean isEmpty(){
                return size == 0;
        }

        /** Adds x to the front of the list. */
        public void addFirst(Type x) {

                if(this.isEmpty()){
                        sentinel.next = new StuffNode(x, sentinel, sentinel);
                        sentinel.previous = sentinel.next;
                }
                else {
                        sentinel.next = new StuffNode(x, sentinel.next, sentinel);
                        sentinel.next.next.previous = sentinel.next;
                }
                size += 1;
        }

        /** Adds x to the Last element of the list. */
        public void addLast(Type x) {
                if(this.isEmpty()){
                        sentinel.next = new StuffNode(x, sentinel, sentinel);
                        sentinel.previous = sentinel.next;
                }
                else{
                        sentinel.previous.next = new StuffNode(x, sentinel, sentinel.previous);
                        sentinel.previous = sentinel.previous.next;
                }
                size += 1;
        }

        /** Return the size of the linklist */
        public int size(){
                return size;
        }

        /** Print every element of the linklist */
        public void printDeque(){
                if(this.isEmpty()){
                        System.out.println("empty list");
                }
                else {
                        StuffNode currentNode = sentinel.next;
                        while (!currentNode.equals(sentinel)) {
                                System.out.print(currentNode.item);
                                System.out.print(' ');
                                currentNode = currentNode.next;
                        }
                        System.out.println();
                }
        }

        /**remove the first element of the linklist and return the value*/
        public Type removeFirst(){
                if(this.isEmpty()){
                        return null;
                }
                else{
                        Type element = sentinel.next.item;
                        //if there is only one element ? Have to also deal with sentinel.previous
                        if(sentinel.next.next.equals(sentinel)){
                                sentinel.next = sentinel;
                                sentinel.previous = sentinel;
                        }
                        else {
                                sentinel.next = sentinel.next.next;
                                sentinel.next.previous = sentinel;
                        }
                        size --;
                        return element;
                }
        }

        /**remove the last element of the linklist and return the value*/
        public Type removeLast(){
                if(this.isEmpty()){
                        return null;
                }
                else{
                        Type element = sentinel.previous.item;
                        //if there is only one element ? Have to also deal with sentinel.next
                        if(sentinel.next.next.equals(sentinel)){
                                sentinel.next = sentinel;
                                sentinel.previous = sentinel;
                        }
                        else {
                                sentinel.previous = sentinel.previous.previous;
                                sentinel.previous.next = sentinel;
                        }
                        size --;
                        return element;
                }
        }

        /**get the element of a certain index in the list, index begins from 0 (implemented iteratively)*/
        public Type get(int index){
                if(index > (this.size - 1) || index < 0 || this.size == 0){
                        return null;
                }
                else {
                        StuffNode currentNode = sentinel.next;
                        while (index > 0) {
                                currentNode = currentNode.next;
                                index--;
                        }
                        return currentNode.item;
                }
        }

        public Type getRecursiveHelper(StuffNode currentNode, int index){
                if (index == 0){
                        return currentNode.item;
                }
                else if (index > size - 1){
                        return null;
                }
                else return getRecursiveHelper(currentNode.next, index - 1);

        }
        /**get the element of a certain index in the list, index begins from 0 (implemented recursively)*/
        public Type getRecursive(int index){
                return getRecursiveHelper(sentinel.next, index);
        }

}