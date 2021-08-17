package com.sysambientes.sysambientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sysambientes.sysambientes.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {

	@Query(value = "SELECT * FROM links WHERE link_reduzido = :id", nativeQuery = true)
	public Link findbyLinkReduzido(@Param("id") String id);

	public <S extends Link> S save(S entity);

	public List<Link> findAll();

	public void deleteById(Integer id);

}
