package br.com.areadigital.web.service.exceptions;

import java.util.function.Supplier;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
