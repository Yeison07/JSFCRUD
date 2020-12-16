package co.ups.edu.dao;

import java.util.List;

import co.ufps.edu.conexion.Conexion;
import co.ufps.edu.entities.Servicio;

public class ServicioDAO {

Conexion con=null;
	
	public ServicioDAO(){
		con= new Conexion();
		con.setC(Servicio.class);
	}
	
	public Servicio selectById(int id) {
		Servicio e = (Servicio) con.find(id);		
		return e;
	}

	
	public List<Servicio> selectAll() {
		
		List<Servicio> contactos = con.list();

		return contactos;
	}

	
	public void insert(Servicio objeto) {
		
		con.insert(objeto);

	}

	
	public void update(Servicio objeto) {

		con.update(objeto);

	}

	
	public void delete(Servicio objeto) {
		
		con.delete(objeto);

	}
}
