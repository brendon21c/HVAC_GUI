package com.Brendon;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


/*
This is the main window which all others will be called from.
 */

public class HVAC_MainGUI extends JFrame {

    private JPanel rootPanel;
    private JRadioButton furnaceRadioButton;
    private JRadioButton ACRadioButton;
    private JList OpenReqList; // List for open tickets
    private JList ResolvedList; // List for closed tickets
    private JButton resolveButton;
    private JButton quitButton;
    private JButton selectButton;

    DefaultListModel openTickets;
    DefaultListModel closedTickets;

    Vector<Object> openList;
    Vector<Object> resolvedList;


    private boolean isFurnace;
    private boolean isAC;
    public Object selection;

    public boolean isFurnace() {
        return isFurnace;
    }

    public boolean isAC() {
        return isAC;
    }

    public HVAC_MainGUI() {

        super("HVAC Requests");


        openTickets = new DefaultListModel<String>();
        closedTickets = new DefaultListModel<String>();
        openList = new Vector<Object>();
        resolvedList = new Vector<Object>();



        OpenReqList.setModel(openTickets);
        OpenReqList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ResolvedList.setModel(closedTickets);
        ResolvedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        setContentPane(rootPanel);
        setPreferredSize(new Dimension(1000,500));
        setLocation(150,200);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        furnaceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                isFurnace = furnaceRadioButton.isSelected();

                }

        });

        ACRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                isAC = ACRadioButton.isSelected();

            }
        });

        /*
        This next block of code checks what option is selected and opens the appropriate window, then resets
        and clears the selection so that it can be reselected.
         */

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isFurnace == true) {

                    FurnaceGUI furnace = new FurnaceGUI(HVAC_MainGUI.this);
                    furnaceRadioButton.setSelected(false);
                    isFurnace = false;


                }
                if (isAC == true) {

                    AC_GUI ac = new AC_GUI(HVAC_MainGUI.this);
                    ACRadioButton.setSelected(false);
                    isAC = false;

                }


            }
        });

        OpenReqList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { // chooses the ticket to be resolved

                selection = OpenReqList.getSelectedValue();


            }
        });

        resolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // opens the resolution window

                resolutionGUI resolve = new resolutionGUI(HVAC_MainGUI.this);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }


}
