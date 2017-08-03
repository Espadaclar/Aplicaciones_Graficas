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
           // --- PARA QUE UTILICE NUESTRA PROPIA DISPOSICION LIBRE LE PASO COMO PARAMETRO NUESTRA CLASE ' EnColumnas'..
            // -- es lo mismo que asignarle una de las disposiciones que ofrece la api de java
            setLayout(new EnColumnas());

            JButton boton1 = new JButton("Boton 1");
            JLabel a = new JLabel(" ");
            JButton boton2 = new JButton("Boton 2");
            JLabel b = new JLabel(" ");
            JButton boton3 = new JButton("Boton 2");
            JLabel c = new JLabel(" ");

            JLabel nombre = new JLabel("Nombre");
            JLabel apellido = new JLabel("Apellido");
            JTextField c_nombre = new JTextField();
            JTextField c_apellido = new JTextField();

            add(nombre);// --- orden en que apareceran en la interface.
            add(c_nombre);
            add(apellido);
            add(c_apellido);
            add(boton1);
            add(a);
            add(boton2);
            add(b);
            add(boton3);
            add(c);
        }
    }
}

/**
 * OBJETIVO¡¡¡ Crear una clase propia que cree una disposición de mí gusto,
 * --esta clase va ha colocar elementos por parejas, al lado izquierdo de la
 * lamina, perfectamente alineados.
 */
class EnColumnas implements LayoutManager {

    // --- coordenadas para colocar el primer elemento.
    private int x;
    private int y = 20;

    @Override
    public void addLayoutComponent(String name, Component comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void layoutContainer(Container miContenedor) {
        //este mt obtine los datos de los componentes que contenga la lamina a la que la asignemos la disposicion que estamos creando
        int cont = 0; // --> variable para almacenar el componente en el se encuentra un bucle.
        int numElementos = miContenedor.getComponentCount(); // --> almacena el nº de elementos que tiene la lamina o el contenedor.
        int d = miContenedor.getWidth();// -- obtiene el ancho del contenedor.
        x = d/2;
        // --> formamos un bucle que de tantas vueltas como elementos tiene el contenedor.
        for(int i = 0; i < numElementos; i ++){
            cont ++;
            // --> aplicamos el mt '‘getComponent(int i)’ que devuelve el componente que le indiquemos con un nº entero
            // para ello tenemos que almacenarlo en una variable de tipo 'Component'.
            Component comp = miContenedor.getComponent(i);

            // RECORDEMOS¡¡¡ los componentes no estan colocados aun, les ponemos las coordenadas.
            comp.setBounds(x -100, y, 100, 20); // ----estas son las coordenadas para el componente 'i'.

            x += 100; // -- aumentamos la coordenada 'x' para colocar el 2 componente, a la misma altura que el 1º.
            // -- al ser una colocación en parejas, los elementos impares cambian la coordenada 'y'. luengo

            if(cont % 2 == 0){
                x = d/2;
                y += 40; 
            }            
        }
    }
}
