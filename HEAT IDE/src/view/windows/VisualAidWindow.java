
/**
*
* Copyright (c) 2005 University of Kent
* Computing Laboratory, Canterbury, Kent, CT2 7NP, U.K
*
* This software is the confidential and proprietary information of the
* Computing Laboratory of the University of Kent ("Confidential Information").
* You shall not disclose such confidential Information and shall use it only
* in accordance with the terms of the license agreement you entered into with
* the University.
*
* @author Chris Olive, Dean Ashton
*
*/

package view.windows;

import managers.WindowManager;

import utils.jsyntax.*;

import utils.Settings;
import managers.SettingsManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisualAidWindow {
 private JPanel jpMain = new JPanel();
 private JPanel jPanel1 = new JPanel();
 private JPanel jButton1 = new JPanel();
 private JLabel jlHeat = new JLabel();
 private FlowLayout flowLayout1 = new FlowLayout();
 private JLabel jLabel1 = new JLabel();
 private JDialog dialog;
 private BorderLayout borderLayout1 = new BorderLayout();
 private JPanel jPanel2 = new JPanel();
 private JButton jbClose = new JButton();
 private JButton jbDefault = new JButton();
 private JButton jbLargeFont = new JButton();
 private JButton jbXLargeFont = new JButton();
 private FlowLayout flowLayout2 = new FlowLayout();
 private static Logger log = Logger.getLogger("heat");
 private SettingsManager sm; 
 private WindowManager wm;
 
 
 
 public VisualAidWindow() {
   try {
     jbInit();
   } catch (Exception e) {
     e.printStackTrace();
   }
 }
 /**
  * Sets the layout of the pop-up window.
  * Specifies the positions of the buttons.
  * @throws Exception
  */

 private void jbInit() throws Exception {
   sm = SettingsManager.getInstance();
   wm = WindowManager.getInstance();
   jpMain.setLayout(borderLayout1);
   jPanel1.setLayout(flowLayout1);
   jlHeat.setText("Font Size");
   jlHeat.setFont(new Font("Dialog", 3, 20 ));
   flowLayout1.setAlignment(0);
   jPanel2.setLayout(flowLayout2);
   flowLayout2.setAlignment(FlowLayout.RIGHT);
   
//   Buttons 
//   Close Button
   jbClose.setText("Apply");
   jbClose.setFont(new Font(null, 5, 20));
   jbClose.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
         jbClose_actionPerformed(e);
       }
     });
   
// 	 Buttons Area
   jButton1.setLayout(new BoxLayout(jButton1, BoxLayout.PAGE_AXIS));
   jButton1.add(Box.createVerticalBox());
   jButton1.add(Box.createRigidArea(new Dimension(100,30)));
   
   
//	 Default button settings
   jbDefault.setText(" Default Font Size ");
   jbDefault.setFont(new Font(null, 5, 24));
   jbDefault.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent b) {
		   
//		 Set font size and save settings
		 sm.setSetting(Settings.OUTPUT_FONT_SIZE, "12");
		 sm.setSetting(Settings.CODE_FONT_SIZE, "12");
		 sm.saveSettings();
		 sm.loadSettings();
		 
//		 Check settings and apply them
		 String fontSizeStr = sm.getSetting(Settings.CODE_FONT_SIZE);

		    if ((fontSizeStr != null) && (fontSizeStr != "")) {
		      try {
		        int size = Integer.parseInt(fontSizeStr);
		        int fontSize = size;
		        wm.getEditorWindow().setFontSize(fontSize);
		        wm.getConsoleWindow().setFontSize(fontSize);
		        wm.getTreeWindow().setFontSize(fontSize);
		       
		      } catch (NumberFormatException nfe) {
		    	  log.warning("[DisplayWindow] - Failed to parse " +
		    	          Settings.CODE_FONT_SIZE + " setting, check value in settings file");		      
				}
		    }
		 
		   }
   });
   
//   Large Font Button
   jbLargeFont.setText("  Large Font Size  ");
   jbLargeFont.setFont(new Font(null, 5, 24));
   jbLargeFont.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent b) {
		   
//		 Set font size and save settings
		 sm.setSetting(Settings.OUTPUT_FONT_SIZE, "18");
		 sm.setSetting(Settings.CODE_FONT_SIZE, "18");
		 sm.saveSettings();
		 sm.loadSettings();
		 
//		 Check settings and apply them
		 String fontSizeStr = sm.getSetting(Settings.CODE_FONT_SIZE);

		    if ((fontSizeStr != null) && (fontSizeStr != "")) {
		      try {
		        int size = Integer.parseInt(fontSizeStr);
		        int fontSize = size;
		        wm.getEditorWindow().setFontSize(fontSize);
		        wm.getConsoleWindow().setFontSize(fontSize);
		        wm.getTreeWindow().setFontSize(fontSize);
		       
		      } catch (NumberFormatException nfe) {
		    	  log.warning("[DisplayWindow] - Failed to parse " +
		    	          Settings.CODE_FONT_SIZE + " setting, check value in settings file");		      
				}
		    }
		 
		   }
   });  
   
//   XLarge Font Button
   jbXLargeFont.setText(" XLarge Font Size ");
   jbXLargeFont.setFont(new Font(null, 5, 24));
   jbXLargeFont.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent c) {
	    	
//	      Set font size and save settings
		  sm.setSetting(Settings.OUTPUT_FONT_SIZE, "24");
		  sm.setSetting(Settings.CODE_FONT_SIZE, "24");
		  sm.saveSettings();
		  sm.loadSettings();
		  
//		  Check settings and apply them
		  String fontSizeStr = sm.getSetting(Settings.CODE_FONT_SIZE);

		    if ((fontSizeStr != null) && (fontSizeStr != "")) {
		      try {
		        int size = Integer.parseInt(fontSizeStr);
		        int fontSize = size;
		        wm.getEditorWindow().setFontSize(fontSize);
		        wm.getConsoleWindow().setFontSize(fontSize);
		        wm.getTreeWindow().setFontSize(fontSize);
		 
		      } catch (NumberFormatException nfe) {
				log.warning("[DisplayWindow] - Failed to parse " +
		    	          Settings.CODE_FONT_SIZE + " setting, check value in settings file");		      
				}
		    }
		 
		   }
   }); 
   
//   The Header
   jPanel1.add(jlHeat, null);
   jPanel1.add(jLabel1, null);
//   The Footer
   jPanel2.add(jbClose, null);
// Default Button
   jButton1.add(jbDefault, null);
//   Large Button
   jButton1.add(jbLargeFont, null);
//   XLarge Button
   jButton1.add(jbXLargeFont, null);

   
//	 The Container
   jpMain.add(jPanel1, BorderLayout.NORTH);
   jpMain.add(jPanel2, BorderLayout.SOUTH);
   jpMain.add(jButton1, BorderLayout.CENTER);
 }

// Dialog box
 public void show() {
   dialog = new JDialog(WindowManager.getInstance().getMainScreenFrame(),
       "HEAT Visual Aid");
   dialog.setModal(true);
   dialog.getContentPane().add(jpMain);
   dialog.setSize(400, 500);
   dialog.setLocationRelativeTo(WindowManager.getInstance().getMainScreenFrame());
   dialog.setVisible(true);
 }

// Close pop-up window
 private void jbClose_actionPerformed(ActionEvent e) {
   dialog.dispose();
 }


}