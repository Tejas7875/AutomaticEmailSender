package com.emailApp.JPA;

import com.emailApp.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity, String>
{
    boolean existsByEmail(String email);

}
