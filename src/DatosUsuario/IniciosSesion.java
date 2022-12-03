package DatosUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class IniciosSesion {
    //registra la fecha actual en un archivo csv llamado inicios sesion
    public static void registrarInicioSesion(Date fecha) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoInicios = new File(filePath + "\\Recursos\\DatosUsuario\\IniciosSesion.csv");
        try (FileWriter writer = new FileWriter(archivoInicios, true);) {
            writer.write(fecha.toString() + ",");
            System.out.println("escrito");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de registro de inicio de sesión no encontrado");
        }
    }

    //devuelve un arraylist de strings de los registros de inicio de sesion
    public static ArrayList<String> obtenerIniciosSesion() {
        String filePath = new File("").getAbsolutePath();
        File archivoInicios = new File(filePath + "\\Recursos\\DatosUsuario\\IniciosSesion.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(archivoInicios))) {
            ArrayList<String> iniciosSesion = new ArrayList<>();
            String linea = "";
            while ((linea = br.readLine()) != null) {
                for (String elemento :
                        linea.split(",")) {
                    if (!("".equals(elemento))) {
                        iniciosSesion.add(elemento);
                    }
                }
            }
            return iniciosSesion;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de registro de inicio de sesión no encontrado");
        } catch (IOException e) {
            System.out.println("El archivo no se pudo cerrar");
        }
        return null;
    }
}
