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
public class ArrayList implements List {
	private Object[] array;

	public ArrayList() {
		array = new Object[50];
	}
	/**
	 * Returns true if the list is empty, false otherwise.
	 *
	 * @return true if the list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		if array[0] = null ? true : false;
	}

	/**
	 * Returns the number of items currently in the list.
	 *
	 * @return the number of items currently in the list
	 */
	public int size() {
		int counter = 0;
		int arraySize = this.array.length();
		while (array[counter] != null && counter < arraySize) {
			counter++;
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
	public ReturnObject get(int index);

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordingly.
	 *
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 *
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message,
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index);

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordingly.
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
	public ReturnObject add(int index, Object item);

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
	public ReturnObject add(Object item);

	/**
	* Resizes the array if appropriate (if it is less than 25% full, the size will
	* half; if it is more than 75% full, the size will double).
	*
	*/
	private void resize() {
		if (array.size() > array.length() * 0.75) {
			Object[] newArray = new Object[array.length() * 2];
			System.arraycopy(array, 0, newArray, 0, array.size());
			this.array = newArray;
		} else if (array.size() < array.length() * 0.25) {
			Object[] newArray = new Object[Math.ceil(array.length() * 0.5)];
			System.arraycopy(array, 0, newArray, 0, array.size());
			this.array = newArray;
		}
	}
}
