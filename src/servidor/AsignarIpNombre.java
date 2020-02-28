
package servidor;


public class AsignarIpNombre {
    private String nombre;
    private String ip;

    public AsignarIpNombre(String nombre, String ip) {
        this.nombre = nombre;
        this.ip = ip;
    }
    public AsignarIpNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getIp() {
        if (ip=="0"){
            return "127.0.0.1";}
        else{
            return ip;
        }
    }
}    


