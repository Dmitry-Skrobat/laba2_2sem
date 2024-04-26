import java.util.Scanner;

public class LinkedList {
    private Node head;
    private Node tail;
    private long startTime;
    private long endTime;
    private int length;


    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;

    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }


    public long calculateCreationTime(int numNode){
        LinkedList list = new LinkedList();

        list.startTimer();

        for (int i = 0;i<numNode;i++){
            list.add(i);
        }
        list.stopTimer();
        return list.getElapsedTime();
    }

    public long deleteByIndex(int index){
        LinkedList list = new LinkedList();
        list.startTimer();
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index==0){
            head = head.next;
            if(head!=null){
                head.prev = null;
            }
        }
        else {
            Node current = head;
            for (int i = 0;i<index-1;i++){
                current = current.next;
            }
            current.next = current.next.next;
            if(current.next!=null){
                current.next.prev = current;
            }
            length--;
        }
        list.stopTimer();
        return list.getElapsedTime();
    }

    public long deleteByValue(int value){
        LinkedList list = new LinkedList();
        list.startTimer();
        Node current = head;
        while (current!=null){
            if(current.data==value){
                if (current.prev!=null){
                    current.prev.next = current.next;
                }
                else {
                    head = current.next;
                }
                if (current.next!=null){
                    current.next.prev = current.prev;
                }
                length--;
                list.stopTimer();
                return list.getElapsedTime();
            }
            current = current.next;
        }
        return -1;
    }

    public long insertByIndex(int index,int data){
        LinkedList list = new LinkedList();
        list.startTimer();

        if (index < 0 || index > length) {
            System.out.println("Недопустимый индекс для вставки элемента.");
            return -1;
        }
        Node newNode = new Node(data);
        Node current = head;

        if (index==0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else {
            for (int i = 0;i<index-1;i++){
                current = current.next;
            }
            newNode.prev = current;
            newNode.next = current.next;

            if(current.next!=null){
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
        length++;
        list.stopTimer();
        return list.getElapsedTime();
    }

    public long getIndexByData(int data){
        LinkedList list = new LinkedList();
        list.startTimer();
        Node current = head;
        int index = 0;
        while (current!=null){
            if(current.data==data){
                System.out.println("Индекс найденного элемента: " + index);
                list.stopTimer();
                return list.getElapsedTime();
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public long getDataByIndex(int index){
        LinkedList list = new LinkedList();
        list.startTimer();
        if (index < 0 || index >= length) {
            System.out.println("Недопустимый индекс элемента.");
            return -1;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("Значения элемента по введенному индексу: " + current.data);
        list.stopTimer();
        return list.getElapsedTime();
    }

    public long swapNodes(int index1,int index2){
        LinkedList list = new LinkedList();
        list.startTimer();
        if(index1==index2){
            return list.getElapsedTime();
        }

        Node node1 = getNodeAtIndex(index1);
        Node node2 = getNodeAtIndex(index2);

        if (node1 == null || node2 == null) {
            return -1;
        }

        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;

        list.stopTimer();
        return list.getElapsedTime();
    }

    private Node getNodeAtIndex(int index) {
        Node current = head;
        int count = 0;

        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        return current;
    }

    public long deleteEvenInList(){
        LinkedList list = new LinkedList();
        list.startTimer();
        Node current = head;

        while (current!=null && current.next!=null){
            if(current.next.data % 2==0){
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        if(head.data%2==0){
            head = head.next;
        }
        list.stopTimer();
        return list.getElapsedTime();
    }

    public void findTwo(int num){
        Scanner scanner = new Scanner(System.in);

        Node current = head;
        Node nextStep = head;

        while (nextStep!=null){
            if (current.data>current.next.data){
                Node node1 = current;
                current.next = current.next.next;
                current.prev = current;
                current.next.prev = node1.prev;
                current.next.next = node1.next;
            }
            nextStep = nextStep.next;
        }


    }
}
