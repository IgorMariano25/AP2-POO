package gestor;

import java.io.IOException;
import persistencia.MedicoDB;
import util.LeitoraDados;

public class GestorMedico {
    LeitoraDados leitoraDados;
    MedicoDB db;

    public GestorMedico(MedicoDB db) throws IOException {
        //caminho pra salvar a lista de arquivos
        this.leitoraDados = new LeitoraDados();
        this.db = db;
    }

    public void exibeOpcoes() {
        System.out.println("Selecione um número, ou aperte qualquer outra tecla para voltar ao menu anterior: ");
        System.out.println("1 - Cadastrar um médico");
        System.out.println("2 - Atualizar um médico");
        System.out.println("3 - Remover um médico");
        System.out.println("4 - Pesquisar um médico pelo CPF");
        System.out.println("5 - Exibir todos os médicos");
    }

    //método pra processar as opções
    public String processaOpcoes() throws IOException {
        String opcao = this.leitoraDados.lerTexto();
        String cpf;

        switch (opcao) {
            case "1": //adicionar médico
                this.db.adicionar(leitoraDados.lerNovoMedico());
            break;

            case "2": //alterar médico
                System.out.println("Digite o cpf do médico a ser alterado: ");
                cpf = leitoraDados.lerTexto();
                if (this.db.consultar(cpf) != null) {
                    this.db.alterar(leitoraDados.lerMedicoAlteracao(cpf));
                } else {
                    System.out.println("O CPF inserido não foi localizado!");
                }
            break;
            
            case "3": //excluindo médico
                System.out.println("Digite o cpf do médico a ser excluído: ");
                cpf = leitoraDados.lerTexto();
                if (this.db.consultar(cpf) != null) {
                    this.db.excluir(cpf);
                    System.out.println("Médico excluído com sucesso!");
                } else {
                    System.out.println("O CPF inserido não foi localizado!");
                }
            break;

            case "4": //consulta médico
                System.out.println("Digite o cpf do médico a ser pesquisado: ");
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

}
