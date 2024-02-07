$(document).ready(function(){
    $.ajax({
        url: "http://localhost:8080/",
        type: "GET",
        dataType: "json",
        success: function(usuarios){
            for (const element of usuarios) {
                let usuario = element;

                $("#corpoTabelaUsuarios").append("<tr>" +
                    "<td>" + usuario.id + "</td>" +
                    "<td>" + usuario.nome + "</td>" +
                    "<td>" + usuario.score + "</td>" +
                    "</tr>");
            }
        },
        error: function(error){
            console.error("Erro ao obter a lista de usuários.");
            console.error(error);
        }
    });
});

$(document).ready(function () {
    $("#returnbtn").on("click", function () {
        window.location.href = "../index.html";
    });
});