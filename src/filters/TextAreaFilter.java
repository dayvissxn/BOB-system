package filters;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class TextAreaFilter extends DocumentFilter {

    private final int maxCharacters;
    private final int maxRows;
    private int rowcount;

    public TextAreaFilter(int maxChars,int maxrows) {
        maxCharacters = maxChars;
        maxRows = maxrows;
        rowcount = 0;
    }
    
    private int Occurrences(String s){
        int count=0;
        int size=s.length();
        for (int i=0;i<size;i++){
            if (s.charAt(i)=='\n')
                count++;
        }
        return count;
    }
    
    private boolean Insert(String text, int offs, String str){
        int cont=0, i=offs-1;
        while (i>=0&&text.charAt(i--)!='\n')cont++;
        for (i=0;i<str.length();i++){
            if (str.charAt(i)=='\n') cont=0;
            else cont++;
            if (cont>maxCharacters)return false;
        }
        i=offs;
        while (i<text.length()&&text.charAt(i++)!='\n')cont++;
        return cont <= maxCharacters;
    }

    @Override
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
            throws BadLocationException {
        int size = fb.getDocument().getLength();
        int max = offs+maxCharacters>size?size:offs+maxCharacters;
        int min = offs-maxCharacters<0?0:offs-maxCharacters;
        int row = Occurrences(str);
        if (Insert(fb.getDocument().getText(min, max-min),offs-min,str)&&
                rowcount+row<maxRows){
            rowcount+=row;
            super.insertString(fb, offs, str, a);
        }
        else{
            Toolkit.getDefaultToolkit().beep();
        }
    }
        
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws
            BadLocationException {
        rowcount-=Occurrences(fb.getDocument().getText(offset, length));
        super.remove(fb, offset, length);
    }

    @Override
    public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)
            throws BadLocationException {
        int size = fb.getDocument().getLength();
        int dep = offs+length;
        int max = dep+maxCharacters>size?size:dep+maxCharacters;
        int min = offs-maxCharacters<0?0:offs-maxCharacters;
        int row = Occurrences(str)-Occurrences(fb.getDocument().getText(offs, length));
        if (rowcount+row<maxRows&&Insert(fb.getDocument().getText(min, offs-min)+
                fb.getDocument().getText(dep, max-dep),offs-min,str)){
            rowcount+=row;
            super.replace(fb, offs, length, str, a);
        }
        else{
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
