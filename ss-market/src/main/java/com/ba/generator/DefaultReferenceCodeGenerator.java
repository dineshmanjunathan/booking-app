package com.ba.generator;

import com.ba.gen.hbm.AbstractStringIDGenerator;

public class DefaultReferenceCodeGenerator extends AbstractStringIDGenerator {
	
	private static final long serialVersionUID = 1L;

	public static final String defaultSsequencePrefix = ENTITY_KEY_CODE.KEY_REFERED_ID;
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%07d";

	
	public DefaultReferenceCodeGenerator() {
		super();
	}
	
	@Override
	public String defaultEntityIdentifierPrefix() {
		return defaultSsequencePrefix;
	}

	@Override
	public boolean isStringFormatDecimal() {
		return true;
	}

	@Override
	public String getStringFormat() {
		// --String.format("%010d", nextValue);
		return stringFormat;
	}
	
	@Override
	public boolean isAssignedSequence() {
		return false;
	}

}
