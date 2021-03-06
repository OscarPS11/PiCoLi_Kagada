package control;

import acciones.Actualizador;
import acciones.Barajador;
import acciones.Borrador;
import acciones.Encolador;
import acciones.Iniciador;
import acciones.ListenerBorrar;
import acciones.Pedidor;
import acciones.Retroceso;
import acciones.Seleccionador;
import modelo.Datos;
import vista.VistaPrincipal;

public class Puente extends VistaPrincipal {
	private Seleccionador seleccionarColor;
	private Pedidor pedirColor;
	private Logica logica;
	private Barajador barajarPila;
	private Borrador borrarColor;
	private Datos datos;
	private Actualizador actualizador;
	private Encolador encolador;
	private Retroceso retroceso;
	private ListenerBorrar listenerBorrar;
	
	public Puente() {
		super();
		Iniciador iniciador = new Iniciador(this.cola);
		this.datos = iniciador.crearDatos();
		this.logica = iniciador.crearLogica();
		this.actualizador = new Actualizador();
		this.retroceso = new Retroceso(this.panelSeleccionarColor, this.botonSeleccionarColor,this.panelPedirColor,this.botonPedirColor,this.botonBorrarColor,this.panelBorrarColor, actualizador);
		this.encolador = new Encolador(this.logica,this.cola,this.pilaUno,this.pilaDos,this.actualizador,this.lista,this.botonSeleccionarColor,this.panelSeleccionarColor,this.botonPedirColor,this.panelPedirColor,this.puntosMonedas, this.mensaje,this.botonBarajarPila);
		this.seleccionarColor = new Seleccionador(this.panelSeleccionarColor, this.botonSeleccionarColor,this.logica,this.actualizador,this.encolador,this.retroceso);
		this.botonSeleccionarColor.addActionListener(seleccionarColor);
		this.pedirColor= new Pedidor(this.panelPedirColor, this.botonPedirColor,this.logica,this.actualizador,this.encolador,this.retroceso);
		this.botonPedirColor.addActionListener(pedirColor);
		this.listenerBorrar = new ListenerBorrar(logica, actualizador, lista, botonSeleccionarColor, puntosMonedas, botonBorrarColor, panelBorrarColor);
		this.borrarColor=new Borrador(panelBorrarColor, botonBorrarColor, actualizador,retroceso, listenerBorrar, logica);
		this.botonBorrarColor.addActionListener(this.borrarColor);
		this.barajarPila= new Barajador(this.pilaUno,this.pilaDos,this.datos,this.actualizador,this.logica, this.botonBarajarPila);
		this.botonBarajarPila.addActionListener(barajarPila);
		if (this.logica.isPerdedor()) {
			this.botonBarajarPila.setEnabled(false);
		}
		}

}
