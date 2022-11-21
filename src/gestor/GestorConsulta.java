package gestor;

import java.io.IOException;
import persistencia.ConsultaDB;
import util.LeitoraDados;

public class GestorConsulta {
    LeitoraDados leitoraDados;
    ConsultaDB db;

    public GestorConsulta(ConsultaDB db) throws IOException {
        this.leitoraDados = new LeitoraDados();
        this.db = db;
    }

    public void exibeOpcoes() {
        System.out.println("Selecione um número, ou aperte qualquer outra tecla para voltar ao menu anterior: ");
        System.out.println("1 - Agendar consulta");
        System.out.println("2 - Alterar uma consulta");
        System.out.println("3 - Cancelar consulta");
        System.out.println("4 - Pesquisar uma consulta pelo cpf do paciente");
        System.out.println("5 - Exibir todas as consultas");
    }

    public String processaOpcoes() throws IOException {
        String opcao = this.leitoraDados.lerTexto();
        String cpfPaciente;

        switch (opcao) {
            case "1":
                this.db.adicionar(leitoraDados.lerNovaConsulta());
            break;

            case "2":
                System.out.println("Digite o cpf do paciente cuja consulta será ser alterada: ");
                cpfPaciente = leitoraDados.lerTexto();
                if (this.db.consultar(cpfPaciente) != null) {
                    this.db.alterar(leitoraDados.lerConsultaAlteracao(cpfPaciente));
                } else {
                    System.out.println("O cpf inserido não foi localizado!");
                }
            break;
            
            case "3":
                System.out.println("Digite o cpf do paciente cuja consulta será ser cancelada: ");
                cpfPaciente = leitoraDados.lerTexto();
                if (this.db.consultar(cpfPaciente) != null) {
                    this.db.excluir(cpfPaciente);
                    System.out.println("Consulta cancelada com sucesso!");
                } else {
                    System.out.println("O cpf inserido não foi localizado!");
                }
            break;

            case "4":
                System.out.println("Digite o cpf do paciente da consulta a ser pesquisada: ");
                cpfPaciente = leitoraDados.lerTexto();
                if (this.db.consultar(cpfPaciente) != null) {
                    System.out.println(this.db.consultar(cpfPaciente));
                } else {
                    System.out.println("O cpf inserido não foi localizado!");
                }
            break;

            case "5":
            System.out.println(this.db);
            break;

            default:
                this.db.exportar();
                opcao = "";
            break;
        }

        return opcao;
    }
    
}
