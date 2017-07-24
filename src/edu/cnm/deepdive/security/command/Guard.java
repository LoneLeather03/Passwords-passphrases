/**
 * 
 */
package edu.cnm.deepdive.security.command;
import java.util.HashMap;
import java.util.Map;

import edu.cnm.deepdive.security.core.PassphraseGenerator;
import edu.cnm.deepdive.security.core.PasswordGenerator;
import edu.cnm.deepdive.security.core.SecurePasswordGenerator;


/**
 * @author David Martinez
 * Pass command line arguments to a parser from Apache Commons library
 * then instantiate and invoke the appropriate classes and methods to 
 * generate the requested artifact.
 */
public class Guard {

	  /**
	   * Parse command line arguments using Apache Commons CLI library,then 
	   * instantiate and invoke the appropriate classes and methods to 
	   * generate the requested artifact.
	   * 
	   * @param args   Command line arguments, specifying generation options.
	   */
	  public static void main(String[] args) {
	    HashMap<String, Object> map = Options.getOptions(args);
	    if (map != null) {
	    String artifact = generateArtifact(map);
	    emitArtifact(artifact);
	    }
	  }
	 
	  static String generateArtifact(HashMap<String, Object> map) {
	    if (map.containsKey("m")) {
	      PasswordGenerator gen = new SecurePasswordGenerator();
	      // TODO Set fields for all specified options.
	      for (Map.Entry<String, Object> entry : map.entrySet()) {
	    	  switch (entry.getKey()) {
	    	  case "L":
	    	  int length = ((Number) entry.getValue()).intValue();
	    	  gen.setMinLength(length);
	    	  gen.setMaxLength(length);
	    	  break;
	    	  case "a":
	    	  gen.setAmbiguousExcluded(false);
	    	  break;
	    	  case "b":
	    	  gen.setUpperCaseIncluded(false);
	    	  break;
	    	  case "s":
	    	  gen.setLowerCaseIncluded(false);
	    	  break;
	    	  case "n":
	    	  gen.setNumbersIncluded(false);
	    	  break;
	    	  case "p":
	    	  gen.setPunctuationIncluded(false);
	    	  break;
	    	  default:
	    		  break;
	    	  
	    	  }
	    	  
	      }
	      return gen.generate();
	    } else {
	    	PassphraseGenerator gen = new PassphraseGenerator();
	    	// TODO Set fields for all relevant and specified options.
	    	return gen.generate();
	    }
	  
	  }
	  
	  static void emitArtifact(String artifact) {
	   
	    System.out.println(artifact);
	  }
	  
	}
