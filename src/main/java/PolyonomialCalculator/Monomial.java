public class Monomial {
    private double coef;
    private int rank;
    private boolean isBrowsed;   // this is a measure to verify there are no monomials left behind

    public Monomial(){
        this.coef = 0;
        this.rank = 0;
        this.isBrowsed = false;
    }

    public Monomial(double coef, int rank) {
            this.isBrowsed = false;
            this.coef = coef;
            this.rank = rank;
    }

    // -------------------- Operations -------------------- \\

    protected Monomial add(Monomial toAdd){
        return new Monomial(this.coef + toAdd.getCoef(), this.rank);
    }

    protected Monomial sub(Monomial toSub){
        return new Monomial(this.coef - toSub.getCoef(), this.rank);
    }

    protected Monomial mul(Monomial toMul){
        return new Monomial(this.coef * toMul.getCoef(), this.rank + toMul.getRank());
    }

    protected Monomial div(Monomial toDiv){
        return new Monomial(this.coef / toDiv.getCoef(), this.rank - toDiv.getRank());
    }

    protected Monomial deriv(){
        return new Monomial(this.coef * this.rank, this.rank-1);
    }

    protected Monomial integr(){
        return new Monomial(this.coef / (this.rank + 1), this.rank+1);
    }

    // -------------------- Getters & Setters -------------------- \\

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef){
        this.coef = coef;
    }

    public int getRank() {
        return rank;
    }

    public boolean isBrowsed() {
        return isBrowsed;
    }

    public void setBrowsed(boolean browsed) {
        this.isBrowsed = browsed;
    }

}
