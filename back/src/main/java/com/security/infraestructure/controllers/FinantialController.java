package com.security.infraestructure.controllers;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.security.application.services.FinantialService;
import com.security.domain.model.Finantial;
import com.security.infraestructure.excelMapper.ExcelMapper;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/finantial")
public class FinantialController {
    private final FinantialService finantialService;

    private static final Logger logger = LoggerFactory.getLogger(FinantialController.class);
    public FinantialController(FinantialService finantialService) {
        this.finantialService = finantialService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Finantial>> getAllFinantials(){
        List<Finantial> finantials = finantialService.getAllFinantials();
        return new ResponseEntity<>(finantials, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Finantial> getFinantialById(@PathVariable Long id){
        return finantialService.getFinantialById(id)
                .map(finantial -> new ResponseEntity<>(finantial, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Finantial> createFinantial(@RequestBody Finantial finantial){
        Finantial createdFinantial = finantialService.createFinantial(finantial);
        return new ResponseEntity<>(createdFinantial, HttpStatus.CREATED);
    }

    @PostMapping("/xlsx/")
    public ResponseEntity<List<Finantial>> uploadXLSXFILE(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            //return "nada";
            logger.info("el archivo está vacio...");
        }

        List<Finantial> finantials = null;

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            ExcelMapper<Finantial> excelMapper = new ExcelMapper<>(Finantial.class);
            finantials = excelMapper.mapRows(sheet);

            for(Finantial finantial : finantials){
                finantialService.createFinantial(finantial);
            }

            // Aquí tienes la lista de objetos Finantial creados a partir del archivo Excel
            return new ResponseEntity<>(finantials, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            //return new ResponseEntity<>(new ArrayList<String>(Collections.singleton("Error al procesar el archivo")), HttpStatus.INTERNAL_SERVER_ERROR);
            logger.info("error al cargar la data del archivo");
        }


        /*

        List<String> fieldValues = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            // Supongamos que estamos leyendo la primera hoja del libro de trabajo (worksheet).
            Sheet sheet = workbook.getSheetAt(0);

            // Obtener el número de filas en la hoja
            int numRows = sheet.getPhysicalNumberOfRows();

            // Variable para rastrear el índice de fila actual
            int currentRowIndex = 0;

            // Iterar a través de las filas de la hoja
            while (currentRowIndex < numRows) {
                // Obtener la fila actual
                Row row = sheet.getRow(currentRowIndex);

                // Obtener el número de celdas (columnas) en la fila actual
                int numCells = row.getPhysicalNumberOfCells();

                int currentCellIndex = 0;

                while (currentCellIndex < numCells) {
                    // Supongamos que el campo que deseas leer está en la primera celda de cada fila.
                    // Puedes cambiar el índice de la celda según tus necesidades.
                    Cell cell = row.getCell(currentCellIndex);

                    // Verificar si la celda no está vacía y es de tipo cadena (string)
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        // Agregar el valor de la celda a la lista de valores de campo
                        fieldValues.add(cell.getStringCellValue());
                        logger.info("data: " + fieldValues);
                    }

                    currentCellIndex++;
                }

                // Incrementar el índice de fila actual para avanzar a la siguiente fila
                currentRowIndex++;
            }


            return new ResponseEntity<>(fieldValues, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<String>(Collections.singleton("Error al procesar el archivo")), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            // Supongamos que estamos leyendo la primera hoja del libro de trabajo (worksheet).
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar a través de las filas de la hoja
            for (Row row : sheet) {
                // Supongamos que el campo que deseas leer está en la primera celda de cada fila.
                // Puedes cambiar el índice de la celda según tus necesidades.
                Cell cell = row.getCell(0);

                // Verificar si la celda no está vacía y es de tipo cadena (string)
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    // Agregar el valor de la celda a la lista de valores de campo
                    fieldValues.add(cell.getStringCellValue());
                }
            }

            return new ResponseEntity<>(fieldValues, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<String>(Collections.singleton("Error al procesar el archivo")), HttpStatus.INTERNAL_SERVER_ERROR);
        }

         */
        return new ResponseEntity<>(finantials, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Finantial> updateFinantial(@PathVariable Long id, @RequestBody Finantial finantial){
        return finantialService.updateFinantial(id, finantial)
                .map(finantialk -> new ResponseEntity<>(finantialk, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFinantialById(@PathVariable Long id){
        return (finantialService.deleteFinantial(id)) ? ResponseEntity.ok("Finantial deleted.") : new ResponseEntity<>("Finantial not found", HttpStatus.NOT_FOUND);
    }
}
