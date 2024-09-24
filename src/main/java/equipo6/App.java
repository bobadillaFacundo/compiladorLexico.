package equipo6;
import jflex.Lexico;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class App extends JDialog {
    private JButton buttonCreate;
    private JButton buttonValidate;
    private JTextArea textAreaInput;
    private JTextArea textAreaResult;

    public App() throws FileNotFoundException {
        setTitle("Compilador Lexico");
        setModal(true);
        setLayout(null); // Usar layout nulo

        // Inicializar JTextAreas
        textAreaInput = new JTextArea();
        textAreaResult = new JTextArea();
        textAreaResult.setEditable(false); // No editable para el área de resultados

        // Configurar JScrollPane para cada JTextArea
        JScrollPane scrollInput = new JScrollPane(textAreaInput);
        JScrollPane scrollResult = new JScrollPane(textAreaResult);

        // Configurar el tamaño de los JScrollPane y JTextArea
        scrollInput.setBounds(10, 40, 500, 300);  // Agrandé el área de entrada
        scrollResult.setBounds(520, 40, 500, 300); // Agrandé el área de resultados

        // Añadir títulos
        JLabel labelInput = new JLabel("Entrada");
        JLabel labelResult = new JLabel("Resultado");
        labelInput.setBounds(10, 10, 100, 25);
        labelResult.setBounds(520, 10, 100, 25);

        // Inicializar botones
        buttonCreate = new JButton("Crear Archivo");
        buttonValidate = new JButton("Validar Archivo");
        // Reubicar los botones en la parte inferior derecha
        buttonCreate.setBounds(770, 360, 150, 30);
        buttonValidate.setBounds(930, 360, 150, 30);

        // Agregar ActionListeners a los botones
        buttonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearArchivo();
            }
        });

        buttonValidate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarArchivo();
            }
        });

        // Manejar el cierre de la ventana
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Asignar acción de Escape para validar archivo
        getRootPane().registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarArchivo();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // Agregar componentes a la ventana
        add(scrollInput);
        add(scrollResult);
        add(labelInput);
        add(labelResult);
        add(buttonCreate);
        add(buttonValidate);

        setSize(1050, 450);  // Agrandé la ventana
        setLocationRelativeTo(null); // Centrar la ventana
    }

    private void crearArchivo() {
        File file = new File("src\\main\\java\\ejemploFlex\\prueba.txt");

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file);
            writer.write(textAreaInput.getText());
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void validarArchivo() {
        try {
            String filePath = "src\\main\\java\\ejemploFlex\\prueba.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            Lexico lexer = new jflex.Lexico(reader);
            textAreaResult.setText("");
            Token token = lexer.yylex();
            File file = new File("src\\main\\java\\ejemploFlex\\ts.txt");
            FileWriter writer = new FileWriter(file);
            textAreaResult.append("NOMBRE        "+"TOKEN        "+"TIPO        "+"VALOR        "+"LONG        \n");
            writer.write("NOMBRE        "+"TOKEN        "+"TIPO        "+"VALOR        "+"LONG        \n");
            while (token.getType() != TokenConstants.EOF) {
                try {
                    writer.write(token.toString()+"\n");
                    textAreaResult.append(token.toString()+"\n");
                    token = lexer.yylex();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e) {e.printStackTrace();}
    }



    // Métodos crearArchivo y validarArchivo (sin cambios)...

    public static void main(String[] args) {
        App dialog;
        try {
            dialog = new App();
            dialog.pack();
            dialog.setSize(1100, 500);
            dialog.setResizable(false);
            dialog.setVisible(true);
            System.exit(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



































