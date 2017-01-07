/**
 * An implementation of a stack with additional methods.
 *
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack.
 *
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 *
 * @author kathryn
 */
public class ImprovedStackImpl implements ImprovedStack {

	private List myStackContent;

	public ImprovedStackImpl (List myList) {
		this.myStackContent = myList;
	}

	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 *
	 * @return a copy of this stack with the items reversed.
	 */
	public ImprovedStack reverse() {
		List returnList = new LinkedList();
		List carrierList = new LinkedList();
		int listSize = myStackContent.size();
		for (int i = 0; i < listSize; i++) {
			Object listItem = myStackContent.remove(0).getReturnValue();
			returnList.add(0, listItem);
			carrierList.add(listItem);
		}
		this.myStackContent = carrierList;
		ImprovedStack returnStack = new ImprovedStackImpl(returnList);
		return returnStack;
	}

	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * Classes implementing this method must use method .equals() to
	 * check whether the item is in the stack or not.
	 *
	 * @param object the object to remove
	 */
	public void remove(Object object) {
		int listSize = myStackContent.size();
		for (int i = 0; i < listSize; i++) {
			if (myStackContent.get(i).getReturnValue().equals(object)) {
				myStackContent.remove(i);
			}
		}
	}
	public boolean isEmpty() {
		return myStackContent.isEmpty() ? true : false;
	}

	/**
	 * Returns the number of items currently in the stack.
	 *
	 * @return the number of items currently in the stack
	 */
	public int size() {
		return myStackContent.size();
	}

	/**
	 * Adds an element at the top of the stack.
	 *
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		myStackContent.add(0, item);
	}

	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 *
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top() {
		return myStackContent.get(0);
	}

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed from the stack.
	 *
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		return myStackContent.remove(0);
	}
}
