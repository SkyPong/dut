//package jwallet.ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import javax.json.*;

/**
 *
 * @author nicolas
 */
public class JWalletFrame extends javax.swing.JFrame {

  private javax.swing.JMenuItem addMenuItem;
  private javax.swing.JMenu editMenu;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenuItem quitMenuItem;
  private javax.swing.JMenuItem removeMenuItem;
  private javax.swing.JMenuItem updateMenuItem;
  private javax.swing.JTable table;
  private javax.swing.table.DefaultTableModel model;
  private Vector<String> data;

    /**
     * Creates new form MainFrame
     */
    public JWalletFrame() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        quitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        addMenuItem = new javax.swing.JMenuItem();
        removeMenuItem = new javax.swing.JMenuItem();
        updateMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.data = new Vector<>();
        Vector<String> headers = new Vector<>();
        headers.add("URL");
        headers.add("Identifiant");
        headers.add("Mot de passe");
        headers.add("Commentaire");
        this.model = new javax.swing.table.DefaultTableModel(data,headers);

        table.setModel(this.model);

        jScrollPane1.setViewportView(table);

        fileMenu.setText("Fichier");

        quitMenuItem.setText("Quitter");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(quitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Edition");

        addMenuItem.setText("Ajouter");
        addMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(addMenuItem);

        updateMenuItem.setText("Modifier");
		updateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(updateMenuItem);

		removeMenuItem.setText("Supprimer");
		removeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(removeMenuItem);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        pack();
    }

    //--------------------------------------------------------------------------
    // Action listeners
    //--------------------------------------------------------------------------

    private void addMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        model.addRow(new Object[]{null, null, null, null});
    }


	private void updateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {

    }

	private void removeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
            int selectedRow = table.getSelectedRow();
            model.removeRow(selectedRow);
    }

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }


    //--------------------------------------------------------------------------
    // Méthode main
    //--------------------------------------------------------------------------

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JWalletFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JWalletFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JWalletFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JWalletFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JWalletFrame().setVisible(true);
            }
        });
    }
}
