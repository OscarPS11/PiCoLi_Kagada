package acciones;

public class IniciarPrograma implements Iniciable{
	Cola cola;
	Pila pila;
	Lista lista;
	
	@Override
	public void iniciarPrograma() {
		cola = new Cola<Colores>();
		for (int i = 0; i < Constantes.TAMANO_COLA; i++) {
			int numero = Utiles.genNumeroRandom();
			cola.getCola().add(Colores.getElement(numero));
		}
		pila = new Pila();
		lista = new Lista();
	}

	@Override
	public void mostrarCambios() {
		// TODO Auto-generated method stub
		
	}
}