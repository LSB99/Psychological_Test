import React from "react";
import styled from "styled-components";
import img from "./back.png";
import img2 from "./next.png";

const QnA = (props) => {
    const goBack = () => {
        props.history.goBack();
    };

    return (
        <Container>
            <Qbox>
                <h1>Q.1</h1>
                <h3>금요일 새벽 1시, 당신은 배가 고프다. 야식이 생각나는 새벽에 당신이 할 행동은?</h3>
            </Qbox>

            <Abox><p>배고픔을 참지 못하고 바로 야식 주문을 한다.</p></Abox>
            <Abox><p>배달앱에서 메뉴를 계속 고민하다가 배고픔을 참고 잠을 청한다.</p></Abox>
            <Abox><p>카톡으로 친구에게 야식을 먹을지 말지 물어보고 친구가 말한대로 한다.</p></Abox>
            <div className="qna-button-div">
                <BackIcon
                    src={img} onClick={goBack}
                />
                <NextIcon
                    src={img2}
                    onClick={() => {
                    props.history.push("/Comment");
                }}
                />
            </div>
        </Container>
    );
}

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100vw;
    height: 100vh;
`;

const Qbox = styled.div`
    & > h1 {
        padding-top: 10px;
    }
    & > h3 {
        margin-left: 20px;
        margin-right: 20px;
    }
    background-color: #FCD6E6;
    text-align: center;
    border-radius: 30px;
    font-size: 20px;
    width: 80%;
    color: #000000;
    align-items: center;
    margin-top: 30px;
    padding-bottom: 30px;
    margin-bottom: 30px;
`;

const Abox = styled.div`
    & > p {
        padding-left: 20px;
        padding-right: 20px;
    }
    background-color: #f8257e82;
    display: block;
    border-radius: 90px;
    width: 100%;
    border: 0px;
    font-size: 15px;
    width: 80%;
    text-align: center;
    color: white;
    margin-left: 20px;
    padding-bottom: 2px;
    padding-top: 2px;
    margin-bottom: 10px;
`;

const BackIcon = styled.img`
    width: 9%;
    margin-left: 10px;
    margin-top: 5px;
`

const NextIcon = styled.img`
    width: 9%;
    margin-right: 10px;
    margin-top: 5px;
`

export default QnA;

