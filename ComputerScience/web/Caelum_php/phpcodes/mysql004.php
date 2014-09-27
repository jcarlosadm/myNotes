<?
$dados = mysqli_query($conexao, "SELECT * FROM produtos
                        WHERE id = 4");
$produto = mysqli_fetch_array($dados);
?>
