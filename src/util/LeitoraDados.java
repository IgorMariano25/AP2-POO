package util;

import java.util.Scanner;

public class LeitoraDados {
    private Scanner scanner;

    public LeitoraDados() {
        this.scanner = new Scanner(System.in);
        //fecha o scanner quando se estiver destruindo a instancia dessa classe
        //limpeza do objeto pelo garbage collector
    }

    public String lerTexto() {
        return this.scanner.nextLine();
    }

    public String[] lerNovoCliente () {
        System.out.println("Informe o cpf: ");
        String cpf = this.lerTexto();

        System.out.println("Informe o nome: ");
        String nome  = this.lerTexto();

        return new String[] {cpf, nome};
    }

    public String[] lerClienteAlteracao(String cpf) {
        System.out.println("Informe o nome: ");
        String nome  = this.lerTexto();

        return new String[] {cpf, nome};
    }

    @Override
    protected void finalize () {
        this.scanner.close();
        //fecha scanner pra não deixar a leitura de dados aberta
    }

    //médico

    public String[] lerNovoMedico () {
        System.out.println("Informe o cpf: ");
        String cpf = this.lerTexto();

        System.out.println("Informe o nome: ");
        String nome  = this.lerTexto();

        System.out.println("Informe o crm: ");
        String crm  = this.lerTexto();

        System.out.println("Informe a especialidade: ");
        String especialidade  = this.lerTexto();

        System.out.println("Informe o email: ");
        String email  = this.lerTexto();

        return new String[] {cpf, nome, crm, especialidade, email};
    }

    public String[] lerMedicoAlteracao(String cpf) {
        System.out.println("Informe o nome: ");
        String nome  = this.lerTexto();
        String crm = this.lerTexto();

        return new String[] {cpf, nome, crm};
    }

    //consulta

    public String[] lerNovaConsulta () {
        System.out.println("Informe o cpf do paciente: ");
        String cpfPaciente = this.lerTexto();

        System.out.println("Informe o nome do paciente: ");
        String nomePaciente  = this.lerTexto();

        System.out.println("Informe o nome do médico que fará o atendimento: ");
        String nomeMedico = this.lerTexto();

        System.out.println("Informe o dia da consulta: ");
        String data  = this.lerTexto();

        System.out.println("Informe a hora da consulta: ");
        String hora  = this.lerTexto();

        return new String[] {cpfPaciente, nomePaciente, nomeMedico, data, hora};
    }

    public String[] lerConsultaAlteracao(String cep){
        System.out.println("Informe o cpf do paciente: ");
        String cpfPaciente = this.lerTexto();

        System.out.println("Informe o nome do paciente: ");
        String nomePaciente  = this.lerTexto();

        System.out.println("Informe o nome do médico que fará o atendimento: ");
        String nomeMedico = this.lerTexto();

        System.out.println("Informe o dia da consulta: ");
        String data  = this.lerTexto();

        System.out.println("Informe a hora da consulta: ");
        String hora  = this.lerTexto();

        return new String[] {cpfPaciente, nomePaciente, nomeMedico, data, hora};
    }

    //agenda

    public String[] lerNovaAgenda () {
        System.out.println("Informe o dia da semana: "); 
        String diaSemana = this.lerTexto();

        System.out.println("Informe a hora de início: ");
        String horaInicio  = this.lerTexto();

        System.out.println("Informe a hora de encerramento: ");
        String horaFim  = this.lerTexto();

        System.out.println("Informe intervalo entre consultas: ");
        String intervaloConsulta  = this.lerTexto();

        System.out.println("Informe o nome do médico: ");
        String nomeMedico  = this.lerTexto();

        return new String[] {diaSemana, horaInicio, horaFim, intervaloConsulta, nomeMedico};
    }

    public String[] lerAgendaAlteracao(String cep){
        System.out.println("Informe o dia da semana: "); 
        String diaSemana = this.lerTexto();

        System.out.println("Informe a hora de início: ");
        String horaInicio  = this.lerTexto();

        System.out.println("Informe a hora de encerramento: ");
        String horaFim  = this.lerTexto();

        System.out.println("Informe intervalo entre consultas: ");
        String intervaloConsulta  = this.lerTexto();

        System.out.println("Informe o nome do médico: ");
        String nomeMedico  = this.lerTexto();

        return new String[] {diaSemana, horaInicio, horaFim, intervaloConsulta, nomeMedico};
    }
}
