
import './App.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./component/Navbar.tsx";
import LoginForm from "./component/LoginForm.tsx";
import BookList from "./component/BookList.tsx";

// import LoginForm from "./component/LoginForm.tsx";
//
// import Footer from "./component/Footer.tsx";


function App() {

  // return (
  //   <>
  //    <LoginForm/>
  //       <Footer/>
  //   </>
  // )

    return(

    <BrowserRouter>

        <div className="App">
            <Navbar/>
        </div>
        <div className="content">
            <Routes>
                <Route path="/" element={<LoginForm/>}/>
                <Route path="/login" element={<LoginForm/>}/>
                <Route path="/book-list" element={<BookList/>}/>

            </Routes>
        </div>
    </BrowserRouter>
    );
}

export default App
