public class Socio {
    private String nome;
    private int numeroSocio;
    private String bilheteIdentidade;
    private String contribuinte;
    private String morada;
    private String telefone;
    private String email;
    private int estatuto; // 1 - Dirigente, 2 - Honorário, 3 - Ordinário
    private int anoUltimoPagamento;

    // Construtor
    public Socio(String nome, int numeroSocio, String bilheteIdentidade, String contribuinte, String morada, String telefone, String email, int estatuto) {
        this.nome = nome;
        this.numeroSocio = numeroSocio;
        this.bilheteIdentidade = bilheteIdentidade;
        this.contribuinte = contribuinte;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.estatuto = estatuto;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public String getBilheteIdentidade() {
        return bilheteIdentidade;
    }

    public void setBilheteIdentidade(String bilheteIdentidade) {
        this.bilheteIdentidade = bilheteIdentidade;
    }

    public String getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(String contribuinte) {
        this.contribuinte = contribuinte;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstatuto() {
        return estatuto;
    }

    public void setEstatuto(int estatuto) {
        this.estatuto = estatuto;
    }

    public int getAnoUltimoPagamento() {
        return anoUltimoPagamento;
    }

    public void setAnoUltimoPagamento(int anoUltimoPagamento) {
        this.anoUltimoPagamento = anoUltimoPagamento;
    }
}
