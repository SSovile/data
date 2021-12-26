package com.company.view;

import com.company.controller.*;
import com.company.controller.interfaces.GeneralController;
import com.company.model.models.*;
import com.company.model.models.GeneralModel;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View implements Printable{
    private final Map<String, GeneralController> controllers;
    private final Map<String, GeneralModel> models;
    private String consoleInput;
    private Scanner input;
    boolean isQuit;

    public View() {
        input = new Scanner(System.in, StandardCharsets.UTF_8);
        isQuit = false;
        models = new HashMap<>();
        controllers = new HashMap<>();
        controllers.put("SmartWatch",new SmartWatchController());
        controllers.put("Street",new StreetController());
        controllers.put("UserInformation",new UserInformationController());
        controllers.put("Position",new PositionController());
        controllers.put("User",new UserController());
        controllers.put("Customer",new CustomerController());
        controllers.put("Settings",new SettingsController());
        controllers.put("HomeAddress",new HomeAddressController());
        controllers.put("City",new CityController());


        models.put("SmartWatch",new SmartWatch());
        models.put("Street",new Street());
        models.put("UserInformation",new UserInformation());
        models.put("Position",new Position());
        models.put("User",new User());
        models.put("Customer",new Customer());
        models.put("Settings",new Settings());
        models.put("HomeAddress",new HomeAddress());
        models.put("City",new City());
    }

    @Override
    public void print(){
        while (!isQuit) {
            try {
                System.out.println("Type in console key to choose option(key - option):");
                System.out.println(getTables());
                consoleInput = input.nextLine().toUpperCase();
                switch (consoleInput) {
                    case "SmartWatch" -> printMethodModel("SmartWatch");
                    case "Street" -> printMethodModel("Street");
                    case "UserInformation" -> printMethodModel("UserInformation");
                    case "Position" -> printMethodModel("Position");
                    case "User" -> printMethodModel("User");
                    case "Customer" -> printMethodModel("Customer");
                    case "Settings" -> printMethodModel("Settings");
                    case "HomeAddress" -> printMethodModel("HomeAddress");
                    case "City" -> printMethodModel("City");
                    case "Quit" -> isQuit = true;
                    default -> System.out.println("invalid input");
                }
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        }
    }

    private void printMethodModel(String table) throws SQLException {
        boolean isBack = false;
        while (!isBack) {
            System.out.println(getMethodModel(table));
            consoleInput = input.nextLine().toUpperCase();
            switch (consoleInput) {
                case "FindAll" -> printFindAll(controllers.get(table));
                case "FindById" -> printFindById(controllers.get(table));
                case "Create" -> createModel(controllers.get(table), models.get(table));
                case "Update" -> updateModel(controllers.get(table), models.get(table));
                case "Delete" -> delete(controllers.get(table));
                case "Back" -> isBack = true;
                default -> System.out.println("invalid input");
            }
        }
    }

    private String getTables() {
        StringBuffer str = new  StringBuffer();
        str.append("    SmartWatch - SmartWatch\n");
        str.append("    Street - Street\n");
        str.append("    UserInformation - UserInformation\n");
        str.append("    User - User\n");
        str.append("    Position - Position\n");
        str.append("    Customer - Customer\n");
        str.append("    Settings - Settings\n");
        str.append("    HomeAddress - HomeAddress\n");
        str.append("    City - City\n");
        str.append("    Quit - quit\n");
        return str.toString();
    }

    private String getMethodModel(String table) {
        StringBuffer str = new  StringBuffer();
        str.append(table+"\n");
        str.append("    FindAll - Find All\n");
        str.append("    FindById - Find by id\n");
        str.append("    Create - Create\n");
        str.append("    Update - Update\n");
        str.append("    Delete - Delete\n");
        str.append("    Back - Back\n");
        return str.toString();
    }

    private void printFindAll(GeneralController controller) throws SQLException {
        for (Object a:controller.findAll()) {
            System.out.println(a);
        }
    }

    private void printFindById(GeneralController controller) throws SQLException {
        System.out.println("Print id of model:");
        consoleInput = input.nextLine();
        System.out.println(controller.findById(Integer.parseInt(consoleInput)));
    }

    private void createModel(GeneralController controller, GeneralModel model) throws SQLException {
        controller.create(getModel(model,false));
        System.out.println("Success");
    }

    private void updateModel(GeneralController controller, GeneralModel model) throws SQLException {
        model = getModel(model,true);
        if(model == null){
            System.out.println("Bad input");
        }else {
            controller.update(model);
            System.out.println("Success");
        }
    }

    private GeneralModel getModel(GeneralModel model,boolean isToUpdate){
        try {
            model = model.getClass().getConstructor().newInstance();
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field: fields) {
                if(field.getName() == "id" && !isToUpdate){
                    continue;
                }
                System.out.println("Print value of " + field.getName() + " type " + field.getAnnotatedType() + ": ");
                consoleInput = input.nextLine();
                field.setAccessible(true);
                switch (field.getAnnotatedType().toString()) {
                    case "java.lang.Integer":
                        field.set(model, Integer.parseInt(consoleInput));
                        break;
                    case "java.lang.String":
                        field.set(model, consoleInput);
                        break;
                    case "java.lang.Float":
                        field.set(model, Float.parseFloat(consoleInput));
                        break;
                    case "com.company.model.models.City":
                        field.set(model, controllers.get("City").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.company.model.models.Customer":
                        field.set(model, controllers.get("Customer").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.company.model.models.GeneralModel":
                        field.set(model, controllers.get("GeneralModel").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.company.model.models.Position":
                        field.set(model, controllers.get("Position").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "java.sql.Date":
                        field.set(model, Date.valueOf(consoleInput));
                        break;
                    default:
                        break;
                }
            }
            return model;
        }catch (Exception e){
            System.out.println("bad input" + e);
        }
        return null;
    }

    public void delete(GeneralController controller) throws SQLException {
        System.out.println("Print id of model to delete:");
        consoleInput = input.nextLine();
        System.out.println("Success");
        System.out.println(controller.delete(Integer.parseInt(consoleInput)));
    }
}