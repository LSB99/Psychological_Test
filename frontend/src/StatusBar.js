import React from "react";
import styled from "styled-components";
// import { useSelector } from "react-redux";

const StatusBar = (props) => {
// 질문 리스트 가지고 오기
// const question = useSelector((state) => state.question.question);
// // 유저 선택 리스트 가지고 오기
// const choice = useSelector((state) => state.question.choice);
// // 선택 리스트 갯수 세기
//   let count = choice.length;

    return (
        <div>
        <HighLight/>
        <State><div>1/8</div></State>
        </div>
    );
};

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
<<<<<<< HEAD
`;

const HighLight = styled.div`
  background: #df402c88;
  height: 20px;
//   width: ${(props) => props.width};
  width: 20%;
  transition: width 1s;
  border-radius: 10px;
`;

export default StatusBar;

