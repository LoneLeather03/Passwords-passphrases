package edu.cnm.deepdive.security;

import java.security.SecureRandom;

/**
 * 
 * @author David Martinez
 *
 */

public class SecurePasswordGenerator extends PasswordGenerator {

		/** Default value for the phrase length, if none is specified. */
	
		/**
		 * Invokes random number generator.
		 */
	public SecurePasswordGenerator() {
		super();
		rng = new SecureRandom();
		// TODO Auto-generated constructor stub
	}

		/**
		 * Invokes {@link PasswordGenerator#PasswordGenerator(int, int) constructor.
		 * @param minLength
		 * @param maxLength
		 */
	public SecurePasswordGenerator(int minLength, int maxLength) {
		super(minLength, maxLength);
		// TODO Auto-generated constructor stub
	}

		/**
		 * Invokes {@link PasswordGenerator#PasswordGenerator(int, int, boolean, boolean, boolean, boolean, boolean) constructor}
		 */
	public SecurePasswordGenerator(int minLength, int maxLength, boolean IncludeUpperCase, boolean IncludeLowerCase,
			boolean IncludeNumbers, boolean IncludePunctuation, boolean IncludeAmbiguous) {
		super(minLength, maxLength, IncludeUpperCase, IncludeLowerCase, IncludeNumbers, IncludePunctuation,
				IncludeAmbiguous);
		// TODO Auto-generated constructor stub
	}

}
