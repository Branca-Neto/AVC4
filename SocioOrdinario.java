
public class SocioOrdinario extends Socio {
    // Construtor
    public SocioOrdinario(String nome, int numeroSocio, String bilheteIdentidade, String contribuinte, String morada,
                           String telefone, String email) {
        super(nome, numeroSocio, bilheteIdentidade, contribuinte, morada, telefone, email, 3); // Estatuto de ordinário (3)
    }

    // Métodos getters e setters específicos de SocioOrdinario aqui...
}
