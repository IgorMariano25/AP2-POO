package entidades;

import java.util.Objects;

public class Paciente {
    private String cpf;
    private String nome;

    public Paciente(String cpf) {
        this.cpf = cpf;
        this.nome = "";
    }

    public Paciente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Paciente)) {
            return false;
        }
        Paciente Paciente = (Paciente) obj;
        return Paciente.cpf.equals(this.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome);
    }

    @Override
    public String toString() {
        return cpf + " - " + nome;
    }
}
