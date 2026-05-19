package com.project.lendAHand.userBusiness.repository;

import com.project.lendAHand.userBusiness.domain.UserBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBusiness, Long> {
}
