import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Disposicion_Muelle extends JFrame {

    public static void main(String[] args) {
        Disposicion_Muelle marco = new Disposicion_Muelle();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Disposicion_Muelle() {

        Muelle muelle = new Muelle();
        add(muelle);

        setBounds(150, 70, 700, 270);
        setVisible(true);
        setTitle("Cajas.");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }

    public class Muelle extends JPanel {

        public Muelle() {
             
            // ----CREAMOS LOS OBJETOS
            JButton boton1 = new JButton("Boton 1");
            JButton boton2 = new JButton("Boton 2");
            JButton boton3 = new JButton("Boton 2");
            // ---- DECIMOS A LA LAMINA EL TIPO DE DISPOSICION QUE TENDRA.
            SpringLayout layout = new SpringLayout();
            setLayout(layout);
            // ---- CREAMOS EL MUELLE
            Spring muelle = Spring.constant(0, 10, 100);
            // ---- ANADIMOS LOS BOTONES A LA LAMINA
            add(boton1);
            add(boton2);
            add(boton3);
            // ---- COLOCAMOS MUELLES ENTRE LOS OBJETOS ANADIDOS A LA LAMINA CON EL MT, 'putConstraint(......)'.
            layout.putConstraint(SpringLayout.WEST, boton1, muelle, SpringLayout.WEST, this);
            // --- SpringLayout.WEST -> zona del objeto donde empieza el muelle.
            // --- boton1 -> objeto en el que empieza el muelle.
            // --- muelle -> objeto muelle.
            // --- SpringLayout.WEST -> zona del objeto donde termina  el muelle.
            // --- this -> objeto en el que termina el muelle.
            layout.putConstraint(SpringLayout.WEST, boton2, muelle, SpringLayout.EAST, boton1);
            layout.putConstraint(SpringLayout.WEST, boton3, muelle, SpringLayout.EAST, boton2);
            layout.putConstraint(SpringLayout.EAST, this, muelle, SpringLayout.EAST, boton3);
        }
    }
}
