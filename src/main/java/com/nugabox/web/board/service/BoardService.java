package com.nugabox.web.board.service;

import com.nugabox.common.Search;
import com.nugabox.web.board.model.BoardVO;
import com.nugabox.web.board.model.ReplyVO;

import java.util.List;

public interface BoardService {

    // 게시물 목록 조회
    public List<BoardVO> getBoardList(Search search) throws Exception;

    //총 게시글 개수 확인
    public int getBoardListCnt(Search search) throws Exception;

    // 게시글 추가
    public void insertBoard(BoardVO boardVO) throws Exception;

    // 게시글 내용 가져오기
    public BoardVO getBoardContent(int bid) throws Exception;

    // 게시글 수정
    public void updateBoard(BoardVO boardVO) throws Exception;

    // 게시글 삭제
    public void deleteBoard(int bid) throws Exception;

    // 댓글 리스트
    public List<ReplyVO> getReplyList(int bid) throws Exception;
    public int saveReply(ReplyVO replyVO) throws Exception;
    public int updateReply(ReplyVO replyVO) throws Exception;
    public int deleteReply(int rid) throws Exception;
}
