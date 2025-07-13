/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.loggers.view;

import br.com.loggers.controller.Controller;
import br.com.loggers.controller.User;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import popup.glasspanepopup.GlassPanePopup;


public class View extends javax.swing.JFrame {

    public String name;
    boolean visible = false;
    User logged;
    public JPasswordField getjPasswordFieldSenha() {
        return jPasswordFieldSenha;
    }

    public JTextField getjTextFieldEmail() {
        return jTextFieldEmail;
    }
    
    public void updateMenu(){
        ordem_servicoButton.setFont(carregarFonte(Font.PLAIN, 12));
        manutencoesButton.setFont(carregarFonte(Font.PLAIN, 12));
        logButton.setFont(carregarFonte(Font.PLAIN, 12));
        relatoriosButton.setFont(carregarFonte(Font.PLAIN, 12));
        ativosButton.setFont(carregarFonte(Font.PLAIN, 12));
        
        ordem_servicoButton.setForeground(new Color(0, 0, 0));
        manutencoesButton.setForeground(new Color(0, 0, 0));
        logButton.setForeground(new Color(0, 0, 0));
        relatoriosButton.setForeground(new Color(0, 0, 0));
        ativosButton.setForeground(new Color(0, 0, 0));
        
        ordem_servicoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ChartBlack.png")));
        manutencoesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Vector.png")));
        logButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Clock.png")));
        relatoriosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Document.png")));
        ativosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Box.png")));
    }
    
    public void updateOS(){
        Controller theController = new Controller();
        OSTable.setModel(theController.getOSTable());
        pendenteLabel.setText("<html><body style='text-align: center'>"+ String.valueOf(theController.countPendente())+"<br>Pendentes");
        andamentoLabel.setText("<html><body style='text-align: center'>"+ String.valueOf(theController.countAndamento())+"<br>Em andamento");
        finalizadoLabel.setText("<html><body style='text-align: center'>"+ String.valueOf(theController.countFinalizado())+"<br>Finalizadas");
        agendadoLabel.setText("<html><body style='text-align: center'>"+ String.valueOf(theController.countAgendado())+"<br>Agendadas");
        
        
        OSTable.getTableHeader().setFont(carregarFonte(Font.BOLD, 16));
        OSTable.getTableHeader().setPreferredSize(new Dimension(100, 50));
        TableColumnModel columnModel = OSTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(280);
        columnModel.getColumn(2).setPreferredWidth(220);
        columnModel.getColumn(3).setPreferredWidth(160);
        columnModel.getColumn(4).setPreferredWidth(180);
        columnModel.getColumn(5).setPreferredWidth(193);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply to all columns (optional: use specific indices if needed)
        for (int i = 0; i < OSTable.getColumnCount(); i++) {
            OSTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public void updateManutencao(){
        Controller theController = new Controller();
        manutencaoTable.setModel(theController.getManutencaoTable());
        
        manutencaoTable.getTableHeader().setFont(carregarFonte(Font.BOLD, 16));
        manutencaoTable.getTableHeader().setPreferredSize(new Dimension(100, 50));
        TableColumnModel columnModel2 = manutencaoTable.getColumnModel();
        columnModel2.getColumn(0).setPreferredWidth(100);
        columnModel2.getColumn(1).setPreferredWidth(300);
        columnModel2.getColumn(2).setPreferredWidth(220);
        columnModel2.getColumn(3).setPreferredWidth(200);
        columnModel2.getColumn(4).setPreferredWidth(200);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < manutencaoTable.getColumnCount(); i++) {
            manutencaoTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public void updateLogs(){
        Controller theController = new Controller();
        logsTable.setModel(theController.getLogsTable());
        
        logsTable.getTableHeader().setFont(carregarFonte(Font.BOLD, 16));
        logsTable.getTableHeader().setPreferredSize(new Dimension(100, 50));
        TableColumnModel columnModel3 = logsTable.getColumnModel();
        columnModel3.getColumn(0).setPreferredWidth(120);
        columnModel3.getColumn(1).setPreferredWidth(100);
        columnModel3.getColumn(2).setPreferredWidth(100);
        columnModel3.getColumn(3).setPreferredWidth(480);
        columnModel3.getColumn(4).setPreferredWidth(300);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < logsTable.getColumnCount(); i++) {
            logsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public void updateAtivo(){
        Controller theController = new Controller();
        ativoTable.setModel(theController.getAtivoTable());
        
        
        ativoTable.getTableHeader().setFont(carregarFonte(Font.BOLD, 16));
        ativoTable.getTableHeader().setPreferredSize(new Dimension(100, 50));
        TableColumnModel columnModel4 = ativoTable.getColumnModel();
        columnModel4.getColumn(0).setPreferredWidth(100);
        columnModel4.getColumn(1).setPreferredWidth(300);
        columnModel4.getColumn(2).setPreferredWidth(220);
        columnModel4.getColumn(3).setPreferredWidth(200);
        columnModel4.getColumn(4).setPreferredWidth(200);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < ativoTable.getColumnCount(); i++) {
            ativoTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    private void exportToPDF(JTable table) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setSelectedFile(new java.io.File("table_output.pdf"));
    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        java.io.File fileToSave = fileChooser.getSelectedFile();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
            document.open();

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // Add column headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(new Phrase(table.getColumnName(i))));
            }

            // Add rows
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getValueAt(row, col);
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }

            document.add(pdfTable);
            document.close();

            GlassPanePopup.showPopup(new PopupView("PDF exportado com sucesso!", "Verifique sua pasta"));

        } catch (Exception ex) {
            ex.printStackTrace();
            GlassPanePopup.showPopup(new PopupView("Erro ao exportar o PDF", "Contate o administrador"));
        }
    }
}

    
    private void exportToCSV(JTable table) {
    try {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new java.io.File("table_output.csv"));
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter csvWriter = new FileWriter(fileToSave)) {

                // Write column names
                for (int i = 0; i < table.getColumnCount(); i++) {
                    csvWriter.append(table.getColumnName(i));
                    if (i != table.getColumnCount() - 1) csvWriter.append(",");
                }
                csvWriter.append("\n");

                // Write rows
                for (int row = 0; row < table.getRowCount(); row++) {
                    for (int col = 0; col < table.getColumnCount(); col++) {
                        Object cellValue = table.getValueAt(row, col);
                        csvWriter.append(cellValue != null ? cellValue.toString() : "");
                        if (col != table.getColumnCount() - 1) csvWriter.append(",");
                    }
                    csvWriter.append("\n");
                }

                GlassPanePopup.showPopup(new PopupView("CSV exportado com sucesso!", "Verifique sua pasta"));
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        GlassPanePopup.showPopup(new PopupView("Erro ao exportar o CSV", "Contate o administrador"));
    }
}
    
    public static Font carregarFonte(int estilo, float tamanho) {
    try {
        String caminhoFonte;

        switch (estilo) {
            case Font.BOLD:
                caminhoFonte = "/resources/fonts/Poppins-Bold.ttf";
                break;
            default:
                caminhoFonte = "/resources/fonts/Poppins-Medium.ttf";
                break;
        }

        InputStream is = View.class.getResourceAsStream(caminhoFonte);
        Font fonteBase = Font.createFont(Font.TRUETYPE_FONT, is);
        return fonteBase.deriveFont(estilo, tamanho);

    } catch (FontFormatException | IOException | NullPointerException e) {
        e.printStackTrace();
        return new JLabel().getFont(); // fallback: fonte padrão do Swing
    }
}
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(View.class.getName());

    /**
     * Creates new form LoginView
     */
    public View() {
        initComponents();
        GlassPanePopup.install(this);
        FlatLightLaf.install();
        
        
        
        relatorioTable.getTableHeader().setFont(carregarFonte(Font.BOLD, 16));
        relatorioTable.getTableHeader().setPreferredSize(new Dimension(100, 50));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < relatorioTable.getColumnCount(); i++) {
            relatorioTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane5 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        root = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cadastro = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldEmail2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldEmail1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jPasswordFieldSenha1 = new javax.swing.JPasswordField();
        jButton5 = new javax.swing.JButton();
        jPanel65 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        dashboard = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        nameUser = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        menu = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        ordem_servicoButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        manutencoesButton = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        logButton = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        relatoriosButton = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        ativosButton = new javax.swing.JButton();
        rootDashboard = new javax.swing.JPanel();
        ordem_servico = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel25 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        pendenteLabel = new javax.swing.JLabel();
        andamentoLabel = new javax.swing.JLabel();
        finalizadoLabel = new javax.swing.JLabel();
        agendadoLabel = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        OSTable = new javax.swing.JTable();
        manutencoes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        manutencaoTable = new javax.swing.JTable();
        historico = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        logsTable = new javax.swing.JTable();
        relatorio = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel41 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        relatorioTable = new javax.swing.JTable();
        ativo = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jPanel57 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel21 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ativoTable = new javax.swing.JTable();

        jScrollPane5.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setSize(new java.awt.Dimension(1440, 810));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        root.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setPreferredSize(new java.awt.Dimension(1440, 810));
        login.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(23, 50, 62));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/server_image_svg.png"))); // NOI18N
        jPanel2.add(jLabel1, new java.awt.GridBagConstraints());

        login.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(540, 810));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(360, 384));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setPreferredSize(new java.awt.Dimension(360, 100));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(carregarFonte(Font.BOLD, 28));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SGMP");
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setPreferredSize(new java.awt.Dimension(81, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel5.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(carregarFonte(Font.PLAIN, 16));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sistema de Gerenciamento");
        jLabel3.setToolTipText("");
        jLabel3.setAlignmentX(0.5F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        jPanel5.add(jLabel3, gridBagConstraints);

        jLabel28.setFont(carregarFonte(Font.PLAIN, 16));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("de Manutenção Predial");
        jLabel28.setAlignmentX(0.5F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        jPanel5.add(jLabel28, gridBagConstraints);

        jPanel4.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(360, 186));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setFont(carregarFonte(Font.PLAIN, 15));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("E-mail");
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel4.setPreferredSize(new java.awt.Dimension(49, 44));
        jPanel6.add(jLabel4);

        jTextFieldEmail.setFont(carregarFonte(Font.PLAIN, 15));
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldEmail.setAlignmentX(0.0F);
        jTextFieldEmail.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(java.awt.Color.decode("#D0D5DD"), 3, true),
            javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8)
        )
    );
    jTextFieldEmail.setPreferredSize(new java.awt.Dimension(360, 20));
    jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldEmailActionPerformed(evt);
        }
    });
    jPanel6.add(jTextFieldEmail);

    jLabel5.setFont(carregarFonte(Font.PLAIN, 15));
    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel5.setText("Senha");
    jLabel5.setPreferredSize(new java.awt.Dimension(48, 44));
    jPanel6.add(jLabel5);

    jPanel9.setBackground(new java.awt.Color(255, 255, 255));
    jPanel9.setAlignmentX(0.0F);
    jPanel9.setPreferredSize(new java.awt.Dimension(360, 20));
    jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.X_AXIS));

    jPasswordFieldSenha.setFont(carregarFonte(Font.BOLD, 15));
    jPasswordFieldSenha.setToolTipText("");
    jPasswordFieldSenha.setAlignmentX(0.0F);
    jPasswordFieldSenha.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(java.awt.Color.decode("#D0D5DD"), 3, true),
        javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8)
    )
    );
    jPasswordFieldSenha.setPreferredSize(new java.awt.Dimension(135, 20));
    jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jPasswordFieldSenhaActionPerformed(evt);
        }
    });
    jPanel9.add(jPasswordFieldSenha);

    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eye.png"))); // NOI18N
    jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(java.awt.Color.decode("#D0D5DD"), 3, true),
        javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8)
    )
    );
    jButton3.setPreferredSize(new java.awt.Dimension(40, 30));
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    jPanel9.add(jButton3);

    jPanel6.add(jPanel9);

    jPanel4.add(jPanel6);

    jPanel7.setBackground(new java.awt.Color(255, 255, 255));
    jPanel7.setAlignmentX(0.0F);
    jPanel7.setPreferredSize(new java.awt.Dimension(360, 120));
    jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.PAGE_AXIS));

    jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel6.setText("<html> </html>");
    jLabel6.setAlignmentX(1.0F);
    jPanel7.add(jLabel6);

    jButton1.setBackground(new java.awt.Color(60, 137, 166));
    jButton1.setFont(carregarFonte(Font.BOLD, 16));
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Entrar");
    jButton1.setAlignmentX(1.0F);
    jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    jButton1.setMaximumSize(new java.awt.Dimension(360, 52));
    jButton1.setPreferredSize(new java.awt.Dimension(360, 52));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    jPanel7.add(jButton1);

    jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel7.setText("<html></html>");
    jLabel7.setAlignmentX(1.0F);
    jPanel7.add(jLabel7);

    jButton2.setBackground(new java.awt.Color(60, 137, 166));
    jButton2.setFont(carregarFonte(Font.BOLD, 16));
    jButton2.setForeground(new java.awt.Color(255, 255, 255));
    jButton2.setText("Cadastrar");
    jButton2.setAlignmentX(1.0F);
    jButton2.setBorderPainted(false);
    jButton2.setFocusPainted(false);
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    jPanel7.add(jButton2);

    jPanel4.add(jPanel7);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap(102, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(78, 78, 78))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap(209, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(217, Short.MAX_VALUE))
    );

    login.add(jPanel3, java.awt.BorderLayout.EAST);

    root.add(login, "login");

    cadastro.setBackground(new java.awt.Color(255, 255, 255));
    cadastro.setPreferredSize(new java.awt.Dimension(1440, 810));
    cadastro.setLayout(new java.awt.BorderLayout());

    jPanel59.setBackground(new java.awt.Color(23, 50, 62));
    jPanel59.setMinimumSize(new java.awt.Dimension(0, 0));
    jPanel59.setLayout(new java.awt.GridBagLayout());

    jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/server_image_svg.png"))); // NOI18N
    jPanel59.add(jLabel22, new java.awt.GridBagConstraints());

    cadastro.add(jPanel59, java.awt.BorderLayout.CENTER);

    jPanel60.setBackground(new java.awt.Color(255, 255, 255));
    jPanel60.setPreferredSize(new java.awt.Dimension(540, 810));

    jPanel61.setBackground(new java.awt.Color(255, 255, 255));
    jPanel61.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
    jPanel61.setPreferredSize(new java.awt.Dimension(360, 384));
    jPanel61.setLayout(new javax.swing.BoxLayout(jPanel61, javax.swing.BoxLayout.Y_AXIS));

    jPanel62.setBackground(new java.awt.Color(255, 255, 255));
    jPanel62.setAlignmentX(0.0F);
    jPanel62.setPreferredSize(new java.awt.Dimension(360, 40));
    jPanel62.setLayout(new java.awt.GridBagLayout());

    jLabel29.setFont(carregarFonte(Font.PLAIN, 16));
    jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel29.setText("Sistema de Gerenciamento");
    jLabel29.setToolTipText("");
    jLabel29.setAlignmentX(0.5F);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    jPanel62.add(jLabel29, gridBagConstraints);

    jLabel32.setFont(carregarFonte(Font.BOLD, 28));
    jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel32.setText("SGMP");
    jLabel32.setAlignmentX(0.5F);
    jLabel32.setPreferredSize(new java.awt.Dimension(81, 28));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
    jPanel62.add(jLabel32, gridBagConstraints);

    jLabel33.setFont(carregarFonte(Font.PLAIN, 16));
    jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel33.setText("de Manutenção Predial");
    jLabel33.setAlignmentX(0.5F);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 3;
    jPanel62.add(jLabel33, gridBagConstraints);

    jPanel61.add(jPanel62);

    jPanel63.setBackground(new java.awt.Color(255, 255, 255));
    jPanel63.setPreferredSize(new java.awt.Dimension(360, 210));
    jPanel63.setLayout(new javax.swing.BoxLayout(jPanel63, javax.swing.BoxLayout.Y_AXIS));

    jLabel27.setFont(carregarFonte(Font.PLAIN, 15));
    jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    jLabel27.setText("Nome");
    jLabel27.setFocusable(false);
    jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    jLabel27.setPreferredSize(new java.awt.Dimension(49, 44));
    jPanel63.add(jLabel27);

    jTextFieldEmail2.setFont(carregarFonte(Font.PLAIN, 15));
    jTextFieldEmail2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    jTextFieldEmail2.setAlignmentX(0.0F);
    jTextFieldEmail2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(java.awt.Color.decode("#D0D5DD"), 3, true),
        javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8)
    )
    );
    jTextFieldEmail2.setPreferredSize(new java.awt.Dimension(360, 20));
    jTextFieldEmail2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldEmail2ActionPerformed(evt);
        }
    });
    jPanel63.add(jTextFieldEmail2);

    jLabel25.setFont(carregarFonte(Font.PLAIN, 15));
    jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    jLabel25.setText("E-mail");
    jLabel25.setFocusable(false);
    jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    jLabel25.setPreferredSize(new java.awt.Dimension(49, 44));
    jPanel63.add(jLabel25);

    jTextFieldEmail1.setFont(carregarFonte(Font.PLAIN, 15));
    jTextFieldEmail1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    jTextFieldEmail1.setAlignmentX(0.0F);
    jTextFieldEmail1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(java.awt.Color.decode("#D0D5DD"), 3, true),
        javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8)
    )
    );
    jTextFieldEmail1.setPreferredSize(new java.awt.Dimension(360, 20));
    jTextFieldEmail1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldEmail1ActionPerformed(evt);
        }
    });
    jPanel63.add(jTextFieldEmail1);

    jLabel26.setFont(carregarFonte(Font.PLAIN, 15));
    jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel26.setText("Senha");
    jLabel26.setPreferredSize(new java.awt.Dimension(48, 44));
    jPanel63.add(jLabel26);

    jPanel64.setBackground(new java.awt.Color(255, 255, 255));
    jPanel64.setAlignmentX(0.0F);
    jPanel64.setPreferredSize(new java.awt.Dimension(360, 20));
    jPanel64.setLayout(new javax.swing.BoxLayout(jPanel64, javax.swing.BoxLayout.X_AXIS));

    jPasswordFieldSenha1.setFont(carregarFonte(Font.BOLD, 15));
    jPasswordFieldSenha1.setToolTipText("");
    jPasswordFieldSenha1.setAlignmentX(0.0F);
    jPasswordFieldSenha1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(java.awt.Color.decode("#D0D5DD"), 3, true),
        javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8)
    )
    );
    jPasswordFieldSenha1.setPreferredSize(new java.awt.Dimension(135, 20));
    jPanel64.add(jPasswordFieldSenha1);

    jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eye.png"))); // NOI18N
    jButton5.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(java.awt.Color.decode("#D0D5DD"), 3, true),
        javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8)
    )
    );
    jButton5.setPreferredSize(new java.awt.Dimension(40, 30));
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });
    jPanel64.add(jButton5);

    jPanel63.add(jPanel64);

    jPanel61.add(jPanel63);

    jPanel65.setBackground(new java.awt.Color(255, 255, 255));
    jPanel65.setAlignmentX(0.0F);
    jPanel65.setPreferredSize(new java.awt.Dimension(360, 120));
    jPanel65.setLayout(new javax.swing.BoxLayout(jPanel65, javax.swing.BoxLayout.PAGE_AXIS));

    jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel30.setText("<html> </html>");
    jLabel30.setAlignmentX(1.0F);
    jPanel65.add(jLabel30);

    jButton7.setBackground(new java.awt.Color(60, 137, 166));
    jButton7.setFont(carregarFonte(Font.BOLD, 16));
    jButton7.setForeground(new java.awt.Color(255, 255, 255));
    jButton7.setText("Cadastrar");
    jButton7.setAlignmentX(1.0F);
    jButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    jButton7.setMaximumSize(new java.awt.Dimension(360, 52));
    jButton7.setPreferredSize(new java.awt.Dimension(360, 52));
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });
    jPanel65.add(jButton7);

    jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel31.setText("<html></html>");
    jLabel31.setAlignmentX(1.0F);
    jPanel65.add(jLabel31);

    jButton8.setBackground(new java.awt.Color(60, 137, 166));
    jButton8.setFont(carregarFonte(Font.BOLD, 16));
    jButton8.setForeground(new java.awt.Color(255, 255, 255));
    jButton8.setText("Voltar");
    jButton8.setAlignmentX(1.0F);
    jButton8.setBorderPainted(false);
    jButton8.setFocusPainted(false);
    jButton8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton8ActionPerformed(evt);
        }
    });
    jPanel65.add(jButton8);

    jPanel61.add(jPanel65);

    javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
    jPanel60.setLayout(jPanel60Layout);
    jPanel60Layout.setHorizontalGroup(
        jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
            .addContainerGap(102, Short.MAX_VALUE)
            .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(78, 78, 78))
    );
    jPanel60Layout.setVerticalGroup(
        jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
            .addContainerGap(173, Short.MAX_VALUE)
            .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(170, Short.MAX_VALUE))
    );

    cadastro.add(jPanel60, java.awt.BorderLayout.EAST);

    root.add(cadastro, "cadastro");

    dashboard.setLayout(new java.awt.BorderLayout());

    header.setBackground(new java.awt.Color(60, 137, 166));
    header.setPreferredSize(new java.awt.Dimension(1440, 64));
    header.setLayout(new java.awt.BorderLayout());

    jLabel8.setFont(carregarFonte(Font.BOLD, 24));
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("SGMP");
    jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
    header.add(jLabel8, java.awt.BorderLayout.LINE_START);

    jPanel1.setBackground(new java.awt.Color(60, 137, 166));
    jPanel1.setPreferredSize(new java.awt.Dimension(220, 100));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel17.setBackground(new java.awt.Color(60, 137, 166));
    jPanel17.setPreferredSize(new java.awt.Dimension(198, 32));
    jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));

    nameUser.setFont(carregarFonte(Font.PLAIN, 12));
    nameUser.setForeground(new java.awt.Color(255, 255, 255));
    nameUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user-3296.png"))); // NOI18N
    nameUser.setText("  Técnico - Mário");
    jPanel17.add(nameUser);

    jButton9.setBackground(new java.awt.Color(60, 137, 166));
    jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/chevron_down.png"))); // NOI18N
    jButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
    jButton9.setBorderPainted(false);
    jButton9.setContentAreaFilled(false);
    jButton9.setFocusPainted(false);
    jPanel17.add(jButton9);

    jButton10.setBackground(new java.awt.Color(60, 137, 166));
    jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/notifica.png"))); // NOI18N
    jButton10.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
    jButton10.setBorderPainted(false);
    jButton10.setFocusPainted(false);
    jButton10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton10ActionPerformed(evt);
        }
    });
    jPanel17.add(jButton10);

    jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, 200, 32));

    header.add(jPanel1, java.awt.BorderLayout.LINE_END);

    dashboard.add(header, java.awt.BorderLayout.PAGE_START);

    menu.setBackground(new java.awt.Color(255, 255, 255));
    menu.setMinimumSize(new java.awt.Dimension(0, 0));
    menu.setPreferredSize(new java.awt.Dimension(263, 746));
    menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel10.setBackground(new java.awt.Color(255, 255, 255));
    jPanel10.setPreferredSize(new java.awt.Dimension(183, 256));
    jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

    jPanel11.setBackground(new java.awt.Color(255, 255, 255));
    jPanel11.setMaximumSize(new java.awt.Dimension(2147483647, 42));
    jPanel11.setPreferredSize(new java.awt.Dimension(183, 42));
    jPanel11.setLayout(new java.awt.BorderLayout());

    jLabel9.setFont(carregarFonte(Font.BOLD, 14));
    jLabel9.setText("Menu");
    jPanel11.add(jLabel9, java.awt.BorderLayout.LINE_START);

    jPanel10.add(jPanel11);

    jPanel12.setBackground(new java.awt.Color(255, 255, 255));
    jPanel12.setPreferredSize(new java.awt.Dimension(183, 42));

    ordem_servicoButton.setFont(carregarFonte(Font.BOLD, 12));
    ordem_servicoButton.setForeground(new java.awt.Color(60, 137, 166));
    ordem_servicoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Chart.png"))); // NOI18N
    ordem_servicoButton.setText("  Ordens de Serviço");
    ordem_servicoButton.setBorderPainted(false);
    ordem_servicoButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ordem_servicoButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ordem_servicoButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(ordem_servicoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(ordem_servicoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
    );

    jPanel10.add(jPanel12);

    jPanel13.setBackground(new java.awt.Color(255, 255, 255));
    jPanel13.setPreferredSize(new java.awt.Dimension(183, 42));

    manutencoesButton.setFont(carregarFonte(Font.PLAIN, 12));
    manutencoesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Vector.png"))); // NOI18N
    manutencoesButton.setText("  Manutenções");
    manutencoesButton.setBorderPainted(false);
    manutencoesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    manutencoesButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            manutencoesButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
    jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(manutencoesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel13Layout.setVerticalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(manutencoesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
    );

    jPanel10.add(jPanel13);

    jPanel14.setBackground(new java.awt.Color(255, 255, 255));
    jPanel14.setPreferredSize(new java.awt.Dimension(183, 42));

    logButton.setFont(carregarFonte(Font.PLAIN, 12));
    logButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Clock.png"))); // NOI18N
    logButton.setText("  Logs de Sistema");
    logButton.setBorderPainted(false);
    logButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    logButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            logButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
    jPanel14.setLayout(jPanel14Layout);
    jPanel14Layout.setHorizontalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(logButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel14Layout.setVerticalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(logButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
    );

    jPanel10.add(jPanel14);

    jPanel15.setBackground(new java.awt.Color(255, 255, 255));
    jPanel15.setPreferredSize(new java.awt.Dimension(183, 42));

    relatoriosButton.setFont(carregarFonte(Font.PLAIN, 12));
    relatoriosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Document.png"))); // NOI18N
    relatoriosButton.setText("  Relatórios");
    relatoriosButton.setBorderPainted(false);
    relatoriosButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    relatoriosButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            relatoriosButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
    jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(relatoriosButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel15Layout.setVerticalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(relatoriosButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
    );

    jPanel10.add(jPanel15);

    jPanel16.setBackground(new java.awt.Color(255, 255, 255));
    jPanel16.setPreferredSize(new java.awt.Dimension(183, 42));

    ativosButton.setFont(carregarFonte(Font.PLAIN, 12));
    ativosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Box.png"))); // NOI18N
    ativosButton.setText("  Ativos");
    ativosButton.setBorderPainted(false);
    ativosButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ativosButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ativosButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
    jPanel16.setLayout(jPanel16Layout);
    jPanel16Layout.setHorizontalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(ativosButton, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
    );
    jPanel16Layout.setVerticalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(ativosButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
    );

    jPanel10.add(jPanel16);

    menu.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 300));

    dashboard.add(menu, java.awt.BorderLayout.LINE_START);

    rootDashboard.setLayout(new java.awt.CardLayout());

    ordem_servico.setBackground(new java.awt.Color(255, 255, 255));
    ordem_servico.setPreferredSize(new java.awt.Dimension(1177, 746));

    jScrollPane1.setPreferredSize(new java.awt.Dimension(1177, 776));

    jPanel25.setPreferredSize(new java.awt.Dimension(500, 1000));
    jPanel25.setLayout(new java.awt.BorderLayout());

    jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.Y_AXIS));

    jPanel18.setAlignmentX(0.0F);
    jPanel18.setPreferredSize(new java.awt.Dimension(1177, 130));
    jPanel18.setLayout(new java.awt.BorderLayout());

    jPanel23.setMinimumSize(new java.awt.Dimension(0, 0));
    jPanel23.setPreferredSize(new java.awt.Dimension(608, 60));
    jPanel23.setLayout(new java.awt.GridBagLayout());

    jPanel20.setPreferredSize(new java.awt.Dimension(508, 80));
    jPanel20.setLayout(new java.awt.BorderLayout());

    jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton4.setBackground(new java.awt.Color(23, 50, 62));
    jButton4.setFont(carregarFonte(Font.BOLD, 11));
    jButton4.setForeground(new java.awt.Color(255, 255, 255));
    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icon.png"))); // NOI18N
    jButton4.setText("Nova O.S");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    jPanel24.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, 108, 34));

    jPanel20.add(jPanel24, java.awt.BorderLayout.EAST);

    jPanel8.setMinimumSize(new java.awt.Dimension(400, 32));
    jPanel8.setPreferredSize(new java.awt.Dimension(400, 32));
    jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

    jLabel11.setFont(carregarFonte(Font.BOLD, 24));
    jLabel11.setText("Dashboard ");
    jPanel8.add(jLabel11);

    jLabel12.setFont(carregarFonte(Font.PLAIN, 13));
    jLabel12.setText("Progresso e organização das ordens de serviço");
    jLabel12.setMaximumSize(new java.awt.Dimension(1231231, 16));
    jLabel12.setMinimumSize(new java.awt.Dimension(400, 16));
    jLabel12.setPreferredSize(new java.awt.Dimension(400, 16));
    jPanel8.add(jLabel12);

    jPanel20.add(jPanel8, java.awt.BorderLayout.WEST);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(50, 50, 0, 50);
    jPanel23.add(jPanel20, gridBagConstraints);

    jPanel18.add(jPanel23, java.awt.BorderLayout.CENTER);

    jPanel22.add(jPanel18);

    jPanel19.setAlignmentX(0.0F);
    jPanel19.setMinimumSize(new java.awt.Dimension(0, 0));
    jPanel19.setPreferredSize(new java.awt.Dimension(1177, 200));
    jPanel19.setLayout(new java.awt.GridBagLayout());

    pendenteLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
    pendenteLabel.setForeground(new java.awt.Color(255, 255, 255));
    pendenteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pendentes.png"))); // NOI18N
    pendenteLabel.setText("<html><body style='text-align: center'>0<br>Pendentes");
    pendenteLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(35, 35, 35, 0);
    jPanel19.add(pendenteLabel, gridBagConstraints);

    andamentoLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
    andamentoLabel.setForeground(new java.awt.Color(255, 255, 255));
    andamentoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/em_andamento.png"))); // NOI18N
    andamentoLabel.setText("<html><body style='text-align: center'>0<br>Em andamento");
    andamentoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(35, 35, 35, 0);
    jPanel19.add(andamentoLabel, gridBagConstraints);

    finalizadoLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
    finalizadoLabel.setForeground(new java.awt.Color(255, 255, 255));
    finalizadoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/finalizados.png"))); // NOI18N
    finalizadoLabel.setText("<html><body style='text-align: center'>0<br>Finalizadas");
    finalizadoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(35, 35, 35, 0);
    jPanel19.add(finalizadoLabel, gridBagConstraints);

    agendadoLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
    agendadoLabel.setForeground(new java.awt.Color(255, 255, 255));
    agendadoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/agendados.png"))); // NOI18N
    agendadoLabel.setText("<html><body style='text-align: center'>0<br>Agendadas");
    agendadoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(35, 35, 35, 0);
    jPanel19.add(agendadoLabel, gridBagConstraints);

    jPanel22.add(jPanel19);

    jPanel21.setAlignmentX(0.0F);
    jPanel21.setPreferredSize(new java.awt.Dimension(1227, 100));
    jPanel21.setLayout(new java.awt.BorderLayout());

    jPanel26.setLayout(new javax.swing.BoxLayout(jPanel26, javax.swing.BoxLayout.Y_AXIS));

    jLabel10.setFont(carregarFonte(Font.BOLD, 18));
    jLabel10.setText("Notificações recentes");
    jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 15, 1));
    jPanel26.add(jLabel10);

    jLabel13.setFont(carregarFonte(Font.PLAIN, 13));
    jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Document.png"))); // NOI18N
    jLabel13.setText("Nenhuma notificação recente");
    jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));
    jPanel26.add(jLabel13);

    jPanel21.add(jPanel26, java.awt.BorderLayout.PAGE_START);

    jPanel22.add(jPanel21);

    jPanel25.add(jPanel22, java.awt.BorderLayout.NORTH);

    jPanel27.setAlignmentX(0.0F);
    jPanel27.setLayout(new java.awt.GridBagLayout());

    jScrollPane6.setMinimumSize(new java.awt.Dimension(16, 402));

    OSTable.setFont(carregarFonte(Font.PLAIN, 15));
    OSTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {"asdfsa", "asdfasdfas", "dasfasdfa", "asdfasdfasd", "asdfasdf", null}
        },
        new String [] {
            "Ordem", "Título", "Técnico", "Status", "Local", "Prazo"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    OSTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    OSTable.setRowHeight(50);
    jScrollPane6.setViewportView(OSTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 50, 50);
    jPanel27.add(jScrollPane6, gridBagConstraints);

    jPanel25.add(jPanel27, java.awt.BorderLayout.CENTER);

    jScrollPane1.setViewportView(jPanel25);

    javax.swing.GroupLayout ordem_servicoLayout = new javax.swing.GroupLayout(ordem_servico);
    ordem_servico.setLayout(ordem_servicoLayout);
    ordem_servicoLayout.setHorizontalGroup(
        ordem_servicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    ordem_servicoLayout.setVerticalGroup(
        ordem_servicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
    );

    rootDashboard.add(ordem_servico, "ordem_servico");

    manutencoes.setBackground(new java.awt.Color(255, 255, 255));

    jPanel28.setMinimumSize(new java.awt.Dimension(0, 66));
    jPanel28.setPreferredSize(new java.awt.Dimension(500, 700));
    jPanel28.setLayout(new java.awt.BorderLayout());

    jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.Y_AXIS));

    jPanel30.setAlignmentX(0.0F);
    jPanel30.setPreferredSize(new java.awt.Dimension(1177, 150));
    jPanel30.setLayout(new java.awt.BorderLayout());

    jPanel31.setMinimumSize(new java.awt.Dimension(0, 0));
    jPanel31.setLayout(new java.awt.GridBagLayout());

    jPanel32.setLayout(new java.awt.BorderLayout());

    jPanel33.setPreferredSize(new java.awt.Dimension(300, 42));
    jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton12.setBackground(new java.awt.Color(23, 50, 62));
    jButton12.setFont(carregarFonte(Font.BOLD, 12));
    jButton12.setForeground(new java.awt.Color(255, 255, 255));
    jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icon.png"))); // NOI18N
    jButton12.setText("Nova manutenção");
    jButton12.setBorder(null);
    jButton12.setPreferredSize(new java.awt.Dimension(150, 34));
    jButton12.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton12ActionPerformed(evt);
        }
    });
    jPanel33.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 34));

    jButton14.setBackground(new java.awt.Color(23, 50, 62));
    jButton14.setFont(carregarFonte(Font.BOLD, 12));
    jButton14.setForeground(new java.awt.Color(255, 255, 255));
    jButton14.setText("Exportar PDF");
    jButton14.setBorder(null);
    jButton14.setBorderPainted(false);
    jButton14.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton14ActionPerformed(evt);
        }
    });
    jPanel33.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 109, 35));

    jPanel32.add(jPanel33, java.awt.BorderLayout.EAST);

    jPanel34.setMaximumSize(new java.awt.Dimension(2314123, 2134123));
    jPanel34.setLayout(new javax.swing.BoxLayout(jPanel34, javax.swing.BoxLayout.Y_AXIS));

    jLabel14.setFont(carregarFonte(Font.BOLD, 24));
    jLabel14.setText("Manutenções");
    jLabel14.setMaximumSize(new java.awt.Dimension(21341, 12341));
    jPanel34.add(jLabel14);

    jLabel15.setFont(carregarFonte(Font.PLAIN, 13));
    jLabel15.setText("Manutenções registradas");
    jLabel15.setMaximumSize(new java.awt.Dimension(2311234, 1234123));
    jPanel34.add(jLabel15);

    jPanel32.add(jPanel34, java.awt.BorderLayout.WEST);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 50);
    jPanel31.add(jPanel32, gridBagConstraints);

    jPanel30.add(jPanel31, java.awt.BorderLayout.CENTER);

    jPanel29.add(jPanel30);

    jPanel28.add(jPanel29, java.awt.BorderLayout.NORTH);

    jPanel38.setAlignmentX(0.0F);
    jPanel38.setLayout(new java.awt.GridBagLayout());

    manutencaoTable.setFont(carregarFonte(Font.PLAIN, 15));
    manutencaoTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {"asdfsa", "asdfasdfas", "asdfasdfas", "asdfasdf", null}
        },
        new String [] {
            "Ordem", "Título", "Data", "Local", "Tipo"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    manutencaoTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    manutencaoTable.setRowHeight(50);
    jScrollPane7.setViewportView(manutencaoTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 50, 50);
    jPanel38.add(jScrollPane7, gridBagConstraints);

    jPanel28.add(jPanel38, java.awt.BorderLayout.CENTER);

    jScrollPane3.setViewportView(jPanel28);

    javax.swing.GroupLayout manutencoesLayout = new javax.swing.GroupLayout(manutencoes);
    manutencoes.setLayout(manutencoesLayout);
    manutencoesLayout.setHorizontalGroup(
        manutencoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
    );
    manutencoesLayout.setVerticalGroup(
        manutencoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
    );

    rootDashboard.add(manutencoes, "manutencoes");

    historico.setBackground(new java.awt.Color(255, 255, 255));

    jPanel35.setMinimumSize(new java.awt.Dimension(0, 66));
    jPanel35.setPreferredSize(new java.awt.Dimension(500, 700));
    jPanel35.setLayout(new java.awt.BorderLayout());

    jPanel36.setLayout(new javax.swing.BoxLayout(jPanel36, javax.swing.BoxLayout.Y_AXIS));

    jPanel37.setAlignmentX(0.0F);
    jPanel37.setPreferredSize(new java.awt.Dimension(1177, 150));
    jPanel37.setLayout(new java.awt.BorderLayout());

    jPanel39.setMinimumSize(new java.awt.Dimension(0, 0));
    jPanel39.setLayout(new java.awt.GridBagLayout());

    jPanel40.setLayout(new java.awt.BorderLayout());

    jPanel42.setLayout(new javax.swing.BoxLayout(jPanel42, javax.swing.BoxLayout.Y_AXIS));

    jLabel16.setFont(carregarFonte(Font.BOLD, 24));
    jLabel16.setText("Logs de sistema");
    jLabel16.setMaximumSize(new java.awt.Dimension(2131, 12312));
    jPanel42.add(jLabel16);

    jLabel17.setFont(carregarFonte(Font.PLAIN, 13));
    jLabel17.setText("Logs e histórico de mudanças no sistema");
    jLabel17.setMaximumSize(new java.awt.Dimension(2132423, 43216));
    jPanel42.add(jLabel17);

    jPanel40.add(jPanel42, java.awt.BorderLayout.WEST);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 50);
    jPanel39.add(jPanel40, gridBagConstraints);

    jPanel37.add(jPanel39, java.awt.BorderLayout.CENTER);

    jPanel36.add(jPanel37);

    jPanel35.add(jPanel36, java.awt.BorderLayout.NORTH);

    jPanel43.setAlignmentX(0.0F);
    jPanel43.setLayout(new java.awt.GridBagLayout());

    logsTable.setFont(carregarFonte(Font.PLAIN, 15));
    logsTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {"asdfsa", "asdfasdfas", "asdfasdfas", "asdfasdf", null}
        },
        new String [] {
            "Data", "Hora", "Usuário", "Descrição", "Tipo"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    logsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    logsTable.setRowHeight(50);
    jScrollPane8.setViewportView(logsTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 50, 50);
    jPanel43.add(jScrollPane8, gridBagConstraints);

    jPanel35.add(jPanel43, java.awt.BorderLayout.CENTER);

    jScrollPane4.setViewportView(jPanel35);

    javax.swing.GroupLayout historicoLayout = new javax.swing.GroupLayout(historico);
    historico.setLayout(historicoLayout);
    historicoLayout.setHorizontalGroup(
        historicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
    );
    historicoLayout.setVerticalGroup(
        historicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
    );

    rootDashboard.add(historico, "historico");

    relatorio.setBackground(new java.awt.Color(255, 255, 255));

    jPanel41.setMinimumSize(new java.awt.Dimension(0, 66));
    jPanel41.setPreferredSize(new java.awt.Dimension(500, 700));
    jPanel41.setLayout(new java.awt.BorderLayout());

    jPanel44.setLayout(new javax.swing.BoxLayout(jPanel44, javax.swing.BoxLayout.Y_AXIS));

    jPanel45.setAlignmentX(0.0F);
    jPanel45.setPreferredSize(new java.awt.Dimension(1177, 150));
    jPanel45.setLayout(new java.awt.BorderLayout());

    jPanel46.setMinimumSize(new java.awt.Dimension(0, 0));
    jPanel46.setLayout(new java.awt.GridBagLayout());

    jPanel47.setLayout(new java.awt.BorderLayout());

    jPanel48.setPreferredSize(new java.awt.Dimension(300, 42));
    jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton15.setBackground(new java.awt.Color(23, 50, 62));
    jButton15.setFont(carregarFonte(Font.BOLD, 12));
    jButton15.setForeground(new java.awt.Color(255, 255, 255));
    jButton15.setText("Exportar CSV");
    jButton15.setBorder(null);
    jButton15.setPreferredSize(new java.awt.Dimension(150, 34));
    jButton15.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton15ActionPerformed(evt);
        }
    });
    jPanel48.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 109, 34));

    jButton16.setBackground(new java.awt.Color(23, 50, 62));
    jButton16.setFont(carregarFonte(Font.BOLD, 12));
    jButton16.setForeground(new java.awt.Color(255, 255, 255));
    jButton16.setText("Exportar PDF");
    jButton16.setBorder(null);
    jButton16.setBorderPainted(false);
    jButton16.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton16ActionPerformed(evt);
        }
    });
    jPanel48.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 109, 35));

    jPanel47.add(jPanel48, java.awt.BorderLayout.EAST);

    jPanel49.setLayout(new javax.swing.BoxLayout(jPanel49, javax.swing.BoxLayout.Y_AXIS));

    jLabel18.setFont(carregarFonte(Font.BOLD, 24));
    jLabel18.setText("Relatórios");
    jLabel18.setMaximumSize(new java.awt.Dimension(21312, 32116));
    jPanel49.add(jLabel18);

    jLabel19.setFont(carregarFonte(Font.PLAIN, 13));
    jLabel19.setText("Exportar arquivo em PDF");
    jLabel19.setMaximumSize(new java.awt.Dimension(13530, 16345));
    jPanel49.add(jLabel19);

    jPanel47.add(jPanel49, java.awt.BorderLayout.WEST);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 50);
    jPanel46.add(jPanel47, gridBagConstraints);

    jPanel45.add(jPanel46, java.awt.BorderLayout.CENTER);

    jPanel44.add(jPanel45);

    jPanel41.add(jPanel44, java.awt.BorderLayout.NORTH);

    jPanel50.setAlignmentX(0.0F);
    jPanel50.setLayout(new java.awt.GridBagLayout());

    relatorioTable.setFont(carregarFonte(Font.PLAIN, 15));
    relatorioTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {"10", "Abril", "2025", "16"},
            {"9", "Março", "2025", "10"},
            {"8", "Fevereiro", "2025", "11"},
            {"7", "Janeiro", "2025", "17"},
            {"6", "Dezembro", "2024", "9"},
            {"5", "Novembro", "2024", "17"},
            {"4", "Outubro", "2024", "20"},
            {"3", "Setembro", "2024", "14"},
            {"2", "Agosto", "2024", "13"},
            {"1", "Julho", "2024", "11"}
        },
        new String [] {
            "ID", "Mês", "Ano", "Total de OS"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    relatorioTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    relatorioTable.setRowHeight(50);
    jScrollPane10.setViewportView(relatorioTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 50, 50);
    jPanel50.add(jScrollPane10, gridBagConstraints);

    jPanel41.add(jPanel50, java.awt.BorderLayout.CENTER);

    jScrollPane9.setViewportView(jPanel41);

    javax.swing.GroupLayout relatorioLayout = new javax.swing.GroupLayout(relatorio);
    relatorio.setLayout(relatorioLayout);
    relatorioLayout.setHorizontalGroup(
        relatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
    );
    relatorioLayout.setVerticalGroup(
        relatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
    );

    rootDashboard.add(relatorio, "relatorio");

    jPanel51.setMinimumSize(new java.awt.Dimension(0, 66));
    jPanel51.setPreferredSize(new java.awt.Dimension(500, 700));
    jPanel51.setLayout(new java.awt.BorderLayout());

    jPanel52.setLayout(new javax.swing.BoxLayout(jPanel52, javax.swing.BoxLayout.Y_AXIS));

    jPanel53.setAlignmentX(0.0F);
    jPanel53.setPreferredSize(new java.awt.Dimension(1177, 150));
    jPanel53.setLayout(new java.awt.BorderLayout());

    jPanel54.setMinimumSize(new java.awt.Dimension(0, 0));
    jPanel54.setLayout(new java.awt.GridBagLayout());

    jPanel55.setLayout(new java.awt.BorderLayout());

    jPanel56.setPreferredSize(new java.awt.Dimension(300, 42));
    jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton17.setBackground(new java.awt.Color(23, 50, 62));
    jButton17.setFont(carregarFonte(Font.BOLD, 12));
    jButton17.setForeground(new java.awt.Color(255, 255, 255));
    jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icon.png"))); // NOI18N
    jButton17.setText("Novo ativo");
    jButton17.setBorder(null);
    jButton17.setPreferredSize(new java.awt.Dimension(150, 34));
    jButton17.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton17ActionPerformed(evt);
        }
    });
    jPanel56.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, 34));

    jPanel55.add(jPanel56, java.awt.BorderLayout.EAST);

    jPanel57.setLayout(new javax.swing.BoxLayout(jPanel57, javax.swing.BoxLayout.Y_AXIS));

    jLabel20.setFont(carregarFonte(Font.BOLD, 24));
    jLabel20.setText("Ativos");
    jLabel20.setMaximumSize(new java.awt.Dimension(32343, 1236));
    jPanel57.add(jLabel20);
    jPanel57.add(jTabbedPane1);

    jLabel21.setFont(carregarFonte(Font.PLAIN, 13));
    jLabel21.setText("Ativos cadastrados");
    jLabel21.setMaximumSize(new java.awt.Dimension(9219, 12316));
    jPanel57.add(jLabel21);

    jPanel55.add(jPanel57, java.awt.BorderLayout.WEST);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 50);
    jPanel54.add(jPanel55, gridBagConstraints);

    jPanel53.add(jPanel54, java.awt.BorderLayout.CENTER);

    jPanel52.add(jPanel53);

    jPanel51.add(jPanel52, java.awt.BorderLayout.NORTH);

    jPanel58.setAlignmentX(0.0F);
    jPanel58.setLayout(new java.awt.GridBagLayout());

    ativoTable.setFont(carregarFonte(Font.PLAIN, 15));
    ativoTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {"asdfsa", "asdfasdfas", "asdfasdfas", "asdfasdf", null}
        },
        new String [] {
            "ID", "Nome", "Tipo", "Localização", "Última manut."
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    ativoTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    ativoTable.setRowHeight(50);
    jScrollPane12.setViewportView(ativoTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(0, 50, 50, 50);
    jPanel58.add(jScrollPane12, gridBagConstraints);

    jPanel51.add(jPanel58, java.awt.BorderLayout.CENTER);

    jScrollPane11.setViewportView(jPanel51);

    javax.swing.GroupLayout ativoLayout = new javax.swing.GroupLayout(ativo);
    ativo.setLayout(ativoLayout);
    ativoLayout.setHorizontalGroup(
        ativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
    );
    ativoLayout.setVerticalGroup(
        ativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
    );

    rootDashboard.add(ativo, "ativo");

    dashboard.add(rootDashboard, java.awt.BorderLayout.CENTER);

    root.add(dashboard, "dashboard");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(root, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(root, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(getjTextFieldEmail().getText().matches("") || getjPasswordFieldSenha().getText().matches("")){
            GlassPanePopup.showPopup(new PopupView("Erro!", "Um ou mais campos obrigatórios não foram preenchidos."));
        } else{
            Controller theController = new Controller();
            String email = jTextFieldEmail.getText();
            String senha = new String(jPasswordFieldSenha.getPassword());
            User loggedIn = null;
            try {
                loggedIn = theController.getUser(new User(0, null, email, senha, 0));
            } catch (SQLException ex) {
                System.getLogger(View.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
            
            if(loggedIn != null){
                GlassPanePopup.showPopup(new PopupView("Login realizado", "Bem vindo!"));
                CardLayout card = (CardLayout) root.getLayout();
                card.show(root, "dashboard");
                nameUser.setText("Técnico - "+loggedIn.getNome());
                logged = loggedIn;
                
                updateOS();
                
            }
            else{
                GlassPanePopup.showPopup(new PopupView("Usuário não encontrado", "Verifique seu e-mail e senha."));
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout card = (CardLayout) root.getLayout();
        card.show(root, "cadastro");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (visible == false){
            visible = true;
            jPasswordFieldSenha.setEchoChar((char)0);
        } else{
            visible = false;
            jPasswordFieldSenha.setEchoChar('*');
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ordem_servicoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordem_servicoButtonActionPerformed
        CardLayout card = (CardLayout) rootDashboard.getLayout();
        card.show(rootDashboard, "ordem_servico");
        
        updateMenu();
        ordem_servicoButton.setFont(carregarFonte(Font.BOLD, 12));
        ordem_servicoButton.setForeground(new Color(60,137,166));
        ordem_servicoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Chart.png")));
        
        updateOS();
    }//GEN-LAST:event_ordem_servicoButtonActionPerformed

    private void manutencoesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manutencoesButtonActionPerformed
        CardLayout card = (CardLayout) rootDashboard.getLayout();
        card.show(rootDashboard, "manutencoes");
        
        updateMenu();
        manutencoesButton.setFont(carregarFonte(Font.BOLD, 12));
        manutencoesButton.setForeground(new Color(60,137,166));
        manutencoesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/predioBlue.png")));
        
        updateManutencao();
    }//GEN-LAST:event_manutencoesButtonActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if(evt.getComponent().getWidth() < 1250){
            jPanel25.setPreferredSize(new Dimension(500, 1300));
            jPanel19.setPreferredSize(new Dimension(1177, 400));
            
            jPanel19.remove(finalizadoLabel);

            GridBagConstraints novoGbc = new GridBagConstraints();
            novoGbc.gridx = 0;
            novoGbc.gridy = 1; // Nova linha
            novoGbc.insets = new Insets(35, 35, 35, 0);

            jPanel19.add(finalizadoLabel, novoGbc);
            jPanel19.revalidate();
            jPanel19.repaint();
            
            jPanel19.remove(agendadoLabel);

            novoGbc.gridx = 1;
            novoGbc.gridy = 1; // Nova linha

            jPanel19.add(agendadoLabel, novoGbc);
            jPanel19.revalidate();
            jPanel19.repaint();
        }
        else{
            jPanel25.setPreferredSize(new Dimension(500, 1000));
            jPanel19.setPreferredSize(new Dimension(1177, 200));
            
            jPanel19.remove(finalizadoLabel);

            GridBagConstraints novoGbc = new GridBagConstraints();
            novoGbc.gridx = 2;
            novoGbc.gridy = 0; // Nova linha
            novoGbc.insets = new Insets(35, 35, 35, 0);

            jPanel19.add(finalizadoLabel, novoGbc);
            jPanel19.revalidate();
            jPanel19.repaint();
            
            jPanel19.remove(agendadoLabel);

            novoGbc.gridx = 3;
            novoGbc.gridy = 0; // Nova linha

            jPanel19.add(agendadoLabel, novoGbc);
            jPanel19.revalidate();
            jPanel19.repaint();
        }
        if(evt.getComponent().getWidth() < 850){
            menu.setPreferredSize(new Dimension(43, 746));
            menu.remove(jPanel10); // remover do layout
            menu.add(jPanel10, new AbsoluteConstraints(0, 10, 220, 300));
            menu.revalidate();
            menu.repaint();
            ordem_servicoButton.setText("   Ordens de Serviço");
        } else{
            menu.setPreferredSize(new Dimension(263, 746));
            menu.remove(jPanel10); // remover do layout
            menu.add(jPanel10, new AbsoluteConstraints(20, 10, 220, 300));
            menu.revalidate();
            menu.repaint();
            ordem_servicoButton.setText("  Ordens de Serviço");
            
        }
    }//GEN-LAST:event_formComponentResized

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        CardLayout card = (CardLayout) rootDashboard.getLayout();
        card.show(rootDashboard, "historico");
        
        updateMenu();
        logButton.setFont(carregarFonte(Font.BOLD, 12));
        logButton.setForeground(new Color(60,137,166));
        logButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ClockBlue.png")));
        
        updateLogs();
    }//GEN-LAST:event_logButtonActionPerformed

    private void relatoriosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatoriosButtonActionPerformed
        CardLayout card = (CardLayout) rootDashboard.getLayout();
        card.show(rootDashboard, "relatorio");
        
        updateMenu();
        relatoriosButton.setFont(carregarFonte(Font.BOLD, 12));
        relatoriosButton.setForeground(new Color(60,137,166));
        relatoriosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DocumentBlue.png")));
    }//GEN-LAST:event_relatoriosButtonActionPerformed

    private void ativosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ativosButtonActionPerformed
        CardLayout card = (CardLayout) rootDashboard.getLayout();
        card.show(rootDashboard, "ativo");
        
        updateMenu();
        ativosButton.setFont(carregarFonte(Font.BOLD, 12));
        ativosButton.setForeground(new Color(60,137,166));
        ativosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/BoxBlue.png")));
        
        updateAtivo();
    }//GEN-LAST:event_ativosButtonActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        GlassPanePopup.showPopup(new Notificacao());
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        OSForms formulario = new OSForms(logged);
        GlassPanePopup.showPopup(formulario);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        GlassPanePopup.showPopup(new AtivoForms(logged));
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        GlassPanePopup.showPopup(new ManutencaoForms(logged));
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextFieldEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmail1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (visible == false){
            visible = true;
            jPasswordFieldSenha1.setEchoChar((char)0);
        } else{
            visible = false;
            jPasswordFieldSenha1.setEchoChar('*');
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmail2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(jTextFieldEmail2.getText().matches("") || jTextFieldEmail1.getText().matches("") || new String(jPasswordFieldSenha1.getPassword()).matches("")){
            GlassPanePopup.showPopup(new PopupView("Erro!", "Um ou mais campos obrigatórios não foram preenchidos."));
        }else{
        User usuario = new User(0, jTextFieldEmail2.getText(), jTextFieldEmail1.getText(), new String(jPasswordFieldSenha1.getPassword()), 1);
        Controller controller = new Controller();
        try {
            if(controller.createUser(usuario)){
                GlassPanePopup.showPopup(new PopupView("Usuário criado com sucesso!", "Vá para a tela de login para poder logar"));
            }
            else{
                GlassPanePopup.showPopup(new PopupView("Erro ao criar o usuário", "Contate o administrator"));
            }
        } catch (SQLException ex) {
            System.getLogger(View.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        CardLayout card = (CardLayout) root.getLayout();
        card.show(root, "login");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        exportToPDF(manutencaoTable);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        exportToPDF(relatorioTable);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        exportToCSV(relatorioTable);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jPasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldSenhaActionPerformed

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
    UIManager.setLookAndFeel( new FlatLightLaf() );
    } catch( Exception ex ) {
        System.err.println( "Failed to initialize LaF" );
    }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new View().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OSTable;
    private javax.swing.JLabel agendadoLabel;
    private javax.swing.JLabel andamentoLabel;
    private javax.swing.JPanel ativo;
    private javax.swing.JTable ativoTable;
    private javax.swing.JButton ativosButton;
    private javax.swing.JPanel cadastro;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel finalizadoLabel;
    private javax.swing.JPanel header;
    private javax.swing.JPanel historico;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEmail1;
    private javax.swing.JTextField jTextFieldEmail2;
    private javax.swing.JButton logButton;
    private javax.swing.JPanel login;
    private javax.swing.JTable logsTable;
    private javax.swing.JTable manutencaoTable;
    private javax.swing.JPanel manutencoes;
    private javax.swing.JButton manutencoesButton;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel nameUser;
    private javax.swing.JPanel ordem_servico;
    private javax.swing.JButton ordem_servicoButton;
    private javax.swing.JLabel pendenteLabel;
    private javax.swing.JPanel relatorio;
    private javax.swing.JTable relatorioTable;
    private javax.swing.JButton relatoriosButton;
    private javax.swing.JPanel root;
    private javax.swing.JPanel rootDashboard;
    // End of variables declaration//GEN-END:variables
}
