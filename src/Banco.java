import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.nome = nome;
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public List<Cliente> getClientes(){
        return clientes;
    }

    public Cliente getCliente(String nomeDoCliente) {
        return this.clientes.stream()
                .filter(cliente -> cliente.getNome().equals(nomeDoCliente))
                .findFirst()
                .orElse(null);
    }

    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void imprimirNomeDeClientes(){
        clientes.forEach(System.out::println);
    }
}
