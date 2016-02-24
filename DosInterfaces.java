import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DosInterfaces extends JFrame implements MouseMotionListener, MouseListener {

  JTextField tf = new JTextField(30);
  JLabel label = new JLabel("Click y arrasta el boton");

  public DosInterfaces(){ super("Dos Interfaces");}

  public void abreMarco(){

    Container cont = getContentPane();
    cont.add(label,BorderLayout.NORTH);
    cont.add(tf,BorderLayout.SOUTH);

    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(300,200);
    this.setVisible(true);

  }

  @Override
  public void mouseDragged(MouseEvent e){
    String s = "Arastrando  raton: X = "+ e.getX() + "Y = " + e.getY();
    tf.setText(s);
  }
  public void mouseEntered(MouseEvent e){
    String s = "¡El raton ha entrado!";
    tf.setText(s);
  }
  public void mouseExited(MouseEvent e){
    String s = "El raton ha salido";
    tf.setText(s);
  }
  public void mouseMoved(MouseEvent e){}
  public void mousePressed(MouseEvent e){}
  public void mouseClicked(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}

  public static void main(String[] args) {
    DosInterfaces di = new DosInterfaces();
    di.abreMarco();
  }

}
