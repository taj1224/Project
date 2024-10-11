class DLList<T> {
    public Node<T> first; // head node
    public Node<T> last; //tail node
    public int length; // length of list

    //method that returns no. of elements in the list
    public int size() {
        return length;
    }
    // Constructor that generates an empty list
    public DLList() {
        length = 0;
        first = null;
        last = null;
    }
    // Constructor that generates a list with a single element
    public DLList(T e) {
        length = 1;
        first = new Node<T>();
        first.val = e;
        last = first;
    }
    // Constructor that generates a list with two elements
    public DLList(T e, T e2) {
        length = 2;
        first = new Node<T>();
        first.val = e;
        last = new Node<T>();
        last.val = e2;
        first.next = last;
        last.prev = first;
    }
    // Method that allows to display a DLList; use liberally to test your functions!
    public String toString() {
        String res = "[";
        Node<T> it = first;
        if(it != null){
            res += it.val;
            it = it.next;
            while(it != null){
                res += ", " + it.val;
                it = it.next;
            }
        }
        return res + "]";
    }
    // QUESTION 1
    //adding a new element at the end of the list.
    public void push_back(T x) {
        // Your code goes here
        Node<T> newNode = new Node<T>();
        newNode.val = x;
        if (size() == 0) {
            first = newNode;
            last = newNode;
        } else { 
            newNode.prev = last; 
            last.next = newNode;
            last = newNode;
        }
        length++;
    }
    // QUESTION 2
    //adding a new element at the beggining of the list.
    public void push_front(T x) {
        // Your code goes here
        Node<T> newNode = new Node<T>();
        newNode.val = x;
        if (size() == 0) {
            first = newNode;
            last = newNode;
        } else { 
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        length++;
    }
    // QUESTION 3
    //popping out (or) removing the 1st element of the list
    public T pop_front() {
        // Your code goes here
        //throws an exception if no element is there in the list
        if (size() == 0) {
            throw new RuntimeException("List is empty");
        }
        T val = first.val;
        if (size() == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        length--; 
        // The next line should be replaced by something sensible once you're done!
        return val;// popped value will return
    }
    // QUESTION 4
    // Concatenate another list to the end of the current list.
    public void concatenate(DLList<T> xs) {
        // Your code goes here
        if (size() == 0) {
            first = xs.first;
            last = xs.last;
            length = xs.size();
        } else if (xs.size() > 0) { 
            if (last != null) { 
                last.next = xs.first;  
                xs.first.prev = last; 
            }
            last = xs.last; 
            length += xs.size();
        }
    }
    // QUESTION 5
    // get an element at specified index
    public T get(int idx) {
        // Your code goes here
        //throws an exception if specified index is not found in the list
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> it = first;
        for (int i = 0; i < idx; i++) {
            it = it.next;
        }
        // The next line should be replaced by something sensible once you're done!
        return it.val; // returns the value from the specified index.
    }
    // QUESTION 6
    //inserting a new element at a specified index 
    public void insertAt(int idx, T x){
        // Your code goes here
        //throws an exception if specified index is not found in the list
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (idx == 0) {
            push_front(x);
        } else if (idx == size()) {
            push_back(x);
        } else {
            Node<T> newNode = new Node<T>();
            newNode.val = x;
            Node<T> it = first;
            for (int i = 0; i < idx - 1; i++) {
                it = it.next;
            }
            newNode.prev = it;
            newNode.next = it.next;
            it.next.prev = newNode;
            it.next = newNode;
            length++;
        }
    }
    // QUESTION 7
    //Reverse the order of the DLList 
    public void reverse(){
        //if the list is empty or length is equal to 1, then do nothing
        if (size() <= 1) {  
            return;
        }
        Node<T> it = first;
        first = last;
        last = it;
        while (it != null) {
            Node<T> temp = it.prev;
            it.prev = it.next;
            it.next = temp;
            it = it.prev;
        }
    }
}
public class Node<T> {
    public Node<T> prev;
    public T val;
    public Node<T> next;

    public static void main(String[] args) {
        // Testing all the methods
        DLList<Integer> myList = new DLList<>();

        // Testing push_back method
        myList.push_back(1);
        myList.push_back(2);
        myList.push_back(3);
        System.out.println("After push_back: " + myList);

        // Testing push_front method
        myList.push_front(0);
        System.out.println("After push_front: " + myList);

        // Testing pop_front method
        int popped = myList.pop_front();
        System.out.println("Popped element: " + popped);
        System.out.println("After pop_front: " + myList);

        // Testing concatenate method
        DLList<Integer> anotherList = new DLList<>(4, 5);
        myList.concatenate(anotherList);
        System.out.println("After concatenate: " + myList);

        // Testing get method
        int elementAtIndex2 = myList.get(2);
        System.out.println("Element at index 2: " + elementAtIndex2);

        // Testing insertAt method
        myList.insertAt(2, 10);
        System.out.println("After insertAt: " + myList);

        // Testing reverse method
        myList.reverse();
        System.out.println("After reverse: " + myList);
    }
}
