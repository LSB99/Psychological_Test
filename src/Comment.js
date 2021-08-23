import React from "react";
import styled from "styled-components";
import img from "./back.png";

const Comment = (props) => {

    return (
        <div className="container">
            <div className="back-div">
                <BackIcon
                    src={img} onClick={() => {
                    props.history.push("/Result")
                }}
                />
            </div>
            <div className="comment-title-div">
                <p className="comment-title">
                    테스트는 재미있었나요?<br/>
                    자유롭게 테스트에 대한<br/>
                    코멘트를 달아 보세요:)
                </p>
            </div>
            <div className="comment-container">
                <CommentItem>
                    <CommentName>익명1</CommentName>
                    <CommentContent>재밌어요~</CommentContent>

                </CommentItem>
            </div>

            <div className="input-container">
                <CommentInput id="comment-input" placeholder="한줄평을 입력해보세요"/>
                <OkButton type="submit">확인</OkButton>
            </div>
        </div>
    );
}

const CommentInput = styled.textarea`
  padding: 7px;
  border: 1px solid #BDBDBD;
  border-radius: 5px;
  width: 70%;
  height: 70px;
  text-align: left;
  font-family: '함초롬돋움';
`

const OkButton = styled.div`
    padding: 10px 10px;
    background-color: #6799FF;
    border-radius: 10px;
    border: #F8257E;
    color: white;
    margin-left: 15px;
    font-size: 13px;
`

const BackIcon = styled.img`
    width: 9%;
    margin-left: 10px;
    margin-top: 5px;
`

const CommentItem = styled.div`
  width: 80vw;
  margin: 8px auto;
  display: flex;
  flex-direction: column;
  border-radius: 5px;
  border: 1px solid #FFF2E6;
  padding: 10px;
  background-color: #FFF2E6;
  box-shadow: 1px 1px 3px 1px rgba(0, 0, 0, 0.2);
  
`

const CommentName = styled.div`
    font-size: 15px;
    font-weight: bold;
`

const CommentContent = styled.div`
    text-align: center;
`

export default Comment;