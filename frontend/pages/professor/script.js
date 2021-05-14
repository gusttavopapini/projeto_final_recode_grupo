const table = document.getElementById("professor-table");

const apiUrl = "http://localhost:8080/professors"

const getData = async () => {
    const response = await fetch(apiUrl);
    if(response.ok) {
        const data = await response.json();
        loadTable(data);
    }
};

const loadTable = (data) => {
    table.innerHTML = "";

    for(let i = 0; i < data.length; i++) {
        table.innerHTML += `
        <tr>
            <th>${data[i].id}</th>
            <td>${data[i].name}</td>
            <td>${data[i].cpf}</td>
            <td>${data[i].department.name}</td>
            <td class="button"><button>Edit</button><button>Delete</button></td>
        </tr>
        `;
    }
}

getData();