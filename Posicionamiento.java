import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Posicionamiento extends JFrame{
  JLabel latitud = new JLabel("Latitud");
  JLabel longitud = new JLabel("Longitud");
  JTextField latitudTxt = new JTextField(10);
  JTextField longitudTxt = new JTextField(10);
  JLabel error1 = new JLabel(" ");
  JLabel error2 = new JLabel(" ");
  JButton validar = new JButton("Validar");

  public Posicionamiento(){
    super("Validar Latitud y longitud");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    //Agregar los componentes
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    add(latitud,gbc);

    gbc.gridx = 2;
    add(latitudTxt,gbc);

    gbc.gridy = 1;
    gbc.gridx = 1;
    add(error1,gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    add(longitud,gbc);

    gbc.gridx = 2;
    add(longitudTxt,gbc);

    gbc.gridy = 3;
    gbc.gridx = 1;
    add(error2,gbc);

    gbc.gridy = 4;
    gbc.gridx = 2;
    add(validar,gbc);

    //Agregar los listener
    FocusListener fl = new FocusAdapter(){
      @Override
      public void focusGained(FocusEvent e){}
      public void focusLost(FocusEvent e){
        Object x = e.getSource();
        validaSintaxis(x);
      }
    };
    latitudTxt.addFocusListener(fl);
    longitudTxt.addFocusListener(fl);

    validar.addActionListener(e -> validar());

    pack();
    setVisible(true);
  }

  private void validar(){
    JOptionPane.showMessageDialog(null,"AWEBO");
  }

  private void validaSintaxis(Object x){
    if(x == error1){

    }else{

    }
  }

  public static void main(String[] args) {
    new Posicionamiento();
  }
}
