package com.pkoli.util;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by pkoli on 16/7/17.
 */
public abstract class FileLister {

    public static void listAllCreatedFiles(File outputDirectory, Log log) throws MojoExecutionException {
        File folder = new File(String.valueOf(outputDirectory));
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            try {
                log.info("Files created: "+listOfFiles[i]);
                Writer fileWriter = new FileWriter(listOfFiles[i].getAbsoluteFile(),true);
                fileWriter.write("}");
                fileWriter.close();
            } catch (IOException e) {
                log.error("Exception: ",e);
                throw new MojoExecutionException("Exception: ",e);
            }
        }
    }
}
