package io.victordegallegos.coronavirustracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.victordegallegos.coronavirustracker.models.LocationStats;
import io.victordegallegos.coronavirustracker.service.CoronaVirusDataService;
import io.victordegallegos.coronavirustracker.service.CoronaVirusDataServiceRecuperados;

@Controller
public class HomeController {

  @Autowired
  CoronaVirusDataService coronaVirusDataService;
  CoronaVirusDataServiceRecuperados coronaVirusDataServiceRecuperados;

  @GetMapping("/")
  public String home(Model model) {
    List<LocationStats> allStats = coronaVirusDataService.getAllStats();
    int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
    int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
    int totalReportedCasesRecuperados = allStats.stream().mapToInt(stat -> stat.getLatestTotalCasesRecuperados()).sum();
    model.addAttribute("locationStats", allStats);
    model.addAttribute("totalReportedCases", totalReportedCases);
    model.addAttribute("totalNewCases", totalNewCases);
    model.addAttribute("totalReportedCasesRecuperados", totalReportedCasesRecuperados);

    return "home";
  }
}
