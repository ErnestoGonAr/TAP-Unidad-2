import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SeleccionaFramework extends JFrame implements ItemListener{

  String[] frameworks = {"(Selecciona Framework)","YII","Cake PHP","Zend", "Akelos"};

  String[] descripciones = {"The Fast, secure and proesional PHP framework",
  "Cake PHP makes building web applications simpler, faster and ",
  "The most popular framework for modern, high-erforming PHP applications",
  "Akelos PHP framework"};
  JComboBox<String> frameBox = new JComboBox<>(frameworks);
  JLabel descriptionLabel = new JLabel();

  public SeleccionaFramework(){
    super("Selecciona framework de PHP");

    setSize(420,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cont = getContentPane();

    frameBox.addItemListener(this);
    cont.add(frameBox,BorderLayout.NORTH);
    cont.add(descriptionLabel,BorderLayout.CENTER);
    setVisible(true);

  }

  @Override
  public void itemStateChanged(ItemEvent e){
    int choice = frameBox.getSelectedIndex();
    if(choice > 0)descriptionLabel.setText(descripciones[choice - 1]);
    else descriptionLabel.setText("");
  }
  public Insets getInsets(){
    return new Insets(50,50,50,50);
  }

  public static void main(String[] args) {
    new SeleccionaFramework();
  }

}
