
import javax.swing.JFrame;


public class SubResult extends javax.swing.JFrame {

    public SubResult() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        juniorResultButton = new javax.swing.JButton();
        seniorResultButton = new javax.swing.JButton();
        classResultButton = new javax.swing.JButton();
        annualResultButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 153, 153)));

        juniorResultButton.setBackground(new java.awt.Color(153, 153, 153));
        juniorResultButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        juniorResultButton.setText("CLASS NUR-4");
        juniorResultButton.setBorder(null);
        juniorResultButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        juniorResultButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        juniorResultButton.setIconTextGap(20);
        juniorResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juniorResultButtonActionPerformed(evt);
            }
        });

        seniorResultButton.setBackground(new java.awt.Color(153, 153, 153));
        seniorResultButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        seniorResultButton.setText("CLASS 5 - 8");
        seniorResultButton.setBorder(null);
        seniorResultButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seniorResultButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        seniorResultButton.setIconTextGap(40);
        seniorResultButton.setInheritsPopupMenu(true);
        seniorResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seniorResultButtonActionPerformed(evt);
            }
        });

        classResultButton.setBackground(new java.awt.Color(153, 153, 153));
        classResultButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        classResultButton.setText("CLASS RESULT");
        classResultButton.setBorder(null);
        classResultButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        classResultButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        classResultButton.setIconTextGap(15);
        classResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classResultButtonActionPerformed(evt);
            }
        });

        annualResultButton.setBackground(new java.awt.Color(153, 153, 153));
        annualResultButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        annualResultButton.setText("Annual Result");
        annualResultButton.setBorder(null);
        annualResultButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        annualResultButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        annualResultButton.setIconTextGap(15);
        annualResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annualResultButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(juniorResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seniorResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annualResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(juniorResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(classResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(annualResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(seniorResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void juniorResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juniorResultButtonActionPerformed
        ResultJunior obj = new ResultJunior();
        obj.setVisible(true);
    }//GEN-LAST:event_juniorResultButtonActionPerformed

    private void seniorResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seniorResultButtonActionPerformed
        ResultSenior obj = new ResultSenior();
        obj.setVisible(true);
    }//GEN-LAST:event_seniorResultButtonActionPerformed

    private void classResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classResultButtonActionPerformed
        ClassResult obj = new ClassResult();
        obj.setVisible(true);
    }//GEN-LAST:event_classResultButtonActionPerformed

    private void annualResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annualResultButtonActionPerformed
        AnnualReport obj = new AnnualReport();
        obj.setVisible(true);
    }//GEN-LAST:event_annualResultButtonActionPerformed

   
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
            java.util.logging.Logger.getLogger(SubResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annualResultButton;
    private javax.swing.JButton classResultButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton juniorResultButton;
    private javax.swing.JButton seniorResultButton;
    // End of variables declaration//GEN-END:variables
}
