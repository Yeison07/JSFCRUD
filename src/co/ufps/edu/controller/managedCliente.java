package co.ufps.edu.controller;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.ufps.edu.entities.Cliente;
import co.ups.edu.dao.ClienteDAO;

@ManagedBean
@SessionScoped
public class managedCliente {
	
	private Cliente cliente;
	private ClienteDAO clienteD;
	private List<Cliente> listaClientes;
	private String mensaje="";
	
	public managedCliente() {
		// TODO Auto-generated constructor stub
		cliente= new Cliente();
		clienteD= new ClienteDAO();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAO getClienteD() {
		return clienteD;
	}

	public void setClienteD(ClienteDAO clienteD) {
		this.clienteD = clienteD;
	}

	public List<Cliente> getListaClientes() {
		this.listaClientes=clienteD.selectAll();
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void guardar() {
		try {
			this.clienteD.insert(cliente);
			this.cliente= new Cliente();
			this.mensaje="Cliente almacenado con exito";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
			// TODO: handle exception
		}
		FacesMessage mens= new FacesMessage(this.mensaje);
		FacesContext.getCurrentInstance().addMessage(null, mens);
		
	}
	
	public void editar() {
		try {
			this.clienteD.update(cliente);
			this.cliente= new Cliente();
			this.mensaje="Cliente actualizado con exito";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
			// TODO: handle exception
		}
		FacesMessage mens= new FacesMessage(this.mensaje);
		FacesContext.getCurrentInstance().addMessage(null, mens);
		
	}
	
	public void eliminar(Cliente c) {
		try {
			this.clienteD.delete(c); 
			this.cliente= new Cliente();
			this.mensaje="Cliente eliminado con exito";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
			// TODO: handle exception
		}
		FacesMessage mens= new FacesMessage(this.mensaje);
		FacesContext.getCurrentInstance().addMessage(null, mens);
		
	}
	
	public void cargarID(Cliente c) {
		this.cliente=c;
	}
	
	public void limpiar() {
		this.cliente=new Cliente();
	}
}
