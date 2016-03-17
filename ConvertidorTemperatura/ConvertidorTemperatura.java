import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConvertidorTemperatura extends JFrame implements KeyListener,ActionListener {

  JLabel cel = new JLabel("Celcius");
  JLabel far = new JLabel("Farhenheit");
  JTextField celTxt = new JTextField(5);
  JTextField farTxt = new JTextField(5);
  JButton farBtn = new JButton("Farhenheit");
  JButton celBtn = new JButton("Celcius");

  public ConvertidorTemperatura(){

    super("Convertidor de temperatura");
    Container cont = getContentPane();
    cont.setLayout(new GridLayout(2,3,5,5));
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    //Agregar a la ventana los componentes
    cont.add(cel);
    cont.add(celTxt);
    cont.add(farBtn);
    cont.add(far);
    cont.add(farTxt);
    cont.add(celBtn);

    //Agregar los listener a los componentes
    celTxt.addKeyListener(this);
    farTxt.addKeyListener(this);
    celBtn.addActionListener(this);
    farBtn.addActionListener(this);

    pack();
    setVisible(true);

  }

  public float convierteACelcius(float x){
    return (x-32)*5/9;
  }

  public float convierteAFarhenheit(float x){
    return (x*9/5)+32;
  }


  @Override
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == farBtn){
      farTxt.setText(""+ convierteAFarhenheit(Float.parseFloat(celTxt.getText())));
    }
    if(e.getSource() == celBtn){
      celTxt.setText(""+ convierteACelcius(Float.parseFloat(farTxt.getText())));
    }
  }
  public void keyPressed(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_ENTER){
      if(e.getSource() == celTxt){
        farTxt.setText(""+ convierteAFarhenheit(Float.parseFloat(celTxt.getText())));
      }
      if(e.getSource() == farTxt){
        celTxt.setText(""+ convierteACelcius(Float.parseFloat(farTxt.getText())));
      }
    }
  }
  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}

  public static void main(String[] args) {
    new ConvertidorTemperatura();
  }

}
