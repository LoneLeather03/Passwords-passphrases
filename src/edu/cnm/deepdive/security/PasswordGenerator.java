/*
 * PasswordGenerator.java
 */

package edu.cnm.deepdive.security;

import java.util.Random;

/**
 * Implementation of a simple password generator. This includes support for
 * elementary character-set-based rules, (optional inclusion of specified sets
 * and exclusion of a small number of ambiguous characters), but not for more advanced
 * expressions.
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
	/** Standard (not cryptographically secure) pseudo */ 
	protected Random rng;
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
		
		/**
		 * Initialize generator for password of length in the range specified.
		 * 
		 * @param minLength   Minimum length of password to be generated.
		 * @param maxLength   Maximum length of password to be generated.
		 */

	}
		/**
		 * Invokes random number generator.
		 */
	public PasswordGenerator() {
		rng = new Random();
	}
		/**
		 * 
		 * @param minLength
		 * @param maxLength
		 */
	public PasswordGenerator(int minLength, int maxLength) {
		this();
		this.minLength = minLength;
		this.maxLength = maxLength;
	}
	
	/** 
	 * 
	 * @param minLength		Minimum length of password to be generated.
	 * @param maxLength		Maximum length of password to be generated.
	 * @param IncludeUpperCase	Include upper case characters.
	 * @param IncludeLowerCase	Include lower case characters.
	 * @param IncludeNumbers	Include numbers.
	 * @param IncludePunctuation	Include punctuation.
	 * @param IncludeAmbiguous 		Exclude the lower case "l" and upper case
	 * 								"O" characters.
	 */
	
	public PasswordGenerator(int minLength, int maxLength,
			boolean IncludeUpperCase, boolean IncludeLowerCase,
			boolean IncludeNumbers, boolean IncludePunctuation,
			boolean IncludeAmbiguous) {
		this(minLength, maxLength);
			this.includeUpperCase = includeUpperCase;
			this.includeLowerCase = includeLowerCase;
			this.includeNumbers = includeNumbers;
			this.includePunctuation = includePunctuation;
			this.excludeAmbiguous = excludeAmbiguous;
			
			
			/**
			 * Instantiate PasswordGenerator class for testing password generation.
			 * @param args    Command-line parameters for password generation options.
			 */ 
	}

	/**
	 * Return max password length.
	 * @return the maxLength
	 */
	public int getMaxLength() {
		return maxLength;
	}

	/**
	 * Set max password length.
	 * @param maxLength the maxLength to set
	 */
	protected void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * Return min password length.
	 * @return the minLength
	 */
	public int getMinLength() {
		return minLength;
	}

	/**
	 * Set min password length.
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
	
	/**
	 * Return password.
	 * @return
	 */
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
