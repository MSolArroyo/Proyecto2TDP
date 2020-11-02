package RELOJ;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;



public class Ventana extends JFrame implements Runnable{
    
    private int seg = 0;
    private int min = 0;
    private int hora = 0;
    private boolean continuar = true;
    private Incrementar i;
 // Declaracion de Variables 
    private JButton btn_comenzar;
    private JButton btn_parar;
    private JButton btn_reanudar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField txf_cont1;
    private JTextField txf_cont2;
    private JTextField txf_cont3;
    
    
    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Cronómetro");
        this.setLocation(600,100);
        txf_cont1.setText(String.valueOf(hora));
        txf_cont2.setText(String.valueOf(min));
        txf_cont3.setText(String.valueOf(seg));
        btn_comenzar.setEnabled(true);
        btn_parar.setEnabled(false);
        btn_reanudar.setEnabled(false);
    }

    /**
     *Inicializacion de los componentes
     **/
    @SuppressWarnings("unchecked")
    private void initComponents() {

        btn_comenzar = new javax.swing.JButton();
        btn_comenzar.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btn_parar = new javax.swing.JButton();
        btn_parar.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btn_reanudar = new javax.swing.JButton();
        btn_reanudar.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txf_cont3 = new javax.swing.JTextField();
        txf_cont1 = new javax.swing.JTextField();
        txf_cont2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        btn_comenzar.setText("INICIAR");
        btn_comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comenzarActionPerformed(evt);
            }
        });

        btn_parar.setText("PARAR");
        btn_parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pararActionPerformed(evt);
            }
        });

        btn_reanudar.setText("REANUDAR");
        btn_reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reanudarActionPerformed(evt);
            }
        });

        txf_cont3.setEditable(false);
        txf_cont3.setBackground(Color.LIGHT_GRAY);
        txf_cont3.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        txf_cont3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txf_cont3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_cont3ActionPerformed(evt);
            }
        });

        txf_cont1.setEditable(false);
        txf_cont1.setBackground(Color.LIGHT_GRAY);
        txf_cont1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        txf_cont1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txf_cont1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_cont1ActionPerformed(evt);
            }
        });

        txf_cont2.setEditable(false);
        txf_cont2.setBackground(Color.LIGHT_GRAY);
        txf_cont2.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        txf_cont2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txf_cont2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_cont2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel1.setText(":");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel2.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_comenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_parar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_reanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txf_cont1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txf_cont2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(txf_cont3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_comenzar)
                    .addComponent(btn_parar)
                    .addComponent(btn_reanudar))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txf_cont1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txf_cont2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txf_cont3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }

    private void btn_comenzarActionPerformed(java.awt.event.ActionEvent evt) {

        btn_comenzar.setEnabled(false);
        btn_parar.setEnabled(true);
        btn_reanudar.setEnabled(false);
        resetSeg();
        resetMin();
        resetHora();
        seguir();
        i=null;
        i = new Incrementar(this);
        i.start();
        
    }

    private void btn_pararActionPerformed(java.awt.event.ActionEvent evt) {
        btn_comenzar.setEnabled(true);
        btn_parar.setEnabled(false);
        btn_reanudar.setEnabled(true);
        parar();
    }

    private void btn_reanudarActionPerformed(java.awt.event.ActionEvent evt) {
        btn_comenzar.setEnabled(false);
        btn_parar.setEnabled(true);
        btn_reanudar.setEnabled(false);
        seguir();
        i.seguir();
    }

    private void txf_cont3ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txf_cont1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txf_cont2ActionPerformed(java.awt.event.ActionEvent evt) {
    }
    
    
    
    public static void main(String args[]) {
        
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    public void run() {
        
    }
    public synchronized int aumentSeg(){
        seg++;
        txf_cont3.setText(String.valueOf(seg));
        return seg;
    }
    public synchronized int aumentMin(){
        min++;
        txf_cont2.setText(String.valueOf(min));
        return min;
    }
    public synchronized int aumentHora(){
        hora++;
        txf_cont1.setText(String.valueOf(hora));
        return hora;
    }
    public void resetSeg(){
        txf_cont3.setText(String.valueOf("0"));
        seg=0;
    }
    public void resetMin(){
        txf_cont2.setText(String.valueOf("0")); 
        min=0;
    }
    public void resetHora(){
        txf_cont1.setText(String.valueOf("0"));       
        hora=0;
    }
    public synchronized int getMin(){
        return min;
    }
    public synchronized int getSeg(){
        return seg;
    }    
    public synchronized int getHora(){
        return hora;
    }   
    public synchronized void seguir(){
        continuar =true;
    }
    public synchronized void parar(){
        continuar =false;
    }
    public synchronized boolean isContinuar() {
        return continuar;
    }       
}