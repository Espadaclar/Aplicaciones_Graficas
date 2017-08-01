import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * Crea una caja para almacenar elementos en posicion vertical. Los elementos
 * que contendrá seran cajas. Estas cajas a su vez contendran elementos en
 * posición horizontal.
 *
 * franciscoJavier
 */
public class Disposicion_Box extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Disposicion_Box marco = new Disposicion_Box();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Disposicion_Box() {

        Caja caja = new Caja();
        add(caja);

        setBounds(150, 70, 200, 200);
        setVisible(true);
        setTitle("Cajas.");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class Caja extends JPanel {

        public Caja() {

            //DADO QUE 'createVerticalBox()' DEVUELVE UN 'BOX' LO ALMACENAMOS EN UNA V.L Y YA TENEMOS LA CAJA.
            Box cajaBase = Box.createVerticalBox();//--------------- CREAMOS LA CAJA BASSE.
            add(cajaBase);   
            
            JLabel rotulo = new JLabel("Nombre");// ---------------etiqueta para la 1º caja.
            JTextField texto1 = new JTextField(10);// -------------cuadro de texto para la 1º caja.
            texto1.setMaximumSize(texto1.getPreferredSize());//--- para evitar problemas si redimensionamos el marco.

            JLabel rotulo2 = new JLabel("Pasword");// ---------------etiqueta para la 2º caja.
            JPasswordField pasword = new JPasswordField(10);// -------------cuadro de texto para la 2º caja.
            pasword.setMaximumSize(pasword.getPreferredSize());//--- para evitar problemas si redimensionamos el marco.

            Box caja1 = Box.createHorizontalBox();//---------------- 1º caja.
            caja1.add(rotulo);
            caja1.add(Box.createHorizontalStrut(10));  // ----- pone separacion de 10 px entre los objetos de la caja.
            caja1.add(texto1);
                      
            Box caja2 = Box.createHorizontalBox();//---------------- 2º caja.
            caja2.add(rotulo2);
            caja2.add(Box.createHorizontalStrut(10));
            caja2.add(pasword);
    
            JButton boton1 = new JButton();
            JButton boton2 = new JButton();
            
            Box caja3 = Box.createHorizontalBox();//---------------- 3º caja.
            caja3.add(boton1);
            caja3.add(Box.createGlue());
            caja3.add(boton2);
            

            cajaBase.add(caja1);
            cajaBase.add(caja2);
            cajaBase.add(caja3);
            
        }
    }
}
