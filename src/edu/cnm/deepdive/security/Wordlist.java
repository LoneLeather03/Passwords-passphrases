package edu.cnm.deepdive.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Wordlist {

  public static final int RECOMMENDED_PHRASE_LEGNTH = 5;

  public static final String WORD_LIST_FILE = "resources/eff_large_wordlist.txt";

  private static final String PROPERTIES_FILE = "resources/text.properties";

  private static String usageMessage;
  private static String errorMessage;
  private static String warningMessage;

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
      System.out.println(Arrays.toString(wordlist)); // FIXME - Get rid of this debugging.
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
}


