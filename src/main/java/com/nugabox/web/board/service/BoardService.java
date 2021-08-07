package com.nugabox.web.board.service;

import com.nugabox.web.board.model.BoardVO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    // 게시물 목록 조회
    public List<BoardVO> getBoardList() throws Exception;

    // 게시글 추가
    public void insertBoard(BoardVO boardVO) throws Exception;

    // 게시글 내용 가져오기
    public BoardVO getBoardContent(int bid) throws Exception;

    // 게시글 수정
    public void updateBoard(BoardVO boardVO) throws Exception;

    // 게시글 삭제
    public void deleteBoard(int bid) throws Exception;
}
