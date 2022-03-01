package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Descuento;
import com.example.demo.repository.DescuentoRepository;
@Service
public class DescuentoServiceDB implements DescuentoService{

	@Autowired
	private DescuentoRepository repositorioDescuento;
	@Override
	public Descuento addDescuento(Descuento d) {
		return repositorioDescuento.save(d);
	}

	@Override
	public Descuento findById(Integer id) {
		return repositorioDescuento.findById(id).orElse(null);
	}

	@Override
	public List<Descuento> findAll() {
		return repositorioDescuento.findAll();
	}
	public Descuento findByCodigo(String codigo) {
		return repositorioDescuento.findDescuentoByCodigo(codigo);
	}
	public Descuento edit(Descuento d) {
		return repositorioDescuento.save(d);
	}

}
