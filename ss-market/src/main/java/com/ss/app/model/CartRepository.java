package com.ss.app.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Cart;

@Service
public interface CartRepository extends CrudRepository<Cart, Long> {

	List<Cart> findByMemberid(String memberid);
	
	Cart findByMemberidAndProdCode(String memberid, String prodCode);
	
	@Query(value = "delete from t_cart where prodCode=:code and memberid=:memberId ", nativeQuery = true)
	void removeCart(String code, String memberId);
	
	
}
