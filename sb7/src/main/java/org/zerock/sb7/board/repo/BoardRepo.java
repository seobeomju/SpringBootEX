package org.zerock.sb7.board.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.sb7.board.domain.Board;

public interface BoardRepo extends JpaRepository<Board, Integer> {

    //Pageable이 파라미터 무조건 리턴타입은 Page타입

    @Query("""
    select b.bno, b.title, b.writer, count(r), count(f)
    from Board b 
        left join Reply r on r.board = b
        left join Favorite f on f.board = b
    group by b.bno
""")
    Page<Object[]> list1(Pageable pageable);
}
