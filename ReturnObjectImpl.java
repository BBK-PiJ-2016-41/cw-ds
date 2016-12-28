/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 * @author kathryn.buckley
 */
public class ReturnObjectImpl implements ReturnObject {
	private Object returnValue;
	private ErrorMessage error;
	// constructor for successful operations
	public ReturnObjectImpl(Object value) {
		this.returnValue = value;
		this.error = null;
	}
	//constructor for failed operations
	public ReturnObjectImpl(ErrorMessage error) {
		this.returnValue = null;
		this.error = error;
	}
	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError() {
		return this.error == null ? false : true;
	}

	/**
	 * Returns the error message.
	 *
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 *
	 * @return the error message
	 */
	public ErrorMessage getError() {
		if (this.hasError()) {
			return this.error;
		} else {
			return ErrorMessage.NO_ERROR;
		}
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 *
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 *
	 * @return the return value from the method or null if there has been an error
	 */
	public Object getReturnValue(){
		if (this.hasError()) {
			return null;
		} else {
			return this.value;
		}
	}
}
