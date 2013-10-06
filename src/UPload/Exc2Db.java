package UPload;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import GradeManage.GradeBean;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Exc2Db {
	/**
	 * ����excel
	 * @param filename
	 * @return list<GradeBean>
	 */
	public List<GradeBean> ReadExcel(String filename){
		
		ArrayList list = new ArrayList();
		GradeBean grade = null;
		try {
			Workbook book = Workbook.getWorkbook(new File(filename));
			Sheet sheet = book.getSheet(0); // ��õ�һ�����������
			int rows = sheet.getRows();
			for (int i = 0; i < rows - 1; i++) {
				grade = new GradeBean();
				Cell[] cell = sheet.getRow(i);
				if (cell.length == 0) {
					continue;
				}
				if(sheet.getCell(0, 0).getContents().trim().contains("ѧ��")){
					grade.setSid(sheet.getCell(0, i+1).getContents());
				}
				if(sheet.getCell(1,0).getContents().trim().contains("����")){
					grade.setSname(sheet.getCell(1,i+1).getContents());
				}
				if(sheet.getCell(2,0).getContents().trim().contains("�༶")){
					grade.setSclass(sheet.getCell(2,i+1).getContents());
				}
				if(sheet.getCell(3,0).getContents().trim().contains("ƽʱ�ɼ�")){
					grade.setPeacetime(Integer.valueOf(sheet.getCell(3,i+1).getContents()));
				}
				if(sheet.getCell(4,0).getContents().trim().contains("���гɼ�")){
					grade.setMidgrade(Integer.valueOf(sheet.getCell(4,i+1).getContents()));
				}
				
				if(sheet.getCell(5,0).getContents().trim().contains("��ĩ�ɼ�")){
					grade.setFinnal(Integer.valueOf(sheet.getCell(5,i+1).getContents()));
				}
				if(sheet.getCell(6,0).getContents().trim().contains("ʵ���ɼ�")){
					grade.setPractic(Integer.valueOf(sheet.getCell(6,i+1).getContents()));
				}
				
				long all = 0;
				all =  (long) ((grade.getPeacetime()+grade.getMidgrade())*0.1+
						0.2*grade.getPractic()+0.6*grade.getFinnal());
				grade.setAll(all);
				list.add(grade);
			}
			

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
