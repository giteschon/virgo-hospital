/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.gui;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivy
 */
public class GuiUtilities {

    public static void changePanel(JComponent container, JComponent pnl) {
        container.removeAll();
        container.add(pnl);
        container.repaint();
        container.validate();
    }

    public static void fillDdlWithObject(List<?> list, JComboBox ddl) {

        for (Object o : list) {
            ddl.addItem(o);

        }
    }

    public static void fillDdlBoolean(JComboBox ddl) {
        ddl.addItem("No");
        ddl.addItem("Yes");

    }

    public static DefaultTableModel getModel(JTable table) {
        return (DefaultTableModel) table.getModel();

    }

    public static void changeDdlValue(JComboBox ddl, String value) {
        for (int i = 0; i < ddl.getItemCount(); i++) {

            if ((ddl.getModel().getElementAt(i)).toString().equals(value)) {
                ddl.setSelectedIndex(i);
                ddl.updateUI();
                //System.out.println(ddl.getModel().getElementAt(i));

            } else {
                ddl.setSelectedIndex(1);
                ddl.updateUI();
            }

        }
    }
}
