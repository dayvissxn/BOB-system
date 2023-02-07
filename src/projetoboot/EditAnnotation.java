package projetoboot;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import screens.MainFrame;
public class EditAnnotation {
    
    private Vector<Annotation> allannotations;
    
    // Construtor: Lê todos os arquivos contidos na mesma pasta do projeto
    public EditAnnotation() throws Exception{
        Annotation annot;
        allannotations = new Vector<>();
        FilenameFilter filter = new FilenameFilter() {
          public boolean accept(File dir, String name) {
             return name.endsWith(".txt");             
          }
        }; 
        //Localização dos arquivos
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles(filter);
        FileReader reader;
        File file;
        for (int i = 0; i < listOfFiles.length; i++) {            
            annot = new Annotation();
            file = listOfFiles[i];            
            reader = null;
            try {                
                reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                annot.setFile(br.readLine());
                annot.setTitle(br.readLine());        
                String tag = br.readLine();
                String[] tags; 
                tags = tag.split(" ");
                Set<String> meta = new HashSet<String>(Arrays.asList(tags));
                annot.setMetatag(meta);                     
                SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                Date creation = null;
                try {
                    creation = format.parse(br.readLine());
                } catch (ParseException ex) {
                    System.out.println("Error 1");
                    //Logger.getLogger(EditAnnotation.class.getName()).log(Level.SEVERE, null, ex);
                }
                annot.setCreation(creation);
                Date lastmodification = null;
                try {
                    lastmodification = format.parse(br.readLine());
                } catch (ParseException ex) {
                    System.out.println("Error 2");
                    //Logger.getLogger(EditAnnotation.class.getName()).log(Level.SEVERE, null, ex);
                }  
                annot.setLastmodification(lastmodification);
                String text = "";
                int c = br.read();                
                while (c != -1){
                    text = text + (char)c;
                    c = br.read();
                }
                annot.setText(text);  
                allannotations.addElement(annot);                                                          
                
                reader.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error 3");
               // Logger.getLogger(EditAnnotation.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }
    }
    //cria um .txt de an e adiciona an ao vetor allannotations
    public void Create(Annotation an){
        an.getMetatag().remove("");
        
     //   System.out.println(allannotations.firstElement().getTitle());
        int i;
        String filename;
        //verificar o proximo arquivo a ser criado
        for(i = 1; ; i++) {            
            filename = i + ".txt";
            try {
                FileInputStream teste = new FileInputStream(filename);
                try {
                    teste.close();
                } catch (IOException ex) {
                 //   Logger.getLogger(EditingFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                break;
            }
        }        
        filename = i + ".txt";
        OutputStream os = null;
        try {
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
        }
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw); 
        try {
            //nome do .txt
            bw.write(filename);
            bw.newLine();
            //segunda linha titulo, terceira tags, quarta data inicial e quinta data de modificaçao
            bw.write(an.getTitle());
            bw.newLine();
            bw.write(Functions.SetToString(an.getMetatag()));   
            bw.newLine();
            bw.write(an.getCreation().toString());            
            bw.newLine();
            bw.write(an.getLastmodification().toString());
            bw.newLine();
            //ultima linha: conteúdo da anotação
            bw.write(an.getText());                        
        } catch (IOException ex) {
        }
        
        
        try {
            bw.close();
        } catch (IOException ex) {
        }
        
        an.setFile(filename);
        allannotations.add(an);
    }
    //an: anotação editada cujo arquivo corresponde deve ser alterado
    public void Edit(Annotation an){
        String filename;
        filename = an.getFile();
        File file = new File(filename);        
        file.delete();
                  
        OutputStream os = null;
        try {
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw); 
        try {
            //nome do .txt
            bw.write(filename);
            bw.newLine();
            //segunda linha titulo, terceira tags, quarta data inicial e quinta data de modificaçao
            bw.write(an.getTitle());
            bw.newLine();
            bw.write(Functions.SetToString(an.getMetatag()));            
            bw.newLine();
            bw.write(an.getCreation().toString());                  
            bw.newLine();
            bw.write(an.getLastmodification().toString());
            bw.newLine();
            //ultima linha: conteúdo da anotação
            bw.write(an.getText());                        
        } catch (IOException ex) {
        }
        
        try {
            bw.close();
        } catch (IOException ex) {
        }        
        
    }
    //deleta um arquivo, deletando o .txt e removendo o annotation do vetor
    //An: annotation a ser removido
    public void Delete(Annotation an){
        allannotations.remove(an);
        File file = new File(an.getFile());
        file.delete();      
    }
    
    public Vector<Annotation> getAnnotations(){
        return allannotations;
    }
}
