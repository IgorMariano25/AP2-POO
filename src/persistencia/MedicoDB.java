package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Medico;
import util.Arquivo;

public class MedicoDB {
    private List<Medico> medicos = new ArrayList<>();
    private String caminho;
    
    public MedicoDB(String caminho) throws IOException {
        this.caminho = caminho;
        this.importar();
    }

    //adicionar
    public void adicionar(String[] dadosMedico) {
        Medico medico = new Medico(dadosMedico[0], dadosMedico[1], dadosMedico[2], dadosMedico[3], dadosMedico[4]);
        if (!this.medicos.contains(medico)) {
            this.medicos.add(medico);
        }
    }

    //alterar
    public void alterar(String[] dadosMedico) {
        Medico medico = new Medico(dadosMedico[0], dadosMedico[1], dadosMedico[2], dadosMedico[3], dadosMedico[4]);
        int posicao = this.medicos.indexOf(medico);
        if (posicao != -1) {
            this.medicos.set(posicao, (Medico) medicos);
        }
    }

    //excluir
    public void excluir(String cpf) {
        Medico medico = new Medico(cpf);
        if(this.medicos.contains(medico)){
            this.medicos.remove(medico);
        }
    }

    //consultar (pelo cpf)
    public Medico consultar(String cpf) {
        Medico medico = new Medico(cpf);
        int posicao = this.medicos.indexOf(medico);
        if (posicao != -1) {
            return this.medicos.get(posicao);
        }
        return null;
    }

    //listar
    public List<Medico> listar() {
        return Collections.unmodifiableList(this.medicos);
    }

    //importar 
    public void importar() throws IOException{
        List<String> linhas = Arquivo.ler(this.caminho);

        for (String linha : linhas) { 
            this.adicionar(linha.split(" - ")); 
        }
    }

    //exportar
    public void exportar() throws IOException{
        List<String> linhas = new ArrayList<>();

        for (Medico medico : this.medicos) {
            linhas.add(medico.toString());
        }

        Arquivo.escrever(this.caminho, linhas);
    }

    //toString
    @Override
    public String toString() {
        String msg = "";
        for (Medico medico : this.listar()){
            msg += medico + "\n";
        }
        return msg;
    }
}