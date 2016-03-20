package org.hisrc.tenra.settings;

import java.io.File;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

public class Settings {

	private File inputFile;

	public File getInputFile() {
		return inputFile;
	}

	@Argument(required = true, metaVar = "<INPUT FILE>", usage = "Input file")
	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	private File outputDirectory = new File(".");

	public File getOutputDirectory() {
		return outputDirectory;
	}

	@Option(required = false, name = "-d", aliases = "--output-directory", usage = "Output directory, defaults to the current directory", metaVar = "<OUTPUT DIRECTORY>")
	public void setOutputDirectory(File outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

}
