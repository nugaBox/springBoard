package com.nugabox.web.board.dao;

import com.nugabox.common.Search;
import com.nugabox.web.board.model.BoardVO;
import com.nugabox.web.board.model.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO {
    @Inject
    private SqlSession sqlSession;

    @Override
    public List<BoardVO> getBoardList(Search search) throws Exception {
        return sqlSession.selectList("com.nugabox.web.board.boardMapper.getBoardList", search);
    }

    //총 게시글 개수 확인
    @Override
    public int getBoardListCnt(Search search) throws Exception {
        return sqlSession.selectOne("com.nugabox.web.board.boardMapper.getBoardListCnt",search);
    }

    @Override
    public BoardVO getBoardContent(int bid) throws Exception {
        return sqlSession.selectOne("com.nugabox.web.board.boardMapper.getBoardContent", bid);
    }

    @Override
    public int insertBoard(BoardVO boardVO) throws Exception {
        return sqlSession.insert("com.nugabox.web.board.boardMapper.insertBoard", boardVO);
    }

    @Override
    public int updateBoard(BoardVO boardVO) throws Exception {
        return sqlSession.update("com.nugabox.web.board.boardMapper.updateBoard", boardVO);
    }

    @Override
    public int deleteBoard(int bid) throws Exception {
        return sqlSession.insert("com.nugabox.web.board.boardMapper.deleteBoard", bid);
    }

    @Override
    public int updateViewCnt(int bid) throws Exception {
        return sqlSession.update("com.nugabox.web.board.boardMapper.updateViewCnt", bid);
    }

    // 댓글 리스트
    @Override
    public List<ReplyVO> getReplyList(int bid) throws Exception {
        return sqlSession.selectList("com.nugabox.web.board.replyMapper.getReplyList", bid);
    }

    @Override
    public int saveReply(ReplyVO replyVO) throws Exception {
        return sqlSession.insert("com.nugabox.web.board.replyMapper.saveReply", replyVO);
    }

    @Override
    public int updateReply(ReplyVO replyVO) throws Exception {
        return sqlSession.update("com.nugabox.web.board.replyMapper.updateReply", replyVO);
    }

    @Override
    public int deleteReply(int rid) throws Exception {
        return sqlSession.delete("com.nugabox.web.board.replyMapper.deleteReply", rid);
    }
}
