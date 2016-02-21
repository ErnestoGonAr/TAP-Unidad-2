import java.awt.event.*;
import javax.swing.JOptionPane;

public class ClaseManejadora implements ActionListener  {

  public void actionPerformed(ActionEvent evt){

    JOptionPane.showMessageDialog(null,"El comando es \""+ evt.getActionCommand()+"\"");

  }

}
