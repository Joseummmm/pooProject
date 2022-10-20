package DatosUsuario;

import Alimentacion.Alimento;
import Alimentacion.TipoAlimento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Credencial {
    private String username;
    private String password;

    //builder
    public Credencial(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //getters y setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //METODOS
    public boolean passwordCoincide(String passwordComprobar) {return password.equals(passwordComprobar);}
    public boolean usernameCoincide(String usernameComprobar) {return username.equals(usernameComprobar);}
    public static Credencial buscarCredencial(String usernameBuscar, ArrayList<Credencial> credenciales) {
        for (Credencial c:
             credenciales) {
            if (c.usernameCoincide(usernameBuscar)) {
                return c;
            }
        }
        return null;
    }
    public boolean passwordPermite(Credencial credencial, String password) {
        return credencial.passwordCoincide(password);
    }
    //Obtener lista de credenciales desde txt
    public static ArrayList<Credencial> leerCredenciales() throws FileNotFoundException {
        ArrayList<Credencial> credenciales = new ArrayList<>();
        int cantidadAtributos = 2;
        String[] atributosAgregar = new String[cantidadAtributos];
        String filePath = new File("").getAbsolutePath(), componentesLinea;
        File archivoCredenciales = new File(filePath + "\\Recursos\\DatosUsuario\\Credenciales.txt");
        Scanner scannerCredenciales = new Scanner(archivoCredenciales);
        while (scannerCredenciales.hasNextLine()) {
            for (int i = 0; i < cantidadAtributos; i++) {
                componentesLinea = scannerCredenciales.nextLine();
                if (componentesLinea.contains(":")) {
                    atributosAgregar[i] = componentesLinea.split(":")[1];
                }
            }
            Credencial credencialAgregar = new Credencial(atributosAgregar[0],atributosAgregar[1]);
            credenciales.add(credencialAgregar);
        }
        scannerCredenciales.close();
        return credenciales;
    }
    //Registrar datos de usuario, usado para actualizar el listado de credenciales. Lo hace sin getters de credencial
    //SOLO PUEDE HABER UN USUARIO, POR ESO REESCRIBE
    public static void registrarCredencial(String alias, String password) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoCredenciales = new File(filePath + "\\Recursos\\DatosUsuario\\Credenciales.txt");
        FileWriter writer = new FileWriter(archivoCredenciales);
        writer.write("alias:" + alias + "\n");
        writer.write("password:" + password + "\n");
        writer.close();
    }

}
