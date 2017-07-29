package com.github.pkoli.reader;

import com.github.pkoli.writer.PojoWriter;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Created by Pavan on 15-07-2017.
 */
public abstract class XlsReader {
    public static void readAndWrite(String fileName, File outputDirectory) throws MojoExecutionException,
            MojoFailureException {

        try {
            InputStream excelFile = new FileInputStream(new File(fileName));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row currentRow : sheet) {
                String rowContent = "";
                for (Cell currentCell : currentRow) {

                    if (currentCell != null && currentCell.getCellTypeEnum()
                            != CellType.BLANK) {
                        rowContent += currentCell.getStringCellValue()+",";
                    }
                }
                PojoWriter.write(outputDirectory, rowContent);
            }
        } catch (IOException e) {
            throw new MojoExecutionException("Exception: ", e);
        }
    }
}
