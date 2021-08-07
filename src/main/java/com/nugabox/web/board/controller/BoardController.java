package com.nugabox.web.board.controller;

import com.nugabox.web.board.model.BoardVO;
import com.nugabox.web.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Controller
@RequestMapping(value="/board")
public class BoardController {

    @Inject
    private BoardService boardService;

    // 게시글 목록 화면
    @RequestMapping(value="/getBoardList", method= RequestMethod.GET)
    public String getBoardList(Model model) throws Exception{
        model.addAttribute("boardList", boardService.getBoardList());
        return "board/index";
    }

    // 게시글 쓰기 화면
    @RequestMapping("/boardForm")
    public String boardForm(){
        return "board/boardForm";
    }

    // 게시글 저장
    @RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
    public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO, RedirectAttributes rttr) throws Exception {
        boardService.insertBoard(boardVO);
        return "redirect:/board/getBoardList";
    }
}
