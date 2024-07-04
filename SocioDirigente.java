public class SocioDirigente extends Socio {
    // Atributos específicos para os dirigentes
    private int anosMandato;

    // Construtor
    public SocioDirigente(String nome, int numeroSocio, String bilheteIdentidade, String contribuinte, String morada, String telefone, String email, int anosMandato) {
        super(nome, numeroSocio, bilheteIdentidade, contribuinte, morada, telefone, email, 1); // Estatuto de dirigente (1)
        this.anosMandato = anosMandato;
    }

    // Getters e Setters específicos para dirigentes
    // ...
}
