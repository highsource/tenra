package org.hisrc.tenra;

import org.hisrc.tenra.processor.Processor;
import org.hisrc.tenra.settings.Settings;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main {

	public static void main(String[] args) throws Exception {

			final Settings settings = new Settings();

		final CmdLineParser parser = new CmdLineParser(settings);

		try {
			parser.parseArgument(args);
			new Processor().process(settings);
		} catch (CmdLineException e) {
			// if there's a problem in the command line,
			// you'll get this exception. this will report
			// an error message.
			System.err.println(e.getMessage());
			// TODO
			System.err.println("java SampleMain [options...] arguments...");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			// // print option sample. This is useful some time
			// System.err.println("  Example: java SampleMain"
			// + parser.printExample(ALL));

			return;
		}
	}

}
