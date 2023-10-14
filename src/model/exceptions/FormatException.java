package model.exceptions;

public class FormatException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FormatException(String msg) {
		super(msg);
	}
}
