package com.company;

import com.company.model.managerSessions.Manager;
import com.company.view.View;

public class App {
    public static void main(String[] args) {
        Manager.openSession();
        View view = new View();
        view.print();
        Manager.closeSession();
    }
}