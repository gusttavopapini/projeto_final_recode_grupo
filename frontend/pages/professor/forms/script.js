const apiUrl = "http://localhost:8080/professors";
const apiUrlDepartament = "http://localhost:8080/departments"

const form = document.querySelector("form");

let id = 0;
let departaments = false;

const verifyId = () => {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    id = urlParams.get('id');

    if(id) {
        const title = document.getElementById("title-form");
        title.innerText = "Edit Professor";
        getData();
    }
}

const getData = async () => {
    const response = await fetch(apiUrl + `/${id}`);
    if(response.ok) {
        const data = await response.json();
        document.getElementById("name").value = data.name;
        document.getElementById("cpf").value = data.cpf;
        document.getElementById("department").value = data.departament.name;
    }
};

const loadSelect = async () => {
    const department = document.getElementById("department");
    const responseDepartment = await fetch(apiUrlDepartament);
    if (responseDepartment.ok) {
      const data = await responseDepartment.json();
      for (let i = 0; i < data.length; i++) {
        department.innerHTML += `
        <option value="${data[i].id}">${data[i].name}</option>
        `;
      }
    }    
};

verifyId();
loadSelect();
  
const save = (e) => {
    e.preventDefault();
  
    const name = document.getElementById("name").value.trim();
    const cpf = document.getElementById("cpf").value.trim();
    const departamentId = parseInt(document.getElementById("department").value.trim());
  
    if (!name || !cpf || !departamentId) {
      alert("All inputs is necessary!");
      return;
    }
  
    const method = id ? "PUT" : "POST";
    let url = apiUrl;
    if (id) {
      url = apiUrl + `/${id}`;
    }
  
    const objRequest = {
      name: name,
      cpf: cpf,
      departament: {
        id: departamentId
      }
    };  
  
    makeRequest(objRequest, method, url);
  } 

form.addEventListener("submit", save);

async function makeRequest(data, method, url) {
    const res = await fetch(url,
        {
            method: method,
            headers: {
                'Accept': 'application/json',
                'Content-Type':'application/json'
            },
            body: JSON.stringify(data)
        });

    if(!res.ok) {
        alert(`${res.status} - ${res.statusText}`);
        return;
    }

    const jsonResult = await res.json();
    if(JSON.stringify(jsonResult).includes("message")) {
        alert(jsonResult.message);
    }else {
        location.href = '../';
    }
}

document.getElementById("cancel").addEventListener("click", () => {
    location.href = '../';
})