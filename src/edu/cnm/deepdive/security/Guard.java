/**
 * 
 */
package edu.cnm.deepdive.security;

import java.util.HashMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * @author David Martinez
 * Pass command line arguments to a parser from Apache Commons library
 * then instantiate and invoke the appropriate classes and methods to 
 * generate the requested artifact.
 * @param args Command line arguments, specifying generation options.
 */
public class Guard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Object> map = getOptions(args);
		String artifact = generateArtifact(map);
		emitArtifact(artifact);
	/** Get options
	 * 	Generate artifact
	 *  Emit artifact
	 */
	}
		
	static HashMap<String, Object> getOptions(String[] args) {
		try {
			Option excludeUpperOption = Option.builder("b").longOpt("exclude-upper")
		                                                     .hasArg(false)
		                                                     .build();
			Option excludeLowerOption = Option.builder("s").longOpt("exclude-lower")
					                                       .hasArg(false)
					                                       .build();
			Option excludeNumberOption = Option.builder("n").longOpt("exclude-numbers")
                                                            .hasArg(false)
                                                            .build();
			Option excludePunctuationOption = Option.builder("p").longOpt("exclude-punctuation")
                                                           .hasArg(false)
                                                           .build();
			Option includeAmbiguous = Option.builder("a").longOpt("include-ambiguous")
                                                         .hasArg(false)
                                                         .build();
	
			
			Option lengthOption = Option.builder("L").argName("length")
													 .hasArg()
													 .longOpt("length")
													 .numberOfArgs(1)
													 .type(Number.class)
													 .build();
			Option delimiterOption = Option.builder("d").argName("delimiter")
														.hasArg()
														.longOpt("delimiter")
														.numberOfArgs(1)
														.optionalArg(true)
														.type(String.class)
														.build();
			Option wordListOption = Option.builder("w").argName("path-to-list-file")
													   .hasArg()
													   .longOpt("word-list")
													   .numberOfArgs(1)
													   .type(String.class)
													   .build();
			Option modeOption = Option.builder("m").longOpt("password-mode")
												   .hasArg(false)
												   .build();
		    Options opts = new Options().addOption(delimiterOption)
		    						   .addOption(lengthOption)
		    						   .addOption(wordListOption)
		    						   .addOption(excludeUpperOption)
		    						   .addOption(excludeLowerOption)
		    						   .addOption(excludePunctuationOption)
		    						   .addOption(excludeNumberOption)
		    						   .addOption(includeAmbiguous)
		    						   .addOption(modeOption);
			DefaultParser parser = new DefaultParser();
			HashMap<String, Object> map = new HashMap<>();
			CommandLine cmdLine = parser.parse(opts, args);
			for (Option option : cmdLine.getOptions()) {
				String opt = option.getOpt();
				map.put(opt, cmdLine.getParsedOptionValue(opt));
			};
			
			return map;
		}   catch (ParseException ex) {
			// TODO Handle this exception with usage display.
			return null;
		}
	}
	
	static String generateArtifact(HashMap<String, Object> map) {
		return null; // FIXME
	}
	
	static void emitArtifact(String artifact) {
		
  }

}
