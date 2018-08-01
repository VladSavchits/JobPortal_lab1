package by.bsuir.jobproject.documentbuilder.impl;

import by.bsuir.jobproject.documentbuilder.ExcelDocumentBuilder;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Jobseeker;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.lang.reflect.Field;
import java.util.List;

public class FreeJobseekersDocumentBuilder extends ExcelDocumentBuilder<List<Jobseeker>> {
    public FreeJobseekersDocumentBuilder() {
        super("free_jobseekers.xls");
    }


    private static class Holder{
        private final static FreeJobseekersDocumentBuilder INSTANCE = new FreeJobseekersDocumentBuilder();
    }

    public static FreeJobseekersDocumentBuilder getInstance(){
        return FreeJobseekersDocumentBuilder.Holder.INSTANCE;
    }

    @Override
    protected void fillDoc(HSSFWorkbook workbook,List<Jobseeker> documentData) throws ServiceException{
        HSSFSheet sheet = workbook.createSheet("Jobseekers");
        int columnsCount = addHeader(sheet, documentData.get(0));
        for (Jobseeker jobseeker : documentData)     {
            fillRow(sheet, jobseeker);
        }
        CellRangeAddress region = new CellRangeAddress(0,0,0,columnsCount);
        sheet.addMergedRegion(region);
        for (int i=0; i< columnsCount; i++){
            sheet.autoSizeColumn(i);
        }
    }

    private void fillRow(HSSFSheet sheet, Jobseeker jobseeker) throws ServiceException{
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
        setCellStyle(row.createCell(0)).setCellValue(jobseeker.getJobseeker_id());
        setCellStyle(row.createCell(1)).setCellValue(jobseeker.getUser_id());
        setCellStyle(row.createCell(2)).setCellValue(jobseeker.getJobseeker_lastname().toString());
        setCellStyle(row.createCell(3)).setCellValue(jobseeker.getJobseeker_name().toString() );
        setCellStyle(row.createCell(4)).setCellValue(jobseeker.getJobseeker_status().toString());
    }

    private int addHeader(HSSFSheet sheet, Jobseeker jobseeker){
        createRowWithCells(sheet, "Список соискателей: ");
        Row row = createRowWithCells(sheet, null);
        Field[] fields = jobseeker.getClass().getDeclaredFields();
        for (int i=0; i< fields.length; i++){
            setCellStyle(row.createCell(i)).setCellValue(fields[i].getName());
        }
        return fields.length - 1;
    }

    private Row createRowWithCells(HSSFSheet sheet, String cellValue){
        Row row = sheet.createRow(sheet.getRow(0) == null ? sheet.getLastRowNum() : sheet.getLastRowNum() + 1);
        Cell cell = row.createCell(0);
        cell.setCellValue(cellValue);
        setCellStyle(cell);
        setCellStyle(row.createCell(1));
        return row;
    }

    private Cell setCellStyle(Cell cell){
        CellStyle cellStyle = cell.getCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
        return cell;
    }
}
