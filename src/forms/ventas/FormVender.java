package forms.ventas;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


import data.DataCompra;
import data.DataConfig;
import data.DataItems;

import net.miginfocom.swing.MigLayout;
import javax.swing.JEditorPane;
import java.awt.Font;

public class FormVender extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JTextField textFieldPrecio;
	protected JTextField textFieldNumCompra;
	protected JComboBox<String> comboBox;
	protected JButton cerrar;
	protected JButton btnvender;
	protected JEditorPane editorContenido;
	
	protected JLabel labelCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormVender dialog = new FormVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public FormVender() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 471, 351);
		getContentPane().setLayout(new MigLayout("gapx 10px, gapy 10px", "[120px][grow 40][grow 30,fill]", "[][][][grow]"));
		{
			JLabel labelModelo = new JLabel("Modelo");
			getContentPane().add(labelModelo, "cell 0 0,alignx left");
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
			btnvender = new JButton("Vender");
			btnvender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					venderJDialog(e);
				}
			});
			getContentPane().add(btnvender, "cell 2 0");
		}
		{
			JLabel labelPrecio = new JLabel("Precio (S/)");
			getContentPane().add(labelPrecio, "cell 0 1,alignx left");
		}
		{
			textFieldPrecio = new JTextField();
			getContentPane().add(textFieldPrecio, "cell 1 1,growx");
			textFieldPrecio.setColumns(10);
		}
		{
			JButton btncerrar = new JButton("Cerrar");
			btncerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closeJDialog();
				}
			});
			getContentPane().add(btncerrar, "cell 2 1");
		}
		{
			labelCantidad = new JLabel("Cantidad");
			getContentPane().add(labelCantidad, "cell 0 2,alignx left");
		}
		{
			textFieldNumCompra = new JTextField();
			getContentPane().add(textFieldNumCompra, "cell 1 2,growx");
			textFieldNumCompra.setColumns(10);
		}
		{
			editorContenido = new JEditorPane();
			editorContenido.setFont(new Font("Consolas", Font.PLAIN, 14));
			editorContenido.setEnabled(false);
			getContentPane().add(editorContenido, "cell 0 3 3 1,grow");
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
		int cant_model0 = DataItems.contenido0 - DataCompra.contenido0;
		//	
		if(cant_model0 == 0) {
			textFieldNumCompra.setEditable(false);
		}
		
    	textFieldPrecio.setText(Double.toString(DataItems.precio0));
    	labelCantidad.setText("Cantidad Stock("+ cant_model0 +") ");
	}
	
	public void setValuesFields(String model) {
		
		//int cant_model0 = DataItems.contenido0 - DataCompra.contenido0;
		int cantidad_compras = 0;
		
		if(model == DataCompra.modelo0) {
			cantidad_compras += DataCompra.contenido0;
		}
		
		if(model == DataCompra.modelo1) {
			cantidad_compras += DataCompra.contenido1;
		}
		
		if(model == DataCompra.modelo2) {
			cantidad_compras += DataCompra.contenido2;
		}
		
		if(model == DataCompra.modelo3) {
			cantidad_compras += DataCompra.contenido3;
		}
		
		if(model == DataCompra.modelo4) {
			cantidad_compras += DataCompra.contenido4;
		}
		
		///////////////////////////////////////////////
		int cantidad_stock = 0;
		
		if(model.equals(DataItems.modelo0)) {
			cantidad_stock = DataItems.contenido0 - cantidad_compras;
			
		} else if(model.equals(DataItems.modelo1)) {
			cantidad_stock = DataItems.contenido1 - cantidad_compras;
			
		} else if(model.equals(DataItems.modelo2)) {
			cantidad_stock = DataItems.contenido2 - cantidad_compras;
			
		} else if(model.equals(DataItems.modelo3)) {
			cantidad_stock = DataItems.contenido3 - cantidad_compras;
			
		} else if(model.equals(DataItems.modelo4)) {
			cantidad_stock = DataItems.contenido4 - cantidad_compras;
		}
		
		if(cantidad_stock == 0) {
			textFieldNumCompra.setEditable(false);
		}
		
    	labelCantidad.setText("Cantidad Stock("+ cantidad_stock +") ");
        
	}
	
	
	public void closeJDialog() {
		dispose();
	}
	
	public void venderJDialog(ActionEvent e) {
		
		String model_selected = (String) comboBox.getSelectedItem();
		int numcompra = 0;
		
		try {
			numcompra = Integer.parseInt(textFieldNumCompra.getText());
		} catch (Exception e2) {
			//dataContenido = 0;
			System.out.println(e2.getMessage());
		}
				
			
		if(DataCompra.currentpositionkey == 0) {
			
			int stock = procesar_compra(model_selected, numcompra);
			
			if(stock >= 0) {
				DataCompra.contenido0 = numcompra;
				DataCompra.modelo0 = model_selected;
				// boleta de venta
				PrintListItem(DataCompra.currentpositionkey);
				
				// incrementar el puntero
				DataCompra.currentpositionkey += 1;
				
			}
				
			
		} else if(DataCompra.currentpositionkey == 1) {
			
			int stock = procesar_compra(model_selected, numcompra);
			
			if(stock >= 0) {
				DataCompra.contenido1 = numcompra;
				DataCompra.modelo1 = model_selected;
				// boleta de venta
				PrintListItem(DataCompra.currentpositionkey);
				
				// incrementar el puntero
				DataCompra.currentpositionkey += 1;
				
			}
			
			
		} else if(DataCompra.currentpositionkey == 2) {
			
			int stock = procesar_compra(model_selected, numcompra);
			
			if(stock >= 0) {
				DataCompra.contenido2 = numcompra;
				DataCompra.modelo2 = model_selected;
				// boleta de venta
				PrintListItem(DataCompra.currentpositionkey);
				
				// incrementar el puntero
				DataCompra.currentpositionkey += 1;
				
			}
			
		} else if(DataCompra.currentpositionkey == 3) {
			
			int stock = procesar_compra(model_selected, numcompra);
			
			if(stock >= 0) {
				DataCompra.contenido3 = numcompra;
				DataCompra.modelo3 = model_selected;
				// boleta de venta
				PrintListItem(DataCompra.currentpositionkey);
				
				// incrementar el puntero
				DataCompra.currentpositionkey += 1;
				
			}
			
		} else if(DataCompra.currentpositionkey == 4) {
			
			int stock = procesar_compra(model_selected, numcompra);
			
			if(stock >= 0) {
				DataCompra.contenido4 = numcompra;
				DataCompra.modelo4 = model_selected;
				// boleta de venta
				PrintListItem(DataCompra.currentpositionkey);
				
				// incrementar el puntero
				//DataCompra.currentpositionkey += 1;
				JDialogAvance();
			}
			
		}
		
		
		
		//dispose();
		
	}
	
	int procesar_compra(String modelname, int numcompra) {
		//int stock = DataItems.contenido0 - numcompra;
		int stock = 0;
		
		if(modelname == DataItems.modelo0) {
			
			stock = DataItems.contenido0 - numcompra;
			if(stock >= 0) {
				DataItems.contenido0 = stock;
				labelCantidad.setText("Cantidad Stock("+ stock +") ");
			}
			
		} else if(modelname == DataItems.modelo1) {
			
			stock = DataItems.contenido1 - numcompra;
			if(stock >= 0) {
				DataItems.contenido1 = stock;
				labelCantidad.setText("Cantidad Stock("+ stock +") ");
			}
			
		} else if(modelname == DataItems.modelo2) {
			
			stock = DataItems.contenido2 - numcompra;
			if(stock >= 0) {
				DataItems.contenido2 = stock;
				labelCantidad.setText("Cantidad Stock("+ stock +") ");
			}
			
		} else if(modelname == DataItems.modelo3) {
			
			stock = DataItems.contenido3 - numcompra;
			if(stock >= 0) {
				DataItems.contenido3 = stock;
				labelCantidad.setText("Cantidad Stock("+ stock +") ");
			}
			
		} else if(modelname == DataItems.modelo3) {
			
			stock = DataItems.contenido4 - numcompra;
			if(stock >= 0) {
				DataItems.contenido4 = stock;
				labelCantidad.setText("Cantidad Stock("+ stock +") ");
			}

		}
		
		return stock;
		
		
		
		
	}
	
	
	
	void alertField() {
		// Crea un borde lineal con un color personalizado (en este caso, rojo)
        Border border = BorderFactory.createLineBorder(Color.RED, 2);
        // Establece el borde personalizado en el JTextField
        textFieldNumCompra.setBorder(border);
	}
	
	void normalField() {
		textFieldNumCompra.setBorder(null);
	}
	
	
	void JDialogAvance() {
		
		JDialog dialog = new JDialog(this, "Diálogo Informativo", true);

        // Define el mensaje que se mostrará
        JLabel messageLabel = new JLabel("Este es un mensaje informativo.");

        // Crea el botón "OK"
        JButton okButton = new JButton("OK");
        okButton.addActionListener(actionEvent -> {
            // Cierra el diálogo cuando se presiona el botón "OK"
            dialog.dispose();
        });

        // Crea un panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.add(messageLabel);
        panel.add(okButton);

        // Agrega el panel al diálogo
        dialog.getContentPane().add(panel);

        // Establece el tamaño del diálogo
        dialog.pack();

        // Centra el diálogo en la pantalla principal
        dialog.setLocationRelativeTo(this);

        // Muestra el diálogo
        dialog.setVisible(true);

	}
	
	
	public void PrintListItem(int key_item) {	
		
		String modelo = "", tipo_obsequio = "";
		double precio = 0.0, importe_compra = 0.0, importe_descuento = 0.0, importe_pagar = 0.0;
		int cantidad_adquirida = 0, unidad_obsequio = 0;
		
		
		if(key_item == 0) {
			modelo = DataCompra.modelo0;
			precio = DataItems.precio0;
			cantidad_adquirida = DataCompra.contenido0;
			importe_compra = precio * cantidad_adquirida;
			// calculo del descuento
			importe_descuento = importe_compra * getPorcentaje(cantidad_adquirida) * 0.01 ;
			// pago real
			importe_pagar = importe_compra - importe_descuento;
			tipo_obsequio = DataConfig.tipoObsequio;
			// calculo de las unidades obsequiadas
			unidad_obsequio = getUnidadesObsequiadas(cantidad_adquirida);
			
		} else if(key_item == 1) {
			modelo = DataCompra.modelo1;
			precio = DataItems.precio1;
			cantidad_adquirida = DataCompra.contenido1;
			importe_compra = precio * cantidad_adquirida;
			// calculo del descuento
			importe_descuento = importe_compra * getPorcentaje(cantidad_adquirida) * 0.01 ;
			// pago real
			importe_pagar = importe_compra - importe_descuento;
			tipo_obsequio = DataConfig.tipoObsequio;
			// calculo de las unidades obsequiadas
			unidad_obsequio = getUnidadesObsequiadas(cantidad_adquirida);
			
		} else if(key_item == 2) {
			modelo = DataCompra.modelo2;
			precio = DataItems.precio2;
			cantidad_adquirida = DataCompra.contenido2;
			importe_compra = precio * cantidad_adquirida;
			// calculo del descuento
			importe_descuento = importe_compra * getPorcentaje(cantidad_adquirida) * 0.01 ;
			// pago real
			importe_pagar = importe_compra - importe_descuento;
			tipo_obsequio = DataConfig.tipoObsequio;
			// calculo de las unidades obsequiadas
			unidad_obsequio = getUnidadesObsequiadas(cantidad_adquirida);
			
		} else if(key_item == 3) {
			modelo = DataCompra.modelo3;
			precio = DataItems.precio3;
			cantidad_adquirida = DataCompra.contenido3;
			importe_compra = precio * cantidad_adquirida;
			// calculo del descuento
			importe_descuento = importe_compra * getPorcentaje(cantidad_adquirida) * 0.01 ;
			// pago real
			importe_pagar = importe_compra - importe_descuento;
			tipo_obsequio = DataConfig.tipoObsequio;
			// calculo de las unidades obsequiadas
			unidad_obsequio = getUnidadesObsequiadas(cantidad_adquirida);
			
		} else if(key_item == 4) {
			modelo = DataCompra.modelo4;
			precio = DataItems.precio4;
			cantidad_adquirida = DataCompra.contenido4;
			importe_compra = precio * cantidad_adquirida;
			// calculo del descuento
			importe_descuento = importe_compra * getPorcentaje(cantidad_adquirida) * 0.01 ;
			// pago real
			importe_pagar = importe_compra - importe_descuento;
			tipo_obsequio = DataConfig.tipoObsequio;
			// calculo de las unidades obsequiadas
			unidad_obsequio = getUnidadesObsequiadas(cantidad_adquirida);
			
		} 
		
		
		
		
		String template = String.join("\n",
			"BOLETA DE VENTA",
			"",
			" Modelo             : " + modelo,
			" Precio             : " + "S/ " + precio,
			" Cantidad adquirida : " + cantidad_adquirida,
			" Importe compra     : " + "S/ "+ importe_compra,
			" Importe descuento  : " + "S/ "+ importe_descuento,
			" importe pagar      : " + "S/ "+ importe_pagar,
			" Tipo obsequio      : " + tipo_obsequio,
			" Unidad obsequio    : " + unidad_obsequio,
			" "
		);
		
		editorContenido.setText(template);
		
	}
	
	// calculo porcentaje dependiendo de la cantidad de unidades
	public double getPorcentaje(int unidades) {
		
		double percent = 0.0;
		
		if(unidades > 15) {
			percent = DataConfig.porcentaje1;
		} else if(unidades >= 11 && unidades <= 15) {
			percent = DataConfig.porcentaje2;
		}  else if(unidades >= 6 && unidades <= 10) {
			percent = DataConfig.porcentaje3;
		} else if(unidades >= 1 && unidades <= 5) {
			percent = DataConfig.porcentaje4;
		}
		
		return percent;
		
	}
	
	// calculo porcentaje dependiendo de la cantidad de unidades
		public int getUnidadesObsequiadas(int unidades) {
			
			int cantidad = 0;
			
			if(unidades > 10) {
				cantidad = DataConfig.obsequioCantidad1;
			} else if(unidades >= 6 && unidades <= 10) {
				cantidad = DataConfig.obsequioCantidad2;
			}  else if(unidades >= 1 && unidades <= 5) {
				cantidad = DataConfig.obsequioCantidad3;
			}
			
			return cantidad;
			
		}

	
}
