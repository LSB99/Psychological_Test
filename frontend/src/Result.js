import React from "react";
import styled from "styled-components";
import img from "./Piglet.jpg";
import img2 from "./yasha.png";
import img3 from "./mang.png";


const Result = (props) => {
    return (
      <Container>
        <ResultPage>
          <h2>
            당신이 닮은 <b>캐릭터는?</b>
          </h2>
          <img src={img}></img>
          <h2>
            <b>피글렛</b> 입니다.
          </h2>
          <p>#귀여운 #배려 #소심한 #우정</p>
          <h3>[총평]</h3>
          <h4>~~~~~~~~~~~~~~~~~~<br/>
              ~~~~~~~~~~~~~~~~~~</h4>

          <Extra>
            <article>
            <p>나와 상극인 캐릭터</p>
            <img src={img2}></img>
            <p><b>이누야샤</b></p>
            </article>

            <article>
              <p>나와 찰떡궁합 캐릭터</p>
              <img src={img3}></img>
              <p><b>맹구</b></p>
            </article>
          </Extra>
        </ResultPage>

        <Next>
          <Tbutton onClick={() => {
                    props.history.push("/Comment");
                }}>테스트 한줄평 남기러 가기</Tbutton>
          <Kbutton >카카오톡 공유하기</Kbutton>
        </Next>
      </Container>
    );
}

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100vw;
    height: 100vh;
    overflow: hidden;

`;

const ResultPage = styled.div`
    & > img {
        max-width: 100%;
        height: auto;
    }
    & > h2 {
        margin-top: 20px;
        font-weight : 500;
        margin-bottom: 10px
    }
    & > p {
        color: #F8257E;
        margin-top: 10px;
    }
    background-color: #FCD6E6;
    border-radius: 30px;
    font-size: 20px;
    width: 90%;
    color: #000000;
    align-items: center;
    margin-top: 30px;
    flex-wrap: wrap;
    height: 500px;
    overflow-y: scroll;
    scroll-snap-type: y mandatory;
    padding-bottom: 30px;
    margin-bottom: 30px;
    padding-left: 5px;
    padding-right: 5px;
`;

const Extra = styled.div`
  & > article {
    background-size: contain;
    margin-left: 5px;
    &:first-child {
      margin-left: 0;
    }
  }

  & > article > p {
      font-size: 80%;
      font-weight : 900;
  }

  & > article > img {
    width: 160px;
    height: 160px;
    margin: 0 auto;
  }
  display: flex;
  box-sizing: border-box;
  width: 100%;
  padding: 5px;
  float: left;
  width: 30%;
  padding: 10px;
  text-align: center;
`;

const Next = styled.div`
    align-self: auto;
    justify-content: center;
    float: left;
    width: 100%;
    padding: 10px;
`;

const Tbutton = styled.button`
& > p {
    padding-left: 20px;
    padding-right: 20px;
}
background-color: #f8257e82;
display: block;
border-radius: 90px;
width: 100%;
border: 0px;
font-size: 17px;
font-weight : 600;
width: 80%;
text-align: center;
color: white;
margin-left: 30px;
padding-bottom: 4px;
padding-top: 4px;
margin-bottom: 10px;

`;
const Kbutton = styled.button`
& > p {
    padding-left: 20px;
    padding-right: 20px;
}
background-color: #fef01b;
display: block;
border-radius: 90px;
width: 100%;
border: 0px;
font-size: 17px;
font-weight : 600;
width: 80%;
text-align: center;
color: black;
margin-left: 30px;
padding-bottom: 5px;
padding-top: 5px;
margin-bottom: 10px;
`;

export default Result;