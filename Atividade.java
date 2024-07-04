public class Atividade {
    private String nomeAtividade;
    private int numeroEquipes;
    private String[] listaAtividades;
    private Campeonato[][] campeonatos; // Array para armazenar os campeonatos de cada atividade
    private int[] numCampeonatos; // Array para manter o número de campeonatos de cada atividade

    public Atividade(String nomeAtividade, int numEquipes, int numAtividades) {
        this.nomeAtividade = nomeAtividade;
        this.numeroEquipes = numeroEquipes;
        listaAtividades = new String[numAtividades];
        campeonatos = new Campeonato[numAtividades][100]; // Assumindo um máximo de 100 campeonatos por atividade
        numCampeonatos = new int[numAtividades];
        inicializarAtividades();
    }

    // Métodos getters para nomeAtividade e numEquipes
    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public int getNumeroEquipes() {
        return numeroEquipes;
    }
    private void inicializarAtividades() {
        // Adicione aqui todas as atividades disponíveis
        listaAtividades[0] = "Futsal";
        listaAtividades[1] = "Paintball";
        listaAtividades[2] = "Escalada";
        listaAtividades[3] = "Rappel";
        listaAtividades[4] = "Canoagem";
        listaAtividades[5] = "Rafting";
        // Adicione outras atividades conforme necessário
    }

    public void listarAtividades() {
        System.out.println("Atividades disponíveis:");
        for (int i = 0; i < listaAtividades.length; i++) {
            if (listaAtividades[i] != null) {
                System.out.println((i + 1) + ". " + listaAtividades[i]);
            }
        }
    }
    

    public void adicionarCampeonato(int indiceAtividade, Campeonato campeonato) {
        if (indiceAtividade >= 0 && indiceAtividade < listaAtividades.length) {
            if (numCampeonatos[indiceAtividade] < campeonatos[indiceAtividade].length) {
                campeonatos[indiceAtividade][numCampeonatos[indiceAtividade]] = campeonato;
                numCampeonatos[indiceAtividade]++;
                System.out.println("Campeonato adicionado com sucesso à atividade " + listaAtividades[indiceAtividade] + ".");
            } else {
                System.out.println("Limite máximo de campeonatos atingido para a atividade " + listaAtividades[indiceAtividade] + ".");
            }
        } else {
            System.out.println("Índice de atividade inválido.");
        }
    }

    // Outros métodos, como remover campeonatos ou acessar informações dos campeonatos, podem ser implementados conforme necessário
}
