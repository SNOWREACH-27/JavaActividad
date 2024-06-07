package Frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Empleados.*;
import java.awt.*;
import java.awt.event.*;

public class EmpresaFrame extends JFrame {
    /**
     * Campos de texto para los datos de los empleados.
     */
    private JTextField[] textFields;
    /**
     * Modelo para la tabla de empleados.
     */
    private DefaultTableModel model;
    /**
     * Botones de la interfaz.
     */
    private JButton[] buttons;
    /**
     * Color del panel principal de la interfaz.
     */
    public Color COLOR_PANEL = new Color(127, 179, 213);
    /**
     * Los placeholders (textos de ayuda) para los campos de texto.
     */
    private String[] TEXTFIELD_PLACEHOLDERS = {
            "Nombre", "Apellido", "Cedula", "Cantidad de Hijos",
            "Horas Trabajadas", "Años de Servicios", "DD/MM/AA", "DD/MM/AA"
    };
    /**
     * Los nombres de las columnas de la tabla de empleados.
     */
    private String[] COLUMN_NAMES = {
            "Nombre", "Apellido", "Cedula", "Hijos", "Tipo de empleado",
            "Horas Trabajadas", "Años de Servicios", "Fecha de Alta",
            "Fecha de Baja", "Sueldo"
    };
    /**
     * Los tipos de empleado disponibles.
     */
    private String[] TIPO_EMPLEADO = {
            "Seleccione", "Por Hora", "Temporal", "Planta Permanente"
    };
    /**
     * ComboBox para seleccionar el tipo de empleado.
     */
    private JComboBox<String> comboBox = new JComboBox<>(TIPO_EMPLEADO);
    /**
     * Tipo de empleado seleccionado en el ComboBox.
     */
    private String empleadoTipo = TIPO_EMPLEADO[0];

    // Define el constructor para la clase `EmpresaFrame`.
    // Llama al método `init()`
    // para inicializar la clase cuando se crea un objeto de `EmpresaFrame`.
    public EmpresaFrame() {
        init();
    }

    /**
     * Método que inicializa la clase `EmpresaFrame`.
     * Establece el título de la ventana, el tamaño, la posición, el comportamiento
     * al cerrar la ventana,
     * el diseño y si puede redimensionarse.
     * Crea una tabla y la agrega al centro de la ventana.
     * Crea un panel de formulario y lo agrega al lado derecho de la ventana.
     * Establece los campos de texto, los botones y los componentes de los paneles.
     * Establece la visibilidad de la ventana.
     */
    public void init() {
        setTitle("Empleados");
        setSize(1500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JScrollPane table = createTable();
        add(table, BorderLayout.CENTER);

        JPanel panelForm = createPanelForm();
        panelForm.setPreferredSize(new Dimension(500, getHeight()));
        add(panelForm, BorderLayout.EAST);

        setTextFields();
        setButtons();
        layoutComponents(panelForm);

        setVisible(true);
    }

    /**
     * Crea un panel de formulario y lo configura con el color de fondo definido.
     *
     * @return Un panel de formulario con el color de fondo definido.
     */
    private JPanel createPanelForm() {
        JPanel panel = new JPanel();
        panel.setBackground(COLOR_PANEL);
        return panel;
    }
    /**
     * Crea un panel secundario con un flujo de diseño izquierdo y un tamaño
     * preferido.
     *
     * @return un panel con flujo de diseño izquierdo y tamaño preferido.
     */
    private JPanel createSubPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(215, getHeight()));
        panel.setBackground(COLOR_PANEL);
        return panel;
    }
    /**
     * Crea un campo de texto con el texto de marcador de posición dado, el tamaño y
     * la fuente establecidos.
     *
     * @param placeholder el texto de marcador de posición que se mostrará en el
     *                    campo de texto.
     * @return un campo de texto con el texto de marcador de posición, el tamaño y
     *         la fuente establecidos.
     */
    private JTextField createTextField(String placeholder) {
        JTextField textField = new JTextField(placeholder);
        textField.setPreferredSize(new Dimension(200, 35));
        textField.setForeground(Color.gray);
        textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        return textField;
    }

    /**
     * Crea un botón con el texto dado, el color de fondo y las propiedades de
     * fuente
     * establecidas.
     *
     * @param nombreTexto    el texto que se mostrará en el botón.
     * @param actionListener el listener de eventos que se asociará al botón.
     * @return un botón con el texto dado, el color de fondo y las propiedades de
     *         fuente
     *         establecidas.
     */
    private JButton createButtons(String nombreTexto, ActionListener actionListener) {
        JButton button = new JButton();
        button.setText(nombreTexto);
        button.setBackground(new Color(169, 204, 227));
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        button.setPreferredSize(new Dimension(100, 60));
        button.addActionListener(actionListener);
        return button;
    }

    /**
     * Configura los botones de la interfaz de usuario.
     * Crea dos botones: uno para guardar los datos y otro para limpiar los campos
     * de texto.
     */
    private void setButtons() {
        JButton buttonSave = createButtons("Guardar", e -> saveDataShowModal());
        JButton buttonClean = createButtons("Limpiar", e -> clearDataShowModal());
        buttons = new JButton[] { buttonSave, buttonClean };
    }
    /**
     * Devuelve los valores de los campos de texto como un arreglo de cadenas.
     * 
     * @return arreglo de cadenas con los valores de los campos de texto
     */
    private String[] getTextFieldValues() {
        String nombre = textFields[0].getText();
        String apellido = textFields[1].getText();
        String cedula = textFields[2].getText();
        String cantidadHijos = textFields[3].getText();
        String horasTrabajadas = textFields[4].getText();
        String añosServicio = textFields[5].getText();
        String fechaAlta = textFields[6].getText();
        String fechaBaja = textFields[7].getText();

        return new String[] {
                nombre, apellido, cedula, cantidadHijos, horasTrabajadas, añosServicio, fechaAlta, fechaBaja
        };
    }
    /**
     * Establece los valores de los campos de texto como los placeholders
     * correspondientes
     * y establece el color del texto a gray.
     */
    private void setTextFieldValuesClean() {
        for (int i = 0; i < textFields.length; i++) {
            if (!textFields[i].getText().equals(TEXTFIELD_PLACEHOLDERS[i])) {
                textFields[i].setText(TEXTFIELD_PLACEHOLDERS[i]);
                textFields[i].setForeground(Color.gray);
            }
        }
    }
    /**
     * Crea y establece los campos de texto con los placeholders correspondientes.
     */
    
    private void setTextFields() {
        textFields = new JTextField[TEXTFIELD_PLACEHOLDERS.length];
        for (int i = 0; i < TEXTFIELD_PLACEHOLDERS.length; i++) {
            textFields[i] = createTextField(TEXTFIELD_PLACEHOLDERS[i]);
        }
    }
    
    /**
     * Formatea los valores de los campos de texto, reemplazando los placeholders
     * por cadenas vacías o números ceros según sea necesario.
     *
     * @param values arreglo de cadenas con los valores de los campos de texto
     * @return arreglo de cadenas con los valores formateados
     */
    private String[] formatTextFieldsValues(String[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(TEXTFIELD_PLACEHOLDERS[i])) {
                if (i == 3 || i == 4 || i == 5) {
                    values[i] = "0";
                } else {
                    values[i] = "";
                }
            }
        }
        return values;
    }
    /**
     * Guarda los datos mostrados en el cuadro de diálogo si el usuario lo confirma.
     * Primero, verifica que se haya seleccionado un tipo de empleado. Si no se ha
     * seleccionado,
     * muestra un mensaje de error. Si se ha seleccionado un tipo de empleado,
     * verifica que los
     * campos de texto no estén vacíos. Si alguno de los campos de texto está vacío,
     * muestra un
     * mensaje de error. Si todos los campos de texto están llenos, crea un nuevo
     * empleado
     * según el tipo de empleado seleccionado, muestra un mensaje de confirmación y
     * limpia los
     * campos de texto.
     */
    private void saveDataShowModal() {
        int dialogResult = JOptionPane.showConfirmDialog(
                null, "¿Desea guardar la información?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (empleadoTipo.equals(TIPO_EMPLEADO[0])) {
                JOptionPane.showMessageDialog(
                        null, "Error: seleccione un tipo de empleado", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] values = formatTextFieldsValues(getTextFieldValues());
                createEmpleados(values);
                JOptionPane.showMessageDialog(null, "Los datos fueron almacenados");
                setTextFieldValuesClean();
                comboBox.setSelectedIndex(0);
            }
        }
    }

    /**
     * Limpia los datos mostrados en el cuadro de diálogo si el usuario lo confirma.
     * Primero, muestra un mensaje de advertencia. Si el usuario confirma, limpia
     * los
     * campos de texto.
     */
    private void clearDataShowModal() {
        int dialogResult = JOptionPane.showConfirmDialog(
                null, "¿Está seguro que desea limpiar todos los parámetros?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            setTextFieldValuesClean();
            comboBox.setSelectedIndex(0);
        }
    }
    /**
     * Crea un nuevo objeto de tipo Empleado según el tipo de empleado seleccionado
     * y actualiza la lista de empleados con los valores del objeto creado.
     *
     * @param values arreglo de cadenas con los valores de los campos de texto
     */
    private void createEmpleados(String[] values) {
        switch (empleadoTipo) {
            case "Por Hora":
                EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora(
                        values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                updateTable(empleadoPorHora.valuesList());
                break;
            case "Temporal":
                EmpleadoTemporal empleadoTemporal = new EmpleadoTemporal(
                        values[0], values[1], values[2], Integer.parseInt(values[3]), values[6], values[7]);
                updateTable(empleadoTemporal.valuesList());
                break;
            case "Planta Permanente":
                EmpleadoPermanente empleadoPermanente = new EmpleadoPermanente(
                        values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[5]));
                updateTable(empleadoPermanente.valuesList());
                break;
        }
    }
    /**
     * Actualiza la lista de empleados agregando una nueva fila con los valores
     * proporcionados.
     *
     * @param values arreglo de cadenas con los valores de los campos de texto
     */
    private void updateTable(String[] values) {
        model.addRow(values);
    }

    /**
     * Agrega un listener de teclado a un campo de texto para permitir solo
     * ingresar dígitos.
     *
     * @param textField el campo de texto al que se le agregará el listener.
     */
    private void addKeyListenerToTextField(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent event) {
                char character = event.getKeyChar();
                if (!Character.isDigit(character)) {
                    event.consume(); // Evita que se ingrese el carácter no numérico
                }
            }
        });
    }

    /**
     * Agrega un listener de evento de enfoque a un campo de texto para cambiar
     * el texto y el color cuando se obtiene o pierde el foco.
     *
     * @param JtextField el campo de texto al que se le agregará el listener.
     * @param index      el índice del campo de texto en la matriz de campos de
     *                   texto.
     */
    private void textFieldFocus(JTextField JtextField, Integer index) {
        JtextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (JtextField.getText().equals(TEXTFIELD_PLACEHOLDERS[index])) {
                    JtextField.setText("");
                    JtextField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (JtextField.getText().isEmpty()) {
                    JtextField.setText(TEXTFIELD_PLACEHOLDERS[index]);
                    JtextField.setForeground(Color.gray);
                }
            }
        });
    }

    /**
     * Coloca los componentes en el panel de diseño.
     *
     * @param panel el panel al que se le agregarán los componentes.
     */
    private void layoutComponents(JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 25, 15));

        JPanel leftPanel = createSubPanel();
        addComponentsToLeftPanel(leftPanel);
        panel.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = createSubPanel();
        addComponentsToRightPanel(rightPanel);
        panel.add(rightPanel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    

    /**
     * Agrega los componentes al panel izquierdo del formulario.
     * Incluye los campos de texto para Nombre, Apellido, Cedula y Cantidad de
     * Hijos.
     * 
     * @param panel el panel al que se le agregarán los componentes.
     */

    private void addComponentsToLeftPanel(JPanel panel) {
        panel.add(new JLabel("Nombre:"));
        panel.add(textFields[0]);
        textFieldFocus(textFields[0], 0);

        panel.add(new JLabel("Apellido:"));
        panel.add(textFields[1]);
        textFieldFocus(textFields[1], 1);

        panel.add(new JLabel("Cedula:"));
        panel.add(textFields[2]);
        addKeyListenerToTextField(textFields[2]);
        textFieldFocus(textFields[2], 2);

        panel.add(new JLabel("Cantidad de Hijos:"));
        panel.add(textFields[3]);
        addKeyListenerToTextField(textFields[3]);
        textFieldFocus(textFields[3], 3);
    }

    /**
     * Agrega los componentes al panel derecho del formulario.
     * Incluye los campos de texto para Horas Trabajadas, Años de Servicio, Fecha de
     * Alta,
     * Fecha de Baja y Tipo de Empleado.
     *
     * @param panel el panel al que se le agregarán los componentes.
     */
    private void addComponentsToRightPanel(JPanel panel) {
        panel.add(new JLabel("Horas Trabajadas:"));
        panel.add(textFields[4]);
        disableTextField(4);
        textFieldFocus(textFields[4], 4);
        addKeyListenerToTextField(textFields[4]);

        panel.add(new JLabel("Años de Servicio:"));
        panel.add(textFields[5]);
        disableTextField(5);
        textFieldFocus(textFields[5], 5);
        addKeyListenerToTextField(textFields[5]);

        panel.add(new JLabel("Fecha de Alta:"));
        panel.add(textFields[6]);
        disableTextField(6);
        textFieldFocus(textFields[6], 6);

        panel.add(new JLabel("Fecha de Baja:"));
        panel.add(textFields[7]);
        disableTextField(7);
        textFieldFocus(textFields[7], 7);

        panel.add(new JLabel("Tipo de Empleado:"));
        comboBox = new JComboBox<>(TIPO_EMPLEADO);
        comboBox.addActionListener(e -> configureTextFieldBasedOnComboBoxSelection());
        panel.add(comboBox);
    }

    /**
     * Configura los campos de texto basados en la selección del ComboBox.
     *
     * Cuando se selecciona "Por Hora" en el ComboBox, se habilita el campo de
     * texto "Horas Trabajadas" y se deshabilitan los campos de texto "Años de
     * Servicio", "Fecha de Alta" y "Fecha de Baja".
     *
     * Cuando se selecciona "Temporal" en el ComboBox, se habilita el campo de
     * texto "Fecha de Alta" y se deshabilitan los campos de texto "Horas
     * Trabajadas", "Años de Servicio" y "Fecha de Baja".
     *
     * Cuando se selecciona "Planta Permanente" en el ComboBox, se habilita el
     * campo de texto "Años de Servicio" y se deshabilitan los campos de texto
     * "Horas Trabajadas", "Fecha de Alta" y "Fecha de Baja".
     *
     */
    private void configureTextFieldBasedOnComboBoxSelection() {
        empleadoTipo = comboBox.getSelectedItem().toString();
        boolean isPorHoraSelected = TIPO_EMPLEADO[1].equals(empleadoTipo);
        boolean isTemporalSelected = TIPO_EMPLEADO[2].equals(empleadoTipo);
        boolean isPermanenteSelected = TIPO_EMPLEADO[3].equals(empleadoTipo);

        enableOrDisableTextField(4, isPorHoraSelected);
        enableOrDisableTextField(6, isTemporalSelected);
        enableOrDisableTextField(7, isTemporalSelected);
        enableOrDisableTextField(5, isPermanenteSelected);
    }

    /**
     * Habilita o deshabilita el campo de texto dependiendo de la condición.
     *
     * @param indexTextField Índice del campo de texto a habilitar o deshabilitar.
     * @param condition      Condición para habilitar o deshabilitar el campo de
     *                       texto.
     */
    private void enableOrDisableTextField(Integer indexTextField, boolean condition) {
        if (condition) {
            enableTextField(indexTextField);
        } else {
            disableTextField(indexTextField);
        }
    }

    /**
     * Crea y devuelve un JScrollPane conteniendo una tabla con la información de
     * los empleados.
     * La tabla es de solo lectura y sus filas no pueden ser seleccionadas
     * individualmente.
     * 
     * @return Un JScrollPane conteniendo la tabla de empleados.
     */
    private JScrollPane createTable() {
        model = new DefaultTableModel(COLUMN_NAMES, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setCellSelectionEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        return scrollPane;
    }

    /**
     * Habilita un campo de texto específico.
     *
     * @param indexTextField Índice del campo de texto a habilitar.
     */
    private void enableTextField(Integer indexTextField) {
        textFields[indexTextField].setEnabled(true);
        textFields[indexTextField].setFocusable(true);
    }

    /**
     * Deshabilita un campo de texto específico, establece su texto y su color de
     * texto en los valores correspondientes al placeholder del campo.
     *
     * @param indexTextField Índice del campo de texto a deshabilitar.
     */
    private void disableTextField(Integer indexTextField) {
        if (!textFields[indexTextField].getText().equals(TEXTFIELD_PLACEHOLDERS[indexTextField])) {
            textFields[indexTextField].setEnabled(false);
            textFields[indexTextField].setFocusable(false);
            textFields[indexTextField].setText(TEXTFIELD_PLACEHOLDERS[indexTextField]);
            textFields[indexTextField].setForeground(Color.gray);
        }
        textFields[indexTextField].setEnabled(false);
        textFields[indexTextField].setFocusable(false);
    }
}