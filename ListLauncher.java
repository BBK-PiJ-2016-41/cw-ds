/**
Things to test before Sunday:
1. Handles null parameters
2. Handles requests to items beyond scope of list
3. StackImpl and ImprovedStackImpl work
4. Handles requests to an empty list
*/
public class ListLauncher {
  public static void main (String[] args) {
    FunctionalLinkedList myLinkedList = new FunctionalLinkedList();
    System.out.println(myLinkedList.isEmpty());
    for (int i = 1; i <= 50; i++) {
      myLinkedList.add(i);
    }

    System.out.println(myLinkedList.add(51, 250).hasError());
    myLinkedList.print();
    //SampleableList sampledList = myLinkedList.sample();
    //LinkedList newList = (LinkedList)sampledList;
    //newList.print();
    System.out.println(myLinkedList.size());
    System.out.println(myLinkedList.get(55).getError());
    System.out.println(myLinkedList.add(null).getError());
    //System.out.println(myLinkedList.add(20,75).getReturnValue());
    //myLinkedList.print();
    //System.out.println(myLinkedList.remove(20).getReturnValue());
    //myLinkedList.print();
    //System.out.println(myLinkedList.remove(95).getError());
    System.out.println(myLinkedList.head().getReturnValue());
    //myLinkedList.print();
    FunctionalList rest = myLinkedList.rest();
    FunctionalLinkedList myRest = (FunctionalLinkedList) rest;
    myRest.print();
    /*FunctionalLinkedList secondList = new FunctionalLinkedList();
    for (int i = 6; i <= 10; i++) {
      secondList.add(i);
    }
    myLinkedList.concat(secondList);*/
    //myLinkedList.print();
    /*
    FunctionalArrayList myArrayList = new FunctionalArrayList();
    System.out.println(myArrayList.isEmpty());
    System.out.println(myArrayList.remove(5).getError());
    for (int i = 1; i <= 75; i++) {
      myArrayList.add(i);
    }
    System.out.println(myArrayList.head().getReturnValue());
    myArrayList.print();
    System.out.println(myArrayList.get(52).getError());
    System.out.println(myArrayList.add(null).getError());
    */
    SampleableList myList = myLinkedList.sample();
    LinkedList secondList = (LinkedList)myList;
    secondList.print();
    /*
    System.out.println(myArrayList.size());
    System.out.println(myArrayList.add(20,75).getReturnValue());
    myArrayList.print();
    System.out.println(myArrayList.remove(20).getReturnValue());
    myArrayList.print();
    System.out.println(myArrayList.remove(95).getError());
    */
    /*
    ImprovedStackImpl myStack = new ImprovedStackImpl(myArrayList);
    myStack.pop();
    myArrayList.print();
    System.out.println(myStack.size());
    ImprovedStackImpl reverseStack = (ImprovedStackImpl) myStack.reverse();
    reverseStack.print();
    */
  }
}
