public class FineCalculator {
    private java.math.BigDecimal dailyRate;

    public FineCalculator(java.math.BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public java.math.BigDecimal calculate(Loan loan, java.time.LocalDate currentDate) {
        int daysOverdue = loan.getDaysOverdue(currentDate);
        if (daysOverdue > 0) {
            return dailyRate.multiply(new java.math.BigDecimal(daysOverdue));
        }
        return java.math.BigDecimal.ZERO;
    }
}