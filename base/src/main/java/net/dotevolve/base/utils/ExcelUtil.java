/*******************************************************************************
 * @Copyright (c) 2023 DotEvolve, All rights reserved
 * @author DotEvolve
 * @since 25/01/23, 2:06 am
 *
 *
 ******************************************************************************/

package net.dotevolve.base.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {


    public static void readFromExcel(String filepath, String sheetName) throws IOException {

        FileInputStream inputStream = new FileInputStream(filepath);
        XSSFWorkbook workBook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workBook.getSheetAt(0); // get sheet by index

        if (CodeHelp.notEmpty(sheetName)) {
            sheet = workBook.getSheet(sheetName); //get sheet by name
        }

        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        inputStream.close();
    }

    // ArrayList<Object[]> data = new ArrayList<Object[]>();
    // 	data.add(new Object[]{"Name", "Age", "City", "Country"});
    // 	data.add(new Object[]{"Dan", 23, "Saint Paul", "US"});
    // 	data.add(new Object[]{"Emmi", 24, "Burnsville", "US"});
    public static void writeToExcel(List<Object[]> data, String sheetName, String destinationPathWithFileName, String formula) throws IOException {
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet(sheetName);

        //some logic using LOOP or ITERATOR
        int rowNum = 0;
        for (Object[] rowData : data) {
            XSSFRow row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object colElem : rowData) {
                XSSFCell cell = row.createCell(colNum++);
                if (colElem instanceof String) {
                    cell.setCellValue((String) colElem);
                }
                if (colElem instanceof Boolean) {
                    cell.setCellValue((Boolean) colElem);
                }
                if (colElem instanceof Integer) {
                    cell.setCellValue((Integer) colElem);
                }
            }
            if (CodeHelp.notEmpty(formula)) {
                XSSFCell cell = row.createCell(colNum);
                cell.setCellFormula(formula);
            }
        }
        // destinationPathWithFileName = ".//datafiles/data.xlsx";
        FileOutputStream outputStream = new FileOutputStream(destinationPathWithFileName);
        workBook.write(outputStream);
        outputStream.close();
        System.out.printf("File [ %s ]written succesfully!!%n", destinationPathWithFileName);

    }

    // If : C8 is the cell to which formula to be applied then
    // cellRow = 7 & cellCol = 2
    // formula = SUM(C2:C6)
    public static void applyFormulaToParticularCell(String filePath, String sheetName, String formula, int cellRow, int cellCol) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workBook.getSheetAt(0);
        // if(CodeHelp.notEmpty(sheetName)){
        //     sheet = workBook.getSheet(sheetName);
        // }
        sheet.getRow(7).getCell(4).setCellFormula("SUM(E2:E5)");
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workBook.write(outputStream);
        workBook.close();
        outputStream.close();

        System.out.println("Formula Applied Succesfully");

    }

    public static void templateBasedFormatting(String filePath, String sheetName, ExcelFormatterTemplateEnum template) throws IOException {

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
        readFromExcel(filePath, sheetName);
        InputStream is = new FileInputStream("C:\\code\\dot_workspace\\VLogo.png");
        byte[] bytes = IOUtils.toByteArray(is);
        int pictureIdx = workBook.addPicture(bytes, workBook.PICTURE_TYPE_PNG);
        System.out.print("Workbook read succesfully!");
        inputStream.close();

        // XSSFWorkbook formattedWorkBook = formatSheet(workBook, sheetName, template);
        // XSSFCellStyle cellStyle = workBook.createCellStyle();

        // cellStyle.setWrapText(true);
        // cellStyle.setFillForegroundColor(IndexedColors.RED.index);
        // cellStyle.setFillBackgroundColor(IndexedColors.RED.index);
        // cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // cellStyle.setAlignment(HorizontalAlignment.RIGHT);
        // cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);

        XSSFSheet sheet = workBook.getSheetAt(0);
        if (CodeHelp.notEmpty(sheetName)) {
            sheet = workBook.getSheet(sheetName);
        }
        // XSSFRow row = sheet.getRow(2);
        // row.setRowStyle(cellStyle);
        // row.setHeightInPoints(30);

        CreationHelper helper = workBook.getCreationHelper();
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = helper.createClientAnchor();

        anchor.setCol1(1);
        anchor.setRow1(2);
        Picture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize();


        FileOutputStream outputStream = new FileOutputStream(filePath);
        workBook.write(outputStream);
        workBook.close();
        outputStream.close();
    }

    // private static XSSFWorkbook formatSheet(XSSFWorkbook workBook, String sheetName, ExcelFormatterTemplateEnum template) {
    //     XSSFCellStyle cellStyle = workBook.createCellStyle();

    //     cellStyle.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.index);

    //     XSSFSheet sheet = workBook.getSheetAt(0);
    //     if(CodeHelp.notEmpty(sheetName)){
    //         sheet = workBook.getSheet(sheetName);
    //     }
    //     XSSFRow row = sheet.getRow(0);
    //     row.setRowStyle(cellStyle);


    //     return workBook;

    // }

    public static void csvToXLSX() {
        try {
            String csvFileAddress = "C:\\code\\dot_workspace\\28_CSR.csv"; //csv file address
            String xlsxFileAddress = "C:\\code\\dot_workspace\\fromCSV.xlsx"; //xlsx file address
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("sheet1");
            String currentLine = null;
            int RowNum = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFileAddress));
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] str = currentLine.split(",");
                RowNum++;
                XSSFRow currentRow = sheet.createRow(RowNum);
                for (int i = 0; i < str.length; i++) {
                    currentRow.createCell(i).setCellValue(str[i]);
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Done");
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "Exception in try");
        }
    }

    public static void XLSXTocsv() {
        //need to code
    }

    public XSSFWorkbook setHeaderRow(List<String> headers) {
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet();

        int numOfHeaders = headers.size();
        int cellCount = 0;
        int autoSizeCount = 0;


        for (String headerElem : headers) {
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell = row.createCell(cellCount++);
            XSSFCellStyle style = workBook.createCellStyle();
            XSSFFont font = workBook.createFont();
            font.setBold(true);
            font.setFontHeight(16);
            style.setFont(font);

            cell.setCellValue(headerElem);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(autoSizeCount++);
        }
        return workBook;

    }

    public XSSFWorkbook setRowData(XSSFWorkbook workBook, List<List<String>> data) {
        XSSFSheet sheet = workBook.getSheetAt(0);
        int rowCount = 1;

        for (List<String> elemList : data) {
            XSSFRow row = sheet.createRow(rowCount++);
            for (String elem : elemList) {
                int cellCount = 0;
                XSSFCell cell = row.createCell(cellCount++);
                cell.setCellValue(elem);
            }
        }
        return workBook;
    }
}
