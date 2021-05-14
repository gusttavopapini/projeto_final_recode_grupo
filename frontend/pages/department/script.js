const table = document.getElementById("department-table");

const apiUrl = "http://localhost:8080/departments"

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
            <td>
                <button class="btn btn-warning" onclick={goToEdit(${data[i].id})}>Edit</button>
                <button class="btn btn-danger" onclick={deleteById(${data[i].id})}>Delete</button>
            </td>
        </tr>
        `;
    }
}

const deleteById = async (id) => {
    if(!confirm("Are you sure you want to delete this department?")) {
        return;
    }

    const response = await fetch(apiUrl + `/${id}`, {
        method: "DELETE"
    });
    if(!response.ok) {
        alert(`${response.status} - ${response.statusText}`);
    }else {
        getData();
    }
}

const goToEdit = (id) => {
    location.href += '/forms/index.html?id=' + id;
}

getData();

