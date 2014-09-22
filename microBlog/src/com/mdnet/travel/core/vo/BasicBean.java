package com.mdnet.travel.core.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BasicBean implements Serializable{
	private static final long serialVersionUID = 734783L;

	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
