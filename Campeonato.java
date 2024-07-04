import java.util.Date;

public class Campeonato {
    private String nome;
    private Date dataInicio;
    private Date dataFim;
    private Equipe[] equipes;
    private String[] actividades= {"Futsal", "Paintiball", "","Rappel","Canoagem","Rafting","Escalada"};

    private int numEquipes; // Controla o número de equipes atualmente no campeonato

    public Campeonato(String nome, Date dataInicio, Date dataFim, int numMaxEquipes) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.equipes = new Equipe[numMaxEquipes];
        this.numEquipes = 0;
    }


    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipe[] getEquipes() {
        return equipes;
    }

    public void adicionarEquipe(Equipe equipe) {
        if (numEquipes < equipes.length) {
            equipes[numEquipes] = equipe;
            numEquipes++;
        } else {
            System.out.println("Número máximo de equipes atingido.");
        }
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    // Métodos para gerir as equipas, partidas, classificação, etc.
    // ..

    // Métodos para adicionar e manipular equipes
}
