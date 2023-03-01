package com.diary.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.diary.demo.model.User;
@Repository
public interface UsersRepository  extends JpaRepository<User,Long>{

}
