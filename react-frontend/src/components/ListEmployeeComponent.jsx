import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';
import { Link } from 'react-router-dom';
import {withRouter} from './withRouter';

class ListEmployeeComponent extends Component {

    constructor(props){
        super(props)

        this.state = {
            employees: []
        }

        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
        this.deleteEmployee = this.deleteEmployee.bind(this);
    }

    componentDidMount(){
        EmployeeService.getEmployees().then((res)=>{
            this.setState( {employees: res.data});
        });
    }

    addEmployee(){
        //this.props.history.push('/add-employee');
    }

    editEmployee(id){
        console.log('btn clicked for case #' + id);
       //when passing a value in url, don't use single quote, it'a a back-tick
       this.props.navigate(`/update-employee/${id}`);
    }

    deleteEmployee(id){
        EmployeeService.deleteEmployee(id).then( (res)=>{
            //here we are deleing the record from the list and rendering the dom again instead
            //of refereshing the browser or which would go fetch data from the application again 
            //and re-load the array. 
            this.setState({employees: this.state.employees.filter(employee=>employee.id!==id)});
         });
    }

    render() {
        return (
            <div>
                <h2 className='text-center'>Employee List</h2>
                <div className='row'>
                    <Link to="/add-employee">
                        <button className='btn btn-primary' onClick={this.addEmployee}>Add Employee</button>
                    </Link>
                </div>

                <div className='row'>
                    <table className='table table-striped table-bordered'>

                        <thead>
                            <tr>
                                <th>Employee First Name</th>
                                <th>Employee Last Name</th>
                                <th>Employee Email Id</th>
                                <th>Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                        {
                            this.state.employees.map(
                                employee =>
                                <tr key={employee.id}>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.emailId}</td>
                                    <td> 
                                        <button onClick={ ()=> this.editEmployee(employee.id)} className="btn btn-info">Update</button>
                                        <button style={{marginLeft: "10px"}} onClick={ ()=> this.deleteEmployee(employee.id)} className="btn btn-danger">Delete</button>
                                    </td>
                                </tr>
                            )
                        }  
                        </tbody>

                    </table>
                </div>
            </div>
        );
    }
}

export default withRouter(ListEmployeeComponent);
