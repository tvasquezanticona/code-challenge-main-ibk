# Code Challenge

<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Parameters</th>
    <th>Param</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>POST</td>
    <td>/api/v1/employees</td>
    <td>NO</td>
    <td></td>
    <td>Crear nuevo empleado.</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/api/v1/employees</td>
    <td>NO</td>
    <td></td>
    <td>Obtener todos los empleados.</td>
  </tr>
  <tr>
    <td rowspan="2">GET</td>
    <td rowspan="2">/api/v1/employees/find</td>
    <td rowspan="2">SI</td>  
    <td>type</td>
    <td>Tipo de la busqueda (EMAIL o PHONE).</td>
  </tr>
  <tr>
    <td>value</td>
    <td>Valor de la busqueda por el tipo seleccionado.</td>
  </tr>
</table>

### [postman collection](tools/Code-Challenge.postman_collection.json)