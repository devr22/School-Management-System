
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Admission extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    JTextFieldDateEditor dtEditor;
    JTextFieldDateEditor dtEditor1;
    ButtonGroup bg = new ButtonGroup();
    
    String fileName = null;
    byte[] image = null;
    byte[] adhar = null;
    byte[] sssmid = null;
    byte[] caste = null;
    byte[] birth = null;
    byte[] tc = null;
    
    
    public Admission() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:sms.db";
            con = DriverManager.getConnection(url);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error in Conneting to the database: " + e.toString());
        }
        
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        
        fillclasscomboBox();
        initDateEditor();
    }
    
    private void fillclasscomboBox(){
        try{
            String query = "select distinct Class from ClassDetail order by class asc";
            pst =con.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String c = rs.getString("class");
                classComboBox.addItem(c);
            }
            pst.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void initDateEditor(){
        dtEditor = (JTextFieldDateEditor)dobChooser.getDateEditor();
        dtEditor.setEditable(false);
        dtEditor1 = (JTextFieldDateEditor)doaChooser.getDateEditor();
        dtEditor1.setEditable(false);
    }
    
    private void covertToUpperCase(JTextField textField){
        int position = textField.getCaretPosition();
        textField.setText(textField.getText().toUpperCase());
        textField.setCaretPosition(position);
    }
    
    private void restrictInputToInteger(JTextField textField, KeyEvent evt){
        char c = evt.getKeyChar();
        if(c >= '0' && c<= '9')
        {
            textField.setEditable(true);
        }
        else{
            if(evt.getExtendedKeyCode()== KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()== KeyEvent.VK_DELETE){
                textField.setEditable(true);
            }
            else{
                textField.setEditable(false);
            }
        }
    }
    
    private void restictInputToIntegerAndByLength(JTextField textField, KeyEvent evt, int maxLength){
        int length = textField.getText().length();
        char c = evt.getKeyChar();
        if(c >= '0' && c<= '9')
        {
            if(length < maxLength){
                textField.setEditable(true);
            }
            else{
                textField.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()== KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()== KeyEvent.VK_DELETE){
                textField.setEditable(true);
            }
            else{
                textField.setEditable(false);
            }
        }
    }
    
    public String getGender(){
       if(jRadioButton1.isSelected()){
           return "Male";
       }
       else if(jRadioButton2.isSelected()){
           return "Female";
       }
       else{
           return "Other";
       }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        headingLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        FnameLabel = new javax.swing.JLabel();
        fnameTxt = new javax.swing.JTextField();
        MnameLabel = new javax.swing.JLabel();
        MnameTxt = new javax.swing.JTextField();
        LnameLabel = new javax.swing.JLabel();
        LnameTxt = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        dobLabel = new javax.swing.JLabel();
        classLabel1 = new javax.swing.JLabel();
        dobChooser = new com.toedter.calendar.JDateChooser();
        classComboBox = new javax.swing.JComboBox<>();
        admissionLabel = new javax.swing.JLabel();
        admTxt = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        fatherNameLabel = new javax.swing.JLabel();
        FatherTxt = new javax.swing.JTextField();
        motherNameLabel = new javax.swing.JLabel();
        MotherTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nationalityLabel = new javax.swing.JLabel();
        NationTxt = new javax.swing.JTextField();
        stateLabel = new javax.swing.JLabel();
        StateTxt = new javax.swing.JTextField();
        stateLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTxt = new javax.swing.JTextArea();
        AdharLabel = new javax.swing.JLabel();
        AdharTxt = new javax.swing.JTextField();
        sssmidTxt = new javax.swing.JTextField();
        jLabel_SSSMID = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        mobNoLabel = new javax.swing.JLabel();
        mobTxt = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        daolabel = new javax.swing.JLabel();
        doaChooser = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        sssmidButton = new javax.swing.JButton();
        casteCertificateButton = new javax.swing.JButton();
        imageButton = new javax.swing.JButton();
        tcCertificateButton = new javax.swing.JButton();
        adharButton = new javax.swing.JButton();
        birthCertificateButton = new javax.swing.JButton();
        ImageTxt = new javax.swing.JTextField();
        AdharCertiTxt = new javax.swing.JTextField();
        sssmidCertiTxt = new javax.swing.JTextField();
        casteCertiTxt = new javax.swing.JTextField();
        birthCertiTxt = new javax.swing.JTextField();
        TcCertiTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgPanel.setBackground(new java.awt.Color(204, 204, 204));
        bgPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 153, 153)));

        headingLabel.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(80, 99, 244));
        headingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingLabel.setText("Student Admission ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        FnameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        FnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FnameLabel.setText("First Name");

        fnameTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        fnameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fnameTxtKeyReleased(evt);
            }
        });

        MnameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        MnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MnameLabel.setText("Middle Name");

        MnameTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        MnameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MnameTxtKeyReleased(evt);
            }
        });

        LnameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LnameLabel.setText("Last Name");

        LnameTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        LnameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LnameTxtKeyReleased(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderLabel.setText("Gender");

        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jRadioButton1.setText("Male");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jRadioButton2.setText("Female");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        dobLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        dobLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dobLabel.setText("D.O.B");

        classLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        classLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        classLabel1.setText("Class");

        dobChooser.setDateFormatString("dd /MM/ yyyy");
        dobChooser.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        dobChooser.setMinSelectableDate(new java.util.Date(-62135785739000L));

        classComboBox.setMaximumRowCount(50);
        classComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        classComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        admissionLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        admissionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admissionLabel.setText("Scholar No.");

        admTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        admTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admTxtKeyPressed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jRadioButton3.setText("Other");
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        fatherNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        fatherNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fatherNameLabel.setText("Father Name");

        FatherTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        FatherTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FatherTxtKeyReleased(evt);
            }
        });

        motherNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        motherNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        motherNameLabel.setText("Mother Name");

        MotherTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        MotherTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MotherTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(jRadioButton2)
                                .addGap(39, 39, 39)
                                .addComponent(jRadioButton3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(admissionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(admTxt))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(classLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(fatherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(classComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FatherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LnameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(FnameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(MnameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                    .addComponent(dobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                    .addComponent(MnameTxt)
                                    .addComponent(LnameTxt)
                                    .addComponent(dobChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(motherNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(MotherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admissionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dobLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dobChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FatherTxt)
                    .addComponent(fatherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MotherTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(motherNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        nationalityLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        nationalityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nationalityLabel.setText("Nationality");

        NationTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        NationTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NationTxtKeyReleased(evt);
            }
        });

        stateLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        stateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stateLabel.setText("State");

        StateTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        StateTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StateTxtKeyReleased(evt);
            }
        });

        stateLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        stateLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stateLabel1.setText("Address");

        addressTxt.setColumns(20);
        addressTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        addressTxt.setRows(5);
        addressTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addressTxtKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(addressTxt);

        AdharLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        AdharLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdharLabel.setText("Adhar No.");

        AdharTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        AdharTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdharTxtKeyPressed(evt);
            }
        });

        sssmidTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        sssmidTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sssmidTxtKeyPressed(evt);
            }
        });

        jLabel_SSSMID.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel_SSSMID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_SSSMID.setText("SSSMID No.");

        categoryLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        categoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoryLabel.setText("Category");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Gen", "OBC", "SC", "ST" }));
        categoryComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mobNoLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        mobNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mobNoLabel.setText("Mob No.");

        mobTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        mobTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nationalityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(stateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stateLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AdharLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_SSSMID, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mobTxt)
                        .addComponent(NationTxt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(StateTxt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                        .addComponent(AdharTxt)
                        .addComponent(sssmidTxt))
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nationalityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stateLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdharTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdharLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sssmidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_SSSMID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        resetButton.setBackground(new java.awt.Color(255, 51, 102));
        resetButton.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        resetButton.setText("Reset");
        resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        submitButton.setBackground(new java.awt.Color(51, 255, 51));
        submitButton.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        nextButton.setBackground(new java.awt.Color(102, 102, 255));
        nextButton.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        nextButton.setText("Next");
        nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        daolabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        daolabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        daolabel.setText("Date of Admission");

        doaChooser.setDateFormatString("dd /MM/ yyyy");

        sssmidButton.setText("Select File");
        sssmidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sssmidButtonActionPerformed(evt);
            }
        });

        casteCertificateButton.setText("Select File");
        casteCertificateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casteCertificateButtonActionPerformed(evt);
            }
        });

        imageButton.setText("Select File");
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });

        tcCertificateButton.setText("Select File");
        tcCertificateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcCertificateButtonActionPerformed(evt);
            }
        });

        adharButton.setText("Select File");
        adharButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adharButtonActionPerformed(evt);
            }
        });

        birthCertificateButton.setText("Select File");
        birthCertificateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthCertificateButtonActionPerformed(evt);
            }
        });

        ImageTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImageTxt.setForeground(new java.awt.Color(102, 102, 102));
        ImageTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ImageTxt.setText("Photo");

        AdharCertiTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AdharCertiTxt.setForeground(new java.awt.Color(102, 102, 102));
        AdharCertiTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AdharCertiTxt.setText("Adhar");

        sssmidCertiTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sssmidCertiTxt.setForeground(new java.awt.Color(102, 102, 102));
        sssmidCertiTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sssmidCertiTxt.setText("SSSMID");

        casteCertiTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        casteCertiTxt.setForeground(new java.awt.Color(102, 102, 102));
        casteCertiTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casteCertiTxt.setText("Cast Certificate");

        birthCertiTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        birthCertiTxt.setForeground(new java.awt.Color(102, 102, 102));
        birthCertiTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birthCertiTxt.setText("Birth Certificate");

        TcCertiTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TcCertiTxt.setForeground(new java.awt.Color(102, 102, 102));
        TcCertiTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TcCertiTxt.setText("TC Certificate");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(ImageTxt))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adharButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(AdharCertiTxt))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sssmidButton, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(sssmidCertiTxt))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(casteCertificateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(casteCertiTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(birthCertificateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(birthCertiTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tcCertificateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(TcCertiTxt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ImageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdharCertiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sssmidCertiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casteCertiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthCertiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(imageButton))
                    .addComponent(adharButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sssmidButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(TcCertiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(casteCertificateButton)
                            .addComponent(birthCertificateButton)
                            .addComponent(tcCertificateButton))))
                .addContainerGap())
        );

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgPanelLayout.createSequentialGroup()
                                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bgPanelLayout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                                            .addComponent(daolabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(doaChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(58, 58, 58))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(headingLabel)))
                .addGap(30, 30, 30))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doaChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(daolabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameTxtKeyReleased
        covertToUpperCase(fnameTxt);
    }//GEN-LAST:event_fnameTxtKeyReleased

    private void MnameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MnameTxtKeyReleased
        covertToUpperCase(MnameTxt);
    }//GEN-LAST:event_MnameTxtKeyReleased

    private void LnameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LnameTxtKeyReleased
        covertToUpperCase(LnameTxt);
    }//GEN-LAST:event_LnameTxtKeyReleased

    private void mobTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobTxtKeyPressed
        restictInputToIntegerAndByLength(mobTxt, evt, 10);
    }//GEN-LAST:event_mobTxtKeyPressed

    private void admTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admTxtKeyPressed
        restrictInputToInteger(admTxt, evt);
    }//GEN-LAST:event_admTxtKeyPressed

    private void NationTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NationTxtKeyReleased
        covertToUpperCase(NationTxt);
    }//GEN-LAST:event_NationTxtKeyReleased

    private void FatherTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FatherTxtKeyReleased
        covertToUpperCase(FatherTxt);
    }//GEN-LAST:event_FatherTxtKeyReleased

    private void MotherTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MotherTxtKeyReleased
        covertToUpperCase(MotherTxt);
    }//GEN-LAST:event_MotherTxtKeyReleased

    private void StateTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StateTxtKeyReleased
        covertToUpperCase(StateTxt);
    }//GEN-LAST:event_StateTxtKeyReleased

    private void addressTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressTxtKeyReleased
        int position = addressTxt.getCaretPosition();
        addressTxt.setText(addressTxt.getText().toUpperCase());
        addressTxt.setCaretPosition(position);
    }//GEN-LAST:event_addressTxtKeyReleased

    private void AdharTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdharTxtKeyPressed
        restictInputToIntegerAndByLength(AdharTxt, evt, 12);
    }//GEN-LAST:event_AdharTxtKeyPressed

    private void sssmidTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sssmidTxtKeyPressed
       restrictInputToInteger(sssmidTxt, evt);
    }//GEN-LAST:event_sssmidTxtKeyPressed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try{
            String query = "insert into admission values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);

            pst.setString(1, admTxt.getText());
            pst.setString(2, ((JTextField)doaChooser.getDateEditor().getUiComponent()).getText());
            //pst.setDate(2, new java.sql.Date(doaChooser.getDate().getTime()));
            pst.setString(3, fnameTxt.getText());
            pst.setString(4, MnameTxt.getText());
            pst.setString(5, LnameTxt.getText());
            pst.setString(6, getGender());
            pst.setString(7, ((JTextField)dobChooser.getDateEditor().getUiComponent()).getText());
            //pst.setDate(7, new java.sql.Date(dobChooser.getDate().getTime()));
            pst.setString(8, classComboBox.getSelectedItem().toString());
            pst.setString(9, FatherTxt.getText());
            pst.setString(10, MotherTxt.getText());
            pst.setString(11, mobTxt.getText());
            pst.setString(12, categoryComboBox.getSelectedItem().toString());
            pst.setString(13, NationTxt.getText());
            pst.setString(14, StateTxt.getText());
            pst.setString(15, addressTxt.getText());
            pst.setString(16, AdharTxt.getText());
            pst.setString(17, sssmidTxt.getText());
            pst.setBytes(18, image);
            pst.setBytes(19, adhar);
            pst.setBytes(20, sssmid);
            pst.setBytes(21, caste);
            pst.setBytes(22, birth);
            pst.setBytes(23, tc);

            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Admission successful");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Admission Unsuccessful"+ex);
            System.out.println(""+ ex);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        validateInput();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void imageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageButtonActionPerformed
        image = selectFileToUpload(ImageTxt);
    }//GEN-LAST:event_imageButtonActionPerformed

    private void adharButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adharButtonActionPerformed
        adhar = selectFileToUpload(AdharCertiTxt);
        if(adhar == null){
            System.out.println("adhar is null");
        }
    }//GEN-LAST:event_adharButtonActionPerformed

    private void sssmidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sssmidButtonActionPerformed
        sssmid = selectFileToUpload(sssmidCertiTxt);
        if(sssmid == null){
            System.out.println("sssmid is null");
        }
    }//GEN-LAST:event_sssmidButtonActionPerformed

    private void casteCertificateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casteCertificateButtonActionPerformed
       caste = selectFileToUpload(casteCertiTxt);
    }//GEN-LAST:event_casteCertificateButtonActionPerformed

    private void birthCertificateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthCertificateButtonActionPerformed
        birth = selectFileToUpload(birthCertiTxt);
    }//GEN-LAST:event_birthCertificateButtonActionPerformed

    private void tcCertificateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcCertificateButtonActionPerformed
        tc = selectFileToUpload(TcCertiTxt);
    }//GEN-LAST:event_tcCertificateButtonActionPerformed

    private byte[] selectFileToUpload(JTextField textfield){
        byte[] output = null;
        
        JFileChooser fileChooser = new JFileChooser();
        int  selected = fileChooser.showOpenDialog(null);
        
        if(selected == JFileChooser.APPROVE_OPTION){
            File f = fileChooser.getSelectedFile();
            fileName = f.getAbsolutePath();
            textfield.setText(fileName);
            
            try{
                File file = new File(fileName);
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];

                for(int readNum; (readNum = fis.read(buffer)) != -1;){
                    bos.write(buffer, 0,readNum);
                }

                output = bos.toByteArray();

            }catch(IOException e){
                System.out.println("" + e.getMessage());
            }
        }
        return output;
    }
    
    private void validateInput(){
        if(!admTxt.getText().trim().isEmpty()){
            if(!doaChooser.getCalendar().equals(null)){
                if(!fnameTxt.getText().trim().isEmpty()){
                    if(jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected()){
                        if(!dobChooser.getCalendar().equals(null)){
                            if(classComboBox.getSelectedIndex()!= 0){
                                if(categoryComboBox.getSelectedIndex()!= 0){
                                    if(!NationTxt.getText().trim().isEmpty()){
                                        if(!StateTxt.getText().trim().isEmpty()){
                                            if(!addressTxt.getText().trim().isEmpty()){
                                                /**
                                                 * 
                                                 */
                                                submitButton.setEnabled(true);
                                                /**
                                                 * 
                                                 */
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Address can't be empty!");
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "State can't be empty!");
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Nationality can't be empty!");
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Valid Category must be selected!");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Valid Class must be selected!");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Date of birth can't be empty!");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Gender must be selected");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "First Name can't be empty!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Date of addmission can't be empty!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Scholar Number can't be empty!");
        }
    }
    
    private void reset(){
        submitButton.setEnabled(false);
        admTxt.setText("");
        fnameTxt.setText("");
        MnameTxt.setText("");
        LnameTxt.setText("");
        FatherTxt.setText("");
        MotherTxt.setText("");
        mobTxt.setText("");
        NationTxt.setText("");
        StateTxt.setText("");
        AdharTxt.setText("");
        sssmidTxt.setText("");
        addressTxt.setText("");
        bg.clearSelection();
        classComboBox.setSelectedIndex(0);
        categoryComboBox.setSelectedIndex(0);
        dobChooser.setCalendar(null);
        doaChooser.setCalendar(null);
    }
    
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
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admission().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdharCertiTxt;
    private javax.swing.JLabel AdharLabel;
    private javax.swing.JTextField AdharTxt;
    private javax.swing.JTextField FatherTxt;
    private javax.swing.JLabel FnameLabel;
    private javax.swing.JTextField ImageTxt;
    private javax.swing.JLabel LnameLabel;
    private javax.swing.JTextField LnameTxt;
    private javax.swing.JLabel MnameLabel;
    private javax.swing.JTextField MnameTxt;
    private javax.swing.JTextField MotherTxt;
    private javax.swing.JTextField NationTxt;
    private javax.swing.JTextField StateTxt;
    private javax.swing.JTextField TcCertiTxt;
    private javax.swing.JTextArea addressTxt;
    private javax.swing.JButton adharButton;
    private javax.swing.JTextField admTxt;
    private javax.swing.JLabel admissionLabel;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JTextField birthCertiTxt;
    private javax.swing.JButton birthCertificateButton;
    private javax.swing.JTextField casteCertiTxt;
    private javax.swing.JButton casteCertificateButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JComboBox<String> classComboBox;
    private javax.swing.JLabel classLabel1;
    private javax.swing.JLabel daolabel;
    private com.toedter.calendar.JDateChooser doaChooser;
    private com.toedter.calendar.JDateChooser dobChooser;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel fatherNameLabel;
    private javax.swing.JTextField fnameTxt;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JButton imageButton;
    private javax.swing.JLabel jLabel_SSSMID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mobNoLabel;
    private javax.swing.JTextField mobTxt;
    private javax.swing.JLabel motherNameLabel;
    private javax.swing.JLabel nationalityLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton sssmidButton;
    private javax.swing.JTextField sssmidCertiTxt;
    private javax.swing.JTextField sssmidTxt;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JLabel stateLabel1;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton tcCertificateButton;
    // End of variables declaration//GEN-END:variables
}
