

document.getElementById("traducirbtn").addEventListener("click",traducir,false);
const encodedParams = new URLSearchParams();
encodedParams.append("q", document.getElementById("textoOriginal").value);
encodedParams.append("target", document.getElementById("traducido").value);
encodedParams.append("source", document.getElementById("original").value);
const options = {
    method: 'POST',
    headers: {
        'content-type': 'application/x-www-form-urlencoded',
        'Accept-Encoding': 'application/gzip',
        'X-RapidAPI-Key': '1ac7eecb91mshea5302d9bb59239p16d827jsnab03720b37ec',
        'X-RapidAPI-Host': 'google-translate1.p.rapidapi.com'
    },
    body: encodedParams
};
function traducir(){
    console.log(document.getElementById("original").value);
    console.log(document.getElementById("textoOriginal").value)
    console.log(document.getElementById("traducido").value);
    fetch('https://google-translate1.p.rapidapi.com/language/translate/v2', options)
	.then(data => data.json())
	.then(data => {
        console.log(data)
/*         document.getElementById("TextoTraducido").innerHTML = data
 */    }) 

	
    
}