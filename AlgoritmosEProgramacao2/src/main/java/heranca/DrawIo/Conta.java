package heranca.DrawIo;

public class Conta extends Pessoa{
    private Integer idConta;
    private String nuConta;
    private String matricula;
    private Double saldo;
    private boolean flAtivo;

    double sacar(double valor){
        this.saldo += valor;
        return saldo;
    }
    double depositar(double valor){
        if(saldo >= valor){
            this.saldo += valor;
        }
        else {
            System.out.println("Saldo insuficiente");
        }
        return saldo;
    }
    void mostraDados(){
        System.out.println("ID" + idConta);
        System.out.println("Numero da conta" + nuConta);
        System.out.println("Matricula" + matricula);
        System.out.println("Saldo" + saldo);
        if(flAtivo){
            System.out.println("Ativo");
        } else {
            System.out.println("Inativo");
        }
    }
}
