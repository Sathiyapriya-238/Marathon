package first.marathon2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDynamic {

	public static String[][] readData(String fileName) throws IOException {
		//set up the path for excel
        XSSFWorkbook wb=new XSSFWorkbook("./Data/"+fileName+".xlsx");
        //Get into the sheet
         //XSSFSheet ws = wb.getSheet("Create");//by name
         XSSFSheet ws = wb.getSheetAt(0);//by index
         //row count
         int rowCount = ws.getLastRowNum();
         //column(cell) count
         short columnCount = ws.getRow(0).getLastCellNum();
         //To pass data[][]
         String[][] data=new String[rowCount][columnCount];
         //Get into the row
         for (int i = 1; i <=rowCount; i++) {
         XSSFRow row = ws.getRow(i);
         //Get into cell
         for(int j=0;j<columnCount;j++) {
         XSSFCell cell = row.getCell(j);
         //Read the data from cell
         data[i-1][j]=cell.getStringCellValue();
         //1  0
         System.out.println(cell.getStringCellValue());
         }
         }
         //Close the file
         wb.close();
         return data;


	}

}
