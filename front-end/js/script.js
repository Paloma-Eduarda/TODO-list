class Tarefa{
    constructor(titulo,descricao, categoria, data, status, prioridade){
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.data = data;
        this.status = status;
        this.prioridade = prioridade;
    }
}

let tarefas = [];
const formulario = document.getElementById("form");
const tarefaTODO = document.getElementById("tarefasAFazer");
const tarefaDOING = document.getElementById("tarefasFazendo");
const tarefaDONE = document.getElementById("tarefasFeita");
const modal = document.getElementById("titulo-modal");

document.getElementById("enviar").onclick = function (){

    const tituloTarefa = document.getElementById("titulo").value;
    const descricaoTarefa = document.getElementById("descricao").value
    const categoriaSelec = document.getElementById("categoria").value;
    const data_selecionada = document.getElementById("data").value;
    const statusSelec = document.getElementById("status").value;
    const prioridadeSelec = document.getElementById("prioridade").value;

    if(tituloTarefa.trim() == "" || descricaoTarefa.trim() == "" || data_selecionada.trim() == ""){
        alert("Preencha todos os campos")
    }else{
        const nova_tarefa = new Tarefa(tituloTarefa, descricaoTarefa, categoriaSelec, data_selecionada, statusSelec, prioridadeSelec)
        tarefas.push(nova_tarefa);
        renderizarTarefa();
        formulario.reset();
    } 
}
function renderizarTarefa() {
    tarefaTODO.innerHTML = '';
    tarefaDONE.innerHTML = '';
    tarefaDOING.innerHTML = '';
    modal.innerHTML = 'Adicione um tarefa';

    tarefas.forEach((tarefa, index) =>{

        const tarefaElement = document.createElement("div");
        tarefaElement.innerHTML = `
        <p data-toggle="modal" data-target="#modalAlterarExcluir">
            <strong>${tarefa.titulo}</strong><br>
            ${tarefa.descricao}<br>
            Categoria: ${tarefa.categoria}<br>
            Data: ${tarefa.data}<br>
            Prioridade: ${tarefa.prioridade}<br><br>
            <button onclick="editarTarefa(${index})" class="btn btn-success" data-toggle="modal" data-target="#myModal">Editar</button>
            <button onclick="excluirTarefa(${index})" class="btn btn-danger">Excluir</button>
        </p>    
        `;

        if (tarefa.status === "TODO") {
            document.getElementById("tarefasAFazer").appendChild(tarefaElement);
        } else if (tarefa.status === "DOING") {
            document.getElementById("tarefasFazendo").appendChild(tarefaElement);
        } else if (tarefa.status === "DONE") {
            document.getElementById("tarefasFeita").appendChild(tarefaElement);
        }
    })
 
    
}
function excluirTarefa(index){

    const confirmacao = confirm("Tem certeza que deseja exluir a tarefa?");
    if(confirmacao){
        tarefas.splice(index, 1);
        renderizarTarefa();
    }
    
}
function editarTarefa(index){
    modal.innerHTML = "Editar Tarefa";


    document.getElementById("titulo").value = tarefas[index].titulo;
    document.getElementById("descricao").value = tarefas[index].descricao;
    document.getElementById("categoria").value = tarefas[index].categoria;
    document.getElementById("data").value = tarefas[index].data;
    document.getElementById("prioridade").value = tarefas[index].prioridade;
    document.getElementById("status").value = tarefas[index].status;

    
    //Melhorar
    tarefas.splice(index, 1);
    renderizarTarefa();

}




// function filtrarCategoria(){
//     let filtro = "trabalho"; // filtro como "Trabalho"

   
   
// }
// function filtrarPrioridade(){
//     let filtro = "Low"; // filtro como "Low"

//     for (var i = 0; i < tarefas.length; i++) {
//         if (tarefas[i].prioridade === filtro) {
//             console.log(tarefas[i]); // Exibe as tarefas que pertencem a Low
//         }
//     }
   
//}

