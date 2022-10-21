package in.tp.wfd.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.tp.wfd.entity.Product;
import in.tp.wfd.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Flux<? extends Product> getAll() {
		return productRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<Product> getById(final String id) {
		return productRepository.findById(id);
	}

	public Mono<?> update(final String id, final Product product) {
		return productRepository.save(product);
	}

	public Mono<?> save(final Product product) {
		return productRepository.save(product);
	}

	public Mono<?> delete(final String id) {
		final Mono<?> dbProduct = getById(id);
		if (Objects.isNull(dbProduct)) {
			return Mono.empty();
		}
		return getById(id).switchIfEmpty(Mono.empty())
				.filter(Objects::nonNull)
				.flatMap(
						productToBeDeleted -> productRepository
								.delete(productToBeDeleted
				)
				.then(Mono.just(productToBeDeleted)));
	}
}
