import { useEffect, useState } from "react"
import "./ListElementsStyless.css"
import axios from "axios"

const ListElements = () => {

  const [data, setData] = useState([])

  useEffect(() => {
    axios
      .get("http://localhost:8080/finantial/")
      .then((response) => {
        // handle the response
        setData(response.data)
        console.log(response);
      })
      .catch((error) => {
        // handle errors
        console.log(error);
      });
  }, [])




  return (
    <>
      <div className="table">
        <div className="table-header">
          <div className="header__item"><a className="filter__link" href="#">N.</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">segment</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">country</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">product</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">discount_band</a></div>

          {/* <div className="header__item"><a className="filter__link filter__link--number" href="#">units_sold</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">manufactoring</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">sale_price</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">gross_sales</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">discounts</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">sales</a></div> */}

          <div className="header__item"><a className="filter__link filter__link--number" href="#">cogs</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">profit</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">process_date</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">month_number</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">month_name</a></div>
          <div className="header__item"><a className="filter__link filter__link--number" href="#">process_year</a></div>
        </div>
        <div className="table-content">
          {
            data.map((item, index) => {
              return (
                <div className="table-row" key={item.id}>
                  <div className="table-data">{index + 1}</div>
                  <div className="table-data">{item.segment}</div>
                  <div className="table-data">{item.country}</div>
                  <div className="table-data">{item.product}</div>
                  <div className="table-data">{item.discountBand}</div>
{/* 
                  <div className="table-data">{item.unitsSold}</div>
                  <div className="table-data">{item.manufactoring}</div>
                  <div className="table-data">{item.salePrice}</div>
                  <div className="table-data">{item.grossSale}</div>
                  <div className="table-data">{item.discounts}</div>
                  <div className="table-data">{item.sales}</div> */}

                  <div className="table-data">{item.cogs}</div>
                  <div className="table-data">{item.profit}</div>
                  <div className="table-data">{item.processDate}</div>
                  <div className="table-data">{item.monthNumber}</div>
                  <div className="table-data">{item.monthName}</div>
                  <div className="table-data">{item.processYear}</div>
                </div>
              )
            })
          }
        </div>
      </div>
    </>
  )
}



export default ListElements
/*
     <table border="1">
       <tr>
         <th>N.</div>
         <th>segment</div>
         <th>country</div>
         <th>product</div>
         <th>discount_band</div>
         <th>units_sold</div>
         <th>manufactoring</div>
         <th>sale_price</div>
         <th>gross_sales</div>
         <th>discounts</div>
         <th>sales</div>
         <th>cogs</div>
         <th>profit</div>
         <th>process_date</div>
         <th>month_number</div>
         <th>month_name</div>
         <th>process_year</div>
       </tr>
       {
         data.map((item, index) => {
           return <tr key={item.id}>
             <td>{index + 1}</td>
             <td>{item.segment}</td>
             <td>{item.country}</td>
             <td>{item.product}</td>
             <td>{item.discountBand}</td>
             <td>{item.unitsSold}</td>
             <td>{item.manufactoring}</td>
             <td>{item.salePrice}</td>
             <td>{item.grossSales}</td>
             <td>{item.discounts}</td>
             <td>{item.sales}</td>
             <td>{item.cogs}</td>
             <td>{item.profit}</td>
             <td>{item.processDate}</td>
             <td>{item.monthNumber}</td>
             <td>{item.monthName}</td>
             <td>{item.processYear}</td>
           </tr>;
         })
       }
     </table>
     */