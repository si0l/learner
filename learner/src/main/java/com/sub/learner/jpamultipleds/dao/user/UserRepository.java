package com.sub.learner.jpamultipleds.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sub.learner.jpamultipleds.model.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
