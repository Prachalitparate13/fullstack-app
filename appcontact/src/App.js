import { getContacts } from './api/ContactService';
import './App.css';
import {useEffect, useState } from 'react';

function App() {
  const [data, setData] = useState({});
  const [currentPage, setCurrentPage] = useState(0);

  const getAllContacts=async (page=0,size=10)=>{
    try{
      setCurrentPage(page);
      const {data } = await getContacts(page,size);
      setData(data);
      console.log(data);
    }catch(e){
      console.log(e)

    }
  }
useEffect(()=>{
  getAllContacts();
},[]);


  return (
    <div>
     <h1>Hello</h1>
    </div>
  );
}

export default App;
