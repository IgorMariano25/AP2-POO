package entidades;

import java.util.Objects;

public class Medico {
    private String cpf;
    private String nome;
    private String crm;
    private String especialidade;
    private String email;

    public Medico(String cpf) {
        this.cpf = cpf;
        this.nome = "";
        this.crm = "";
        this.especialidade = "";
        this.email = "";
    }

    public Medico(String cpf, String nome, String crm, String especialidade, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Medico)) {
            return false;
        }
        Medico medico = (Medico) obj;
        return medico.cpf.equals(this.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, crm, especialidade, email);
    }

    @Override
    public String toString() {
        return cpf + " - " + nome + " - " + crm + " - " + especialidade + " - " + email;
    }
}
