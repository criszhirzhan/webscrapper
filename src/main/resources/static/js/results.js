const URL_API = 'http://localhost:8080/api/';


 async function search(query){

    let url = URL_API + "search?query="+query;

    let result = await fetch(url);

    let json = await result.json();
    let jsonResult = json;
    let html='';

    for (let json of jsonResult){

        let description = json.description.substring(0.150) + "..."

        html += 
        `
        <div class="result">
        <div class="title">
            <img class = "picture" src="${json.picture}">
            <a href="${json.url}" target = "_blank">${json.title}</a>
            
        </div>
        <div class="description">
            <p>${description}</p>
        </div> 
        </div>
        
        `
    }

    document.getElementById('results').outerHTML = html;
 }

async function onclickSearch (){
    let query = document.getElementById('txtSearch').value;
    search(query);
 }

function load(){
    let query = window.location.href.split('?query=')[1];
    document.getElementById('txtSearch').value = query
    search(query);
}

 load();