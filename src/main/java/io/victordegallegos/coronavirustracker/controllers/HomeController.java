package io.victordegallegos.coronavirustracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.victordegallegos.coronavirustracker.models.LocationStats;
import io.victordegallegos.coronavirustracker.service.CoronaVirusDataService;
import io.victordegallegos.coronavirustracker.service.CoronaVirusDataServiceMuertes;
import io.victordegallegos.coronavirustracker.service.CoronaVirusDataServiceRecuperados;

@Controller
public class HomeController {

  @Autowired
  CoronaVirusDataService coronaVirusDataService;
  @Autowired
  CoronaVirusDataServiceRecuperados coronaVirusDataServiceRecuperados;
  @Autowired
  CoronaVirusDataServiceMuertes coronaVirusDataServiceMuertes;

  @GetMapping("/")
  public String home(Model model) {
    List<LocationStats> allStats = coronaVirusDataService.getAllStats();
    List<LocationStats> allStatsRecuperados = coronaVirusDataServiceRecuperados.getAllStats();
    List<LocationStats> allStatsMuertes = coronaVirusDataServiceMuertes.getAllStats();
    int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
    int totalReportedCasesMuertes = allStatsMuertes.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
    int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
    int totalReportedCasesRecuperados = allStatsRecuperados.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
    model.addAttribute("locationStats", allStats);
    model.addAttribute("totalReportedCases", totalReportedCases);
    model.addAttribute("totalReportedCasesMuertes", totalReportedCasesMuertes);
    model.addAttribute("totalNewCases", totalNewCases);
    model.addAttribute("totalReportedCasesRecuperados", totalReportedCasesRecuperados);

    return "home";
  }
}
