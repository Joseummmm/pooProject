package GUI;

import DatosUsuario.Credencial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class BotonLogin {
    private Credencial credencial = new Credencial();
    private String usuarioComprobar;
    private String passwordComprobar;
    private JLabel etiquetaExito;

    public BotonLogin(JTextField usuarioComprobar, JPasswordField password, JLabel etiquetaExito) {
        this.usuarioComprobar = usuarioComprobar.getText();
        this.passwordComprobar = new String(password.getPassword());
        this.etiquetaExito = etiquetaExito;
    }

    public boolean check() {
        if (!(credencial.getUsername().equals(usuarioComprobar))) {
            etiquetaExito.setText("Usuario no registrado");
        } else if (!(credencial.passwordCoincide(passwordComprobar))) {
            etiquetaExito.setText("Password incorrecta");
        } else {
            etiquetaExito.setText("Password correcta!");
            return true;
        }
        return false;
    }
}



