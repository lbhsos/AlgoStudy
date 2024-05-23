class Solution {
  Map<String, List<TrxInfo>> trxHistories;
  List<String> invalids;

  public List<String> invalidTransactions(String[] transactions) {
// name, time (in minutes), amount, and city
    trxHistories = new HashMap<>();
    invalids = new ArrayList<>();
    for (String trx : transactions) {
      checkIfInvalid(trx);
    }

    for (String name : trxHistories.keySet()) {
//      System.out.println("name: %s".formatted(name));

      for (TrxInfo trxInfo : trxHistories.get(name)) {
        if (!trxInfo.isValid()) {
          invalids.add(trxInfo.getTrx());
        }
      }
//      System.out.println(trxHistories.get(name));
    }
    return invalids;
  }

  private void checkIfInvalid(String trx) {
    String[] splited = trx.split(",");
    String name = splited[0];
    Integer min = Integer.parseInt(splited[1]);
    Integer amount = Integer.parseInt(splited[2]);
    String city = splited[3];

    TrxInfo currentTrx = new TrxInfo(min, city, trx);
    if (!trxHistories.containsKey(name)) {
      trxHistories.put(name, new ArrayList<>());
    }
    List<TrxInfo> trxInfos = trxHistories.get(name);
    // 과거꺼가 같이 걸리는 경우가 있음.. 밑에까지 다봐야함.
    List<TrxInfo> newTrx = new ArrayList<>();
    for (TrxInfo pastTrx : trxInfos) {
      if (!pastTrx.isValid(currentTrx)) {
        pastTrx.setValid(false);
        currentTrx.setValid(false);
      }
      newTrx.add(pastTrx);
    }

    if (amount > 1000) {
      currentTrx.setValid(false);
    }
    newTrx.add(currentTrx);
    trxHistories.put(name, newTrx);
  }

  class TrxInfo {
    Integer min;
    String city;
    String trx;
    boolean valid = true;

    public TrxInfo(Integer min, String city, String trx) {
      this.min = min;
      this.city = city;
      this.trx = trx;
    }

    public Integer getMin() {
      return min;
    }

    public String getCity() {
      return city;
    }

    public String getTrx() {
      return trx;
    }

    public boolean isValid() {
      return valid;
    }

    public boolean isValid(TrxInfo otherTrx) {
      if (Math.abs(this.getMin() - otherTrx.getMin()) <= 60 && !this.getCity()
          .equals(otherTrx.getCity())) {
        return false;
      }
      return true;
    }

    public void setValid(boolean valid) {
      this.valid = valid;
    }

    @Override
    public String toString() {
      return "TrxInfo{" +
          "trx='" + trx + '\'' +
          ", valid=" + valid +
          '}';
    }
  }
}