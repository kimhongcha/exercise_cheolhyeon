package com.example.webstudy.controller;

import com.example.webstudy.dto.BoardDto;
import com.example.webstudy.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;

    /* 게시글 목록 */
    @GetMapping("")
    public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);

        return "board/list";
    }

    @GetMapping("/post")
    public String displayBoardWrite() {

        return "board/write";
    }

    @PostMapping("/post")
    public String writeBoard(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/board";
    }

    @GetMapping("/post/{no}")
    public String displayBoardDetail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/detail";
    }

    @GetMapping("/post/edit/{no}")
    public String displayBoardUpdate(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/update";
    }

    @PutMapping("/post/edit/{no}")
    public String executeUpdate(BoardDto boardDTO) {
        boardService.savePost(boardDTO);

        return "redirect:/board";
    }

    @DeleteMapping("/post/{no}")
    public String executeDelete(@PathVariable("no") Long no) {
        boardService.deletePost(no);
        return "redirect:/board";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model) {
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }
}
