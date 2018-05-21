package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    StatisticRepository statisticRepository;

    //@Override
    public List<Statistic> show_all_statistic() {
        return statisticRepository.findAll();
    }

//    public void increment_find_all_counter(){
//        int a;
//    }
}
