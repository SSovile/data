package com.company.model.transformer;

import com.company.controller.interfaces.GeneralController;
import com.company.model.models.annotation.Column;
import com.company.model.models.annotation.Table;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Transformer<T> {
    private final Class<T> clazz;

    public Transformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T extractModelFromData(ResultSet rs) throws SQLException {
        T model = null;
        try {
            model = clazz.getConstructor().newInstance();
            if (clazz.isAnnotationPresent(Table.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field: fields) {
                    if(field.isAnnotationPresent(Column.class)) {
                        Column column = field.getAnnotation(Column.class);
                        String name = column.name();
                        String type = field.getType().toString();
                        field.setAccessible(true);
                        switch (type) {
                            case "class java.lang.Integer" -> field.set(model, rs.getInt(name));
                            case "class java.lang.String" -> field.set(model, rs.getString(name));
                            case "class java.lang.Float" -> field.set(model, rs.getFloat(name));
                            case "class java.sql.Date" -> field.set(model, rs.getDate(name));
                            default -> {
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Can not transform object");
        }
        return model;
    }

}