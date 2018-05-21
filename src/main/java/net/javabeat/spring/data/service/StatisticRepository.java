package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic,Long> {
}
