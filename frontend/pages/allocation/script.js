const table = document.getElementById("allocation-table");

const apiUrl = "http://localhost:8080/allocations"

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
            <td>${data[i].professor.name}</td>
            <td>${data[i].course.name}</td>
            <td>${data[i].days}</td>
            <td>${data[i].start_hour} - ${data[i].end_hour}</td>
            <td class="button"><button>Edit</button><button>Delete</button></td>
        </tr>
        `;
    }
}

getData();