import React from "react";
import './App.css';
import {Routes, Route} from 'react-router-dom';
import Main from './views/Main';
import Create from './views/AddAuthor';
import Edit from './views/EditAuthor';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route element={<Main/>} path="/authors" />
        <Route element={<Create/>} path="/authors/create" />
        <Route element={<Edit/>} path="/authors/:id/edit"/>
      </Routes>
    </div>
  );
}

export default App;
