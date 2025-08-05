function fetchAllEmployees() {
    // Construir la solicitud SOAP
    const soapRequest = `
      <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.api.service.soap.mx.com">
         <soapenv:Header/>
         <soapenv:Body>
            <soap:getAllEmployeesRequest/>
         </soapenv:Body>
      </soapenv:Envelope>
    `;
  
    // Crear una nueva solicitud XMLHttpRequest
    const xmlhttp = new XMLHttpRequest();
  
    // Configurar la solicitud
    xmlhttp.open("POST", "http://localhost:8080/employee/api", true);
    xmlhttp.setRequestHeader("Content-Type", "text/xml");
  
    // Manejar la respuesta
    xmlhttp.onreadystatechange = function () {
      if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
        // Procesar la respuesta SOAP
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(xmlhttp.responseText, "text/xml");
  
        const employeeList = xmlDoc.getElementsByTagName("ns2:employeeInfo");
  
        // Obtener el elemento donde mostraremos los empleados
        const employeeTableBody = document.getElementById("employeeTableBody");
  
        // Limpiar el contenido existente
        employeeTableBody.innerHTML = "";
  
        // Iterar sobre cada empleado en la lista y añadir una fila en la tabla
        for (let i = 0; i < employeeList.length; i++) {
          const employee = employeeList[i];
          const employeeId = employee.getElementsByTagName("ns2:employeeId")[0]?.textContent || "N/A";
          const name = employee.getElementsByTagName("ns2:name")[0]?.textContent || "N/A";
          const department = employee.getElementsByTagName("ns2:department")[0]?.textContent || "N/A";
          const phone = employee.getElementsByTagName("ns2:phone")[0]?.textContent || "N/A";
          const address = employee.getElementsByTagName("ns2:address")[0]?.textContent || "N/A";
  
          // Crear una fila para el empleado
          const row = document.createElement("tr");
          row.innerHTML = `
            <td>${employeeId}</td>
            <td>${name}</td>
            <td>${department}</td>
            <td>${phone}</td>
            <td>${address}</td>
          `;
  
          // Añadir la fila a la tabla
          employeeTableBody.appendChild(row);
        }
      } else if (xmlhttp.readyState === 4 && xmlhttp.status !== 200) {
        console.error("Error al obtener la lista de empleados.");
      }
    };
  
    // Enviar la solicitud SOAP
    xmlhttp.send(soapRequest);
}

function fetchEmployeeById() {
    const employeeId = parseInt(document.getElementById("employeeId").value, 10);

    if (isNaN(employeeId)) {
        alert("Por favor, ingrese un ID de empleado válido.");
        return;
    }

    const soapRequest = `
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.api.service.soap.mx.com">
            <soapenv:Header/>
            <soapenv:Body>
                <soap:getEmployeeByIdRequest>
                    <soap:employeeId>${employeeId}</soap:employeeId>
                </soap:getEmployeeByIdRequest>
            </soapenv:Body>
        </soapenv:Envelope>`;

    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/employee/api", true);
    xmlhttp.setRequestHeader("Content-Type", "text/xml");

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4) {
            if (xmlhttp.status === 200) {
                const parser = new DOMParser();
                const xmlDoc = parser.parseFromString(xmlhttp.responseText, "text/xml");

                const employeeResponse = xmlDoc.getElementsByTagName("ns2:getEmployeeResponse")[0];
                if (!employeeResponse) {
                    alert("No se encontró la respuesta del empleado.");
                    return;
                }

                const serviceStatus = employeeResponse.getElementsByTagName("ns2:serviceStatus")[0];
                const status = serviceStatus?.getElementsByTagName("ns2:status")[0]?.textContent || "No disponible";
                const message = serviceStatus?.getElementsByTagName("ns2:message")[0]?.textContent || "No disponible";

                const employeeInfo = employeeResponse.getElementsByTagName("ns2:employeeInfo")[0];
                const name = employeeInfo?.getElementsByTagName("ns2:name")[0]?.textContent || "No disponible";
                const department = employeeInfo?.getElementsByTagName("ns2:department")[0]?.textContent || "No disponible";
                const phone = employeeInfo?.getElementsByTagName("ns2:phone")[0]?.textContent || "No disponible";
                const address = employeeInfo?.getElementsByTagName("ns2:address")[0]?.textContent || "No disponible";

                const output = `
                    <h2>Detalles del Empleado</h2>
                    <ul>
                        <li><strong>ID:</strong> ${employeeId}</li>
                        <li><strong>Status:</strong> ${status}</li>
                        <li><strong>Message:</strong> ${message}</li>
                        <li><strong>Name:</strong> ${name}</li>
                        <li><strong>Department:</strong> ${department}</li>
                        <li><strong>Phone:</strong> ${phone}</li>
                        <li><strong>Address:</strong> ${address}</li>
                    </ul>`;

                document.getElementById("result").innerHTML = output;
            } else {
                console.log("Error de llamada con código " + xmlhttp.status, xmlhttp.responseText);
                alert("Error al obtener los detalles del empleado.");
            }
        }
    };

    xmlhttp.send(soapRequest);
}
  