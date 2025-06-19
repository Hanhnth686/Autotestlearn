package ClassLession.ClassLessionDay05.Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static List<Map<String, String>> readExelData(String filePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList();

        try {
            FileInputStream file = new FileInputStream(filePath);

            try {
                Workbook workbook = new XSSFWorkbook(file);

                try {
                    Sheet sheet = workbook.getSheet(sheetName);
                    if (sheet == null) {
                        throw new IllegalArgumentException("Sheet '" + sheetName + "' không tồn tại trong file " + filePath);
                    }

                    Row headerRow = sheet.getRow(0);
                    if (headerRow == null) {
                        throw new IllegalArgumentException("Sheet '" + sheetName + "' không có dữ liệu hàng tiêu đề");
                    }

                    DataFormatter dataFormatter = new DataFormatter();
                    int colCount = headerRow.getLastCellNum();

                    for (int i = 1; i <= sheet.getLastRowNum(); ++i) {
                        Row row = sheet.getRow(i);
                        if (row != null) {
                            Map<String, String> rowData = new HashMap();
                            boolean hasValue = false;

                            for (int j = 0; j < colCount; ++j) {
                                String columnHeader = dataFormatter.formatCellValue(headerRow.getCell(j)).trim();
                                String cellValue = dataFormatter.formatCellValue(row.getCell(j)).trim();
                                if (!cellValue.isEmpty()) {
                                    hasValue = true;
                                }

                                rowData.put(columnHeader, cellValue);
                            }

                            if (hasValue) {
                                data.add(rowData);
                            }
                        }
                    }
                } catch (Throwable var18) {
                    try {
                        workbook.close();
                    } catch (Throwable var17) {
                        var18.addSuppressed(var17);
                    }

                    throw var18;
                }

                workbook.close();
            } catch (Throwable var19) {
                try {
                    file.close();
                } catch (Throwable var16) {
                    var19.addSuppressed(var16);
                }

                throw var19;
            }

            file.close();
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file Excel: " + e.getMessage());
        }

        return data;
    }
}
