package kr.perfume.usermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.perfume.usermodule.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
