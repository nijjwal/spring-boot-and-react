import React, {useState, useEffect} from 'react';
import {useParams, useNavigate, UNSAFE_NavigationContext} from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';


export default function CreateEmployeeComponent(props){
    //properties of functional component
    let { id } = useParams();
    const navigate = useNavigate();

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [emailId, setEmailId] = useState('');

    let firstNameRef = React.createRef();
    let lastNameRef = React.createRef();
    let emailIdRef = React.createRef();

     //this method is similar to componentDidMount
     useEffect(() => {
       console.log('Hi');
     });

    const changeFirstNameHandler = (event) =>{        
        setFirstName(event.target.value);
    }

    const changeLastNameHandler = (event) =>{        
        setLastName(event.target.value);
    }

    const changeEmailIdHandler = (event) =>{        
        setEmailId(event.target.value);
    }

    const cancel = () =>{
        navigate('/employees');
    }

    const handleClick =(event) =>{

        console.log(id);
        event.preventDefault();
        setFirstName(firstNameRef.current.value);

        let employee = {firstName: firstNameRef.current.value, 
            lastName: lastNameRef.current.value, 
            emailId: emailIdRef.current.value};
                        
        console.log('employee' + JSON.stringify(employee));

        EmployeeService.createEmployee(employee).then( (res)=>{
           navigate('/employees');
        });
        
    }
    

     return(
        <div>
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className='text-center'>Add Employee</h3>
                            <div className='card-body'>

                                <form>

                                    <div className='form-group'>
                                        <label>First Name: </label>
                                        <input placeholder='First Name' name='firstName' className='form-control'
                                        ref={firstNameRef}
                                        defaultValue={firstName} onChange={changeFirstNameHandler}
                                        />
                                    </div>


                                    <div className='form-group'>
                                        <label>Last Name: </label>
                                        <input placeholder='Last Name' name='lastName' className='form-control'
                                        ref={lastNameRef}
                                        defaultValue={lastName} onChange={changeLastNameHandler}
                                        />
                                    </div>

                                    <div className='form-group'>
                                        <label>Email: </label>
                                        <input placeholder='Email' name='emailId' className='form-control'
                                        ref={emailIdRef}
                                        defaultValue={emailId} onChange={changeEmailIdHandler}
                                        />
                                    </div>

                                    <button className='btn btn-success' onClick={handleClick}>Save</button>  
                                
                                    <button className='btn btn-danger' onClick={cancel} style={{marginLeft: "10px"}}>Cancel</button>


                                    
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
        </div>
     );

}