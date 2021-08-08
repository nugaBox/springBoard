package com.nugabox.web.board.service;

import com.nugabox.common.Pagination;
import com.nugabox.web.board.dao.BoardDAO;
import com.nugabox.web.board.model.BoardVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Inject
    private BoardDAO boardDAO;

    // 게시물 목록 조회
    @Override
    public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
        return boardDAO.getBoardList(pagination);
    }

    //총 게시글 개수 확인
    @Override
    public int getBoardListCnt() throws Exception {
        return boardDAO.getBoardListCnt();
    }

    // 게시글 추가
    @Override
    public void insertBoard(BoardVO boardVO) throws Exception {
        boardDAO.insertBoard(boardVO);
    }

    // 게시글 내용 가져오기
    @Override
    public BoardVO getBoardContent(int bid) throws Exception{
        BoardVO boardVO = new BoardVO();
        boardDAO.updateViewCnt(bid);
        boardVO = boardDAO.getBoardContent(bid);
        // 예외처리 테스트
        //    try {
        //		boardVO.setBid(bid);
        //		boardVO.setCate_cd("1111111111111111111111111111111111111");
        //		boardDAO.updateBoard(boardVO);
        //	} catch (RuntimeException e) {
        //		throw new NotFoundException();
        //	}
        return boardVO;
    }

    // 게시글 추가
    @Override
    public void updateBoard(BoardVO boardVO) throws Exception {
        boardDAO.updateBoard(boardVO);
    }

    // 게시글 삭제
    @Override
    public void deleteBoard(int bid) throws Exception {
        boardDAO.deleteBoard(bid);
    }
}
