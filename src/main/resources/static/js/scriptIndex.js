
async function onclickSearch (){
    let query = document.getElementById('txtSearch').value;
    location.href = './results.html?query='+query;
    search(query);
 }
