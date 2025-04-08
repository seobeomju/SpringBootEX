package org.zerock.sb7.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.sb7.board.domain.Reply;

public interface ReplyRepo extends JpaRepository<Reply, Integer> {
}
