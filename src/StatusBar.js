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


//   return (
//     <ProgressBar>
//       <HighLight width={(count / quiz_list.length) * 100 + "%"} />
//       <Dot />
//     </ProgressBar>
//   );
// };

// const ProgressBar = styled.div`
//   width: 80%;
//   margin: 20px auto;
//   background: #eee;
// //   width: 100%;
//   height: 20px;
//   display: flex;
//   align-items: center;
//   border-radius: 10px;
// `;

// const HighLight = styled.div`
//   background: #df402c88;
//   height: 20px;
//   width: ${(props) => props.width};
//   transition: width 1s;
//   border-radius: 10px;
// `;

// const Dot = styled.div`
//   background: #fff;
//   border: 5px solid #df402c88;
//   box-sizing: border-box;
//   margin: 0px 0px 0px -10px;
//   width: 40px;
//   height: 40px;
//   border-radius: 20px;
// `;
