package scislak.program;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class WebPageFrame extends JFrame{
    private static JTextArea area;
    
    public WebPageFrame(String title, String document){
        super(title);
        setVisible(true);
        init();
        addInside();
        setDocument(document);
    }
    
    private void init(){
        setSize(600, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    private void addInside(){
        area = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        area.setLineWrap(true);
        area.setEditable(false);
        area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 11));
        add(scrollPane);
        validate();
    }
    
    public void setDocument(String text){
        area.setText(text);
    }
    
    public static String getDocument(){
        return area.getText();
    }
}
