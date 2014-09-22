package com.mdnet.travel.core.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseModel implements Serializable{
	private static final long serialVersionUID = 418L;

	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
