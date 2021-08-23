import React from "react";

const Start = (props) => {

    return (
        <div className="container">
            <h1>
                캐릭터들로 보는<br/>나의 성격 유형 테스트
            </h1>
            <p className="start-subtitle">나와 닮은 캐릭터는 누구일까?</p>

                <input className="nickname-input" type="text" placeholder="닉네임을 입력해주세요"/>


            <button
                className="start-button"
                onClick={() => {

                    props.history.push("/QnA");
                }}
            >
                START
            </button>
        </div>
    );
};

export default Start;

