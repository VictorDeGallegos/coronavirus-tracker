package io.victordegallegos.coronavirustracker.models;

public class LocationStats {

  private String state;
  private String country;
  private int latestTotalCases;
  private int diffFromPrevDay;
  private int latestTotalCasesRecuperados;
  private int latestTotalCasesMuertes;

  public int getDiffFromPrevDay() {
    return diffFromPrevDay;
  }

  public void setDiffFromPrevDay(int diffFromPrevDay) {
    this.diffFromPrevDay = diffFromPrevDay;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public int getLatestTotalCases() {
    return latestTotalCases;
  }

  public void setLatestTotalCases(int latestTotalCases) {
    this.latestTotalCases = latestTotalCases;
  }

  public int getLatestTotalCasesRecuperados() {
    return latestTotalCasesRecuperados;
  }

  public void setLatestTotalCasesRecuperados(int latestTotalCasesRecuperados) {
    this.latestTotalCasesRecuperados = latestTotalCasesRecuperados;
  }

  @Override
  public String toString() {
    return "LocationStats{" +
        "state='" + state + '\'' +
        ", country='" + country + '\'' +
        ", latestTotalCases=" + latestTotalCases +
        ", latestTotalCasesRecuperados=" + latestTotalCasesRecuperados +
        ", latestTotalCasesMuertes=" + latestTotalCasesMuertes +
        '}';
  }
}