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