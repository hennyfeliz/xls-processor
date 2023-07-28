
import axios from "axios";
import "./SendFileRestStyless.css"
import { useState } from "react";

const SendFileRest = () => {
  let contador = 0;

  const [loading, setLoading] = useState(false)
  const [success, setSuccess] = useState(false)

  const actualizarContador = () => {
    contador++;
  }

  const handleFileUpload = (event) => {
    setInterval(actualizarContador, 1000);
    setLoading(true)
    console.log(event.target)
    // get the selected file from the input
    const file = event.target.files[0];
    // create a new FormData object and append the file to it
    const formData = new FormData();
    formData.append("file", file);
    // make a POST request to the File Upload API with the FormData object and Rapid API headers
    axios
      .post("http://localhost:8080/finantial/xlsx/", formData, {
        headers: {
          "Content-Type": "multipart/form-data"
        },
      })
      .then((response) => {
        // handle the response
        // alert("carga completada")
        setSuccess(true);
        setLoading(false);
        console.log(response);
      })
      .catch((error) => {
        // handle errors
        console.log(error);
      });
  };
  // render a simple input element with an onChange event listener that calls the handleFileUpload function
  return (
    <div className="containerr">
      <div className="carga-div">
        <input type="file" onChange={handleFileUpload} />
      </div>
      {loading ? <h2>Cargando...</h2> : ''}
      {success ? <h2 style={{ color: "green" }}>Carga completada!</h2> : ''}
    </div>
  );
};

export default SendFileRest