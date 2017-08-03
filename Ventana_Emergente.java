/**
 * ----. VENTANAS EMERGENTES DE TIPO CUADROS DE DIALOGO
 *--- Se abren cuando trabajamos con aplicaciones graficas, para informar al usuario sobre una incidencia, para pedir Informacion, etc

 *Los mt son los que construyen los distintos cuadros  de dialogo.
 * --- showInputDialog(),         muestra una ventana para introducir información.
 * --- showMessageDialog(Component parentComponent, Oject messaje),  muestra una ventana con la finalidad de , mostrar un mensaje, 
 *       el parámetro ‘Component parentComponent , es para indicarle quien es el , componente que va ha desencadenar la acción o el 
 *       lugar donde se desencadena Object messaje, es para indicarle un mensaje de tipo Object, o sea un String.
 * --- showConfirmDialog(),   muestra una ventana con diferentes botones, ‘aceptar, cancelar etc’
 * --- showOptionDialog(),      es un compendio o suma de las opciones anteriores.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * franciscoJavier
 */
public class Ventana_Emergente extends JFrame{

    public static void main(String[] args) {
        Ventana_Emergente marco = new Ventana_Emergente();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Ventana_Emergente() {

        Lamina_Cuadros_Dialogo lamina = new Lamina_Cuadros_Dialogo();
        add(lamina);

        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("JavaApplication57_Ventana_Emergente");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class Lamina_Cuadros_Dialogo extends JPanel {

        private JButton boton1, boton2, boton3, boton4;

        public Lamina_Cuadros_Dialogo() {
            boton1 = new JButton("Boton 1");
            boton2 = new JButton("Boton 2");
            boton3 = new JButton("Boton 3");
            boton4 = new JButton("Boton 4");;

            boton1.addActionListener(new AccionBotones());
            boton2.addActionListener(new AccionBotones());
            boton3.addActionListener(new AccionBotones());
            boton4.addActionListener(new AccionBotones());

            add(boton1);
            add(boton2);
            add(boton3);
            add(boton4);
        }

        private class AccionBotones implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton1) {
                    // ---------- ********    JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogo.this, "has pulsado el boton 1");
                    //showMessageDialog(Component parentComponent, Oject messaje),  muestra una ventana con la finalidad de,
                    //mostrar un mensaje, el parámetro 1º es para indicarle quien es el ,componente 
                    //que va ha desencadenar la acción. ,el parámetro 2º, es para indicarle un mensaje que da el botón un String.
                    // el 3º es para poner titulo a la ventana emergente. 4º para cambiar un icono que muestara la ventana al lado del mensaje
                    // 5º para poner un icono a la ventana.
                    // ---------- ********   utilizamos otro constructor.
                    JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogo.this, "has pulsado el boton 1", "Advertencia", 2);
                }
                else if (e.getSource() == boton2) {
                    JOptionPane.showInputDialog("Introduce orden");
                } 
                else if (e.getSource() == boton3) {
                    System.out.println("has pulsado el boton 3");
                } 
                else if (e.getSource() == boton4) {
                    System.out.println("has pulsado el boton 4");
                }
            }
        }
    }
}
