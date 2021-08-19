import React from "react";
import styled from "styled-components";

const QnA = (props) => {
    return (
        <Container>
        <Qbox>
            <p>1/8</p>
            <h1>Q.1</h1>
        </Qbox>
        
        <Abox>배고픔을 참지 못하고 바로 야식 주문을 한다.</Abox>
        <Abox><div>1. 어쩌구</div></Abox>
        <Abox><div>1. 어쩌구</div></Abox>
        </Container>
    );
}

const Container = styled.div`
    margin-left: 20px;
    align-items: center;
`;

const Qbox = styled.div`
    background-color: #FCD6E6;
    text-align: center;
    border-radius: 30px;
    font-size: 20px;
    width: 80%;
    color: #000000;
    align-items: center;
    margin-left: 20px;
`;

const Abox = styled.div`
    background-color: #F8257E;
    display: block;
    border-radius: 90px;
    width: 100%;
    border: 0px;
    font-size: 17px;
    width: 80%;
    text-align: center;
    color: white;
    margin-left: 20px;
    
`;
export default QnA;



