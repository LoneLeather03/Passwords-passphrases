package edu.cnm.deepdive.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
	/** @author David Martinez */
public class Wordlist {
  /** Phrase length recommendation. */
  public static final int RECOMMENDED_PHRASE_LEGNTH = 5;
  /** Class path relative of the word list file. */
  public static final String WORD_LIST_FILE = "resources/eff_large_wordlist.txt";

  private static final String PROPERTIES_FILE = "resources/text.properties";

  private static String usageMessage;
  private static String errorMessage;
  private static String warningMessage;

  /** Exception handling.
   * @param args*/
  public static void main(String[] args) {
    try {
      loadResources();
      int phraselength = (args.length > 0) ? Integer.parseInt(args[0]) : RECOMMENDED_PHRASE_LEGNTH;
      if (phraselength <= 0) {
        throw new IllegalArgumentException(errorMessage);
      } else if (phraselength < RECOMMENDED_PHRASE_LEGNTH) {
        System.out.println(warningMessage);
      }
      String[] wordlist = getWordList(WORD_LIST_FILE);
      String[] selectedWords = getRandomWords(phraselength, wordlist);
      System.out.println(getJoinedString(selectedWords));
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
      System.out.println(errorMessage);
      System.out.printf(usageMessage);
      System.exit(1);
    } catch (IllegalArgumentException ex) {
      System.out.println(errorMessage);
      System.out.printf(usageMessage, Wordlist.class.getName());
    } catch (IOException ex) {
      ex.printStackTrace();
      System.exit(1);
    }
  }


  private static void loadResources() throws IOException {
    Properties properties = new Properties();
    try (InputStream input = Wordlist.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
      properties.load(input);
      usageMessage = properties.getProperty("usage.message");
      errorMessage = properties.getProperty("error.message");
      warningMessage = properties.getProperty("warningMessage");
    }
  }

  /**
   * @param listPath
   * @return
   * @throws IOException */
  public static String[] getWordList(String listPath) throws IOException {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(Wordlist.class.getClassLoader().getResourceAsStream(listPath)))) {
      ArrayList<String> words = new ArrayList<>();
      for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        words.add(line.split("\\s+")[1]);
      }
      return words.toArray(new String[]{});
    }
  }
  
  /** Randomly select and return a subset of the word list.
   * @param numWords
   * @param wordlist
   * @return */
  public static String[] getRandomWords(int numWords, String[] wordlist) {
    String[] selection = new String[numWords];
    Random rng = new Random();
    for (int i = 0; i < selection.length; i++) {
      int selectedPosition = rng.nextInt(wordlist.length);
      selection[i] = wordlist[selectedPosition];
   
    }
    return selection;
  }
  private static String getJoinedString(String[]source) {
    StringBuilder builder = new StringBuilder();
    for (String item : source) {
      builder.append(item);
      builder.append(" ");
    }
    return builder.toString().trim();
  }
}



