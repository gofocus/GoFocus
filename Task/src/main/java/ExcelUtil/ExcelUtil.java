package ExcelUtil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.InputStream;
import java.util.HashSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtil {

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    /**
     * 判断Excel的版本,获取Workbook
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in, File file) throws IOException {
        Workbook wb = null;
        if (file.getName().endsWith(EXCEL_XLS)) {  //Excel 2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     *
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception {
        if (!file.exists()) {
            throw new Exception("文件不存在");
        }
        if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
            throw new Exception("文件不是Excel");
        }
    }

    /**
     * 读取Excel测试，兼容 Excel 2003/2007/2010
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 同时支持Excel 2003、2007
            File excelFile = new File("d:/product.xlsx"); // 创建文件对象
            FileInputStream in = new FileInputStream(excelFile); // 文件流
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbok(in, excelFile);
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            /**
             * 设置当前excel中sheet的下标：0开始
             */
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet
//            Sheet sheet = workbook.getSheetAt(2);   // 遍历第三个Sheet

//            获取总行数
            System.out.println("总行数" + sheet.getLastRowNum());

            // 为跳过第一行目录设置count
            int count = 0;



            HashSet<String> hashSet = new HashSet();

            for (Row row : sheet) {
                try {
                    // 跳过第一和第二行的目录
                    if (count < 1) {
                        count++;
                        continue;
                    }

                    //如果当前行没有数据，跳出循环
                    if (row.getCell(0).toString().equals("")) {
                        return;
                    }

                    //获取总列数(空格的不计算)
                    int columnTotalNum = row.getPhysicalNumberOfCells();
//                    System.out.println("总列数：" + columnTotalNum);

//                    System.out.println("最大列数：" + row.getLastCellNum());

                    //for循环的，不扫描空格的列
//                    for (Cell cell : row) {
//                    	System.out.println(cell);
//                    }
                    int end = row.getLastCellNum();

                    String sql = "insert into INF_ITEM_MAPPING(ST_ID,ST_ITEM_NAME,ST_ITEM_CODE,ST_SUMMER_ITEM_NO) values (newid(),";
                    boolean flag = true;
                    for (int i = 7; i < 12; i+=2) {
                        if (i == 7 || i == 9 || i == 11) {
                            Cell cell = row.getCell(i);
                           /* if (cell == null) {
                                System.out.print("null" + "\t");
                                continue;
                            }*/
                            Object obj = getValue(cell);

                            if (i == 7)
                                if (hashSet.add(obj.toString()))
                                    flag = true;
                                else flag = false;
                            if (flag) {
                                sql = sql + "'" + obj + "'";
                                if (i != 11) sql = sql + ",";
                            }
                        }
                    }
                    if (flag) {
                        sql += ")";
                        System.out.println(sql);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object getValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                Double d = cell.getNumericCellValue();
                obj = d.intValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }
}
