import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import HelloWorld from "./HelloWorld";
import ListEmployeeCompnent from "./components/ListEmployeeCompnent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import EmployeeComponent from "./components/EmployeeComponent";

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<ListEmployeeCompnent />}></Route>
          {/* //http://localhost:3000/employees */}
          <Route path="/employees" element={<ListEmployeeCompnent />}></Route>
          {/* //http://localhost:3000/employees */}
          <Route path="/addEmployee" element={<EmployeeComponent />}></Route>

          {/* //http://localhost:3000/employees/1 */}
          <Route path="/updateEmployee/:id" element={<EmployeeComponent />}></Route>
        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;
