/**
 * A sampleable list can be sampled.
 *
 * @author kathryn.buckley
 */
public abstract class SampleableListImpl implements SampleableList {
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty.
	 * This class is extended by LinkedList and ArrayList. If a new extension
	 * is created, it should be included as an option for instantiating returnList.
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableList sample() {
		SampleableList returnList;
		if (this instanceof LinkedList) {
			returnList = new LinkedList();
		} else {
			returnList = new ArrayList();
		}
		if (this.isEmpty()) {
			return returnList;
		}
		int size = this.size();
		for (int i = 0; i < size; i = i + 2) {
			returnList.add(this.get(i).getReturnValue());
		}
		return returnList;
	}
}
