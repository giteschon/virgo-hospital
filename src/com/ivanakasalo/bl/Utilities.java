/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.bl;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Ivana
 */
public class Utilities {
    //date string format
    //MM==month, mm==minutes

    private final static DateFormat FORMAT = new SimpleDateFormat("dd/MM/yy");

    //center form, according to the screen size
    public static void setFormLocation(JFrame form) {
        //screen size
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //form size
        int w = form.getSize().width;
        int h = form.getSize().height;
        //set location x,y
        int x = (d.width - w) / 2;
        int y = (d.height - h) / 2;

        form.setLocation(x, y);

    }

    public static void changeColorOnClick(JButton btn) {

    }

    public static Date getSqlDate(String text) {

        java.util.Date date = new java.util.Date();
        try {
            date = FORMAT.parse(text);
        } catch (ParseException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date sqlDate = new Date(date.getTime());

        return sqlDate;
    }

    public static int getNumber(String text) {
        try {
            int number = Integer.parseInt(text);

            return number;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;

    }

    public static double getDouble(String text) {
        try {
            double number = Integer.parseInt(text);

            return number;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0.0;

    }

    public static Date getDateOfTheWeek(int dayOfTheWeek) {
        //0 je za prvi dan, a 6 za zadnji dan (zbrajaju se!!)
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        c.add(Calendar.DATE, dayOfTheWeek);
        //cast calendar to date
        return new Date(c.getTime().getTime());
    }

    public static Date getDateOfTheMonth(int dayofTheMonth) {
        //1 je za prvi dan, a
        //cal.getActualMaximum(Calendar.DAY_OF_MONTH) za zadnji dan
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, dayofTheMonth);

        return new Date(c.getTime().getTime());
    }

    public static String getDateAsString(Date date) {

        return FORMAT.format(date);
    }

}
