package heranca.concessionaria;
/*
Um sistema de concessionária precisa cadastrar veículos. Existem carros e motos, mas ambos compartilham algumas informações em comum (marca e ano).

O que deve ser feito:
Crie a classe base Veiculo com atributos:
marca (String)
ano (int).

Crie classes filhas:
Carro → possui atributo adicional portas (int).
Moto → possui atributo adicional cilindradas (int).

Crie métodos:
exibirInformacoes() em cada classe, exibindo os dados específicos.

No programa principal:
Crie um carro e uma moto, preenchendo os atributos.
Exiba as informações de ambos.
*/
public class Veiculo {
    protected String marca;
    protected int ano;
    
    
    public String getMarca(){
        return marca;
    }
    public int getAno(){
        return ano;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setAno (int ano){
        this.ano = ano;
    }

    void exibirInformacoes(){
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
    }
}
