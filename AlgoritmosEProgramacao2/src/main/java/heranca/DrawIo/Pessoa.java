package heranca.DrawIo;

public class Pessoa extends Usuario{
    private Integer idPessoa;
    private String nome;
    private String tipoPessoa;
    private String nuCpfCnpj;

    public Pessoa() {}
    public Pessoa(String nome, String tipoPessoa, String nuCpfCnpj, Integer idPessoa) {
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.nuCpfCnpj = nuCpfCnpj;
        this.idPessoa = idPessoa + 1;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNuCpfCnpj() {
        return nuCpfCnpj;
    }

    public void setNuCpfCnpj(String nuCpfCnpj) {
        this.nuCpfCnpj = nuCpfCnpj;
    }

    void mostrarDados(){
        System.out.println("ID: " + idPessoa);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo Pessoa: " + tipoPessoa);
        System.out.println("Numero CPF/CNPJ: " + nuCpfCnpj);
    }
}
