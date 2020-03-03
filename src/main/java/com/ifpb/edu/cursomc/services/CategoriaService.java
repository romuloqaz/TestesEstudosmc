package com.ifpb.edu.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ifpb.edu.cursomc.domain.Categoria;
import com.ifpb.edu.cursomc.repositories.CategoriaRepository;
import com.ifpb.edu.cursomc.services.exceptions.DataIntegretyException;
import com.ifpb.edu.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired //injeção de dependencia spring
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
	
	public Categoria insert (Categoria obj){
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegretyException("Não é possível excluir uma categoria que possui produtos!");
		}
	}
}
