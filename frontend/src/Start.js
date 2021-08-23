import React from "react";
import styled from "styled-components"; // eslint-disable-line no-unused-vars

const Start = (props) => {
    return (
        <div className="container">
            <h1>
                캐릭터들로 보는<br/>나의 성격 유형 테스트
            </h1>
            <p className="start-subtitle">나와 닮은 캐릭터는 누구일까?</p>
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

