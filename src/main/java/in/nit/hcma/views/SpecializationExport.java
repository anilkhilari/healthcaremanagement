package in.nit.hcma.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.hcma.entities.Specialization;

public class SpecializationExport extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
									  Workbook workbook,
									  HttpServletRequest request,
									  HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=SPECS.xlsx");
		
		@SuppressWarnings("unchecked")
		List<Specialization> specializations=(List<Specialization>)model.get("specializations");
		
		Sheet sheet=workbook.createSheet("specialization");
		
		setHead(sheet);
		setBody(sheet,specializations);
			
			
	}
	
	private void setHead(Sheet sheet) {
		Row rowHead=sheet.createRow(0);
		rowHead.createCell(0).setCellValue("ID");
		rowHead.createCell(1).setCellValue("Code");
		rowHead.createCell(2).setCellValue("Name");
		rowHead.createCell(3).setCellValue("Note");
		
	}
	
	private void setBody(Sheet sheet, List<Specialization> specializations) {
		int rowNum=1;
		
		for(Specialization specialization:specializations) {
			rowNum++;
			Row row=sheet.createRow(rowNum);
			row.createCell(0).setCellValue(specialization.getId());
			row.createCell(1).setCellValue(specialization.getCode());
			row.createCell(2).setCellValue(specialization.getName());
			row.createCell(3).setCellValue(specialization.getNote());
			
		}
		
	}

}
