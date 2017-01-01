/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 *
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 *
 * Not all operations on a list will always be successful. For
 * example, a programmer may try to remove an element from an empty
 * list, or from a position where there is nothing. Since we hace not
 * covered exceptions yet, we need another mechanism to report
 * errors. In order to do that, methods of this list will return a
 * {@see ReturnObject} that will contain either an object or an error
 * value of the right kind (as defined in {@see ErrorMessage}).
 *
 * @author kathryn.buckley
 */
public class LinkedList extends SampleableListImpl implements List {
	private ObjectPointer head;

	public LinkedList() {
		this.head = null;
	}
	/**
	 * Returns true if the list is empty, false otherwise.
	 *
	 * @return true if the list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return this.head == null ? true : false;
	}
	/**
	 * Returns the number of items currently in the list.
	 *
	 * @return the number of items currently in the list
	 */
	public int size() {
		if (this.head == null) {
			return 0;
		}
		if (this.head.getNext() == null) {
			return 1;
		}
		int counter = 1;
		ObjectPointer current = head;
		while (current.getNext() != null) {
			counter++;
			current = current.getNext();
		}
		return counter;
	}
	/**
	 * Returns the element at the given position.
	 *
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 *
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message,
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index) {
		ReturnObject returnItem;
		if (this.isEmpty()) {
			returnItem = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return returnItem;
		}
		if (index < 0) {
			returnItem = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return returnItem;
		}
		if (index == 0) {
			returnItem = new ReturnObjectImpl(head.getValue());
			return returnItem;
		}
		ObjectPointer element = findObject(index);
		if (element == null){
			returnItem = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return returnItem;
		} else {
			returnItem = new ReturnObjectImpl(element.getValue());
			return returnItem;
		}
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 *
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 *
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message,
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index){
		ReturnObject returnItem;
		if (this.isEmpty()) {
			returnItem = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return returnItem;
		}
		if (index < 0) {
			returnItem = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return returnItem;
		}
		if (index == 0) {
			ReturnObject headElement = new ReturnObjectImpl(head.getValue());
			head = head.getNext();
			return headElement;
		}
		ObjectPointer element = findObject(index);
		if (element == null){
			returnItem = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return returnItem;
		} else {
			ReturnObject currentObject = new ReturnObjectImpl(element.getValue());
			ObjectPointer previous = findObject(index - 1);
			previous.setNext(element.getNext());
			return currentObject;
		}
	}
	/**
	* Finds an element of the list, given the index. The index provided must be above zero
	* and should be validated before use.
	* @param index the position at which the item can be found
	* @return a pointer to the element
	*/
	protected ObjectPointer findObject (int index) {
		int counter = 0;
		ObjectPointer current = this.head;
		while (counter < index && current != null) {
			current = current.getNext();
			counter++;
		}
		return current;
	}
	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 *
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 *
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 *
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */

	public ReturnObject add(int index, Object item) {
		ReturnObject returnItem;
		if (item == null) {
			returnItem = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return returnItem;
		}
		if (index < 0 || index > this.size() - 1) {
			returnItem = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return returnItem;
		}
		if (index == 0) {
			ObjectPointer insert = new ObjectPointer(item);
			insert.setNext(head);
			head = insert;
			returnItem = new ReturnObjectImpl(item);
			return returnItem;
		}
		ObjectPointer element = findObject(index);
		ObjectPointer previous = findObject(index - 1);
		ObjectPointer insert = new ObjectPointer(item);
		previous.setNext(insert);
		insert.setNext(element);
		returnItem = new ReturnObjectImpl(item);
		return returnItem;
	}

	/**
	 * Adds an element at the end of the list.
	 *
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 *
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(Object item) {
		ReturnObject returnItem;
		if (item == null) {
			returnItem = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return returnItem;
		}
		ObjectPointer insertItem = new ObjectPointer(item);
		if (head == null) {
			head = insertItem;
		} else {
			ObjectPointer lastElement = findObject(this.size() - 1);
			lastElement.setNext(insertItem);
		}
		returnItem = new ReturnObjectImpl(item);
		return returnItem;
	}
	/**
	* Prints all the items in the list on a single line, separated by a space.
	*/
	public void print() {
		String output = "";
		ObjectPointer current = head;
		while (current != null) {
			output += current.getValue().toString() + " ";
			current = current.getNext();
		}
		System.out.println(output);
	}
	public SampleableList sample() {
		SampleableList sampledList = super.sample();
		return sampledList;
	}
}
