import React from "react";
import styled from "styled-components";
import { useSelector } from "react-redux";


const StatusBar = (props) => {
// 질문 리스트 가지고 오기
// const question = useSelector((state) => state.question.question);
// // 유저 선택 리스트 가지고 오기
// const choice = useSelector((state) => state.question.choice);
// // 선택 리스트 갯수 세기
//   let count = choice.length;

    // let count_per = question_list.map((l, idx) => {
    //     if (l.completed) {
    //         count++;
    //     }
    // });

    return (
        <ProgressBar>
             <HighLight width="30%"></HighLight>
             {/*<HighLight width={(count / question_list.length) * 100 + "%"}></HighLight>*/}
             <Dot />
         </ProgressBar>
    );
};


const ProgressBar = styled.div`
  background: #FCD6E6;
  width: 80%;
  height: 20px;
  display: flex;
  border-radius: 10px;
  align-items: center;
  margin-top: 40px;
`;

const HighLight = styled.div`
  background: #df402c88;
  width: ${(props) => props.width};
  height: 20px;
  border-radius: 10px;
  transition: 2s;
`;

const Dot = styled.div`
  background: #fff;
  border: 5px solid #df402c88;
  box-sizing: border-box;
  margin: 0px 0px 0px -10px;
  width: 40px;
  height: 40px;
  border-radius: 20px;
`;

export default StatusBar;

