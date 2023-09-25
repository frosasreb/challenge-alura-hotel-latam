package jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import jdbc.dao.ReservacionesDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reservaciones;

public class ReservacionesController {
	
	private ReservacionesDAO reservaDAO;
	
	 public ReservacionesController() {
			Connection connection = new ConnectionFactory().recuperarConexion();
			this.reservaDAO = new ReservacionesDAO(connection);
	}
	
	public void guardar(Reservaciones reserva) {
		this.reservaDAO.guardarReservacion(reserva);
	}
		
	public List<Reservaciones> listarReservas() {
		return this.reservaDAO.listarReservaciones();
	}
	
	public List<Reservaciones> listarReservasId(String id) {
		return this.reservaDAO.buscarReservacionPorId(id);
	}
	
	public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		this.reservaDAO.actualizarReservacion(fechaE, fechaS, valor, formaPago, id);
	}
	
	public void eliminar(Integer id) {
		this.reservaDAO.eliminarReservacion(id);
	}

}
