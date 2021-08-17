package com.nugabox.web.board.service;

import com.nugabox.common.Search;
import com.nugabox.web.board.dao.BoardDAO;
import com.nugabox.web.board.model.BoardVO;
import com.nugabox.web.board.model.ReplyVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Inject
    private BoardDAO boardDAO;

    // 게시물 목록 조회
    @Override
    public List<BoardVO> getBoardList(Search search) throws Exception {
        return boardDAO.getBoardList(search);
    }

    //총 게시글 개수 확인
    @Override
    public int getBoardListCnt(Search search) throws Exception {
        return boardDAO.getBoardListCnt(search);
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

    // 댓글 리스트
    @Override
    public List<ReplyVO> getReplyList(int bid) throws Exception {
        return boardDAO.getReplyList(bid);
    }

    @Override
    public int saveReply(ReplyVO replyVO) throws Exception {
        return boardDAO.saveReply(replyVO);
    }

    @Override
    public int updateReply(ReplyVO replyVO) throws Exception {
        return boardDAO.updateReply(replyVO);
    }

    @Override
    public int deleteReply(int rid) throws Exception {
        return boardDAO.deleteReply(rid);
    }
}
