
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class StudentRecords extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    JTextFieldDateEditor dtEditor;
    DefaultTableModel model;
    
    String adm;
    
    public StudentRecords() {
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
        
        getSchoolInfo();
        fillclasscomboBox(classComboBox);
        fillclasscomboBox(classComboBox1);
        initDateEditor();   
    }
    
    private void getSchoolInfo(){
        try{
            String query = "select * from SchoolDetail";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
                schoolNameLabel.setText(rs.getString("Name"));
                addressLabel.setText(rs.getString("Address"));
            }
            pst.close();
        }catch(SQLException e){
            System.out.println(""+ e.getMessage());
        }
    }
    
    private void fillclasscomboBox(JComboBox comboBox){
        try{
            String query = "select distinct Class from ClassDetail order by class asc";
            pst =con.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String c = rs.getString("class");
                comboBox.addItem(c);
            }
            pst.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fillsectioncomboBox(JComboBox sectionComboBox, JComboBox classComboBox){
              
        sectionComboBox.removeAllItems();
        try{
            String query = "select Section from ClassDetail where Class='"+classComboBox.getSelectedItem().toString()+"'";
            pst =con.prepareStatement(query);
            rs = pst.executeQuery();
                         
            while(rs.next()){
                String s = rs.getString("section");
                sectionComboBox.addItem(s);
            }
            pst.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("" + e);
        }
    }
    
    private void initDateEditor(){
        dtEditor = (JTextFieldDateEditor)dobChooser.getDateEditor();
        dtEditor.setEditable(false);
    }
    
    private void printRecord(JPanel panel){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Record");
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex>0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D graphics2D = (Graphics2D)graphics;
                graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                // default scale  is 0.3
                graphics2D.scale(0.4, 0.4);
                
                panel.paint(graphics2D);
                
                return Printable.PAGE_EXISTS;
            }
        });
        
        boolean result = printerJob.printDialog();
        
        if(result){
            try{
                printerJob.print();
            }
            catch(PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error!"+printerException.getMessage());
            }
        }
        
    }
    
    public void reset(){
        saveButton.setEnabled(false);

        admTxt.setText("");
        nameTxt.setText("");
        rollNoTxt.setText("");
        fatherTxt.setText("");
        motherTxt.setText("");
        mobileNoTxt.setText("");
        adharTxt.setText("");
        sssmidTxt.setText("");
        addressTxt.setText("");
        remarksTxt.setText("");  
        buttonGroup1.clearSelection();
        classComboBox.setSelectedIndex(0);
        categoryComboBox.setSelectedIndex(0);
        dobChooser.setCalendar(null);
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        fatherNameLabel = new javax.swing.JLabel();
        fatherTxt = new javax.swing.JTextField();
        motherNameLabel = new javax.swing.JLabel();
        motherTxt = new javax.swing.JTextField();
        stateLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTxt = new javax.swing.JTextArea();
        AdharLabel = new javax.swing.JLabel();
        adharTxt = new javax.swing.JTextField();
        sssmidTxt = new javax.swing.JTextField();
        sssmidLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        stateLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTxt = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        FnameLabel = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        dobLabel = new javax.swing.JLabel();
        mobNoLabel = new javax.swing.JLabel();
        mobileNoTxt = new javax.swing.JTextField();
        classLabel1 = new javax.swing.JLabel();
        sectionLabel = new javax.swing.JLabel();
        dobChooser = new com.toedter.calendar.JDateChooser();
        sectionComboBox = new javax.swing.JComboBox<>();
        classComboBox = new javax.swing.JComboBox<>();
        admissionLabel = new javax.swing.JLabel();
        admTxt = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        rollNoTxt = new javax.swing.JTextField();
        FnameLabel1 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        admissionLabel1 = new javax.swing.JLabel();
        classComboBox1 = new javax.swing.JComboBox<>();
        admissionLabel2 = new javax.swing.JLabel();
        sectionComboBox1 = new javax.swing.JComboBox<>();
        deleteButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        detailPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sectionTxt = new javax.swing.JTextField();
        classTxt = new javax.swing.JTextField();
        schoolNameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 222, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 153, 153)));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        fatherNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        fatherNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fatherNameLabel.setText("Father Name");

        fatherTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        fatherTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fatherTxtKeyReleased(evt);
            }
        });

        motherNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        motherNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        motherNameLabel.setText("Mother Name");

        motherTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        motherTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                motherTxtKeyReleased(evt);
            }
        });

        stateLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        stateLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stateLabel1.setText("Address");

        addressTxt.setColumns(20);
        addressTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        addressTxt.setRows(5);
        jScrollPane1.setViewportView(addressTxt);

        AdharLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        AdharLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdharLabel.setText("Adhar No.");

        adharTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        adharTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adharTxtKeyPressed(evt);
            }
        });

        sssmidTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        sssmidTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sssmidTxtKeyPressed(evt);
            }
        });

        sssmidLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        sssmidLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sssmidLabel.setText("SSSMID No.");

        categoryLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        categoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoryLabel.setText("Category");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Gen", "OBC", "SC", "ST" }));
        categoryComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        stateLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        stateLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stateLabel2.setText("Remarks");

        remarksTxt.setColumns(20);
        remarksTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        remarksTxt.setRows(5);
        jScrollPane2.setViewportView(remarksTxt);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(AdharLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(fatherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fatherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(stateLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(motherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(sssmidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(24, 24, 24))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(stateLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(24, 24, 24)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1)
                                    .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(adharTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sssmidTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(motherTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))))
                        .addGap(20, 20, 20))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fatherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stateLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdharLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adharTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sssmidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sssmidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stateLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        FnameLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        FnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FnameLabel.setText("Name");

        nameTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTxtKeyReleased(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderLabel.setText("Gender");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jRadioButton1.setText("Male");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jRadioButton2.setText("Female");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        dobLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        dobLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dobLabel.setText("D.O.B");

        mobNoLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        mobNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mobNoLabel.setText("Mob No.");

        mobileNoTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        mobileNoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobileNoTxtKeyPressed(evt);
            }
        });

        classLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        classLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        classLabel1.setText("Class");

        sectionLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        sectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sectionLabel.setText("Section");

        dobChooser.setDateFormatString("dd/MM/yyyy");
        dobChooser.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        sectionComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        classComboBox.setMaximumRowCount(50);
        classComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        classComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        classComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                classComboBoxItemStateChanged(evt);
            }
        });

        admissionLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        admissionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admissionLabel.setText("Adm No.");

        admTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        admTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admTxtKeyPressed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jRadioButton3.setText("Other");
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rollNoTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        rollNoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rollNoTxtKeyPressed(evt);
            }
        });

        FnameLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        FnameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FnameLabel1.setText("Roll No.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(admissionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(admTxt)
                            .addComponent(nameTxt)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(FnameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(33, 33, 33)
                                        .addComponent(jRadioButton2)
                                        .addGap(39, 39, 39)
                                        .addComponent(jRadioButton3))
                                    .addComponent(rollNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(mobileNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(dobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dobChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mobNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admissionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FnameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dobChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobileNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        nextButton.setBackground(new java.awt.Color(102, 102, 255));
        nextButton.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        nextButton.setText("Next");
        nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(255, 51, 102));
        resetButton.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        resetButton.setText("Reset");
        resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(51, 255, 51));
        saveButton.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        saveButton.setText("Save");
        saveButton.setAutoscrolls(true);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 99, 244));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT RECORD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(443, 443, 443)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Create", jPanel1);

        jPanel2.setBackground(new java.awt.Color(243, 252, 232));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 153, 153)));

        admissionLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        admissionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admissionLabel1.setText("Class");

        classComboBox1.setMaximumRowCount(50);
        classComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        classComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        classComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                classComboBox1ItemStateChanged(evt);
            }
        });

        admissionLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        admissionLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admissionLabel2.setText("Section");

        sectionComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(admissionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(admissionLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sectionComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(admissionLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sectionComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(admissionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(classComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        deleteButton.setBackground(new java.awt.Color(255, 102, 96));
        deleteButton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        printButton.setBackground(new java.awt.Color(102, 102, 255));
        printButton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(0, 218, 145));
        updateButton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        updateButton.setText("Update");
        updateButton.setEnabled(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(255, 204, 255));
        searchButton.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        detailPanel.setBackground(new java.awt.Color(255, 255, 255));
        detailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admission No.", "Roll No.", "Name", "Class", "Section", "D.O.B", "Gender", "Father Name", "Mother Name", "Contact", "Category", "Address", "Adhar No.", "SSSMID No.", "Remarks"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 147, 133));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Class");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 147, 133));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Section");

        sectionTxt.setEditable(false);
        sectionTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        classTxt.setEditable(false);
        classTxt.setMinimumSize(new java.awt.Dimension(6, 26));
        classTxt.setPreferredSize(new java.awt.Dimension(6, 26));

        schoolNameLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        schoolNameLabel.setForeground(new java.awt.Color(255, 153, 153));
        schoolNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolNameLabel.setText("ANANDA MARGA MIDDLE SCHOOL");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("STUDENT RECORD");

        addressLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addressLabel.setText("Security Line , Govindpura BHEL Bhopal");

        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(detailPanel);
        detailPanel.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1323, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanelLayout.createSequentialGroup()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(classTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(sectionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(schoolNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGap(519, 519, 519)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(schoolNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(classTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(sectionTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressLabel)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(detailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(updateButton)
                        .addGap(55, 55, 55)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 517, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(searchButton)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(detailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("View", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fatherTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherTxtKeyReleased
        covertToUpperCase(fatherTxt);
    }//GEN-LAST:event_fatherTxtKeyReleased

    private void motherTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motherTxtKeyReleased
        covertToUpperCase(motherTxt);
    }//GEN-LAST:event_motherTxtKeyReleased

    private void adharTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adharTxtKeyPressed
        restictInputToIntegerAndByLength(adharTxt, evt, 12);
    }//GEN-LAST:event_adharTxtKeyPressed

    private void sssmidTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sssmidTxtKeyPressed
        restrictInputToInteger(sssmidTxt, evt);
    }//GEN-LAST:event_sssmidTxtKeyPressed

    private void nameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyReleased
        covertToUpperCase(nameTxt);
    }//GEN-LAST:event_nameTxtKeyReleased

    private void mobileNoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileNoTxtKeyPressed
        restictInputToIntegerAndByLength(mobileNoTxt, evt, 10);
    }//GEN-LAST:event_mobileNoTxtKeyPressed

    private void classComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_classComboBoxItemStateChanged
        fillsectioncomboBox(sectionComboBox, classComboBox);
    }//GEN-LAST:event_classComboBoxItemStateChanged

    private void admTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admTxtKeyPressed
        restrictInputToInteger(admTxt, evt);
    }//GEN-LAST:event_admTxtKeyPressed

    private void rollNoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rollNoTxtKeyPressed
        restrictInputToInteger(rollNoTxt, evt);
    }//GEN-LAST:event_rollNoTxtKeyPressed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if(!admTxt.getText().trim().isEmpty()){
            if(!nameTxt.getText().trim().isEmpty()){
                if(classComboBox.getSelectedIndex()!= 0){
                    if(jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected()){
                        if(!dobChooser.getCalendar().equals(null)){
                            /**
                             * 
                             */
                            saveButton.setEnabled(true);
                            /**
                             * 
                             */
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Date of birth can't be empty!");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Gender must be selected!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Valid Class must be selected!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Name filed can't be empty!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Admission Number can't be empty!");
        }   
    }//GEN-LAST:event_nextButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try{
            String query = "insert into StudentRecords (AdmNo,Name,Class,Section,RollNo,Gender,DateOfBirth,"
                    + "MobileNo,FatherName,MotherName,Category,Address,AdharNo,SSSMID,Remarks)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);

            pst.setString(1, admTxt.getText());
            pst.setString(2, nameTxt.getText());
            pst.setString(3, classComboBox.getSelectedItem().toString());
            pst.setString(4, sectionComboBox.getSelectedItem().toString());
            pst.setString(5, rollNoTxt.getText());
            pst.setString(6, getGender());
            pst.setString(7, ((JTextField)dobChooser.getDateEditor().getUiComponent()).getText());
            pst.setString(8, mobileNoTxt.getText());
            pst.setString(9, fatherTxt.getText());
            pst.setString(10, motherTxt.getText());
            pst.setString(11, categoryComboBox.getSelectedItem().toString());
            pst.setString(12, addressTxt.getText());
            pst.setString(13, adharTxt.getText());
            pst.setString(14, sssmidTxt.getText());
            pst.setString(15, remarksTxt.getText());

            pst.executeUpdate();
            reset();
            
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Saved");
        }
        catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(""+ ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void classComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_classComboBox1ItemStateChanged
       fillsectioncomboBox(sectionComboBox1, classComboBox1);
    }//GEN-LAST:event_classComboBox1ItemStateChanged

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            String query = "DELETE FROM StudentRecords where AdmNo='"+adm+"'";
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            pst.close();
            fetch();
            JOptionPane.showMessageDialog(null, "Deleted successfully");
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(""+ ex);
        }
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        printRecord(detailPanel);
    }//GEN-LAST:event_printButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            String query = "update StudentRecords set Name=?,Class=?,Section=?,RollNo=?,Gender=?,DateOfBirth=?,MobileNo=?,FatherName=?"
                    + ",MotherName=?,Category=?,Address=?,AdharNo=?,SSSMID=?,Remarks=? where AdmNo='" + adm + "'";
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            pst.close();
            fetch();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        }
        catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(""+ ex);
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        fetch();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        deleteButton.setEnabled(true);
        updateButton.setEnabled(true);
        int SelectedRowIndex = jTable1.getSelectedRow();
        model = (DefaultTableModel)jTable1.getModel();

        adm = model.getValueAt(SelectedRowIndex, 0).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void fetch(){
        try{
            String query = "select * from StudentRecords where Class='" + classComboBox1.getSelectedItem().toString() + 
                    "' AND Section='" + sectionComboBox1.getSelectedItem().toString() + "' order by RollNo";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
            classTxt.setText((String) classComboBox1.getSelectedItem());
            sectionTxt.setText((String) sectionComboBox1.getSelectedItem());
            
            pst.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(""+ e);
        }
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
            java.util.logging.Logger.getLogger(StudentRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdharLabel;
    private javax.swing.JLabel FnameLabel;
    private javax.swing.JLabel FnameLabel1;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextArea addressTxt;
    private javax.swing.JTextField adharTxt;
    private javax.swing.JTextField admTxt;
    private javax.swing.JLabel admissionLabel;
    private javax.swing.JLabel admissionLabel1;
    private javax.swing.JLabel admissionLabel2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JComboBox<String> classComboBox;
    private javax.swing.JComboBox<String> classComboBox1;
    private javax.swing.JLabel classLabel1;
    private javax.swing.JTextField classTxt;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel detailPanel;
    private com.toedter.calendar.JDateChooser dobChooser;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel fatherNameLabel;
    private javax.swing.JTextField fatherTxt;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel mobNoLabel;
    private javax.swing.JTextField mobileNoTxt;
    private javax.swing.JLabel motherNameLabel;
    private javax.swing.JTextField motherTxt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton printButton;
    private javax.swing.JTextArea remarksTxt;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField rollNoTxt;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel schoolNameLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> sectionComboBox;
    private javax.swing.JComboBox<String> sectionComboBox1;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JTextField sectionTxt;
    private javax.swing.JLabel sssmidLabel;
    private javax.swing.JTextField sssmidTxt;
    private javax.swing.JLabel stateLabel1;
    private javax.swing.JLabel stateLabel2;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
