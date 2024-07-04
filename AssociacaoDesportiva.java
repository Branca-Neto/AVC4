import java.util.Scanner;
import java.util.Calendar;
import java.util.Date; // Adicionado para importar a classe Date
import java.text.SimpleDateFormat; // Adicionado para importar a classe SimpleDateFormat
import java.text.ParseException; // Adicionado para importar a classe ParseException


public class AssociacaoDesportiva {
    private Socio[] socios = new Socio[100]; // Assumindo um máximo de 100 sócios
    private Atividade[] atividades = new Atividade[6]; // existem 6 atividades
    private Campeonato[] campeonatos = new Campeonato[100]; // Supondo um máximo de 100 campeonatos
    private Equipe[] equipes = new Equipe[100]; // Assumindo um máximo de 100 equipes
    private Partida[] partidas = new Partida[100]; // Assumindo um máximo de 100 partidas
    private int numSocios = 0;
    private int numAtividades = 0;
    private int numCampeonatos = 0;
    private int numEquipes = 0;
    private int numPartidas = 0;

    // Métodos para criar, adicionar e registrar entidades na associação

    // Método para criar um sócio
    public void criarSocio(Scanner scanner) {
        System.out.println("\n----- Criar Sócio -----");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Número de sócio: ");
        int numeroSocio = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Bilhete de identidade: ");
        String bilheteIdentidade = scanner.nextLine();
        System.out.print("Contribuinte: ");
        String contribuinte = scanner.nextLine();
        System.out.print("Morada: ");
        String morada = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Estatuto (1 - Dirigente, 2 - Honorário, 3 - Ordinário): ");
        int estatuto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Socio socio = null;
        switch (estatuto) {
            case 1:
                System.out.print("Anos de mandato: ");
                int anosMandato = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                socio = new SocioDirigente(nome, numeroSocio, bilheteIdentidade, contribuinte, morada, telefone, email, anosMandato);
                break;
            case 2:
                socio = new SocioHonorario(nome, numeroSocio, bilheteIdentidade, contribuinte, morada, telefone, email);
                break;
            case 3:
                socio = new SocioOrdinario(nome, numeroSocio, bilheteIdentidade, contribuinte, morada, telefone, email);
                break;
            default:
                System.out.println("Opção inválida para estatuto. O sócio será criado como ordinário.");
                socio = new SocioOrdinario(nome, numeroSocio, bilheteIdentidade, contribuinte, morada, telefone, email);
        }

        socios[numSocios++] = socio;
        System.out.println("Sócio criado com sucesso!");
    }

    // Métodos para adicionar campeonatos, equipes, registrar partidas e pagar quotas
    // ...


//Actividas Disponiveis
 // Mostrar lista de atividades disponíveis
 System.out.println("Atividades disponíveis:");
 for (String atividade : Campeonato.getAtividadesDisponiveis()) {
     System.out.println("- " + atividade);
 }

 // Pedir ao usuário para selecionar uma atividade
 System.out.print("Selecione uma atividade: ");
 String nomeAtividade = scanner.nextLine();

 // Verificar se a atividade selecionada é válida
 if (!Campeonato.validarAtividade(nomeAtividade)) {
     System.out.println("Atividade selecionada não é válida.");
     return;
 }

 // Pedir informações adicionais
 System.out.print("Nome do campeonato: ");
 String nomeCampeonato = scanner.nextLine();

 System.out.print("Data de início (dd/mm/aaaa): ");
 String dataInicioStr = scanner.nextLine();

 System.out.print("Data de fim (dd/mm/aaaa): ");
 String dataFimStr = scanner.nextLine();

 // Converter strings de data para objetos Date
 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 Date dataInicio = null;
 Date dataFim = null;
 try {
     dataInicio = sdf.parse(dataInicioStr);
     dataFim = sdf.parse(dataFimStr);
 } catch (ParseException e) {
     System.out.println("Erro ao converter data. Certifique-se de inserir no formato dd/mm/aaaa.");
     return;
 }

 // Criar o campeonato correspondente e adicionar a atividade
 Campeonato campeonato = new Campeonato(nomeCampeonato, dataInicio, dataFim);
 campeonato.adicionarAtividade(nomeAtividade);

 // Adicionar o campeonato à associação desportiva
 adicionarCampeonato(campeonato);

 System.out.println("Atividade '" + nomeAtividade + "' adicionada ao campeonato '" + nomeCampeonato + "'.");
}

// Método para adicionar um campeonato (pode ser útil para testar a adição de atividades)
public void adicionarCampeonato(Campeonato campeonato) {
 if (numCampeonatos < campeonatos.length) {
     campeonatos[numCampeonatos++] = campeonato;
 } else {
     System.out.println("Número máximo de campeonatos atingido.");
 }
}


// Metodo ara adicionar uma equipe a um campeonato
public void adicionarEquipe(Scanner scanner) {
    System.out.println("\n----- Adicionar Equipe em um Campeonato -----");

    if (numCampeonatos == 0) {
        System.out.println("Não existem campeonatos disponíveis. Por favor, crie um campeonato antes de adicionar uma equipe.");
        return;
    }

    System.out.println("Campeonatos disponíveis:");
    for (int i = 0; i < numCampeonatos; i++) {
        System.out.println((i + 1) + ". " + campeonatos[i].getNome());
    }

    System.out.print("Selecione o número do campeonato para adicionar a equipe: ");
    int escolhaCampeonato = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do scanner

    if (escolhaCampeonato < 1 || escolhaCampeonato > numCampeonatos) {
        System.out.println("Escolha inválida. Por favor, selecione um número de campeonato válido.");
        return;
    }

    Campeonato campeonatoSelecionado = campeonatos[escolhaCampeonato - 1];

    System.out.print("Nome da equipe: ");
    String nomeEquipe = scanner.nextLine();
    System.out.print("Mascote da equipe: ");
    String mascoteEquipe = scanner.nextLine();

    Equipe equipe = new Equipe(nomeEquipe, mascoteEquipe);

    campeonatoSelecionado.adicionarEquipe(equipe);

    equipes[numEquipes++] = equipe;
    System.out.println("Equipe adicionada com sucesso ao campeonato '" + campeonatoSelecionado.getNome() + "'.");
}

// Método para registrar uma partida em um campeonato
public void registrarPartida(Scanner scanner) {
    System.out.println("\n----- Registrar Partida em um Campeonato -----");

    if (numCampeonatos == 0) {
        System.out.println("Não existem campeonatos disponíveis. Por favor, crie um campeonato antes de registrar uma partida.");
        return;
    }

    System.out.println("Campeonatos disponíveis:");
    for (int i = 0; i < numCampeonatos; i++) {
        System.out.println((i + 1) + ". " + campeonatos[i].getNome());
    }

    System.out.print("Selecione o número do campeonato para registrar a partida: ");
    int escolhaCampeonato = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do scanner

    if (escolhaCampeonato < 1 || escolhaCampeonato > numCampeonatos) {
        System.out.println("Escolha inválida. Por favor, selecione um número de campeonato válido.");
        return;
    }

    Campeonato campeonatoSelecionado = campeonatos[escolhaCampeonato - 1];

    // Obter os detalhes da partida
    System.out.print("Número da partida: ");
    int numeroPartida = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do scanner
    System.out.print("Data da partida (dd/mm/aaaa): ");
    String dataPartida = scanner.nextLine(); // Aqui seria necessário converter a string para um objeto de data
    System.out.print("Equipas participantes (separadas por vírgula): ");
    String equipasParticipantesInput = scanner.nextLine();
    String[] equipasParticipantesArray = equipasParticipantesInput.split(",");
    Equipe[] equipasParticipantes = new Equipe[equipasParticipantesArray.length];
    for (int i = 0; i < equipasParticipantesArray.length; i++) {
        // Buscar a equipe pelo nome no campeonato selecionado
        for (Equipe equipe : campeonatoSelecionado.getEquipes()) {
            if (equipe.getNome().equalsIgnoreCase(equipasParticipantesArray[i].trim())) {
                equipasParticipantes[i] = equipe;
                break;
            }
        }
        if (equipasParticipantes[i] == null) {
            // Se a equipe não for encontrada, criar uma nova equipe e adicioná-la ao campeonato
            System.out.println("A equipe '" + equipasParticipantesArray[i] + "' não foi encontrada. Criando uma nova equipe...");
            System.out.print("Mascote da equipe: ");
            String mascoteEquipe = scanner.nextLine();
            equipasParticipantes[i] = new Equipe(equipasParticipantesArray[i], mascoteEquipe);
            campeonatoSelecionado.adicionarEquipe(equipasParticipantes[i]);
            equipes[numEquipes++] = equipasParticipantes[i];
        }
    }

    Partida partida = new Partida(numeroPartida, dataPartida, equipasParticipantes);

    partidas[numPartidas++] = partida;
    System.out.println("Partida registrada com sucesso no campeonato '" + campeonatoSelecionado.getNome() + "'.");
}

// Método para pagar as quotas de um sócio
public void pagarQuotas(Scanner scanner) {
    System.out.println("\n----- Pagar Quotas de um Sócio -----");

    if (numSocios == 0) {
        System.out.println("Não existem sócios disponíveis para pagar as quotas.");
        return;
    }

    System.out.println("Sócios disponíveis:");
    for (int i = 0; i < numSocios; i++) {
        System.out.println((i + 1) + ". " + socios[i].getNome());
    }

    System.out.print("Selecione o número do sócio para pagar as quotas: ");
    int escolhaSocio = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do scanner

    if (escolhaSocio < 1 || escolhaSocio > numSocios) {
        System.out.println("Escolha inválida. Por favor, selecione um número de sócio válido.");
        return;
    }

    Socio socioSelecionado = socios[escolhaSocio - 1];

    // Obter o ano atual para registrar o pagamento das quotas
    int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

    // Verificar se o sócio já pagou as quotas deste ano
    if (socioSelecionado.getAnoUltimoPagamento() == anoAtual) {
        System.out.println("As quotas do sócio selecionado já foram pagas este ano.");
    } else {
        // Registrar o pagamento das quotas do sócio para o ano atual
        socioSelecionado.setAnoUltimoPagamento(anoAtual);
        System.out.println("Quotas do sócio '" + socioSelecionado.getNome() + "' pagas com sucesso para o ano de " + anoAtual + ".");
    }
}
}