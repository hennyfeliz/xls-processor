import './App.css'
import { BrowserRouter } from "react-router-dom";
import { Routes, Route, Link } from "react-router-dom";
import SendFileRest from './components/SendFileRest'
import ListElements from './components/ListElements';
import axios from 'axios';
import { useEffect, useState } from 'react';

function App() {

  const [loading, setLoading] = useState(false)
  const [success, setSuccess] = useState(false)

  const truncateHandler = () => {
    axios.delete("http://localhost:8080/finantial/truncate")
    .then(() => {
      setSuccess(true);
      setLoading(false);
    })
    .catch((error) => {
      console.log(error);
    });
  }

  return (
    <>
      <BrowserRouter>
        <div className="all-elements">
          <Link to={"/"}>
            <h2>Carga</h2>
          </Link>
          <span>|</span>
          <Link to={"/list"}>
            <h2>Lista</h2>
          </Link>
          <span>|</span>
          <Link>
            <h2 onClick={truncateHandler}>Limpiar tabla</h2>
          </Link>
        </div>
        <Routes>
          <Route path="/" element={<SendFileRest />} />
          <Route path="/list" element={<ListElements />} />
        </Routes>
        {loading ? <h2>Borrando...</h2> : ''}
        {success ? <h2 style={{ color: "red" }}>Borrado completado!</h2> : ''}
      </BrowserRouter>
    </>
  )
}

export default App
