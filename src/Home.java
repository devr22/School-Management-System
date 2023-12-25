
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Home extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private ImageIcon format = null;
    
    public Home() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:sms.db";
            con = DriverManager.getConnection(url);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error in Conneting to the database: " + e.toString());
        }
        
        getSchoolInfo();
    }
    
    private void getSchoolInfo(){
        try{
            String query = "select * from SchoolDetail";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
                schoolNameLabel.setText(rs.getString("Name"));
                addressLabel.setText(rs.getString("Address"));
                byte[] imgData =  rs.getBytes("Logo");
                format = new ImageIcon(imgData);
                scaleLogoImage(format);
            }
            pst.close();
        }catch(SQLException e){
            System.out.println(""+ e.getMessage());
        }
    }
  
    private void scaleLogoImage(ImageIcon imageIcon){
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(logoImage.getWidth(), logoImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon fitImage = new ImageIcon(image);
        logoImage.setIcon(fitImage);
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        schoolNameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        logoImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        admissionPanel = new javax.swing.JPanel();
        admissionLabel = new javax.swing.JLabel();
        studentRecordPanel = new javax.swing.JPanel();
        studentRecordLabel = new javax.swing.JLabel();
        modifyStudentPanel = new javax.swing.JPanel();
        modifyStudentLabel = new javax.swing.JLabel();
        studentTcPanel = new javax.swing.JPanel();
        studentTcLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        feeSubmitPanel = new javax.swing.JPanel();
        feeSubmitLabel = new javax.swing.JLabel();
        feeStructurePanel = new javax.swing.JPanel();
        feeStructureLabel = new javax.swing.JLabel();
        feeReminderPanel = new javax.swing.JPanel();
        feeReminderLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        resultPanel = new javax.swing.JPanel();
        resultLabel = new javax.swing.JLabel();
        admitCardPanel = new javax.swing.JPanel();
        admitCardLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        addEditDelClassPanel = new javax.swing.JPanel();
        manageClassLabel = new javax.swing.JLabel();
        editSchoolDetailPanel = new javax.swing.JPanel();
        editSchoolLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(250, 251, 243));

        logoutButton.setBackground(new java.awt.Color(255, 153, 153));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        schoolNameLabel.setFont(new java.awt.Font("Wide Latin", 1, 30)); // NOI18N
        schoolNameLabel.setForeground(new java.awt.Color(204, 0, 204));
        schoolNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolNameLabel.setText("ANANDA MARGA MIDDLE SCHOOL");

        addressLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(102, 102, 255));
        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addressLabel.setText("Security Line ,Govindpura  BHEL Bhopal  ");

        logoImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(schoolNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(schoolNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPanel2.setBackground(new java.awt.Color(141, 52, 253));

        jLabel1.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jPanel4.setBackground(new java.awt.Color(141, 52, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 22), new java.awt.Color(102, 255, 102))); // NOI18N

        admissionPanel.setBackground(new java.awt.Color(141, 52, 253));
        admissionPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        admissionPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admissionPanelMouseClicked(evt);
            }
        });

        admissionLabel.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        admissionLabel.setForeground(new java.awt.Color(255, 255, 255));
        admissionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admissionLabel.setText("  Admission");
        admissionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout admissionPanelLayout = new javax.swing.GroupLayout(admissionPanel);
        admissionPanel.setLayout(admissionPanelLayout);
        admissionPanelLayout.setHorizontalGroup(
            admissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admissionPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(admissionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        admissionPanelLayout.setVerticalGroup(
            admissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(admissionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        studentRecordPanel.setBackground(new java.awt.Color(141, 52, 253));
        studentRecordPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        studentRecordPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentRecordPanelMouseClicked(evt);
            }
        });

        studentRecordLabel.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        studentRecordLabel.setForeground(new java.awt.Color(255, 255, 255));
        studentRecordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentRecordLabel.setText("Records");
        studentRecordLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout studentRecordPanelLayout = new javax.swing.GroupLayout(studentRecordPanel);
        studentRecordPanel.setLayout(studentRecordPanelLayout);
        studentRecordPanelLayout.setHorizontalGroup(
            studentRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentRecordPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(studentRecordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        studentRecordPanelLayout.setVerticalGroup(
            studentRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentRecordPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(studentRecordLabel)
                .addGap(2, 2, 2))
        );

        modifyStudentPanel.setBackground(new java.awt.Color(141, 52, 253));
        modifyStudentPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        modifyStudentPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyStudentPanelMouseClicked(evt);
            }
        });

        modifyStudentLabel.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        modifyStudentLabel.setForeground(new java.awt.Color(255, 255, 255));
        modifyStudentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modifyStudentLabel.setText("Modify");
        modifyStudentLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout modifyStudentPanelLayout = new javax.swing.GroupLayout(modifyStudentPanel);
        modifyStudentPanel.setLayout(modifyStudentPanelLayout);
        modifyStudentPanelLayout.setHorizontalGroup(
            modifyStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyStudentPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(modifyStudentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        modifyStudentPanelLayout.setVerticalGroup(
            modifyStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyStudentPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(modifyStudentLabel)
                .addGap(0, 0, 0))
        );

        studentTcPanel.setBackground(new java.awt.Color(141, 52, 253));
        studentTcPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        studentTcPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTcPanelMouseClicked(evt);
            }
        });

        studentTcLabel.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        studentTcLabel.setForeground(new java.awt.Color(255, 255, 255));
        studentTcLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentTcLabel.setText("TC");
        studentTcLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout studentTcPanelLayout = new javax.swing.GroupLayout(studentTcPanel);
        studentTcPanel.setLayout(studentTcPanelLayout);
        studentTcPanelLayout.setHorizontalGroup(
            studentTcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentTcPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(studentTcLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        studentTcPanelLayout.setVerticalGroup(
            studentTcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentTcPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(studentTcLabel)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyStudentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admissionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentRecordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentTcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(admissionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(modifyStudentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(studentRecordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(studentTcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel6.setBackground(new java.awt.Color(141, 52, 253));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Fee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 22), new java.awt.Color(102, 255, 102))); // NOI18N

        feeSubmitPanel.setBackground(new java.awt.Color(141, 52, 253));
        feeSubmitPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        feeSubmitPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feeSubmitPanelMouseClicked(evt);
            }
        });

        feeSubmitLabel.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        feeSubmitLabel.setForeground(new java.awt.Color(255, 255, 255));
        feeSubmitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feeSubmitLabel.setText("Submit");
        feeSubmitLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout feeSubmitPanelLayout = new javax.swing.GroupLayout(feeSubmitPanel);
        feeSubmitPanel.setLayout(feeSubmitPanelLayout);
        feeSubmitPanelLayout.setHorizontalGroup(
            feeSubmitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feeSubmitPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(feeSubmitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        feeSubmitPanelLayout.setVerticalGroup(
            feeSubmitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feeSubmitPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(feeSubmitLabel)
                .addGap(2, 2, 2))
        );

        feeStructurePanel.setBackground(new java.awt.Color(141, 52, 253));
        feeStructurePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        feeStructurePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feeStructurePanelMouseClicked(evt);
            }
        });

        feeStructureLabel.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        feeStructureLabel.setForeground(new java.awt.Color(255, 255, 255));
        feeStructureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feeStructureLabel.setText("Structure");
        feeStructureLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout feeStructurePanelLayout = new javax.swing.GroupLayout(feeStructurePanel);
        feeStructurePanel.setLayout(feeStructurePanelLayout);
        feeStructurePanelLayout.setHorizontalGroup(
            feeStructurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feeStructurePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(feeStructureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        feeStructurePanelLayout.setVerticalGroup(
            feeStructurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feeStructurePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(feeStructureLabel)
                .addGap(2, 2, 2))
        );

        feeReminderPanel.setBackground(new java.awt.Color(141, 52, 253));
        feeReminderPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        feeReminderPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feeReminderPanelMouseClicked(evt);
            }
        });

        feeReminderLabel.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        feeReminderLabel.setForeground(new java.awt.Color(255, 255, 255));
        feeReminderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feeReminderLabel.setText("Reminder");
        feeReminderLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout feeReminderPanelLayout = new javax.swing.GroupLayout(feeReminderPanel);
        feeReminderPanel.setLayout(feeReminderPanelLayout);
        feeReminderPanelLayout.setHorizontalGroup(
            feeReminderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feeReminderPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(feeReminderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        feeReminderPanelLayout.setVerticalGroup(
            feeReminderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feeReminderPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(feeReminderLabel)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feeSubmitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feeStructurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feeReminderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(feeStructurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(feeSubmitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(feeReminderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel7.setBackground(new java.awt.Color(141, 52, 253));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Exam", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 22), new java.awt.Color(102, 255, 102))); // NOI18N

        resultPanel.setBackground(new java.awt.Color(141, 52, 253));
        resultPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        resultPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultPanelMouseClicked(evt);
            }
        });

        resultLabel.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        resultLabel.setForeground(new java.awt.Color(255, 255, 255));
        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultLabel.setText("Result");
        resultLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(resultLabel)
                .addGap(2, 2, 2))
        );

        admitCardPanel.setBackground(new java.awt.Color(141, 52, 253));
        admitCardPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        admitCardPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admitCardPanelMouseClicked(evt);
            }
        });

        admitCardLabel.setFont(new java.awt.Font("Serif", 1, 30)); // NOI18N
        admitCardLabel.setForeground(new java.awt.Color(255, 255, 255));
        admitCardLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admitCardLabel.setText("Admit Card");
        admitCardLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout admitCardPanelLayout = new javax.swing.GroupLayout(admitCardPanel);
        admitCardPanel.setLayout(admitCardPanelLayout);
        admitCardPanelLayout.setHorizontalGroup(
            admitCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admitCardPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(admitCardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        admitCardPanelLayout.setVerticalGroup(
            admitCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admitCardPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(admitCardLabel)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admitCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(admitCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel8.setBackground(new java.awt.Color(141, 52, 253));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Others", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 22), new java.awt.Color(102, 255, 102))); // NOI18N

        addEditDelClassPanel.setBackground(new java.awt.Color(141, 52, 253));
        addEditDelClassPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        addEditDelClassPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEditDelClassPanelMouseClicked(evt);
            }
        });

        manageClassLabel.setFont(new java.awt.Font("Serif", 1, 30)); // NOI18N
        manageClassLabel.setForeground(new java.awt.Color(255, 255, 255));
        manageClassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageClassLabel.setText("Manage Class");
        manageClassLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout addEditDelClassPanelLayout = new javax.swing.GroupLayout(addEditDelClassPanel);
        addEditDelClassPanel.setLayout(addEditDelClassPanelLayout);
        addEditDelClassPanelLayout.setHorizontalGroup(
            addEditDelClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEditDelClassPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(manageClassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        addEditDelClassPanelLayout.setVerticalGroup(
            addEditDelClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEditDelClassPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(manageClassLabel)
                .addGap(2, 2, 2))
        );

        editSchoolDetailPanel.setBackground(new java.awt.Color(141, 52, 253));
        editSchoolDetailPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        editSchoolDetailPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editSchoolDetailPanelMouseClicked(evt);
            }
        });

        editSchoolLabel.setFont(new java.awt.Font("Serif", 1, 26)); // NOI18N
        editSchoolLabel.setForeground(new java.awt.Color(255, 255, 255));
        editSchoolLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editSchoolLabel.setText("Edit School Detail");
        editSchoolLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout editSchoolDetailPanelLayout = new javax.swing.GroupLayout(editSchoolDetailPanel);
        editSchoolDetailPanel.setLayout(editSchoolDetailPanelLayout);
        editSchoolDetailPanelLayout.setHorizontalGroup(
            editSchoolDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editSchoolDetailPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(editSchoolLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        editSchoolDetailPanelLayout.setVerticalGroup(
            editSchoolDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editSchoolDetailPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(editSchoolLabel)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addEditDelClassPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editSchoolDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEditDelClassPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(editSchoolDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admissionPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admissionPanelMouseClicked
        Admission obj = new Admission();
        obj.setVisible(true);
    }//GEN-LAST:event_admissionPanelMouseClicked

    private void studentRecordPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentRecordPanelMouseClicked
        StudentRecords obj = new StudentRecords();
        obj.setVisible(true);
    }//GEN-LAST:event_studentRecordPanelMouseClicked

    private void modifyStudentPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyStudentPanelMouseClicked
        ManageStudent obj = new ManageStudent();
        obj.setVisible(true);
    }//GEN-LAST:event_modifyStudentPanelMouseClicked

    private void studentTcPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTcPanelMouseClicked
        StudentTC obj = new StudentTC();
        obj.setVisible(true);
    }//GEN-LAST:event_studentTcPanelMouseClicked

    private void feeSubmitPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feeSubmitPanelMouseClicked
        FeeSubmission obj = new FeeSubmission();
        obj.setVisible(true);
    }//GEN-LAST:event_feeSubmitPanelMouseClicked

    private void feeStructurePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feeStructurePanelMouseClicked
        FeeStructure obj = new FeeStructure();
        obj.setVisible(true);
    }//GEN-LAST:event_feeStructurePanelMouseClicked

    private void feeReminderPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feeReminderPanelMouseClicked
        FeeReminder obj = new FeeReminder();
        obj.setVisible(true);
    }//GEN-LAST:event_feeReminderPanelMouseClicked

    private void resultPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultPanelMouseClicked
        SubResult obj = new SubResult();
        obj.setVisible(true);
    }//GEN-LAST:event_resultPanelMouseClicked

    private void admitCardPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admitCardPanelMouseClicked
        AdmitCard obj = new AdmitCard();
        obj.setVisible(true);
    }//GEN-LAST:event_admitCardPanelMouseClicked

    private void addEditDelClassPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEditDelClassPanelMouseClicked
        ManageClass obj = new ManageClass();;
        obj.setVisible(true);
    }//GEN-LAST:event_addEditDelClassPanelMouseClicked

    private void editSchoolDetailPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editSchoolDetailPanelMouseClicked
        EditSchoolDetail obj = new EditSchoolDetail();
        obj.setVisible(true);
    }//GEN-LAST:event_editSchoolDetailPanelMouseClicked

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        MainFrame obj = new MainFrame();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addEditDelClassPanel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel admissionLabel;
    private javax.swing.JPanel admissionPanel;
    private javax.swing.JLabel admitCardLabel;
    private javax.swing.JPanel admitCardPanel;
    private javax.swing.JPanel editSchoolDetailPanel;
    private javax.swing.JLabel editSchoolLabel;
    private javax.swing.JLabel feeReminderLabel;
    private javax.swing.JPanel feeReminderPanel;
    private javax.swing.JLabel feeStructureLabel;
    private javax.swing.JPanel feeStructurePanel;
    private javax.swing.JLabel feeSubmitLabel;
    private javax.swing.JPanel feeSubmitPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoImage;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel manageClassLabel;
    private javax.swing.JLabel modifyStudentLabel;
    private javax.swing.JPanel modifyStudentPanel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JLabel schoolNameLabel;
    private javax.swing.JLabel studentRecordLabel;
    private javax.swing.JPanel studentRecordPanel;
    private javax.swing.JLabel studentTcLabel;
    private javax.swing.JPanel studentTcPanel;
    // End of variables declaration//GEN-END:variables
}
