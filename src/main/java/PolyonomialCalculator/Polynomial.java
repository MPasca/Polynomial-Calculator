package PolyonomialCalculator;

import java.util.*;

public class Polynomial extends Monomial {
    private int rank;
    private List<Monomial> monomials = new ArrayList<>();
    //private HashMap<Integer, PolyonomialCalculator.Monomial> monomials = new HashMap<Integer, PolyonomialCalculator.Monomial>();    // the polynomial can be written as a sum of monomials
                                                                                 // so each monomial can be kept in a hashmap, where the index is the rank of the coeficient

    Operations operation = new Operations();

    public Polynomial(){
        this.rank = 0;
        monomials.add(new Monomial());
    }

    public Polynomial(List<Monomial> monomials, int rank){
        this.monomials = monomials;
        this.rank = rank;
    }

    // -------------------- PolyonomialCalculator.Operations -------------------- \\

    public Polynomial add(Polynomial toAdd){
        return operation.addition(this, toAdd);
    }

    public Polynomial sub(Polynomial toSubtract){
        return operation.subtraction(this, toSubtract);
    }

    public Polynomial mul(Polynomial toMultiply){
        return operation.multiplication(this, toMultiply);
    }

    public Polynomial div(Polynomial toDivide){
        return operation.division(this, toDivide);
    }

    public Polynomial deriv(){
        return operation.derivative(this);
    }

    public Polynomial integ(){
        return operation.integration(this);
    }

    // ---------------------------------------------------- \\

    // -------------------- Getters & Setters -------------------- \\

    public int getRank() {
        return rank;
    }

    public List<Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(List<Monomial> monomials) {
        this.monomials = monomials;
    }

    // ----------------------------------------------------------- \\

    protected Monomial getMaxMonomial(){
        Monomial maxMonomial = new Monomial(0, 0);
        for(Monomial entry: monomials){
            if(maxMonomial.getRank() < entry.getRank()){
                maxMonomial = entry;
            }
        }
        return maxMonomial;
    }
/*
    protected int getMaxRank(){
        int maxRank = 0;
        for(PolyonomialCalculator.Monomial entry: monomials){
            if(maxRank < entry.getRank() && entry.getCoef() != 0){
                maxRank = entry.getRank();
            }
        }
        return maxRank;
    }

 */

    @Override
    public String toString(){
        String result = "";
        for(Monomial entry : monomials){
            if(entry.getCoef() < 0){
                result += entry.getCoef() + "*x^" + entry.getRank();
            }else if(entry.getCoef() > 0){
                result += "+" + entry.getCoef() + "*x^" + entry.getRank();
            }
        }

        return result;
    }
}
