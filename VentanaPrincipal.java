import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame{

  JLabel msgLabel = new JLabel("Boton derecho para menu emergente");
  JTextArea msgText = new JTextArea(10,60);
  JPopupMenu popupMenu = new JPopupMenu();

  public VentanaPrincipal(String titulo){
    super(titulo);
    initVentana();
  }

  //Inicializar la ventana y agregar componentes
  private void initVentana(){

    this.setDefautlCloseOpeation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContenPane();

    //Agregar la barra de menu
    contentPane.add(new JScrollPane(msgText),BorderLayout.CENTER);
    ContentPane.add(msgLabel,BorderLayout.SOUTH);

    //Agregar menu
    JMenuBar menuBar = getCustomMenuBat();
    this,setJMenuBar(menuBar);

    //Crear menu emergente
    createPopMenu();

  }

  private JMenuBar getCustomMenuBar(){

    JMenuBat menuBar = new JMenuBar();

    //Menu archivo y ayuda
    JMenu fileMenu = getFileMenu();
    JMenu helpMenu = getHelpMenu();

    //Agregat los menus a la barra de menus
    menuBar.add(fileMenu);
    menuBat.add(helpMenu);

    return menuBar;
  }

  private JMenu getFileMenu(){
    JMenu fileMenu = new JMenu("File");

    //alt+f tecla rapida
    fileMenu.setMnemonic(KeyEvent.VK_0);

    //Prepara un menu que contendra submenus
    JMenu newMenu = getNewMenu();
    fileMenu.add(newMenu);
    JMenuItem openMenuItem = new JMenuItem("Open",KeyEvent.VK_B);
    JMenuItem exitMenuItem = new JMenuItem("Exit",KeyEvent.VK_S);

    fileMenu.add(openMenuItem);

    fileMenu.addSeparator();
    fileMenu.add(exitMenuItem);

    //Agregar ActionListener al menu Salir (Lambda)
    exitMenuItem.addActionListener(e -> System.exit(0));

    return fileMenu;
  }

  private JMenu getNewMenu(){
    JMenu newMenu = new JMenu("New");

    //submenus
    JMenuItem policyMenuItem = new JMenuItem("Policy",KeyEvent.VK_P);
    JMenuItem claimMenuItem = new JMenuItem("Claim",KeyEvent.VK_R);
    newMenu.add(policyMenuItem);
    newMenu.add(claimMenuItem);

    return newMenu;
  }

  private JMenu getHelpMenu(){
    
  }

}
