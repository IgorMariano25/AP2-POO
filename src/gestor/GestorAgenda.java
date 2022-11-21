package gestor;

import java.io.IOException;
import persistencia.AgendaDB;
import util.LeitoraDados;

public class GestorAgenda {
    LeitoraDados leitoraDados;
    AgendaDB db;

    public GestorAgenda(AgendaDB agendaDB) throws IOException {
        this.leitoraDados = new LeitoraDados();
        this.db = agendaDB;
    }

    public void exibeOpcoes() {
        System.out.println("Selecione um número, ou aperte qualquer outra tecla para voltar ao menu anterior: ");
        System.out.println("1 - Adicionar item a agenda do dia");
        System.out.println("2 - Atualizar os dados de uma agenda em um dia especificoo");
        System.out.println("3 - Cancelar agenda por dia");
        System.out.println("4 - Pesquisar agenda por dia da semana"); 
        System.out.println("5 - Exibir todas as agendas");
    }

    public String processaOpcoes() throws IOException {
        String opcao = this.leitoraDados.lerTexto();
        String diaSemana; 

        switch (opcao) {
            case "1":
                this.db.adicionar(leitoraDados.lerNovaConsulta());
            break;

            case "2":
                System.out.println("Digite o dia da semana da agenda a ser atualizada: ");
                diaSemana = leitoraDados.lerTexto();
                if (this.db.consultar(diaSemana) != null) {
                    this.db.alterar(leitoraDados.lerConsultaAlteracao(diaSemana));
                } else {
                    System.out.println("Não há nada marcado nesse dia!");
                }
            break;
            
            case "3":
                System.out.println("Digite o dia da semana da agenda a ser cancelada: ");
                diaSemana = leitoraDados.lerTexto();
                if (this.db.consultar(diaSemana) != null) {
                    this.db.excluir(diaSemana);
                    System.out.println("Agenda cancelada com sucesso!");
                } else {
                    System.out.println("Não há nada marcado nesse dia!");
                }
            break;

            case "4":
                System.out.println("Digite o dia da semana da agenda a ser pesquisado: ");
                diaSemana = leitoraDados.lerTexto();
                if (this.db.consultar(diaSemana) != null) {
                    System.out.println(this.db.consultar(diaSemana));
                } else {
                    System.out.println("Não há nada marcado nesse dia!");
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
