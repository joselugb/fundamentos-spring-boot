package com.fundamentos.platzi.fundamentos.repository;

import com.fundamentos.platzi.fundamentos.dto.UserDto;
import com.fundamentos.platzi.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email=?1")
    Optional<User> findByUserMail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    //String a = "new UserDto(a.id, a.name, a.birthDate)";

    @Query("select new com.fundamentos.platzi.fundamentos.dto.UserDto(a.id, a.name, a.birthDate) from User a" +
    "where a.birthDate =: parametroFecha" +
    "and a.name =: parametroEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date,
                                                @Param("parametroEmail") String email);

}
