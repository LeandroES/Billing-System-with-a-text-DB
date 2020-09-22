package Sistema_Facturacion;

import java.util.ArrayList;
import java.io.*;
import javax.swing.JOptionPane;

public class CollectionCliente {
	
	private ArrayList<ClassCliente> clientes;
	private ClassCliente c;
	
	public CollectionCliente()
	{
		clientes=new ArrayList<ClassCliente>();
	}
	
	public String toString()
	{
		String reporte="";
		for(ClassCliente i:clientes)
		{
			reporte+=i.getCodigo()+"\t\t"+
					i.getRuc()+"\t\t"+
					i.getRazon_social()+"\t\t"+
					i.getDireccion()+"\n";
		}
		return reporte;
	}
	
	public int LongitudClientes()
	{
		return clientes.size();
	}
	
	public ClassCliente ObtenerCliente(int codigo)
	{
		return clientes.get(codigo);
	}
	
	public void AgregarClientes(int codigo, String ruc, String razon_social, String direccion)
	{
		c=new ClassCliente(codigo,ruc,razon_social,direccion);
		clientes.add(c);
	}
	
	public ClassCliente BusquedaCliente(int codigo)
	{
		ClassCliente b;
		for(int i=0;i<LongitudClientes();i++)
		{
			b=ObtenerCliente(i);
			if(b.getCodigo()==codigo)
			{
				return b;
			}
		}
		return null;
	}
	
	public void EliminarCliente(int codigo)
	{
		ClassCliente e=BusquedaCliente(codigo);
		clientes.remove(e);
	}
	
	public void EliminarTodosClientes()
	{
		if(LongitudClientes()>0)
		{
			clientes.clear();
		}
	}
	
	public void GrabarClientes()
	{
		try{
			PrintWriter pw;
			ClassCliente c;
			String linea;
			
			pw=new PrintWriter(new FileWriter("TbClientes.txt"));
			
			for(int i=0;i<clientes.size();i++)
			{
				c=clientes.get(i);
				linea=c.getCodigo()+"\t"+
						c.getRuc()+"\t"+
						c.getRazon_social()+"\t"+
						c.getDireccion();
				pw.println(linea);
			}
			pw.close();
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void CargarClientes()
	{
		try{
			BufferedReader br;
			String linea, s[];
			
			int codigo;
			String ruc, razon_social, direccion;
			
			br=new BufferedReader(new FileReader("TbClientes.txt"));
			while((linea=br.readLine())!=null)
			{
				s=linea.split("\t");
				codigo=Integer.parseInt(s[0]);
				ruc=s[1];
				razon_social=s[2];
				direccion=s[3];
				clientes.add(new ClassCliente(codigo,ruc,razon_social,direccion));
			}
			br.close();
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
