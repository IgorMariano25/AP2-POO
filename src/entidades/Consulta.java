package entidades;

import java.util.Objects;

public class Consulta {
    private String data;
    private String hora;
    private String nomePaciente;
    private String cpfPaciente;
    private String nomeMedico;

    public Consulta(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
        this.nomePaciente = "";
        this.nomeMedico = "";
        this.data = "";
        this.hora = "";
    }

    public Consulta(String cpfPaciente, String nomePaciente, String nomeMedico, String data, String hora) {
        this.cpfPaciente = cpfPaciente;
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.data = data;
        this.hora = hora;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Consulta)) {
            return false;
        }
        Consulta consulta = (Consulta) obj;
        return consulta.cpfPaciente.equals(this.cpfPaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpfPaciente, nomePaciente, nomeMedico, data, hora);
    }

    @Override
    public String toString() {
        return cpfPaciente + " - " + nomePaciente + " - " + nomeMedico + " - " + data + " - " + hora;
    }
}
