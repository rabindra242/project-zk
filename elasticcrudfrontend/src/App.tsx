import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import MainFile from "./component/MainFile.tsx";
import InputForm from "./component/InputForm.tsx";

function App() {
  const [count, setCount] = useState(0)

  // useEffect(()=>{
  //   axios.get("https://localhost:8080/login")
  // },[])

  return (
    <>
      <MainFile/>
        <InputForm/>
    </>
  )
}

export default App
