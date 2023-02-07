package screens;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import projetoboot.Annotation;
import projetoboot.Functions;

public class ResultsTableModel extends AbstractTableModel {

    private final int COLUMNTITLE = 0;
    private final int COLUMNTAGS = 1;
    private final int COLUMNCREATION = 2;
    private final int COLUMNUPDATE = 3;

    private final String[] columnNames = {"Título", "Tags", "Data de Criação", 
        "Data de modificação"};

    private List<Annotation> annotations;
    private final SimpleDateFormat dateformat;

    public ResultsTableModel() {
        dateformat = new SimpleDateFormat(Functions.getDateFormat());
        annotations = new ArrayList();
    }

    public void ResetContent() {
        int length = annotations.size();
        annotations.clear();
        if (length>0)fireTableRowsDeleted(0, length-1);
        
    }

    public void setRows(List<Annotation> annotations) {
        if (annotations==null){
            return;
        }
        this.annotations = annotations;
        if (!annotations.isEmpty()){
            fireTableRowsInserted(0, annotations.size() - 1);
        }
    }

    public void removeRows(int[] indexes) {
        for (int i = indexes.length - 1; i >= 0; i--) {
            removeRow(indexes[i]);
        }
    }
    
    public void removeRow(int row) {
        annotations.remove(row);
        fireTableRowsDeleted(row, row);
    }

    @Override
    public int getRowCount() {
        return annotations.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (annotations.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Annotation an = annotations.get(rowIndex);
        Object returnvalue = null;
        switch (columnIndex) {
            case COLUMNTITLE:
                returnvalue = an.getTitle();
                break;
            case COLUMNTAGS:
                returnvalue = Functions.SetToString(an.getMetatag());
                break;
            case COLUMNCREATION:
                returnvalue = dateformat.format(an.getCreation());
                break;
            case COLUMNUPDATE:
                returnvalue = dateformat.format(an.getLastmodification());
                break;
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
        return returnvalue;
    }
    
    public Annotation getValueAt(int row){
        if (row<0||row>=annotations.size()){
            throw new IllegalArgumentException("Invalid column index");
        }
        return annotations.get(row);
    }

}
