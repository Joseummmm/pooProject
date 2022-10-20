package GUI;

import DatosUsuario.Credencial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BotonLogin implements ActionListener {
    private ArrayList<Credencial> credenciales = Credencial.leerCredenciales();
    private String usuarioComprobar;
    private String passwordComprobar;
    private JLabel etiquetaExito;

    public BotonLogin(JTextField usuarioComprobar, JPasswordField passwordComprobar, JLabel etiquetaExito) throws FileNotFoundException {
        this.usuarioComprobar = usuarioComprobar.getText();
        this.passwordComprobar = new String(passwordComprobar.getPassword());
        this.etiquetaExito = etiquetaExito;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Credencial credencialEncontrada = Credencial.buscarCredencial(usuarioComprobar,credenciales);
        if (credencialEncontrada == null) {
            etiquetaExito.setText("Usuario no registrado");
        } else if (!(credencialEncontrada.passwordCoincide(passwordComprobar))) {
            etiquetaExito.setText("Password incorrecta");
        } else {
            etiquetaExito.setText("Password correcta!");
        }
    }
}
