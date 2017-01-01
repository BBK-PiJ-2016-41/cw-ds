/**
 * An implementation of a stack that uses a {@List} as the underlying
 * data structure.
 *
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 *
 * @author kathryn.buckley
 */
public class StackImpl extends AbstractStack {

    public StackImpl(List list) {
  	  super(list);
    }
    /**
  	 * Returns true if the stack is empty, false otherwise.
  	 *
  	 * @return true if the stack is empty, false otherwise.
  	 */
  	public boolean isEmpty() {
      return internalList.isEmpty() ? true : false;
    }

  	/**
  	 * Returns the number of items currently in the stack.
  	 *
  	 * @return the number of items currently in the stack
  	 */
  	public int size() {
      return internalList.size();
    }

  	/**
  	 * Adds an element at the top of the stack.
  	 *
  	 * @param item the new item to be added
  	 */
  	public void push(Object item) {
      internalList.add(0, item);
    }

  	/**
  	 * Returns the element at the top of the stack. The stack is
  	 * left unchanged.
  	 *
  	 * @return If stack is not empty, the item on the top is returned. If the
  	 *         stack is empty, an appropriate error.
  	 */
  	public ReturnObject top() {
      return internalList.get(0);
    }

  	/**
  	 * Returns the element at the top of the stack. The element is
  	 * removed from the stack.
  	 *
  	 * @return If stack is not empty, the item on the top is returned. If the
  	 *         stack is empty, an appropriate error.
  	 */
  	public ReturnObject pop() {
      return internalList.remove(0);
    }
}
