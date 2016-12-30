public class ListLauncher {
  public static void main (String[] args) {
    LinkedList myLinkedList = new LinkedList();
    System.out.println(myLinkedList.isEmpty());
    for (int i = 1; i <= 50; i++) {
      myLinkedList.add(i);
    }

    myLinkedList.print();
    System.out.println(myLinkedList.size());
    System.out.println(myLinkedList.add(20,75).getReturnValue());
    myLinkedList.print();
    System.out.println(myLinkedList.remove(20).getReturnValue());
    myLinkedList.print();
    System.out.println(myLinkedList.remove(95).getError());

    ArrayList myArrayList = new ArrayList();
    System.out.println(myArrayList.isEmpty());
    for (int i = 1; i <= 50; i++) {
      myArrayList.add(i);
    }

    myArrayList.print();
    System.out.println(myArrayList.size());
    System.out.println(myArrayList.add(20,75).getReturnValue());
    myArrayList.print();
    System.out.println(myArrayList.remove(20).getReturnValue());
    myArrayList.print();
    System.out.println(myArrayList.remove(95).getError());
  }
}
