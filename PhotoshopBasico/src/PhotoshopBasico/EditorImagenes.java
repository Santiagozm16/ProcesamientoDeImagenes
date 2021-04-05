/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhotoshopBasico;
import java.awt.Image;
import javax.swing.*;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;


//Aquiii
/**
 *
 * @author Daniel Esteban Rico C. 
 */
public class EditorImagenes extends javax.swing.JFrame {

    /**
     * Creates new form EditorImagenes
     */
    public EditorImagenes() {
        initComponents();
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Image = new javax.swing.JLabel();
        jLabel_Image1 = new javax.swing.JLabel();
        Contraste = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Gamma = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SliderBrillo = new javax.swing.JSlider();
        Maximo = new javax.swing.JButton();
        Mediana = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Minimo = new javax.swing.JButton();
        Moda = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        convolucion5 = new javax.swing.JButton();
        convolucion7 = new javax.swing.JButton();
        convolucion9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        sigma2 = new javax.swing.JRadioButton();
        sigma3 = new javax.swing.JRadioButton();
        sigma1 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMI_Open = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Original = new javax.swing.JMenuItem();
        Editado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Contraste.setText("Contraste");
        Contraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContrasteActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Gamma.setText("Gamma");
        Gamma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GammaActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Brillo");

        SliderBrillo.setMajorTickSpacing(5);
        SliderBrillo.setMaximum(255);
        SliderBrillo.setMinimum(-255);
        SliderBrillo.setValue(0);
        SliderBrillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderBrilloStateChanged(evt);
            }
        });

        Maximo.setText("Maximo");
        Maximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaximoActionPerformed(evt);
            }
        });

        Mediana.setText("Mediana");
        Mediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedianaActionPerformed(evt);
            }
        });

        jButton1.setText("Ecualización");
        jButton1.setActionCommand("Ecualizacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcualizacionActionPerformed(evt);
            }
        });

        Minimo.setText("Minimo");
        Minimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinimoActionPerformed(evt);
            }
        });

        Moda.setText("Moda");
        Moda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModaActionPerformed(evt);
            }
        });

        jButton2.setText("3x3");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filtro3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtros no lineales");

        jLabel3.setText("Ecualización");

        jLabel4.setText("Convolucion y binomiales");

        convolucion5.setText("5x5");
        convolucion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convolucion5Filtro3ActionPerformed(evt);
            }
        });

        convolucion7.setText("7x7");
        convolucion7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convolucion7Filtro3ActionPerformed(evt);
            }
        });

        convolucion9.setText("9x9");
        convolucion9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convolucion9Filtro3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Filtro Gaussiano");

        sigma2.setText("1.5");
        sigma2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigma2ActionPerformed(evt);
            }
        });

        sigma3.setText("2");
        sigma3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigma3ActionPerformed(evt);
            }
        });

        sigma1.setText("1");
        sigma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigma1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMI_Open.setText("Abrir");
        jMI_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_OpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMI_Open);

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jMenu1.add(Guardar);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Histograma");

        Original.setText("Imagen Original");
        Original.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OriginalActionPerformed(evt);
            }
        });
        jMenu3.add(Original);

        Editado.setText("Imagen Editada");
        Editado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditadoActionPerformed(evt);
            }
        });
        jMenu3.add(Editado);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(Contraste, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(Gamma, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Maximo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Minimo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Moda, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mediana, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(convolucion5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(convolucion7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(convolucion9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sigma1)
                                        .addGap(46, 46, 46)
                                        .addComponent(sigma2)
                                        .addGap(42, 42, 42)
                                        .addComponent(sigma3)))))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(195, 195, 195))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(SliderBrillo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(208, 208, 208))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(202, 202, 202))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(179, 179, 179))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel_Image1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                        .addComponent(jLabel_Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SliderBrillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Contraste, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gamma, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Maximo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mediana, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Minimo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Moda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(convolucion5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(convolucion7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(convolucion9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sigma1)
                            .addComponent(sigma2)
                            .addComponent(sigma3))))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private  BufferedImage ImgOriginal=null;
    private  BufferedImage ImgUso=null;
    private Raster raster =null;
    private int sliderValue;
    private ImagenEditada ImgEdit = new ImagenEditada();
    private static final int BINS = 256;
    private HistogramDataset dataset;
    private XYBarRenderer renderer;

    
    //Abre la imagen seleccionada
    private BufferedImage AbrirImagen(){
        
         JFileChooser jfc =new JFileChooser();
         BufferedImage img= null;
         
          if(jfc.showOpenDialog(jMenu1)== JFileChooser.APPROVE_OPTION){
              File f = jfc.getSelectedFile();
               try {
                  img =ImageIO.read(f);
              }catch (IOException ex) {
                System.out.println("No se pudo abrir la imagen seleccionada");
              }
          }else {
              System.out.println("No se escogio nada");
            }
          return img;
    }
    //Graficar Imagen Original
    private void MostrarImagenOriginal(BufferedImage imagen){
        BufferedImage img= imagen;
        Image dimg =img.getScaledInstance(jLabel_Image.getWidth(),jLabel_Image.getHeight(),Image.SCALE_SMOOTH);
        jLabel_Image.setIcon(new ImageIcon(dimg));      
        
    }
    //Graficar Imagen Modificada
    private void MostrarImagenEditada(BufferedImage img){
        Image dimg =img.getScaledInstance(jLabel_Image1.getWidth(),jLabel_Image1.getHeight(),Image.SCALE_SMOOTH);
        jLabel_Image1.setIcon(new ImageIcon(dimg)); 
    }
     
    //Histograma
    private ChartPanel createChartPanel(BufferedImage img) {
        // dataset
        dataset = new HistogramDataset(); 
        raster = img.getRaster();  
        final int w = img.getWidth();
        final int h = img.getHeight();
        double[] r = new double[w * h];
        r = raster.getSamples(0, 0, w, h, 0, r);
        dataset.addSeries("Rojo", r, BINS);
        r = raster.getSamples(0, 0, w, h, 1, r);
        dataset.addSeries("Verde", r, BINS);
        r = raster.getSamples(0, 0, w, h, 2, r);
        dataset.addSeries("Azul", r, BINS);
     
        // chart
        JFreeChart chart = ChartFactory.createHistogram("Histograma", "Valor",
            "Repeticiones", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardXYBarPainter());
        // translucent red, green & blue
        Paint[] paintArray = {
            new Color(0x80ff0000, true),
            new Color(0x8000ff00, true),
            new Color(0x800000ff, true)
        };
        plot.setDrawingSupplier(new DefaultDrawingSupplier(
            paintArray,
            DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        return panel;
    }
 
       private void display(BufferedImage img) {
        JFrame f = new JFrame("Histogram");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createChartPanel(img));
        JLabel picture= new JLabel();
        picture.setPreferredSize(new Dimension(500, 700));
        Image dimg =img.getScaledInstance(500,700,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg); 
        picture.setIcon(icon);
        f.add(picture, BorderLayout.WEST);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    
    //Brillo
    private void Brillo(int k1){

        ImgEdit.BrilloSetNuevosColores(k1);
    }
    //Contraste
    private void Contraste(int k1){

        ImgEdit.ContrasteSetNuevosColores(k1);
    }
    //Gamma
    private void Gamma(){

        ImgEdit.GammaSetNuevosColores();
    }
    
    //Maximo
    private void Maximo(){
        
    ImgEdit.FiltroMaximo();
    }
    
    //Mediana
    private void Mediana(){
        
    ImgEdit.FiltroMediana();
    }
    
    //Minimo
    private void Minimo(){
        
      ImgEdit.FiltroMinimo();
    } 
    
    //Moda
    
    private void Moda(){
      ImgEdit.FiltroModa();
    }
    
    //Ecualizacion
    private void Ecualizacion(){
        
      ImgEdit.FiltroEcualizador();
    }
    
    //Filtro 3x3
    private void Tres(){
        int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente 1"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente 2"));
        int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente 3"));
        ImgEdit.TresPorTres(a, b, c);
    }
    
    //Gaussiano
    private void Gaussiano(double num){
        ImgEdit.FiltroGaussiano(num);
    }
    
    //Filtro 5x5
    
    private void Cinco(){
        
        ImgEdit.CincoPorCinco();
    }
        //Filtro 7x7
    private void Siete(){
        
        ImgEdit.SietePorSiete();
    }
    
    //Filtro 9x9
    private void Nueve(){
        
        ImgEdit.NuevePorNueve();
    }
    private void jMI_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_OpenActionPerformed
        // TODO add your handling code here:
    ImgOriginal=AbrirImagen();
    ImgEdit.setImagen(ImgOriginal);
    ImgUso= Clon.clone(ImgOriginal);
    MostrarImagenOriginal(ImgOriginal);
    MostrarImagenEditada (ImgEdit.getImagen());
    }//GEN-LAST:event_jMI_OpenActionPerformed

    private void ContrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContrasteActionPerformed
        // TODO add your handling code here:
    Contraste(2);
    MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));   
    }//GEN-LAST:event_ContrasteActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
     
     ImgEdit.setImagen(ImgOriginal);
     ImgUso= Clon.clone(ImgOriginal);
     MostrarImagenEditada(ImgEdit.getImagen());
     SliderBrillo.setValue(0);
     sigma2.setSelected(false);
     sigma1.setSelected(false);
     sigma3.setSelected(false);
    }//GEN-LAST:event_ResetActionPerformed

    private void GammaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GammaActionPerformed
        // TODO add your handling code here:
    Gamma();
    MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));     
    
    }//GEN-LAST:event_GammaActionPerformed

    private void OriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OriginalActionPerformed
        // TODO add your handling code here:
         display(ImgOriginal);
        
    }//GEN-LAST:event_OriginalActionPerformed

    private void EditadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditadoActionPerformed
        // TODO add your handling code here:
        display(ImgEdit.getImagen());
    }//GEN-LAST:event_EditadoActionPerformed

    private void SliderBrilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderBrilloStateChanged
        // TODO add your handling code here:
        ImgEdit.setImagen(ImgUso);
        sliderValue=SliderBrillo.getValue();
        Brillo(sliderValue);
        MostrarImagenEditada(ImgEdit.getImagen());         
    }//GEN-LAST:event_SliderBrilloStateChanged

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
      if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
            ImageIO.write(ImgEdit.getImagen(), "png", new File(file.getAbsolutePath()+".png"));
        } catch (IOException ex) {
            System.out.println("No se pudo guardar la imagen");
        }
    } else {
        System.out.println("No se escogio nada");
    }
    }//GEN-LAST:event_GuardarActionPerformed

    private void MaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaximoActionPerformed
        // TODO add your handling code here:
        Maximo();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
    }//GEN-LAST:event_MaximoActionPerformed

    private void MedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedianaActionPerformed
        // TODO add your handling code here:
        Mediana();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
    }//GEN-LAST:event_MedianaActionPerformed
     
    private void EcualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcualizacionActionPerformed
        // TODO add your handling code here:
        Ecualizacion();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
    }//GEN-LAST:event_EcualizacionActionPerformed

    private void MinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinimoActionPerformed
        Minimo();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));// TODO add your handling code here:
    }//GEN-LAST:event_MinimoActionPerformed

    private void ModaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModaActionPerformed
        Moda();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen())); 
    }//GEN-LAST:event_ModaActionPerformed

    private void Filtro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filtro3ActionPerformed
        // TODO add your handling code here:
        Tres();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
    }//GEN-LAST:event_Filtro3ActionPerformed

    private void convolucion5Filtro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convolucion5Filtro3ActionPerformed
        // TODO add your handling code here:
        Cinco();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
    }//GEN-LAST:event_convolucion5Filtro3ActionPerformed

    private void convolucion7Filtro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convolucion7Filtro3ActionPerformed
        // TODO add your handling code here:
        Siete();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
    }//GEN-LAST:event_convolucion7Filtro3ActionPerformed

    private void convolucion9Filtro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convolucion9Filtro3ActionPerformed
        // TODO add your handling code here:
        Nueve();
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
    }//GEN-LAST:event_convolucion9Filtro3ActionPerformed

    private void sigma2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigma2ActionPerformed
        Gaussiano(1.5);
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
        sigma3.setSelected(false);
        sigma1.setSelected(false);// TODO add your handling code here:
    }//GEN-LAST:event_sigma2ActionPerformed

    private void sigma3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigma3ActionPerformed
        Gaussiano(2);
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
        sigma2.setSelected(false);
        sigma1.setSelected(false);// TODO add your handling code here:
    }//GEN-LAST:event_sigma3ActionPerformed

    private void sigma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigma1ActionPerformed
        Gaussiano(1);
        MostrarImagenEditada(ImgUso= Clon.clone(ImgEdit.getImagen()));
        sigma2.setSelected(false);
        sigma3.setSelected(false);// TODO add your handling code here:
    }//GEN-LAST:event_sigma1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditorImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorImagenes().setVisible(true);
              //  new EditorImagenes().display();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Contraste;
    private javax.swing.JMenuItem Editado;
    private javax.swing.JButton Gamma;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JButton Maximo;
    private javax.swing.JButton Mediana;
    private javax.swing.JButton Minimo;
    private javax.swing.JButton Moda;
    private javax.swing.JMenuItem Original;
    private javax.swing.JButton Reset;
    private javax.swing.JSlider SliderBrillo;
    private javax.swing.JButton convolucion5;
    private javax.swing.JButton convolucion7;
    private javax.swing.JButton convolucion9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Image;
    private javax.swing.JLabel jLabel_Image1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton sigma1;
    private javax.swing.JRadioButton sigma2;
    private javax.swing.JRadioButton sigma3;
    // End of variables declaration//GEN-END:variables
}
