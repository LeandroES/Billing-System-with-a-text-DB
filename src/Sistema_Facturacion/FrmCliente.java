package Sistema_Facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.TextArea;
import javax.swing.UIManager;
//import Atxy2k.CustomField.RestrictedTextField;

@SuppressWarnings({ "unused", "serial" })
public class FrmCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton BtnNuevo;
	private JLabel lblMike;
	private JTextField TxtCodigo;
	private JTextField TxtUsuario;
	private JTextField TxtRazonSocial;
	private JTextField TxtDireccion;
	private JLabel lblRuc;
	private JLabel lblRaznSocial;
	private JLabel lblDireccin;
	private JButton BtnGrabar;
	private JButton BtnEliminar;
	private JButton BtnBuscar;
	private JButton BtnSalir;
	private JButton BtnCancelar;
	private TextArea TxtSalida;
	
	CollectionCliente clis=new CollectionCliente();
	private JButton BtnEditar;
	
	boolean grabar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 801, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		BtnNuevo = new JButton("Nuevo");
		BtnNuevo.setBounds(10, 11, 130, 34);
		BtnNuevo.addActionListener(this);
		contentPane.setLayout(null);
		BtnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(BtnNuevo);
		
		lblMike = new JLabel("Codigo :");
		lblMike.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMike.setBounds(82, 81, 67, 27);
		contentPane.add(lblMike);
		
		TxtCodigo = new JTextField();
		TxtCodigo.setEnabled(false);
		TxtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TxtCodigo.setBounds(159, 80, 178, 30);
		contentPane.add(TxtCodigo);
		TxtCodigo.setColumns(10);
		
		TxtUsuario = new JTextField();
		TxtUsuario.setEnabled(false);
		TxtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TxtUsuario.setColumns(10);
		TxtUsuario.setBounds(159, 119, 178, 30);
		contentPane.add(TxtUsuario);
		
		TxtRazonSocial = new JTextField();
		TxtRazonSocial.setEnabled(false);
		TxtRazonSocial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TxtRazonSocial.setColumns(10);
		TxtRazonSocial.setBounds(159, 160, 361, 30);
		contentPane.add(TxtRazonSocial);
		
		TxtDireccion = new JTextField();
		TxtDireccion.setEnabled(false);
		TxtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TxtDireccion.setColumns(10);
		TxtDireccion.setBounds(159, 201, 361, 30);
		contentPane.add(TxtDireccion);
		
		lblRuc = new JLabel("Usuario :");
		lblRuc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRuc.setBounds(78, 120, 71, 27);
		contentPane.add(lblRuc);
		
		lblRaznSocial = new JLabel("Raz\u00F3n Social :");
		lblRaznSocial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRaznSocial.setBounds(37, 161, 112, 27);
		contentPane.add(lblRaznSocial);
		
		lblDireccin = new JLabel("Direcci\u00F3n :");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDireccin.setBounds(66, 202, 83, 27);
		contentPane.add(lblDireccin);
		
		BtnGrabar = new JButton("Grabar");
		BtnGrabar.addActionListener(this);
		BtnGrabar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BtnGrabar.setBounds(142, 11, 130, 34);
		contentPane.add(BtnGrabar);
		
		BtnEliminar = new JButton("Eliminar");
		BtnEliminar.addActionListener(this);
		BtnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BtnEliminar.setBounds(405, 11, 130, 34);
		contentPane.add(BtnEliminar);
		
		BtnBuscar = new JButton("Buscar");
		BtnBuscar.addActionListener(this);
		BtnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BtnBuscar.setBounds(536, 11, 130, 34);
		contentPane.add(BtnBuscar);
		
		BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(this);
		BtnSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BtnSalir.setBounds(10, 562, 130, 34);
		contentPane.add(BtnSalir);
		
		BtnCancelar = new JButton("Cancelar");
		BtnCancelar.addActionListener(this);
		BtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BtnCancelar.setBounds(667, 11, 130, 34);
		contentPane.add(BtnCancelar);
		
		TxtSalida = new TextArea();
		TxtSalida.setEditable(false);
		TxtSalida.setFont(new Font("Dialog", Font.PLAIN, 15));
		TxtSalida.setBounds(10, 250, 864, 296);
		contentPane.add(TxtSalida);
		
		BtnEditar = new JButton("Editar");
		BtnEditar.addActionListener(this);
		BtnEditar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BtnEditar.setBounds(274, 11, 130, 34);
		contentPane.add(BtnEditar);
		
		// Evento para cargar el formulario //
		
		ResetearFormulario();
		ActualizarDatos();
		
		//RestrictedTextField r = new RestrictedTextField();
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == BtnEditar) {
			actionPerformedBtnEditar(arg0);
		}
		if (arg0.getSource() == BtnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == BtnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == BtnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == BtnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == BtnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == BtnNuevo) {
			actionPerformedBtnNuevo(arg0);
			
		}
	}
	
	public void ResetearFormulario()
	{
		BtnNuevo.setEnabled(true);
		BtnGrabar.setEnabled(false);
		BtnEditar.setEnabled(false);
		BtnEliminar.setEnabled(false);
		BtnBuscar.setEnabled(true);
		BtnCancelar.setEnabled(false);
		LimpiarCajas();
		DeshabilitarCajas();
	}
	
	public void LimpiarCajas()
	{
		TxtCodigo.setText(null);
		TxtUsuario.setText(null);
		TxtRazonSocial.setText(null);
		TxtDireccion.setText(null);
		TxtCodigo.requestFocus();
	}
	
	public void HabilitarCajas()
	{
		TxtCodigo.setEnabled(true);
		TxtUsuario.setEnabled(true);
		TxtRazonSocial.setEnabled(true);
		TxtDireccion.setEnabled(true);
		TxtCodigo.requestFocus();
	}
	
	public void DeshabilitarCajas()
	{
		TxtCodigo.setEnabled(false);
		TxtUsuario.setEnabled(false);
		TxtRazonSocial.setEnabled(false);
		TxtDireccion.setEnabled(false);
		TxtCodigo.requestFocus();
	}
	
	public void EliminarTodo()
	{
			clis.EliminarTodosClientes();
	}
	
	public void ActualizarDatos()
	{
		EliminarTodo();
		TxtSalida.setText(null);
		clis.CargarClientes();
		TxtSalida.setText(clis.toString());
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		grabar=true;
		HabilitarCajas();
		LimpiarCajas();
		BtnNuevo.setEnabled(false);
		BtnGrabar.setEnabled(true);
		BtnBuscar.setEnabled(false);
		BtnCancelar.setEnabled(true);
	}
	
	public void AgregarCliente(){
		try
		{
			clis.AgregarClientes(Integer.parseInt(TxtCodigo.getText()),
					TxtUsuario.getText(),
					TxtRazonSocial.getText(),
					TxtDireccion.getText());
					if(grabar==true)
					{
						JOptionPane.showMessageDialog(null, "Cliente Registrado");
					}
					else if(grabar==false)
					{
						JOptionPane.showMessageDialog(null, "Cliente Actualizado");
					}
					LimpiarCajas();
					DeshabilitarCajas();
					clis.GrabarClientes();
					ActualizarDatos();
					ResetearFormulario();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error, Faltan Datos");
		}
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		if(grabar==true)
		{
			if(TxtCodigo.getText().equals("") || TxtUsuario.getText().equals("") || TxtRazonSocial.getText().equals("") || TxtDireccion.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Error, Faltan Datos");
			}
			else
			{
				int codigo;
				codigo=Integer.parseInt(TxtCodigo.getText());
				if(clis.BusquedaCliente(codigo)!=null)
				{
					JOptionPane.showMessageDialog(null, "Error, ya existe un registro con este codigo");
					TxtCodigo.requestFocus();
				}
				else
				{
					AgregarCliente();
				}
			}
		}
		else if(grabar==false)
		{
			int cod=Integer.parseInt(TxtCodigo.getText());
			clis.EliminarCliente(cod);
			AgregarCliente();
			clis.GrabarClientes();
			ActualizarDatos();
		}
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		int cod=Integer.parseInt(TxtCodigo.getText());
		int resp = JOptionPane.showConfirmDialog(null, "�Est� seguro de eliminar el Cliente?");
		if(resp==JOptionPane.YES_OPTION)
		{
			clis.EliminarCliente(cod);
			JOptionPane.showMessageDialog(null, "Cliente eliminado");
			clis.GrabarClientes();
			ActualizarDatos();
			ResetearFormulario();
		}
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		int codigo;
		codigo=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese c�digo a buscar"));
		if(clis.BusquedaCliente(codigo)!=null)
		{
			JOptionPane.showMessageDialog(null, "Registro encontrado");
			TxtCodigo.setText(""+(clis.BusquedaCliente(codigo)).getCodigo());
			TxtUsuario.setText(""+(clis.BusquedaCliente(codigo)).getRuc());
			TxtRazonSocial.setText(""+(clis.BusquedaCliente(codigo)).getRazon_social());
			TxtDireccion.setText(""+(clis.BusquedaCliente(codigo)).getDireccion());
			BtnNuevo.setEnabled(false);
			BtnGrabar.setEnabled(false);
			BtnEditar.setEnabled(true);
			BtnEliminar.setEnabled(true);
			BtnBuscar.setEnabled(false);
			BtnCancelar.setEnabled(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No existe el codigo ingresado");
		}
	}
	
	protected void actionPerformedBtnEditar(ActionEvent arg0) {
		grabar=false;
		HabilitarCajas();
		BtnNuevo.setEnabled(false);
		BtnGrabar.setEnabled(true);
		BtnEditar.setEnabled(false);
		BtnEliminar.setEnabled(false);
		BtnBuscar.setEnabled(false);
		BtnCancelar.setEnabled(true);
		TxtCodigo.setEnabled(false);
	}
	
	protected void actionPerformedBtnSalir(ActionEvent arg0){
		this.setVisible(false);
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		int resp = JOptionPane.showConfirmDialog(null, "�Est� seguro cancelar la Operaci�n?");
		if(resp==JOptionPane.YES_OPTION)
		{
			ResetearFormulario();
		}
	}
}
