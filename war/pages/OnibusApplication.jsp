<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Ônibus</title>
		<link rel="stylesheet" type="text/css" href="../css/main.css"/>
	</head>
<body>
	<div class="main">

		<div class="headline">Novo Ônibus</div>

		<form action="/cademeubusao/onibus" method="post" accept-charset="utf-8">
			<table>
				<tr>
					<td><label for="placa">Placa</label></td>
					<td><input type="text" name="placa" id="placa" size="8" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Salvar" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
</body>
</html>