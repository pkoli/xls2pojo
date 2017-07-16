package com.pkoli.reader;

import com.pkoli.writer.XlsToPojoWriter;
import org.apache.maven.plugin.logging.Log;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Pavan on 15-07-2017.
 */
public class XlsToPojoReader {
    public static void read(String fileName, Log log) {

        try {
            FileInputStream excelFile = new FileInputStream(new File(fileName));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row currentRow : sheet) {
                String rowContent = "";
                for (Cell currentCell : currentRow) {

                    if (currentCell != null && currentCell.getCellTypeEnum() != CellType.BLANK) {
                        rowContent += currentCell.getStringCellValue()+",";
                    }
                }
                XlsToPojoWriter.write(rowContent, log);
            }
        } catch (IOException e) {
            log.error(e);
        }
    }
}
