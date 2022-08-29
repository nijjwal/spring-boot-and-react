import logo from './logo.svg';
import './App.css';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';


import {BrowserRouter as Router} from "react-router-dom";
import {Routes, Route} from "react-router";



function App() {  
  return (
    <div >
      <HeaderComponent />
         <Router> 
              <div className="container">
                   <Routes>
                         <Route exact path = "/"  element={<ListEmployeeComponent/>}></Route>
                         <Route path = "/employees" element={<ListEmployeeComponent/>}></Route>
                         <Route path = "/add-employee" element={<CreateEmployeeComponent/>}></Route>
                         <Route path = "/update-employee/:id" element={<UpdateEmployeeComponent/>}></Route>
                   </Routes>
              </div>
         </Router>
     <FooterComponent/>
    </div>
  );
}

export default App;
