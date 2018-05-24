package net.javabeat.spring.data.web;

import net.javabeat.spring.data.domain.Statistic;
import net.javabeat.spring.data.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class StatisticController {
    @Autowired
    StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService){
        this.statisticService = statisticService;
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET,produces = "application/json")
    public List<Statistic> getStatistic(){
        return statisticService.show_all_statistic();
    }
}
