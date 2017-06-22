/**
 * 
 */
package edu.cnm.deepdive.security;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * @author David Martinez
 *
 */
public class Guard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
		
	static CommandLine getOptions(String[] args) {
		try {
			Option lengthOption = Option.builder("l"
					+ "L").argName("length")
													 .hasArg()
													 .longOpt("length")
													 .numberOfArgs(1)
													 .type(Byte.class)
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
		    Options opts = new Options().addOption(delimiterOption)
		    						   .addOption(lengthOption)
		    						   .addOption(wordListOption);
			DefaultParser parser = new DefaultParser();
			CommandLine cmdLine = parser.parse(opts, args);
			Object test = cmdLine.getParsedOptionValue("L"); // FIXME - debug statement
			return cmdLine;
		}   catch (ParseException ex) {
			// TODO Handle this exception with usage display.
			return null;
		}
	}
	
	static String generateArtifacte(CommandLine cmdLine) {
		return null; // FIXME
	}
	
	static void emitArtifact(String artifact) {
		
  }

}
