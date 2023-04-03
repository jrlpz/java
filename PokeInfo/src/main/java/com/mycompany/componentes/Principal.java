/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.componentes;

import static com.mycompany.json.LeerJSON.leerPokemon;
import static com.mycompany.json.LeerJSONName.leerNombres1;
import conexionHTTP.PokeAPIExample;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Name;
import model.Pokemon;
import model.Results;

/**
 *
 * @author javir
 */
public class Principal extends javax.swing.JFrame {

    Pokemon pokemon;
    Name name;
    Results results;

    public Principal() throws IOException {

        initComponents();
        File file = new File("nombres.json");
        File file2 = new File("pokemon.json");
        if (file.exists()) {
        } else {
            PokeAPIExample.leer2();
        }
        if (file.exists()) {
        } else {
            PokeAPIExample.leer("pikachu");

        }

        leerListaNombres();
        pintarLabel("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/poke-ball.png");
        jComboBox1.setSelectedIndex(-1);
        if (jComboBox1.getSelectedIndex() == -1) {
            jNombre.setText("");
            jAlto.setText("");
            jPeso.setText("");
            jNumero.setText("");
            jRadioFront.setText("Sprite");
            jRadioNormal.setText("Pokeball");
            JRadioBack.setText("HD");
            JRadioShiny.setText("Master");
        } else {
            //  leerFichero();
            pokemon = leerPokemon();
            //para marcar por defecto esa opcion
            jRadioFront.setSelected(true);
            jRadioNormal.setSelected(true);
            jRadioFront.setSelected(true);
            jRadioNormal.setSelected(true);
            //llamamos a la imagen

        }
    }

    private void leerListaNombres() {
        try {
            results = leerNombres1();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Pokemon pk : results.getResults()) {
            jComboBox1.addItem(pk.getName());

        }
    }

    private void leerFichero() {

        String seleccionado = (String) jComboBox1.getSelectedItem();
        try {
            PokeAPIExample.leer(seleccionado);
            PokeAPIExample.leer2();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error IMAGEN", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void pintarLabel(String path) throws NullPointerException {
        if (jComboBox1.getSelectedIndex() == -1) {

            try {

                if (jRadioFront.isSelected()) {

                    if (jRadioNormal.isSelected()) {
                        path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/poke-ball.png";
                    } else if (JRadioShiny.isSelected()) {
                        path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/master-ball.png";
                    }

                }

                if (JRadioBack.isSelected()) {

                    if (jRadioNormal.isSelected()) {
                        path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/dream-world/poke-ball.png";
                    } else if (JRadioShiny.isSelected()) {
                        path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/dream-world/master-ball.png";
                    }
                    // path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/dream-world/poke-ball.png";
                }

                URL url = new URL(path);
                ImageIcon imageIcon = new ImageIcon(url);
                imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));

                // Crear un JLabel con el ImageIcon
                jlImagen.setIcon(imageIcon);
                jlImagen.setHorizontalAlignment(JLabel.CENTER);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {

                //URL url = new URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
                String seleccionado = (String) jComboBox1.getSelectedItem();
                URL url = new URL(path);
                ImageIcon imageIcon = new ImageIcon(url);
                imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));

                // Crear un JLabel con el ImageIcon
                jlImagen.setIcon(imageIcon);
                jlImagen.setHorizontalAlignment(JLabel.CENTER);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jlImagen = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jNombre = new javax.swing.JTextField();
        jRadioFront = new javax.swing.JRadioButton();
        JRadioBack = new javax.swing.JRadioButton();
        jAlto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPeso = new javax.swing.JTextField();
        jNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jRadioNormal = new javax.swing.JRadioButton();
        JRadioShiny = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBuscarTexto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokemon");
        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(560, 380));
        setResizable(false);

        jlImagen.setBackground(new java.awt.Color(204, 204, 204));
        jlImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlImagen.setOpaque(true);

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setToolTipText("Selecciona el pokemon deseado para ver sus datos.");
        jComboBox1.setBorder(null);
        jComboBox1.setPreferredSize(new java.awt.Dimension(92, 23));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jNombre.setEditable(false);
        jNombre.setBackground(new java.awt.Color(204, 204, 204));

        buttonGroup1.add(jRadioFront);
        jRadioFront.setText("Frontal");
        jRadioFront.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFrontActionPerformed(evt);
            }
        });

        buttonGroup1.add(JRadioBack);
        JRadioBack.setText("Espalda");
        JRadioBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRadioBackActionPerformed(evt);
            }
        });

        jAlto.setEditable(false);
        jAlto.setBackground(new java.awt.Color(204, 204, 204));
        jAlto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAltoActionPerformed(evt);
            }
        });

        jLabel1.setText("Altura");

        jLabel2.setText("Nombre");

        jLabel3.setText("Peso");

        jPeso.setEditable(false);
        jPeso.setBackground(new java.awt.Color(204, 204, 204));
        jPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPesoActionPerformed(evt);
            }
        });

        jNumero.setEditable(false);
        jNumero.setBackground(new java.awt.Color(204, 204, 204));
        jNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNumeroActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Nº Pokedex");

        btnReset.setBackground(new java.awt.Color(204, 204, 204));
        btnReset.setText("Reiniciar");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioNormal);
        jRadioNormal.setText("Normal");
        jRadioNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNormalActionPerformed(evt);
            }
        });

        buttonGroup2.add(JRadioShiny);
        JRadioShiny.setText("Shiny");
        JRadioShiny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRadioShinyActionPerformed(evt);
            }
        });

        jLabel5.setText("metros");

        jLabel6.setText("kilos");

        jBuscarTexto.setToolTipText("Introduce un nombre");
        jBuscarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarTextoActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 238, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html> Pulsa sobre el desplegable  <br> o utiliza el  buscador para <br> ver los datos de un  Pokemon</html>");
        jLabel7.setAlignmentX(0.5F);
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), null));
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioFront, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JRadioBack, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JRadioShiny, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jNombre)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPeso)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6))
                                .addComponent(jNumero)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jAlto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jBuscarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))))
                .addGap(0, 311, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAlto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioFront)
                            .addComponent(jRadioNormal))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JRadioBack)
                            .addComponent(JRadioShiny))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBuscarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedIndex() == -1) {

        } else {
            jRadioFront.setText("Frontal");
            jRadioNormal.setText("Normal");
            JRadioBack.setText("Espalda");
            JRadioShiny.setText("Shiny");
            try {
                String seleccionado = (String) jComboBox1.getSelectedItem();
                // Pintamos la seleccion de jComboBox, getSelected ->  index o items es diferente
                jNombre.setText(seleccionado);

                leerFichero();
                pokemon = leerPokemon();
                String path = pokemon.getSprites().getFront_default();

                try {

                    if (path != null && !path.isEmpty()) {
                        pintarLabel(path);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NullPointerException ex) {
                    System.out.println("error");
                }

                //pasar de gramos a kg
                double pesoD = pokemon.getWeight();
                String peso = Double.toString(pesoD);
                DecimalFormat df = new DecimalFormat("#,##0.0");
                String resultado = df.format(pesoD / 10);
                //pasar de cm a metros
                double alturaD = pokemon.getHeight();
                String altura = Double.toString(pesoD);
                String resultado1 = df.format(alturaD / 10);

                jAlto.setText(resultado1);
                jPeso.setText(resultado);
                jNumero.setText(String.valueOf(pokemon.getOrder()));
                jRadioFront.setSelected(true); //para marcar por defecto esa opcion
                jRadioNormal.setSelected(true); //par amarcar por defecto esa opcion
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void JRadioBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRadioBackActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedIndex() == -1) {
            String path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/dream-world/poke-ball.png";
            pintarLabel(path);

        } else {
            String seleccionado = (String) jComboBox1.getSelectedItem();
            if (jRadioNormal.isSelected()) {
                String path = pokemon.getSprites().getBack_default();
                if (path != null && !path.isEmpty()) {
                    pintarLabel(path);
                } else {
                    JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                jRadioNormal.setSelected(true);
            } else {
                String path = pokemon.getSprites().getBack_shiny();
                if (path != null && !path.isEmpty()) {
                    pintarLabel(path);
                } else {
                    JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                JRadioShiny.setSelected(true);
            }

        }
    }//GEN-LAST:event_JRadioBackActionPerformed

    private void jAltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAltoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jAltoActionPerformed

    private void jRadioFrontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioFrontActionPerformed
        if (jComboBox1.getSelectedIndex() == -1) {
            String path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/gen5/poke-ball.png";
            pintarLabel(path);
        } else {
            try {
                // TODO add your handling code here:
                String seleccionado = (String) jComboBox1.getSelectedItem();
                leerFichero();
                pokemon = leerPokemon();

                if (jRadioNormal.isSelected()) {
                    String path = pokemon.getSprites().getFront_default();

                    if (path != null && !path.isEmpty()) {
                        pintarLabel(path);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                    jRadioNormal.setSelected(true);
                } else {
                    String path = pokemon.getSprites().getFront_shiny();
                    if (path != null && !path.isEmpty()) {
                        pintarLabel(path);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    JRadioShiny.setSelected(true);
                }
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jRadioFrontActionPerformed

    private void jNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNumeroActionPerformed

    }//GEN-LAST:event_jNumeroActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        jRadioFront.setText("Sprite");
        jRadioNormal.setText("Pokeball");
        JRadioBack.setText("HD");
        JRadioShiny.setText("Master");
        jNombre.setText("");
        jBuscarTexto.setText("");
        String path = pokemon.getSprites().getFront_default();
        jAlto.setText("");
        jPeso.setText("");
        jNumero.setText("");
        pintarLabel("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/poke-ball.png");
        jRadioNormal.setSelected(true);
        jRadioFront.setSelected(true);
        jComboBox1.setSelectedIndex(-1);
        pintarLabel(path);
    }//GEN-LAST:event_btnResetActionPerformed

    private void jRadioNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNormalActionPerformed
        if (jComboBox1.getSelectedIndex() == -1) {
            String path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/poke-ball.png";
            pintarLabel(path);
        } else {
            String path;

            if (jRadioFront.isSelected()) {
                try {
                    path = pokemon.getSprites().getFront_default();
                } catch (NullPointerException e) {
                    // Manejar la excepción aquí
                    path = "ruta/por/defecto.png";
                }
                if (path != null && !path.isEmpty()) {
                    pintarLabel(path);
                } else {
                    JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    path = pokemon.getSprites().getBack_default();
                } catch (NullPointerException e) {
                    // Manejar la excepción aquí
                    path = "ruta/por/defecto.png";
                }
                if (path != null && !path.isEmpty()) {
                    pintarLabel(path);
                } else {
                    JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jRadioNormalActionPerformed

    private void JRadioShinyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRadioShinyActionPerformed
        if (jComboBox1.getSelectedIndex() == -1) {
            String path = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/itemsmaster-ball.png";
            pintarLabel(path);
        } else {
            String path;
            if (jRadioFront.isSelected()) {
                try {
                    path = pokemon.getSprites().getFront_shiny();
                } catch (NullPointerException e) {
                    // Manejar la excepción aquí
                    path = "ruta/por/defecto.png";
                }
                if (path != null && !path.isEmpty()) {
                    pintarLabel(path);
                } else {
                    JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    path = pokemon.getSprites().getBack_shiny();
                } catch (NullPointerException e) {
                    // Manejar la excepción aquí
                    path = "ruta/por/defecto.png";
                }
                if (path != null && !path.isEmpty()) {
                    pintarLabel(path);
                } else {
                    JOptionPane.showMessageDialog(this, "Sprite no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
    }//GEN-LAST:event_JRadioShinyActionPerformed
    }


    private void jPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPesoActionPerformed

    }//GEN-LAST:event_jPesoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String buscar = jBuscarTexto.getText().toLowerCase();
        jComboBox1.setSelectedItem(buscar);

        boolean encontrado = false;
        for (int i = 0; i < jComboBox1.getItemCount(); i++) {
            if (buscar.equals(jComboBox1.getItemAt(i))) {
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Pokemon no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBuscarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarTextoActionPerformed


    }//GEN-LAST:event_jBuscarTextoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JRadioBack;
    private javax.swing.JRadioButton JRadioShiny;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTextField jAlto;
    private javax.swing.JTextField jBuscarTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jNombre;
    private javax.swing.JTextField jNumero;
    private javax.swing.JTextField jPeso;
    private javax.swing.JRadioButton jRadioFront;
    private javax.swing.JRadioButton jRadioNormal;
    private javax.swing.JLabel jlImagen;
    // End of variables declaration//GEN-END:variables
}
