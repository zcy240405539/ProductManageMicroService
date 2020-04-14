package com.framework.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.framework.jpa.ProductsEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, String>  {
	 @Query("SELECT p FROM ProductsEntity p WHERE p.pid=?1")
	 public List<ProductsEntity> findByPid(String pid);
	 @Query("SELECT p FROM ProductsEntity p WHERE p.category=?1")
	 public List<ProductsEntity> findByCategory(String category);
	 
}
