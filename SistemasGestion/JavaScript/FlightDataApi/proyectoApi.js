document.getElementById("buscarBtn").addEventListener("click", buscarVuelo, false);
const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': '1ac7eecb91mshea5302d9bb59239p16d827jsnab03720b37ec',
		'X-RapidAPI-Host': 'aerodatabox.p.rapidapi.com'
	}
};
let data = ""
function buscarVuelo(){
	document.getElementById("tablaVuelo").style.visibility = "visible"
	let codigo = document.getElementById("cod").value;
	fetch('https://aerodatabox.p.rapidapi.com/flights/number/'+codigo+'?withAircraftImage=true&withLocation=true', options)
	.then(response => response.json())
	.then(data => {
		console.log(data[0].aircraft.model)
		document.getElementById("aerolinea").innerHTML = data[0].airline.name
		document.getElementById("numero").innerHTML = data[0].number
		document.getElementById("salida").innerHTML = data[0].departure.airport.municipalityName
		document.getElementById("llegada").innerHTML = data[0].arrival.airport.municipalityName
		document.getElementById("horaSalida").innerHTML = data[0].departure.scheduledTimeLocal
		document.getElementById("horaLlegada").innerHTML = data[0].arrival.scheduledTimeLocal
		document.getElementById("terminal").innerHTML = data[0].departure.terminal
		document.getElementById("puerta").innerHTML = data[0].departure.gate
		document.getElementById("estado").innerHTML = data[0].status
		if (document.getElementById("chckImage").checked){
			document.getElementById("imagen").setAttribute("src", data[0].aircraft.image.url)
			document.getElementById("imagen").style.visibility = "visible"
		}else{
			document.getElementById("imagen").style.visibility = "hidden"
		}
		if (document.getElementById("chckFlightData").checked) {
			document.getElementById("tablaDatosTecnicos").style.visibility = "visible"
			document.getElementById("tablaTelemetria").style.visibility = "visible"
			document.getElementById("modelo").innerHTML = data[0].aircraft.model
			document.getElementById("matricula").innerHTML = data[0].aircraft.reg
			document.getElementById("serie").innerHTML = data[0].aircraft.modeS
			if(data[0].isCargo == true){
				document.getElementById("tipo").innerHTML = "Carga"
			}else{
				document.getElementById("tipo").innerHTML = "Comercial"
			}
			document.getElementById("altitud").innerHTML = data[0].greatCircleDistance.feet 
			document.getElementById("velocidad").innerHTML = data[0].greatCircleDistance.nm * 10
			document.getElementById("latitud").innerHTML = data[0].departure.airport.location.lat
			document.getElementById("longitud").innerHTML = data[0].departure.airport.location.lon
		}else{
			document.getElementById("tablaDatosTecnicos").style.visibility = "hidden"
			document.getElementById("tablaTelemetria").style.visibility = "hidden"
		}
	})
}
	