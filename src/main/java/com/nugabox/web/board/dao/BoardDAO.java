package com.nugabox.web.board.dao;

import java.util.List;

import com.nugabox.common.Pagination;
import com.nugabox.common.Search;
import com.nugabox.web.board.model.BoardVO;

public interface BoardDAO {
    public List<BoardVO> getBoardList(Search search) throws Exception;

    //총 게시글 개수 확인
    public int getBoardListCnt(Search search) throws Exception;

    public BoardVO getBoardContent(int bid) throws Exception;

    public int insertBoard(BoardVO boardVO) throws Exception;

    public int updateBoard(BoardVO boardVO) throws Exception;

    public int deleteBoard(int bid) throws Exception;

    public int updateViewCnt(int bid) throws Exception;

}
