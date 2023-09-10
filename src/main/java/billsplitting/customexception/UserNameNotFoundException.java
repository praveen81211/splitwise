package billsplitting.customexception;

public class UserNameNotFoundException extends RuntimeException {
	public UserNameNotFoundException(String message) {
		super(message);
	}

}
