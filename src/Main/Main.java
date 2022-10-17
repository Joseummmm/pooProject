package Main;

import Alimentacion.Alimento;
import Alimentacion.Dieta;
import DatosUsuario.Usuario;
import Ejercitacion.Ejercicio;
import Ejercitacion.Rutina;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Alimento> alimentosDisponibles = Alimento.leerAlimentosDisponibles();
        ArrayList<Ejercicio> ejerciciosDisponibles = Ejercicio.leerEjerciciosDisponibles();
        Usuario usuario;
        //establecer datos del objeto usuario dependiendo de si ya existe o no
        if (Usuario.existeUsuario()) {
            usuario = Usuario.leerUsuario();
            usuario.setRutinaRecomendada(Rutina.leerRutina(ejerciciosDisponibles));
            usuario.setDietaRecomendada(Dieta.leerDieta(alimentosDisponibles));
        } else {
            usuario = Usuario.obtenerUsuario();
            Usuario.escribirDatosUsuario(usuario);
        }
    }
}

