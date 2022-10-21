package in.tp.wfd.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import in.tp.wfd.entity.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
