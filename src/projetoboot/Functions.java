package projetoboot;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Set;

public class Functions {
    
    // Exibe os elementos de um set de strings separados por vírgula
    public static String SetToString(Set<String> set) {
        String ret = "";
        boolean first = true;
        for (String s : set) {            
            if (!first) {
                ret += " ";
            }
            ret += s;
            first = false;
        }
        return ret;
    }
    
    // Verifica o array "calendar" é uma data válida
    // calendar[0] = ano, calendar[1]=mês, calendar[2] = dia
    public static boolean CheckDateIsValid(int[] calendar) {
        boolean ret;
        try {
            LocalDate.of(calendar[0] > 0 ? calendar[0] : 2016, calendar[1] > 0
                    ? calendar[1] : 12, calendar[2] > 0 ? calendar[2] : 1);
            ret = true;
        } catch (DateTimeException e) {
            ret = false;
        }
        return ret;
    }
    
    // Retorna um formato padronizado de representação de data
    public static String getDateFormat(){
        return "dd/MM/yyyy - HH:mm:ss";
    }
    
    // Converte a data em um formato usado para comparação
    public static String convertDate(String date){
        String[] values = date.substring(0,10).split("/");
        String newdate = "";
        for (int i=values.length-1;i>=0;i--){
            newdate+=values[i];
        }
        newdate+=date.substring(13);
        return newdate;
    }
}

