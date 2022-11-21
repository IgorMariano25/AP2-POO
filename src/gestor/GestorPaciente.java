package gestor;
import java.io.IOException;

import persistencia.PacienteDB;
import util.LeitoraDados;

public class GestorPaciente {
    LeitoraDados leitoraDados;
    PacienteDB db;

    public GestorPaciente(PacienteDB db) throws IOException {
        //caminho pra salvar a lista de arquivos
        this.leitoraDados = new LeitoraDados();
        this.db = db;
    }

    public void exibeOpcoes() {
        System.out.println("Selecione um número, ou aperte qualquer outra tecla para voltar ao menu anterior: ");
        System.out.println("1 - Cadastrar um paciente");
        System.out.println("2 - Atualizar um paciente");
        System.out.println("3 - Remover um paciente");
        System.out.println("4 - Pesquisar um paciente pelo CPF");
        System.out.println("5 - Exibir todos os pacientes");
    }

    //método pra processar as opções
    public String processaOpcoes() throws IOException {
        String opcao = this.leitoraDados.lerTexto();
        String cpf;

        switch (opcao) {
            case "1": //adicionar cliente
                this.db.adicionar(leitoraDados.lerNovoCliente()); //pega as strings nome e cpf e adiciona ao db
            break;

            case "2": //alterar cliente
                System.out.println("Digite o cpf do paciente a ser alterado: ");
                cpf = leitoraDados.lerTexto();
                if (this.db.consultar(cpf) != null) {
                    this.db.alterar(leitoraDados.lerClienteAlteracao(cpf));
                } else {
                    System.out.println("O CPF inserido não foi localizado!");
                }
            break;
            
            case "3": //excluindo cliente
                System.out.println("Digite o cpf do paciente a ser excluído: ");
                cpf = leitoraDados.lerTexto();
                if (this.db.consultar(cpf) != null) {
                    this.db.excluir(cpf);
                    System.out.println("Paciente excluído com sucesso!");
                } else {
                    System.out.println("O CPF inserido não foi localizado!");
                }
            break;

            case "4": //consulta cliente
                System.out.println("Digite o cpf do paciente a ser pesquisado: ");
                cpf = leitoraDados.lerTexto();
                if (this.db.consultar(cpf) != null) {
                    System.out.println(this.db.consultar(cpf));
                } else {
                    System.out.println("O CPF inserido não foi localizado!");
                }
            break;

            case "5":
            System.out.println(this.db); //exibe atributo
            break;

            default:
                this.db.exportar();
                opcao = "";
            break;
        }

        return opcao;
    }

    // a classe gestor ficou um pouco grande
    //trabalhar com menus e sub menus para o código não ficar tão grande
    //GestorConsulta, GestorCliente, GestorConsultorio
    //para cada classe ser mais enxuta, e para que não seja uma classe enorme com várias opções
    //não fazer um único processo com 500 opções

}
