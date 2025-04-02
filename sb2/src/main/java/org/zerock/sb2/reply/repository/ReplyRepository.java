package org.zerock.sb2.reply.repository;
 
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.zerock.sb2.reply.entities.ReplyEntity;
 
 public interface ReplyRepository extends JpaRepository<ReplyEntity, Long>{
   
 }