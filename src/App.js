import React from "react";
import './App.css';
import { withRouter } from "react-router";
import {Route, Switch} from "react-router-dom";
import { connect } from "react-redux";

import StatusBar from "./StatusBar";
import QnA from "./QnA";
import Result from "./Result";
import Start from "./Start";
import Comment from "./Comment";


class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.text = React.createRef();
    }

    // componentDidMount() {
    //     this.props.load();
    // }

    addCommentList = () => {
        const new_item = this.text.current.value;
        this.props.create(new_item);
    };

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