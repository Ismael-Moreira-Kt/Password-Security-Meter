$(document).ready(function(){
    $("#enviar").click(function(){
        let nome = $("#nome").val();
        let senha = $("#senha").val();


        let dados = {
            nome: nome,
            senha: senha
        };

        $.ajax({
            url: "http://localhost:8080/",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(dados),
            success: function(response){
                console.log("Dados enviados com sucesso!");
                console.log(response);
                window.location.href = "/pages/listar.html";
            },
            error: function(error){
                console.error("Erro ao enviar os dados.");
                console.error(error);
            }
        });
    });
});