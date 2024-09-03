import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciarTarefas {
    ArrayList <Tarefas> tarefas = new ArrayList<Tarefas>();;

    public void adicionarTarefa(String nome, String descricao, Tarefas.Categoria categoria, LocalDate dataFinal, int prioridade, Tarefas.Status status){

        Tarefas novaTarefa = new Tarefas(nome, descricao, categoria, dataFinal, prioridade, status);
        tarefas.add(novaTarefa);
        Collections.sort(tarefas);
    }
    public void excluirTarefa(int indice){
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Índice inválido. Nenhuma tarefa removida.");
        }
    }
    public void filtrarTarefaPorStatus(Tarefas.Status status){
       for(Tarefas tarefa:tarefas){
            if(tarefa.getStatus() == status){
                System.out.println(tarefa);
            }
       }
    }
    public void filtrarTarefaPorCategoria(Tarefas.Categoria categoria){
        for(Tarefas tarefa:tarefas){
            if(tarefa.getCategoria() == categoria){
                System.out.println(tarefa);
            }
        }
    }
    public void filtrarTarefaPorPrioridade(int prioridade){
        for(Tarefas tarefa:tarefas){
            if(tarefa.getPrioridade() == prioridade){
                System.out.println(tarefa);
            }
        }
    }
    public void listarTarefas(){
            if(tarefas.isEmpty()){
                System.out.println("Lista de tarefas vazia, adicione uma nova tarefa");
            }else{
                for(int i = 0; i < tarefas.size(); i++) {
                    System.out.println(i + 1 + "-" + tarefas.get(i));
                }
        }

    }
}
