package com.github.pkoli.writer;

import com.github.pkoli.util.XlsToPojoNamingUtil;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Pavan on 15-07-2017.
 */
public abstract class PojoWriter {
    private static final XlsToPojoNamingUtil XLS_TO_POJO_NAMING_UTIL =
            new XlsToPojoNamingUtil();

    public static void write(File outputDirectory, String rowContent)
            throws MojoFailureException, MojoExecutionException {
        String[] splitRowContent = rowContent.substring(0,
                rowContent.length() - 1).split(",");
        createPojo(outputDirectory, splitRowContent);
    }

    private static void createPojo(File outputDirectory, String[] splitRowContent)
            throws MojoExecutionException, MojoFailureException {
        Writer fileWriter = null;
        try {
            outputDirectory.mkdirs();
            File file = new File(outputDirectory.toString() +"/"+ XLS_TO_POJO_NAMING_UTIL.
                    applyClassNamingConvention(splitRowContent[0]) + ".java");

            if (!file.exists()) {
                file.createNewFile();
                fileWriter = new FileWriter(file.getAbsoluteFile(), false);
                fileWriter.write("public class " + XLS_TO_POJO_NAMING_UTIL.
                        applyClassNamingConvention(splitRowContent[0]) + " {" +
                        System.getProperty("line.separator") + "");
            } else {
                fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            }
            fileWriter.write("\tpublic " + splitRowContent[2] + " " +
                    XLS_TO_POJO_NAMING_UTIL.applyIdentifierNamingConvention(
                            splitRowContent[1]) + ";" +
                    System.getProperty("line.separator") + "");
        } catch (IOException e) {
            throw new MojoExecutionException("Exception: ", e);
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                throw new MojoFailureException("Exception: ", ex);
            }
        }
    }
}
