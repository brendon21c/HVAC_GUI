package com.Brendon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class HVAC_MainGUI extends JFrame {

    private JPanel rootPanel;
    private JRadioButton furnaceRadioButton;
    private JRadioButton ACRadioButton;
    private JList OpenReqList;
    private JList ResolvedList;
    private JButton resolveButton;
    private JButton quitButton;
    private JButton selectButton;

    public DefaultListModel tickets;
    Vector<Job> data;


    private boolean isFurnace;

    public boolean isFurnace() {
        return isFurnace;
    }

    public HVAC_MainGUI() {

        super("HVAC Requests");


        tickets = new DefaultListModel<String>();

        OpenReqList.setModel(tickets);
        OpenReqList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500,500));
        setLocation(300,300);
        pack();
        setVisible(true);

        addListeners();


    }

    public void addListeners() {


        furnaceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 isFurnace = furnaceRadioButton.isSelected();

                if (isFurnace == true) {

                    FurnaceGUI test = new FurnaceGUI();
                    test.FurnaceGUI();
                    //setVisible(false);

                }

                }

        });


        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (Job t : data) {

                    tickets.addElement(t);
                }

            }
        });

    }


}
