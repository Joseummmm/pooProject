package DatosUsuario;

public abstract class Estado {
    private float altura;
    private float peso;

    public Estado(float altura, float peso) {
        this.altura = altura;
        this.peso = peso;
    }
    public Estado(){}
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
