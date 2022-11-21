package gestor;
import java.io.IOException;

import persistencia.AgendaDB;
import persistencia.PacienteDB;
import persistencia.ConsultaDB;
import persistencia.MedicoDB;
import util.LeitoraDados;

public class Gestor {
    LeitoraDados leitoraDados;
    PacienteDB pacienteDB;
    MedicoDB medicoDB;
    AgendaDB agendaDB;
    ConsultaDB consultaDB;
    GestorPaciente gestorPaciente;
    GestorMedico gestorMedico;
    GestorConsulta gestorConsulta;
    GestorAgenda gestorAgenda;

    public Gestor() throws IOException {
        //caminho pra salvar a lista de arquivos
        this.leitoraDados = new LeitoraDados();
        this.pacienteDB = new PacienteDB("pacientes.txt");
        this.gestorPaciente = new GestorPaciente(this.pacienteDB);
        this.medicoDB = new MedicoDB("medicos.txt");
        this.gestorMedico = new GestorMedico(this.medicoDB);
        this.agendaDB = new AgendaDB("agenda.txt");
        this.gestorAgenda = new GestorAgenda(this.agendaDB);
        this.consultaDB = new ConsultaDB("consultas.txt");
        this.gestorConsulta = new GestorConsulta(this.consultaDB);
    }

    public void exibeOpcoes() {
        System.out.println("Selecione um número, ou aperte qualquer outra tecla para encerrar o programa: ");
        System.out.println("1 - menu paciente");
        System.out.println("2 - menu médicos");
        System.out.println("3 - menu consultas");
        System.out.println("4 - menu agenda");
    }

    //método pra processar as opções
    public String processaOpcoes() throws IOException {
        String opcao = this.leitoraDados.lerTexto();
        String opcaoMenu = "0";

        switch (opcao) {
            case "1": //cliente
            while (!opcaoMenu.equals("")){
                gestorPaciente.exibeOpcoes();
                opcaoMenu = gestorPaciente.processaOpcoes();
                    }

            break;

            case "2": //médicos
            while (!opcaoMenu.equals("")){
                gestorMedico.exibeOpcoes();
                opcaoMenu = gestorMedico.processaOpcoes();
                    }

            case "3": //consultas
            while (!opcaoMenu.equals("")){
                gestorConsulta.exibeOpcoes();
                opcaoMenu = gestorConsulta.processaOpcoes();
                    }

            case "4": //agendas
            while (!opcaoMenu.equals("")){
                gestorAgenda.exibeOpcoes();
                opcaoMenu = gestorAgenda.processaOpcoes();
                    }

            default:
                System.out.println("Volte sempre!");
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
