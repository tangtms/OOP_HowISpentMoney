/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howispentmoney;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tang-pc
 */
public class Activity extends javax.swing.JPanel {

    /**
     * Creates new form Activity
     */
    public Activity() {
            initComponents();
            show_user();
            System.out.println(Login.username_tf.getText());
    }
    public ArrayList<Userdata> userData(){
        Connection connect = null;
        Statement s = null;
        String userid = null;
        ArrayList<Userdata> userData = new ArrayList<>();
        try{
            connect = DriverManager.getConnection("jdbc:derby:C:\\Users\\Thitiwut\\Documents\\GitHub\\HowISpentMoney\\.derby\\db_hism", "", "");
            String sql = "select * FROM APP.USERDATA WHERE USERNAME = '"+DatabaseConnection.user_name+"'";
            s = connect.createStatement();
            ResultSet rec = s.executeQuery(sql);
            Userdata theData;
            while(rec.next()){
                theData = new Userdata(rec.getTimestamp("TIMESTAMP"), rec.getString("TYPE"), rec.getString("TYPE_DES"), rec.getDouble("VALUE"));
                userData.add(theData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return userData;
    }
    public void show_user(){
        ArrayList<Userdata> list = userData();
        DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
        Object[] row = new Object[4];
        for (int i=0; i<list.size(); i++){
            row[0] = list.get(i).getTIMESTAMP();
            row[1] = list.get(i).getTYPE();
            row[2] = list.get(i).getTYPE_DES();
            row[3] = list.get(i).getVALUE();
            model.addRow(row);
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display = new javax.swing.JTable();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Type", "Type Des", "Value"
            }
        ));
        jScrollPane1.setViewportView(jTable_Display);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(155, 155, 155))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Main.demo.toDash();
        System.out.println("In");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display;
    // End of variables declaration//GEN-END:variables
}
