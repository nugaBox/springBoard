package com.nugabox.web.board.controller;

import com.nugabox.web.board.model.BoardVO;
import com.nugabox.web.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String saveBoard(@ModelAttribute("boardVO") BoardVO boardVO, @RequestParam("mode") String mode, RedirectAttributes rttr) throws Exception {
        if (mode.equals("edit")) {
            boardService.updateBoard(boardVO);
        } else {
            boardService.insertBoard(boardVO);
        }
        return "redirect:/board/getBoardList";
    }

    // 게시글 내용 가져오기
    @RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
    public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
        model.addAttribute("boardContent", boardService.getBoardContent(bid));
        return "board/boardContent";
    }

    // 게시글 수정
    @RequestMapping(value = "/editForm", method = RequestMethod.GET)
    public String editForm(@RequestParam("bid") int bid, @RequestParam("mode") String mode, Model model) throws Exception {
        model.addAttribute("boardContent", boardService.getBoardContent(bid));
        model.addAttribute("mode", mode);
        model.addAttribute("boardVO", new BoardVO());
        return "board/boardForm";
    }

    // 게시글 삭제
    @RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
    public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
        boardService.deleteBoard(bid);
        return "redirect:/board/getBoardList";
    }

//    @ExceptionHandler(RuntimeException.class)
//    public String exceptionHandler(Model model, Exception e){
//        logger.info("exception : " + e.getMessage());
//        model.addAttribute("exception", e);
//        return "include/exception";
//    }
}
