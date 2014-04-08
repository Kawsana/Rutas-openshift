function showRouteDiv()
{
	$( "#frmNewRoute\\:pnlNewRoute" ).show();
	$( "#frmNewRoute\\:btnCreateRoute" ).hide();
}

function showRouteListDiv()
{
	$( "#frmNewRoute\\:pnlNewRoute" ).hide();
	$( "#frmNewRoute\\:btnCreateRoute" ).show();
}

function validateNumbers(evt)
{
	keynum = (document.all) ? evt.keyCode : evt.which;
	if ((keynum > 47 && keynum < 58) || keynum == 8 || keynum == 13) {
		return true;
	} else {
		return false;
	}
}

function showClientDiv()
{
	$( "#frmClient\\:pnlCreateClient" ).show();
	$( "#frmClient\\:pnlClientList" ).hide();
}

function showClientListDiv()
{
	$( "#frmClient\\:pnlCreateClient" ).hide();
	$( "#frmClient\\:pnlClientList" ).show();
}

function validateLetters(evt) {
	keynum = (document.all) ? evt.keyCode : evt.which;
	if (!(keynum > 47 && keynum < 58) || keynum == 8 || keynum == 13 || keynum == 32) {
		return true;
	} else {
		return false;
	}
}