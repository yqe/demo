package finance;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import po.CostManList;
import po.CostManagePO;
import po.EarnedPO;
import po.EarnedPOList;

public class BuildExcel {

	public static boolean CreateCostExcel(CostManList cpolist) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("付款单");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("付款日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("付款金额");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("付款人");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("付款账号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("条目");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("备注");
		cell.setCellStyle(style);


		for (int i = 0; i < cpolist.GetSize(); i++) {
			row = sheet.createRow((int) i + 1);
			CostManagePO am = cpolist.GetIndex(i);
			row.createCell((short) 0).setCellValue(am.getDate());
			row.createCell((short) 1)
					.setCellValue((double) am.getPayment());
			row.createCell((short) 2).setCellValue(am.getPayer());
			row.createCell((short) 3).setCellValue(am.getPayaccount());
			row.createCell((short) 4).setCellValue(am.getTiaomu());
			row.createCell((short) 5).setCellValue(am.getTip());
		}

		try {
			FileOutputStream fout = new FileOutputStream("ExcelFolder/fukuandan.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean CreateEarnExcel(EarnedPOList epolist) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("收款单");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("收款日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("收款金额");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("快递员");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("订单条形码号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("所属营业厅ID");
		cell.setCellStyle(style);

		for (int i = 0; i < epolist.Getsize(); i++) {
			row = sheet.createRow((int) i + 1);
			EarnedPO am = epolist.GetIndex(i);
			row.createCell((short) 0).setCellValue(am.getPaydate());
			row.createCell((short) 1)
					.setCellValue((double) am.getEarnedmoney());
			row.createCell((short) 2).setCellValue(am.getDilivername());
			row.createCell((short) 3).setCellValue(am.getOrderID());
			row.createCell((short) 4).setCellValue(am.getBussinessID());
		}

		try {
			FileOutputStream fout = new FileOutputStream("ExcelFolder/Earned.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
