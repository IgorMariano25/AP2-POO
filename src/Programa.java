import gestor.Gestor;
//import gestor.GestorCliente;

public class Programa {
    public static void main(String[] args) throws Exception {
        //nossa classe programa só tem um gestor, desacoplou o tudo que tinha antes
        Gestor gestor = new Gestor();
        String opcao = "0";

        while (!opcao.equals("")){
            gestor.exibeOpcoes();
            opcao = gestor.processaOpcoes();
        }
    }
}
