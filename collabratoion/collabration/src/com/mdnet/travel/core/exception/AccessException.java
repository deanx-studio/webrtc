package com.mdnet.travel.core.exception;

public class AccessException extends Exception {
	private static final long serialVersionUID = 374L;

	public AccessException(String info){
		super(info);
	}
}
