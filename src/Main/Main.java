package Main;

import Alimentacion.Alimento;
import Alimentacion.Dieta;
import DatosUsuario.EstadoFisico;
import DatosUsuario.Usuario;
import Ejercitacion.Ejercicio;
import Ejercitacion.Rutina;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
            Dieta.escribirDieta(recomendarDieta(alimentosDisponibles));
            Rutina.escribirRutina(recomendarRutina(ejerciciosDisponibles,usuario.getEstadoFisico()));
        }


    }

    public static Dieta recomendarDieta(ArrayList<Alimento> alimentosDisponibles) {;
        ArrayList<Alimento> alimentosDieta = new ArrayList<>();
        Random randomizer = new Random();
        int randomIndex;
        int contadorTipos = 0; //cuando llegue a 7 significa que están todos los tipos
        //selecciona un alimento al azar de cada tipo de la lista de alimentos disponibles
        while (contadorTipos < 7) {
            randomIndex = randomizer.nextInt(0,alimentosDisponibles.size() + 1);
            if (!Alimento.seEncuentraTipo(alimentosDieta,alimentosDisponibles.get(randomIndex).getTipo())) {
                alimentosDieta.add(alimentosDisponibles.get(randomIndex));
                contadorTipos++;
            }
        }
        return new Dieta(alimentosDieta);
    }
    public static Rutina recomendarRutina(ArrayList<Ejercicio> ejerciciosDisponibles, EstadoFisico estadoUsuario) {
        Random randomizer = new Random();
        ArrayList<Ejercicio> ejerciciosRutina = new ArrayList<>();
        float pesoIdeal = estadoUsuario.getIMC() * (estadoUsuario.getAltura() * estadoUsuario.getAltura());
        int randomIndex, duracionTotal = 0;
        //dos casos, uno se calcula para ganar músculo y el otro para perder grasa
        //ganar musculatura, se arma una rutina según lo recomendado, solo 3500 (500 diarias) semanales por cuatro semanas
        //perder grasa (3500 calorías semanales por kilo), plan de cuatro semanas
        int caloriasQuemar = pesoIdeal >= estadoUsuario.getPeso() ? 500 :
                (int) (Math.floor(estadoUsuario.getPeso() - pesoIdeal) / 4) * 500;
        while (caloriasQuemar > 0) {
            randomIndex = randomizer.nextInt(0,ejerciciosDisponibles.size() + 1);
            ejerciciosRutina.add(ejerciciosDisponibles.get(randomIndex));
            caloriasQuemar -= ejerciciosDisponibles.get(randomIndex).getCaloriasQuemadasPorMinuto() *
                    ejerciciosDisponibles.get(randomIndex).getDuracionEstimada();
            duracionTotal += ejerciciosDisponibles.get(randomIndex).getDuracionEstimada();
        }
        return new Rutina(ejerciciosRutina, duracionTotal >= 30 ? (int) duracionTotal / 8 : (int) duracionTotal / 4);
    }
}

