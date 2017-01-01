public class ListLauncher {
  public static void main (String[] args) {
    LinkedList myLinkedList = new LinkedList();
    System.out.println(myLinkedList.isEmpty());
    for (int i = 1; i <= 5; i++) {
      myLinkedList.add(i);
    }

    myLinkedList.print();
    SampleableList sampledList = myLinkedList.sample();
    LinkedList newList = (LinkedList)sampledList;
    newList.print();
    //System.out.println(myLinkedList.size());
    //System.out.println(myLinkedList.add(20,75).getReturnValue());
    //myLinkedList.print();
    //System.out.println(myLinkedList.remove(20).getReturnValue());
    //myLinkedList.print();
    //System.out.println(myLinkedList.remove(95).getError());
    //FunctionalLinkedList rest = (FunctionalLinkedList) myLinkedList.rest();
    //rest.print();
    /*FunctionalLinkedList secondList = new FunctionalLinkedList();
    for (int i = 6; i <= 10; i++) {
      secondList.add(i);
    }
    myLinkedList.concat(secondList);*/
    //myLinkedList.print();

    ArrayList myArrayList = new ArrayList();
    System.out.println(myArrayList.isEmpty());
    for (int i = 1; i <= 50; i++) {
      myArrayList.add(i);
    }

    myArrayList.print();
    SampleableList myList = myArrayList.sample();
    ArrayList secondList = (ArrayList)myList;
    secondList.print();
    /*
    System.out.println(myArrayList.size());
    System.out.println(myArrayList.add(20,75).getReturnValue());
    myArrayList.print();
    System.out.println(myArrayList.remove(20).getReturnValue());
    myArrayList.print();
    System.out.println(myArrayList.remove(95).getError());
    */
    StackImpl myStack = new StackImpl(myArrayList);
    myStack.pop();
    myArrayList.print();
    System.out.println(myStack.size());
  }
}
