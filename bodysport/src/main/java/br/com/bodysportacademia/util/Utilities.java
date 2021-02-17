/**
 * @(#) Utilities.java 1.0 27/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * @version 1.0 27/01/2021
 * @author Pietro do Nascimento
 */
public class Utilities {
	
    public Utilities() {
    }

    /**
     */
    public static int parseInt(String value) {
        try {
            if (value != null && !value.equals("")) {
                return Integer.parseInt(value);
            }
            return -1;
        } catch (NumberFormatException nfex) {
            System.err.println("Utilities -> parseInt: " + nfex);
            return -1;
        }
    }

    public static float parseFloat(String value) {
        try {
            if (value != null && !value.equals("")) {
                return Float.parseFloat(value.replace("R$ ", "").replace(",", "."));
            }
            return -1;
        } catch (NumberFormatException nfex) {
            System.err.println("Utilities -> parseFloat: " + nfex);
            return -1;
        }
    }

    public static double parseDouble(String value) {
        try {
            if (value != null && !value.equals("")) {
                return Double.parseDouble(value.replace("R$ ", "").replace(",", "."));
            }
            return -1;
        } catch (NumberFormatException nfex) {
            System.err.println("Utilities -> parseDouble: " + nfex);
            return -1;
        }
    }

    /**
     */
    public static String formatNumber(float value) {
        return getDecimalFormat("#0.00").format(value);
    }

    public static String formatNumber(String str, float value) {
        return getDecimalFormat(str).format(value);
    }

    public static String formatNumber(double value) {
        return getDecimalFormat("#0.00").format(value);
    }

    public static String formatNumber(String str, double value) {
        return getDecimalFormat(str).format(value);
    }

    private static DecimalFormat getDecimalFormat(String str) {
        return new DecimalFormat(str, new DecimalFormatSymbols(new Locale("pt", "PT")));
    }

    /**
     */
    public static String formatCPF(String str) {
        str = str.replace(" ", "").replace(",", "").replace(".", "").replace("-", "");
        return str.trim();
    }

    public static String formatCNPJ(String str) {
        str = str.replace(" ", "").replace(",", "").replace("/", "").replace(".", "").replace("-", "");
        return str.trim();
    }

    public static String formatMS(String str) {
        str = str.replace(".", "").replace(",", "").replace("-", "").replace("/", "");
        return str.trim();
    }
    
    /**
     * ler o número contido em uma palavra
     */
    public static String readNumber(String str) {
        String s = "";
        for (char c : str.toCharArray()) {
            if (Utilities.parseInt("" + c) != -1) {
                s += c; 
            }
        } 
        return s;
    }
}
