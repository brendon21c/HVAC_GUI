package com.Brendon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/*
This is the widow for enetering a job for a Furnace, it will pass the information
back to the main window and add the job to the furnace list and display the job.
 */
public class FurnaceGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField addressEntry;
    private JLabel AddressEntry;
    private JTextField issueEntry;
    private JComboBox typeSelection;
    private JButton closeButton;
    private Date date = Calendar.getInstance().getTime();


    FurnaceGUI(final HVAC_MainGUI parentComponent) {


        setContentPane(rootPanel);
        setLocation(300,300);
        pack();
        setVisible(true);
        parentComponent.setEnabled(false);


        //hvacManager.data = new Vector<Job>();


        typeSelection.addItem("Forced Air");
        typeSelection.addItem("Boiler");
        typeSelection.addItem("Octopus Style");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String address = addressEntry.getText();
                String issue = issueEntry.getText();
                String type = (String) typeSelection.getSelectedItem();


                Job furn = new Job(address,issue,type,date);

                parentComponent.openList.add(furn);
                parentComponent.openTickets.addElement(furn);
                parentComponent.setEnabled(true);
                FurnaceGUI.this.dispose();


            }
        });

    }




}
