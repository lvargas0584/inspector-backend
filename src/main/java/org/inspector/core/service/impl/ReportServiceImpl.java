package org.inspector.core.service.impl;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.inspector.core.dto.PipeBodyDto;
import org.inspector.core.dto.PipeBoxDto;
import org.inspector.core.dto.PipePinDto;
import org.inspector.core.dto.WorkOrderDto;
import org.inspector.core.service.WorkOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.*;
import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Singleton
public class ReportServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Inject
    WorkOrderService workOrderService;

    @ConfigProperty(name = "inspector.resources.root")
    String resourcesRoot;

    @ConfigProperty(name = "inspector.resources.excel")
    String excelPath;

    @ConfigProperty(name = "inspector.resources.zip")
    String zipPath;

    public String generate(String workOrderId) throws Exception {
        try {

            WorkOrderDto workOrderDto = workOrderService.getWorkOrderById(workOrderId);

            XSSFWorkbook workbook = new XSSFWorkbook();

            buildExcel(workOrderDto, workbook);

            String pathFile = MessageFormat.format(excelPath, workOrderId,workOrderDto.getCode());

            File xls = new File(pathFile);
            xls.getParentFile().mkdirs();
            xls.createNewFile();


            FileOutputStream outputStream = new FileOutputStream(pathFile);
            workbook.write(outputStream);
            workbook.close();

            logger.info("[PATH EXCEL FILE] " + pathFile);

            return pathFile;

        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            throw  new Exception("ERRO AL TRAER DATOS");
        }
        return "";
    }


    private void buildExcel(WorkOrderDto wo, XSSFWorkbook workbook) {

        XSSFSheet sheet = workbook.createSheet("DRILL PIPE");


        AtomicInteger row = new AtomicInteger();

        wo.getPipes().forEach(s -> {

            XSSFRow fila = sheet.createRow(row.get());

            PipePinDto pipePin = s.getPipePin();
            if (pipePin != null) {
                fila.createCell((short) 0).setCellValue(s.getSerialCode() != null ? s.getSerialCode() : "");
                fila.createCell((short) 2).setCellValue(pipePin.getPinOutside() != null ? pipePin.getPinOutside().toString() : "");
                fila.createCell((short) 3).setCellValue(pipePin.getPinInside() != null ? pipePin.getPinInside() : 0);
                fila.createCell((short) 4).setCellValue(pipePin.getPinBevel() != null ? pipePin.getPinBevel().toString() : "");
                fila.createCell((short) 5).setCellValue(pipePin.getPinNeck() != null ? pipePin.getPinNeck().toString() : "");
                fila.createCell((short) 6).setCellValue(pipePin.getPinLpc() != null ? pipePin.getPinLpc().toString() : "");
                fila.createCell((short) 7).setCellValue(pipePin.getPinTong() != null ? pipePin.getPinTong().toString() : "");
                fila.createCell((short) 8).setCellValue(pipePin.getPinHardBandHt() != null ? pipePin.getPinHardBandHt().toString() : "");
                fila.createCell((short) 9).setCellValue(pipePin.getPinHardBandApply() != null ? pipePin.getPinHardBandApply() : "");
                fila.createCell((short) 10).setCellValue(pipePin.getPinVt() != null ? pipePin.getPinVt() : "");
                fila.createCell((short) 11).setCellValue(pipePin.getPinFinalCond() != null ? pipePin.getPinFinalCond().toString() : "");
            }


            PipeBoxDto pipeBox = s.getPipeBox();
            if (pipeBox != null) {
                fila.createCell((short) 12).setCellValue(pipeBox.getBoxOutside() != null ? pipeBox.getBoxOutside().toString() : "");
                fila.createCell((short) 13).setCellValue(pipeBox.getBoxBevel() != null ? pipeBox.getBoxBevel().toString() : "");
                fila.createCell((short) 14).setCellValue(pipeBox.getBoxShoulder() != null ? pipeBox.getBoxShoulder().toString() : "");
                fila.createCell((short) 15).setCellValue(pipeBox.getBoxBoreDiam() != null ? pipeBox.getBoxBoreDiam().toString() : "");
                fila.createCell((short) 16).setCellValue(pipeBox.getBoxBoreDepth() != null ? pipeBox.getBoxBoreDepth().toString() : "");
                fila.createCell((short) 17).setCellValue(pipeBox.getBoxTong() != null ? pipeBox.getBoxTong().toString() : "");
                fila.createCell((short) 18).setCellValue(pipeBox.getBoxHardBandHt() != null ? pipeBox.getBoxHardBandHt().toString() : "");
                fila.createCell((short) 19).setCellValue(pipeBox.getBoxHardBandApply() != null ? pipeBox.getBoxHardBandApply() : "");
                fila.createCell((short) 20).setCellValue(pipeBox.getBoxVt() != null ? pipeBox.getBoxVt() : "");
                fila.createCell((short) 21).setCellValue(pipeBox.getBoxFinalCond() != null ? pipeBox.getBoxFinalCond().toString() : "");
            }

            PipeBodyDto pipeBody = s.getPipeBody();
            if (pipeBody != null) {
                fila.createCell((short) 22).setCellValue("VT");
                fila.createCell((short) 23).setCellValue(pipeBody.getBodyUltraRwt() != null ? pipeBody.getBodyUltraRwt().toString() : "");
                fila.createCell((short) 24).setCellValue(pipeBody.getBodyCoatingCond() != null ? pipeBody.getBodyCoatingCond().toString() : "");
                fila.createCell((short) 25).setCellValue(pipeBody.getBodyClassificationPc() != null ? pipeBody.getBodyClassificationPc().toString() : "");
                fila.createCell((short) 26).setCellValue(pipeBody.getBodyClassificationC2() != null ? pipeBody.getBodyClassificationC2().toString() : "");
                fila.createCell((short) 27).setCellValue(pipeBody.getBodyClassificationC3() != null ? pipeBody.getBodyClassificationC3().toString() : "");
                fila.createCell((short) 28).setCellValue(pipeBody.getBodyClassificationScrap() != null ? pipeBody.getBodyClassificationScrap().toString() : "");
                fila.createCell((short) 29).setCellValue(pipeBody.getEffectiveLength() != null ? pipeBody.getEffectiveLength().toString() : "");
                fila.createCell((short) 30).setCellValue(pipeBody.getRemark() != null ? pipeBody.getRemark() : "");
            }

            row.getAndIncrement();
        });
    }

    public String generateZip(String workOrderId) {

        try{
            WorkOrderDto workOrderDto = workOrderService.getWorkOrderById(workOrderId);
            String sourceFile =  MessageFormat.format(resourcesRoot,workOrderId)+"/images/";
            String outPath = MessageFormat.format(zipPath,workOrderId,workOrderDto.getCode());
            File zip = new File(outPath);
            zip.getParentFile().mkdirs();
            zip.createNewFile();

            FileOutputStream fos = new FileOutputStream(outPath);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(sourceFile);

            zipFile(fileToZip, fileToZip.getName(), zipOut);
            zipOut.close();
            fos.close();
            return  outPath;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}
