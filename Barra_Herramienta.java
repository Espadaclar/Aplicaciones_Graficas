import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * franciscoJavier
 */
public class Barra_Herramienta extends JFrame
{
    public static void main(String[] args) {
        Barra_Herramienta marco = new Barra_Herramienta();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public Barra_Herramienta() {
        
        Lamina lamina = new Lamina();
        add(lamina);
        
        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("Menu_&&_Barra_Herramientas");
        
        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);
    }
    
    public class Lamina extends JPanel {
    
        private JButton azul;
        private JButton amarillo;
        private JButton rojo;
        private JButton cerrar;

        private JButton boton;
        private JToolBar barra;

        private JMenuBar barraMenu;
        // private JMenuItem item;
        private JMenu menu;

        public Lamina() {
            setLayout(new GridLayout(15, 1));

            barraMenu = new JMenuBar();
            barra = new JToolBar();
            menu = new JMenu(("Color"));

            FlowLayout laminaMenu = new FlowLayout(FlowLayout.LEFT);
            barraMenu.setLayout(laminaMenu);

            AccionColor accion_azul = new AccionColor("Azul", new ImageIcon("../iconos/azul.gif"), Color.BLUE);
            AccionColor accion_amarillo = new AccionColor("Amarillo", new ImageIcon("../iconos/amarillo.gif"), Color.YELLOW);
            AccionColor accion_rojo = new AccionColor("Rojo", new ImageIcon("../iconos/rojo.gif"), Color.RED);

            AccionColor accion_cerrar = new AccionColor("Cerrar", new ImageIcon("../iconos/cerrar.gif"), Color.WHITE);

            azul = new JButton(accion_azul);
            amarillo = new JButton(accion_amarillo);
            rojo = new JButton(accion_rojo);
            cerrar = new JButton(accion_cerrar);

            barra.add(azul);
            barra.add(amarillo);
            barra.add(rojo);
            barra.addSeparator();
            barra.add(cerrar);

            menu.add(accion_azul);
            menu.add(accion_amarillo);
            menu.add(accion_rojo);
            //menu.add(accion_cerrar);

            barraMenu.add(menu);
            add(barraMenu); // -----------anade la barra del menu a la lamina del marco.
            add(barra); // ---------------anade la de herramientas al marco

        }
        // Clase interna hecha con la cl, 'AbstracAction' en vez de la interface 'Action'
        private class AccionColor extends AbstractAction {

            private Color color;
            public AccionColor(String name, Icon icono, Color color) {
                this.color = color;
                putValue(Action.NAME, name);
                putValue(Action.LARGE_ICON_KEY, icono);
                putValue(Action.SHORT_DESCRIPTION, "Cambia fondo a color; " + name);
                putValue("color_de_fondo", color);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String valor = e.getActionCommand();
                if (valor == "Cerrar") {
                    System.exit(0);
                }
                else{
                     setBackground(color);
                }
            }
        }
    }
}
