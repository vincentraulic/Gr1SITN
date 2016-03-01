$(document).ready(function(){
	var j=1;

	function addRow(tableID) {
		var table = document.getElementById(tableID);

		$('#p'+j).html("<td><input type='checkbox' name='chk'/></td><td><h:inputText styleClass='form-control #{component.valid ? '' : 'has-error'}' value='#{projectController.project.phases.name}' required='true' name='name0' placeholder='Nom'> <f:validateLength minimum='2' maximum='50' /> </h:inputText></td> <td><h:inputText styleClass='form-control #{component.valid ? '' : 'has-error'}' value='#{projectController.project.phases.cost}' required='true' name='cost0' placeholder='Coût'> <f:validateRegex pattern='[0-9]+' /> </h:inputText></td> <td><p:inputMask styleClass='form-control #{component.valid ? '' : 'has-error'}' value='#{projectController.project.phases.dateStart}' mask='99/99/9999' required='true' name='dstart0' placeholder='dd/MM/aaaa'> <f:convertDateTime pattern='dd/MM/yyyy' /> </p:inputMask></td> <td><p:inputMask styleClass='form-control #{component.valid ? '' : 'has-error'}' value='#{projectController.project.phases.dateEnd}' mask='99/99/9999' required='true' name='dend0' placeholder='dd/MM/aaaa'> <f:convertDateTime pattern='dd/MM/yyyy' /> </p:inputMask></td>");

		table.append('<tr id="p'+(j+1)+'"></tr>');
		j++;
	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if(null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		}catch(e) {
			alert(e);
		}
	}
});