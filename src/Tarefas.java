import java.io.Serializable;
import java.time.LocalDate;

public class Tarefas implements Comparable<Tarefas> {
    private String nome;
    private String descricao;
    private Categoria Categoria;
    private LocalDate dataFinal;
    private int prioridade;
    private Status status;

    public enum Status{
        TODO, DOING, DONE
    }
    public enum Categoria{
        TRABALHO, ESTUDO, CASA
    }
    public Tarefas(String nome, String descricao, Categoria categoria, LocalDate dataFinal, int prioridade, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.Categoria = categoria;
        this.dataFinal = dataFinal;
        this.prioridade = prioridade;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Tarefas.Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Tarefas.Categoria categoria) {
        Categoria = categoria;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa: " +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", dataFinal=" + dataFinal +
                ", prioridade=" + prioridade +
                ", status='" + status + '\'';
    }

    @Override
    public int compareTo(Tarefas o) {
        if(this.prioridade<o.prioridade){
            return -1;
        }else if(this.prioridade>o.prioridade){
            return 1;
        }
        return 0;
    }
}
