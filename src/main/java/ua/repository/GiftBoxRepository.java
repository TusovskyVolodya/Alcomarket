package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.GiftBox;

public interface GiftBoxRepository extends JpaRepository<GiftBox, Integer>, JpaSpecificationExecutor<GiftBox> {

	GiftBox findByGiftBox(String giftBox);
}

