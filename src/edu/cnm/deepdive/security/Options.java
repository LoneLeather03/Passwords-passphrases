/**
 * 
 */
package edu.cnm.deepdive.security;

import java.util.HashMap;
import java.util.ResourceBundle;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;

/**
 * @author David Martinez
 *
 */
public class Options {
	
	private static final String OPTIONS_DESCRIPTION_BUNDLE = "resources/options";
	
	
			private static final String HELP_OPTION_KEY = "help.option";
			private static final String LENGTH_OPTION_KEY = "length.option";
		    private static final String DELIMITER_OPTION_KEY ="delimiter.option";
			private static final String LIST_OPTION_KEY = "word-list.option";
		    private static final String MODE_OPTION_KEY = "password-mode.option";
		    private static final String EXCLUDE_UPPER_OPTION_KEY = "exclude-upper.option";
		    private static final String EXCLUDE_LOWER_OPTION_KEY = "exclude-lower.option";
		    private static final String EXCLUDE_DIGITS_OPTION_KEY = "exclude-digits.option";
		    private static final String EXCLUDE_PUNCTUATION_OPTION_KEY ="exclude-punctuation.option";
		    private static final String INCLUDE_AMBIGUOUS_OPTION_KEY = "include-ambiguous.option";
		    
	  
	  static HashMap<String, Object> getOptions(String[] args) {
	    try {
	    	ResourceBundle bundle = ResourceBundle.getBundle(OPTIONS_DESCRIPTION_BUNDLE);
	    	Option helpOption = Option.builder("?").longOpt("help")
	    										   .hasArg(false)
	    										   .desc(bundle.getString(HELP_OPTION_KEY))
	    										   .build();
	      Option excludeUpperOption = Option.builder("b").longOpt("exclude-upper")
	    		 										 .hasArg(false)
  	 	                                                 .desc(bundle.getString(EXCLUDE_UPPER_OPTION_KEY))
	    		 										 .build();
	                                                     
	      Option excludeLowerOption = Option.builder("s").longOpt("exclude-lower")
	                                                     .hasArg(false)
	                                                     .desc(bundle.getString(EXCLUDE_LOWER_OPTION_KEY))
	                                                     .build();
	      Option excludeDigitsOption = Option.builder("n").longOpt("exclude-digits")
	                                                      .hasArg(false)
	                                                      .desc(bundle.getString(EXCLUDE_DIGITS_OPTION_KEY))
	                                                      .build();
	      Option excludePunctuationOption = Option.builder("p").longOpt("exclude-punctuation")
	                                                           .hasArg(false)
	                                                           .desc(bundle.getString(EXCLUDE_PUNCTUATION_OPTION_KEY))
	                                                           .build();
	      Option includeAmbiguousOption = Option.builder("a").longOpt("include-ambiguous")
	                                                         .hasArg(false)
	                                                         .desc(bundle.getString(INCLUDE_AMBIGUOUS_OPTION_KEY))
	                                                         .build();
	      Option modeOption = Option.builder("m").longOpt("mode-option")
	                                             .hasArg(false)
	                                             .desc(bundle.getString(MODE_OPTION_KEY))
	                                             .build();
	      Option lengthOption = Option.builder("L").argName("length")
	                                               .hasArg()
	                                               .desc(bundle.getString(LENGTH_OPTION_KEY))
	                                               .longOpt("length")
	                                               .numberOfArgs(1)
	                                               .type(Number.class)
	                                               .build();
	      Option delimiterOption = Option.builder("d").argName("delimiter")
	                                                  .hasArg()
	                                                  .desc(bundle.getString(DELIMITER_OPTION_KEY))
	                                                  .longOpt("delimiter")
	                                                  .numberOfArgs(1)
	                                                  .optionalArg(true)
	                                                  .type(String.class)
	                                                  .build();
	      Option wordListOption = Option.builder("w").argName("word-list")
	                                                 .hasArg()
	                                                 .desc(bundle.getString(LIST_OPTION_KEY))
	                                                 .longOpt("word-list")
	                                                 .numberOfArgs(1)
	                                                 .type(String.class)
	                                                 .build();
	      org.apache.commons.cli.Options opts 
	          = new org.apache.commons.cli.Options().addOption(helpOption)
	                                                .addOption(excludeUpperOption)
	                                                .addOption(excludeLowerOption)
	                                                .addOption(excludeDigitsOption)
	                                                .addOption(excludePunctuationOption)
	                                                .addOption(includeAmbiguousOption)
	                                                .addOption(lengthOption)
	                                                .addOption(delimiterOption)
	                                                .addOption(wordListOption)
	                                                .addOption(modeOption);      
	      DefaultParser parser = new DefaultParser();
	      HashMap<String, Object> map = new HashMap<>();
	      CommandLine cmdLine = parser.parse(opts, args);
	      if (cmdLine.hasOption('?')) {
	    	  new HelpFormatter().printHelp("These are the options", opts); // FIXME Take message from resources
	      }
	      for (Option option : cmdLine.getOptions()) {
	        String opt = option.getOpt(); 
	        map.put(opt, cmdLine.getParsedOptionValue(opt));
	      }
	      return map;
	    } catch (ParseException ex) {
	      // TODO Handle this exception with a usage display.
	      return null;
	    }
	  }

	}



