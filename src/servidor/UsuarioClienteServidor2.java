
package servidor;

//Clase que hereda de UsuarioGeneral y indica que el usuario inicializado es el Cliente
public class UsuarioClienteServidor2 extends UsuarioGeneral{
    public void TipodeUsuario(){
        System.out.println("El usuario iniciado es el cliente");
    }
}
