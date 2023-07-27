package com.security.infraestructure.excelMapper;
import org.apache.poi.ss.usermodel.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class ExcelMapper<T> {

    private final Class<T> type;

    public ExcelMapper(Class<T> type) {
        this.type = type;
    }

    public List<T> mapRows(Sheet sheet) {
        List<T> objects = new ArrayList<>();
        for (Row row : sheet) {
            T object = mapRow(row);
            if (object != null) {
                objects.add(object);
            }
        }
        return objects;
    }

    /*
    private T mapRow(Row row) {
        T instance;
        try {
            instance = type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        int currentCellIndex = 0;
        for (Cell cell : row) {
            String fieldName = "field" + currentCellIndex; // This is just an example, you can use a different naming convention
            try {
                BeanUtils.setProperty(instance, fieldName, getCellValue(cell));
            } catch (Exception e) {
                e.printStackTrace();
            }
            currentCellIndex++;
        }

        return instance;
    }
     */

    // ESTE MÉTODO FUNCIONA CORRECTAMENTE, PERO NO OMITE LA CABEZERA

    private T mapRow(Row row) {
        T instance;
        try {
            instance = type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        int currentCellIndex = 0;
        String[] fieldNames = {"segment", "country", "product", "discountBand", "unitsSold", "manufactoring", "salePrice", "grossSale", "discounts", "sales", "cogs", "profit", "proccessDate", "monthNumber", "monthName", "proccessYear"};

        for (Cell cell : row) {
            String fieldName = fieldNames[currentCellIndex];
            try {
                BeanUtils.setProperty(instance, fieldName, getCellValue(cell));
            } catch (Exception e) {
                e.printStackTrace();
            }
            currentCellIndex++;
        }

        return instance;
    }


    /*
    private T mapRow(Row row) {
        T instance;
        try {
            instance = type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        int currentCellIndex = 1; // Comenzar desde la segunda celda (omitiendo la primera columna/cabecera)

        String[] fieldNames = {"segment", "country", "product", "discountBand", "unitsSold", "manufactoring", "salePrice", "grossSale", "discounts", "sales", "cogs", "profit", "proccessDate", "monthNumber", "monthName", "proccessYear"};

        for (; currentCellIndex < row.getLastCellNum(); currentCellIndex++) {
            String fieldName = fieldNames[currentCellIndex - 1]; // Restar 1 para obtener el nombre del campo correcto del array
            try {
                BeanUtils.setProperty(instance, fieldName, getCellValue(row.getCell(currentCellIndex)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

     */


    private String getCellValue(Cell cell) {
        if (cell == null) { return null; }

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> null;
        };
    }
}

