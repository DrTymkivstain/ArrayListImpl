package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList1<String> someLinkedList = new LinkedList1<>();
        someLinkedList.addTail("q");
        someLinkedList.addTail("w");
        someLinkedList.addTail("e");
        someLinkedList.addTail("r");
        someLinkedList.addHead("1");
        someLinkedList.add("hello", 4);
        System.out.println(someLinkedList.getElByIndex(4));

    }
}
