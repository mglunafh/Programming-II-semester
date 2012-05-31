/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guicalculator;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author Fedor Uvarychev
 */
public class Calc extends javax.swing.JFrame {

    private String currentLabel = "";   // то, что выводится в лейбл.
    private int operand = 0;            // операнд
    private String previousOperation = "";      // знак операции
    private boolean opWasPressedBefore = false; //

    /**
     * Creates new form Calc
     */
    public Calc() {
        initComponents();
        setResizable(false);
        sign.setText("");

        NumListener numListener = new NumListener();
        numButton0.addActionListener(numListener);
        numButton1.addActionListener(numListener);
        numButton2.addActionListener(numListener);
        numButton3.addActionListener(numListener);
        numButton4.addActionListener(numListener);
        numButton5.addActionListener(numListener);
        numButton6.addActionListener(numListener);
        numButton7.addActionListener(numListener);
        numButton8.addActionListener(numListener);
        numButton9.addActionListener(numListener);

        CleanListener cleanListener = new CleanListener();
        clearButton.addActionListener(cleanListener);

        OpListener opListener = new OpListener();
        addButton.addActionListener(opListener);
        subButton.addActionListener(opListener);
        mulButton.addActionListener(opListener);
        divButton.addActionListener(opListener);

        EqualsListener equalsListener = new EqualsListener();
        equalsButton.addActionListener(equalsListener);

        SignListener signListener = new SignListener();
        addButton.addActionListener(signListener);
        subButton.addActionListener(signListener);
        mulButton.addActionListener(signListener);
        divButton.addActionListener(signListener);
    }

    // Работает нормально.
    private class NumListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Button button = (Button) e.getSource();

            if (opWasPressedBefore) {
                opWasPressedBefore = false;
                label.setText("0");
                currentLabel = "0";
            }
            if ("0".equals(currentLabel)) {
                currentLabel = button.getLabel();
            } else {
                currentLabel += button.getLabel();
            }
            label.setText(currentLabel);
        }
    }

    // Тоже работает нормально.
    private class CleanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentLabel = "0";
            label.setText(currentLabel);
            operand = 0;
            opWasPressedBefore = false;
            previousOperation = "";
            sign.setText("");
        }
    }

    // Берёт знак, запихивает его.
    private class SignListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Button opButton = (Button) e.getSource();
            sign.setText(opButton.getLabel());
        }
    }

    // Работа с кнопочкой "равно".
    private class EqualsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer currentNum = new Integer(currentLabel);
            calculate(currentNum);
            currentLabel = "" + operand;
            label.setText(currentLabel);
            previousOperation = "";
            opWasPressedBefore = true;
        }
    }

    // Bags shall fall!
    private class OpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Button opButton = (Button) e.getSource();
            Integer currentNum = new Integer(currentLabel);
            calculate(currentNum);
            currentLabel = "" + operand;
            label.setText(currentLabel);
            previousOperation = opButton.getLabel();
            opWasPressedBefore = true;
        }
    }

    private void calculate(int currentNumber) {
        switch (previousOperation) {
            case "+":
                operand += currentNumber;
                break;
            case "-":
                operand -= currentNumber;
                break;
            case "*":
                operand *= currentNumber;
                break;
            case "/":
                if (0 == currentNumber) {
                    JOptionPane.showMessageDialog(rootPane, "Division by zero lol");
                    break;
                } else {
                    operand /= currentNumber;
                }
                break;
            case "":
                operand = currentNumber;
                break;
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        debugLabel = new java.awt.Label();
        numButton1 = new java.awt.Button();
        numButton2 = new java.awt.Button();
        numButton3 = new java.awt.Button();
        numButton4 = new java.awt.Button();
        numButton5 = new java.awt.Button();
        numButton6 = new java.awt.Button();
        numButton7 = new java.awt.Button();
        numButton8 = new java.awt.Button();
        numButton9 = new java.awt.Button();
        numButton0 = new java.awt.Button();
        addButton = new java.awt.Button();
        label = new java.awt.Label();
        subButton = new java.awt.Button();
        mulButton = new java.awt.Button();
        divButton = new java.awt.Button();
        equalsButton = new java.awt.Button();
        clearButton = new java.awt.Button();
        sign = new java.awt.Label();

        jInternalFrame1.setVisible(true);

        debugLabel.setText("label1");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(debugLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(debugLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        numButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        numButton1.setLabel("1");
        numButton1.setName("");
        numButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numButton1ActionPerformed(evt);
            }
        });

        numButton2.setLabel("2");

        numButton3.setLabel("3");

        numButton4.setLabel("4");

        numButton5.setLabel("5");

        numButton6.setLabel("6");

        numButton7.setLabel("7");

        numButton8.setLabel("8");

        numButton9.setLabel("9");

        numButton0.setLabel("0");

        addButton.setActionCommand("addButton");
        addButton.setLabel("+");

        label.setName("");
        label.setText("0");

        subButton.setLabel("-");

        mulButton.setLabel("*");

        divButton.setLabel("/");

        equalsButton.setLabel("=");

        clearButton.setLabel("C");

        sign.setText("label1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mulButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(divButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(numButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numButton0, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
                                    .addComponent(numButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(numButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(59, 59, 59)
                        .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(equalsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numButton0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equalsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(subButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mulButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(divButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        label.getAccessibleContext().setAccessibleName("label");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Calc().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button addButton;
    private java.awt.Button clearButton;
    private java.awt.Label debugLabel;
    private java.awt.Button divButton;
    private java.awt.Button equalsButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private java.awt.Label label;
    private java.awt.Button mulButton;
    private java.awt.Button numButton0;
    private java.awt.Button numButton1;
    private java.awt.Button numButton2;
    private java.awt.Button numButton3;
    private java.awt.Button numButton4;
    private java.awt.Button numButton5;
    private java.awt.Button numButton6;
    private java.awt.Button numButton7;
    private java.awt.Button numButton8;
    private java.awt.Button numButton9;
    private java.awt.Label sign;
    private java.awt.Button subButton;
    // End of variables declaration//GEN-END:variables
}
