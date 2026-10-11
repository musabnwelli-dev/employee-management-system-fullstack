import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import EmployeeListComponent from './components/EmployeeListComponent'
import { HeaderComponent } from './components/HeaderComponent'
import { FooterComponent } from './components/FooterComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import EmployeeCompenent from './components/EmployeeCompenent'


function App() {


  return (
    <>
    <BrowserRouter>
    <HeaderComponent />

    <Routes>
      <Route path='/' element={ <EmployeeListComponent />}>
    </Route>
    <Route path='/employees' element={ <EmployeeListComponent />}>
    </Route>
    <Route path='/add-employee' element={<EmployeeCompenent />}></Route>
    <Route path='/edit-employee/:id' element={<EmployeeCompenent />}></Route>
     </Routes>
     
     <FooterComponent />
     </BrowserRouter>
    </>
  )
}

export default App
