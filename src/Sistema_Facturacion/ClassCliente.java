package Sistema_Facturacion;

public class ClassCliente {
	
	private int codigo;
	private String usuario;
	private String pass;
	private String registro;
	
	public ClassCliente()
	{
		
	}
	
	public ClassCliente(int codigo, String usuario, String pass,String registro)
	{
		this.codigo=codigo;
		this.usuario=usuario;
		this.pass=pass;
		this.registro=registro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
