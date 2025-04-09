package org.zerock.sb7.board.repo.search;


import org.zerock.sb7.board.dto.BoardListDTO;
import org.zerock.sb7.board.dto.PageRequestDTO;
import org.zerock.sb7.board.dto.PageResponseDTO;

public interface BoardSearch {

    PageResponseDTO<BoardListDTO> search(PageRequestDTO pageRequestDTO);



}
