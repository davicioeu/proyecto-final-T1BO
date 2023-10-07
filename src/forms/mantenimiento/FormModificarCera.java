package forms.mantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.DataItems;
import net.miginfocom.swing.MigLayout;

public class FormModificarCera extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JTextField textFieldPrecio;
	protected JTextField textFieldAncho;
	protected JTextField textFieldEspesor;
	protected JTextField textFieldContenido;
	protected JComboBox<String> comboBox;
	protected JButton cerrar;
	protected JButton guardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormModificarCera dialog = new FormModificarCera();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public FormModificarCera() {
		setBounds(100, 100, 405, 221);
		getContentPane().setLayout(new MigLayout("gapx 10px, gapy 10px", "[80px,left][grow][100px,fill]", "[][][][][][]"));
		{
			JLabel labelModelo = new JLabel("Modelo");
			getContentPane().add(labelModelo, "cell 0 0,alignx trailing");
		}
		{
			comboBox = new JComboBox<String>();
			// register event changed Selected
			comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// Action Event
					ActionChangeModel(e);
				}
			});
			
			// set values Models
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
					DataItems.modelo0, 
					DataItems.modelo1, 
					DataItems.modelo2, 
					DataItems.modelo3,
					DataItems.modelo4
			}));
			getContentPane().add(comboBox, "flowx,cell 1 0,growx");
		}
		{
			JButton cerrar = new JButton("Cerrar");
			cerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closeJDialog();
				}
			});
			getContentPane().add(cerrar, "cell 2 0");
		}
		{
			JLabel labelPrecio = new JLabel("Precio (S/)");
			getContentPane().add(labelPrecio, "cell 0 1,alignx trailing");
		}
		{
			textFieldPrecio = new JTextField();
			getContentPane().add(textFieldPrecio, "cell 1 1,growx");
			textFieldPrecio.setColumns(10);
		}
		{
			guardar = new JButton("Guardar");
			guardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveJDialog(e);
				}
			});
			getContentPane().add(guardar, "cell 2 1");
		}
		{
			JLabel labelAncho = new JLabel("Ancho (cm)");
			getContentPane().add(labelAncho, "cell 0 2,alignx trailing");
		}
		{
			textFieldAncho = new JTextField();
			getContentPane().add(textFieldAncho, "cell 1 2,growx");
			textFieldAncho.setColumns(10);
		}
		{
			JLabel labelEspesor = new JLabel("Espesor (mm)");
			getContentPane().add(labelEspesor, "cell 0 3,alignx trailing");
		}
		{
			textFieldEspesor = new JTextField();
			getContentPane().add(textFieldEspesor, "cell 1 3,growx");
			textFieldEspesor.setColumns(10);
		}
		{
			JLabel labelContenido = new JLabel("Contenido");
			getContentPane().add(labelContenido, "cell 0 4,alignx trailing");
		}
		{
			textFieldContenido = new JTextField();
			getContentPane().add(textFieldContenido, "cell 1 4,growx");
			textFieldContenido.setColumns(10);
		}
		
		setDefaultValues();
		
	}
	
	public void ActionChangeModel(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
            // Acciones que deseas realizar cuando se selecciona un elemento
            String itemSelected = (String) comboBox.getSelectedItem();
            
            //System.out.println("Elemento seleccionado: " + itemSelected);
           
            setValuesFields(itemSelected);
            
        }
	}
	
	public void setDefaultValues() {
		setValuesFields(DataItems.modelo0);
	}
	
	public void setValuesFields(String model) {
		if(model == DataItems.modelo0) {
        	textFieldPrecio.setText(Double.toString(DataItems.precio0));
        	textFieldAncho.setText(Double.toString(DataItems.ancho0));
        	textFieldEspesor.setText(Double.toString(DataItems.espesor0));
        	textFieldContenido.setText(Integer.toString(DataItems.contenido0));
        } else if(model == DataItems.modelo1) {
        	textFieldPrecio.setText(Double.toString(DataItems.precio1));
        	textFieldAncho.setText(Double.toString(DataItems.ancho1));
        	textFieldEspesor.setText(Double.toString(DataItems.espesor1));
        	textFieldContenido.setText(Integer.toString(DataItems.contenido1));
        } else if(model == DataItems.modelo2) {
        	textFieldPrecio.setText(Double.toString(DataItems.precio2));
        	textFieldAncho.setText(Double.toString(DataItems.ancho2));
        	textFieldEspesor.setText(Double.toString(DataItems.espesor2));
        	textFieldContenido.setText(Integer.toString(DataItems.contenido2));
        } else if(model == DataItems.modelo3) {
        	textFieldPrecio.setText(Double.toString(DataItems.precio3));
        	textFieldAncho.setText(Double.toString(DataItems.ancho3));
        	textFieldEspesor.setText(Double.toString(DataItems.espesor3));
        	textFieldContenido.setText(Integer.toString(DataItems.contenido3));
        } else if(model == DataItems.modelo4) {
        	textFieldPrecio.setText(Double.toString(DataItems.precio4));
        	textFieldAncho.setText(Double.toString(DataItems.ancho4));
        	textFieldEspesor.setText(Double.toString(DataItems.espesor4));
        	textFieldContenido.setText(Integer.toString(DataItems.contenido4));
        } else {
        	// nothing
        }
	}
	
	
	public void closeJDialog() {
		dispose();
	}
	
	public void saveJDialog(ActionEvent e) {
		
		String dataModel = (String) comboBox.getSelectedItem();
		double dataPrecio = Double.parseDouble(textFieldPrecio.getText());
		double dataAncho = Double.parseDouble(textFieldAncho.getText());
		double dataEspesor = Double.parseDouble(textFieldEspesor.getText());
		int dataContenido = Integer.parseInt(textFieldContenido.getText());
		
		if(dataModel == DataItems.modelo0) {
			DataItems.precio0 = dataPrecio;
			DataItems.ancho0 = dataAncho;
			DataItems.espesor0 = dataEspesor;
			DataItems.contenido0 = dataContenido;
		} else if(dataModel == DataItems.modelo1) {
			DataItems.precio1 = dataPrecio;
			DataItems.ancho1 = dataAncho;
			DataItems.espesor1 = dataEspesor;
			DataItems.contenido1 = dataContenido;
		} else if(dataModel == DataItems.modelo2) {
			DataItems.precio2 = dataPrecio;
			DataItems.ancho2 = dataAncho;
			DataItems.espesor2 = dataEspesor;
			DataItems.contenido2 = dataContenido;
		} else if(dataModel == DataItems.modelo3) {
			DataItems.precio3 = dataPrecio;
			DataItems.ancho3 = dataAncho;
			DataItems.espesor3 = dataEspesor;
			DataItems.contenido3 = dataContenido;
		} else if(dataModel == DataItems.modelo4) {
			DataItems.precio4 = dataPrecio;
			DataItems.ancho4 = dataAncho;
			DataItems.espesor4 = dataEspesor;
			DataItems.contenido4 = dataContenido;
		}
		
		dispose();
		
	}

}
