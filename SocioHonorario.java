import java.util.Date;
import java.util.List;

public class SocioHonorario extends Socio {
    // Construtor
    public SocioHonorario(String nome, int numeroSocio, String bilheteIdentidade, String contribuinte, String morada,
                          String telefone, String email) {
        super(nome, numeroSocio, bilheteIdentidade, contribuinte, morada, telefone, email, 2); // Estatuto de honorário (2)
    }

    // Métodos getters e setters específicos de SocioHonorario aqui...
}