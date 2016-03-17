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

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContentPane();

    //Agregar la barra de menu
    contentPane.add(new JScrollPane(msgText),BorderLayout.CENTER);
    contentPane.add(msgLabel,BorderLayout.SOUTH);

    //Agregar menu
    JMenuBar menuBar = getCustomMenuBar();
    this.setJMenuBar(menuBar);

    //Crear menu emergente
    createPopupMenu();

  }

  private JMenuBar getCustomMenuBar(){

    JMenuBar menuBar = new JMenuBar();

    //Menu archivo y ayuda
    JMenu fileMenu = getFileMenu();
    JMenu helpMenu = getHelpMenu();

    //Agregat los menus a la barra de menus
    menuBar.add(fileMenu);
    menuBar.add(helpMenu);

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
    JMenu helpMenu = new JMenu("Help");
    helpMenu.setMnemonic(KeyEvent.VK_Y);

    JMenuItem indexMenuItem = new JMenuItem("Index",KeyEvent.VK_I);
    JMenuItem aboutMenuItem = new JMenuItem("About",KeyEvent.VK_C);

    //Selecciona la tecla F1 para el menu indexMenuIndex
    KeyStroke f1Key = KeyStroke.getKeyStroke(KeyEvent.VK_F1,0);
    indexMenuItem.setAccelerator(f1Key);

    helpMenu.add(indexMenuItem);
    helpMenu.addSeparator();
    helpMenu.add(aboutMenuItem);

    //Agregar actionListener a index Lambda
    indexMenuItem.addActionListener(e -> msgText.append("Has seleccionado help >> menu Index,\n"));
    return helpMenu;
  }

  private void  createPopupMenu(){
    //Crea enu emergente y agrega mouse listener al frame
    //para que se uestre el menu emergente cuando el usuario hace click derecho
    JMenuItem popup1 = new JMenuItem("Menu emergente 1");
    JMenuItem popup2 = new JMenuItem("Menu emergente 2");
    JMenuItem popup3 = new JMenuItem("Menu emergente 3");

    //Crear un actionListener
    ActionListener al = e -> {
      JMenuItem menuItem = (JMenuItem)e.getSource();
      String menuText = menuItem.getText();
      String msg  = "Haz seleccionado "+ menuText +" .\n";
      msgText.append(msg);
    };


    //Agregar el mismo action listener a los menus popup
    popup1.addActionListener(al);
    popup2.addActionListener(al);
    popup3.addActionListener(al);

    //Agrega los elementos al popup
    popupMenu.add(popup1);
    popupMenu.add(popup2);
    popupMenu.add(popup3);

    //Crear MouseListener para mostrar el menu emergente
    MouseListener ml = new MouseAdapter(){
      @Override
      public void vemousePressed(MouseEvent e){
        displayPopupMenu(e);
      }
      public void mouseReleased(MouseEvent e){
        displayPopupMenu(e);
      }
    };

    //Aagregar MouseListener al label y al textArea
    msgText.addMouseListener(ml);    msgLabel.addMouseListener(ml);
  }

  private void displayPopupMenu(MouseEvent e){
    //Aseurasrse que se miestra el popupMenu
    if(e.isPopupTrigger()) this.popupMenu.show(e.getComponent(),e.getX(),e.getY());
  }

  //mostrar Ventana
  public static void main(String[] args) {
    VentanaPrincipal vPrincipal = new VentanaPrincipal("Ventana Principal");
    vPrincipal.pack();
    vPrincipal.setVisible(true);
  }
}
