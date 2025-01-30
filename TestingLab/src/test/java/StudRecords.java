import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
public class StudRecords {
    @BeforeClass //@BeforeClass runs once before the entire test.
    public void setUp() throws Exception {}
    @Test
    public void testImportexport1() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\USER\\Downloads\\Students.xls");
        Workbook w = Workbook.getWorkbook(fi);
        Sheet s = w.getSheet(0);
        String[][] a = new String[s.getRows()][s.getColumns()];
        FileOutputStream fo = new FileOutputStream("C:\\Users\\USER\\Downloads\\Now.xls");
        WritableWorkbook wwb = Workbook.createWorkbook(fo);
        WritableSheet ws = wwb.createSheet("result1", 0);
        // for 1st Experiment Uncomment the below lines and comment lines from 36 to 52
//        for (int i = 0; i < s.getRows(); i++)
//            for (int j = 0; j < s.getColumns(); j++)
//            {
//                a[i][j] = s.getCell(j, i).getContents();
//                Label l2 = new Label(j, i, a[i][j]);
//                ws.addCell(l2);
//                Label l1 = new Label(6, 0, "Result");
//                ws.addCell(l1);
//            }
        int c = 0;
        for (int i = 0; i < s.getRows(); i++) {
            for (int j = 0; j < s.getColumns(); j++) {
                if (i >= 1) {
                    String b = new String();
                    b = s.getCell(3, i).getContents();
                    int x = Integer.parseInt(b);
                    if (x < 60) {
                        c++;
                        break;
                    }
                }
                a[i][j] = s.getCell(j, i).getContents();
                Label l2 = new Label(j, i - c, a[i][j]);
                ws.addCell(l2);
            }
        }
        wwb.write();
        wwb.close();
    }
}
