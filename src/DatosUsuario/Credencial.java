package DatosUsuario;

import Alimentacion.Alimento;
import Alimentacion.TipoAlimento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Credencial implements MetodosCredencial{
    private String username;
    private String password;

    //builder
    public Credencial(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Credencial(){
        try {
            this.leerCredencial();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //getters y setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }


    //METODOS
    public boolean passwordCoincide(String passwordComprobar) {return password.equals(passwordComprobar);}
    public boolean usernameCoincide(String usernameComprobar) {return username.equals(usernameComprobar);}
    public boolean esCredencial(String usernameBuscar) {
        if (this.usernameCoincide(usernameBuscar)) {
            return true;
        }
        return false;
    }
    public boolean passwordPermite(Credencial credencial, String password) {
        return credencial.passwordCoincide(password);
    }
    //Obtener credencial desde txt
    public void leerCredencial() throws FileNotFoundException {
        int cantidadAtributos = 2;
        String[] atributosAgregar = new String[cantidadAtributos];
        String filePath = new File("").getAbsolutePath();
        File archivoCredenciales = new File(filePath + "\\Recursos\\DatosUsuario\\Credenciales.txt");
        Scanner scannerCredenciales = new Scanner(archivoCredenciales);
        for (int i = 0; i < cantidadAtributos; i++) {
            atributosAgregar[i] = scannerCredenciales.nextLine();
        }
        this.username = atributosAgregar[0];
        this.password = atributosAgregar[1];
        scannerCredenciales.close();
    }

    //Registrar datos de usuario, usado para actualizar el listado de credenciales. Lo hace sin getters de credencial
    //SOLO PUEDE HABER UN USUARIO, POR ESO REESCRIBE
    public static void registrarCredencial(String alias, String password) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoCredenciales = new File(filePath + "\\Recursos\\DatosUsuario\\Credenciales.txt");
        FileWriter writer = new FileWriter(archivoCredenciales);
        writer.write(alias + "\n");
        writer.write(password);
        writer.close();
    }

}
