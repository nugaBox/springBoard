package com.nugabox.web.board.service;

import com.nugabox.web.board.model.BoardVO;

import java.util.List;

public interface BoardService {

    public List<BoardVO> getBoardList() throws Exception;
}
