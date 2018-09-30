package com.xulong.amazingsite.repository;

import com.xulong.amazingsite.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BannerRepository
 *
 * @author xulong
 * @date 2018/9/18
 */
@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
}
