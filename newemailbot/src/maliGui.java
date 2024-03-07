import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class maliGui extends JFrame {

    public static String reciver;
    public static String msg;
    public static String subject;

    public void spamGui() {

        // sets layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(5, 10, 5, 10);

        JLabel reciverMail = new JLabel("Write recivers email here:");
        constraint.fill = GridBagConstraints.LINE_START;
        constraint.gridx = 0;
        constraint.gridy = 1;
        add(reciverMail, constraint);

        JTextField reciverField = new JTextField(25);
        constraint.fill = GridBagConstraints.CENTER;
        constraint.gridx = 10;
        constraint.gridy = 1;
        add(reciverField, constraint);

        JLabel emailSubject = new JLabel("Email Subject:");
        constraint.gridx = 0;
        constraint.gridy = 5;
        add(emailSubject, constraint);

        JTextField subjecField = new JTextField(25);
        constraint.gridx = 10;
        constraint.gridy = 5;
        add(subjecField, constraint);

        JLabel reciverMessage = new JLabel("Write spam message:");
        constraint.gridx = 0;
        constraint.gridy = 7;
        add(reciverMessage, constraint);

        JTextField messageField = new JTextField(25);
        constraint.gridx = 10;
        constraint.gridy = 7;
        add(messageField, constraint);

        JButton btn1 = new JButton("spam");
        constraint.anchor = GridBagConstraints.LAST_LINE_END;
        constraint.ipadx = 40;
        constraint.gridx = 10;
        constraint.gridy = 9;
        add(btn1, constraint);

        JButton clearButton = new JButton("Clear Fields");
        constraint.anchor = GridBagConstraints.LAST_LINE_START;
        constraint.ipadx = 40;
        constraint.gridx = 0;
        constraint.gridy = 9;
        add(clearButton, constraint);

        // buttom to execute mail method.
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newMailBot.Mail();
            }
        });

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                reciver = reciverField.getText();
                msg = messageField.getText();
                subject = subjecField.getText();
            }
        });

        // btn1.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent ae) {

        // }
        // });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reciverField.setText("");
                messageField.setText("");
                subjecField.setText("");
            }
        });

        // adds menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemExit);

        menuBar.add(menuFile);

        // adds menu bar to the frame
        setJMenuBar(menuBar);

        // adds window event listener
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent event) {
                int reply = JOptionPane.showConfirmDialog(maliGui.this,
                        "Are you sure you want to quit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (reply == JOptionPane.YES_OPTION) {
                    dispose();
                } else {
                    return;
                }
            }
        });

        // // sets icon image
        // String iconPath = "/icon.png";
        // Image icon = new ImageIcon(getClass().getResource(iconPath)).getImage();
        // setIconImage(icon);

        pack();

        // centers on screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setSize(500, 200);

        setVisible(true);

    }
}
