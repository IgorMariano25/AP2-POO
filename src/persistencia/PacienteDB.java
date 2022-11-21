package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Paciente;
import util.Arquivo;

public class PacienteDB {
    private List<Paciente> pacientes = new ArrayList<>();
    private String caminho;

    public PacienteDB(String caminho) throws IOException {
        this.caminho = caminho;
        this.importar(); // pra opder faezr a importação dos dados
    }

    // adicionar
    public void adicionar(String[] dadosPaciente) {
        // pra cada classe de entidade ter uma classe de DB, boa prática
        // colocar limite d 20 clientes aqui, mas vitor vai tirar a restrição da
        // quantidade de clientes
        Paciente paciente = new Paciente(dadosPaciente[0], dadosPaciente[1]);
        if (!this.pacientes.contains(paciente)) {
            this.pacientes.add(paciente);
        }
    }

    // alterar
    public void alterar(String[] dadospaciente) {
        Paciente paciente = new Paciente(dadospaciente[0], dadospaciente[1]);
        int posicao = this.pacientes.indexOf(paciente); // método indexOf retorna a posição do dado na estrutura de
                                                        // dados
        // se o cliente não estiver no banco de dados retorna -1
        // criando nova instancia
        if (posicao != -1) {
            this.pacientes.set(posicao, paciente);
        }
    }

    // excluir
    public void excluir(String cpf) {
        // cpf teria que ter um equals pois não pode ser igual
        Paciente paciente = new Paciente(cpf);
        if (this.pacientes.contains(paciente)) {
            this.pacientes.remove(paciente);
        }
    }

    // consultar (pelo cpf)
    public Paciente consultar(String cpf) {
        Paciente paciente = new Paciente(cpf);
        int posicao = this.pacientes.indexOf(paciente);
        if (posicao != -1) {
            return this.pacientes.get(posicao);
        }
        return null;
        // significa que não encontrou
    }

    // listar
    public List<Paciente> listar() {
        return Collections.unmodifiableList(this.pacientes);
        // exibe as informações
    }

    // importar (mesma coisa pra qualquer classe de DB que existir, poderia ser
    // método da superclasse se existisse)
    public void importar() throws IOException {
        // populando com dados do arquivo
        List<String> linhas = Arquivo.ler(this.caminho);

        for (String linha : linhas) {
            // quebra minha linha com o -
            this.adicionar(linha.split(" - ")); // faz várias adições sucessivas
        }
    }

    // exportar (mesma coisa pra qualquer classe de DB que existir, poderia ser
    // método da superclasse se existisse)
    public void exportar() throws IOException {
        List<String> linhas = new ArrayList<>();

        for (Paciente paciente : this.pacientes) {
            linhas.add(paciente.toString());
        }

        Arquivo.escrever(this.caminho, linhas); // método estático, por isso se chama assim
    }

    // toString
    @Override
    public String toString() {
        String msg = "";
        for (Paciente paciente : this.listar()) {
            msg += paciente + "\n";
        }
        return msg;
    }
}