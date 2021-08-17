package com.nugabox.web.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nugabox.web.board.model.ReplyVO;
import com.nugabox.web.board.service.BoardService;

import java.util.List;

@RestController
@RequestMapping(value="/restBoard")

public class RestBoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Inject
    private BoardService boardService;

    @RequestMapping(value="/getReplyList", method=RequestMethod.POST)
    public List<ReplyVO> getReplyList(@RequestParam("bid") int bid) throws Exception {
        return boardService.getReplyList(bid);
    }
}
