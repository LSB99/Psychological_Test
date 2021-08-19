import React from "react";
import './App.css';
import {Route, Switch} from "react-router-dom";
import {withRouter} from "react-router";

import StatusBar from "./StatusBar";
import QnA from "./QnA";
import Result from "./Result";
import Start from "./Start";
import Comment from "./Comment";


class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {};
    }

    render() {
        return (
            <div className="App">
                <Switch>
                    <Route exact path="/" component={Start}/>
                    <Route exact path="/QnA" component={QnA}/>
                    <Route exact path="/StatusBar" component={StatusBar}/>
                    <Route exact path="/Result" component={Result}/>
                    <Route exact path="/Comment" component={Comment}/>
                </Switch>
            </div>
        );
    }
}

export default App;