/**
 * @(#) UtilDate.java 1.0 27/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

/**
 * @version 1.0 27/01/2021
 * @author Pietro do Nascimento
 */
public class UtilDate {
	
	public UtilDate() {
    }

    public static java.sql.Date getDate() {
        return new java.sql.Date(new java.util.Date().getTime());
    }

    public static String format(java.sql.Date date) {
        return getFormat("dd/MM/yyyy").format(date);
    }

    public static String format(java.util.Date date) {
        return getFormat("dd/MM/yyyy").format(date);
    }
    
    public static String format(LocalDate date) {
        return getFormat("dd/MM/yyyy").format(parse(date));
    }

    public static java.sql.Date parse(String str) {
        return parse("dd/MM/yyyy", str);
    }

    public static java.sql.Date parse(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.sql.Date parse(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    public static java.sql.Date parse(String format, String str) {
        try {
            if (str == null || str.equals("")) {
                return null;
            }
            return new java.sql.Date(getFormat(format).parse(str).getTime());
        } catch (ParseException pex) {
            System.err.println("UtilDate - > parse: " + pex);
            return null;
        }
    }

    /*
     * -------------------------------------------------------------------------
     * Retorna a data soma do tanto de dias desejado.
     */
    public static java.sql.Date getNextDate(java.sql.Date date, int n) {
        Calendar calendar = Calendar.getInstance(new Locale("pt", "PT"));
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, n);
        return new java.sql.Date(calendar.getTimeInMillis());
    }
    
    public static LocalDate getNextMonth(LocalDate date, int month, int day) {
    	LocalDate nextMonth = LocalDate.of(date.getYear(), date.getMonthValue(), day);    	
    	
        Calendar calendar = Calendar.getInstance(new Locale("pt", "PT"));
        calendar.setTime(Date.valueOf(nextMonth));
        calendar.add(Calendar.MONTH, month);
        return new java.sql.Date(calendar.getTimeInMillis()).toLocalDate();
    }

    public static int getDay() {
        return Utilities.parseInt(getFormat("dd").format(getDate()));
    }
    
    public static int getDay(java.sql.Date date) {
        return Utilities.parseInt(getFormat("dd").format(date));
    }

    public static int getMonth() {
        return Utilities.parseInt(getFormat("MM").format(getDate()));
    }
    
    public static int getMonth(java.sql.Date date) {
        return Utilities.parseInt(getFormat("MM").format(date));
    }

    public static int getYear() {
        return Utilities.parseInt(getFormat("yyyy").format(getDate()));
    }
    
    public static int getYear(java.sql.Date date) {
        return Utilities.parseInt(getFormat("yyyy").format(date));
    }

    private static SimpleDateFormat getFormat(String str) {
        return new SimpleDateFormat(str, new DateFormatSymbols(new Locale("pt", "PT")));
    }
}
