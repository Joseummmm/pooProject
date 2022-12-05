package DatosUsuario;

public class EstadoFisico extends Estado{
    //atributos
    private float IMC;

    //builder
    public EstadoFisico() {super();}
    public EstadoFisico(float altura, float peso) {
        super(altura,peso);
        this.IMC = peso / (altura * altura);
    }

    //getters
    public float getIMC() {
        return IMC;
    }

    //setters
    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

    //metodo
    public void imprimirEstadoFisico() {
        System.out.println(super.getPeso());
        System.out.println(super.getAltura());
        System.out.println(getIMC());
    }
}