package entidades;

import java.util.Objects;

public class Agenda {
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    private String intervaloConsulta;
    private String nomeMedico;

    public Agenda(String diaSemana) {
        this.diaSemana = diaSemana;
        this.horaInicio = "";
        this.horaFim = "";
        this.intervaloConsulta = "";
        this.nomeMedico = "";
    }

    public Agenda(String diaSemana, String horaInicio, String horaFim, String intervaloConsulta, String nomeMedico) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.intervaloConsulta = intervaloConsulta;
        this.nomeMedico = nomeMedico;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Agenda)) {
            return false;
        }
        Agenda agenda = (Agenda) obj;
        return agenda.diaSemana == this.diaSemana;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMedico, diaSemana, horaInicio, horaFim , intervaloConsulta);
    }

    @Override
    public String toString() {
        return nomeMedico + " - " + diaSemana + " - " + horaInicio + " - " + horaFim + " - " + intervaloConsulta;
    }
}
