package gui;

import javax.swing.JFrame; // for main window
import javax.swing.JOptionPane; // for standard dialogs
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar; // row of menu selections
import javax.swing.JMenu; // menu selection that offers another menu
import javax.swing.JMenuItem; // menu selection that does something
import javax.swing.JToolBar; // row of buttons under the menu
import javax.swing.ListSelectionModel;
import javax.swing.JButton; // regular button
import javax.swing.JFileChooser;
import javax.swing.Box; // to create toolbar spacer
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.JLabel; // text or image holder
import javax.swing.JList;
import javax.swing.ImageIcon; // holds a custom icon
import javax.swing.SwingConstants; // useful values for Swing method calls
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; // opens a file
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.BorderLayout; // layout manager for main window
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font; // rich text in a JLabel or similar widget

import store.Computer;
import store.Customer;
import store.Option;
import store.Store;

public class MainWin extends JFrame {

    private enum Record {
        CUSTOMER, OPTION, COMPUTER, ORDER
    }

    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 600));
        setSize(900, 600);
        setLocationRelativeTo(null); // Set to middle of screen

        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem newStore = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As");
        JMenuItem quit = new JMenuItem("Quit");
        JMenu insert = new JMenu("Insert");
        JMenuItem iCustomer = new JMenuItem("Customer");
        JMenuItem iOption = new JMenuItem("Option");
        JMenuItem iComputer = new JMenuItem("Computer");
        JMenu view = new JMenu("View");
        JMenuItem vCustomer = new JMenuItem("Customer");
        JMenuItem vOption = new JMenuItem("Option");
        JMenuItem vComputer = new JMenuItem("Computer");
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        newStore.addActionListener(event -> onNewClick());
        open.addActionListener(event -> onOpenClick());
        save.addActionListener(event -> onSaveClick());
        saveAs.addActionListener(event -> onSaveAsClick());
        quit.addActionListener(event -> onQuitClick());
        iCustomer.addActionListener(event -> onInsertCustomerClick());
        iOption.addActionListener(event -> onInsertOptionClick());
        iComputer.addActionListener(event -> onInsertComputerClick());
        vCustomer.addActionListener(event -> onViewClick(Record.CUSTOMER));
        vOption.addActionListener(event -> onViewClick(Record.OPTION));
        vComputer.addActionListener(event -> onViewClick(Record.COMPUTER));
        about.addActionListener(event -> onAboutClick());

        file.add(newStore);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(quit);
        insert.add(iCustomer);
        insert.add(iOption);
        insert.add(iComputer);
        view.add(vCustomer);
        view.add(vOption);
        view.add(vComputer);
        help.add(about);

        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);
        setJMenuBar(menubar);

        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Store Menus");

        // Docks the toolbar at the top and doesnt allow dragging it
        toolbar.setFloatable(false);

        // A "horizontal strut" is just a space of the specified pixel width
        // toolbar.add(Box.createHorizontalStrut(10));

        // Create the 4 file buttons using the icons provided
        JButton newFile = new JButton(new ImageIcon("gui/resources/newFile.png"));
        newFile.setActionCommand("New Store");
        newFile.setToolTipText("New Store");
        newFile.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(newFile);
        newFile.addActionListener(event -> onNewClick());

        JButton openFile = new JButton(new ImageIcon("gui/resources/openFile.png"));
        openFile.setActionCommand("Open File");
        openFile.setToolTipText("Open File");
        openFile.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(openFile);
        openFile.addActionListener(event -> onOpenClick());

        JButton saveFile = new JButton(new ImageIcon("gui/resources/saveFile.png"));
        saveFile.setActionCommand("Save File");
        saveFile.setToolTipText("Save File");
        saveFile.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(saveFile);
        saveFile.addActionListener(event -> onSaveClick());

        JButton saveFileAs = new JButton(new ImageIcon("gui/resources/saveFileAs.png"));
        saveFileAs.setActionCommand("Save File As");
        saveFileAs.setToolTipText("Save File As");
        saveFileAs.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(saveFileAs);
        saveFileAs.addActionListener(event -> onSaveAsClick());

        toolbar.add(Box.createHorizontalStrut(25));

        // Create the 3 insert buttons using the icons provided
        JButton insertCust = new JButton(new ImageIcon("gui/resources/insertCust.png"));
        insertCust.setActionCommand("Insert Customer");
        insertCust.setToolTipText("Insert Customer");
        insertCust.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(insertCust);
        insertCust.addActionListener(event -> onInsertCustomerClick());

        JButton insertOpt = new JButton(new ImageIcon("gui/resources/insertOpt.png"));
        insertOpt.setActionCommand("Insert Option");
        insertOpt.setToolTipText("Insert Option");
        insertOpt.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(insertOpt);
        insertOpt.addActionListener(event -> onInsertOptionClick());

        JButton insertComp = new JButton(new ImageIcon("gui/resources/insertComp.png"));
        insertComp.setActionCommand("Insert Computer");
        insertComp.setToolTipText("Insert Computer");
        insertComp.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(insertComp);
        insertComp.addActionListener(event -> onInsertComputerClick());

        toolbar.add(Box.createHorizontalStrut(25));

        // Create the 3 view buttons using the icons provided
        JButton viewCust = new JButton(new ImageIcon("gui/resources/viewCust.png"));
        viewCust.setActionCommand("View Customers");
        viewCust.setToolTipText("View Customers");
        viewCust.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(viewCust);
        viewCust.addActionListener(event -> onViewClick(Record.CUSTOMER));

        JButton viewOpt = new JButton(new ImageIcon("gui/resources/viewOpt.png"));
        viewOpt.setActionCommand("View Options");
        viewOpt.setToolTipText("View Options");
        viewOpt.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(viewOpt);
        viewOpt.addActionListener(event -> onViewClick(Record.OPTION));

        JButton viewComp = new JButton(new ImageIcon("gui/resources/viewComp.png"));
        viewComp.setActionCommand("View Computers");
        viewComp.setToolTipText("View Computers");
        viewComp.setPreferredSize(new DimensionUIResource(64, 64));
        toolbar.add(viewComp);
        viewComp.addActionListener(event -> onViewClick(Record.COMPUTER));

        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        // /////////////////////////// ////////////////////////////////////////////
        // D I S P L A Y
        // Display the selected view on the main center screen
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        // S T A T U S B A R D I S P L A Y ////////////////////////////////////
        // Provide a status bar for messages
        // display = new JLabel();
        // add(display, BorderLayout.PAGE_END);

        // Make everything in the JFrame visible
        setVisible(true);

        // Start the store
        store = new Store("ELSA");
        display.setFont(new JLabel().getFont()); // Reset to default font
    }

    // Listeners
    protected void onNewClick() {
        JLabel lblStoreName = new JLabel("Store Name");
        JTextField txtStoreName = new JTextField();
        Object[] objects = { lblStoreName, txtStoreName };

        int button = JOptionPane.showConfirmDialog(this, objects, "New Store", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        // Create a New Store
        if (button == JOptionPane.OK_OPTION) {
            try {
                store = new Store(txtStoreName.getText());
                this.setTitle(txtStoreName.getText());
                display.setText("<html><p><font size=+2> Welcome To Your New Store!</font></p></html>");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error With Creating New Store: " + e.getMessage(),
                        "New Store Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onOpenClick() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fileExt = new FileNameExtensionFilter(fileName + " files", "txt");
        fc.addChoosableFileFilter(fileExt);
        fc.setFileFilter(fileExt);

        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File openFile = fc.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(openFile))) {
                store = new Store(br);
                this.setTitle(store.name());
                display.setText("<html><p><font size=+2> Welcome Back To " + this.getTitle() + "!</font></p></html>");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error With Opening File: " + e.getMessage(), "Open File Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            store.save(bw);
            JOptionPane.showMessageDialog(this, "File saved successfully!", "File Saved",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error With Saving File: " + e.getMessage(), "Save File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onSaveAsClick() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fileExt = new FileNameExtensionFilter(this.getTitle() + " files", "txt");
        fc.addChoosableFileFilter(fileExt);
        fc.setFileFilter(fileExt);

        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File saveFile = fc.getSelectedFile();
            if (!saveFile.getAbsolutePath().endsWith(".txt")) {
                saveFile = new File(saveFile.getAbsolutePath() + ".txt");
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {
                store.save(bw);
                JOptionPane.showMessageDialog(this, "File saved successfully!", "File Saved",
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error With Saving File: " + e.getMessage(), "Save File Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onInsertCustomerClick() {
        JLabel lblName = new JLabel("Name");
        JTextField txtName = new JTextField();
        JLabel spacer = new JLabel("<HTML><br/></HTML>");
        JLabel lblEmail = new JLabel("Email");
        JTextField txtEmail = new JTextField();

        // Display the OptionPane
        Object[] objects = { lblName, txtName, spacer, lblEmail, txtEmail };

        int button = JOptionPane.showConfirmDialog(this, objects, "Insert Customer", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        // Add customer if valid to the store
        if (button == JOptionPane.OK_OPTION) {
            try {
                Customer customer = new Customer(txtName.getText(), txtEmail.getText());
                store.add(customer);
                onViewClick(Record.CUSTOMER);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error With Inserting Customer",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onInsertOptionClick() {
        JLabel lblName = new JLabel("Name");
        JTextField txtName = new JTextField();
        JLabel spacer = new JLabel("<HTML><br/></HTML>");
        JLabel lblCost = new JLabel("Cost");
        JTextField txtCost = new JTextField();

        // Display the OptionPane
        Object[] objects = { lblName, txtName, spacer, lblCost, txtCost };

        int button = JOptionPane.showConfirmDialog(this, objects, "Insert Option", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        // Add option if valid to the store
        if (button == JOptionPane.OK_OPTION) {
            try {
                Double dCost = Double.parseDouble(txtCost.getText()) * 100;
                Option option = new Option(txtName.getText(), Double.valueOf(dCost).longValue());
                store.add(option);
                onViewClick(Record.OPTION);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error With Inserting Option",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onInsertComputerClick() {
        JLabel lblName = new JLabel("Name");
        JTextField txtName = new JTextField();
        JLabel spacer = new JLabel("<HTML><br/></HTML>");
        JLabel lblModel = new JLabel("Model");
        JTextField txtModel = new JTextField();

        // Options Lists and Buttons
        DefaultListModel<store.Option> availOpts = new DefaultListModel<>(), selectedOpts = new DefaultListModel<>();
        for (Object object : store.options()) {
            availOpts.addElement((Option) object);
        }

        JLabel lblOptions = new JLabel("Available Options");
        JList<store.Option> lstOptions = new JList<>(availOpts);
        lstOptions.setLayoutOrientation(JList.VERTICAL);
        lstOptions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane aOptionScroller = new JScrollPane(lstOptions);
        aOptionScroller.setPreferredSize(new DimensionUIResource(200, 100));
        DefaultListCellRenderer aOptRenderer = (DefaultListCellRenderer) lstOptions.getCellRenderer();
        aOptRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblSelectedOpts = new JLabel("Selected Options");
        JList<store.Option> lstSelectedOpts = new JList<>(selectedOpts);
        lstSelectedOpts.setLayoutOrientation(JList.VERTICAL);
        lstSelectedOpts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sOptionScroller = new JScrollPane(lstSelectedOpts);
        sOptionScroller.setPreferredSize(new DimensionUIResource(200, 100));
        DefaultListCellRenderer sOptRenderer = (DefaultListCellRenderer) lstSelectedOpts.getCellRenderer();
        sOptRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnAddOpt = new JButton("Add");
        btnAddOpt.addActionListener(
                event -> {
                    selectedOpts.addElement(lstOptions.getSelectedValue());
                    // availOpts.removeElement(lstOptions.getSelectedValue());
                });
        JButton btnRemoveOpt = new JButton("Remove");
        btnRemoveOpt.addActionListener(
                event -> {
                    // availOpts.addElement(lstSelectedOpts.getSelectedValue());
                    selectedOpts.removeElement(lstSelectedOpts.getSelectedValue());
                });

        // JPanel to hold layout the Options lists and buttons correctly
        JPanel optionPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[] { 100, 100, 100 };
        layout.rowHeights = new int[] { 30, 30, 30, 30, 30, 10 };
        optionPanel.setLayout(layout);
        optionPanel.add(lblOptions, constraints(0, 0, 1, 1));
        optionPanel.add(lblSelectedOpts, constraints(2, 0, 1, 1));
        optionPanel.add(aOptionScroller, constraints(0, 1, 1, 4));
        optionPanel.add(sOptionScroller, constraints(2, 1, 1, 4));
        optionPanel.add(new JLabel(" "), constraints(1, 1, 1, 1));
        optionPanel.add(btnAddOpt, constraints(1, 2, 1, 1));
        optionPanel.add(btnRemoveOpt, constraints(1, 3, 1, 1));
        optionPanel.add(new JLabel(" "), constraints(1, 4, 1, 1));

        // Display the OptionPane
        Object[] objects = { lblName, txtName, spacer, lblModel, txtModel, spacer, optionPanel };

        int button = JOptionPane.showConfirmDialog(this, objects, "Insert Computer", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        // Add computer if valid to the store
        if (button == JOptionPane.OK_OPTION) {
            try {
                Computer computer = new Computer(txtName.getText(), txtModel.getText());
                for (Object object : selectedOpts.toArray()) {
                    computer.addOption((Option) object);
                }
                store.add(computer);
                onViewClick(Record.COMPUTER);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error With Inserting Computer",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private GridBagConstraints constraints(int col, int row, int cspan, int rspan) {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridy = row;
        constraint.gridx = col;
        constraint.gridheight = rspan;
        constraint.gridwidth = cspan;
        constraint.anchor = GridBagConstraints.CENTER;
        return constraint;
    }

    protected void onViewClick(Record record) {
        JLabel lblHeader = new JLabel(), lblData = new JLabel();
        Object[] objects = null;

        switch (record) {
            case CUSTOMER:
                lblHeader.setText("Customers");
                objects = store.customers();
                break;
            case OPTION:
                lblHeader.setText("Options");
                objects = store.options();
                break;
            case COMPUTER:
                lblHeader.setText("Computers");
                objects = store.computers();
                break;
            case ORDER:
                lblHeader.setText("Orders");
                objects = store.orders();
                break;
        }

        display.setText("<html><p><font size=+2>" + lblHeader.getText() + "</font></p><br/><ol>");
        for (Object object : objects) {
            String replacer = object.toString();
            replacer = replacer.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
            replacer = replacer.replaceAll("<", "&lt;").replace(">", "&gt;").replaceAll("\n", "<br/>");
            lblData.setText(lblData.getText() + "<li>" + replacer + "</li>");
        }

        display.setText(display.getText() + lblData.getText() + "</ol></html>");
    }

    protected void onAboutClick() { // Display About dialog
        Canvas logo = new Canvas();

        JLabel title = new JLabel("<html><center>"
                + "<p>Exception Laptops and Supercomputers Always</p>"
                + "<p>Version 0.3</p>"
                + "</center></html>",
                SwingConstants.CENTER);

        JLabel artists = new JLabel("<html>"
                + "<br/><p>Copyright 2023 by Brandon M. Faulkner</p>"
                + "<p>Licensed under Gnu GPL 3.0</p><br/>"
                + "<p>ELSA Logo, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.freepik.com/free-photos-vectors/computer-store-logo - Created by Freepik</font></p>"
                + "<br/><p>New File, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/new-document_4212157 - Created by Tempo_doloe</font></p>"
                + "<br/><p>Open File, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/open-folder-with-document_32743 - Created by Freepik</font></p>"
                + "<br/><p>Save File, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/diskette_2874050 - Created by Yogi Aprellityanto</font></p>"
                + "<br/><p>Save File As, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/save-as_1539 - Created by Freepik</font></p>"
                + "<br/><p>Insert Customer, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/add-friend_2583118 - Created by Freepik</font></p>"
                + "<br/><p>Insert Option, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/add_2879271 - Created by Pixel perfect</font></p>"
                + "<br/><p>Insert Computer, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/computer_159356 - Created by Freepik</font></p>"
                + "<br/><p>View Customers, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/multiple-users-silhouette_33308 - Created by Freepik</font></p>"
                + "<br/><p>View Options, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/network_9533704 - Created by Vectorslab</font></p>"
                + "<br/><p>View Computers, licensed for personal and commercial purposes with attribution</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/network_1311693 - Created by Freepik</font></p>"
                + "</html>");

        JOptionPane.showMessageDialog(this,
                new Object[] { logo, title, artists },
                "About ELSA",
                JOptionPane.PLAIN_MESSAGE);
    }

    protected void onQuitClick() {
        System.exit(0);
    } // Exit the store

    private String fileName = "ELSA.txt";
    private Store store;
    private JLabel display;
}
