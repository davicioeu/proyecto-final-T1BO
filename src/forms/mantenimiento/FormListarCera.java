package forms.mantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.DataItems;

import javax.swing.JEditorPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class FormListarCera extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	protected JButton btnCerrar;
	protected JButton btnListar;
	protected JPanel panel_1;
	protected JTextArea editorContent;
	protected JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormListarCera dialog = new FormListarCera();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormListarCera() {
		setResizable(false);
		setBounds(100, 100, 633, 468);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 371, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 198, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 419, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -214, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CloseJDialog();
				
			}
		});
		panel.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ActionShowListItem();
				
			}
		});
		panel.add(btnListar);
		
		panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		editorContent = new JTextArea();
		editorContent.setFont(new Font("Consolas", Font.PLAIN, 15));
		editorContent.setEnabled(false);
		//editorContent.setLineWrap(true);
		//panel_1.add(editorContent, "name_13501290058600");
		
		scrollPane = new JScrollPane(editorContent);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane, "name_13543735400700");
	}
	
	public void CloseJDialog() {
		dispose();
	}
	
	public void ActionShowListItem() {
		
		String output = String.join("\n",
			"",
			" LISTADO DE CERAMICOS",
			"",
			PrintListItem(DataItems.modelo0, DataItems.precio0, DataItems.ancho0, DataItems.largo0, DataItems.espesor0, DataItems.contenido0),
			PrintListItem(DataItems.modelo1, DataItems.precio1, DataItems.ancho1, DataItems.largo1, DataItems.espesor1, DataItems.contenido1),
			PrintListItem(DataItems.modelo2, DataItems.precio2, DataItems.ancho2, DataItems.largo2, DataItems.espesor2, DataItems.contenido2),
			PrintListItem(DataItems.modelo3, DataItems.precio3, DataItems.ancho3, DataItems.largo3, DataItems.espesor3, DataItems.contenido3),
			PrintListItem(DataItems.modelo4, DataItems.precio4, DataItems.ancho4, DataItems.largo4, DataItems.espesor4, DataItems.contenido4)
		);
		
		editorContent.setText(output);
		editorContent.setCaretPosition(0);
		
		//JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        //verticalScrollBar.setValue(verticalScrollBar.getMinimum());
		
	}
	
	public String PrintListItem(
			String modelo, 
			double precio, 
			double ancho , 
			double largo, 
			double espesor, 
			int contenido) {	
		
		String template = String.join("\n", 
			" Modelo        : " + modelo,
			" Precio        : " + "S/ " + precio,
			" Ancho    (cm) : " + ancho + " cm",
			" Largo    (cm) : " + largo + " cm",
			" Espesor  (mm) : " + espesor + " cm",
			" Contenido     : " + contenido + " unidades",
			" "
		);
		
		
		return template;
	}
	
	
}
