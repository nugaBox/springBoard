package com.nugabox.web.board.service;

import com.nugabox.web.board.model.BoardVO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    // 게시물 목록 조회
    public List<BoardVO> getBoardList() throws Exception;

    // 게시글 추가
    public void insertBoard(BoardVO boardVO) throws Exception;
}
