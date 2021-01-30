import javax.swing.JFileChooser;

public class OpenFile {
    JFileChooser fileChooser = new JFileChooser();
    StringBuilder sb = new StringBuilder();
    
    public String pickMe() throws Exception{
        
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileChooser.getSelectedFile();
            return file.getPath();
            
        }
        else { 
            return null;
        }
    }

}
