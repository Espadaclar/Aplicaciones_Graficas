import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.*;



 
public class ProcesadorDeTexto extends JFrame
{
    private Image image;
    private Toolkit icon;
    public static void main(String[] args) {
        ProcesadorDeTexto marco = new ProcesadorDeTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ProcesadorDeTexto() {
        Lamina lamina = new Lamina();
        add(lamina);

        setBounds(150, 70, 900, 500);
        setVisible(true);
        setTitle("46_Menus");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../iconos/a.gif");
        setIconImage(image);
    }

    public class Lamina extends JPanel {
            JPanel laminaN = new JPanel();//     para colocar la barra del menu.
        JMenuBar barraM = new JMenuBar();//  barra del menu
        JMenu fuent, tamano, stilo;
        JTextPane texto = new JTextPane();// cuadro de texto
        Font fuente = new Font(null);//      da formato al texto

        private int z; // --almacena el tamano de la letra.
        private ButtonGroup group;
        private JRadioButtonMenuItem radio;
        private ButtonGroup group2;
        private JRadioButtonMenuItem radio2;

        private JToolBar barraH; //  --- para crear barra de herrmaientas.

        
        public Lamina() {
            setLayout(new BorderLayout());// -------- DISPOSICION DE LA LAMINA BASE.
            
           JToolBar barraH = new JToolBar(JToolBar.VERTICAL);//  --- para crear barra de herrmaientas.
  
            JPanel laminaBarraH = new JPanel();
            laminaBarraH.add(barraH);//  --- anade a laminaBarraH la barra de herrmaientas.
            add(laminaBarraH, BorderLayout.WEST);
            
            group = new ButtonGroup();
            
            add(laminaN, BorderLayout.NORTH);
            add(texto, BorderLayout.CENTER);
            
            //texto.setFont(new Font("Arial", Font.PLAIN, 22));
            laminaN.add(barraM);// -------------pone la barra dentro de una lamina.

            fuent = new JMenu("Fuente");           
            stilo = new JMenu("Stilo");
            tamano = new JMenu("Tamaño");

            barraM.add(fuent);
            barraM.add(stilo);
            barraM.add(tamano);

            creaFuenteJRadioButtonMenuItem("Arial", "../iconos/file_font.gif");
            creaFuenteJRadioButtonMenuItem("Bell MT", "../iconos/file_font.gif");
            creaFuenteJRadioButtonMenuItem("Lucida Handwriting", "../iconos/file_font.gif");

            configuraMenu("Negrita", "stilo", " ", Font.BOLD, z, "");// solo tiene que modificar el stilo.
            configuraMenu("Cursiva", "stilo", " ", Font.ITALIC, z, "");

            creaTamanoJRadioButtonMenuItem("18", "../iconos/file_font_truetype.gif", 18 );
            creaTamanoJRadioButtonMenuItem("25", "../iconos/file_font_truetype.gif", 25 );
            creaTamanoJRadioButtonMenuItem("30", "../iconos/file_font_truetype.gif", 30 );
            creaTamanoJRadioButtonMenuItem("35", "../iconos/file_font_truetype.gif", 35 );

            iconoBarraH("Negrita", "../iconos/aaNegrita.gif");
            iconoBarraH("Cursiva", "../iconos/aaCursiva.gif");
            iconoBarraH("Subrrallado", "../iconos/aaSubrrallado.gif");
            iconoBarraH("Copiar", "../iconos/aaCopiar.gif");
            iconoBarraH("Cortar", "../iconos/aaCortar.gif");
            iconoBarraH("Pegar", "../iconos/aaPegar.gif");        
        } 

        /**
         * @param rotulo   ----nombre de subclase del elemento de la barra
         * @param menu    -----nombre del elemento de la barra
         * @param tipo_letra   - Nombre del tipo de letra que se asigna al texto.
         * @param est      - Estilo que toma cada tipo de letra, negrita, cursiva etc
         * @param tam       - Tamano de la letra. 
         */
        public void configuraMenu(String rotulo, String menu, String tipo_letra, int est, int tam, String icon){
            z = tam;
            JMenuItem elemento_menu = new JMenuItem(rotulo, new ImageIcon(icon));

            if(menu == "stilo"){
                stilo.add(elemento_menu);             
                if(est == Font.BOLD){  
                    // --- atajo de teclado para poner en negrita el texto seleccionado.
                    elemento_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                    elemento_menu.addActionListener(new StyledEditorKit.BoldAction());
                }
                else if(est == Font.ITALIC){
                    // --- atajo de teclado para poner en cursiva el texto seleccionado.
                    elemento_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                    elemento_menu.addActionListener(new StyledEditorKit.ItalicAction());
                }                
            }
        }

        public void creaTamanoJRadioButtonMenuItem(String text, String icono, int tam){
            z = tam;
            radio = new JRadioButtonMenuItem(text, new ImageIcon(icono));
            radio.addActionListener(new  StyledEditorKit.FontSizeAction("adfaa", z));
            tamano.add(radio);
            group.add(radio);
        }

        public void creaFuenteJRadioButtonMenuItem(String TipoLetra, String icono){
            radio = new JRadioButtonMenuItem(TipoLetra, new ImageIcon(icono));
            radio.addActionListener(new StyledEditorKit.FontFamilyAction("adfaa", TipoLetra));
            fuent.add(radio);
            group.add(radio);
        }

        /**
         * Crea botones para barra de herramientas, tambien gestiona el evento que realiza.
         */
        public void iconoBarraH(String name, String icono){

            JButton element = new JButton(new ImageIcon(icono)); // BOTON QUE APARECE EN LA BARRA DE HERRAMIENTAS 
            if(name.equals("Negrita")){ // --------- APLICAMOS EL GESTOR DE EVENTOS
                element.addActionListener(new StyledEditorKit.BoldAction());
                barraH.add(element);//  --- anade elemento a la barra de herrmaientas.
            }else if(name.equals("Cursiva")){
                element.addActionListener(new StyledEditorKit.ItalicAction());
                barraH.add(element);//  --- anade elemento a la barra de herrmaientas.
            }
            else if(name.equals("Copiar")){
                element.addActionListener(new DefaultEditorKit.CopyAction());
                barraH.add(element);//  --- anade elemento a la barra de herrmaientas.
            }
            else if(name.equals("Cortar")){
                element.addActionListener(new DefaultEditorKit.CutAction());
                barraH.add(element);//  --- anade elemento a la barra de herrmaientas.
            }
            else if(name.equals("Pegar")){
                element.addActionListener(new DefaultEditorKit.PasteAction());
                barraH.add(element);//  --- anade elemento a la barra de herrmaientas.
            }else if(name.equals("Subrrallado")){
                element.addActionListener(new StyledEditorKit.UnderlineAction());
                barraH.add(element);//  --- anade elemento a la barra de herrmaientas.
            }
        }
    }
}
