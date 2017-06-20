/*
 * PasswordGenerator.java
 */

package edu.cnm.deepdive.security;

import java.util.Random;

/**
 * Implementation of a simple password generator.
 * 
 * @author David Martinez
 * @version 1.0
 */
public class PasswordGenerator {
	
	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE = UPPERCASE.toLowerCase();
	private static final String NUMBERS = "0123456789";
	private static final String PUNCTUATION = "!@#$%&*,.";
	private static final String AMBIGUOUS = "Ol";
	
	private char[] pool = null;
	private int minLength = 6;
	private int maxLength = 12;
	private Random rng;
	private boolean includeUpperCase = true;
	private boolean includeLowerCase = true;
	private boolean includeNumbers = true;
	private boolean includePunctuation = false;
	private boolean excludeAmbiguous = true;

	/**
	 * Test rig for generating passwords
	 * @param args Command-line parameters for password generation options.
	 * Instantiate PasswordGenerator class for testing password generation.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public PasswordGenerator() {
		System.out.println("In default constructor");
		rng = new Random();
	}
	
	public PasswordGenerator(int minLength, int maxLength) {
		this();
		System.out.println("In overloaded constructor");
		this.minLength = minLength;
		this.maxLength = maxLength;
	}
	
	public PasswordGenerator(int minLength, int maxLength,
			boolean IncludeUpperCase, boolean IncludeLowerCase,
			boolean IncludeNumbers, boolean IncludePunctuation,
			boolean IncludeAmbiguous) {
		this(minLength, maxLength);
			System.out.println("In another overloaded constructor");
			this.includeUpperCase = includeUpperCase;
			this.includeLowerCase = includeLowerCase;
			this.includeNumbers = includeNumbers;
			this.includePunctuation = includePunctuation;
			this.excludeAmbiguous = excludeAmbiguous;
	}

	/**
	 * @return the maxLength
	 */
	public int getMaxLength() {
		return maxLength;
	}

	/**
	 * @param maxLength the maxLength to set
	 */
	protected void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * @return the minLength
	 */
	public int getMinLength() {
		return minLength;
	}

	/**
	 * @param minLength the minLength to set
	 */
	protected void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	
	private void setUpPool() {
		if (pool == null) {
		  StringBuilder builder = new StringBuilder();
		  if (includeLowerCase) {
			  builder.append(LOWERCASE);
		  }
		  if (includeUpperCase) {
			  builder.append(UPPERCASE);
		  }
		  if (includeNumbers) {
			  builder.append(NUMBERS);
		  }
		  if (includePunctuation) {
			  builder.append(PUNCTUATION);
		  }
		  String work =  builder.toString();
		  if (excludeAmbiguous) {
			 work.replaceAll(AMBIGUOUS, "");
		  }
		  pool = work.toCharArray();
		}
	}
	
	public String generate() {
		setUpPool();
		int passwordLength = minLength + rng.nextInt(maxLength - minLength + 1);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < passwordLength; i++) {
			char selection = pool[rng.nextInt(pool.length)];
			builder.append(selection);
		}
		return builder.toString();
		
	}

}
