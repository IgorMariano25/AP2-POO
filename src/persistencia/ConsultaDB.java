package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Consulta;
import util.Arquivo;

public class ConsultaDB {
    private List<Consulta> consultas = new ArrayList<>();
    private String caminho;
    
    public ConsultaDB(String caminho) throws IOException {
        this.caminho = caminho;
        this.importar();
    }

    public void adicionar(String[] dadosConsulta) {
        Consulta consulta = new Consulta(dadosConsulta[0], dadosConsulta[1], dadosConsulta[2], dadosConsulta[3], dadosConsulta[4]);
        if (!this.consultas.contains(consulta)) {
            this.consultas.add(consulta);
        }
    }

    public void alterar(String[] dadosConsulta) {
        Consulta Consulta = new Consulta(dadosConsulta[0], dadosConsulta[1], dadosConsulta[2], dadosConsulta[3], dadosConsulta[4]);
        int posicao = this.consultas.indexOf(Consulta);
        if (posicao != -1) {
            this.consultas.set(posicao, Consulta);
        }
    }

    public void excluir(String cpfPaciente) {
        Consulta Consulta = new Consulta(cpfPaciente);
        if(this.consultas.contains(Consulta)){
            this.consultas.remove(Consulta);
        }
    }

    public Consulta consultar(String cpfPaciente) {
        Consulta Consulta = new Consulta(cpfPaciente);
        int posicao = this.consultas.indexOf(Consulta);
        if (posicao != -1) {
            return this.consultas.get(posicao);
        }
        return null;
        //significa que não encontrou
    }


    public List<Consulta> listar() {
        return Collections.unmodifiableList(this.consultas);
    }
    
    public void importar() throws IOException{
        List<String> linhas = Arquivo.ler(this.caminho);

        for (String linha : linhas) { 
            this.adicionar(linha.split(" - "));
        }
    }

    public void exportar() throws IOException{
        List<String> linhas = new ArrayList<>();
        for (Consulta Consulta : this.consultas) {
            linhas.add(Consulta.toString());
        }
        Arquivo.escrever(this.caminho, linhas);
    }

    @Override
    public String toString() {
        String msg = "";
        for (Consulta Consulta : this.listar()){
            msg += Consulta + "\n";
        }
        return msg;
    }

}
