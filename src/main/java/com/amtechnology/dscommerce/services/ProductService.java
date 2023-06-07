package com.amtechnology.dscommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amtechnology.dscommerce.dto.ProductDTO;
import com.amtechnology.dscommerce.entities.Product;
import com.amtechnology.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> result = repository.findById(id);
		Product product = result.get();
		ProductDTO dto = new ProductDTO(product.getId(), product.getName(), product.getDescription(),
				product.getPrice(), product.getImgUrl());
		return dto;
		/*
		 * Product product = repository.findById(id).get(); return new
		 * ProductDTO(product.getId(), product.getName(), product.getDescription(),
		 * product.getPrice(), product.getImgUrl());
		 */
	}

	@Transactional(readOnly = true)
	// consulta paginada
	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> result = repository.findAll(pageable);
		return result.map(product -> new ProductDTO(product.getId(), product.getName(), product.getDescription(),
				product.getPrice(), product.getImgUrl()));
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {

		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);

		return new ProductDTO(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(),
				entity.getImgUrl());
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {

		Product entity = repository.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);

		return new ProductDTO(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(),
				entity.getImgUrl());
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);

	}

	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());
	}
}
