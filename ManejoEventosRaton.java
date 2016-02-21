import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ManejoEventosRaton extends JFrame{

  JButton mouseButton = new JButton("Sin eventos de movimiento aun");

  public ManejoEventosRaton(){

    super("Manejo de enventos del raton");
    this.initFrame();

  }

  private void initFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.getContentPane().add(mouseButton);

    //agregar un MouseListner al JButton
    mouseButton.addMouseListener(
      new MouseListener(){
        @Override
        public void mouseClicked (MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){
          mouseButton.setText("Entrando al boton!!");
        }
        public void mouseExited(MouseEvent e){
          mouseButton.setText("Saliendo del boton :(");
        }
      }
      );

  }

  public static void main(String[] args) {
    ManejoEventosRaton frame = new ManejoEventosRaton();
    frame.pack();
    frame.setVisible(true);
  }

}
