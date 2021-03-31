package jpabook.jpashop.repository;

import jpabook.jpashop.entity.Item;
import jpabook.jpashop.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("SELECT m FROM Item m", Item.class).getResultList();
    }

    public List<Item> findByName(String name) {
        return em.createQuery("SELECT m FROM Member m WHERE m.name = :name", Item.class)
                .setParameter("name", name)
                .getResultList();
    }



}
