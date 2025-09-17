package heranca.DrawIo;

public class Usuario{
    private Integer idUsuario;
    private String login;
    private String senha;
    private boolean flTipoUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String login, String senha, boolean flTipoUsuario) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.flTipoUsuario = flTipoUsuario;
    }

    void mostrarDados(){
        System.out.println("ID: " + idUsuario);
        System.out.println("Login: " + login);
        System.out.println("Senha: " + senha);
        if (flTipoUsuario) {
            System.out.println("Pessoa Física");
        } else {
            System.out.println("Pessoa Juridica");
        }
    }
}
