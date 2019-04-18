public class Student {
  private double LAB_WEIGHT = .15; //constants storing weight
  private double PROJ_WEIGHT = .15;
  private double EXAM_WEIGHT = .3;
  private double ZY_WEIGHT = .1;
  private double FINAL_WEIGHT = .3;

  private String firstName, lastName, wid;
  private double labTotal, projTotal, examTotal, zyTotal, finalScore, totalPoints;
  private double percentage;

  public Student()
  {
    firstName = "NA";
    lastName = "NA";
    wid = "NO WID";
    this.labTotal = 0;
    this.projTotal = 0;
    this.examTotal = 0;
    this.zyTotal = 0;
    this.finalScore = 0;
  }

  public Student(String firstName, String lastName, String wid, double labTotal, double projTotal,
                  double examTotal, double zyTotal, double finalScore)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.wid = wid;
    this.labTotal = labTotal;
    this.projTotal = projTotal;
    this.examTotal = examTotal;
    this.zyTotal = zyTotal;
    this.finalScore = finalScore;
    this.totalPoints = this.labTotal + this.projTotal + this.examTotal + this.zyTotal;
  }

  /** calcOverallPercent
   * Calculates student's percentage for the class and stores in class field
   * @param allPossible the student object containing max possible points
   */

  public void calcOverallPercent(Student allPossible)
  {
    //adjusted totals for max points possible
    double labAdjTtl = allPossible.labTotal * LAB_WEIGHT; //breaking adjusted totals up to make the sum statement easier
    double projAdjTtl = allPossible.projTotal * PROJ_WEIGHT;
    double examAdjTtl = allPossible.examTotal * EXAM_WEIGHT;
    double zyAdjTtl = allPossible.labTotal * ZY_WEIGHT;
    double finalAdjTtl = allPossible.labTotal * FINAL_WEIGHT;
    //sum of max possible adjusted
    double adjTtl = labAdjTtl + projAdjTtl + examAdjTtl + zyAdjTtl + finalAdjTtl;
    //adjusted totals for student's scores
    double labAdj = (this.labTotal/allPossible.labTotal) * labAdjTtl;
    double projAdj = (this.projTotal/allPossible.projTotal) * projAdjTtl;
    double examAdj = (this.examTotal/allPossible.examTotal) * examAdjTtl;
    double zyAdj = (this.labTotal/allPossible.zyTotal) * zyAdjTtl;
    double finalAdj = (this.finalScore/allPossible.finalScore) * finalAdjTtl;
    //final percent, stored in object's field, not returned
    this.percentage = ((labAdj + projAdj + examAdj + zyAdj + finalAdj)/adjTtl) * 100; //formula as described on project outline
  }

  /** getFinalGrade
   * Looks at overall percentage then figures out what letter grade that corresponds to
   * @param pct the student's percentage in the class
   * @return String that is the letter grade
   */

  public String getFinalGrade(double pct) {
    if(pct >= 89.5)
    {
      return "A";
    }
    else if(pct < 89.5 && pct >= 79.5)
    {
      return "B";
    }
    else if(pct < 79.5 && pct >= 69.5)
    {
      return "C";
    }
    else if(pct < 69.5 && pct > 58.5)
    {
      return "D";
    }
    else //no other choice
    {
      return "F";
    }
  }

  /** toString
   * Summarizes the student object's attributes
   * @return a nice summary of the object
   */

  public String toString()
  {
    StringBuilder out = new StringBuilder();

    out.append(String.format("\nStudent Name: %s,%s\n", this.lastName, this.firstName));
    out.append(String.format("WID: %s\n", this.wid));
    out.append(String.format("Overall pct: %.2f%%\n", this.percentage)); //percentage is stored in the object
    out.append(String.format("Final Grade: %s\n", getFinalGrade(this.percentage))); //pass percentage into final grade

    return out.toString();
  }
}
