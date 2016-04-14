package com.Brendon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;


/*
This class operates like the others but appends information on resolution such as fees and a final date.
 */
public class resolutionGUI extends JFrame {
    private JPanel resPanel;
    private JTextField resEntry;
    private JTextField fee;
    private JButton closeButton;
    private Date date = Calendar.getInstance().getTime();

    resolutionGUI(final HVAC_MainGUI parentComponent) {

        setContentPane(resPanel);
        setLocation(300,300);
        pack();
        setVisible(true);
        parentComponent.setEnabled(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String entry = resEntry.getText();
                double charge = Double.parseDouble(fee.getText());

                Object userSelect = parentComponent.selection;

                parentComponent.resolvedList.add(userSelect);
                parentComponent.openList.remove(userSelect);
                parentComponent.openTickets.removeElement(userSelect);

                parentComponent.closedTickets.addElement(userSelect + " Resolution: " +
                        entry + " On Date: " + date + " Charged: $ " + charge + "\n");

                parentComponent.setEnabled(true);
                resolutionGUI.this.dispose();

            }
        });



    }

}
