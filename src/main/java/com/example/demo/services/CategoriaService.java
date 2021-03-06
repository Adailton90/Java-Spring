package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public java.util.Optional<Categoria> buscar(Integer id) {
		java.util.Optional<Categoria> obj = repo.findById(id);
		
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id
					+ "Tipo: "+ Categoria.class.getName());
		}
		return obj;
	}
}
