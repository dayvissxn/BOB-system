package projetoboot;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Set;

public class Search {

    private Vector<Annotation> allan;
    private final SimpleDateFormat dateformat;

    public Search(Vector<Annotation> allan) {
        this.allan = allan;
        dateformat = new SimpleDateFormat("yyyy MM dd");
    }

    private boolean StringMatch(String s1, String s2) {
        boolean ret = false;
        if (s1.toLowerCase().contains(s2.toLowerCase())) {
            ret = true;
        }
        return ret;
    }

    private boolean DateMatch(Date d, int[] searchdate) {
        Integer calendar[];
        boolean ret = true;
        String[] stringcalendar = dateformat.format(d).split(" ");
        calendar = new Integer[stringcalendar.length];
        for (int i = 0; i < stringcalendar.length; i++) {
            calendar[i] = Integer.parseInt(stringcalendar[i]);
        }

        for (int i = 0; ret && i < calendar.length; i++) {
            ret = ret & (calendar[i] == searchdate[i] | searchdate[i] == 0);
        }
        return ret;
    }

    public ArrayList<Annotation> Search(String name, Set<String> tags, int[] datecreation, int[] lastupdate,
            Annotation.SortCriteria sortcriteria) {
        ArrayList<Annotation> results = new ArrayList<>();

        tags.remove("");
        
        for (Annotation a : allan) {
            boolean isamatch;
            isamatch = StringMatch(a.getTitle(), name) & a.getMetatag().
                    containsAll(tags) & DateMatch(a.getCreation(), datecreation)
                    & DateMatch(a.getLastmodification(), lastupdate);
            if (isamatch) {
                results.add(a);
            }
        }
        if (sortcriteria == Annotation.SortCriteria.TITLE) {
            results.sort(Annotation.NameComparison);
        } else if (sortcriteria == Annotation.SortCriteria.CREATION) {
            results.sort(Annotation.CreationComparison);
        } else if (sortcriteria == Annotation.SortCriteria.LASTMODIFICATION) {
            results.sort(Annotation.UpdateComparison);
        }
        return results;
    }
}
