package Interfaz;

import static Interfaz.Lexico.nombreArchivo;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacc.Python;
import javacc.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lexico extends javax.swing.JFrame {

    public Lexico() {
        initComponents();
         ImageIcon logo = new ImageIcon ("src/Imagenes/excelente1.png");   //creamos un objeto con una imagen
        this.setIconImage(logo.getImage());   //designamos la imagen como icono del compilador
        this.setVisible(true);
        //La ventana se crea justo en el centro
        this.setLocationRelativeTo(null);

        //Es importante que el título de la ventana no contenga .mpl
        this.setTitle("Analizador Léxico-Sintáctico-Semántico  PYTHON - Nuevo proyecto");

        //No hacer nada al darle clic a la X de cerrar, ya que se aplica otro método
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }
    Python compilador;

    //String que en al abrir contiene el nombre del archivo
    public static String nombreArchivo;

    //Variable para el número de líneas de la interfaz
    private int numeroLinea = 1;

    //Variable lógica que indica que hay un archivo cargado si su valor se vuelve verdadero
    public boolean cargo_archivo = false;

    //String global que contendrá el nombre del archivo
    public String nombre;

    //File global que contendrá la ruta del archivo
    public File ruta2;

    //Contador para el autoguardado
    public int c;

    //Ruta de acceso para el FileChooser
    private static String ruta_de_acceso = "C:\\Users\\Carlos\\Documents\\NetBeansProjects\\MPL\\src\\Programas";

    //FileChooser que al guardar utiliza la ruta de acceso predeterminada
    private static JFileChooser guardar_como = new JFileChooser(ruta_de_acceso);

    //Otro FileChooser que al guardar utiliza la ruta de acceso predeterminada
    private static JFileChooser buscar = new JFileChooser(ruta_de_acceso);

    //Variable booleana que indica cuando hubo cambios en el área de código
    //Aparentemente no se usa, quitar?
    private boolean cambios = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelgral = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        area_lineas = new javax.swing.JTextArea();
        area_codigo = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        boton_compilar = new javax.swing.JButton();
        boton_limpiar = new javax.swing.JButton();
        boton_cerrar = new javax.swing.JButton();
        Panel_salida = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_salida = new javax.swing.JTextArea();
        jScrollPane20 = new javax.swing.JScrollPane();
        area_salida1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        area_salida2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_guardar_como = new javax.swing.JMenu();
        nuevo_proyecto = new javax.swing.JMenuItem();
        abrir_proyecto = new javax.swing.JMenuItem();
        menu_guardar = new javax.swing.JMenuItem();
        menu_guardarcomo = new javax.swing.JMenuItem();
        menu_imprimir = new javax.swing.JMenuItem();
        menu_salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        menu_compilar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menu_manual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 102));
        setForeground(new java.awt.Color(153, 153, 153));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Panelgral.setBackground(new java.awt.Color(0, 0, 0));
        Panelgral.setMinimumSize(new java.awt.Dimension(0, 0));

        jScrollPane2.setBorder(null);
        jScrollPane2.setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));

        area_lineas.setEditable(false);
        area_lineas.setColumns(20);
        area_lineas.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        area_lineas.setForeground(new java.awt.Color(0, 0, 102));
        area_lineas.setRows(5);
        area_lineas.setText("1");
        area_lineas.setAutoscrolls(false);
        area_lineas.setBorder(null);

        area_codigo.setColumns(20);
        area_codigo.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        area_codigo.setForeground(new java.awt.Color(0, 51, 51));
        area_codigo.setRows(5);
        area_codigo.setTabSize(5);
        area_codigo.setWrapStyleWord(true);
        area_codigo.setBorder(null);
        area_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                area_codigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                area_codigoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(area_lineas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(area_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 1339, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(area_codigo)
            .addComponent(area_lineas, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        boton_compilar.setBackground(new java.awt.Color(255, 255, 255));
        boton_compilar.setForeground(new java.awt.Color(255, 255, 255));
        boton_compilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejecutar.png"))); // NOI18N
        boton_compilar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_compilarActionPerformed(evt);
            }
        });

        boton_limpiar.setBackground(new java.awt.Color(255, 255, 255));
        boton_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        boton_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        boton_limpiar.setText("Limpiar");
        boton_limpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_limpiarActionPerformed(evt);
            }
        });

        boton_cerrar.setBackground(new java.awt.Color(255, 255, 255));
        boton_cerrar.setForeground(new java.awt.Color(255, 255, 255));
        boton_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Finalizar.png"))); // NOI18N
        boton_cerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boton_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(boton_compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(boton_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(boton_compilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(boton_limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(boton_cerrar))
        );

        Panel_salida.setBackground(new java.awt.Color(255, 255, 255));
        Panel_salida.setPreferredSize(new java.awt.Dimension(1050, 148));

        area_salida.setBackground(new java.awt.Color(153, 153, 153));
        area_salida.setColumns(20);
        area_salida.setRows(5);
        jScrollPane1.setViewportView(area_salida);

        area_salida1.setBackground(new java.awt.Color(102, 102, 102));
        area_salida1.setColumns(20);
        area_salida1.setRows(5);
        jScrollPane20.setViewportView(area_salida1);

        area_salida2.setBackground(new java.awt.Color(153, 153, 153));
        area_salida2.setColumns(20);
        area_salida2.setRows(5);
        jScrollPane3.setViewportView(area_salida2);

        javax.swing.GroupLayout Panel_salidaLayout = new javax.swing.GroupLayout(Panel_salida);
        Panel_salida.setLayout(Panel_salidaLayout);
        Panel_salidaLayout.setHorizontalGroup(
            Panel_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_salidaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Panel_salidaLayout.setVerticalGroup(
            Panel_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane20)
        );

        javax.swing.GroupLayout PanelgralLayout = new javax.swing.GroupLayout(Panelgral);
        Panelgral.setLayout(PanelgralLayout);
        PanelgralLayout.setHorizontalGroup(
            PanelgralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelgralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelgralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_salida, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
                    .addGroup(PanelgralLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelgralLayout.setVerticalGroup(
            PanelgralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelgralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelgralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(Panelgral, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(0, 102, 102));

        menu_guardar_como.setForeground(new java.awt.Color(51, 0, 0));
        menu_guardar_como.setText("ARCHIVOS");
        menu_guardar_como.setFont(new java.awt.Font("Modern No. 20", 3, 14)); // NOI18N

        nuevo_proyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        nuevo_proyecto.setText("Nuevo...");
        nuevo_proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_proyectoActionPerformed(evt);
            }
        });
        menu_guardar_como.add(nuevo_proyecto);

        abrir_proyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        abrir_proyecto.setText("Abrir");
        abrir_proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir_proyectoActionPerformed(evt);
            }
        });
        menu_guardar_como.add(abrir_proyecto);

        menu_guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menu_guardar.setText("Guardar");
        menu_guardar.setEnabled(false);
        menu_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarActionPerformed(evt);
            }
        });
        menu_guardar_como.add(menu_guardar);

        menu_guardarcomo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menu_guardarcomo.setText("Guardar como...");
        menu_guardarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarcomoActionPerformed(evt);
            }
        });
        menu_guardar_como.add(menu_guardarcomo);

        menu_imprimir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menu_imprimir.setText("Imprimir");
        menu_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_imprimirActionPerformed(evt);
            }
        });
        menu_guardar_como.add(menu_imprimir);

        menu_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menu_salir.setText("Salir");
        menu_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_salirActionPerformed(evt);
            }
        });
        menu_guardar_como.add(menu_salir);

        jMenuBar1.add(menu_guardar_como);

        jMenu2.setBackground(new java.awt.Color(51, 0, 0));
        jMenu2.setForeground(new java.awt.Color(51, 0, 0));
        jMenu2.setText("HERRAMIENTAS");
        jMenu2.setFont(new java.awt.Font("Modern No. 20", 3, 14)); // NOI18N

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Limpiar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        menu_compilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menu_compilar.setText("Ejecutar");
        menu_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_compilarActionPerformed(evt);
            }
        });
        jMenu2.add(menu_compilar);

        jMenuBar1.add(jMenu2);

        jMenu4.setBackground(new java.awt.Color(51, 0, 0));
        jMenu4.setForeground(new java.awt.Color(51, 0, 0));
        jMenu4.setText("SOPORTE");
        jMenu4.setFont(new java.awt.Font("Modern No. 20", 3, 14)); // NOI18N

        menu_manual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menu_manual.setText("Manual de Usuario");
        menu_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_manualActionPerformed(evt);
            }
        });
        jMenu4.add(menu_manual);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método cerrar que se llama cuando se va a cerrar la ventana con la X o el botón de la interfaz
    private void cerrar() {
        Object[] opciones = {"Aceptar", "No"};
        //JOptionPane que muestra las opciones para llamar o no al FileChooser
        int eleccion = JOptionPane.showOptionDialog(rootPane, "Guardar antes de salir?", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");

        //Si se quiere guardar antes de salir entra aquí
        if (eleccion == JOptionPane.YES_OPTION) {

            //Para guardar antes de salir habrá dos opciones según el tipo de archivo
            //OPCIÓN 1. La ventana ya contiene .mpl, es decir que hay un archivo abierto, por lo tanto
            //se realizará un sobreescribir en el archivo
            if (this.getTitle().contains(".py")) { /////////////////////////////////////////////////////////////////888888888888

                //Sobreescribe el archivo
                sobreescribirg();
                //Cierra la ventana
                dispose();
                System.out.println("Archivo ya creado sobreescrito antes de salir");
                //Si no hay una ventana inicio activa, abre una ventana inicio al salir
                if (Inicio.limiteinicio == false) {
                    Inicio ini = new Inicio();
                    ini.setVisible(true);
                    //Variable para indicar que ya existe un inicio después de hacer esta parte
                    Inicio.limiteinicio = true;
                }
                System.out.println("Inicio abierto despues de sobreescribir un archivo ya creado");
            } //OPCIÓN 2. La ventana NO contiene .mpl en su título, entonces se deberá crear un nuevo archivo
            //con un 'guardar como'
            else {

                //Método 'guardar como' que creará un nuevo archivo
                guardarArchivo();
                //Después de creado y guardado, cerrar ventana
                dispose();
                System.out.println("Guardar nuevo archivo antes de salir");
                //Si no hay una ventana inicio activa, abre una ventana inicio al salir
                if (Inicio.limiteinicio == false) {
                    Inicio ini = new Inicio();
                    ini.setVisible(true);
                    //Variable para indicar que ya existe un inicio después de hacer esta parte
                    Inicio.limiteinicio = true;
                }
                System.out.println("Inicio abierto despues de crear nuevo archivo");
            }

        } //Si no se quiere guardar antes de salir, entra aquí
        else {

            //Cierra la ventana actual
            dispose();

            //Si no hay una ventana inicio activa, abre una ventana inicio al salir
            if (Inicio.limiteinicio == false) {
                Inicio ini = new Inicio();
                ini.setVisible(true);
                //Variable para indicar que ya existe un inicio después de hacer esta parte
                Inicio.limiteinicio = true;
            }
        }
    }

    private void guardarArchivo() {

        //Botón que abre el cuadro de diálogo de FileChooser, sin importar si hay archivo o no
        //Ya que habrá varias opciones
        int seleccion = guardar_como.showSaveDialog(this);

        //Se selecciona SÍ a guardar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            //Crear un nuevo archivo con su ruta
            File ruta = guardar_como.getSelectedFile();
            ruta2 = ruta;
            //Definir una variable para indicar cuando el archivo existe
            String existeArchivo = ruta2.getName();
            boolean existe = ruta2.exists();

            //Si la ruta bajo el mismo nombre de archivo existe entonces
            if (ruta2.exists()) {
                while (existe) {
                    //Se pregunta si desea reemplazar el archivo
                    seleccion = JOptionPane.showConfirmDialog(null, existeArchivo + " Ya existe. \n" + "¿Desea reemplazarlo?", "PYTHON: ", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    //Si se decide reemplazarlo, se sobreescribe sobre el archivo
                    if (seleccion == JOptionPane.YES_OPTION) {

                        //Obtener la ruta
                        ruta2 = ruta;

                        //El nombre a sobreescribir ya contiene extension
                        if (ruta2.toString().contains(".py")) {
                            System.out.println("Archivo reemplazado después de preguntar, ya teniendo extensión");
                            //Se realizará un guardado, así que se reinicia el contador del autoguardado
                            c = 0;
                            System.out.println("Contador reiniciado al reemplazar archivo existente");
                            //Se escribe sobre el archivo
                            try (FileWriter nuevoArchivo = new FileWriter(ruta)) {

                                //Obtener el texto a guardar y escribir sobre el archivo
                                nuevoArchivo.write(area_codigo.getText());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            //Se activa la variable para indicar que se guardó un archivo y se está
                            //posicionado sobre ese archivo
                            cargo_archivo = true;

                            //Se deshabilita el botón guardar hasta que haya un nuevo cambio
                            menu_guardar.setEnabled(false);

                            //Obtener el archivo guardado
                            File archC = guardar_como.getSelectedFile();

                            //Obtener el nombre del archivo para ponerlo en el frame
                            //Recordar que en este caso se escribió la existensión así que
                            //el nombre de archivo se coloca en el título del frame como tal
                            nombre = archC.getName();
                            this.setTitle("PYTHON - " + nombre);

                            //No hay cambios después de guardar, terminamos el ciclo de existencia
                            cambios = false;
                            existe = false;
                            System.out.println("Variable 'existe' false");

                        }

                    } //Si no se decide reemplazar el archivo, se regresa al FileChooser
                    //para tener de nuevo la opción de guardar como uno nuevo
                    else {

                        //Se abre el FileChooser
                        int seleccion2 = guardar_como.showSaveDialog(this);

                        System.out.println("No se deseó reemplazar, guardar con otro nombre");

                        //Será un nuevo archivo así que la variable de existencia es falsa
                        existe = false;
                        if (seleccion2 == JFileChooser.APPROVE_OPTION) {

                            //Se decidió guardar con otro nombre, entonces habrá opciones
                            System.out.println("NR - Guardar - Archivo nuevo");

                            //Reiniciar el contador de autoguardado sin importar cómo se escriba
                            //esto es, con o sin extensión inicial, ocurrirá el guardado
                            c = 0;
                            System.out.println("Contador reiniciado al crear un nuevo archivo sin reemplazar, con o sin extensión");

                            //Obtenemos la ruta del fichero
                            File rutaN = guardar_como.getSelectedFile();
                            ruta2 = rutaN;

                            //Se procede a crear un nuevo archivo
                            //El nombre dado ya contiene extension
                            if (ruta2.toString().contains(".py")) {
                                System.out.println("NR - Se escribió la extensión");
                                System.out.println("NR - Primer guardado con salto de linea");
                                //Crear el nuevo archivo sin extensión, porque ya se escribió
                                try (FileWriter nuevoArchivo = new FileWriter(rutaN)) {
                                    //Obtener el texto a guardar
                                    nuevoArchivo.write(area_codigo.getText() + "\n");

                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                                //Se activa la variable para indicar que se guardó un archivo y se está
                                //posicionado sobre ese archivo
                                cargo_archivo = true;

                                //Se deshabilita el botón guardar hasta que haya un nuevo cambio
                                menu_guardar.setEnabled(false);

                                //Obtener la ruta del archivo
                                File archC = guardar_como.getSelectedFile(); //Obtenemos el archivo guardado

                                //Obtener el nombre del archivo para ponerlo en el frame
                                //Recordar que en este caso se escribió la existensión así que
                                //el nombre de archivo se coloca en el título del frame como tal
                                nombre = archC.getName();
                                this.setTitle("PYTHON - " + nombre);

                                //Esto es importante, ya que es el primer guardado
                                //y posiblemente haya saltos de línea
                                //El 'guardar como' no hace esto, pero el sobreescribir sí
                                //entonces, se realiza un guardado en un nuevo archivo y
                                //posteriormente se ejecuta un sobreescribir con el mismo código
                                //de esta manera se guardan los espacios correctamente
                                sobreescribirg();

                                //No hay cambios después de guardar, terminamos el ciclo de existencia
                                cambios = false;
                                existe = false;
                                System.out.println("NR - Nuevo archivo con extensión escrita - Variable 'existe' false");

                            } //Se procede a crear un nuevo archivo
                            //El nombre dado no contiene extension
                            else if (!ruta2.toString().contains(".py")) {

                                //Crear el nuevo archivo con la extensión (porque NO se dio)
                                try (FileWriter nuevoArchivo = new FileWriter(rutaN + ".py")) {

                                    //Obtener el texto a guardar
                                    nuevoArchivo.write(area_codigo.getText());

                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }

                                //Se activa la variable para indicar que se guardó un archivo y se está
                                //posicionado sobre ese archivo
                                cargo_archivo = true;

                                //Se deshabilita el botón guardar hasta que haya un nuevo cambio
                                menu_guardar.setEnabled(false);

                                //Obtener la ruta del archivo
                                File archC = guardar_como.getSelectedFile(); //Obtenemos el archivo guardado

                                //Obtener el nombre del archivo para ponerlo en el frame
                                //Recordar que en este caso se escribió la existensión así que
                                //el nombre de archivo se coloca en el título del frame como tal
                                nombre = archC.getName(); //obtenemos el nombre del archivo
                                this.setTitle("PYTHON - " + nombre + ".py");

                                //Esto es importante, ya que es el primer guardado
                                //y posiblemente haya saltos de línea
                                //El 'guardar como' no hace esto, pero el sobreescribir sí
                                //entonces, se realiza un guardado en un nuevo archivo y
                                //posteriormente se ejecuta un sobreescribir con el mismo código
                                //de esta manera se guardan los espacios correctamente
                                sobreescribirg();
                                System.out.println("NR - No se escribió extensión, agregada");

                                //No hay cambios después de guardar, terminamos el ciclo de existencia
                                cambios = false;
                                existe = false;
                                System.out.println("NR - Nuevo archivo con extensión NO escrita - Variable 'existe' false");

                            }

                        }
                    }

                }
            } //El archivo no existe así que simplemente se crea uno nuevo
            //El nombre dado ya contiene extension
            else if (ruta2.toString().contains(".py")) {
                System.out.println("No existe archivo, se guarda extensión escrita");
                //Crear el nuevo archivo sin extensión, porque ya se escribió
                try (FileWriter nuevoArchivo = new FileWriter(ruta)) {
                    //Obtener el texto a guardar
                    nuevoArchivo.write(area_codigo.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //Se activa la variable para indicar que se guardó un archivo y se está
                //posicionado sobre ese archivo
                cargo_archivo = true;

                //Se deshabilita el botón guardar hasta que haya un nuevo cambio
                menu_guardar.setEnabled(false);

                //Obtener la ruta del archivo
                File archC = guardar_como.getSelectedFile(); //Obtenemos el archivo guardado

                //Obtener el nombre del archivo para ponerlo en el frame
                //Recordar que en este caso se escribió la existensión así que
                //el nombre de archivo se coloca en el título del frame como tal
                nombre = archC.getName();
                this.setTitle("PYTHON - " + nombre);

                //Esto es importante, ya que es el primer guardado
                //y posiblemente haya saltos de línea
                //El 'guardar como' no hace esto, pero el sobreescribir sí
                //entonces, se realiza un guardado en un nuevo archivo y
                //posteriormente se ejecuta un sobreescribir con el mismo código
                //de esta manera se guardan los espacios correctamente
                sobreescribirg();
                System.out.println("No reemplazar, crear archivo, primer guardado con salto de linea");

                //Ocurrió un guardado, así que se reinicia el autoguardado
                c = 0;
                System.out.println("Contador reiniciado creando nuevo archivo, CON extensión escrita");

                //No hay cambios después de guardar
                cambios = false;

            } //El nombre dado no contiene extension
            else if (!ruta2.toString().contains(".py")) {
                System.out.println("No existe archivo, no se escribe extensión, se agrega automáticamente");

                //Crear el nuevo archivo con la extensión (porque NO se dio)
                try (FileWriter nuevoArchivo = new FileWriter(ruta + ".py")) {

                    //Obtener el texto a guardar
                    nuevoArchivo.write(area_codigo.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                //Se activa la variable para indicar que se guardó un archivo y se está
                //posicionado sobre ese archivo
                cargo_archivo = true;

                //Se deshabilita el botón guardar hasta que haya un nuevo cambio
                menu_guardar.setEnabled(false);

                //Obtener la ruta del archivo
                File archC = guardar_como.getSelectedFile(); //Obtenemos el archivo guardado

                //Obtener el nombre del archivo para ponerlo en el frame
                //Recordar que en este caso se escribió la existensión así que
                //el nombre de archivo se coloca en el título del frame como tal             
                nombre = archC.getName();
                this.setTitle("PYTHON - " + nombre + ".py");

                //Esto es importante, ya que es el primer guardado
                //y posiblemente haya saltos de línea
                //El 'guardar como' no hace esto, pero el sobreescribir sí
                //entonces, se realiza un guardado en un nuevo archivo y
                //posteriormente se ejecuta un sobreescribir con el mismo código
                //de esta manera se guardan los espacios correctamente
                sobreescribirg();
                System.out.println("No reemplazar, crear archivo, primer guardado con salto de linea");

                //Ocurrió un guardado, así que se reinicia el autoguardado
                c = 0;
                System.out.println("Contador reiniciado creando nuevo archivo, SIN extensión escrita");

                //No hay cambios después de guardar
                cambios = false;

            }

        }

    }



    private void menu_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_imprimirActionPerformed
//
//        //BOTÓN IMPRIMIR
//        //No toqué esta parte y quizá no se llegue a utilizar, solo a comentar
//        //o algo así, funcionaba así que, nada que decir
//        String Cabeza = "Par Ordenado";
//        String Pie = "MPL";
//        try {
//
//            MessageFormat header = new MessageFormat(Cabeza);
//            MessageFormat footer = new MessageFormat(Pie);
//     ////////////////////////////////####################3###############################################################################################################
//            area_salida.print(header, footer, true, null, null, true);
//        } catch (PrinterException ex) {
//            Logger.getLogger(Sintactico.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_menu_imprimirActionPerformed

    private void nuevo_proyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_proyectoActionPerformed

        //Sólo se puede tener una ventana de inicio abierta, si el límite de inicios
        //es falso, es decir que NO HAY NINGUNA, y la crea
        if (Inicio.limiteinicio == false) {
            Inicio ini = new Inicio();
            ini.setVisible(true);
            Inicio.limiteinicio = true;
        } //Por otro lado, si ya hay un inicio, se pide utilizar esa ventana
        else {
            JOptionPane.showMessageDialog(null, "Selecciona una opción del inicio");
        }
    }//GEN-LAST:event_nuevo_proyectoActionPerformed

    private void menu_guardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarcomoActionPerformed

        //MENU ITEM QUE EJECUTA EL MÉTODO 'GUARDAR COMO'
        guardarArchivo();

    }//GEN-LAST:event_menu_guardarcomoActionPerformed

    private void menu_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_salirActionPerformed

        //MENU ITEM QUE EJECUTA EL MÉTODO 'CERRAR'
        cerrar();
    }//GEN-LAST:event_menu_salirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        //AL DAR CLIC EN LA X ROJA PARA SALIR, SE EJECUTA EL MÉTODO 'CERRAR
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void area_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_area_codigoKeyTyped

        //En esta área se definen las teclas que al tipeadas activan el botón 'guardar'
        //es decir, que se realizan cambios en el área de código que podrán ser guardados
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_A: //A 
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_B: //B
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_C: //C
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_D: //D
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_E: //E
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_F: //F
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_G: //G
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_H: //H
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_I: //I
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_J: //J
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_K: //K
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_L: //L
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_M: //M
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_N: //N
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_O: //O
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_P: //P
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_Q: //Q
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_R: //R
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_S: //S
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_T: //T
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_U: //u
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_V: //V
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_W: //W
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_X: //X
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_Y: //Y
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_Z: //Z
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_0: //0
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_1: //1
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_2: //2
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_3: //3
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_4: //4
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_5: //5
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_6: //6
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_7: //7
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_8: //8
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_9: //9
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD0: //0 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD1: //1 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD2: //2 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD3: //3 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD4: //4 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD5: //5 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD6: //6 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD7: //7 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD8: //8 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_NUMPAD9: //9 TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_ENTER: //ENTER
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_SPACE: //ESPACIO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_MINUS: //MENOS, GUION
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_COMMA: //COMA
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_PLUS: //MAS, TECLADO ALFANUMMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_BRACELEFT: //LLAVE IZQUIERDA
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_BRACERIGHT: //LLAVE DERECHA
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_QUOTE: //COMILLA SIMPLE
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_PERIOD: //PUNTO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_ADD: // MAS, TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_DECIMAL: //PUNTO DECIMAL, TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_DIVIDE: //DIVISION, TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_MULTIPLY: //MULTIPLICAR, TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_SUBTRACT: //RESTA, TECLADO NUMERICO
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
            case KeyEvent.VK_UNDEFINED: //SIMBOLOS SIN DEFINIR: Ñ,|,°,¿,¡,¬
                menu_guardar.setEnabled(true);
                cambios = true;
                break;
        }

        //Al presionar ENTER se aumenta el contador de línea en 1
        char tecla = evt.getKeyChar();

        if ((int) tecla == KeyEvent.VK_ENTER) {
            numeroLinea++;
            String num = area_lineas.getText() + '\n' + numeroLinea;
            area_lineas.setText(num);
        }

        if ((int) tecla == KeyEvent.VK_BACK_SPACE || (int) tecla == KeyEvent.VK_DELETE) {

            //Se obtiene el código del TextArea
            //Si está vacío, al dar un BACKSPACE, no se puede guardar
            String lectura = area_codigo.getText();
            if (lectura.isEmpty()) {
                menu_guardar.setEnabled(false);
                cambios = false;
            } //En cambio, si tiene algo y aún queda otro algo, se pueden guardar cambios
            //porque se hicieron modificaciones (borrar líneas de código, por ejemplo)
            else {
                menu_guardar.setEnabled(true);                cambios = true;
            }

            //El while es por si se eliminan varias lineas a la vez
            while (numeroLinea > area_codigo.getLineCount()) {
                String num = area_lineas.getText();

                //Cuando el numero de lineas es solo un digito
                if (area_codigo.getLineCount() < numeroLinea) {
                    if (numeroLinea < 10) {
                        num = num.substring(0, num.length() - 2);
                        area_lineas.setText(num);
                        numeroLinea--;
                    }
                    //Cuando el numero de lineas son dos digitos
                    if (numeroLinea > 9 && numeroLinea < 100) {
                        num = num.substring(0, num.length() - 3);
                        area_lineas.setText(num);
                        numeroLinea--;
                    }
                    //Cuando el numero de lineas son 3 digidos
                    if (numeroLinea > 99 && numeroLinea < 1000) {
                        num = num.substring(0, num.length() - 4);
                        area_lineas.setText(num);
                        numeroLinea--;
                    }
                }
            }
        }
        //Por si se pegan varias lineas a la vez
        if ((int) tecla == 22) {
            while (numeroLinea < area_codigo.getLineCount()) {
                numeroLinea++;
                String num = area_lineas.getText() + '\n' + numeroLinea;
                area_lineas.setText(num);
            }
        }

    }//GEN-LAST:event_area_codigoKeyTyped

    private void abrir_proyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir_proyectoActionPerformed

        if (this.getTitle().contains(".py")){
        
            //Se pregunta si se desea guardar antes de abrir
            Object[] opciones = {"Sí", "No"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "Guardar antes de abrir?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Sí");
            
            //Si se desea limpiar, entra aquí
            if (eleccion == JOptionPane.YES_OPTION){
            
   
                sobreescribirg();
                
            }
        
           metodo_abrir();
        
        }
        
        else if (!this.getTitle().contains(".py")){
        
           metodo_abrir(); 
        
        }

    }//GEN-LAST:event_abrir_proyectoActionPerformed

    
    private void metodo_abrir(){
    
    //MÉTODO ABRIR
        try {

            //Se obtiene el nuevo archivo con un filtro de extensión
            StringBuilder brinco = new StringBuilder();
            guardar_como.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Archivo PYTHON", "py");
            guardar_como.setFileFilter(filtro2);

            int n = guardar_como.showOpenDialog(this);

            //Si se quiso abrir el archivo, se entra aquí
            if (n == JFileChooser.APPROVE_OPTION) {

                //IMPORTANTE: Al abrir un archivo no se carga como tal, por lo cual
                //se debe crear uno nuevo, con dicho nombre y ruta
                File ruta = guardar_como.getSelectedFile();
                ruta2 = ruta;
                System.out.println("Se creó un file al abrir para crear un objeto");

                //Este es el archivo que se abre, por lo cual se obtiene el nombre
                //ATENCIÓN: Este es el archivo que se abrió, pero digamos que
                //se almacena en el que se creó un poco más arriba
                File archivo = guardar_como.getSelectedFile();
                String nombre = archivo.getName();
                System.out.println("Archivo .py abierto");

                //Se verifica si el nombre del archivo contiene .mpl (para que sea válido)
                if (!archivo.toString().contains(".py")) {
                    nombreArchivo = archivo + ".py";
                }

                //Entonces se pone dicho nombre en el título de la ventana, sin agregar nada
                this.setTitle(nombre);
                String nomArchi = guardar_como.getSelectedFile().getAbsolutePath();
                //Se muestra el nombre del archivo válido abierto
                System.out.println("Archivo: " + nomArchi);
                BufferedReader br = new BufferedReader(new FileReader(nomArchi));

                do {
                    brinco.append(br.readLine()).append("\n");

                } while (br.ready());

                area_codigo.setText(brinco.toString());

                //Automáticamente al abrir y crear un archivo donde se almacena
                //se da por hecho que se cargó un archivo
                cargo_archivo = true;
            }

            //Se obtiene el numero de lineas agregadas, y se añaden al contador de líneas
            while (numeroLinea < area_codigo.getLineCount()) {
                numeroLinea++;
                String num = area_lineas.getText() + '\n' + numeroLinea;
                area_lineas.setText(num);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    
    
    }
    
    
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        //MENU ITEM LIMPIAR
        //Si no hay nada de nada, no se puede limpiar
        if (area_codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay nada que limpiar!");
        } //En cambio, si hay algo, por mucho o poco que sea, se procede a limpiar
        else if (!area_codigo.getText().equals("")) {

            System.out.println("Solo limpia y desactiva el guardar");

            //El TextArea queda vacío, por lo tanto no se podrá guardar hasta que hayan cambios
            menu_guardar.setEnabled(false);
            cambios = false;

            //LIMPIAR 
            //Poner todas las áreas de código y salida vacías, y el contador de líneas en 1
            area_codigo.setText("");
  //          ############################################################################################################################################333##
            area_salida.setText("");
            area_salida2.setText("");
            area_salida1.setText("");
            area_lineas.setText("1");

            while (numeroLinea > area_codigo.getLineCount()) {
                String num = area_lineas.getText();

                //Cuando el numero de lineas es solo un digito
                if (area_codigo.getLineCount() < numeroLinea) {

                    if (numeroLinea < 10) {
                        num = "";
                        area_lineas.setText(num);
                        numeroLinea--;
                        numeroLinea = 1;
                    }

                    if (numeroLinea > 9 && numeroLinea < 100) {
                        num = "";
                        area_lineas.setText(num);
                        numeroLinea--;
                        numeroLinea = 1;
                    }

                    if (numeroLinea > 99 && numeroLinea < 1000) {
                        num = "";
                        area_lineas.setText(num);
                        numeroLinea--;
                        numeroLinea = 1;
                    }

                }
                area_lineas.setText("1");
            }

            //FIN DE LA LIMPIEZA
        }


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menu_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_manualActionPerformed

        //MENU ITEM PARA ABRIR EL MANUAL
           if(evt.getSource()==menu_manual){
        try{
        Desktop.getDesktop().browse(new URI("Manual_MPL.pdf"));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"No se ha localizado el archivo. ");
        }
        }
        
    }//GEN-LAST:event_menu_manualActionPerformed

    private void menu_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_compilarActionPerformed

      //MENU ITEM PARA COMPILAR, QUE TENDRÁ VARIAS OPCIONES
        //Opción 1. No se escribe absolutamente nada, se manda un mensaje indicando esto
        if (area_codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Escribe algo para analizar!");
        } //Opción 2. Se escribe algo, cualquier cosa, se procede a analizar de dos maneras
        else if (!area_codigo.getText().equals("")) {

            //El botón compilar preguntará antes de ejecutarse
            Object[] opciones = {"Sí", "No"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "Guardar antes de analizar?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Sí");
            
            //Sí desea guardar antes de compilar
            if (eleccion == JOptionPane.YES_OPTION) {
            
                if (this.getTitle().contains(".py")) {
                     
                    sobreescribirg();
                    System.out.println("Sobreescribir y compilar si ya existe un archivo");
                    
                    c=0;
                    System.out.println("Contador de autoguardado reiniciado");
                    
                    compilar();

                    //Ocurrió un guardado así que se desactiva el 'guardar' hasta que haya cambios
                    menu_guardar.setEnabled(false);

                    cambios = false;    
                    
                }
                
                else if (!this.getTitle().contains(".py")){

                    guardarArchivo();
                    System.out.println("Guardar como y compilar");
                    
                    compilar();  

                }      
            
            }
            
            
            //No se quiere guardar antes de compilar
            else{
            
                System.out.println("Compilar sin guardar (análisis rápido)");
                
                compilar();
                
            }
            
        }

    }//GEN-LAST:event_menu_compilarActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here

        //Este creo que era el de la información de nosotros
        //y no se borró correctamente, hay que quitarlo...
        //QUIZÁ ME EQUIVOCO Y ES ALGÚN MENU ITEM QUE NO SE HA TOCADO

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menu_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarActionPerformed

        //Se procede a guardar así que se reinicia el contador para el autoguardado
        c = 0;
        System.out.println("Reiniciar contador de autoguardado sin importar la sobreescritura");

        //EL GUARDADO NORMAL PODRÁ SER DISTINTOS TIPOS
        //Si ya hay un archivo cargado, se sobreescribirá
        if (cargo_archivo) {

            sobreescribirg();
            System.out.println("Guardar - Archivo existente");

            //Ocurrió un guardado así que se deshabilita el guardado hasta que hayan cambios
            menu_guardar.setEnabled(false);
            cambios = false;

        } else {

            //En cambio, si se utiliza guardar y no hay un archivo cargado, se realizará
            //un 'guardar como' para especificar un archivo nuevo
            System.out.println("Guardar - Archivo nuevo");

            int seleccion = guardar_como.showSaveDialog(this);

            //Si hacemos clic en que SÍ se quiere guardar entonces habrá opciones:
            if (seleccion == JFileChooser.APPROVE_OPTION) {

                //Se obtiene la ruta del fichero
                File ruta = guardar_como.getSelectedFile();
                ruta2 = ruta;

                //El nombre dado ya contiene extension
                if (ruta2.toString().contains(".py")) {
                    System.out.println("Se escribió la extensión");
                    System.out.println("Primer guardado con salto de linea");

                    //Se escribió la extensión manualmente así que no se añade nada
                    try (FileWriter nuevoArchivo = new FileWriter(ruta)) {

                        //Se obtiene el texto a guardar en el archivo que se creará
                        nuevoArchivo.write(area_codigo.getText() + "\n");

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    //Automáticamente se estará trabajando sobre ese archivo, así que se carga
                    cargo_archivo = true;

                    //Además, se deshabilita el guardado hasta que hayan cambios
                    menu_guardar.setEnabled(false);

                    //Se obtendrá el archivo y posteriormente su nombre
                    //para ponerlo en el título de la ventana
                    File archC = guardar_como.getSelectedFile();
                    nombre = archC.getName();

                    //Se escribió la extensión al inicio así que no se agrega nada
                    this.setTitle("PYTHON - " + nombre);
                    System.out.println("Se escribió extensión, no se agrega al título");

                    //Se sobreescribe el archivo
                    sobreescribirg();

                    //No hay cambios
                    cambios = false;

                    //Se reinicia el contador del autoguardado
                    c = 0;
                    System.out.println("Contador reiniciado");

                } //El nombre dado no contiene extension
                else if (!ruta2.toString().contains(".py")) {

                    //Se escribirá en el archivo añadiendo la extensión porque NO se puso
                    try (FileWriter nuevoArchivo = new FileWriter(ruta + ".py")) {

                        //Se obtiene el texto a guardar en el archivo que se creará
                        nuevoArchivo.write(area_codigo.getText());

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    //Automáticamente se estará trabajando sobre ese archivo, así que se carga
                    cargo_archivo = true;

                    //Además, se deshabilita el guardado hasta que hayan cambios
                    menu_guardar.setEnabled(false);

                    //Se obtendrá el archivo y posteriormente su nombre
                    //para ponerlo en el título de la ventana
                    File archC = guardar_como.getSelectedFile();
                    nombre = archC.getName();

                    //NO se escribió la extensión al inicio así que se agrega al título
                    this.setTitle("PYTHON - " + nombre + ".py");
                    System.out.println("No se escribió extensión, agregada");

                    //Se sobre escribe el archivo
                    sobreescribirg();

                    //No hay cambios
                    cambios = false;

                    //Se reinicia el contador del autoguardado
                    c = 0;
                    System.out.println("Contador reiniciado");

                }

            }
        }

    }//GEN-LAST:event_menu_guardarActionPerformed

    private void area_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_area_codigoKeyPressed
        // TODO add your handling code here:

        //ESTO ES PARA EL AUTOGUARDADO
        //IMPORTANTE: Ya existe un KeyTyped con todas las teclas
        //sin embargo, no se reconocían las teclas para el contador
        //Así que, utilicé un KeyPressed que es SIMILAR y funciona
        //para esta tarea
        //Se captura el evento de cada tecla y se aumenta el contador en 1
        //por cada tecla DEFINIDA que se presiona
        //Además se llama el método en cada tecla para que cuando se
        //presione CUALQUIER TECLA pueda activar el método 'autoguardado'
        //DEFINICIÓN DE LAS TECLAS
        if (evt.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Letra A");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_B) {
            System.out.println("Letra B");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_C) {
            System.out.println("Letra C");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("Letra D");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_E) {
            System.out.println("Letra E");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_F) {
            System.out.println("Letra F");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_G) {
            System.out.println("Letra G");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_H) {
            System.out.println("Letra H");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_I) {
            System.out.println("Letra I");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("Letra J");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_K) {
            System.out.println("Letra K");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_L) {
            System.out.println("Letra L");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_M) {
            System.out.println("Letra M");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_N) {
            System.out.println("Letra N");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_O) {
            System.out.println("Letra O");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_P) {
            System.out.println("Letra P");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_Q) {
            System.out.println("Letra Q");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_R) {
            System.out.println("Letra R");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("Letra S");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_T) {
            System.out.println("Letra T");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_U) {
            System.out.println("Letra U");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Letra V");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Letra W");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_X) {
            System.out.println("Letra X");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_Y) {
            System.out.println("Letra Y");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_Z) {
            System.out.println("Letra Z");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_0) {
            System.out.println("Número 0");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_1) {
            System.out.println("Número 1");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_2) {
            System.out.println("Número 2");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_3) {
            System.out.println("Número 3");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_4) {
            System.out.println("Número 4");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_5) {
            System.out.println("Número 5");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_6) {
            System.out.println("Número 6");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_7) {
            System.out.println("Número 7");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_8) {
            System.out.println("Número 8");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_9) {
            System.out.println("Número 9");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD0) {
            System.out.println("NumPad 0");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            System.out.println("NumPad 1");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            System.out.println("NumPad 2");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            System.out.println("NumPad 3");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            System.out.println("NumPad 4");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD5) {
            System.out.println("NumPad 5");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            System.out.println("NumPad 6");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD7) {
            System.out.println("NumPad 7");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD8) {
            System.out.println("NumPad 8");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            System.out.println("NumPad");
            c++;
            auto_guardado();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Enter");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Espacio");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_MINUS) {
            System.out.println("Minus");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_COMMA) {
            System.out.println("Coma");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_PLUS) {
            System.out.println("Plus");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_BRACELEFT) {
            System.out.println("Braceleft");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_BRACERIGHT) {
            System.out.println("Braceright");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_QUOTE) {
            System.out.println("Cita");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_PERIOD) {
            System.out.println("Period");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ADD) {
            System.out.println("Add");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_DECIMAL) {
            System.out.println("Decimal");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_DIVIDE) {
            System.out.println("Dividir");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_MULTIPLY) {
            System.out.println("Multiplicar");
            c++;
            auto_guardado();
        }

        if (evt.getKeyCode() == KeyEvent.VK_UNDEFINED) {
            System.out.println("Símbolos indefinidos");
            c++;
            auto_guardado();
        }

        //FIN DE LA DEFINICIÓN DE LAS TECLAS

    }//GEN-LAST:event_area_codigoKeyPressed

    private void boton_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cerrarActionPerformed

        //BOTÓN CERRAR DE LA INTERFAZ QUE EJECUTA EL MÉTODO 'CERRAR'
        cerrar();
    }//GEN-LAST:event_boton_cerrarActionPerformed

    private void boton_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_limpiarActionPerformed

        //BOTÓN LIMPIAR
        //Si no hay nada de nada, no se puede limpiar
        if (area_codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay nada que limpiar!");
        } //En cambio, si hay algo, por mucho o poco que sea, se procede a limpiar
        else if (!area_codigo.getText().equals("")) {

            //El botón limpiar preguntará antes de ejecutarse
            Object[] opciones = {"Sí", "No"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "Realmente desea limpiar?", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Sí");

            //Si se desea limpiar, entra aquí
            if (eleccion == JOptionPane.YES_OPTION) {

                System.out.println("Solo limpia y desactiva el guardar");

                //El TextArea queda vacío, por lo tanto no se podrá guardar hasta que hayan cambios
                menu_guardar.setEnabled(false);
                cambios = false;

                //LIMPIAR
                //Poner todas las áreas de código y salida vacías, y el contador de líneas en 1
                area_codigo.setText("");
                area_salida.setText("");
                area_salida2.setText("");
                area_salida1.setText("");
                //##############################################################################################################3
                area_lineas.setText("1");

                while (numeroLinea > area_codigo.getLineCount()) {
                    String num = area_lineas.getText();

                    //Cuando el numero de lineas es solo un digito
                    if (area_codigo.getLineCount() < numeroLinea) {

                        if (numeroLinea < 10) {
                            num = "";
                            area_lineas.setText(num);
                            numeroLinea--;
                            numeroLinea = 1;
                        }

                        if (numeroLinea > 9 && numeroLinea < 100) {
                            num = "";
                            area_lineas.setText(num);
                            numeroLinea--;
                            numeroLinea = 1;
                        }

                        if (numeroLinea > 99 && numeroLinea < 1000) {
                            num = "";
                            area_lineas.setText(num);
                            numeroLinea--;
                            numeroLinea = 1;
                        }

                    }
                    area_lineas.setText("1");
                }

                c=0;
                System.out.println("Contador del autoguardado reiniciado");

                //FIN DE LA LIMPIEZA

            }

            //Si no se desea limpiar, se cierra el cuadro de diálogo solamente
            else{

            }

        }
    }//GEN-LAST:event_boton_limpiarActionPerformed

    private void boton_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_compilarActionPerformed

        //BOTÓN PARA COMPILAR, QUE TENDRÁ VARIAS OPCIONES
        //Opción 1. No se escribe absolutamente nada, se manda un mensaje indicando esto
        if (area_codigo.getText().equals("")) 
            JOptionPane.showMessageDialog(null, "Escribe algo para analizar!");
         
        else {
            
            System.out.println("Compilando archivo ...");
            compilar();
        }

    }//GEN-LAST:event_boton_compilarActionPerformed

    public void auto_guardado() {

        //Este es un método que se manda a llamar en cada tecla
        //El contador se va incrementando con cada tecla hasta que llega a la
        //cantidad especificada y alguna tecla (cualquiera definida) lo activa,
        //esto hace que el archivo se sobreescriba si ya está cargado
        //además reinicia el contador para un posterior autoguardado
        //Se realiza en un archivo válido ya cargado, por lo tanto la condición
        //es que la ventana contenga la extensión .mpl y no un nuevo proyecto
        if (this.getTitle().contains(".py")) {
            if (c >= 20) {
                sobreescribirg();
                c = 0;
                System.out.println("Autoguardado exitoso");
                System.out.println("Contador reiniciado");
            }

        } //Si no hay un archivo cargado, no hay donde autoguardar, así que
        //solo se reinicia el contador
        else if (c >= 20 && !this.getTitle().contains(".py")) {
            c = 0;
            System.out.println("No hay donde guardar");
            System.out.println("Contador reiniciado");

        }
    }

    private void sobreescribirg() {

        //NOTA: Este método se utiliza para el primer guardado (de cualquier tipo)
        //y posteriormente para sobreescribir, esto es porque captura el texto
        //tal y como se busca (con espacios y saltos de línea)
        //El sobreescribir se ejecuta de dos maneras       
        //UNO. Si el archivo ya contiene .mpl
        if (ruta2.toString().contains(".py")) {

            try {

                //Se obtiene el texto y se le asigna a un string
                System.out.println("El nombre de archivo sobreescrito ya contiene .py (obviamente, ya que es un archivo válido)");
                String[] code = area_codigo.getText().split("\n");

                //Se crea un nuevo archivo, como se escribió la extensión, no se agrega nada
                File documento = new File(ruta2.toString());

                //Se escribe sobre el archivo lo que se capture
                PrintWriter pw;
                pw = new PrintWriter(documento);

                for (int i = 0; i < code.length; i++) {
                    pw.println(code[i]);
                }

                System.out.println("Éxito, al guardar-sobreescribir archivo nuevo CON .mpl inicial");
                pw.flush();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Python.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //DOS. El archivo no contiene .mpl
        if (!ruta2.toString().contains(".py")) {

            try {

                //Se obtiene el texto y se le asigna a un string
                System.out.println("El nombre de archivo sobreescrito no contiene .mpl, pero se guarda con sobreescribir");
                String[] code = area_codigo.getText().split("\n");

                //Se crea un nuevo archivo, como NO se escribió la extensión, se agrega
                File documento = new File(ruta2.toString() + ".py");

                //Se escribe sobre el archivo lo que se capture
                PrintWriter pw;
                pw = new PrintWriter(documento);

                for (int i = 0; i < code.length; i++) {
                    pw.println(code[i]);
                }
                System.out.println("Éxito, al guardar-sobreescribir archivo nuevo SIN .py inicial");
                pw.flush();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Python.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /* Este metodo debera atrapar las excepciones en lugar de lanzarlas */
    public void compilar(){
        
        area_salida1.setText("");
        
        try {

            //Este método es el que realiza el análisis léxico
            String ObtenerTexto = area_codigo.getText();
            InputStream ToInputStream = new ByteArrayInputStream(ObtenerTexto.getBytes(Charset.forName("UTF-8")));
            compilador = new Python(ToInputStream);

            Python.tabletokens.clear();

            //Aquí es donde se inicializan los tokens
            compilador.Start();
            

            //Método que pone la tabla de tokens en el área de salida
            mostrarResultado();

            JOptionPane.showMessageDialog(null, "Fin del análisis");

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////    
        
        try {

            //Este método es el que realiza el análisis léxico
            String ObtenerTexto = area_codigo.getText();
            InputStream ToInputStream = new ByteArrayInputStream(ObtenerTexto.getBytes(Charset.forName("UTF-8")));
            compilador = new Python(ToInputStream);

            Python.tabletokens.clear();

            //Aquí es donde se inicializan los tokens
            compilador.principal();

           area_salida1.setText("Compilación exitosa");

        } catch (ParseException ex) {
            
            //Aquí se manda al area de salida la excepción que atrapa los errores en el análisis
            area_salida1.setText(ex.getMessage());

        }
        
       
    
        
        
        
        
        
        
        
    }

    private void mostrarResultado() {
        String resultado = "";

        for (String tabletokens : Python.tabletokens) {
            resultado += tabletokens + "\n";
        }
///#####################################################################################################################################################################
        area_salida.setText(resultado);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Sintactico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Sintactico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Sintactico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Sintactico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Sintactico().setVisible(true);
//            }
//        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_salida;
    private javax.swing.JPanel Panelgral;
    private javax.swing.JMenuItem abrir_proyecto;
    private javax.swing.JTextArea area_codigo;
    private javax.swing.JTextArea area_lineas;
    private javax.swing.JTextArea area_salida;
    private javax.swing.JTextArea area_salida1;
    private javax.swing.JTextArea area_salida2;
    private javax.swing.JButton boton_cerrar;
    private javax.swing.JButton boton_compilar;
    private javax.swing.JButton boton_limpiar;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem menu_compilar;
    private javax.swing.JMenuItem menu_guardar;
    private javax.swing.JMenu menu_guardar_como;
    private javax.swing.JMenuItem menu_guardarcomo;
    private javax.swing.JMenuItem menu_imprimir;
    private javax.swing.JMenuItem menu_manual;
    private javax.swing.JMenuItem menu_salir;
    private javax.swing.JMenuItem nuevo_proyecto;
    // End of variables declaration//GEN-END:variables
}
