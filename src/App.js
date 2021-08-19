import React from "react";
import logo from './logo.svg';
import './App.css';

import StatusBar from "./StatusBar";
import QnA from "./QnA";
import Result from "./Result";

 const App = (props) => {
  return(
    <div className="App">
      <StatusBar></StatusBar>
      <QnA></QnA>
      <Result></Result>
  </div>
  );
}

export default App;
//브랜치 생성