const table = document.getElementById("course-table");

const apiUrl = "https://projeto-recodeiv.herokuapp.com/courses"

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
                <button id="actionsButtons" onclick={goToEdit(${data[i].id})}> 
                    <img id="button" src="../../images/edit icon.png" width="25px" heigth="25px">
                </button>
                <button id="actionsButtons" onclick={deleteById(${data[i].id})}> 
                    <img id="button" src="../../images/delete icon.png" width="20px" heigth="20px">
                </button>
            </td>
        </tr>
        `;
    }
}

const deleteById = async (id) => {
    if(!confirm("Are you sure you want to delete this course?")) {
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
    location.href += 'forms/index.html?id=' + id;
}

getData();