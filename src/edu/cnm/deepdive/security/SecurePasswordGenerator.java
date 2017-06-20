package edu.cnm.deepdive.security;

import java.security.SecureRandom;

public class SecurePasswordGenerator extends PasswordGenerator {

	public SecurePasswordGenerator() {
		super();
		rng = new SecureRandom();
		// TODO Auto-generated constructor stub
	}

	public SecurePasswordGenerator(int minLength, int maxLength) {
		super(minLength, maxLength);
		// TODO Auto-generated constructor stub
	}

	public SecurePasswordGenerator(int minLength, int maxLength, boolean IncludeUpperCase, boolean IncludeLowerCase,
			boolean IncludeNumbers, boolean IncludePunctuation, boolean IncludeAmbiguous) {
		super(minLength, maxLength, IncludeUpperCase, IncludeLowerCase, IncludeNumbers, IncludePunctuation,
				IncludeAmbiguous);
		// TODO Auto-generated constructor stub
	}

}
