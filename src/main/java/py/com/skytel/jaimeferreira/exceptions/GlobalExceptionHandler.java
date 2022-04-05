package py.com.skytel.jaimeferreira.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {


		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
		
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setErrors(errors);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<ApiError> handleForbiddenException(ForbiddenException ex) {
		List<String> errors = new ArrayList<>();
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.FORBIDDEN);
		errors.add(ex.getMessage());
		apiError.setErrors(errors);
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
	}
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ApiError> handleConflictException(ConflictException ex) {
		List<String> errors = new ArrayList<>();
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.CONFLICT);
		errors.add(ex.getMessage());
		apiError.setErrors(errors);
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
		List<String> errors = new ArrayList<>();

		ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));

		Map<String, List<String>> result = new HashMap<>();

		result.put("errors", errors);
		
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setErrors(errors);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError();
		apiError.setStatus(status);
		List<String> errors = new ArrayList<>();
		errors.add(ex.getMessage());
		apiError.setErrors(errors);
		return ResponseEntity.status(status).body(apiError);
	}
}