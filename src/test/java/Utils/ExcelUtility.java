package Utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

    static Sheet sheet;

    public static void openExcel(String xlPath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(xlPath);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCellData(int rowIndex, int cellIndex) {
        return sheet.getRow(rowIndex).getCell(cellIndex).toString();
    }

    public static int getRowsCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColsCount(int rowIndex) {
        return sheet.getRow(rowIndex).getLastCellNum();
    }

    public static Object[][] convertExlToArray(String filePath, String sheetName) {
        openExcel(filePath, sheetName);
        Object[][] data = new String[getRowsCount() - 1][getColsCount(0)];
        for (int i = 1; i < getRowsCount(); i++) {
            for (int j = 0; j < getColsCount(i); j++) {
                String value = getCellData(i, j);
                data[i - 1][j] = value;
            }
        }
        return data;
    }

}
