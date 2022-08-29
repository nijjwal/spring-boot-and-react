import axios from 'axios';
import axiso from 'axios'; 

const EMPLOYEE_API_BASE_URL = 'http://localhost:8080/api/v1/employees';

class  EmployeeService{
    getEmployees(){
        return axiso.get(EMPLOYEE_API_BASE_URL);
    }

    createEmployee(employee){
        return axios.post(EMPLOYEE_API_BASE_URL, employee);
    }

    getEmployeeById(emloyeeId){
        return axios.get(EMPLOYEE_API_BASE_URL + '/' + emloyeeId);
    }

    updateEmployee(employee, employeeId){
        return axios.put(EMPLOYEE_API_BASE_URL + '/' + employeeId, employee);
    }


    deleteEmployee(employeeId){
        return axios.delete(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    }
}

export default new EmployeeService()