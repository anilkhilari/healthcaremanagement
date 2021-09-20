package in.nit.hcma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SpecializationNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpecializationNotFoundException() {
		super();
	}
	
	public SpecializationNotFoundException(String message) {
		super(message);
	}

}
