package com.change.projects.book.repo;

import com.change.projects.book.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    @Query(value = "select count(*)>0 from cart where username = :username and productid = :prodid", nativeQuery = true)
    public int ifExists(@Param("username") String username ,@Param("prodid") int productid);

    @Modifying(clearAutomatically = true)
    @Query(value = "update cart set qty = qty+ :q where username = :username and productid = :prodid", nativeQuery = true)
    public void update(@Param("username") String username ,@Param("prodid") int productid, @Param("q") int q);

    @Query(value = "select * from cart where username = :username",nativeQuery = true)
    public List<Cart> getCart(@Param("username") String username);

    @Query(value = "select sum(price) from cart where username = :username" , nativeQuery = true)
    public double getTotal(@Param("username") String username);


    @Query(value = "select count(*) from cart where username= :username", nativeQuery = true)
    public int getCartCount(@Param("username") String username);

    @Modifying(clearAutomatically = true)
    @Query(value = "delete from cart where username = :username",nativeQuery = true)
    public void clearCart(@Param("username") String username);
}
