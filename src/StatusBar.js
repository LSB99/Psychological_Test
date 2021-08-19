import React from "react";
import styled from "styled-components";

const StatusBar = (props) => {
    return (
        <State><div>1/8</div></State>
    );
}

const State = styled.div`
    & > div {
        font-weight: 500;
        padding-left: 250px;
        padding-top: 20px;
        color: #f8257e82;
        
    }
    height: 20px;
    width: 280px;
    background-color: #FCD6E6;
    border-radius : 20px;
    margin-left: 40px;
    margin-top: 20px;
`;
export default StatusBar;