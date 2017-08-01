import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * franciscoJavier
 */
public class Disposicion_Libre extends JFrame {

    public static void main(String[] args) {
        Disposicion_Libre marco = new Disposicion_Libre();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Disposicion_Libre() {

        Laminalibre lamina = new Laminalibre();
        add(lamina);

        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("Laminalibre");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class Laminalibre extends JPanel {

        public Laminalibre() {
            // --- PARA HACER UNA DISPOSICION LIBRE LO 1º ES ANULAR EL Layout.
            setLayout(null);
            
            JButton boton1 = new JButton("Boton 1");
            JButton boton2 = new JButton("Boton 2");
            JButton boton3 = new JButton("Boton 2");
            // --- PONEMOS LAS COORDENADAS Y EL TAMANO A LOS ELEMENTOS.
            boton1.setBounds(50, 50, 100, 20);
            boton2.setBounds(50, 80, 100, 20);
            boton3.setBounds(50, 110, 100, 20);
            
            add(boton1);
            add(boton2);
            add(boton3);
        }
    }
}