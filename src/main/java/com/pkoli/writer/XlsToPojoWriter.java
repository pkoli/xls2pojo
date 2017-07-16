package com.pkoli.writer;

import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pavan on 15-07-2017.
 */
public class XlsToPojoWriter {
    public static void write(String rowContent, Log log) {
        String[] splitRowContent = rowContent.substring(0, rowContent.length() - 1).split(",");
        createPojo(splitRowContent, log);
    }

    private static void createPojo(String[] splitRowContent, Log log) {
        FileWriter fileWriter = null;
        try {

            File file = new File(applyClassNamingConvention(splitRowContent[0])+".java");

            if (!file.exists()) {
                file.createNewFile();
                fileWriter = new FileWriter(file.getAbsoluteFile(), false);
                fileWriter.write("public class " + splitRowContent[0] + " {\n");
            } else {
                fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            }
            fileWriter.write("\tprivate " + splitRowContent[2] + " " + applyIdentifierNamingConvention(splitRowContent[1]) + ";\n");
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                log.error(ex);
            }
        }
    }

    private static String applyClassNamingConvention(String s) {
        return s;
    }

    private static String applyIdentifierNamingConvention(String s) {
        return s;
    }
}
