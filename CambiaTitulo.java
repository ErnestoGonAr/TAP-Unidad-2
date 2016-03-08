import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CambiaTitulo extends JFrame implements ActionListener {

  JButton b1 = new JButton("Dr. House");
  JButton b2 = new JButton("Smallville");

  public CambiaTitulo(){

    super("Barra de titulo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    b1.addActionListener(this);
    b2.addActionListener(this);

    FlowLayout fl = new FlowLayout();
    Container cont = getContentPane();
    cont.setLayout(fl);

    cont.add(b1);
    cont.add(b2);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e){

    Object source = e.getSource();

    if(source == b1){
      this.setTitle("Dr. House");
    }else if(source == b2){
      this.setTitle("Smallville");
    }
    this.repaint();

  }

  public static void main(String[] args) {
    new CambiaTitulo();
  }

}
