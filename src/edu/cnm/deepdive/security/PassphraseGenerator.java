/**
 * 
 */
package edu.cnm.deepdive.security;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * @author David Martinez
 *
 */
public class PassphraseGenerator {
	/** Constant for word list resource. */
	public static final String DEFAULT_WORD_LIST = "resources/wordlist";
	/** Constant for delimiter field. */
	public static final String DEFAULT_DELIMITER = " ";
	/** Constant for default length field. */
	public static final int DEFAULT_LENGTH = 6;
	
	
	private String wordList = DEFAULT_WORD_LIST;
	private String delimiter = DEFAULT_DELIMITER;
	private int length = DEFAULT_LENGTH;
	private Random rng = null;
	private ArrayList<String> pool = null;
	
	
	
	
	/**
	 * Generate passphrase.
	 */
	public PassphraseGenerator() {
		super();
	}
	/** Resource draw for passphrase. */
	protected void setUpPool() {
		ResourceBundle bundle = ResourceBundle.getBundle(wordList);
		pool = new ArrayList<>();
		Enumeration<String> keyEnum = bundle.getKeys();
		while ( keyEnum.hasMoreElements()); {
			String key = keyEnum.nextElement();
			String word = bundle.getString(key);
			pool.add(word);
		}
			
		}
	/** Invokes secure random number generator. */
	protected void setUpRng() {
		rng = new SecureRandom();
	}
	/** Return passphrase. */
	public String generate() {
		if (pool == null) {
			setUpPool();
		}
		if (rng == null) {
			setUpRng();
		}
		StringBuilder builder = new StringBuilder();
		String word = pool.get(rng.nextInt(pool.size()));
		builder.append(word);
		for (int i = 0; i < length - 1; i++) {
		    word = pool.get(rng.nextInt(pool.size()));
			builder.append(delimiter + word);
			builder.append(word);
		}
		return builder.toString().trim();
	}
	/**
	 * @return the wordList
	 */
	public String getWordList() {
		return wordList;
	}
	/**
	 * @param wordList the wordList to set
	 */
	public void setWordList(String wordList) {
		this.wordList = wordList;
	}
	/**
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}
	/**
	 * @param delimiter the delimiter to set
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the rng
	 */
	protected Random getRng() {
		return rng;
	}
	/**
	 * @param rng the rng to set
	 */
	protected void setRng(Random rng) {
		this.rng = rng;
	}





}
