function arrayToTable(tableData) {
    var table = $('<table></table>');
    $(tableData).each(function (i, rowData) {
        var row = $('<tr></tr>');
        $(rowData).each(function (j, cellData) {
            row.append($('<td>'+cellData+'</td>'));
        });
        table.append(row);
    });
    return table;
}

function tablaEjemplo() {
	return '[{nombre:"Pepe",apellido:"Sanchez"},{nombre:"Juan",apellido:"Garcia"}]';
}

function dibujarTabla() {
	document.getElementById("tabla").innerHTML = arrayToTable(tablaEjemplo());
}